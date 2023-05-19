package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.CitiAcabado;

public class ArregloCitiAcabado {
	
	private ArrayList<CitiAcabado> arrCitiAcabado;
	
	public ArregloCitiAcabado() {
		arrCitiAcabado = new ArrayList<CitiAcabado>();
		cargarCitiAcabado();
	}
	
	public int tamaño() {
		return arrCitiAcabado.size();
	}
	
	public CitiAcabado obtener(int i) {
		return arrCitiAcabado.get(i);
	}
	
	public void adicionar(CitiAcabado obj) {
		arrCitiAcabado.add(obj);
	}
	
	public void eliminar(CitiAcabado obj) {
		arrCitiAcabado.remove(obj);
	}
	

	public void editar(CitiAcabado obj) {
		
		for(CitiAcabado x:arrCitiAcabado) {
			if(x.getCod_citiAcabado().equals(obj.getCod_citiAcabado())) {
				
				x.setDes_citiAcabado(obj.getDes_citiAcabado());
				x.setEstado_citiAcabado(obj.getEstado_citiAcabado());
			}
		}
	}
	
	public CitiAcabado buscar(String cod_citiAcabado) {
		
		for(CitiAcabado obj:arrCitiAcabado) {
			if(obj.getCod_citiAcabado().equals(cod_citiAcabado)) {
				return obj;
			}
		}
		return null;
	}
	
	//METODOS PARA GRABAR Y CARGAR DATA
	
	public void grabarCitiAcabado() {
		PrintWriter pw;
		String line;
		
		try {
			pw = new PrintWriter(new FileWriter("citiAcabado.txt"));
			
			for (CitiAcabado obj: arrCitiAcabado) {
				line = obj.getCod_citiAcabado() + ";" +
						obj.getDes_citiAcabado() + ";" +
						obj.getEstado_citiAcabado() + ";";
				
				pw.println(line);
			}
			pw.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}	
	public void cargarCitiAcabado() {
		BufferedReader br;
		String line;
		CitiAcabado citiAcabado;
		
		try {
			br = new BufferedReader(new FileReader("citiAcabado.txt"));
			citiAcabado = new CitiAcabado();
			
			while((line=br.readLine())!=null) {
				 String [] n=line.split(";");
				 String cod_citiAcabado = n[0];
				 String des_citiAcabado = n[1];
				 String estado_citiAcabado = n[2];
				 
				 citiAcabado = new CitiAcabado(cod_citiAcabado,des_citiAcabado,estado_citiAcabado);
				 
				 adicionar(citiAcabado);
				
			}
			br.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
	}
	
}
