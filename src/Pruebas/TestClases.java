package Pruebas;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import functions.*;
class TestClases {
	
	@Test
	void primerAdicion() {
		Operations funciones = new Operations();
		funciones.addValor("+");						//No se puede agregar operadores ni comas
		assertEquals(false, funciones.addValor("."));	//como primer operando, por lo que el display
		assertEquals(0, funciones.display.length());	//esta vacio.
	}
	@Test
	void operadorYcoma() {
		Operations funciones = new Operations();
		funciones.addValor("1");
		funciones.addValor(".");						//No es posible concatenar operadores despues
		assertEquals(false, funciones.addValor("."));	//de una coma o si ya se agrego una previamente,
		assertEquals(false, funciones.addValor("+"));	//debe esperar un operando
		funciones.addValor("1");
		assertEquals(true, funciones.addValor("+"));
	}
	
	@Test
	void memoria(){
		Operations funciones = new Operations();
		assertEquals(false, funciones.guardaMemoria());	//No permite guardar memoria en caso de estar
		funciones.addValor("1");						//vacio.
		assertEquals(true, funciones.guardaMemoria());
	}
	
}
