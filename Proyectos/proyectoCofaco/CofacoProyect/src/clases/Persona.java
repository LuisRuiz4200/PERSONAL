package clases;

public abstract class Persona {
	//atributo privado 
	private String nombre;
	private String apellido;
	private String tipo;
	//constructor 
	public Persona() {
		
	}
	public Persona (String nombre, String apellido, String tipo) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.tipo=tipo;
	}
	//set y get 
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setApellido(String apellido) {
		this.apellido=apellido;
	}
	public String getApellido() {
		return apellido;
	}
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	public String getTipo() {
		return tipo;
	}
	//metodos del abstract 
	
	public String datos() {
		return "nombre : " + nombre +
				"apellido : " + apellido;
	}
	
	public abstract String datosCompletos();
}
