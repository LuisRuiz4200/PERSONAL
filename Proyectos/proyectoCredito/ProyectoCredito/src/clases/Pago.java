package clases;

public class Pago {
	private int codigo;
	private String cliente;
	private String fecha;
	private Double abono;
	
	
	public Pago(int codigo, String cliente, String fecha, Double abono) {
		
		this.codigo = codigo;
		this.cliente = cliente;
		this.fecha = fecha;
		this.abono = abono;
	}



	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public Double getAbono() {
		return abono;
	}


	public void setAbono(Double abono) {
		this.abono = abono;
	}
	
}
