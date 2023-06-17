package modelo;

public class Deudor {
	
	private String id_deudor;
	private String nom_deudor;
	private String ape_deudor;
	private String dni_deudor;
	
	public Deudor() {}

	public Deudor(String id_deudor, String nom_deudor, String ape_deudor, String dni_deudor) {
		super();
		this.id_deudor = id_deudor;
		this.nom_deudor = nom_deudor;
		this.ape_deudor = ape_deudor;
		this.dni_deudor = dni_deudor;
	}

	public String getId_deudor() {
		return id_deudor;
	}

	public void setId_deudor(String id_deudor) {
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

	
	
	
	
	
}
