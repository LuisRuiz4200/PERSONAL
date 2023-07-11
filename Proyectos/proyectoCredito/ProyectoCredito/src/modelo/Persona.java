package modelo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Persona {
	
	private int id_persona;
	private String nom_persona;
	private String ape_persona;
	private String dni_persona;
	private Date fechaReg_persona;
	private Date fechaAct_persona;
	private String estado_persona;
	
	
	
}
