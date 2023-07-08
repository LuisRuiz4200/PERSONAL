package arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.*;

public class ArregloDeudor {
	
	private ArrayList <Deudor>arrDeudor;
	
	public ArregloDeudor() {
		arrDeudor = new ArrayList<Deudor>();
		cargarData();
	}
	
	public int tamano() {
		return arrDeudor.size();
	}
	
	public void adicionar(Deudor obj) {
		arrDeudor.add(obj);
	}
	
	public void eliminar (int id) {
		Deudor obj  = buscar (id);
		arrDeudor.remove(obj);
	}
	
	public void editar(Deudor obj) {
		Deudor objDeudor = buscar(obj.getId_deudor());
		objDeudor.setNom_deudor(obj.getNom_deudor());
		objDeudor.setApe_deudor(obj.getApe_deudor());
		objDeudor.setDni_deudor(obj.getDni_deudor());
	}
	
	public Deudor obtener(int x) {
		return arrDeudor.get(x);
	}
	
	public List<Deudor> listar(){
		return arrDeudor.subList(0, tamano());
	}
	
	public Deudor buscar (int codigo) {
		for (int i=0;i<tamano();i++) {
			if(obtener(i).getId_deudor()==codigo) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public int correlativo() {
		
		int id=0;
		
		if(tamano()==0) {
			id=1;
		}else {
			for (Deudor obj : arrDeudor) {
				id = obj.getId_deudor() + 1;
			}
		}
		
		
		return id;
	}
	
	//metodos de grabar y cargar 
	
	public void grabarData() {
		PrintWriter pw;
		String texto;
		Deudor c;
		
		try {
			pw= new PrintWriter(new FileWriter("Deudor.txt"));
			
			for(int i=0;i<tamano();i++) {
				c = obtener(i);
				
				texto = c.getId_deudor() + ";" +
						c.getNom_deudor() + ";" + 
						c.getApe_deudor() + ";" +
						c.getDni_deudor() + ";" +
						new SimpleDateFormat("dd/MM/yyy hh:mm:ss").format(c.getFechaReg_deudor()) + ";" +
						((c.getFechaAct_deudor()==null)?c.getFechaAct_deudor():new SimpleDateFormat("dd/MM/yy hh:mm:ss").format(c.getFechaAct_deudor())) + ";" + 
						c.getEstado_deudor() + ";" ;
				
				pw.println(texto);
			}
			pw.close();
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "GRABAR DEUDOR",0);
		}
	}
	
	public void cargarData() {
		BufferedReader br;
		String texto;
		String [] pos;
		
		try {
			br = new BufferedReader(new FileReader("Deudor.txt"));
			
			while((texto=br.readLine())!=null) {
				pos = texto.split(";");
				
				int codigo =Integer.parseInt( pos[0]);
				String nombre = pos[1];
				String apellido = pos [2];
				String dni = pos [3];
				Date fechaReg = new SimpleDateFormat("dd/MM/yyy hh:mm:ss").parse(pos[4]);
				Date fechaAct = null;
				
				try {
					fechaAct = new SimpleDateFormat("dd/MM/yyy hh:mm:ss").parse(pos[5]);
				} catch (Exception e) {}
				
				String estado = pos[6];
				
				Deudor obj = new Deudor();
				obj.setId_deudor(codigo);
				obj.setNom_deudor(nombre);
				obj.setApe_deudor(apellido);
				obj.setDni_deudor(dni);
				obj.setFechaReg_deudor(fechaReg);
				obj.setFechaAct_deudor(fechaAct);
				obj.setEstado_deudor(estado);
				
				adicionar(obj);
			}
			br.close();	
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,  e.getMessage(),"CARGAR DEUDOR",0);
		}
	}
	
	
}
