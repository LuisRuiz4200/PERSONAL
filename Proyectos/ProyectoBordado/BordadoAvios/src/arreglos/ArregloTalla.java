package arreglos;

import java.util.ArrayList;
import java.util.List;

import clases.Talla;

public class ArregloTalla {
	
	private List<Talla> arrTalla ;

	
	public static void main (String[]args){
		new ArregloTalla();
	}
	
	
	public ArregloTalla() {
		arrTalla = new ArrayList<Talla>();
		
		arrTalla.add(new Talla(1,"XXS"));
		arrTalla.add(new Talla(2,"XS"));
		arrTalla.add(new Talla(3,"S"));
		arrTalla.add(new Talla(4,"M"));
		arrTalla.add(new Talla(5,"L"));
		arrTalla.add(new Talla(6,"XL"));
		arrTalla.add(new Talla(7,"2XL"));
		arrTalla.add(new Talla(8,"3XL"));
		arrTalla.add(new Talla(9,"4XL"));
		arrTalla.add(new Talla(10,"0"));
		arrTalla.add(new Talla(11,"1"));
		arrTalla.add(new Talla(12,"2"));
		arrTalla.add(new Talla(13,"3"));
		arrTalla.add(new Talla(14,"4"));
		arrTalla.add(new Talla(15,"5"));
		arrTalla.add(new Talla(16,"6"));
		arrTalla.add(new Talla(17,"7"));
		arrTalla.add(new Talla(18,"8"));
		arrTalla.add(new Talla(19,"9"));
		arrTalla.add(new Talla(20,"10"));
		arrTalla.add(new Talla(21,"11"));
		arrTalla.add(new Talla(22,"12"));
		arrTalla.add(new Talla(23,"13"));
		arrTalla.add(new Talla(24,"14"));
		arrTalla.add(new Talla(25,"15"));
		arrTalla.add(new Talla(26,"16"));
		arrTalla.add(new Talla(27,"17"));
		arrTalla.add(new Talla(28,"18"));
		arrTalla.add(new Talla(29,"19"));
		arrTalla.add(new Talla(30,"20"));
	}
	
	
	
	
	public int tamano() {
		return arrTalla.size();
	}
	
	public Talla obtener(int n) {
		return arrTalla.get(n);
	}
	
	public void adicionar(Talla obj) {
		arrTalla.add(obj);
	}
	
	public void editar (Talla obj) {
		
		Talla objTalla = buscar(obj.getId_talla());
		objTalla.setDes_talla(obj.getDes_talla());
		
	}
	
	public void eliminar (Talla obj) {
		arrTalla.remove(obj);
	}
	
	
	public List<Talla> listar(){
		
		return arrTalla.subList(0,tamano());
	}
	
	public Talla buscar(int id) {
		
		for(Talla obj:arrTalla) {
			if(obj.getId_talla()==id) {
				return obj;
			}
		}
		
		return null;
	}
	public Talla buscarPorDesTalla(String desTalla) {
		
		for(Talla obj:arrTalla) {
			if(obj.getDes_talla()==desTalla) {
				return obj;
			}
		}
		
		return null;
	}
	
	
	//metodos cargar y grabar
	
}	


