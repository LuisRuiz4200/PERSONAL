package clases;

public class IngresoSalida implements Comparable<IngresoSalida> {
	//atributos privados
	private int item;
	private String linea;
	private String supervisor;
	private int nroOp;
	private String color;
	private String cliente;
	private int ingreso;
	private String fecha;
	private int subCorte;
	private int salida;
	private int devolucion;
	//constructor
	public IngresoSalida() {
		
	}
	public IngresoSalida(int item, String fecha, String supervisor, String linea, int nroOp, int subCorte, String color, String cliente, int ingreso, int salida, int devolucion) {
		this.item=item;
		this.fecha= fecha;
		this.supervisor= supervisor;
		this.linea=linea;
		this.nroOp= nroOp;
		this.subCorte=subCorte;
		this.color=color;
		this.cliente=cliente;
		this.ingreso=ingreso;
		this.salida=salida;
		this.devolucion=devolucion;
	}
	//set y get 
	
	public void setITem(int item) {
		this.item=item;
	}
	public int getItem() {
		return item;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public int getNroOp() {
		return nroOp;
	}
	public void setNroOp(int nroOp) {
		this.nroOp = nroOp;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getIngreso() {
		return ingreso;
	}
	public void setIngreso(int cantidad) {
		this.ingreso = cantidad;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getSubCorte() {
		return subCorte;
	}
	public void setSubCorte(int subCorte) {
		this.subCorte = subCorte;
	}
	public int getSalida () {
		return salida;
	}
	public void setSalida(int salida) {
		this.salida=salida;
	}
	public int getDevolucion () {
		return devolucion;
	}
	public void setDevolucion(int devolucion) {
		this.devolucion=devolucion;
	}
	
	//metodos adicionales 
	
	public String faltante() {
		if(getIngreso()==0) {
			return "Sin ingreso";
		}else if(getSalida()==0) {
			return "Sin salida";
		}else {

			return getIngreso() - getSalida() - getDevolucion() + "";
		}
			
	}
	@Override
	public int compareTo(IngresoSalida o) {
		if(this.nroOp<o.nroOp && this.subCorte<o.subCorte) {
			return -1;
		}else {
			if(this.nroOp>o.nroOp && this.subCorte<o.subCorte) {
				return 1;
			}else {
				return 0;
			}
		}
	}
	
}
