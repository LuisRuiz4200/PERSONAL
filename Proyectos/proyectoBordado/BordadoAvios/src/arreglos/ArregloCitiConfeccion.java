package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.CitiConfeccion;
import clases.CitiConfeccion;

public class ArregloCitiConfeccion {
private ArrayList<CitiConfeccion> arrCitiConfeccion;
	
	public ArregloCitiConfeccion() {
		arrCitiConfeccion = new ArrayList<CitiConfeccion>();
		cargarCitiConfeccion();
	}
	
	public int tamaño() {
		return arrCitiConfeccion.size();
	}
	
	public CitiConfeccion obtener(int i) {
		return arrCitiConfeccion.get(i);
	}
	
	public void adicionar(CitiConfeccion obj) {
		arrCitiConfeccion.add(obj);
	}
	
	public void eliminar(CitiConfeccion obj) {
		arrCitiConfeccion.remove(obj);
	}
	
	public void editar(CitiConfeccion obj) {
		
		for(CitiConfeccion x:arrCitiConfeccion) {
			if(x.getCod_citiConfeccion().equals(obj.getCod_citiConfeccion())) {
				
				x.setDes_citiConfeccion(obj.getDes_citiConfeccion());
				x.setEstado_citiConfeccion(obj.getEstado_citiConfeccion());
			}
		}
	}
	
	public CitiConfeccion buscar(String cod_citiConfeccion) {
		
		for(CitiConfeccion obj:arrCitiConfeccion) {
			if(obj.getCod_citiConfeccion().equals(cod_citiConfeccion)) {
				return obj;
			}
		}
		return null;
	}
	
	//METODOS PARA GRABAR Y CARGAR DATA
	
	public void grabarCitiConfeccion() {
		PrintWriter pw;
		String line;
		
		try {
			pw = new PrintWriter(new FileWriter("citiConfeccion.txt"));
			
			for (CitiConfeccion obj: arrCitiConfeccion) {
				line = obj.getCod_citiConfeccion() + ";" +
						obj.getDes_citiConfeccion() + ";" +
						obj.getEstado_citiConfeccion() + ";";
				pw.println(line);
			}
			pw.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}	
	public void cargarCitiConfeccion() {
		BufferedReader br;
		String line;
		CitiConfeccion citiConfeccion;
		
		try {
			br = new BufferedReader(new FileReader("citiConfeccion.txt"));
			citiConfeccion = new CitiConfeccion();
			
			while((line=br.readLine())!=null) {
				 String [] n=line.split(";");
				 String cod_citiConfeccion = n[0];
				 String des_citiConfeccion = n[1];
				 String estado_citiConfeccion = n[2];
				 
				 citiConfeccion = new CitiConfeccion(cod_citiConfeccion,des_citiConfeccion,estado_citiConfeccion);
				 
				 adicionar(citiConfeccion);
				
			}
			br.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
	}
}
