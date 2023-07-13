package arreglos;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import clases.*;
import reuzables.Custom;

public class ArregloDetPedidoOP {
	
	private List<DetPedidoOP> arrDetPedidoOP;
	
	public ArregloDetPedidoOP() {
		arrDetPedidoOP = new ArrayList<DetPedidoOP>();
		cargarDetPedidoOP();
	}
	
	
	public int tamano() {
		return arrDetPedidoOP.size();
	}
	
	public DetPedidoOP obtener(int n) {
		return arrDetPedidoOP.get(n);
	}
	
	public DetPedidoOP buscar (int idPedido, int idDetPedido) {
		for (DetPedidoOP obj: arrDetPedidoOP) {
			if (obj.getId_pedidoOP()==idPedido && obj.getId_det_pedidoOP()==idDetPedido) {
				return obj;
			}
		}
		return null;
	}
	
	public void adicionar(DetPedidoOP obj) {
		arrDetPedidoOP.add(obj);
	}
	
	public void editar (DetPedidoOP obj) {
		
		DetPedidoOP objDetPedidoOP = buscar(obj.getId_pedidoOP(), obj.getId_det_pedidoOP());
		
		objDetPedidoOP.setCant_det_pedidoOP(obj.getCant_det_pedidoOP());
	}
	
	public void eliminar(int idPedido, int idDetPedido) {
		DetPedidoOP obj = new DetPedidoOP();
		
		obj = buscar (idPedido,idDetPedido);
		
		arrDetPedidoOP.remove(obj);
		
	}
	
	public List<DetPedidoOP> listar () {
		return arrDetPedidoOP;
	}
	
	public int correlativo() {
		//NO FUNCIONA
		int n = 0;
		int idPedido = 0;
		
		for(DetPedidoOP obj : arrDetPedidoOP) {
			
			idPedido = obj.getId_pedidoOP();
			
			if (obj.getId_pedidoOP()==idPedido) {
				n++;
			}else {
				n= 1;
			}
		}
		
		return n;
		
	}
	
	public int totalCantTallaPorPedido(int idPedidoOP) {
		
		int total = 0;
		
		for(DetPedidoOP obj: arrDetPedidoOP) {
			if(obj.getId_pedidoOP()==idPedidoOP) {
				total+=obj.getCant_det_pedidoOP();
			}
		}
		
		return total;
	}
	
	//metodos de cargar y grabar
	
	private void cargarDetPedidoOP() {
		BufferedReader br = null;
		
		String linea;
		
		try {
			br = new BufferedReader (new FileReader("detPedidoOP.txt"));
			
			while ((linea = br.readLine())!=null) {
				String[] x = linea.split(";");
				
				DetPedidoOP obj = new DetPedidoOP();
				
				obj.setId_pedidoOP(Integer.parseInt(x[0]));
				obj.setId_det_pedidoOP(Integer.parseInt(x[1]));
				obj.setId_talla(Integer.parseInt(x[2]));
				obj.setCant_det_pedidoOP(Integer.parseInt(x[3]));

				adicionar(obj);
			}
			
			br.close();
		}catch(Exception ex) {
			Custom.mensajeAdvertencia(null, ex.getMessage() + "\n cargarDetPedidoOP");
		
		}
		
	}
	
	public void grabarDetPedidoOP() {
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new FileWriter("detPedidoOP.txt"));
			
			int id, codPrograma;
			Date fechaReg, fechaAct;
			String estado;
			
			for (DetPedidoOP obj: arrDetPedidoOP) {
				
				String texto = obj.getId_pedidoOP() + ";"
						+ obj.getId_det_pedidoOP() + ";"
						+ obj.getId_talla() + ";"
						+ obj.getCant_det_pedidoOP() +";";
				
				pw.println(texto);
				
			}
			
		}catch (Exception ex) {
			Custom.mensajeAdvertencia(null, ex.getMessage() + "\n grabarDetPedidoOP");
		}finally {
			pw.close();
		}
	}

}
