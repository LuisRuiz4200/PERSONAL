package arreglos;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

import clases.*;
import reuzables.Custom;

public class ArregloIngresoAvio {

	private ArrayList<IngresoAvio> arrIngresoAvio;
	
	public ArregloIngresoAvio() {
		arrIngresoAvio = new ArrayList<IngresoAvio>();
		cargarIngresoAvios();
	}
	
	//METODOS BASICOS
	
	public int tamano() {
		return arrIngresoAvio.size();
	}
	
	public IngresoAvio obtener(int i) {
		return arrIngresoAvio.get(i);
	}
	
	public void adicionar (IngresoAvio ingresoAvios) {
		arrIngresoAvio.add(ingresoAvios);
	}
	
	public void eliminar (int id) {
		IngresoAvio obj = buscar(id);
		arrIngresoAvio.remove(obj);
	}
	
	public void editar(IngresoAvio obj) {
		IngresoAvio objIngresoAvio = buscar(obj.getId_ingresoAvio());
		
		
		objIngresoAvio.setCodAvio(obj.getCodAvio());
		objIngresoAvio.setCant_ingresoAvio(obj.getCant_ingresoAvio());
		objIngresoAvio.setNroOP(obj.getNroOP());
		objIngresoAvio.setObs_ingresoAcvio(obj.getObs_ingresoAcvio());
		
	}
	
	public List<IngresoAvio> listar() {
		return arrIngresoAvio.subList(0, tamano());
	}
	
	public IngresoAvio buscar(int id) {
		
		for (IngresoAvio obj:arrIngresoAvio) {
			if(obj.getId_ingresoAvio()==id) {
				return obj;
			}
		}
		
		return null;
	} 
	
	public int correlativo() {

		int res = 0;
		
		if (tamano() == 0) {
			res =1;
		} else {
			for (IngresoAvio obj: arrIngresoAvio) {
				res = obj.getId_ingresoAvio() + 1;
			}
			
		}
		
		return res;

	}
	
	//METODOS DE LECTURA Y ESCRITURA
	
	public void grabarIngresoAvios() {
		PrintWriter pw = null;
		String texto;
		
		try {
			pw= new PrintWriter (new FileWriter("ingresoAvios.txt"));
			for (IngresoAvio ingresoAvios:arrIngresoAvio) {
				texto = ingresoAvios.getId_ingresoAvio() + ";" +
						ingresoAvios.getNroVale_ingresoAvio() + ";" +
						ingresoAvios.getNroOP() + ";" +
						ingresoAvios.getCodAvio() + ";" +
						ingresoAvios.getCant_ingresoAvio() + ";" +
						ingresoAvios.getObs_ingresoAcvio() + ";" +
						new SimpleDateFormat("dd/MM/yyy hh:mm:ss").format(ingresoAvios.getFechaReg_ingresoAvio()) + ";" +
						ingresoAvios.getEstado_ingresoAvio() + ";";
				
				pw.println(texto);
			}
		}catch(Exception e) {
			Custom.mensajeError(null, e.getMessage());
		}finally {
			pw.close();
		}
	}
	
	public void cargarIngresoAvios() {
		BufferedReader br;
		String linea;
		String[] texto;
		
		try {
			br = new BufferedReader (new FileReader("ingresoAvios.txt"));
			while((linea=br.readLine())!=null) {
				texto = linea.split(";");
				IngresoAvio obj = new IngresoAvio();
				
				obj.setId_ingresoAvio(Integer.parseInt(texto[0]));
				obj.setNroVale_ingresoAvio(texto[1]);
				obj.setNroOP(Integer.parseInt(texto[2]));
				obj.setCodAvio(Integer.parseInt(texto[3]));
				obj.setCant_ingresoAvio(Integer.parseInt(texto[4]));
				obj.setObs_ingresoAcvio(texto[5]);
				obj.setFechaReg_ingresoAvio(new SimpleDateFormat("dd/MM/yyy hh:mm:ss").parse(texto[6]));
				obj.setEstado_ingresoAvio(texto[7]);
				
				arrIngresoAvio.add(obj);
			}
			br.close();
		}catch (Exception e) {
			Custom.mensajeError(null, e.getMessage());
		}
		
		
	}
}
