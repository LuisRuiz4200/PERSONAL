package clases;

public class Avio {
	
	private int codAvio;
	private int codTipoAvio;
	private String desAvio;
	private String medidaAvio;
	private int codUM;
	
	public Avio(int codAvio, int codTipoAvio, String desAvio, String medidaAvio, int codUM) {
		super();
		this.codAvio = codAvio;
		this.codTipoAvio = codTipoAvio;
		this.desAvio = desAvio;
		this.medidaAvio = medidaAvio;
		this.codUM = codUM;
	}
	
	public int getCodAvio() {
		return codAvio;
	}
	public void setCodAvio(int codAvio) {
		this.codAvio = codAvio;
	}
	public int getCodTipoAvio() {
		return codTipoAvio;
	}
	public void setCodTipoAvio(int codTipoAvio) {
		this.codTipoAvio = codTipoAvio;
	}
	public String getDesAvio() {
		return desAvio;
	}
	public void setDesAvio(String desAvio) {
		this.desAvio = desAvio;
	}
	public String getMedidaAvio() {
		return medidaAvio;
	}
	public void setMedidaAvio(String medidaAvio) {
		this.medidaAvio = medidaAvio;
	}
	public int getCodUM() {
		return codUM;
	}
	public void setCodUM(int codUM) {
		this.codUM = codUM;
	}
	
	
}
