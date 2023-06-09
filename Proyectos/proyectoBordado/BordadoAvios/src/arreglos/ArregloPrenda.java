package arreglos;

import java.util.*;
import clases.*;
import reuzables.Custom;

import java.io.*;

public class ArregloPrenda {
	
	private ArrayList<Prenda> arrPrenda;
	
	public ArregloPrenda() {
		arrPrenda = new ArrayList<Prenda>();
		cargarPrenda();
	}
	
	//METODOS BASICOS
	
	public int tamano() {
		return arrPrenda.size();
	}
	
	public Prenda obtener(int i) {
		return arrPrenda.get(i);
	}
	
	public void adicionar(Prenda prenda) {
		arrPrenda.add(prenda);
	}
	
	public void eliminar (Prenda prenda) {
		arrPrenda.remove(prenda);
	}
	
	public Prenda buscar(int codPrenda) {
		for(Prenda prenda:arrPrenda) {
			if(codPrenda==prenda.getCodPrenda()) {
				return prenda;
			}
		}
		return null;
	}
	
	//METODOS DE LECTURA Y ESCRITURA
	
	public void grabarPrenda() {
		PrintWriter pw = null;
		String texto;
		
		try {
			pw = new PrintWriter(new FileWriter("prenda.txt"));
			
			for (Prenda prenda: arrPrenda) {
				texto = prenda.getCodPrenda() + ";" +
						prenda.getDesPrenda();
				
				pw.println(texto);
			}
			
		}catch(Exception e) {
			Custom.mensajeError(null, "Error de grabaci�n");
		}finally {
			pw.close();
		}
	}
	
	public void cargarPrenda() {
		BufferedReader br;
		String linea;
		String [] texto;
		
		try {
			br = new BufferedReader(new FileReader("prenda.txt"));
			while((linea= br.readLine())!=null) {
				texto = linea.split(";");
				Prenda prenda = new Prenda(
						Integer.parseInt(texto[0]),
						texto[1]
						);
				adicionar(prenda);
			}
			br.close();
			
		}catch (Exception e) {
			Custom.mensajeError(null, "Error al cargar objeto");
		}
	}
}
