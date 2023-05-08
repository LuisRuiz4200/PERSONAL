package clases;

import interfaces.*;

public class Rectangulo implements Figura {
	//atributos privados 
	private double base;
	private double altura;
	//constructor 
	public Rectangulo() {
		
	}
	public Rectangulo(double base, double altura) {
		this.base=base;
		this.altura=altura;
	}
	//set y get 
	public void setBase (double base) {
		this.base=base;
	}
	public void setAltura(double altura) {
		this.altura=altura;
	}
	public double getBase() {
		return base;
	}
	public double getAltura() {
		return altura;
	}
	@Override
	public double area() {
		return base * altura;
	}
}
