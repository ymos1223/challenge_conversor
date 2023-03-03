package com.yoropeza.conversor.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPrincipal window = new InterfazPrincipal();
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
	public InterfazPrincipal() {
		setTitle("CONVERSOR");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(246, 97, 81));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JLabel titulo = new JLabel("Que deseas convertir?");
		titulo.setForeground(new Color(255, 255, 255));
		titulo.setFont(new Font("Roboto", Font.BOLD, 19));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(236, 22, 200, 15);
		contentPane.add(titulo);
		
		JButton btnDivisa = new JButton("Divisa");
		btnDivisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazDivisa menuDivisa= new InterfazDivisa();
				menuDivisa.setVisible(true);
				menuDivisa.setLocationRelativeTo(null);
				dispose();
			
				
			}
		});
		btnDivisa.setBackground(new Color(143, 240, 164));
		btnDivisa.setBounds(142, 72, 139, 25);
		contentPane.add(btnDivisa);
		
		JButton btnTemp = new JButton("Temperatura");
		btnTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazTemp menuTemp = new InterfazTemp();
				menuTemp.setVisible(true);
				menuTemp.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnTemp.setBackground(new Color(143, 240, 164));
		btnTemp.setBounds(351, 72, 139, 25);
		contentPane.add(btnTemp);
		
		JButton btnTiempo = new JButton("Tiempo");
		btnTiempo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazTiempo menuTiempo = new InterfazTiempo();
				menuTiempo.setVisible(true);
				menuTiempo.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		btnTiempo.setBackground(new Color(143, 240, 164));
		btnTiempo.setBounds(246, 121, 139, 25);
		contentPane.add(btnTiempo);
		setBounds(100, 100, 650, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
		