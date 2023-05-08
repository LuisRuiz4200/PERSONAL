package arreglos;

import clases.*;
import java.util.Collections;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.*;

public class ArregloNroOp {
	
	private ArrayList <NroOp> nroOp;
	
	public ArregloNroOp () {
		nroOp= new ArrayList<NroOp>();
		cargarNroOp();
		Collections.sort(nroOp);
	}
	
	//metodos de mantenimiento 
	
	public int tamaño() {
		return nroOp.size();
	}
	public void adicionar (NroOp x) {
		nroOp.add(x);
	}
	public void eliminar (NroOp x) {
		nroOp.remove(x);
	}
	public NroOp obtener(int i) {
		return nroOp.get(i);
	}
	public NroOp buscar(int nroOp) {
		for (int i=0;i<tamaño();i++) {
			if (obtener(i).getNroOp()==  nroOp) {
				return obtener(i);
			}
		}

		return null;
	}
	//metodo de grabar y cargar
	
	public void grabarNroOp() {
		
		PrintWriter pw;
		String texto;
		
		try {
			pw= new PrintWriter(new FileWriter("nroOp.txt"));
			
			for(int i=0;i<tamaño();i++) {
				NroOp op= obtener(i);
				
				texto= op.getNroOp() + "" ;
				
				pw.println(texto);
			}
			pw.close();
			
		}catch(Exception e) {
			
		}
	}
	
	public void cargarNroOp() {
		BufferedReader br;
		
		String linea;
		
		try {
			br = new BufferedReader (new FileReader("nroOp.txt"));
			while ( (linea= br.readLine()) != null) {
				
				adicionar (new NroOp(Integer.parseInt(linea)));
				
			}
			
			br.close();
		}catch (Exception e) {
			
		}
	}
	
}
