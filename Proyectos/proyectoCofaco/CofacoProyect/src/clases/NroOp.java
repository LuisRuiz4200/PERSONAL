package clases;

public class NroOp implements Comparable<NroOp>{
	
	private int nroOp;
	
	public NroOp () {
		
	}
	public NroOp (int nroOp) {
		this.nroOp= nroOp;
	}
	
	public void setNroOp(int nroOp) {
		this.nroOp= nroOp;
	}
	public int getNroOp() {
		return nroOp;
	}
	
	@Override
	public int compareTo(NroOp o) {
		return ("" + nroOp).compareTo(o.getNroOp() + "");
	}
}
