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

import com.yoropeza.conversor.models.Divisa;
import com.yoropeza.conversor.utils.ConversorDivisas;

import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InterfazDivisa extends JFrame {

	private static final long serialVersionUID = -728724965366505438L;
	private JPanel contentPane;
	private JLabel resultado;
	private String[] tiposDivisas = { "Pesos Colombianos - COP", "Euros -  EUR", "Dólar - USD",
			"Libras Esterlinas - GBP", "Yen Japonés - JPY", "Won surcoreano - KRW" };
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
					InterfazDivisa window = new InterfazDivisa();
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
	public InterfazDivisa() {
		lista1 = new JComboBox<String>();
		lista2 = new JComboBox<String>();
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("CONVERSOR DE DIVISAS");
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
						String opcion1 = lista1.getSelectedItem().toString().split("-")[1].trim();
						String opcion2 = lista2.getSelectedItem().toString().split("-")[1].trim();
						Divisa divisaDe = new Divisa(opcion1, Double.parseDouble(entradaDatos.getText()));
						Divisa divisaPara = new Divisa(opcion2);
						ConversorDivisas convertir = new ConversorDivisas(divisaDe, divisaPara);
						NumberFormat formatoImporte = NumberFormat.getNumberInstance();
						double resultadoConversion = convertir.obtenerValorDivisa();
						resultado.setText(formatoImporte.format(divisaDe.getValor()) + " " + divisaDe.getNombre() + " equivalen a "
								+ formatoImporte.format(resultadoConversion) + " " + divisaPara.getNombre());
						resultado.setForeground(Color.WHITE);
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

		JButton btnvolver = new JButton("<= Volver");
		btnvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazPrincipal menu = new InterfazPrincipal();
				menu.setVisible(true);
				menu.setLocationRelativeTo(null);
				dispose();

			}
		});
		btnvolver.setBackground(new Color(153, 193, 241));
		btnvolver.setBounds(616, 145, 117, 25);
		contentPane.add(btnvolver);

		lista1.setBounds(221, 65, 215, 24);
		lista2.setBounds(508, 65, 225, 24);

		for (int i = 0; i < tiposDivisas.length; i++) {
			lista1.addItem(tiposDivisas[i]);
			lista2.addItem(tiposDivisas[i]);
		}
		lista2.setSelectedItem("Dólar - USD");
		contentPane.add(lista1);
		contentPane.add(lista2);

		JLabel flecha = new JLabel("=>");
		flecha.setFont(new Font("Dialog", Font.BOLD, 24));
		flecha.setBounds(448, 65, 60, 25);
		contentPane.add(flecha);

		resultado = new JLabel("");
		resultado.setBounds(269, 120, 393, 15);
		contentPane.add(resultado);

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

		JLabel importe = new JLabel("Ingrese Importe:");
		importe.setForeground(new Color(255, 255, 255));
		importe.setFont(new Font("Dialog", Font.BOLD, 14));
		importe.setBounds(26, 45, 166, 15);
		contentPane.add(importe);

		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setForeground(new Color(255, 255, 255));
		lblResultado.setBounds(186, 120, 85, 15);
		contentPane.add(lblResultado);

		JLabel lblA = new JLabel("A:");
		lblA.setForeground(new Color(255, 255, 255));
		lblA.setFont(new Font("Dialog", Font.BOLD, 14));
		lblA.setBounds(511, 45, 50, 15);
		contentPane.add(lblA);
		
		lista2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista1.getSelectedItem().equals(lista2.getSelectedItem())) {
					btnConvertir.setEnabled(false);
					JOptionPane.showMessageDialog(null, "Debe seleccionar Divisas distintas");
				} else {
					btnConvertir.setEnabled(true);
				}
			}
		});
		
	}
}
