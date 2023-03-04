package com.yoropeza.conversor.utils;

import com.yoropeza.conversor.models.Temperatura;

public class ConversorTemperatura {

private Temperatura de;
private Temperatura para;


public ConversorTemperatura(Temperatura de, Temperatura para) {
	this.de = de;
	this.para = para;
}

public double convertir() {
	
	double resultConversion=0.0;
	
	if (de.getNombre().equals(para.getNombre())) {
		resultConversion=de.getValor();
	} else {
	
	switch (de.getNombre()) {
		
	case "Fahrenheit" :
		
		if(para.getNombre().equals("Celsius")) {
			resultConversion= (de.getValor()-32) / 1.8;
		}else {
		resultConversion = (de.getValor() - 32) * 5/9 + 273.15;
		}
		
		break;
		
	case "Celsius" :
		if(para.getNombre().equals("Fahrenheit")) {
			resultConversion= (de.getValor() * 1.8) + 32;
		}else {
		resultConversion= de.getValor() + 273.15;
		}
		
		break;
		
	case "Kelvin":
		if(para.getNombre().equals("Celsius")) {
			resultConversion=  de.getValor() - 273.15;
		}else {
		resultConversion= ( 1.8 * (de.getValor() - 273.15)) + 32;
		}
		
		break;
	
	}
	}

	return resultConversion;
	
}


public Temperatura getDe() {
	return de;
}

public void setDe(Temperatura de) {
	this.de = de;
}

public Temperatura getPara() {
	return para;
}

public void setPara(Temperatura para) {
	this.para = para;
}


	
}
