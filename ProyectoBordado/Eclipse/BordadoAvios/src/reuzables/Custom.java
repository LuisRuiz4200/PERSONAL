package reuzables;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Custom {
	
	public static void mensajeError(Component x,String msj) {
		JOptionPane.showMessageDialog(x,msj,"ERROR",0);
	}
	
	public static int mensajeConfirmacion(Component x,String msj) {
		return JOptionPane.showConfirmDialog(x,msj,"SEGURO?",JOptionPane.OK_CANCEL_OPTION,3);
	}
	
	public static void mensajeAdvertencia(Component x,String msj) {
		JOptionPane.showMessageDialog(x,msj,"ATENCION",2);
	}
	
	public static void mensajeExito(Component x,String msj) {
		JOptionPane.showMessageDialog(x,msj,"FELICIDADES",1);
	}
	
}
