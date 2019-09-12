package functions;
import java.util.ArrayList;
public class Operations {
	private ArrayList<String> operandos;
	private ArrayList<String> operadores;
	public StringBuilder display;
	public StringBuilder resultado;
	private boolean finCalculo;
	private boolean primerValor;
	
	public Operations() {
		operandos = new ArrayList<>();
		operadores = new ArrayList<>();
		display = new StringBuilder();
		resultado = new StringBuilder();
		finCalculo = false;
	}
	
	public void vaciar() {
		this.display.delete(this.display.length()-this.resultado.length(), this.display.length());
		this.resultado.setLength(0);
	}
	
	public void vaciarTodo() {
		this.operandos.clear();
		this.operadores.clear();
		this.display.setLength(0);
		this.resultado.setLength(0);
		this.finCalculo=false;
	}
	
	public void addValor(String valor) {
		if(finCalculo) 					//vacia todo si se realizó alguna operación
			vaciarTodo();
		if (!operadores(valor)) {
			this.resultado.append(valor);
		}
		display.append(valor);
	}
	
	public boolean operadores(String valor) {
		if (valor==("+")||valor==("-")||valor==("*")||valor==("/")) {
			operandos.add(this.resultado.toString());
			operadores.add(valor);
			this.resultado.setLength(0);
			return true;
		}
		else
			return false;
	}
	
	double operando1,operando2;
	int aux;
	public void calcular() {
		if(operadores.size()>0) {
		operandos.add(this.resultado.toString());	//Agrega el último operando
		this.resultado.setLength(0);				
		operando1 = Double.parseDouble(operandos.get(0));
		for (int i = 0; i < operadores.size(); i++) {
			operando2 = Double.parseDouble(operandos.get(i+1));
			if(operadores.get(i)=="+")
				operando1 = operando1 + operando2;
			else if(operadores.get(i)=="-")
				operando1 = operando1 - operando2;
			else if(operadores.get(i)=="*")
				operando1 = operando1*operando2;
			else if(operadores.get(i)=="/")
				operando1 = operando1/operando2;
		}	
		
		this.resultado.append(Double.toString(operando1));
		if(this.resultado.charAt(this.resultado.length()-1)==('0') &&	//En caso de no tener decimales convierte a entero
		   this.resultado.charAt(this.resultado.length()-2)==('.')) {
			aux=(int)operando1;									
			this.resultado.setLength(0);
			this.resultado.append(Integer.toString(aux));
		}
		this.finCalculo=true;
		}
	}
}