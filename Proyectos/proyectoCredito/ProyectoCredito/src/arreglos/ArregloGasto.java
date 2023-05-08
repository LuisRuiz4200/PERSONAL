package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.*;


public class ArregloGasto {
	
	private ArrayList<Gasto> arrGasto;
	
	public ArregloGasto(){
		arrGasto = new ArrayList <Gasto>();
		cargarGasto();
	}
	
	public int tamaño() {
		return arrGasto.size();
	}
	
	public void adicionar(Gasto g) {
		arrGasto.add(g);
	}
	
	public void eliminar(Gasto g) {
		arrGasto.remove(g);
	}
	
	public Gasto obtener(int x) {
		return arrGasto.get(x);
	}
	
	public Gasto buscar (int codigo) {
		
		Gasto g= null;
		
		for(int i = 0 ; i<tamaño();i++) {
			if(obtener(i).getCodigo()==codigo) {
				g=obtener(i);
			}
		}
		
		return g;
	}
	
	//Metodos de guardar y buscar 
	
	public void gabrarGasto () {
		
		PrintWriter pw;
		String texto;
		Gasto g;
		
		try {
			pw= new PrintWriter(new FileWriter("Gasto.txt"));
			
			for(int i=0;i<tamaño();i++) {
				g = obtener(i);
				texto = g.getCodigo() + ";" +
						g.getCliente() + ";" +
						g.getMotivo() + ";" + 
						g.getMonto() + ";" + 
						g.getFecha() + ";" +
						g.getCuota() + ";" +
						g.getInteres();
				
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
			br = new BufferedReader(new FileReader("Gasto.txt"));
			
			while((texto=br.readLine())!=null) {
				pos = texto.split(";");
				
				int codigo = Integer.parseInt(pos[0]);
				String cliente = pos[1];
				String motivo=pos[2];
				double monto= Double.parseDouble(pos[3]);
				String fecha= pos[4];
				int cuota= Integer.parseInt(pos[5]);
				double interes = Double.parseDouble(pos[6]);
				
				adicionar(new Gasto(codigo, cliente, motivo, monto, fecha,cuota,interes));
			}
			
			br.close();
			
		}catch(Exception e) {
			
		}
		
	}
}
