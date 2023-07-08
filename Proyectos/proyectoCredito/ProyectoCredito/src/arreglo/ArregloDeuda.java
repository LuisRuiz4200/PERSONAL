package arreglo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.*;
import reuzable.Custom;


public class ArregloDeuda {
	
	private ArrayList<Deuda> arrDeuda;
	
	public ArregloDeuda(){
		arrDeuda = new ArrayList <Deuda>();
		cargarData();
	}
	
	public int tamano() {
		return arrDeuda.size();
	}
	
	public void adicionar(Deuda obj) {
		arrDeuda.add(obj);
	}
	
	public void eliminar(int idDeuda) {
		Deuda objDeuda = buscar(idDeuda);
		arrDeuda.remove(objDeuda);
	}
	public void editar (Deuda obj) {
		Deuda objDeuda = buscar(obj.getId_deuda());
		objDeuda.setId_deudor(obj.getId_deudor());
		objDeuda.setMonto_deuda(obj.getMonto_deuda());
		objDeuda.setCuota_deuda(obj.getCuota_deuda());
		objDeuda.setInteres_deuda(obj.getInteres_deuda());
		objDeuda.setDes_deuda(obj.getDes_deuda());
		objDeuda.setFechaAct_deuda(obj.getFechaAct_deuda());
		objDeuda.setEstado_deuda(obj.getEstado_deuda());
	}
	
	public List<Deuda> listar() {
		List<Deuda> lista = new ArrayList<Deuda>();
		
		lista = arrDeuda.subList(0, tamano());
		
		return lista;
	}
	
	public Deuda obtener(int x) {
		return arrDeuda.get(x);
	}
	
	public Deuda buscar (int codigo) {
		
		Deuda g= null;
		
		for(int i = 0 ; i<tamano();i++) {
			if(obtener(i).getId_deuda()==codigo) {
				g=obtener(i);
			}
		}
		
		return g;
	}
	
	public double deudaTotal (int idDedudor) {
		double res= -1;
		
		for(int i = 0 ; i<tamano();i++) {
			if(obtener(i).getId_deudor()==idDedudor) {
				res += obtener(i).getMonto_deuda() * (obtener(i).getInteres_deuda()/100) + obtener(i).getMonto_deuda();
			}
		}
		
		return res;
	}
	
	public void cargarEstado() {
		
		for(int i = 0 ; i<tamano();i++) {
			obtener(i).setEstado_deuda("REGISTRADO");
		}
		
		grabarData();
		
		
	}
	
	public int correlativo() {
		int id=0;
		
		if (tamano()==0) {
			id=1;
		}else {
			for (Deuda obj : arrDeuda) {
				id = obj.getId_deuda() + 1;
			}
		}
		
		return id;
	}
	
	//Metodos de guardar y buscar 
	
	public void grabarData() {
		
		PrintWriter pw;
		String texto;
		Deuda g;
		
		try {
			pw= new PrintWriter(new FileWriter("Deuda.txt"));
			
			for(int i=0;i<tamano();i++) {
				g = obtener(i);
				texto = g.getId_deuda() + ";" +
						g.getId_deudor() + ";" +
						g.getMonto_deuda() + ";" + 
						g.getCuota_deuda() + ";" + 
						g.getDes_deuda() + ";" +
						g.getInteres_deuda() + ";" +
						((g.getFechaReg_deuda()==null)?null:new SimpleDateFormat("dd/MM/yyy hh:mm:ss").format(g.getFechaReg_deuda())) + ";" +
						((g.getFechaAct_deuda()==null)?null:new SimpleDateFormat("dd/MM/yyy hh:mm:ss").format(g.getFechaAct_deuda())) + ";" +
						g.getEstado_deuda() + ";";
				
				pw.println(texto);
				
			}
			pw.close();
		}catch(Exception e){
			Custom.mensajeError(null, e.getMessage());
		}
		
	}
	
	public void cargarData() {
		
		BufferedReader br;
		String texto;
		String[] pos;
		
		try {
			br = new BufferedReader(new FileReader("Deuda.txt"));
			
			while((texto=br.readLine())!=null) {
				pos = texto.split(";");
				
				int codigo = Integer.parseInt(pos[0]);
				int cliente = Integer.parseInt(pos[1]);
				double monto= Double.parseDouble(pos[2]);
				int cuota= Integer.parseInt(pos[3]);
				String motivo=pos[4];
				double interes = Double.parseDouble(pos[5]);
				Date fechaReg = ((pos[6].equals("null"))?null: new SimpleDateFormat("dd/MM/yyy hh:mm:ss").parse(pos[6]));
				Date fechaAct = ((pos[7].equals("null"))?null: new SimpleDateFormat("dd/MM/yyy hh:mm:ss").parse(pos[7]));
				String estado = pos[8];
				
				Deuda obj = new Deuda();
				obj.setId_deuda(codigo);
				obj.setId_deudor(cliente);
				obj.setMonto_deuda(monto);
				obj.setCuota_deuda(cuota);
				obj.setDes_deuda(motivo);
				obj.setInteres_deuda(interes);
				obj.setFechaReg_deuda(fechaReg);
				obj.setFechaAct_deuda(fechaAct);
				obj.setEstado_deuda(estado);
				
				adicionar(obj);
			}
			
			br.close();
			
		}catch(Exception e) {
			//Custom.mensajeError(null, e.getMessage());
			e.printStackTrace();
		}
		
	}
}
