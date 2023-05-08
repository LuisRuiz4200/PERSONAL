package clases;

public class TipoAvio {
	
	private int codTipoAvio;
	private String desTipoAvio;
	
	public TipoAvio(int codTipoAvio, String desTipoAvio) {
		super();
		this.codTipoAvio = codTipoAvio;
		this.desTipoAvio = desTipoAvio;
	}
	
	public int getCodTipoAvio() {
		return codTipoAvio;
	}
	public void setCodTipoAvio(int codTipoAvio) {
		this.codTipoAvio = codTipoAvio;
	}
	public String getDesTipoAvio() {
		return desTipoAvio;
	}
	public void setDesTipoAvio(String desTipoAvio) {
		this.desTipoAvio = desTipoAvio;
	}
	
	
}
