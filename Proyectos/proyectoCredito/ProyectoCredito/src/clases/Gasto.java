package clases;

import java.text.DecimalFormat;

public class Gasto {
	
	private int codigo;
	private String cliente;
	private String motivo;
	private double monto;
	private String fecha;
	private int cuota;
	private double interes;
	
	
	public Gasto(int codigo, String cliente, String motivo, double monto, String fecha, int cuotas, double interes) {
		
		this.codigo = codigo;
		this.cliente = cliente;
		this.motivo = motivo;
		this.monto = monto;
		this.fecha = fecha;
		this.cuota = cuotas;
		this.interes = interes;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getMotivo() {
		return motivo;
	}


	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	public double getMonto() {
		return monto;
	}


	public void setMonto(double monto) {
		this.monto = monto;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public int getCuota() {
		return cuota;
	}


	public void setCuotas(int cuota) {
		this.cuota = cuota;
	}


	public double getInteres() {
		return interes;
	}


	public void setInteres(double interes) {
		this.interes = interes;
	}
	
	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	//metodos adicionales 
	
	public double interesCuota() {
		switch (cuota) {
		case 1 : 
			interes = 0;
			break;
		case 3 : 
			interes = 7.53;
			break;
		case 2 :
			interes = 5.61;
			break;
		case 6 :
			interes = 13.42;
			break;
		default:
			interes = 0;
				
		}
		return interes;
	}
	
	


	public double montoMensual() {
		
		DecimalFormat sdf= new DecimalFormat("000.00");
		
		return Double.parseDouble(sdf.format((monto * (interesCuota()/100))+ monto)); 
	}
	
	
}