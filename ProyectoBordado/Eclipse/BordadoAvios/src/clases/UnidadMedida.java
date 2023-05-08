package clases;

public class UnidadMedida {

	private int codUM;
	private String desUM;
	
	public UnidadMedida(int codUM, String desUM) {
		super();
		this.codUM = codUM;
		this.desUM = desUM;
	}
	
	public int getCodUM() {
		return codUM;
	}
	public void setCodUM(int codUM) {
		this.codUM = codUM;
	}
	public String getDesUM() {
		return desUM;
	}
	public void setDesUM(String desUM) {
		this.desUM = desUM;
	}
	
}
