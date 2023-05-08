package clases;

public class Cliente {
	
	private String id_cliente;
	private String nom_cliente;
	private String ape_cliente;
	private String dni_cliente;
	
	public Cliente() {}

	public Cliente(String id_cliente, String nom_cliente, String ape_cliente, String dni_cliente) {
		this.id_cliente = id_cliente;
		this.nom_cliente = nom_cliente;
		this.ape_cliente = ape_cliente;
		this.dni_cliente = dni_cliente;
	}

	public String getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNom_cliente() {
		return nom_cliente;
	}

	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}

	public String getApe_cliente() {
		return ape_cliente;
	}

	public void setApe_cliente(String ape_cliente) {
		this.ape_cliente = ape_cliente;
	}

	public String getDni_cliente() {
		return dni_cliente;
	}

	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}
	
	
	
	
}
