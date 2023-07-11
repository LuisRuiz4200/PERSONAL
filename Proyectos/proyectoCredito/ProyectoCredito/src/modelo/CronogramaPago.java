package modelo;

import java.util.Date;

import lombok.Data;


@Data
public class CronogramaPago {
	
	private int id_deuda;
	private int id_crono_deuda;
	private int cuota_crono_pago;
	private double monto_crono_pago;
	private Date fecha_crono_pago;
	
}
