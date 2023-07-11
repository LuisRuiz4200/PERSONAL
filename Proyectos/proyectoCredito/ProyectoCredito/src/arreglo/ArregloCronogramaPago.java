package arreglo;

import java.io.FileNotFoundException;
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

import interfaz.CrudDetalle;
import modelo.CronogramaPago;
import reuzable.Custom;

public class ArregloCronogramaPago implements CrudDetalle<CronogramaPago>{

	private List<CronogramaPago> arrCronoPago;
	
	public ArregloCronogramaPago() {
		arrCronoPago = new ArrayList<CronogramaPago>();
		cargarData();
	}

	@Override
	public int tamano() {
		return arrCronoPago.size();
	}

	@Override
	public CronogramaPago buscar(int idDeuda, int idCronoDeuda) {
		
		for (CronogramaPago obj: listar()){
			if (obj.getId_deuda()==idDeuda && obj.getId_crono_deuda() == idCronoDeuda) {
				return obj;
			}
		}
		
		return null;
	}

	@Override
	public CronogramaPago obtener(int index) {
		return arrCronoPago.get(index);
	}

	@Override
	public void adicionar(CronogramaPago model) {
		arrCronoPago.add(model);
	}

	@Override
	public void editar(CronogramaPago model) {
		CronogramaPago obj = buscar(model.getId_deuda(),model.getId_crono_deuda());
		obj.setMonto_crono_pago(model.getMonto_crono_pago());
		obj.setCuota_crono_pago(model.getCuota_crono_pago());
		obj.setFecha_crono_pago(model.getFecha_crono_pago());
	}

	@Override
	public void eliminar(int idDeuda, int idCronoPago) {
		CronogramaPago obj = buscar(idDeuda,idCronoPago);
		arrCronoPago.remove(obj);
		
	}

	@Override
	public List<CronogramaPago> listar() {
		return arrCronoPago;
	}
	

	@Override
	public List<CronogramaPago> listarPorId(int idDeuda) {
		
		for (CronogramaPago obj: listar()) {
			if(obj.getId_deuda()==idDeuda) {
				arrCronoPago.add(obj);
			}
		}
		
		return arrCronoPago;
	}


	@Override
	public void grabarData() {
		Gson json = new GsonBuilder().setPrettyPrinting().create();
		PrintWriter pw;
		String texto;
		
		
		try {
			pw = new PrintWriter(new FileWriter("CronogramaPago.json"));
			
			texto = json.toJson(listar());
			
			pw.println(texto);
			pw.close();
			
		}catch(Exception ex) {
			Custom.mensajeError(null, ex.getMessage());
		}
		
	}

	@Override
	public void cargarData() {
		Gson json = new Gson();
		
		JsonReader js ;
		
		try {
			js = new JsonReader(new FileReader("CronogramaPago.json"));
			
			Type tipoLista = new TypeToken<List<CronogramaPago>>(){}.getType();
			arrCronoPago = json.fromJson(js, tipoLista);
			
		} catch (FileNotFoundException ex) {
			Custom.mensajeError(null, ex.getMessage());
		}
		
	}

	

}
