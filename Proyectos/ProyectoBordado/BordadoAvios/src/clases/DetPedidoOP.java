package clases;

public class DetPedidoOP {
	private int id_pedidoOP;
	private int id_det_pedidoOP;
	private int id_talla;
	private int cant_det_pedidoOP;
	
	public DetPedidoOP() {}

	public DetPedidoOP(int id_pedidoOP, int id_det_pedidoOP, int id_talla, int cant_det_pedidoOP) {
		super();
		this.id_pedidoOP = id_pedidoOP;
		this.id_det_pedidoOP = id_det_pedidoOP;
		this.id_talla = id_talla;
		this.cant_det_pedidoOP = cant_det_pedidoOP;
	}

	public int getId_pedidoOP() {
		return id_pedidoOP;
	}

	public void setId_pedidoOP(int id_pedidoOP) {
		this.id_pedidoOP = id_pedidoOP;
	}

	public int getId_det_pedidoOP() {
		return id_det_pedidoOP;
	}

	public void setId_det_pedidoOP(int id_det_pedidoOP) {
		this.id_det_pedidoOP = id_det_pedidoOP;
	}

	public int getId_talla() {
		return id_talla;
	}

	public void setId_talla(int id_talla) {
		this.id_talla = id_talla;
	}

	public int getCant_det_pedidoOP() {
		return cant_det_pedidoOP;
	}

	public void setCant_det_pedidoOP(int cant_det_pedidoOP) {
		this.cant_det_pedidoOP = cant_det_pedidoOP;
	}

	@Override
	public String toString() {
		return "DetPedidoOP [id_pedidoOP=" + id_pedidoOP + ", id_det_pedidoOP=" + id_det_pedidoOP + ", id_talla="
				+ id_talla + ", cant_det_pedidoOP=" + cant_det_pedidoOP + "]";
	}

	

	
	
	
}
