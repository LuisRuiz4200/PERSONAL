package modelo;


public class Deuda {
	
	private String id_deuda;
	private String id_cliente;
	private double monto_deuda;
	private int cuota_deuda;
	private String des_deuda;
	private double interes_deuda;
	private String fecha_deuda;
	private String estado_deuda;
	
	
	private double TEA = 0.55;
	private double TEM = Math.pow((1+ TEA),(30/360)) - 1;
	
	
	public Deuda() {}
	

	public Deuda(String id_deuda, String id_cliente, double monto_deuda, int cuota_deuda, String des_deuda,
			double interes_deuda, String fecha_deuda) {
		super();
		this.id_deuda = id_deuda;
		this.id_cliente = id_cliente;
		this.monto_deuda = monto_deuda;
		this.cuota_deuda = cuota_deuda;
		this.des_deuda = des_deuda;
		this.interes_deuda = interes_deuda;
		this.fecha_deuda = fecha_deuda;
	}

	
	public Deuda(String id_deuda, String id_cliente, double monto_deuda, int cuota_deuda, String des_deuda,
			double interes_deuda, String fecha_deuda, String estado_deuda) {
		super();
		this.id_deuda = id_deuda;
		this.id_cliente = id_cliente;
		this.monto_deuda = monto_deuda;
		this.cuota_deuda = cuota_deuda;
		this.des_deuda = des_deuda;
		this.interes_deuda = interes_deuda;
		this.fecha_deuda = fecha_deuda;
		this.estado_deuda = estado_deuda;
	}

	public String getId_deuda() {
		return id_deuda;
	}

	public void setId_deuda(String id_deuda) {
		this.id_deuda = id_deuda;
	}

	public String getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}

	public double getMonto_deuda() {
		return monto_deuda;
	}

	public void setMonto_deuda(double monto_deuda) {
		this.monto_deuda = monto_deuda;
	}

	public int getCuota_deuda() {
		return cuota_deuda;
	}

	public void setCuota_deuda(int cuota_deuda) {
		this.cuota_deuda = cuota_deuda;
	}

	public String getDes_deuda() {
		return des_deuda;
	}

	public void setDes_deuda(String des_deuda) {
		this.des_deuda = des_deuda;
	}

	public double getInteres_deuda() {
		return interes_deuda;
	}

	public void setInteres_deuda(double interes_deuda) {
		this.interes_deuda = interes_deuda;
	}
	
	public String getFecha_deuda() {
		return fecha_deuda;
	}
	
	public void setFecha_deuda(String fecha_deuda) {
		this.fecha_deuda = fecha_deuda;
	}
	
	public String getEstado_deuda () {
		return this.estado_deuda;
	}
	
	public void setEstado_deuda(String estado_deuda) {
		this.estado_deuda = estado_deuda;
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
		
		return nuevoInteres;
	}
	
	
	
}