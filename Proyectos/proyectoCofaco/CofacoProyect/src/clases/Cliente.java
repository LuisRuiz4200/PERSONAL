package clases;

public class Cliente {
	//atributos privados
	private String codigo;
	private String nombreCli;
	//connstructor
	public Cliente () {
		
	}
	public Cliente (String codigo, String nombreCli) {
		this.codigo=codigo;
		this.nombreCli=nombreCli;
	}
	//setters y getter
	public void setCodigo(String codigo) {
		this.codigo=codigo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setNombreCli(String nombreCli) {
		this.nombreCli=nombreCli;
	}
	public String getNombreCli() {
		return nombreCli;
	}
	
}
