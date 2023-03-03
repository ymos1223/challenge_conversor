package com.yoropeza.conversor.models;

public class Temperatura {

	private String nombre;
	private double valor;
	
	
	public Temperatura(String nombre, double valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	
	public Temperatura(String nombre) {
		this.nombre = nombre;
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
