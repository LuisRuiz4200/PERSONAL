package modelo;

public class MedioPago {
	
	private int id_medioPago;
	private String des_medioPago;
	
	public MedioPago() {}

	public MedioPago(int id_medioPago, String des_medioPago) {
		this.id_medioPago = id_medioPago;
		this.des_medioPago = des_medioPago;
	}

	public int getId_medioPago() {
		return id_medioPago;
	}

	public void setId_medioPago(int id_medioPago) {
		this.id_medioPago = id_medioPago;
	}

	public String getDes_medioPago() {
		return des_medioPago;
	}

	public void setDes_medioPago(String des_medioPago) {
		this.des_medioPago = des_medioPago;
	}
	
	
	
	
}
