package clases;

import java.util.Date;

public class Prioridad {
	
	private int id_prioridad;
	private int nro_OP;
	private String color_OP;
	private String des_prioridad;
	private String obs_prioridad;
	private int orden_prioridad;
	private Date fechaReg_prioridad;
	private String estado_prioridad;
	
	
	public Prioridad() {}


	public Prioridad(int id_prioridad, int nro_OP, String color_OP, String des_prioridad, String obs_prioridad,
			int orden_prioridad, Date fechaReg_prioridad, String estado_prioridad) {
		super();
		this.id_prioridad = id_prioridad;
		this.nro_OP = nro_OP;
		this.color_OP = color_OP;
		this.des_prioridad = des_prioridad;
		this.obs_prioridad = obs_prioridad;
		this.orden_prioridad = orden_prioridad;
		this.fechaReg_prioridad = fechaReg_prioridad;
		this.estado_prioridad = estado_prioridad;
	}


	public int getId_prioridad() {
		return id_prioridad;
	}


	public void setId_prioridad(int id_prioridad) {
		this.id_prioridad = id_prioridad;
	}


	public int getNro_OP() {
		return nro_OP;
	}


	public void setNro_OP(int nro_OP) {
		this.nro_OP = nro_OP;
	}


	public String getColor_OP() {
		return color_OP;
	}


	public void setColor_OP(String color_OP) {
		this.color_OP = color_OP;
	}


	public String getDes_prioridad() {
		return des_prioridad;
	}


	public void setDes_prioridad(String des_prioridad) {
		this.des_prioridad = des_prioridad;
	}


	public String getObs_prioridad() {
		return obs_prioridad;
	}


	public void setObs_prioridad(String obs_prioridad) {
		this.obs_prioridad = obs_prioridad;
	}


	public int getOrden_prioridad() {
		return orden_prioridad;
	}


	public void setOrden_prioridad(int orden_prioridad) {
		this.orden_prioridad = orden_prioridad;
	}


	public Date getFechaReg_prioridad() {
		return fechaReg_prioridad;
	}


	public void setFechaReg_prioridad(Date fechaReg_prioridad) {
		this.fechaReg_prioridad = fechaReg_prioridad;
	}


	public String getEstado_prioridad() {
		return estado_prioridad;
	}


	public void setEstado_prioridad(String estado_prioridad) {
		this.estado_prioridad = estado_prioridad;
	}
	
	
}
