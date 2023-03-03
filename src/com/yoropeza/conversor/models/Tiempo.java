package com.yoropeza.conversor.models;

public class Tiempo {

	private String nombre;
	private double valor;
	
	public Tiempo(String nombre, double valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	
	public Tiempo(String nombre) {
		super();
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
