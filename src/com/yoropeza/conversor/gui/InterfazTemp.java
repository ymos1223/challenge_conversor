package com.yoropeza.conversor.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.yoropeza.conversor.models.Temperatura;
import com.yoropeza.conversor.utils.ConversorTemperatura;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class InterfazTemp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel resultadoTemp;
	private String[] temperaturas= {"Celsius - °C","Fahrenheit - °F","Kelvin - °K" };
	private JComboBox<String> lista1;
	private JComboBox<String> lista2;
	private JTextField entradaDatos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazTemp window = new InterfazTemp();
					window.setVisible(true);
					window.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazTemp() {
		lista1= new JComboBox<String>();
		lista2= new JComboBox<String>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("CONVERSOR DE TEMPERATURAS");
		contentPane.setBackground(new Color(246, 97, 81));
		setBounds(100, 100, 785, 231);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblConversor = new JLabel("De:");
		lblConversor.setForeground(new Color(255, 255, 255));
		lblConversor.setFont(new Font("Dialog", Font.BOLD, 14));
		lblConversor.setBounds(221, 45, 50, 15);
		contentPane.add(lblConversor);
		
		JButton btnConvertir = new JButton("Convertir   ⇌");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (entradaDatos.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un valor a convertir");
				} else {
					try {
						
						String opcion1= lista1.getSelectedItem().toString().split("-")[0].trim();
						String opcion2= lista2.getSelectedItem().toString().split("-")[0].trim();
						Temperatura tempDe=new Temperatura(opcion1, Double.parseDouble(entradaDatos.getText()));
						Temperatura tempA=new Temperatura(opcion2);
						ConversorTemperatura convert=new ConversorTemperatura(tempDe,tempA);
						double resultadoConversion = convert.convertir();
						DecimalFormat formato= new DecimalFormat("#.##");
						resultadoTemp.setText(formato.format(tempDe.getValor()) + " " + tempDe.getNombre() + " equivalen a "
								+ formato.format(resultadoConversion) + " " + tempA.getNombre());
						resultadoTemp.setForeground(Color.WHITE);
					
					} catch (Exception exc) {
						JOptionPane.showMessageDialog(null,
								"Ocurrio un error inesperado: Contacte al desarrollador!!!");
						exc.printStackTrace();
					}
					
				}
				
				
				
				
			}
		});
		btnConvertir.setBackground(new Color(87, 227, 137));
		btnConvertir.setFont(new Font("Dialog", Font.BOLD, 12));
		btnConvertir.setBounds(22, 115, 135, 25);
		contentPane.add(btnConvertir);
		
		JButton btnVolver = new JButton("<= Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazPrincipal menu=new InterfazPrincipal();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btnVolver.setBackground(new Color(153, 193, 241));
		btnVolver.setBounds(616, 145, 117, 25);
		contentPane.add(btnVolver);
		
		lista1.setBounds(221, 65, 215, 24);
		lista2.setBounds(508, 65, 225, 24);
		
		
		for (int i=0;i<temperaturas.length;i++) {
			lista1.addItem(temperaturas[i]);
			lista2.addItem(temperaturas[i]);
		}
		lista2.setSelectedItem("Fahrenheit - °F");
		contentPane.add(lista1);
		contentPane.add(lista2);
		
		resultadoTemp = new JLabel("");
		resultadoTemp.setBounds(269, 120, 393, 15);
		contentPane.add(resultadoTemp);
		
		entradaDatos = new JTextField();
		entradaDatos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter= e.getKeyChar();
				if(!Character.isDigit(caracter) && (caracter!= '.' && caracter!= '-')) { //valida que ingresen digitos, punto o signo de menos.
					e.consume();
				}
				
				if (caracter == '.' && entradaDatos.getText().contains(".") || (caracter == '-' && entradaDatos.getText().contains("-"))) { //validar que contenga un solo "." y un solo "-"
						e.consume();
					} else if(entradaDatos.getText().trim().length()>=12) { //valida el ingreso de 12 caracteres
						JOptionPane.showMessageDialog(null,
								"Se permite solo 12 caracteres");
						e.consume();
					}
				if (entradaDatos.getText().substring(0) == "-") {  //valida que el signo negativo este al comienzo.
					e.consume();
					}
				
			}
		});
		entradaDatos.setBounds(22, 65, 170, 24);
		contentPane.add(entradaDatos);
		entradaDatos.setColumns(10);
		
		JLabel valorTemp = new JLabel("Valor de Temperatura:");
		valorTemp.setForeground(new Color(255, 255, 255));
		valorTemp.setFont(new Font("Dialog", Font.BOLD, 14));
		valorTemp.setBounds(18, 45, 180, 15);
		contentPane.add(valorTemp);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setForeground(new Color(255, 255, 255));
		lblResultado.setBounds(186, 120, 85, 15);
		contentPane.add(lblResultado);
		
		JLabel lblA = new JLabel("A:");
		lblA.setForeground(new Color(255, 255, 255));
		lblA.setFont(new Font("Dialog", Font.BOLD, 14));
		lblA.setBounds(512, 45, 50, 15);
		contentPane.add(lblA);
		
		JButton cambiar = new JButton("⇌");
		cambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int aux1 = lista1.getSelectedIndex();
			int aux2 = lista2.getSelectedIndex();
			lista1.setSelectedIndex(aux2);
			lista2.setSelectedIndex(aux1);
			}
		});
		cambiar.setFont(new Font("Dialog", Font.BOLD, 14));
		cambiar.setBounds(448, 65, 50, 25);
		contentPane.add(cambiar);
	}
}
