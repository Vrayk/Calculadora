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
	private boolean bloqOperador;
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
		bloqOperador=true;
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
		bTn1.setBounds(10, 266, 55, 40);
		frame.getContentPane().add(bTn1);
		bTn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.addValor("1");
				visor();
				bloqOperador=false;
			}
		});
		
		JButton bTn2 = new JButton("2");
		bTn2.setBounds(70, 266, 55, 40);
		frame.getContentPane().add(bTn2);
		bTn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.addValor("2");
				visor();
				bloqOperador=false;
			}
		});
		
		JButton bTn3 = new JButton("3");
		bTn3.setBounds(130, 266, 55, 40);
		frame.getContentPane().add(bTn3);
		bTn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.addValor("3");
				visor();
				bloqOperador=false;
			}
		});
		
		JButton bTn4 = new JButton("4");
		bTn4.setBounds(10, 215, 55, 40);
		frame.getContentPane().add(bTn4);
		bTn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.addValor("4");
				visor();
				bloqOperador=false;
			}
		});
		
		JButton bTn5 = new JButton("5");
		bTn5.setBounds(70, 215, 55, 40);
		frame.getContentPane().add(bTn5);
		bTn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.addValor("5");
				visor();
				bloqOperador=false;
			}
		});
		
		JButton bTn6 = new JButton("6");
		bTn6.setBounds(130, 215, 55, 40);
		frame.getContentPane().add(bTn6);
		bTn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.addValor("6");
				visor();
				bloqOperador=false;
			}
		});
		
		JButton bTn7 = new JButton("7");
		bTn7.setBounds(10, 164, 55, 40);
		frame.getContentPane().add(bTn7);
		bTn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.addValor("7");
				visor();
				bloqOperador=false;
			}
		});
		
		JButton bTn8 = new JButton("8");
		bTn8.setBounds(70, 164, 55, 40);
		frame.getContentPane().add(bTn8);
		bTn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.addValor("8");
				visor();
				bloqOperador=false;
			}
		});
		
		JButton bTn9 = new JButton("9");
		bTn9.setBounds(130, 164, 55, 40);
		frame.getContentPane().add(bTn9);
		bTn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.addValor("9");
				visor();
				bloqOperador=false;
			}
		});
		
		JButton bTn0 = new JButton("0");
		bTn0.setBounds(10, 317, 55, 40);
		frame.getContentPane().add(bTn0);
		bTn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.addValor("0");
				visor();
				bloqOperador=false;
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
				bloqOperador=false;
			}
		});
		
		JButton bTnC = new JButton("C");
		bTnC.setBounds(70, 62, 55, 40);
		frame.getContentPane().add(bTnC);
		bTnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resultado.setText("0");
				funciones.vaciar();
			}
		});
		
		JButton  bTnSuma = new JButton("+");
		bTnSuma.setBounds(190, 266, 55, 91);
		frame.getContentPane().add(bTnSuma);
		bTnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!bloqOperador)
					funciones.addValor("+");
				visor();
				resultado.setText("0");
				bloqOperador=true;
			}
		});
		
		JButton bTnResta = new JButton("-");
		bTnResta.setBounds(190, 215, 55, 40);
		frame.getContentPane().add(bTnResta);
		if(!bloqOperador) {
		bTnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!bloqOperador)
					funciones.addValor("-");
				visor();
				resultado.setText("0");
				bloqOperador=true;
			}
		});
		}
		JButton bTnMult = new JButton("*");
		bTnMult.setBounds(190, 164, 55, 40);
		frame.getContentPane().add(bTnMult);
		if(!bloqOperador) {
		bTnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!bloqOperador)
					funciones.addValor("*");
				visor();
				resultado.setText("0");
				bloqOperador=true;
			}
		});
		}
		JButton bTnDiv = new JButton("/");
		bTnDiv.setBounds(190, 113, 55, 40);
		frame.getContentPane().add(bTnDiv);
		bTnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!bloqOperador)
					funciones.addValor("/");
				visor();
				resultado.setText("0");
				bloqOperador=true;
			}
		});

		JButton bTnIgual = new JButton("=");
		bTnIgual.setBounds(130, 317, 55, 40);
		frame.getContentPane().add(bTnIgual);
		bTnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.calcular();
				visor();
				bloqOperador=true;
			}
		});
		
		JButton bTnPunto = new JButton(".");
		bTnPunto.setBounds(70, 317, 55, 40);
		frame.getContentPane().add(bTnPunto);
		bTnPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funciones.addValor(".");
				visor();
				bloqOperador=false;
			}
		});
		JButton btnMR = new JButton("MR");
		btnMR.setBounds(10, 113, 55, 40);
		frame.getContentPane().add(btnMR);
		
		JButton btnMmas = new JButton("M+");
		btnMmas.setBounds(70, 113, 55, 40);
		frame.getContentPane().add(btnMmas);
		
		JButton btnMmenos= new JButton("M-");
		btnMmenos.setBounds(130, 113, 55, 40);
		frame.getContentPane().add(btnMmenos);
		
		JButton btnDeshacer = new JButton("Deshacer");
		btnDeshacer.setBounds(130, 62, 115, 40);
		frame.getContentPane().add(btnDeshacer);
		
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
	private void visor() {
		display.setText(funciones.display.toString());
		resultado.setText(funciones.resultado.toString());
	}
}
