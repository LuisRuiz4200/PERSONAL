package extendidos;

import clases.Talla;

public interface ArregloInterface {
	
	public Object buscar(int id) ;
	
	public int tamano() ;
	
	public Talla obtener(int n) ;
	
	public void adicionar( Object obj);
	
	public void editar (Talla obj) ;
	
	public void eliminar (Talla obj) ;
	
}
