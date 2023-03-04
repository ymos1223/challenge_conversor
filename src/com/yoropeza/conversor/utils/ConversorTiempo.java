package com.yoropeza.conversor.utils;


import javax.swing.JOptionPane;

import com.yoropeza.conversor.models.Tiempo;

public class ConversorTiempo {

	private Tiempo de;
	private Tiempo para;



	public double convertir() {
		
		double resultConversion = 0.0;
		
		if (de.getNombre().equals(para.getNombre())) {
			resultConversion=de.getValor();
		} else if (de.getValor()==0){
		JOptionPane.showMessageDialog(null, "Debe ingresar un valor distinto a cero");
		} else {

		switch (de.getNombre()) {

		case "Semanas":
			if (para.getNombre().equals("Días")) {
				resultConversion = de.getValor() * 7;
			} else if (para.getNombre().equals("Horas")) {
				resultConversion = de.getValor() * 168;
			} else if (para.getNombre().equals("Minutos")) {
				resultConversion = de.getValor() * 10080;
			} else {
				resultConversion = de.getValor() * 604800;
			}
			break;

		case "Días":
			if (para.getNombre().equals("Semanas")) {
				resultConversion = de.getValor() / 7;
			} else if (para.getNombre().equals("Horas")) {
				resultConversion = de.getValor() * 24;
			} else if (para.getNombre().equals("Minutos")) {
				resultConversion = de.getValor() * 1440;
			} else {
				resultConversion = de.getValor() * 86400;
			}
			
			break;

		case "Horas":
			
			if (para.getNombre().equals("Semanas")) {
				resultConversion = de.getValor() / 168;
			} else if (para.getNombre().equals("Días")) {
				resultConversion = de.getValor() / 24;
			} else if (para.getNombre().equals("Minutos")) {
				resultConversion = de.getValor() * 60;
			} else {
				resultConversion = de.getValor() * 3600;
			}

			break;

		case "Minutos":
			
			if (para.getNombre().equals("Semanas")) {
				resultConversion = de.getValor() / 10080;
			} else if (para.getNombre().equals("Días")) {
				resultConversion = de.getValor() / 1440;
			} else if (para.getNombre().equals("Horas")) {
				resultConversion = de.getValor() / 60;
			} else {
				resultConversion = de.getValor() * 60;
			}
			
			break;

		case "Segundos":


			if (para.getNombre().equals("Semanas")) {
				resultConversion = de.getValor() / 604800;
			} else if (para.getNombre().equals("Días")) {
				resultConversion = de.getValor() / 86400;
			} else if (para.getNombre().equals("Horas")) {
				resultConversion = de.getValor() / 3600;
			} else {
				resultConversion = de.getValor() / 60;
			}
			
			break;

		}
		}
		return resultConversion;
	}


	public Tiempo getDe() {
		return de;
	}

	public void setDe(Tiempo de) {
		this.de = de;
	}

	public Tiempo getPara() {
		return para;
	}

	public void setPara(Tiempo para) {
		this.para = para;
	}

	public ConversorTiempo(Tiempo de, Tiempo para) {
		this.de = de;
		this.para = para;
	}

}
