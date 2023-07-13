package clases;

public class Cliente {
	
	private int codCliente;
	private String desCliente;
	
	public Cliente() {}
	
	public Cliente(int codCliente, String desCliente) {
		super();
		this.codCliente = codCliente;
		this.desCliente = desCliente;
	}
	
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public String getDesCliente() {
		return desCliente;
	}
	public void setDesCliente(String desCliente) {
		this.desCliente = desCliente;
	}
	
	
	
}
