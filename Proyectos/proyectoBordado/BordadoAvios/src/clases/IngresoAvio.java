package clases;

import java.util.Date;

public class IngresoAvio {

	private int id_ingresoAvio;
	private String nroVale_ingresoAvio;
	private int nroOP;
	private int codAvio;
	private int cant_ingresoAvio;
	private String obs_ingresoAcvio;
	private Date fechaReg_ingresoAvio;
	private String estado_ingresoAvio;
	
	
	public IngresoAvio() {}


	

	public IngresoAvio(int id_ingresoAvio, String nroVale_ingresoAvio, int nroOP, int codAvio, int cant_ingresoAvio,
			String obs_ingresoAcvio, Date fechaReg_ingresoAvio, String estado_ingresoAvio) {
		super();
		this.id_ingresoAvio = id_ingresoAvio;
		this.nroVale_ingresoAvio = nroVale_ingresoAvio;
		this.nroOP = nroOP;
		this.codAvio = codAvio;
		this.cant_ingresoAvio = cant_ingresoAvio;
		this.obs_ingresoAcvio = obs_ingresoAcvio;
		this.fechaReg_ingresoAvio = fechaReg_ingresoAvio;
		this.estado_ingresoAvio = estado_ingresoAvio;
	}


	public int getId_ingresoAvio() {
		return id_ingresoAvio;
	}
	public void setId_ingresoAvio(int id_ingresoAvio) {
		this.id_ingresoAvio = id_ingresoAvio;
	}
	public String getNroVale_ingresoAvio() {
		return nroVale_ingresoAvio;
	}
	public void setNroVale_ingresoAvio(String nroVale_ingresoAvio) {
		this.nroVale_ingresoAvio = nroVale_ingresoAvio;
	}
	public int getNroOP() {
		return nroOP;
	}
	public void setNroOP(int nroOP) {
		this.nroOP = nroOP;
	}
	public int getCodAvio() {
		return codAvio;
	}
	public void setCodAvio(int codAvio) {
		this.codAvio = codAvio;
	}
	public Date getFechaReg_ingresoAvio() {
		return fechaReg_ingresoAvio;
	}
	public void setFechaReg_ingresoAvio(Date fechaReg_ingresoAvio) {
		this.fechaReg_ingresoAvio = fechaReg_ingresoAvio;
	}
	public int getCant_ingresoAvio() {
		return cant_ingresoAvio;
	}
	public void setCant_ingresoAvio(int cant_ingresoAvio) {
		this.cant_ingresoAvio = cant_ingresoAvio;
	}
	
	public String getObs_ingresoAcvio() {
		return obs_ingresoAcvio;
	}


	public void setObs_ingresoAcvio(String obs_ingresoAcvio) {
		this.obs_ingresoAcvio = obs_ingresoAcvio;
	}

	public String getEstado_ingresoAvio() {
		return estado_ingresoAvio;
	}
	public void setEstado_ingresoAvio(String estado_ingresoAvio) {
		this.estado_ingresoAvio = estado_ingresoAvio;
	}

	
}
