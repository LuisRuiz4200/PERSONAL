package clases;

public class IngresoAvio {

	private String nroVale;
	private int nroOP;
	private int codAvio;
	private String fechaAvio;
	private int cantAvio;
	
	public IngresoAvio(String nroVale, int nroOP, int codAvio, String fechaAvio, int cantAvio) {
		super();
		this.nroVale = nroVale;
		this.nroOP = nroOP;
		this.codAvio = codAvio;
		this.fechaAvio = fechaAvio;
		this.cantAvio = cantAvio;
	}
	public String getNroVale() {
		return nroVale;
	}
	public void setNroVale(String nroVale) {
		this.nroVale = nroVale;
	}
	public int getNroOP() {
		return nroOP;
	}
	public void setNroOP(int nroOP) {
		this.nroOP = nroOP;
	}
	public int getCodAvio() {
		return codAvio;
	}
	public void setCodAvio(int codAvio) {
		this.codAvio = codAvio;
	}
	public String getFechaAvio() {
		return fechaAvio;
	}
	public void setFechaAvio(String fechaAvio) {
		this.fechaAvio = fechaAvio;
	}
	public int getCantAvio() {
		return cantAvio;
	}
	public void setCantAvio(int cantAvio) {
		this.cantAvio = cantAvio;
	}
	
	
	
}
