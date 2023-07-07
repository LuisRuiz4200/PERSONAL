package modelo;

import java.util.Date;

public class Pago {
	
	private String id_pago;
	private String id_deudor;
	private double monto_pago;
	private Date fechaReg_pago;
	private Date fechaAct_pago;
	private String id_medioPago;
	private String estado_pago;
	
	public Pago() {}

	public String getId_pago() {
		return id_pago;
	}

	public void setId_pago(String id_pago) {
		this.id_pago = id_pago;
	}

	public String getId_deudor() {
		return id_deudor;
	}

	public void setId_deudor(String id_deudor) {
		this.id_deudor = id_deudor;
	}

	public double getMonto_pago() {
		return monto_pago;
	}

	public void setMonto_pago(double monto_pago) {
		this.monto_pago = monto_pago;
	}

	public Date getFechaReg_pago() {
		return fechaReg_pago;
	}

	public void setFechaReg_pago(Date fechaReg_pago) {
		this.fechaReg_pago = fechaReg_pago;
	}

	public Date getFechaAct_pago() {
		return fechaAct_pago;
	}

	public void setFechaAct_pago(Date fechaAct_pago) {
		this.fechaAct_pago = fechaAct_pago;
	}

	public String getId_medioPago() {
		return id_medioPago;
	}

	public void setId_medioPago(String id_medioPago) {
		this.id_medioPago = id_medioPago;
	}

	public String getEstado_pago() {
		return estado_pago;
	}

	public void setEstado_pago(String estado_pago) {
		this.estado_pago = estado_pago;
	}

	
	
	
	
}
