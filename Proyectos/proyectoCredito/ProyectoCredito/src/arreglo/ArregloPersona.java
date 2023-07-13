package arreglo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import interfaz.Crud;
import modelo.*;

public class ArregloPersona implements Crud<Persona>{
	
	private ArrayList <Persona>arrPersona;
	
	public ArregloPersona() {
		arrPersona = new ArrayList<Persona>();
		cargarData();
	}
	
	public int tamano() {
		return arrPersona.size();
	}
	
	public void adicionar(Persona obj) {
		arrPersona.add(obj);
	}
	
	public void eliminar (int id) {
		Persona obj  = buscar (id);
		arrPersona.remove(obj);
	}
	
	public void editar(Persona obj) {
		Persona objpersona = buscar(obj.getId_persona());
		objpersona.setNom_persona(obj.getNom_persona());
		objpersona.setApe_persona(obj.getApe_persona());
		objpersona.setDni_persona(obj.getDni_persona());
	}
	
	public Persona obtener(int x) {
		return arrPersona.get(x);
	}
	
	public List<Persona> listar(){
		return arrPersona.subList(0, tamano());
	}
	
	public Persona buscar (int codigo) {
		for (int i=0;i<tamano();i++) {
			if(obtener(i).getId_persona()==codigo) {
				return obtener(i);
			}
		}
		return null;
	}
	
	public int correlativo() {
		
		int id=2;
		
		if(tamano()==0) {
			id=1;
		}else {
			for (Persona obj : arrPersona) {
				id = obj.getId_persona() + 1;
			}
		}
		
		
		return id;
	}
	
	//metodos de grabar y cargar 
	
	public void grabarData() {
		Gson json = new GsonBuilder().setPrettyPrinting().create();
		PrintWriter pw;
		String texto;
		Persona c;
		
		try {
			pw= new PrintWriter(new FileWriter("Persona.json"));
			
			texto = json.toJson(listar());
			
			pw.println(texto);
			pw.close();
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "GRABAR persona",0);
		}
	}
	
	public void cargarData() {
		Gson json = new Gson();
		
		try {
			
			JsonReader jr = new JsonReader(new FileReader("Persona.json"));
			
			Type tipoLista = new TypeToken<List<Persona>>(){}.getType();
			
			arrPersona = json.fromJson(jr, tipoLista);
			
			jr.close();
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,  e.getMessage(),"CARGAR persona",0);
		}
	}
	
	
}
