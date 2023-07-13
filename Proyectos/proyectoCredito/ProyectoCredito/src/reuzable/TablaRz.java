package reuzable;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import arreglo.ArregloDeuda;
import modelo.Deuda;

public class TablaRz {
	
	public static void main(String [] args) {
	}
	
	public static void filtrarTabla(JTable tabla,String filtro, int columna) {
		
		TableRowSorter<TableModel> clasificador = new TableRowSorter<TableModel>(tabla.getModel());
		
		clasificador.setRowFilter(RowFilter.regexFilter(filtro, columna));
		
		tabla.setRowSorter(clasificador);
		
		
	}
	
	public static DefaultTableModel tableModel(Object[] cabecera) {
		DefaultTableModel modelo = new DefaultTableModel(cabecera,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		return modelo;
	}
	
	public static DefaultTableCellRenderer tableCellRendererModelComponent() {
		DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				// TODO Auto-generated method stub
				
				if(value instanceof JButton) {
					return (JButton)value;
				}
				
				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		};
		
		return tableCellRenderer;
	}
	
	public static void autoAjustarCabecera (JTable tabla) {
		for (int i=0;i<tabla.getColumnCount();i++) {
			String nombreColumna = tabla.getColumnName(i);
			int caracterCount = nombreColumna.length();
			tabla.getColumn(nombreColumna).setPreferredWidth(10 * caracterCount);
		}
	}
	
	public static void autoAjustar(JTable tabla) {
		for (int i=0;i<tabla.getColumnCount();i++) {
			String nombreColumna = tabla.getColumnName(i);
			int caracterColumnaCount = nombreColumna.length();
			
			tabla.getColumn(nombreColumna).setPreferredWidth(13 * caracterColumnaCount);
			
			for(int x=0;x<tabla.getRowCount();x++) {
				String celdaValue=tabla.getValueAt(x, i).toString();
				int caracterCeldaCount=celdaValue.length();
				
				if(caracterColumnaCount<caracterCeldaCount && !(tabla.getValueAt(x,i) instanceof Component)) {
					tabla.getColumn(nombreColumna).setPreferredWidth(10 *  caracterCeldaCount);
				}
			}
		}
	}
	
}
