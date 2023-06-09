package arreglo;

import java.io.BufferedReader;
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

import interfaz.Crud;
import modelo.Pago;
import reuzable.Custom;

public class ArregloPago implements Crud<Pago> {

	private List<Pago> arrPago;
	
	public ArregloPago() {
		arrPago = new ArrayList<Pago>();
		cargarData();
	}

	@Override
	public int tamano() {
		return arrPago.size();
	}

	@Override
	public void adicionar(Pago model) {
		arrPago.add(model);
	}

	@Override
	public void editar(Pago model) {
		Pago obj = buscar(model.getId_pago());
		obj.setEstado_pago(model.getEstado_pago());
		obj.setFechaAct_pago(model.getFechaAct_pago());
		obj.setId_medioPago(model.getId_medioPago());
		obj.setId_persona_prestatario(model.getId_persona_prestatario());
		obj.setMonto_pago(model.getMonto_pago());
	}

	@Override
	public void eliminar(int id) {
		Pago obj = buscar(id);
		arrPago.remove(obj);
	}

	@Override
	public List<Pago> listar() {
		return arrPago.subList(0, tamano());
	}

	@Override
	public Pago buscar(int id) {
		for (Pago obj : arrPago) {
			if (obj.getId_pago() == id) {
				return obj;
			}
		}
		return null;
	}

	@Override
	public Pago obtener(int index) {
		return arrPago.get(index);
	}
	
	public int correlativo() {
		int id = 0;
		
		if (tamano()==0) {
			id =1;
		}else {
			for (Pago obj: listar()) {
				id = obj.getId_pago() + 1;
			}
		}
		
		return id;
	}

	//METODOS ADICIONALES

	@Override
	public void grabarData() {
		
		Gson json = new GsonBuilder().setPrettyPrinting().create();
		
		PrintWriter pw;
		String texto;
		
		
		try {
			pw = new PrintWriter(new FileWriter("Pago.json"));
			
			texto = json.toJson(listar());
			
			pw.println(texto);
			pw.close();
			
		}catch(Exception ex) {
			Custom.mensajeExito(null, ex.getMessage());
		}
		
	}
	
	@Override
	public void cargarData() {

		Gson json = new Gson();
		JsonReader jr ;
		
		try {
			jr = new JsonReader(new FileReader("Pago.json"));
			
			Type tipoLista = new TypeToken<List<Pago>>() {}.getType();
			
			arrPago = json.fromJson(jr, tipoLista);
			
			jr.close();
			
		}catch(Exception ex) {
			Custom.mensajeError(null, ex.getMessage());
		}
		
	}

	
	
	
}
