package modelo;

import java.util.Date;

import lombok.Data;

@Data

public class Pago {
	
	private int id_pago;
	private int id_persona_prestatario;
	private double monto_pago;
	private Date fechaReg_pago;
	private Date fechaAct_pago;
	private int id_medioPago;
	private String estado_pago;	
	
	
}
