package arreglos;

import java.util.*;
import java.io.*;
import clases.*;
import reuzables.Custom;

public class ArregloIngresoAvio {

	private ArrayList<IngresoAvio> arrIngresoAvio;
	
	public ArregloIngresoAvio() {
		arrIngresoAvio = new ArrayList<IngresoAvio>();
		cargarIngresoAvios();
	}
	
	//METODOS BASICOS
	
	public int tamaño() {
		return arrIngresoAvio.size();
	}
	
	public IngresoAvio obtener(int i) {
		return arrIngresoAvio.get(i);
	}
	
	public void adicionar (IngresoAvio ingresoAvios) {
		arrIngresoAvio.add(ingresoAvios);
	}
	
	public void eliminar (IngresoAvio ingresoAvios) {
		arrIngresoAvio.remove(ingresoAvios);
	}
	
	public IngresoAvio buscar(String nroVale) {
		for(IngresoAvio ingresoAvio:arrIngresoAvio) {
			if(nroVale.equals(ingresoAvio.getNroVale())) {
				return ingresoAvio;
			}
		}
		
		return null;
	} 
	
	//METODOS DE LECTURA Y ESCRITURA
	
	public void grabarIngresoAvios() {
		PrintWriter pw = null;
		String texto;
		
		try {
			pw= new PrintWriter (new FileWriter("ingresoAvios.txt"));
			for (IngresoAvio ingresoAvios:arrIngresoAvio) {
				texto = ingresoAvios.getNroVale() + ";" +
						ingresoAvios.getNroOP() + ";" +
						ingresoAvios.getCodAvio() + ";" +
						ingresoAvios.getFechaAvio() + ";" +
						ingresoAvios.getCantAvio();
				
				pw.println(texto);
			}
		}catch(Exception e) {
			Custom.mensajeError(null, "Error al grabar contenido");
		}finally {
			pw.close();
		}
	}
	
	public void cargarIngresoAvios() {
		BufferedReader br;
		String linea;
		String[] texto;
		
		try {
			br = new BufferedReader (new FileReader("ingresoAvios.txt"));
			while((linea=br.readLine())!=null) {
				texto = linea.split(";");
				IngresoAvio ingresoAvios = new IngresoAvio(
						texto[0],
						Integer.parseInt(texto[1]),
						Integer.parseInt(texto[2]),
						texto[3],
						Integer.parseInt(texto[4])
						);
				arrIngresoAvio.add(ingresoAvios);
			}
			br.close();
		}catch (Exception e) {
			Custom.mensajeError(null, "Error al cargar contenido");
		}
		
		
	}
}
