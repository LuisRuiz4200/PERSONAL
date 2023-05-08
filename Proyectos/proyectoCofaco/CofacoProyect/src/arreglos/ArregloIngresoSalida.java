package arreglos;

import java.util.ArrayList;
import java.util.Collections;

import clases.*;
import java.io.*;

public class ArregloIngresoSalida {
	//atributos privados
	private ArrayList <IngresoSalida> ingresoPiezas;
	
	//constructor
	public ArregloIngresoSalida() {
		ingresoPiezas= new ArrayList <IngresoSalida>();
		cargarIngresoPiezas();
		ordenar();
	}
	//metodos de mantenimiento
	public int tamaño() {
		return ingresoPiezas.size();
	}
	public void adicionar(IngresoSalida x) {
		ingresoPiezas.add(x);
	}
	public void eliminar(IngresoSalida x) {
		ingresoPiezas.remove(x);
	}
	public IngresoSalida obtener(int i) {
		return ingresoPiezas.get(i);
	}
	public IngresoSalida buscarOp(int op) {
		for(int i=0;i<tamaño();i++) {
			if(obtener(i).getNroOp()==op) {
				return obtener(i);
			}
		}
		return null;
	}
	public IngresoSalida buscarSubCorte(int subCorte) {
		for(int i=0;i<tamaño();i++) {
			if(obtener(i).getSubCorte()==subCorte) {
				return obtener(i);
			}
		}
		return null;
	}
	public IngresoSalida buscar(String linea,int nroOp, int subCorte) {
		for(int i=0;i<tamaño();i++) {
			if(obtener(i).getLinea().equals(linea) && obtener(i).getNroOp()==nroOp && obtener(i).getSubCorte()==subCorte) {
				return obtener(i);
			}
		}
		return null;
	}
	//metodos de grabar y cargar
	public void grabarIngresoPiezas() {
		PrintWriter pw;
		String texto;
		
		try {
			
			pw=new PrintWriter(new FileWriter("ingresoSalida.txt"));
			
			for(int i=0;i<tamaño();i++) {
				IngresoSalida ip=obtener(i);
				texto=
						ip.getItem() + ";" +
						ip.getFecha() + ";" +
						ip.getSupervisor() + ";" +
						ip.getLinea() + ";" +
						ip.getNroOp() + ";" +
						ip.getSubCorte() + ";" +  
						ip.getColor() + ";" + 
						ip.getCliente() + ";" + 
						ip.getIngreso() + ";" + 
						ip.getSalida() + ";" + 
						ip.getDevolucion();
				pw.println(texto);
			}
			pw.close();
			
		}catch (Exception e) {
			
		}
	}
	
	public void cargarIngresoPiezas() {
		BufferedReader br;
		String fila;
		String s[];
		String fecha, supervisor, color, cliente, linea;
		int item,nroOp, subCorte, ingreso, salida, devolucion;
		
		try {
			br=new BufferedReader(new FileReader("ingresoSalida.txt"));
			while((fila=br.readLine())!=null) {
				s=fila.split(";");
				item=Integer.parseInt(s[0]);
				fecha=s[1];
				supervisor=s[2];
				linea=s[3];
				nroOp=Integer.parseInt(s[4]);
				subCorte=Integer.parseInt(s[5]);
				color=s[6];
				cliente=s[7];
				ingreso=Integer.parseInt(s[8]);
				salida=Integer.parseInt(s[9]);
				devolucion=Integer.parseInt(s[10]);
				
				adicionar(new IngresoSalida(item,fecha,supervisor,linea,nroOp,subCorte,color,cliente,ingreso,salida,devolucion));
				
			}
			br.close();
		}catch(Exception e) {
			
		}
		
		
	}
	//metodos adicionales 

	public void ordenar () {
		Collections.sort(ingresoPiezas);
	}
	
	public int correlativo() {
		if(tamaño()==0) {
			return 1;
		}else {
			return obtener(tamaño()-1).getItem()+1;
		}
	}
	
	
}
