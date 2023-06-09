package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import clases.CitiAcabado;
import clases.ProgramaAcabado;
import reuzables.Custom;

public class ArregloProgramaAcabado {
	
	private ArrayList<ProgramaAcabado> arrProgramaAcabado;
	
	public ArregloProgramaAcabado() {
		arrProgramaAcabado = new ArrayList<ProgramaAcabado>();
		cargarProgramaAcabado();
	}
	
	public int tamano() {
		return arrProgramaAcabado.size();
	}
	
	public ProgramaAcabado obtener(int i) {
		return arrProgramaAcabado.get(i);
	}
	
	public void adicionar(ProgramaAcabado obj) {
		arrProgramaAcabado.add(obj);
	}
	
	public void eliminar(ProgramaAcabado obj) {
		arrProgramaAcabado.remove(obj);
	}
	
	public void editar(ProgramaAcabado obj) {
		
		for(ProgramaAcabado x:arrProgramaAcabado) {
			if(x.getCod_programaAcabado()== obj.getCod_programaAcabado()) {
				
				x.setNro_OP(obj.getNro_OP());
				x.setCod_colorOP(obj.getCod_colorOP());
				x.setCantProg_programaAcabado(obj.getCantProg_programaAcabado());
				x.setCantPed_programaAcabado(obj.getCantPed_programaAcabado());
				x.setCod_citiConfeccion(obj.getCod_citiConfeccion());
				x.setCod_citiAcabado(obj.getCod_citiAcabado());
				x.setFechaAct_programaAcabado(obj.getFechaAct_programaAcabado());
				x.setObs_programaAcabado(obj.getObs_programaAcabado());
				x.setEstado_programaAcabado(obj.getEstado_programaAcabado());
			}
		}
	}
	
	public ProgramaAcabado buscar(int cod_programaAcabado) {
		
		for(ProgramaAcabado obj:arrProgramaAcabado) {
			if(obj.getCod_programaAcabado() == cod_programaAcabado) {
				return obj;
			}
		}
		
		
		return null;
	}
	
	public List<ProgramaAcabado> listar(){
		return arrProgramaAcabado.subList(0, tamano());
	}
	
	public int correlativo () {
		
		int res=0 ;
		
		if (arrProgramaAcabado.size()==0) {
			res = 1;
		}else {
			for(ProgramaAcabado obj:arrProgramaAcabado) {
				res = obj.getCod_programaAcabado() + 1;
			}
		}
		
		return res;
	}
	
	public boolean duplicado (int nroOP, String color, String acabado) {
		
		boolean res = false;
		
		for(ProgramaAcabado obj: arrProgramaAcabado) {
			if (obj.getNro_OP()==nroOP && obj.getCod_colorOP().equals(color) && obj.getCod_citiAcabado().equals(acabado)) {
				Custom.mensajeAdvertencia(null, "YA SE REGISTRO AL PROGRAMA ESTOS DETALLES");
				return res = true;
			}
		}
		
		return res;
	}
	
	//METODOS PARA GRABAR Y CARGAR DATA
	
	public void grabarProgramaAcabado() {
		PrintWriter pw;
		String line;
		
		try {
			pw = new PrintWriter(new FileWriter("programaAcabado.txt"));
			
			for (ProgramaAcabado obj: arrProgramaAcabado) {
				line = obj.getCod_programaAcabado() + ";" +
						obj.getNro_OP() + ";" +
						obj.getCod_colorOP() + ";" +
						obj.getCantPed_programaAcabado() +  ";" + 
						obj.getCantProg_programaAcabado() + ";" + 
						obj.getCod_citiConfeccion() + ";" +
						obj.getCod_citiAcabado() + ";" +
						obj.getObs_programaAcabado() + ";" + 
						new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(obj.getFechaReg_programaAcabado()) +";" +
						new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(obj.getFechaAct_programaAcabado()) +";" +
						obj.getEstado_programaAcabado() + ";" 
						;
				pw.println(line);
			}
		pw.close();	
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}	
	public void cargarProgramaAcabado() {
		BufferedReader br;
		String line;
		ProgramaAcabado citiConfeccion;
		
		try {
			br = new BufferedReader(new FileReader("programaAcabado.txt"));
			citiConfeccion = new ProgramaAcabado();
			
			while((line=br.readLine())!=null) {
				 String [] n=line.split(";");
				 
				 citiConfeccion = new ProgramaAcabado();
				 
				 citiConfeccion.setCod_programaAcabado(Integer.parseInt(n[0]));
				 citiConfeccion.setNro_OP(Integer.parseInt(n[1]));
				 citiConfeccion.setCod_colorOP(n[2]);
				 citiConfeccion.setCantPed_programaAcabado(Integer.parseInt(n[3]));
				 citiConfeccion.setCantProg_programaAcabado(Integer.parseInt(n[4]));
				 citiConfeccion.setCod_citiConfeccion(n[5]);
				 citiConfeccion.setCod_citiAcabado(n[6]);
				 citiConfeccion.setObs_programaAcabado(n[7]);
				 citiConfeccion.setFechaReg_programaAcabado(new Date(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(n[8]).getTime()));
				 citiConfeccion.setFechaAct_programaAcabado(new Date(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(n[9]).getTime()));
				 citiConfeccion.setEstado_programaAcabado(n[10]);
				 
				 adicionar(citiConfeccion);
				
			}
			br.close();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
	}
}
