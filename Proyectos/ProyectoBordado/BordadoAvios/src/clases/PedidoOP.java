package clases;

import java.util.Date;

public class PedidoOP {
	private int id_pedidoOP;
	private int cod_programaAcabado;
	private String obs_pedidoOP;
	private Date fechaReg_pedidoOP;
	private Date fechaAct_pedidoOP;
	private String estado_pedidoOP;
	
	public PedidoOP() {}

	public PedidoOP(int id_pedidoOP, int cod_programaAcabado, String obs_pedidoOP, Date fechaReg_pedidoOP,
			Date fechaAct_pedidoOP, String estado_pedidoOP) {
		super();
		this.id_pedidoOP = id_pedidoOP;
		this.cod_programaAcabado = cod_programaAcabado;
		this.obs_pedidoOP = obs_pedidoOP;
		this.fechaReg_pedidoOP = fechaReg_pedidoOP;
		this.fechaAct_pedidoOP = fechaAct_pedidoOP;
		this.estado_pedidoOP = estado_pedidoOP;
	}

	public int getId_pedidoOP() {
		return id_pedidoOP;
	}

	public void setId_pedidoOP(int id_pedidoOP) {
		this.id_pedidoOP = id_pedidoOP;
	}

	public int getCod_programaAcabado() {
		return cod_programaAcabado;
	}

	public void setCod_programaAcabado(int cod_programaAcabado) {
		this.cod_programaAcabado = cod_programaAcabado;
	}

	public String getObs_pedidoOP() {
		return obs_pedidoOP;
	}

	public void setObs_pedidoOP(String obs_pedidoOP) {
		this.obs_pedidoOP = obs_pedidoOP;
	}

	public Date getFechaReg_pedidoOP() {
		return fechaReg_pedidoOP;
	}

	public void setFechaReg_pedidoOP(Date fechaReg_pedidoOP) {
		this.fechaReg_pedidoOP = fechaReg_pedidoOP;
	}

	public Date getFechaAct_pedidoOP() {
		return fechaAct_pedidoOP;
	}

	public void setFechaAct_pedidoOP(Date fechaAct_pedidoOP) {
		this.fechaAct_pedidoOP = fechaAct_pedidoOP;
	}

	public String getEstado_pedidoOP() {
		return estado_pedidoOP;
	}

	public void setEstado_pedidoOP(String estado_pedidoOP) {
		this.estado_pedidoOP = estado_pedidoOP;
	}

	@Override
	public String toString() {
		return "PedidoOP [id_pedidoOP=" + id_pedidoOP + ", cod_programaAcabado=" + cod_programaAcabado
				+ ", obs_pedidoOP=" + obs_pedidoOP + ", fechaReg_pedidoOP=" + fechaReg_pedidoOP + ", fechaAct_pedidoOP="
				+ fechaAct_pedidoOP + ", estado_pedidoOP=" + estado_pedidoOP + "]";
	}

	
	
	
	
	
}
