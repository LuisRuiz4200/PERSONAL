package arreglos;

import java.util.*;
import java.io.*;
import clases.*;
import reuzables.Custom;

public class ArregloEstiloOP {

	private ArrayList<EstiloOP> arrEstiloOP;
	
	public ArregloEstiloOP() {
		arrEstiloOP = new ArrayList<EstiloOP>();
		cargarEstiloOp();
	}
	
	//METODOS BASICOS
	
	public int tama�o() {
		return arrEstiloOP.size();
	}
	
	public EstiloOP obtener(int i) {
		return arrEstiloOP.get(i);
	}
	
	public void adicionar (EstiloOP estiloOP) {
		arrEstiloOP.add(estiloOP);
	}
	
	public void eliminar (EstiloOP estiloOP) {
		arrEstiloOP.remove(estiloOP);
	}
	
	public EstiloOP buscar(int codEstiloOP) {
		
		for(EstiloOP estiloOP:arrEstiloOP) {
			if(codEstiloOP==estiloOP.getCodEstiloOp()) {
				return estiloOP;
			}
		}
		return null;
	}
	
	//METODOS DE LECTURA Y ESCRITURA
	
	public void grabarEstiloOp() {
		PrintWriter pw = null;
		String texto;
		
		try {
			pw= new PrintWriter (new FileWriter("estiloOp.txt"));
			for (EstiloOP cliente:arrEstiloOP) {
				texto = cliente.getCodEstiloOp() + ";" +
						cliente.getDesEstiloOp() + ";" +
						cliente.getCodPrenda();
				
				pw.println(texto);
			}
		}catch(Exception e) {
			Custom.mensajeError(null, "Error al grabar contenido");
		}finally {
			pw.close();
		}
	}
	
	public void cargarEstiloOp() {
		BufferedReader br;
		String linea;
		String[] texto;
		
		try {
			br = new BufferedReader (new FileReader("estiloOp.txt"));
			while((linea=br.readLine())!=null) {
				texto = linea.split(";");
				EstiloOP estiloOp = new EstiloOP(
						Integer.parseInt(texto[0]),
						texto[1],
						Integer.parseInt(texto[2])
						);
				arrEstiloOP.add(estiloOp);
			}
			br.close();
		}catch (Exception e) {
			Custom.mensajeError(null, "Error al cargar contenido");
		}
		
		
	}
}
