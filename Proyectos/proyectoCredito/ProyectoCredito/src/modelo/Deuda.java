package modelo;

import java.text.DecimalFormat;
import java.util.Date;

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

public class Deuda {
	
	private int id_deuda;
	private int id__persona_prestatario;
	private int id_persona_prestamista;
	private double monto_deuda;
	private int cuota_deuda;
	private String des_deuda;
	private double interes_deuda;
	private Date fechaReg_deuda = null;
	private Date fechaAct_deuda = null;
	private String estado_deuda;
	
	
	private double TEA = 0.55;
	private double TEM = Math.pow((1+ TEA),(30/360)) - 1;
	

	
	public double getTotal(double monto, int cuota) {
		double res = 0;
		res = Double.parseDouble(new DecimalFormat("0.00").format(monto * getInteresGenerado(cuota,monto) + monto));
		return res;
	}


	public double getInteresGenerado(double cuota, double monto) {
		
		double tasa = 0.037196338;//A1
		double nper = cuota;//B1
		double va = monto;//C1
		
		//=(A1*(1+A1)^B1)*C1/(((1+A1)^B1)-1)
		
		double nuevoInteres =  0;
		double nuevoMontoMensual = (tasa * Math.pow((1+tasa),nper))*va/((Math.pow((1+tasa),nper))-1);
		
		if (cuota>1) {
			//
			nuevoInteres = (nuevoMontoMensual - (monto/cuota))/(monto/cuota)*100;
		}
		
		return nuevoInteres/100;
	}
}
