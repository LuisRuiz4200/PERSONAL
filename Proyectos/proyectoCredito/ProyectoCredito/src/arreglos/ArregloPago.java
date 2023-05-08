package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.*;


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
	
	public Pago buscar (int codigo) {
		
		Pago g= null;
		
		for(int i = 0 ; i<tamaño();i++) {
			if(obtener(i).getCodigo()==codigo) {
				g=obtener(i);
			}
		}
		
		return g;
	}
	
	//Metodos de guardar y buscar 
	
	public void gabrarPago () {
		
		PrintWriter pw;
		String texto;
		Pago p;
		
		try {
			pw= new PrintWriter(new FileWriter("Pago.txt"));
			
			for(int i=0;i<tamaño();i++) {
				p = obtener(i);
				texto = p.getCodigo() + ";" +
						p.getCliente() + ";" +
						p.getFecha() + ";" + 
						p.getAbono();
				
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
				
				int codigo = Integer.parseInt(pos[0]);
				String cliente = pos[1];
				String fecha= pos[2];
				double abono= Double.parseDouble(pos[3]);
				
				adicionar(new Pago(codigo, cliente,fecha,abono));
			}
			
			br.close();
			
		}catch(Exception e) {
			
		}
		
	}
}
