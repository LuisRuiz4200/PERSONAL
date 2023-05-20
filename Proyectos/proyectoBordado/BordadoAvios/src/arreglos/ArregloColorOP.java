package arreglos;

import java.util.*;
import java.io.*;
import clases.*;
import reuzables.Custom;

public class ArregloColorOP {

	private ArrayList<ColorOP> arrColorOP;
	
	public ArregloColorOP() {
		arrColorOP = new ArrayList<ColorOP>();
		cargarColorOP();
	}
	
	//METODOS BASICOS
	
	public int tamano() {
		return arrColorOP.size();
	}
	
	public ColorOP obtener(int i) {
		return arrColorOP.get(i);
	}
	
	public void adicionar (ColorOP colorOP) {
		arrColorOP.add(colorOP);
	}
	
	public void eliminar (ColorOP colorOP) {
		arrColorOP.remove(colorOP);
	}
	
	public ColorOP buscar(int nroOP , int  codColorOP) {
		
		for (ColorOP color : arrColorOP) {
			if(nroOP == color.getNroOP() && codColorOP == color.getCodColorOP()) {
				return color;
			}
		}
		
		return null;
		
	}
	
	//METODOS DE LECTURA Y ESCRITURA
	
	public void grabarColorOP() {
		PrintWriter pw = null;
		String texto;
		
		try {
			pw= new PrintWriter (new FileWriter("colorOP.txt"));
			for (ColorOP ordenProd:arrColorOP) {
				texto = ordenProd.getNroOP() + ";" +
						ordenProd.getCodColorOP() + ";" +
						ordenProd.getDesColorOP();
				
				pw.println(texto);
			}
		}catch(Exception e) {
			Custom.mensajeError(null, e.getMessage());
		}finally {
			pw.close();
		}
	}
	
	public void cargarColorOP() {
		BufferedReader br;
		String linea;
		String[] texto;
		
		try {
			br = new BufferedReader (new FileReader("colorOP.txt"));
			while((linea=br.readLine())!=null) {
				texto = linea.split(";");
				ColorOP colorOp = new ColorOP(
						Integer.parseInt(texto[0]),
						Integer.parseInt(texto[1]),
						texto[2]
						);
				arrColorOP.add(colorOp);
			}
			br.close();
		}catch (Exception e) {
			Custom.mensajeError(null, e.getMessage() + " " + e.getLocalizedMessage() + e.getCause());
		}
		
		
	}
}
