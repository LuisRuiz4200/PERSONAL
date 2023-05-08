package utils;

import java.awt.Component;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;


public class Tool {
	
	public static void mensajeError(Component s, String msj) {
		JOptionPane.showMessageDialog(s, msj,"ERROR!",0);
	}
	
	public static void mensajeExito(Component s, String msj) {
		JOptionPane.showMessageDialog(s, msj,"EXITO!",1);
	}
	public static int mensajeConfirmacion(Component s, String msj) {
		return JOptionPane.showConfirmDialog(s, msj,"¿SEGURO?",JOptionPane.YES_NO_OPTION);
	}
	
	public static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyy");
	
	public static DecimalFormat df = new DecimalFormat("000.00");
	
}	
