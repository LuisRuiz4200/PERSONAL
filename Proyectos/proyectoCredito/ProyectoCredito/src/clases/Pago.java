package clases;

public class Pago {
	
	private String id_pago;
	private String id_cliente;
	private double monto_pago;
	private String fecha_pago;
	private String id_medioPago;
	private String estado_pago;
	
	public Pago() {}
	
	public Pago(String id_pago, String id_cliente, double monto_pago, String fecha_pago, String id_medioPago) {
		this.id_pago = id_pago;
		this.id_cliente = id_cliente;
		this.monto_pago = monto_pago;
		this.fecha_pago = fecha_pago;
		this.id_medioPago = id_medioPago;
	}
	
	public Pago(String id_pago, String id_cliente, double monto_pago, String fecha_pago, String id_medioPago,String estado_pago) {
		this.id_pago = id_pago;
		this.id_cliente = id_cliente;
		this.monto_pago = monto_pago;
		this.fecha_pago = fecha_pago;
		this.id_medioPago = id_medioPago;
		this.estado_pago = estado_pago;
	}

	public String getId_pago() {
		return id_pago;
	}

	public void setId_pago(String id_pago) {
		this.id_pago = id_pago;
	}

	public String getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}

	public double getMonto_pago() {
		return monto_pago;
	}

	public void setMonto_pago(double monto_pago) {
		this.monto_pago = monto_pago;
	}

	public String getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(String fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public String getId_medioPago() {
		return id_medioPago;
	}

	public void setId_medioPago(String id_medioPago) {
		this.id_medioPago = id_medioPago;
	}
	
	public String getEstado_pago() {
		return this.estado_pago;
	}
	
	public void setEstado_pago(String estado_pago) {
		this.estado_pago = estado_pago;
	}
	
	
	
}
