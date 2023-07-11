package arreglo;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import interfaz.CRUD;
import modelo.*;
import reuzable.Custom;


public class ArregloDeuda implements CRUD<Deuda> {
	
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
		objDeuda.setId__persona_prestatario(obj.getId__persona_prestatario());
		objDeuda.setId_persona_prestamista(obj.getId_persona_prestamista());
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
	
	public double deudaTotal (int idPersonaPrestammista) {
		double res= -1;
		
		for(int i = 0 ; i<tamano();i++) {
			if(obtener(i).getId_persona_prestamista()==idPersonaPrestammista) {
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
		
		Gson json = new GsonBuilder().setPrettyPrinting().create();
		PrintWriter pw;
		String texto;
		
		try {
			pw= new PrintWriter(new FileWriter("Deuda.json"));
			
			texto = json.toJson(listar());
			
			pw.println(texto);
			pw.close();
		}catch(Exception e){
			Custom.mensajeError(null, e.getMessage());
		}
		
	}
	
	public void cargarData() {
		
		Gson json= new Gson();
		
		try {
			
			Type tipoLista = new TypeToken<List<Deuda>>(){}.getType();
			
			arrDeuda = json.fromJson(new JsonReader(new FileReader("Deuda.json")), tipoLista);
			
		}catch(Exception e) {
			Custom.mensajeError(null, e.getMessage());
			e.printStackTrace();
		}
		
	}
}
