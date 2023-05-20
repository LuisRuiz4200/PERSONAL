package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
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
	
	//CArgaR y grabar
	
	public void grabarF10() {}
	
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
			
		}catch(Exception e) {
			Custom.mensajeError(null,e.getMessage());
		}
	}
	
}
