package Pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;
import functions.*;
class TestClases {
	
	@Test
	void operacionBasica() {
		Operations funciones = new Operations();
		funciones.addValor("2");
		funciones.addValor("2");
		funciones.addValor("+");
		funciones.addValor("5");
		funciones.addValor("7");
		funciones.calcular();
		assertEquals("79", funciones.resultado.toString());
	}
	
	@Test
	void multiplesOperaciones() {
		Operations funciones = new Operations();
		funciones.addValor("2");
		funciones.addValor("+");
		funciones.addValor("5");
		funciones.addValor("+");
		funciones.addValor("7");
		funciones.addValor("-");
		funciones.addValor("1");
		funciones.calcular();
		assertEquals("13", funciones.resultado.toString());
	}
	@Test
	void vaciar() {
		Operations funciones = new Operations();
		funciones.addValor("1");
		funciones.addValor("2");
		funciones.vaciar();
		assertEquals(0, funciones.resultado.length());
	}
	
	@Test
	void vaciarTodo() {
		Operations funciones = new Operations();
		funciones.addValor("1");
		funciones.addValor("+");
		funciones.addValor("2");
		funciones.vaciarTodo();
		assertEquals(0, funciones.display.length());
	}
	
	@Test
	void primerAdicion() {
		Operations funciones = new Operations();
		funciones.addValor("+");						//No se puede agregar operadores ni comas
		funciones.addValor("/");						//como primer operando, por lo que el display
		funciones.addValor(".");						//esta vacio.
		assertEquals(0, funciones.display.length());	
	}
	@Test
	void comas() {
		Operations funciones = new Operations();		
		funciones.addValor("1");						//No es posible concatenar mas de una coma
		funciones.addValor(".");						
		assertEquals(false, funciones.addValor("."));	
	}
	
	@Test
	void operadorAlFinal() {
		Operations funciones = new Operations();
		funciones.addValor("1");
		funciones.addValor("0");
		funciones.addValor("+");
		assertFalse(funciones.calcular());
	}
	
	@Test
	void comaAlFinal() {
		Operations funciones = new Operations();
		funciones.addValor("1");
		funciones.addValor("0");
		funciones.addValor("+");
		funciones.addValor("1");
		funciones.addValor(".");
		assertFalse(funciones.calcular());
	}
	
	@Test
	void memoriaVacia(){
		Operations funciones = new Operations();		//No permite guardar memoria en caso de estar
		assertEquals(false, funciones.guardaMemoria());	//vacio.
	}
	
	@Test
	void agregaMemoria() {
		Operations funciones = new Operations();
		funciones.addValor("1");
		funciones.addValor("2");
		funciones.guardaMemoria();
		funciones.addValor("+");
		funciones.agregaMemo();
		funciones.calcular();
		assertEquals("24", funciones.resultado.toString());
	}
	
	@Test
	void operandoYComa() {
		Operations funciones = new Operations();		
		funciones.addValor("1");						//No es posible concatenar operadores despues de
		funciones.addValor(".");						//de una coma.
		assertEquals(false, funciones.addValor("+"));
	}
	
	
}
