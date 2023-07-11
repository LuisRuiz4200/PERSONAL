package interfaz;

import java.util.List;

public interface CRUD<T> {
	
	public int tamano();
	public T buscar(int id);
	public T obtener(int index);
	public void adicionar( T model);
	public void editar (T model);
	public void eliminar(int id);
	public List<T> listar();

	public void grabarData();
	public void cargarData();
	
}
