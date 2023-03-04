package com.yoropeza.conversor.models;

public class Divisa {

	private String nombre;
	private double valor;
	
	public Divisa(String nombre) {
		this.nombre = nombre;
	}

	public Divisa(String nombre, double valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}