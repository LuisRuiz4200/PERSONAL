package clases;

public class EstiloOP {
	
	private int codEstiloOp;
	private String desEstiloOp;
	private int codPrenda;
	
	public EstiloOP() {}
	
	public EstiloOP(int codEstiloOp, String desEstiloOp, int codPrenda) {
		super();
		this.codEstiloOp = codEstiloOp;
		this.desEstiloOp = desEstiloOp;
		this.codPrenda = codPrenda;
	}

	public int getCodEstiloOp() {
		return codEstiloOp;
	}

	public void setCodEstiloOP(int codEstiloOp) {
		this.codEstiloOp = codEstiloOp;
	}

	public String getDesEstiloOp() {
		return desEstiloOp;
	}

	public void setDesEstiloOp(String desEstiloOp) {
		this.desEstiloOp = desEstiloOp;
	}

	public int getCodPrenda() {
		return codPrenda;
	}

	public void setCodPrenda(int codPrenda) {
		this.codPrenda = codPrenda;
	}
	
	
	
	
}
