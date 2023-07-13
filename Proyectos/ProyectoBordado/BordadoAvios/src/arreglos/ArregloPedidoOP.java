package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import clases.*;
import reuzables.Custom;

public class ArregloPedidoOP {
	
	private List<PedidoOP> arrPedidoOP;
	
	public ArregloPedidoOP() {
		arrPedidoOP = new ArrayList<PedidoOP>();
		cargarPedidoOP();
	}
	
	
	public int tamano() {
		return arrPedidoOP.size();
	}
	
	public PedidoOP obtener(int n) {
		return arrPedidoOP.get(n);
	}
	
	public PedidoOP buscar (int id) {
		for (PedidoOP obj: arrPedidoOP) {
			if (obj.getId_pedidoOP()==id) {
				return obj;
			}
		}
		return null;
	}
	
	public void adicionar(PedidoOP obj) {
		arrPedidoOP.add(obj);
	}
	
	public void editar (PedidoOP obj) {
		
		PedidoOP objPedidoOP = buscar(obj.getId_pedidoOP());
		
		objPedidoOP.setCod_programaAcabado(obj.getCod_programaAcabado());
		objPedidoOP.setObs_pedidoOP(obj.getObs_pedidoOP());
		objPedidoOP.setFechaAct_pedidoOP(obj.getFechaAct_pedidoOP());
		objPedidoOP.setEstado_pedidoOP(obj.getEstado_pedidoOP());
	}
	public void eliminar(int idPedidoOP) {
		PedidoOP obj =buscar(idPedidoOP);
		
		arrPedidoOP.remove(obj);
	}
	
	public List<PedidoOP> listar () {
		return arrPedidoOP;
	}
	
	public int correlativo () {
		
		int n = 0;
		
		if(tamano()==0) {
			n= 1;
		}else {
			for (PedidoOP obj: arrPedidoOP) {
				n = obj.getId_pedidoOP() + 1;
			}
		}
		
		return n;
	}
	
	//metodos de cargar y grabar
	
	public void cargarPedidoOP() {
		BufferedReader br;
		
		String linea;
		
		try {
			br = new BufferedReader (new FileReader("pedidoOP.txt"));
			
			while ((linea = br.readLine())!=null) {
				String[] x = linea.split(";");
				
				PedidoOP obj = new PedidoOP();
				obj.setId_pedidoOP(Integer.parseInt(x[0]));
				obj.setCod_programaAcabado(Integer.parseInt(x[1]));
				obj.setObs_pedidoOP(x[2]);
				obj.setFechaReg_pedidoOP(new SimpleDateFormat("dd/MM/yy hh:mm:ss").parse(x[3]));
				obj.setFechaAct_pedidoOP(new SimpleDateFormat("dd/MM/yy hh:mm:ss").parse(x[4]));
				obj.setEstado_pedidoOP(x[5]);

				adicionar(obj);
			}
			br.close();
			
		}catch(Exception ex) {
			Custom.mensajeAdvertencia(null, ex.getMessage());
		}
	}
	
	public void grabarPedidoOP() {
		PrintWriter pw;
		
		try {
			pw = new PrintWriter(new FileWriter("pedidoOP.txt"));
			
			
			for (PedidoOP obj: arrPedidoOP) {
				
				String fechaReg = new SimpleDateFormat("dd/MM/yy hh:mm:ss").format(obj.getFechaReg_pedidoOP());
				String fechaAct = new SimpleDateFormat("dd/MM/yy hh:mm:ss").format(obj.getFechaAct_pedidoOP());

				
				String texto = obj.getId_pedidoOP() + ";"
						+ obj.getCod_programaAcabado() + ";"
						+ obj.getObs_pedidoOP() + ";"
						+ fechaReg + ";"
						+ fechaAct + ";"
						+ obj.getEstado_pedidoOP() + ";";
				
				pw.println(texto);
				
			}
			pw.close();
			
		}catch (Exception ex) {
			
		}
	}

}
