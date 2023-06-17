package arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import modelo.*;


public class ArregloPago {
	
	private ArrayList<Pago> arrPago;
	
	public ArregloPago(){
		arrPago = new ArrayList <Pago>();
		cargarPago();
	}
	
	public int tamaño() {
		return arrPago.size();
	}
	
	public void adicionar(Pago Pago) {
		arrPago.add(Pago);
	}
	
	public void eliminar(Pago p) {
		arrPago.remove(p);
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
	
	public double pagoTotal (String idCliente) {
		double res= -1;
		
		
		for(int i = 0 ; i<tamaño();i++) {
			if(obtener(i).getId_cliente().equals(idCliente)) {
				res += obtener(i).getMonto_pago() ;
			}
		}
		
		return res;
	}
	
	public void cargarEstado() {
		
		cargarPago();
		
		for(int i = 0 ; i<tamaño();i++) {
			obtener(i).setEstado_pago("REGISTRADO");
		}
		
		grabarPago();
		
	}
	
	
	//Metodos de guardar y buscar 
	
	public void grabarPago () {
		
		PrintWriter pw;
		String texto;
		Pago p;
		
		try {
			pw= new PrintWriter(new FileWriter("Pago.txt"));
			
			for(int i=0;i<tamaño();i++) {
				p = obtener(i);
				texto = p.getId_pago() + ";" +
						p.getId_cliente() + ";" +
						p.getMonto_pago() + ";" + 
						p.getFecha_pago() + ";" +
						p.getId_medioPago() + ";" +
						p.getEstado_pago() + ";";
				
				pw.println(texto);
				
			}
			pw.close();
		}catch(Exception e){
			
		}
		
	}
	
	public void cargarPago() {
		
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
				String fecha= pos[3];
				String medioPago = pos[4];
				String estado = pos[5];
				
				adicionar(new Pago(codigo, cliente,monto,fecha,medioPago,estado));
			}
			
			br.close();
			
		}catch(Exception e) {
			
		}
		
	}
}
