package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.*;


public class ArregloDeuda {
	
	private ArrayList<Deuda> arrGasto;
	
	public ArregloDeuda(){
		arrGasto = new ArrayList <Deuda>();
		cargarGasto();
	}
	
	public int tama�o() {
		return arrGasto.size();
	}
	
	public void adicionar(Deuda g) {
		arrGasto.add(g);
	}
	
	public void eliminar(Deuda g) {
		arrGasto.remove(g);
	}
	
	public Deuda obtener(int x) {
		return arrGasto.get(x);
	}
	
	public Deuda buscar (String codigo) {
		
		Deuda g= null;
		
		for(int i = 0 ; i<tama�o();i++) {
			if(obtener(i).getId_deuda().equals(codigo)) {
				g=obtener(i);
			}
		}
		
		return g;
	}
	
	public double deudaTotal (String idCliente) {
		double res= -1;
		
		for(int i = 0 ; i<tama�o();i++) {
			if(obtener(i).getId_cliente().equals(idCliente)) {
				res += obtener(i).getMonto_deuda() * obtener(i).getInteres_deuda() + obtener(i).getMonto_deuda();
			}
		}
		
		return res;
	}
	
	public void cargarEstado() {
		
		for(int i = 0 ; i<tama�o();i++) {
			obtener(i).setEstado_deuda("REGISTRADO");
		}
		
		grabarGasto();
		
		
	}
	
	//Metodos de guardar y buscar 
	
	public void grabarGasto () {
		
		PrintWriter pw;
		String texto;
		Deuda g;
		
		try {
			pw= new PrintWriter(new FileWriter("Deuda.txt"));
			
			for(int i=0;i<tama�o();i++) {
				g = obtener(i);
				texto = g.getId_deuda() + ";" +
						g.getId_cliente() + ";" +
						g.getMonto_deuda() + ";" + 
						g.getCuota_deuda() + ";" + 
						g.getDes_deuda() + ";" +
						g.getInteres_deuda() + ";" +
						g.getFecha_deuda() + ";" +
						g.getEstado_deuda() + ";";
				
				pw.println(texto);
				
			}
			pw.close();
		}catch(Exception e){
			
		}
		
	}
	
	public void cargarGasto() {
		
		BufferedReader br;
		String texto;
		String[] pos;
		
		try {
			br = new BufferedReader(new FileReader("Deuda.txt"));
			
			while((texto=br.readLine())!=null) {
				pos = texto.split(";");
				
				String codigo = pos[0];
				String cliente = pos[1];
				double monto= Double.parseDouble(pos[2]);
				int cuota= Integer.parseInt(pos[3]);
				String motivo=pos[4];
				double interes = Double.parseDouble(pos[5]);
				String fecha= pos[6];
				String estado = pos[7];
				
				adicionar(new Deuda(codigo,cliente,monto,cuota,motivo,interes,fecha,estado));
			}
			
			br.close();
			
		}catch(Exception e) {
			
		}
		
	}
}
