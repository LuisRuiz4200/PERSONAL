package arreglos;

import java.util.*;
import clases.*;
import reuzables.Custom;

import java.io.*;

public class ArregloTipoAvio {
	
	private ArrayList<TipoAvio> arrTipoAvio;
	
	public ArregloTipoAvio() {
		arrTipoAvio = new ArrayList<TipoAvio>();
		cargarTipoAvio();
	}
	
	//METODOS BASICOS
	
	public int tamano() {
		return arrTipoAvio.size();
	}
	
	public TipoAvio obtener (int i ) {
		return arrTipoAvio.get(i);
	}
	
	public void adicionar (TipoAvio tipoAvio) {
		arrTipoAvio.add(tipoAvio);
	}
	
	public void eliminar (TipoAvio tipoAvio) {
		arrTipoAvio.remove(tipoAvio);
	}
	
	public TipoAvio buscar(int codTipoAvio) {
		for(TipoAvio tipoAvio:arrTipoAvio) {
			if(codTipoAvio==tipoAvio.getCodTipoAvio()) {
				return tipoAvio;
			}
		}
		return null;
	}
	
	//METODOS DE LECTURA Y ESCRITURA
	
	public void grabarTipoAvio() {
		PrintWriter pw = null;
		String texto = null;
		
		try {
		
			pw= new PrintWriter(new FileWriter("tipoAvio.txt"));
		
			for (TipoAvio tipoAvio:arrTipoAvio) {
				texto = tipoAvio.getCodTipoAvio() + ";" +
						tipoAvio.getDesTipoAvio();
				
				pw.println(texto);
				
			}
			
		}catch(Exception e) {
			Custom.mensajeError(null, "Error al grabar el contenido");
		}finally {
			pw.close();
		}
	}
	
	public void cargarTipoAvio() {
		
		BufferedReader br;
		String [] texto;
		String linea;
		TipoAvio tipoAvio;
		
		try {
			br = new BufferedReader ( new FileReader("tipoAvio.txt"));
			while(!((linea=br.readLine())==null)) {
				texto = linea.split(";");
				tipoAvio = new TipoAvio (
						Integer.parseInt(texto[0]),
						texto[1]
						);
				arrTipoAvio.add(tipoAvio);
			}
			br.close();
		}catch(Exception e) {
			Custom.mensajeError(null, "Error al cargar el contenido");
		}
	}

}
