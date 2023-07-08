package interfaz;

import java.util.List;

import conf.Modelo;

public interface CRUD {
	
	public int tamaño();
	public void adicionar(Modelo model);
	public void editar (Modelo model);
	public void eliminar(int id);
	public List<Modelo> listar();
	public Modelo buscar(int id);
	public Modelo obtener(int index);
	
	public void cargarData();
	public void grabarData();
	
}
