package clases;

import java.util.Date;

public class ProgramaAcabado {
	
	private int cod_programaAcabado;
	private int nro_OP;
	private String cod_colorOP;
	private int cantPed_programaAcabado;
	private int cantProg_programaAcabado;
	private String cod_citiConfeccion;
	private String cod_citiAcabado;
	private String obs_programaAcabado;
	private Date fechaReg_programaAcabado;
	private Date fechaAct_programaAcabado;
	private String estado_programaAcabado;
	
	public ProgramaAcabado() {
		
	}

	public ProgramaAcabado(int cod_programaAcabado, int nro_OP, String cod_colorOP, int cantPed_programaAcabado,
			int cantProg_programaAcabado, String cod_citiConfeccion, String cod_citiAcabado, String obs_programaAcabado,
			Date fechaReg_programaAcabado, Date fechaAct_programaAcabado, String estado_programaAcabado) {
		super();
		this.cod_programaAcabado = cod_programaAcabado;
		this.nro_OP = nro_OP;
		this.cod_colorOP = cod_colorOP;
		this.cantPed_programaAcabado = cantPed_programaAcabado;
		this.cantProg_programaAcabado = cantProg_programaAcabado;
		this.cod_citiConfeccion = cod_citiConfeccion;
		this.cod_citiAcabado = cod_citiAcabado;
		this.obs_programaAcabado = obs_programaAcabado;
		this.fechaReg_programaAcabado = fechaReg_programaAcabado;
		this.fechaAct_programaAcabado = fechaAct_programaAcabado;
		this.estado_programaAcabado = estado_programaAcabado;
	}

	public int getCod_programaAcabado() {
		return cod_programaAcabado;
	}

	public void setCod_programaAcabado(int cod_programaAcabado) {
		this.cod_programaAcabado = cod_programaAcabado;
	}

	public int getNro_OP() {
		return nro_OP;
	}

	public void setNro_OP(int nro_OP) {
		this.nro_OP = nro_OP;
	}

	public String getCod_colorOP() {
		return cod_colorOP;
	}

	public void setCod_colorOP(String cod_colorOP) {
		this.cod_colorOP = cod_colorOP;
	}

	public int getCantPed_programaAcabado() {
		return cantPed_programaAcabado;
	}

	public void setCantPed_programaAcabado(int cantPed_programaAcabado) {
		this.cantPed_programaAcabado = cantPed_programaAcabado;
	}

	public int getCantProg_programaAcabado() {
		return cantProg_programaAcabado;
	}

	public void setCantProg_programaAcabado(int cantProg_programaAcabado) {
		this.cantProg_programaAcabado = cantProg_programaAcabado;
	}

	public String getCod_citiConfeccion() {
		return cod_citiConfeccion;
	}

	public void setCod_citiConfeccion(String cod_citiConfeccion) {
		this.cod_citiConfeccion = cod_citiConfeccion;
	}

	public String getCod_citiAcabado() {
		return cod_citiAcabado;
	}

	public void setCod_citiAcabado(String cod_citiAcabado) {
		this.cod_citiAcabado = cod_citiAcabado;
	}

	public String getObs_programaAcabado() {
		return obs_programaAcabado;
	}

	public void setObs_programaAcabado(String obs_programaAcabado) {
		this.obs_programaAcabado = obs_programaAcabado;
	}

	public Date getFechaReg_programaAcabado() {
		return fechaReg_programaAcabado;
	}

	public void setFechaReg_programaAcabado(Date fechaReg_programaAcabado) {
		this.fechaReg_programaAcabado = fechaReg_programaAcabado;
	}

	public Date getFechaAct_programaAcabado() {
		return fechaAct_programaAcabado;
	}

	public void setFechaAct_programaAcabado(Date fechaAct_programaAcabado) {
		this.fechaAct_programaAcabado = fechaAct_programaAcabado;
	}

	public String getEstado_programaAcabado() {
		return estado_programaAcabado;
	}

	public void setEstado_programaAcabado(String estado_programaAcabado) {
		this.estado_programaAcabado = estado_programaAcabado;
	}

	
	
	
}
