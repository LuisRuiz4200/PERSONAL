package arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import modelo.*;

public class ArregloDeudor {
	
	private ArrayList <Deudor>arrCliente;
	
	public ArregloDeudor() {
		arrCliente = new ArrayList<Deudor>();
		cargarDeudor();
	}
	
	public int tamano() {
		return arrCliente.size();
	}
	
	public void adicionar(Deudor obj) {
		arrCliente.add(obj);
	}
	
	public void eliminar (int id) {
		Deudor obj  = buscar (id);
		arrCliente.remove(obj);
	}
	
	public void editar(Deudor obj) {
		Deudor objDeudor = buscar(obj.getId_deudor());
		objDeudor.setNom_deudor(obj.getNom_deudor());
		objDeudor.setApe_deudor(obj.getApe_deudor());
		objDeudor.setDni_deudor(obj.getDni_deudor());
	}
	
	public Deudor obtener(int x) {
		return arrCliente.get(x);
	}
	
	public List<Deudor> listar(){
		return arrCliente.subList(0, tamano());
	}
	
	public Deudor buscar (int codigo) {
		for (int i=0;i<tamano();i++) {
			if(obtener(i).getId_deudor()==codigo) {
				return obtener(i);
			}
		}
		return null;
	}
	
	//metodos de grabar y cargar 
	
	public void grabarDeudor() {
		PrintWriter pw;
		String texto;
		Deudor c;
		
		try {
			pw= new PrintWriter(new FileWriter("Cliente.txt"));
			
			for(int i=0;i<tamano();i++) {
				c = obtener(i);
				
				texto = c.getId_deudor() + ";" +
						c.getNom_deudor() + ";" + 
						c.getApe_deudor() + ";" +
						c.getDni_deudor() + ";";
				
				pw.println(texto);
			}
			pw.close();
			
		}catch (Exception e) {
			
		}
	}
	
	public void cargarDeudor() {
		BufferedReader br;
		String texto;
		String [] pos;
		
		try {
			br = new BufferedReader(new FileReader("Cliente.txt"));
			
			while((texto=br.readLine())!=null) {
				pos = texto.split(";");
				
				int codigo =Integer.parseInt( pos[0]);
				String nombre = pos[1];
				String apellido = pos [2];
				String dni = pos [3];
				
				Deudor obj = new Deudor();
				obj.setId_deudor(codigo);
				obj.setNom_deudor(nombre);
				obj.setApe_deudor(apellido);
				obj.setDni_deudor(dni);
				
				adicionar(obj);
			}
			br.close();	
		}catch(Exception e) {
			
		}
	}
	
	
}
