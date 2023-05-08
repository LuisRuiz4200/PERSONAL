package clases;

public class OrdenProduccion {
	
	private int nroOp;
	private int codCliente;
	private int codEstilo;
	
	public OrdenProduccion(int nroOp, int codCliente, int codEstilo) {
		super();
		this.nroOp = nroOp;
		this.codCliente = codCliente;
		this.codEstilo = codEstilo;
	}
	
	public int getNroOp() {
		return nroOp;
	}
	public void setNroOp(int nroOp) {
		this.nroOp = nroOp;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public int getCodEstilo() {
		return codEstilo;
	}
	public void setCodEstilo(int codEstilo) {
		this.codEstilo = codEstilo;
	}
	
	
	
}
