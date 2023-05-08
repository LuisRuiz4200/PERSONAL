package arreglos;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;
import clases.*;

public class ArregloColaborador {
	//atributo privado 
	private ArrayList<Colaborador> colaborador;
	//constructor 
	public ArregloColaborador() {
		colaborador=new ArrayList<Colaborador>();
		cargarColaborador();
	}
	//metodos de mantenimiento 
	public int tamaño() {
		return colaborador.size();
	}
	public void adicionar(Colaborador c) {
		colaborador.add(c);
	}
	public void eliminar (Colaborador c) {
		colaborador.remove(c);
	}
	public Colaborador obtener(int x) {
		return colaborador.get(x);
	}
	public Colaborador buscar(int codigo) {
		for(int i=0;i<tamaño();i++) {
			if(obtener(i).getCodigo()==codigo) {
				return obtener(i);
			}
		}
		return null;
	}
	//metodos de grabar y cargar
	
	public void grabarColaborador() {
		PrintWriter pw;
		String linea;
		
		try {
			pw= new PrintWriter(new FileWriter("colaborador.txt"));
			
			for(int i=0;i<tamaño();i++) {
				
				Colaborador col= obtener(i);
				
				linea= col.getCodigo() + ";" +
						col.getNombre() + ";" +
						col.getApellido()+ ";" +
						col.getTipo();
						
				pw.println(linea);
			}
			pw.close();
		}catch(Exception e) {
			
		}
	}
	public void cargarColaborador() {
		BufferedReader  br;
		String linea;
		int codigo;
		String nombre, apellido,tipo;
		
		try {
			
			br= new BufferedReader(new FileReader("colaborador.txt"));
			
			while ((linea=br.readLine())!=null) {
				
				String[] o= linea.split(";");
				
				codigo=Integer.parseInt(o[0]);
				nombre=o[1];
				apellido=o[2];
				tipo=o[3];
				
				adicionar(new Colaborador(codigo,nombre,apellido,tipo));
			}
			br.close();
			
			
		}catch(Exception e) {
			
		}
	}
	
}
