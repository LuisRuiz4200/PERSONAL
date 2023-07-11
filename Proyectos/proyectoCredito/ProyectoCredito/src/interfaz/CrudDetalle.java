package interfaz;

import java.util.List;

public interface CrudDetalle<T> {
	
	public int tamano();
	public T buscar(int id1, int id2);
	public T obtener(int index);
	public void adicionar( T model);
	public void editar (T model);
	public void eliminar(int id1, int id2);
	public List<T> listar();
	public List<T> listarPorId(int id);

	public void grabarData();
	public void cargarData();
	
}
