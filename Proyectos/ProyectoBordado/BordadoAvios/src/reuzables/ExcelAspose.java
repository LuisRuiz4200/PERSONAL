package reuzables;

import java.awt.Component;
import java.awt.FileDialog;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.aspose.cells.Cells;
import com.aspose.cells.DifSaveOptions;
import com.aspose.cells.Row;
import com.aspose.cells.SaveOptions;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

import vistas.FrmPrincipal;

public class ExcelAspose {
public static void generarExcel(Component parent,String nombreHoja,JTable tabla) {
		
		FileDialog fDialog = new FileDialog(new JFrame(),"EXPORTAR ARCHIVO",FileDialog.SAVE);
		fDialog.setVisible(true);
		
		String dir = fDialog.getDirectory();
		String nombreFile= fDialog.getFile();
		
		if(nombreFile==null) {
			Custom.mensajeAdvertencia(parent,"CANCELADO");
			return;
		}
		
		try {
			
			Workbook libro = new Workbook();
			Worksheet hoja = libro.getWorksheets().get(0);
			
			ArrayList<String[]> tablaExcel = new ArrayList<String[]>();	
            String[] header = new String[tabla.getColumnCount()];
            String[] body = new String[tabla.getColumnCount()];
            
			//CABECERA
			for (int i = 0; i < tabla.getColumnCount(); i++) {
	            String columnName = tabla.getColumnName(i);
	            header[i]= columnName;
	        }
			
			tablaExcel.add(header);
			//CONTENIDO
			for (int x = 0; x < tabla.getRowCount(); x++) {
				 for (int y = 0; y < tabla.getColumnCount(); y++) {
		            	body[y]=tabla.getValueAt(x, y).toString();
		            }
				 tablaExcel.add(body);
			}
			//SALIDA DE ARCHIVO
			
			Cells celda = hoja.getCells();
			celda.importArrayList(tablaExcel, 1, 1, true);
			
			libro.save(dir + nombreFile);
			
			//MENSAJE DE EXITO
			Custom.mensajeExito(parent, nombreFile +  " GUARDADO");

			//ABRIR EL EXCEL CREADO
			File file = new File(dir+nombreFile);
			Runtime.getRuntime().exec("cmd /c start " +dir + nombreFile);
			//Desktop.getDesktop().open(file);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.print(e.getMessage() + "\n" + e.getCause());
			return;
		}
	}
}
