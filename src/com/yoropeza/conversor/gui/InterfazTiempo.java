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

import com.yoropeza.conversor.models.Tiempo;
import com.yoropeza.conversor.utils.ConversorTiempo;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class InterfazTiempo extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel resultadoTiempo;
	private String[] tiempos= {"Semanas - wk","Días - d","Horas - h","Minutos - min","Segundos - s"};
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
					InterfazTiempo window = new InterfazTiempo();
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
	public InterfazTiempo() {
		lista1= new JComboBox<String>();
		lista2= new JComboBox<String>();
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("CONVERSOR DE UNIDAD DE TIEMPO");
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
						Tiempo tiempoDe= new Tiempo(opcion1,Double.parseDouble(entradaDatos.getText()));
						Tiempo tiempoA= new Tiempo(opcion2);
						ConversorTiempo convert= new ConversorTiempo(tiempoDe,tiempoA);
						double resultado= convert.convertir();
						NumberFormat formato= NumberFormat.getNumberInstance();
						resultadoTiempo.setText(formato.format(tiempoDe.getValor()) + " " + tiempoDe.getNombre() + " equivalen a "
								+ formato.format(resultado) + " " + tiempoA.getNombre());
						resultadoTiempo.setForeground(Color.WHITE);
					} catch (Exception exc) {
						JOptionPane.showMessageDialog(null,"Ocurrio un error inesperado: Contacte al desarrollador!!!");
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
		
		for (int i=0;i<tiempos.length;i++) {
			lista1.addItem(tiempos[i]);
			lista2.addItem(tiempos[i]);
		}
		lista2.setSelectedItem("Días - d");
		contentPane.add(lista1);
		contentPane.add(lista2);
		
		
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
		
		resultadoTiempo = new JLabel("");
		resultadoTiempo.setBounds(269, 120, 393, 15);
		contentPane.add(resultadoTiempo);
		
		entradaDatos = new JTextField();
		entradaDatos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter= e.getKeyChar();
				if(!Character.isDigit(caracter) && caracter!= '.') {
					e.consume();
				}
				
				if (caracter == '.' && entradaDatos.getText().contains(".")) { //validar que contenga un solo "."
						e.consume();
					} else if(entradaDatos.getText().trim().length()>=12) {
						JOptionPane.showMessageDialog(null,
								"Se permite solo 12 caracteres");
						e.consume();
					}
		
			}
		});
		entradaDatos.setBounds(22, 65, 170, 24);
		contentPane.add(entradaDatos);
		entradaDatos.setColumns(10);
		
		JLabel valorTiempo = new JLabel("Valor de Tiempo:");
		valorTiempo.setForeground(new Color(255, 255, 255));
		valorTiempo.setFont(new Font("Dialog", Font.BOLD, 14));
		valorTiempo.setBounds(18, 45, 180, 15);
		contentPane.add(valorTiempo);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setForeground(new Color(255, 255, 255));
		lblResultado.setBackground(new Color(255, 255, 255));
		lblResultado.setBounds(186, 120, 85, 15);
		contentPane.add(lblResultado);
		
		JLabel lblA = new JLabel("A:");
		lblA.setForeground(new Color(255, 255, 255));
		lblA.setFont(new Font("Dialog", Font.BOLD, 14));
		lblA.setBounds(512, 45, 50, 15);
		contentPane.add(lblA);
	}
}

		