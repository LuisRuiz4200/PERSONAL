package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.IngresoDefecto;

public class ArregloIngresoDefectos {
	//atributo privado 
	ArrayList <IngresoDefecto> ingresos;
	//constructor 
	public ArregloIngresoDefectos() {
		ingresos= new ArrayList<IngresoDefecto> ();
		//colocar correlativo a  todos lo registros exisentes antes de cargar el grabado en txt 
		/*for(int i=0;i<tamaño();i++) {
			obtener(i).setItem(correlativo());
		}
		grabarIngresos();*/
		cargarIngresos();
	}
	//metodos de mantenimientos 
	public int tamaño() {
		return ingresos.size();
	}
	public void adicionar(IngresoDefecto i) {
		ingresos.add(i);
	}
	public void eliminar (IngresoDefecto i) {
		ingresos.remove(i);
	}
	public IngresoDefecto obtener(int i) {
		return ingresos.get(i);
	}
	public IngresoDefecto buscarNroGuia(int nroGuia) {
		for(int i=0;i<tamaño();i++) {
			if(obtener(i).getNroGuia()==nroGuia) {
				return obtener(i);
			}
		}
		return null;
	}
	public IngresoDefecto buscarNroOp(int nroOp) {
		for(int i=0;i<tamaño();i++) {
			if(obtener(i).getOrdenP()==nroOp) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public int correlativo() {
		
		int item=1;
		
		if(tamaño()==0) {
			return item;
		}else {
			return obtener(tamaño()-1).getItem() + 1;
		}
	}
	
	//metodos de grabar y cargar
	public void grabarIngresos() {
		PrintWriter pw;
		String fila;
		IngresoDefecto in;
		
		
		try {
			
			pw=new PrintWriter(new FileWriter("ingresoDefectos.txt"));
			
			for(int i=0;i<tamaño();i++) {
				in=obtener(i);
				fila=  in.getItem() + ";" +
						in.getFecha() + ";"+
						in.getConfeccion() + ";" +
						in.getNroGuia() + ";" +
						in.getOrdenP() + ";" +
						in.getColor() + ";" +
						in.getMotivo() +";"+
						in.getTalla0() +";"+
						in.getTalla2() +";"+
						in.getTalla4() +";"+
						in.getTalla6() +";"+
						in.getTalla8() +";"+
						in.getTalla10() +";"+
						in.getTalla12() +";"+
						in.getTalla14() +";"+
						in.getTalla16() +";"+
						in.getTalla18() +";"+
						in.getTalla20();
				pw.println(fila);
			}
			pw.close();
			
		}catch(Exception e) {
			
		}
		
	}
	public void cargarIngresos() {
		BufferedReader br;
		String []s;
		String fila;
		int nroGuia, nroOp, item;
		String color,confeccion, motivo,fecha;
		int talla0,talla2,talla4,talla6,talla8,talla10,talla12,talla14,talla16,talla18,talla20;
		try {
			br=new BufferedReader(new FileReader("ingresoDefectos.txt"));
			while((fila=br.readLine())!=null) {
				s=fila.split(";");
				item=Integer.parseInt(s[0]);
				fecha=s[1];
				confeccion= s[2];
				nroGuia= Integer.parseInt(s[3]);
				nroOp=Integer.parseInt(s[4]);
				color=s[5];
				motivo=s[6];
				talla0=Integer.parseInt(s[7]);
				talla2=Integer.parseInt(s[8]);
				talla4=Integer.parseInt(s[9]);
				talla6=Integer.parseInt(s[10]);
				talla8=Integer.parseInt(s[11]);
				talla10=Integer.parseInt(s[12]);
				talla12=Integer.parseInt(s[13]);
				talla14=Integer.parseInt(s[14]);
				talla16=Integer.parseInt(s[15]);
				talla18=Integer.parseInt(s[16]);
				talla20=Integer.parseInt(s[17]);
				
				
				adicionar(new IngresoDefecto(item,fecha,confeccion, nroGuia,nroOp,color,motivo,talla0,talla2,talla4,talla6,talla8,talla10,talla12,talla14,talla16,talla18,talla20));
				
			}
			br.close();
		}
		catch (Exception e){
			
		}
		
	}
	
}
