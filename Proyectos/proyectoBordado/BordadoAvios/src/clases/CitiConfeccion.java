package clases;

public class CitiConfeccion {
	private String cod_citiConfeccion;
	private String des_citiConfeccion;
	private String estado_citiConfeccion;
	
	public CitiConfeccion() {
		
	}

	public CitiConfeccion(String cod_citiConfeccion, String des_citiConfeccion, String estado_citiConfeccion) {
		super();
		this.cod_citiConfeccion = cod_citiConfeccion;
		this.des_citiConfeccion = des_citiConfeccion;
		this.estado_citiConfeccion = estado_citiConfeccion;
	}

	public String getCod_citiConfeccion() {
		return cod_citiConfeccion;
	}

	public void setCod_citiConfeccion(String cod_citiConfeccion) {
		this.cod_citiConfeccion = cod_citiConfeccion;
	}

	public String getDes_citiConfeccion() {
		return des_citiConfeccion;
	}

	public void setDes_citiConfeccion(String des_citiConfeccion) {
		this.des_citiConfeccion = des_citiConfeccion;
	}

	public String getEstado_citiConfeccion() {
		return estado_citiConfeccion;
	}

	public void setEstado_citiConfeccion(String estado_citiConfeccion) {
		this.estado_citiConfeccion = estado_citiConfeccion;
	}
	
	
}
