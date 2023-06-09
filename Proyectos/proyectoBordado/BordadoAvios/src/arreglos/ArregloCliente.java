package arreglos;

import java.util.*;
import java.io.*;
import clases.*;
import reuzables.Custom;

public class ArregloCliente {

	private ArrayList<Cliente> arrCliente;
	
	public ArregloCliente() {
		arrCliente = new ArrayList<Cliente>();
		cargarCliente();
	}
	
	//METODOS BASICOS
	
	public int tamano() {
		return arrCliente.size();
	}
	
	public Cliente obtener(int i) {
		return arrCliente.get(i);
	}
	
	public void adicionar (Cliente cliente) {
		arrCliente.add(cliente);
	}
	
	public void eliminar (Cliente cliente) {
		arrCliente.remove(cliente);
	}
	
	public Cliente buscar (int codCliente) {
		for(Cliente c:arrCliente) {
			if(codCliente==c.getCodCliente()) {
				return c;
			}
		}
		return null;
	}
	
	public List<Cliente> lista(){
		
		return arrCliente.subList(0, tamano());
		
	}
	
	//METODOS DE LECTURA Y ESCRITURA
	
	public void grabarCliente() {
		PrintWriter pw = null;
		String texto;
		
		try {
			pw= new PrintWriter (new FileWriter("cliente.txt"));
			for (Cliente cliente:arrCliente) {
				texto = cliente.getCodCliente() + ";" +
						cliente.getDesCliente();
				
				pw.println(texto);
			}
		}catch(Exception e) {
			Custom.mensajeError(null, "Error al grabar contenido");
		}finally {
			pw.close();
		}
	}
	
	public void cargarCliente() {
		BufferedReader br;
		String linea;
		String[] texto;
		
		try {
			br = new BufferedReader (new FileReader("cliente.txt"));
			while((linea=br.readLine())!=null) {
				texto = linea.split(";");
				Cliente cliente = new Cliente(
						Integer.parseInt(texto[0]),
						texto[1]
						);
				arrCliente.add(cliente);
			}
			br.close();
		}catch (Exception e) {
			Custom.mensajeError(null, "Error al cargar contenido");
		}
		
		
	}
}
