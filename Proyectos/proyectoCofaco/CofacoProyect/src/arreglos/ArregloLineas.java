package arreglos;

import java.util.ArrayList;
import java.util.Collections;
import clases.*;
import java.io.*;

public class ArregloLineas  {
	//atributo privado
	private ArrayList<Linea> lineas;
	//constructor
	public ArregloLineas() {
		lineas= new ArrayList<Linea>();
		cargarLineas();
		Collections.sort(lineas);
	}
	//metodos de mantenimiento basicos 
	public int tamaño() {
		return lineas.size();
	}
	public void adicionar(Linea x) {
		lineas.add(x);
	}
	public void eliminar(Linea x) {
		lineas.remove(x);
	}
	public Linea obtener(int i) {
		return lineas.get(i);
	}
	public Linea buscar(String linea) {
		for(int i=0;i<tamaño();i++) {
			if(obtener(i).getLinea().equals(linea)) {
				return obtener(i);
			}
		}
		return null;
	}
	//metodos para grabar y cargar
	public void grabarLineas() {
		PrintWriter pw;
		String texto;
		Linea l;
		
		try {
			pw= new PrintWriter(new FileWriter("lineas.txt"));
			for(int i=0;i<tamaño();i++) {
				l=obtener(i);
				texto=l.getLinea() + ";" + 
						l.getSupervisor(); 
				pw.println(texto);
			}
			pw.close();
		}catch(Exception e) {
			
		}
		
	}
	public void cargarLineas() {
		BufferedReader br;
		String []s;
		String fila;
		String linea, supervisor;
		
		try {
			br=new BufferedReader(new FileReader("lineas.txt"));
			while((fila=br.readLine())!=null) {
				s=fila.split(";");
				linea=s[0];
				supervisor=s[1];
				
				adicionar(new Linea(linea, supervisor));
			}
			br.close();
		}catch (Exception e) {
			
		}
	}
}
