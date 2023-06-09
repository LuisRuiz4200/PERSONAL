package arreglos;

import java.util.*;
import java.io.*;
import clases.*;
import reuzables.Custom;

public class ArregloOrdenProduccion {

	private ArrayList<OrdenProduccion> arrOrdenProd;
	
	public ArregloOrdenProduccion() {
		arrOrdenProd = new ArrayList<OrdenProduccion>();
		cargarOrdenProduccion();
	}
	
	//METODOS BASICOS
	
	public int tamano() {
		return arrOrdenProd.size();
	}
	
	public OrdenProduccion obtener(int i) {
		return arrOrdenProd.get(i);
	}
	
	public void adicionar (OrdenProduccion ordenProd) {
		arrOrdenProd.add(ordenProd);
	}
	
	public void eliminar (OrdenProduccion ordenProd) {
		arrOrdenProd.remove(ordenProd);
	}
	
	public OrdenProduccion buscar (int OP) {

		for (OrdenProduccion op : arrOrdenProd) {
			if (OP == op.getNroOp()) {
				return op;
			}
		}
		return null;
	}
	
	//METODOS DE LECTURA Y ESCRITURA
	public void grabarOrdenProduccion() {
		PrintWriter pw = null;
		String texto;
		
		try {
			pw= new PrintWriter (new FileWriter("ordenProduccion.txt"));
			for (OrdenProduccion ordenProd:arrOrdenProd) {
				texto = ordenProd.getNroOp() + ";" +
						ordenProd.getCodCliente() + ";" +
						ordenProd.getCodEstilo();
				
				pw.println(texto);
			}
		}catch(Exception e) {
			Custom.mensajeError(null, e.getMessage());
		}finally {
			pw.close();
		}
	}
	
	public void cargarOrdenProduccion() {
		BufferedReader br;
		String linea;
		String[] texto;
		
		try {
			br = new BufferedReader (new FileReader("ordenProduccion.txt"));
			while((linea=br.readLine())!=null) {
				texto = linea.split(";");
				OrdenProduccion ordenProd = new OrdenProduccion(
						Integer.parseInt(texto[0]),
						Integer.parseInt(texto[1]),
						Integer.parseInt(texto[2])
						);
				arrOrdenProd.add(ordenProd);
			}
			br.close();
		}catch (Exception e) {
			Custom.mensajeError(null, e.getMessage());
		}
		
		
	}
}
