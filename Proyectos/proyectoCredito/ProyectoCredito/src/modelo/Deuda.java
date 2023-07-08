package modelo;

import java.text.DecimalFormat;
import java.util.Date;

public class Deuda {
	
	private int id_deuda;
	private int id_deudor;
	private double monto_deuda;
	private int cuota_deuda;
	private String des_deuda;
	private double interes_deuda;
	private Date fechaReg_deuda = null;
	private Date fechaAct_deuda = null;
	private String estado_deuda;
	
	
	private double TEA = 0.55;
	private double TEM = Math.pow((1+ TEA),(30/360)) - 1;
	
	
	public Deuda() {}
	
	

	public int getId_deuda() {
		return id_deuda;
	}



	public void setId_deuda(int id_deuda) {
		this.id_deuda = id_deuda;
	}



	public int getId_deudor() {
		return id_deudor;
	}



	public void setId_deudor(int id_deudor) {
		this.id_deudor = id_deudor;
	}



	public double getMonto_deuda() {
		return monto_deuda;
	}



	public void setMonto_deuda(double monto_deuda) {
		this.monto_deuda = monto_deuda;
	}



	public int getCuota_deuda() {
		return cuota_deuda;
	}



	public void setCuota_deuda(int cuota_deuda) {
		this.cuota_deuda = cuota_deuda;
	}



	public String getDes_deuda() {
		return des_deuda;
	}



	public void setDes_deuda(String des_deuda) {
		this.des_deuda = des_deuda;
	}



	public double getInteres_deuda() {
		return interes_deuda;
	}



	public void setInteres_deuda(double interes_deuda) {
		this.interes_deuda = interes_deuda;
	}



	public Date getFechaReg_deuda() {
		return fechaReg_deuda;
	}



	public void setFechaReg_deuda(Date fechaReg_deuda) {
		this.fechaReg_deuda = fechaReg_deuda;
	}



	public Date getFechaAct_deuda() {
		return fechaAct_deuda;
	}



	public void setFechaAct_deuda(Date fechaAct_deuda) {
		this.fechaAct_deuda = fechaAct_deuda;
	}



	public String getEstado_deuda() {
		return estado_deuda;
	}



	public void setEstado_deuda(String estado_deuda) {
		this.estado_deuda = estado_deuda;
	}



	public double getTEA() {
		return TEA;
	}



	public void setTEA(double tEA) {
		TEA = tEA;
	}



	public double getTEM() {
		return TEM;
	}



	public void setTEM(double tEM) {
		TEM = tEM;
	}
	
	
	public double getTotal(double monto, int cuota) {
		double res = 0;
		res = Double.parseDouble(new DecimalFormat("0.00").format(monto * getInteresGenerado(cuota,monto) + monto));
		return res;
	}



	public double getInteresGenerado(double cuota, double monto) {
		
		double tasa = 0.037196338;//A1
		double nper = cuota;//B1
		double va = monto;//C1
		
		//=(A1*(1+A1)^B1)*C1/(((1+A1)^B1)-1)
		
		double nuevoInteres =  0;
		double nuevoMontoMensual = (tasa * Math.pow((1+tasa),nper))*va/((Math.pow((1+tasa),nper))-1);
		
		if (cuota>1) {
			//
			nuevoInteres = (nuevoMontoMensual - (monto/cuota))/(monto/cuota)*100;
		}
		
		return nuevoInteres/100;
	}
	
	
	
	
}
