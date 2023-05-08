package clases;



public class Linea implements Comparable<Linea>{
	//atributos privados
	private String linea;
	private String supervisor;
	//constructor
	public Linea() {
		
	}
	public Linea (String linea, String supervisor) {
		this.linea= linea;
		this.supervisor= supervisor;
	}
	//set y get 
	public void setLinea(String linea) {
		this.linea= linea;
	}
	public String getLinea() {
		return linea;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor=supervisor;
	}
	public String getSupervisor() {
		return supervisor;
	}
	@Override
	public int compareTo(Linea o) {
		return linea.compareTo(o.getLinea());
	}
	
}
