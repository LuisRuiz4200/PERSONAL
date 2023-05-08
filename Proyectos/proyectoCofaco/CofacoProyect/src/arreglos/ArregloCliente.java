package arreglos;

import java.util.ArrayList;
import java.io.*;
import clases.*;

public class ArregloCliente {
	//atributos privados
	private ArrayList <Cliente> cliente;
	//constructor
	public ArregloCliente() {
		cliente = new ArrayList <Cliente>();
		cargarCliente();
	}
	//metodos basicos
	public int tamaño() {
		return cliente.size();
	}
	public void adicionar(Cliente c) {
		cliente.add(c);
	}
	public void eliminar(Cliente c) {
		cliente.remove(c);
	}
	public Cliente obtener(int i) {
		return cliente.get(i);
	}
	public Cliente buscarCliente(String cliente) {
		for (int i=0;i<tamaño();i++) {
			if(obtener(i).getNombreCli().equals(cliente)) {
				return obtener(i);
			}
		}
		return null;
	}
	//metodos adicionales
	public String correlativo() {
		
		int numero=1001;
		
		if(tamaño()==0) {
			return "C" + numero;
		}else {
			//return (obtener(tamaño()-1).getCodigo()+1);
			return "C" + (numero + tamaño());
		}
	}
	//metodos de grabar y cargar
	public void grabarCliente() {
		PrintWriter pw;
		String texto;
		try {
			pw=new PrintWriter(new FileWriter("cliente.txt"));
			for(int i=0;i<tamaño();i++) {
				Cliente c=obtener(i);
				texto= c.getCodigo() + ";" + c.getNombreCli();
				pw.println(texto);
			}
			pw.close();
		}
		catch (Exception e) {
			
		}
		
	}
	public void cargarCliente() {
		BufferedReader br;
		String linea;
		String []s;
		String codigo,nombreCli;
		
		
		try {
			br=new BufferedReader(new FileReader("cliente.txt"));
			while(!((linea=br.readLine())==null)) {
				s=linea.split(";");
				codigo=s[0];
				nombreCli=s[1];
				
				adicionar(new Cliente(codigo,nombreCli));
			}
			br.close();
		}
		catch (Exception e) {
			
		}
	}
}
