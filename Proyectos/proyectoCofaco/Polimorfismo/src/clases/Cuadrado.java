package clases;

import interfaces.*;

public class Cuadrado implements Figura,Dibujable, Rotable{
	//atributos 
	private double lado;
	//constructor
	public Cuadrado() {
		
	}
	public Cuadrado(double lado) {
		this.lado=lado;
	}
	//set y get 
	public void setLado(double lado) {
		this.lado=lado;
	}
	public double getLado() {
		return lado;
	}
	@Override
	public double area() {
		return lado * lado;
	}
	@Override
	public String dibujar() {
		return "Dibujando un cuadrado";
	}
	@Override 
	public String rotar() {
		return "Rotando cuadrado";
	}
	
	
}
