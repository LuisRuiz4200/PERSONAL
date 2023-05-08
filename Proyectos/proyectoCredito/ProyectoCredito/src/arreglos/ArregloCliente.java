package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.*;

public class ArregloCliente {
	
	private ArrayList <Cliente>arrCliente;
	
	public ArregloCliente() {
		arrCliente = new ArrayList<Cliente>();
		cargarCliente();
	}
	
	public int tama�o() {
		return arrCliente.size();
	}
	
	public void adicionar(Cliente c) {
		arrCliente.add(c);
	}
	public void eliminar (Cliente c) {
		arrCliente.remove(c);
	}
	public Cliente obtener(int x) {
		return arrCliente.get(x);
	}
	
	public Cliente buscar (String codigo) {
		for (int i=0;i<tama�o();i++) {
			if(obtener(i).getCodigo().equals(codigo)) {
				return obtener(i);
			}
		}
		return null;
	}
	
	//metodos de grabar y cargar 
	
	public void grabarCliente() {
		PrintWriter pw;
		String texto;
		Cliente c;
		
		try {
			pw= new PrintWriter(new FileWriter("Cliente.txt"));
			
			for(int i=0;i<tama�o();i++) {
				c = obtener(i);
				
				texto = c.getCodigo() + ";" +
						c.getNombre() + ";" + 
						c.getApellido() + ";" +
						c.getDni();
				
				pw.println(texto);
			}
			pw.close();
			
		}catch (Exception e) {
			
		}
		
	}
	
	public void cargarCliente() {
		BufferedReader br;
		String texto;
		String [] pos;
		
		try {
			br = new BufferedReader(new FileReader("Cliente.txt"));
			
			while((texto=br.readLine())!=null) {
				pos = texto.split(";");
				
				String codigo = pos[0];
				String nombre = pos[1];
				String apellido = pos [2];
				String dni = pos [3];
				
				adicionar(new Cliente(codigo,nombre,apellido,dni));
			}
			br.close();
			
		}catch(Exception e) {
			
		}
		
		
	}
	
	
}