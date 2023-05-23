package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.F10;
import reuzables.Custom;

public class ArregloF10 {
	private ArrayList<F10> arrF10;
	
	public ArregloF10() {
		arrF10 = new ArrayList<F10>();
		cargarF10();
	}
	
	public int tamano() {
		return arrF10.size();
	}
	
	public void adicionar(F10 obj) {
		arrF10.add(obj);
	}
	
	public void eliminar(F10 obj) {
		arrF10.remove(obj);
	}
	
	public F10 obtener(int x) {
		return arrF10.get(x);
	}
	
	public F10 buscar(int id) {
		for (F10 obj:arrF10) {
			if (obj.getId_F10()==id) {
				return obj;
			}
		}
		return null;
	}
	
	public F10 buscarPorNroOPYColorOP(int nroOP, String colorOP) {
		for (F10 obj:arrF10) {
			if (obj.getNroOP_F10()==nroOP && obj.getColor_F10().equals(colorOP)) {
				return obj;
			}
		}
		return null;
	}
	
	public int correlativo() {
		int res = 0;
		
		if (arrF10.size()==0) {
			res = 1;
		}
		
		for (F10 obj:arrF10) {
			res = obj.getId_F10() + 1;
		}
		
		return res;
	}
	
	//CArgaR y grabar
	
	public void grabarF10() {
		PrintWriter pr;
		String linea;
		
		try {
			pr = new PrintWriter(new FileWriter("F10.txt"));
			for (F10 obj: arrF10) {
				linea = obj.getId_F10() + ";" +
						obj.getNroOP_F10() + ";" +
						obj.getCliente_F10() + ";" +
						obj.getEstilo_F10() + ";" +
						obj.getPrenda_F10() + ";" +
						obj.getColor_F10() + ";";
				
				pr.println(linea);
			}
			pr.close();
		}catch(Exception e){
			
		}
		
	}
	
	public void cargarF10() {
		BufferedReader br ;
		
		try {
			br = new BufferedReader(new FileReader("F10.txt"));
			String[] linea;
			String texto;
			while((texto = br.readLine())!=null) {
				linea = texto.split(";");
				int id = Integer.parseInt(linea[0]);
				int nroOP =Integer.parseInt(linea[1]);
				String cliente = linea[2];
				String estilo = linea[3];
				String prenda = linea [4];
				String color = linea [5];
				
				F10 obj = new F10(id,nroOP,cliente,estilo,prenda,color);
				
				arrF10.add(obj);
			}
			br.close();
			
		}catch(Exception e) {
			Custom.mensajeError(null,e.getMessage() + "\n ArregloF10, cargarF10");
		}
	}
	
}
