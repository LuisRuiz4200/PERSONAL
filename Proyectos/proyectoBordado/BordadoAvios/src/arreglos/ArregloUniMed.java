package arreglos;

import java.util.*;
import clases.*;
import reuzables.Custom;

import java.io.*;

public class ArregloUniMed {
	
	private ArrayList<UnidadMedida> arrUniMed ;
	
	public ArregloUniMed() {
		arrUniMed = new ArrayList<UnidadMedida>();
		cargarUnidadMedida();
	}
	
	//METODOS BASICOS
	
	public int tamano() {
		return arrUniMed.size();
	}
	
	public UnidadMedida obtener(int i) {
		return arrUniMed.get(i);
	}
	
	public void adicionar (UnidadMedida UM) {
		arrUniMed.add(UM);
	}
	
	public void eliminar (UnidadMedida UM) {
		arrUniMed.remove(UM);
	}
	
	public UnidadMedida buscar(int codUM) {
		for(UnidadMedida UM : arrUniMed) {
			if (codUM==UM.getCodUM()) {
				return UM;
			}
		}
		return null;
	}
	
	//METODOS DE LECTURA Y ESCRITURA
	
	public void grabarUnidadMedida() {
		
		PrintWriter pw = null;
		String texto;
		
		try {
			pw = new PrintWriter(new FileWriter("unidadMedida.txt"));
			for (UnidadMedida UM:arrUniMed) {
				texto = UM.getCodUM() + ";" +
						UM.getDesUM();
				pw.println(texto);
			}
		}catch(Exception e) {
			Custom.mensajeError(null, "Error al grabar contenido");
		}finally {
			pw.close();
		}
		
	}
	
	public void cargarUnidadMedida() {
		
		BufferedReader br;
		String linea;
		String [] texto;
		
		try {
			br = new BufferedReader(new FileReader("unidadMedida.txt"));
			while((linea= br.readLine())!=null) {
				texto = linea.split(";");
				UnidadMedida UM = new UnidadMedida(
						Integer.parseInt(texto[0]),
						texto[1]
						);
				adicionar(UM);
			}
			br.close();
		}catch(Exception e){
			Custom.mensajeError(null, "Error al cargar contenido");
		}
		
	}
}
