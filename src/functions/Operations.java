package functions;
import java.util.ArrayList;
public class Operations {
	private ArrayList<String> operandos;
	private ArrayList<String> operadores;
	public StringBuilder display;
	public StringBuilder resultado;
	private boolean finCalculo;
	public StringBuilder memoria;
	private boolean coma;
	private boolean memoriaDisponible;
	public Operations() {
		operandos = new ArrayList<>();
		operadores = new ArrayList<>();
		display = new StringBuilder();
		resultado = new StringBuilder();
		memoria = new StringBuilder();
		memoriaDisponible = true;
		finCalculo = false;
		coma = true;
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
	

	public void guardaMemoria() {
		if(this.memoriaDisponible) {
			this.memoria.append(this.resultado.toString());
			this.memoriaDisponible=false;
		}
	}
	public void agregaMemo() {
		this.resultado.append(this.memoria.toString());
		this.display.append(this.memoria.toString());
	}
	public void borraMemo() {
		if(!memoriaDisponible) {
			this.memoria.setLength(0);
			this.memoriaDisponible=true;
		}
	}
	private boolean adicionPosible(String valor){
		if (this.display.length()==0 && operador(valor))
			return false;
		else if (valor==".") {
			if(this.resultado.length()==0)
				return false;
			else if (!coma)
				return false;
			else if(this.resultado.charAt(this.resultado.length()-1)=='.')
				return false;
			else 
				return true;
		}
		else if(!operador(valor))
				return true;
		else if ((this.display.length()>0)&&(operador(valor))) {
			if(operador(Character.toString(this.display.charAt(this.display.length()-1)))||
					this.display.charAt(this.display.length()-1)=='.')
				return false;
			else
				return true;
		}
		else
			return true;
	}
	
	public boolean addValor(String valor) {
		if(finCalculo) 					//vacia todo si se realizó alguna operación
			vaciarTodo();
		if(adicionPosible(valor)) {
			if (valor==".")
				coma=false;
			if (!operador(valor)) 
				this.resultado.append(valor);
			else {			
				operadores.add(valor);
				operandos.add(this.resultado.toString());
				this.resultado.setLength(0);
				coma=true;
			}
			this.display.append(valor);	
			return true;
		}
		else
			return false;
	}

	private boolean operador(String valor) {
		if (valor.equals("+")||valor.equals("-")||valor.equals("*")||valor.equals("/")) 
			return true;
		else 
			return false;
	}
	public void deshacer() {
		if(this.finCalculo) {
			if(operandos.size()>=2) {
				operandos.remove(operandos.get(operandos.size()-1));
				operadores.remove(operadores.get(operadores.size()-1));
				this.display.setLength(0);
				this.display.append(operandos.get(0));
				for (int i = 0; i < operadores.size(); i++) {
					this.display.append(operadores.get(i));
					this.display.append(operandos.get(i+1));
				}
				calcular();
			}
			if (operandos.size()==1) {
				this.resultado.setLength(0);
				this.resultado.append(operandos.get(0));
			}
		}
			
	}
	private boolean calculoPosible() {
		if (operadores.size()==0)
			return false;
		else if(operador(Character.toString(this.display.charAt(this.display.length()-1))))
			return false;
		else if(this.display.charAt(this.display.length()-1)=='.')
			return false;
		else
			return true;
	}
	double operando1, operando2;
	public boolean calcular() {
		if(calculoPosible()) {
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
			nroEntero(operando1);
			this.finCalculo=true;
			return true;
		}
		else
			return false;
	}
	int entero;
	private void nroEntero(double operando) {
		if(this.resultado.charAt(this.resultado.length()-1)==('0') &&	//En caso de no tener decimales convierte a entero
			this.resultado.charAt(this.resultado.length()-2)==('.')) {
			entero=(int)operando;									
			this.resultado.setLength(0);
			this.resultado.append(Integer.toString(entero));
		}
	}
}