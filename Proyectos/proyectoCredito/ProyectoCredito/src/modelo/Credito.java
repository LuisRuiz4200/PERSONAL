package modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Credito extends MedioPago {
	
	private String nroTarjeta;
	private int nroCuota;
	
	
	
}
