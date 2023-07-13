package clases;

public class ColorOP{

	//Estoy pensando si hacerlo con el extendido o dejarlo asi
	
	private int nroOP;
	private int codColorOP;
	private String desColorOP;
	
	
	public ColorOP() {}
	
	public ColorOP(int nroOP, int codColorOP, String desColorOP) {
		super();
		this.nroOP = nroOP;
		this.codColorOP = codColorOP;
		this.desColorOP = desColorOP;
	}
	
	public int getNroOP() {
		return nroOP;
	}
	public void setNroOP(int nroOP) {
		this.nroOP = nroOP;
	}
	public int getCodColorOP() {
		return codColorOP;
	}
	public void setCodColorOP(int codColorOP) {
		this.codColorOP = codColorOP;
	}
	public String getDesColorOP() {
		return desColorOP;
	}
	public void setDesColorOP(String desColorOP) {
		this.desColorOP = desColorOP;
	}
	

	
	
}
