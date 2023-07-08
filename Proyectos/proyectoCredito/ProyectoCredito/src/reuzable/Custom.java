package reuzable;

import java.awt.Component;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class Custom {
	
	public static void filtrarTabla(JTable tabla,String filtro, int columna) {
		
		TableRowSorter<TableModel> clasificador = new TableRowSorter<TableModel>(tabla.getModel());
		
		clasificador.setRowFilter(RowFilter.regexFilter(filtro, columna));
		
		tabla.setRowSorter(clasificador);
		
		
	}
	
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
