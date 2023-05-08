package clases;


public class OrdenP implements Comparable<OrdenP> {
	//atributos privados
	private int nroOp;
	private String color;
	private String cliente;
	//contructor 
	public OrdenP() {};
	public OrdenP(int nroOp, String color, String cliente) {
		this.nroOp=nroOp;
		this.color=color;
		this.cliente=cliente;
	}
	

	//set y get 
	public int getNroOp() {
		return nroOp;
	}
	public void setNroOp(int nroOp) {
		this.nroOp = nroOp;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	@Override
	public int compareTo(OrdenP o) {
		// TODO Auto-generated method stub
		if(this.nroOp<o.getNroOp()) {
			return -1;
		} else if(this.nroOp>o.getNroOp()) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
	
}
