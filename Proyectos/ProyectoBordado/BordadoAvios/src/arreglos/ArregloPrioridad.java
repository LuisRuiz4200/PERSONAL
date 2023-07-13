package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import clases.Prioridad;
import clases.Prioridad;
import reuzables.Custom;


public class ArregloPrioridad {
	
	private ArrayList<Prioridad> arrPrioridad;
	
	public ArregloPrioridad() {
		arrPrioridad = new ArrayList<Prioridad>();
		cargarPrioridad();
	}
	
	public int tamano() {
		return arrPrioridad.size();
	}
	
	public Prioridad obtener(int x) {
		return arrPrioridad.get(x);
	}
	
	public void adicionar(Prioridad obj) {
		arrPrioridad.add(obj);
	}
	
	public void eliminar (Prioridad obj) {
		arrPrioridad.remove(obj);
	}
	
	public void editar (Prioridad obj) {
		for (Prioridad x: arrPrioridad) {
			if (x.getId_prioridad()==obj.getId_prioridad()) {
				x.setNro_OP(obj.getNro_OP());
				x.setColor_OP(obj.getColor_OP());
				x.setDes_prioridad(obj.getDes_prioridad());
				x.setObs_prioridad(obj.getObs_prioridad());
				x.setOrden_prioridad(obj.getId_prioridad());
				x.setFechaReg_prioridad(obj.getFechaReg_prioridad());
				x.setEstado_prioridad(obj.getEstado_prioridad());
			}
		}
	}
	public Prioridad buscar(int id) {
		for (Prioridad x: arrPrioridad) {
			if (x.getId_prioridad()==id) {
				return x;
			}
		}
		return null;
	}
	
	public int correlativo () {
		
		int n = 0;
		
		if (tamano()==0) {
			n=1;
		}else {
			for (Prioridad x: arrPrioridad) {
				n = x.getId_prioridad() + 1;
			}
		}
		
		return n;
	}
	
	//cargar y grabar
	
	public void grabarPrioridad() {
		PrintWriter pw = null;
		String texto;
		
		try {
			pw = new PrintWriter(new FileWriter("prioridad.txt"));
			
			for (Prioridad obj: arrPrioridad) {
				texto = obj.getId_prioridad() + ";" +
						obj.getNro_OP() + ";" +
						obj.getColor_OP() + ";" +
						obj.getDes_prioridad() + ";" +
						obj.getObs_prioridad() + ";" +
						obj.getOrden_prioridad() + ";" +
						new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(obj.getFechaReg_prioridad()) + ";" +
						obj.getEstado_prioridad() + ";";
				
				pw.println(texto);
			}
			
		}catch(Exception e) {
			Custom.mensajeError(null, e.getMessage() + "ArregloPrioridad grabarPrioridad");
		}finally {
			pw.close();
		}
	}
	
	public void cargarPrioridad() {
		BufferedReader br;
		String linea;
		String [] texto;
		
		try {
			br = new BufferedReader(new FileReader("prioridad.txt"));
			while((linea= br.readLine())!=null) {
				texto = linea.split(";");
				Prioridad obj = new Prioridad();
				
				obj.setId_prioridad(Integer.parseInt(texto[0]));
				obj.setNro_OP(Integer.parseInt(texto[1]));
				obj.setColor_OP(texto[2]);
				obj.setDes_prioridad(texto[3]);
				obj.setObs_prioridad(texto[4]);
				obj.setOrden_prioridad(Integer.parseInt(texto[5]));
				obj.setFechaReg_prioridad(new Date(new SimpleDateFormat("dd/MM/yyy hh:mm:ss").parse(texto[6]).getTime()));
				obj.setEstado_prioridad(texto[7]);
				
				adicionar(obj);
			}
			br.close();
			
		}catch (Exception e) {
			Custom.mensajeError(null, e.getMessage() + "\n ArregloPrioridad cargarPrioridad");
		}
	}
	
	
}
