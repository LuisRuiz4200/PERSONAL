package clases;

public class Talla {
	
	
	
	private int id_talla;
	private String des_talla;
	
	
	public Talla() {}
	
	public Talla(int id_talla, String des_talla) {
		super();
		this.id_talla = id_talla;
		this.des_talla = des_talla;
	}
	
	public int getId_talla() {
		return id_talla;
	}

	public void setId_talla(int id_talla) {
		this.id_talla = id_talla;
	}

	public String getDes_talla() {
		return des_talla;
	}

	public void setDes_talla(String des_talla) {
		this.des_talla = des_talla;
	}
	
	
	
	
}
