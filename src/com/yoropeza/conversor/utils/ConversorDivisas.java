package com.yoropeza.conversor.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.json.JSONObject;

import com.yoropeza.conversor.models.Divisa;

public class ConversorDivisas {

	
	private Divisa de;
	private Divisa para;
	
	public ConversorDivisas(Divisa de, Divisa para) {
		this.de = de;
		this.para = para;
	}

	
	public double obtenerValorDivisa() {
		
		Properties datos= new Properties();
		double resultado=0.0;
		
		if (de.getValor()==0) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un valor distinto a cero");
		} else {
			
		 try {
				datos.load(new FileInputStream("configuration.properties"));
	            URL url = new URL("https://api.apilayer.com/fixer/convert?to=" + para.getNombre() + "&from=" + de.getNombre() + "&amount=" + de.getValor());
	            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
	            conexion.setRequestMethod("GET");
	            conexion.addRequestProperty("apikey", datos.getProperty("ACCESS_KEY"));
	            conexion.connect();

	            int responseCode = conexion.getResponseCode();
	            if (responseCode != 200) {
	                throw new RuntimeException("Ocurrio un error: " + responseCode);
	            } else {
	            	BufferedReader br=null;
	            	System.out.println(conexion.getInputStream());
	            	br = new BufferedReader (new InputStreamReader(conexion.getInputStream()));
	            	String myJson="";
	            	String currentValue="";
	            	while((currentValue =br.readLine()) !=null) {
	            		myJson +=currentValue;
	            	
	            	}
	            	br.close();
	            	JSONObject json = new JSONObject(myJson);
	            	System.out.println(json.toString());
	            	resultado= json.optDouble("result");
	            	System.out.println("resultado "+resultado);
	               
	            }

	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	
	    }
		return resultado;
	}
	
	public Divisa getDe() {
		return de;
	}
	public void setDe(Divisa de) {
		this.de = de;
	}
	public Divisa getPara() {
		return para;
	}
	public void setPara(Divisa para) {
		this.para = para;
	}
	
	
}
