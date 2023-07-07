package arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import modelo.*;


public class ArregloPago {
	
	private ArrayList<Pago> arrPago;
	
	public ArregloPago(){
		arrPago = new ArrayList <Pago>();
		cargarData();
	}
	
	public int tamaño() {
		return arrPago.size();
	}
	
	public void adicionar(Pago Pago) {
		arrPago.add(Pago);
	}
	
	public void eliminar(String id) {
		
		Pago obj =buscar(id);
		
		arrPago.remove(obj);
	}
	
	public Pago obtener(int x) {
		return arrPago.get(x);
	}
	
	public Pago buscar (String codigo) {
		
		Pago g= null;
		
		for(int i = 0 ; i<tamaño();i++) {
			if(obtener(i).getId_pago().equals(codigo)) {
				g=obtener(i);
			}
		}
		
		return g;
	}
	
	public double pagoTotal (String idDeudor) {
		double res= -1;
		
		
		for(int i = 0 ; i<tamaño();i++) {
			if(obtener(i).getId_deudor().equals(idDeudor)) {
				res += obtener(i).getMonto_pago() ;
			}
		}
		
		return res;
	}
	
	public void cargarEstado() {
		
		cargarData();
		
		for(int i = 0 ; i<tamaño();i++) {
			obtener(i).setEstado_pago("REGISTRADO");
		}
		
		grabarData();
		
	}
	
	
	//Metodos de guardar y buscar 
	
	public void grabarData () {
		
		PrintWriter pw;
		String texto;
		Pago p;
		
		try {
			pw= new PrintWriter(new FileWriter("Pago.txt"));
			
			for(int i=0;i<tamaño();i++) {
				p = obtener(i);
				texto = p.getId_pago() + ";" +
						p.getId_deudor() + ";" +
						p.getMonto_pago() + ";" + 
						p.getFechaReg_pago() + ";" +
						p.getFechaAct_pago() + ";" +
						p.getId_medioPago() + ";" +
						p.getEstado_pago() + ";";
				
				pw.println(texto);
				
			}
			pw.close();
		}catch(Exception e){
			
		}
		
	}
	
	public void cargarData() {
		
		BufferedReader br;
		String texto;
		String[] pos;
		
		try {
			br = new BufferedReader(new FileReader("Pago.txt"));
			
			while((texto=br.readLine())!=null) {
				pos = texto.split(";");
				
				String codigo = pos[0];
				String cliente = pos[1];
				double monto= Double.parseDouble(pos[2]);
				Date fechaReg= new SimpleDateFormat().parse(pos[3]);
				Date fechaAct= new SimpleDateFormat().parse(pos[4]);
				String medioPago = pos[5];
				String estado = pos[6];
			
				Pago obj  = new Pago ();
				obj.setId_pago(codigo);
				obj.setId_deudor(cliente);
				obj.setMonto_pago(monto);
				obj.setFechaReg_pago(fechaReg);
				obj.setFechaAct_pago(fechaAct);
				obj.setId_medioPago(medioPago);
				obj.setEstado_pago(estado);
				
				adicionar(obj);
				
				
			}
			
			br.close();
			
		}catch(Exception e) {
			
		}
		
	}
}
