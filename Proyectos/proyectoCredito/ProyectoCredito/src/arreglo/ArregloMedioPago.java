package arreglo;

import java.util.ArrayList;
import java.util.List;

import interfaz.Crud;
import modelo.MedioPago;

public class ArregloMedioPago implements Crud<MedioPago> {

	private List<MedioPago> arrMedioPago;
	
	public ArregloMedioPago() {
		arrMedioPago = new ArrayList<MedioPago>();
		arrMedioPago.add(new MedioPago(1,"TARJETA CREDITO"));
		arrMedioPago.add(new MedioPago(2,"YAPE"));
		arrMedioPago.add(new MedioPago(3,"PLIN"));
		arrMedioPago.add(new MedioPago(4,"EFECTIVO"));
	}
	
	
	@Override
	public int tamano() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MedioPago buscar(int id) {
		
		for (MedioPago obj: listar()) {
			if(obj.getId_medioPago() == id) {
				return obj;
			}
		}
		
		return null;
	}

	@Override
	public MedioPago obtener(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionar(MedioPago model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(MedioPago model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MedioPago> listar() {
		return arrMedioPago;
	}

	@Override
	public void grabarData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cargarData() {
		// TODO Auto-generated method stub
		
	}

}
