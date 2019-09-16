package screen;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import functions.Operations;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
public class Window {
	private JFrame frame;
	private JLabel display;
	private JLabel resultado;
	Operations funciones;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
		funciones = new Operations();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 51, 51));
		frame.setBounds(100, 100, 270, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton bTn1 = new JButton("1");
		bTn1.setBounds(10, 269, 55, 40);
		frame.getContentPane().add(bTn1);
		numeros(bTn1, "1");
		
		JButton bTn2 = new JButton("2");
		bTn2.setBounds(70, 269, 55, 40);
		frame.getContentPane().add(bTn2);
		numeros(bTn2,"2");
		
		JButton bTn3 = new JButton("3");
		bTn3.setBounds(130, 269, 55, 40);
		frame.getContentPane().add(bTn3);
		numeros(bTn3,"3");
		
		JButton bTn4 = new JButton("4");
		bTn4.setBounds(10, 215, 55, 40);
		frame.getContentPane().add(bTn4);
		numeros(bTn4,"4");
		
		JButton bTn5 = new JButton("5");
		bTn5.setBounds(70, 215, 55, 40);
		frame.getContentPane().add(bTn5);
		numeros(bTn5,"5");
		
		JButton bTn6 = new JButton("6");
		bTn6.setBounds(130, 215, 55, 40);
		frame.getContentPane().add(bTn6);
		numeros(bTn6,"6");
		
		JButton bTn7 = new JButton("7");
		bTn7.setBounds(10, 164, 55, 40);
		frame.getContentPane().add(bTn7);
		numeros(bTn7,"7");
		
		JButton bTn8 = new JButton("8");
		bTn8.setBounds(70, 164, 55, 40);
		frame.getContentPane().add(bTn8);
		numeros(bTn8,"8");
		
		JButton bTn9 = new JButton("9");
		bTn9.setBounds(130, 164, 55, 40);
		frame.getContentPane().add(bTn9);
		numeros(bTn9,"9");
		
		JButton bTn0 = new JButton("0");
		bTn0.setBounds(10, 320, 55, 40);
		frame.getContentPane().add(bTn0);
		numeros(bTn0,"0");
		
		JButton  bTnSuma = new JButton("+");
		bTnSuma.setBounds(190, 269, 55, 91);
		frame.getContentPane().add(bTnSuma);
		operadores(bTnSuma, "+");
		
		JButton bTnResta = new JButton("-");
		bTnResta.setBounds(190, 215, 55, 40);
		frame.getContentPane().add(bTnResta);
		operadores(bTnResta, "-");
		
		JButton bTnMult = new JButton("*");
		bTnMult.setBounds(190, 164, 55, 40);
		frame.getContentPane().add(bTnMult);
		operadores(bTnMult, "*");

		JButton bTnDiv = new JButton("/");
		bTnDiv.setBounds(190, 113, 55, 40);
		frame.getContentPane().add(bTnDiv);
		operadores(bTnDiv, "/");

		JButton bTnIgual = new JButton("=");
		bTnIgual.setBounds(130, 320, 55, 40);
		frame.getContentPane().add(bTnIgual);
		bTnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!funciones.calcular())
					resultado.setText("0");
				else
					visor();
			}
		});
		
		JButton bTnAC = new JButton("AC");
		bTnAC.setBounds(10, 62, 55, 40);
		frame.getContentPane().add(bTnAC);
		bTnAC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				display.setText("0");
				resultado.setText("0");
				funciones.vaciarTodo();
			}
		});
		
		JButton bTnC = new JButton("C");
		bTnC.setBounds(70, 62, 55, 40);
		frame.getContentPane().add(bTnC);
		bTnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.vaciar();
				visor();
				resultado.setText("0");
			}
		});
		
		JButton bTnPunto = new JButton(".");
		bTnPunto.setBounds(70, 320, 55, 40);
		frame.getContentPane().add(bTnPunto);
		bTnPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(funciones.addValor(".")) {
					visor();
					resultado.setText("0");
				}
				else
					resultado.setText("0");	
			}
		});
		
		JButton bTnDeshacer = new JButton("Deshacer");
		bTnDeshacer.setBounds(130, 62, 115, 40);
		frame.getContentPane().add(bTnDeshacer);
		bTnDeshacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.deshacer();
				visor();
			}
		});
		
		JButton bTnMR = new JButton("MR");
		bTnMR.setBounds(10, 113, 55, 40);
		frame.getContentPane().add(bTnMR);
		bTnMR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.guardaMemoria();
			}
		});
		JButton bTnMAdd = new JButton("M+");
		bTnMAdd.setBounds(70, 113, 55, 40);
		frame.getContentPane().add(bTnMAdd);
		bTnMAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.agregaMemo();
				visor();
			}
		});
		JButton bTnMRemove = new JButton("M-");
		bTnMRemove.setBounds(130, 113, 55, 40);
		frame.getContentPane().add(bTnMRemove);
		bTnMRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.borraMemo();
			}
		});
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 11, 235, 40);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		display = new JLabel("0");
		display.setFont(new Font("Arial", Font.BOLD, 13));
		display.setForeground(new Color(255, 255, 255));
		display.setBackground(new Color(255, 255, 255));
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setBounds(10, 0, 215, 14);
		panel.add(display);
		
		resultado = new JLabel("0");
		resultado.setFont(new Font("Arial", Font.BOLD, 13));
		resultado.setBackground(new Color(255, 255, 255));
		resultado.setForeground(new Color(255, 255, 255));
		resultado.setHorizontalAlignment(SwingConstants.RIGHT);
		resultado.setBounds(10, 26, 215, 14);
		panel.add(resultado);	
	}
	
	public void numeros(JButton num, String numero) {
		num.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.addValor(numero);
				visor();
			}
		});
	}
	public void operadores(JButton op, String operador) {
		op.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(funciones.addValor(operador)) {
					visor();
					resultado.setText("0");
				}
				else
					resultado.setText("0");
			}
		});
	}
	private void visor() {
		display.setText(funciones.display.toString());
		resultado.setText(funciones.resultado.toString());
	}
}