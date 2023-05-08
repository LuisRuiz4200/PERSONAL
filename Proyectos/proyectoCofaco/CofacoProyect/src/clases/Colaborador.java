package clases;

public class Colaborador extends Persona{
	//atributos privados 
	private int codigo;
	//contructor 
	public Colaborador() {
		
	}
	public Colaborador(int codigo, String nombre, String apellido, String tipo) {
		super (nombre, apellido,tipo);
		this.codigo=codigo;
	}
	//set y get 
	public void setCodigo(int codigo) {
		this.codigo=codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	//metodos adicionales 
	
	@Override
	public String datosCompletos() {
		return null;
	}
	
}
