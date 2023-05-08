package clases;

public class Confeccion {
	//atributo privado
	private String codigoCiti;
	private String nombre;
	//constructor
	public Confeccion () {}
	public Confeccion (String codigoCiti, String nombre) {
		this.codigoCiti=codigoCiti;
		this.nombre=nombre;
	}
	//set y get
	public String getCodigoCiti() {
		return codigoCiti;
	}
	public void setCodigoCiti(String codigoCiti) {
		this.codigoCiti = codigoCiti;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
