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

import interfaz.CRUD;
import modelo.Pago;
import reuzable.Custom;

public class ArregloPago implements CRUD<Pago> {

	private List<Pago> arrPago;
	
	public ArregloPago() {
		arrPago = new ArrayList<Pago>();
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
		buscar(model.getId_deudor());
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
