package arreglos;

import java.util.ArrayList;
import java.io.*;
import clases.*;
import reuzables.Custom;

public class ArregloAvio {

	private ArrayList<Avio> arrAvio;
	
	public ArregloAvio() {
		arrAvio = new ArrayList<Avio>();
		cargarAvio();
	}
	
	//METODOS BASICOS
	public int tamano() {
		return arrAvio.size();
	}
	
	public Avio obtener(int i) {
		return arrAvio.get(i);
	}
	
	public void adicionar(Avio avio) {
		arrAvio.add(avio);
	}
	
	public void eliminar(Avio avio) {
		
		arrAvio.remove(avio);
	}
	
	
	// NO VEO LA NECESIDAD DE IMPLEMENTARLO POR EL MOMENTO
	public Avio buscar(int codAvio) {
		
		for (Avio av: arrAvio) {
			if (codAvio == av.getCodAvio()) {
				return av;
			}
		}
		return null;
	}
	
	//METODOS DE LECTURA Y ESCRITURA
	
	public void grabarAvio () {
		PrintWriter pw = null;
		String texto = null;
		
		try {
			
			pw = new PrintWriter (new FileWriter("avio.txt"));
			
			for (Avio av: arrAvio) {
				texto = av.getCodAvio() + ";" +
						av.getCodTipoAvio() + ";" +
						av.getDesAvio() + ";" +
						av.getMedidaAvio() + ";" +
						av.getCodUM();
				
				pw.println(texto);
			}
		
		}catch (Exception e) {
			Custom.mensajeError(null, "Error al grabar contenido");
		}finally {
			pw.close();
		}
		
	}
	
	
	public void cargarAvio() {
		BufferedReader br;
		String [] texto;
		String linea;
		Avio av;
		
		try {
			br = new BufferedReader(new FileReader("avio.txt"));
			while((linea=br.readLine()) != null) {
				texto= linea.split(";");
				av = new Avio(
						Integer.parseInt(texto[0]),
						Integer.parseInt(texto[1]),
						texto[2],
						texto[3],
						Integer.parseInt(texto[4])
						);			
				arrAvio.add(av);
			}
			br.close();
		}catch  (Exception e) {
			Custom.mensajeError(null, "Error al cargar contenido");
		};
	}
	
	
}

