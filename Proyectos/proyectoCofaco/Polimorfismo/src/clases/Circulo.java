package clases;

import interfaces.*;

public class Circulo implements Figura,Dibujable,Rotable{
	//atributos privados
	private double radio;
	//constructor
	public Circulo() {
		
	}
	public Circulo(double radio) {
		this.radio=radio;
	}
	//set y get 
	public void setRadio(double radio) {
		this.radio=radio;
	}
	public double getRadio() {
		return radio;
	}
	@Override
	public double area() {
		return PI*radio*radio;
	}
	@Override
	public String dibujar() {
		return "Dibujando un circulo";
	}
	@Override 
	public String rotar() {
		return "Rotando circulo";
	}
}
