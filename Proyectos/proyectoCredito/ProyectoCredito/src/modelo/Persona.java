package modelo;

import java.util.Date;

public class Deudor {
	
	private int id_deudor;
	private String nom_deudor;
	private String ape_deudor;
	private String dni_deudor;
	private Date fechaReg_deudor;
	private Date fechaAct_deudor;


	private String estado_deudor;
	
	

	public Deudor() {}

	public Deudor(int id_deudor, String nom_deudor, String ape_deudor, String dni_deudor) {
		super();
		this.id_deudor = id_deudor;
		this.nom_deudor = nom_deudor;
		this.ape_deudor = ape_deudor;
		this.dni_deudor = dni_deudor;
	}

	public int getId_deudor() {
		return id_deudor;
	}

	public void setId_deudor(int id_deudor) {
		this.id_deudor = id_deudor;
	}

	public String getNom_deudor() {
		return nom_deudor;
	}

	public void setNom_deudor(String nom_deudor) {
		this.nom_deudor = nom_deudor;
	}

	public String getApe_deudor() {
		return ape_deudor;
	}

	public void setApe_deudor(String ape_deudor) {
		this.ape_deudor = ape_deudor;
	}

	public String getDni_deudor() {
		return dni_deudor;
	}

	public void setDni_deudor(String dni_deudor) {
		this.dni_deudor = dni_deudor;
	}

	public String getEstado_deudor() {
		return estado_deudor;
	}
	
	public Date getFechaReg_deudor() {
		return fechaReg_deudor;
	}

	public void setFechaReg_deudor(Date fechaReg_deudor) {
		this.fechaReg_deudor = fechaReg_deudor;
	}

	public Date getFechaAct_deudor() {
		return fechaAct_deudor;
	}

	public void setFechaAct_deudor(Date fechaAct_deudor) {
		this.fechaAct_deudor = fechaAct_deudor;
	}

	public void setEstado_deudor(String estado_deudor) {
		this.estado_deudor = estado_deudor;
	}
	
	
	
	
}
