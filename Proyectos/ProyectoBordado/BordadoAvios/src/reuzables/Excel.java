package reuzables;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.DirectoryStream.Filter;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import vistas.FrmPrincipal;

public class Excel {
	public static void generarExcel(Component parent,String nombreHoja,JTable tabla) {
		
		FileDialog fDialog = new FileDialog(new JFrame(),"EXPORTAR ARCHIVO",FileDialog.SAVE);
		fDialog.setVisible(true);
		
		String dir = fDialog.getDirectory();
		String nombreFile= fDialog.getFile();
		
		
		//fDialog.remove((Component)fDialog.getFilenameFilter());
		FilenameFilter filtro = fDialog.getFilenameFilter();
		
		
		fDialog.setFilenameFilter(filtro);
		
		System.out.print(filtro);
		
		if(nombreFile==null) {
			Custom.mensajeAdvertencia(parent,"CANCELADO");
			return;
		}
		
		try {
			
			XSSFWorkbook libro = new XSSFWorkbook();
			Sheet hoja = libro.createSheet(nombreHoja);
			Row fila = hoja.createRow(0);
			fila.setHeight((short)600);
			
			//CABECERA
			for (int i = 0; i < tabla.getColumnCount(); i++) {
	            String columnName = tabla.getColumnName(i);
	            Cell celda = fila.createCell(i);
	            celda.setCellValue(columnName);
	            celda.setCellStyle(estiloCabecera(libro));
	        }
			//CONTENIDO
			for (int x = 0; x < tabla.getRowCount(); x++) {
	            fila = hoja.createRow(x+1);
	            for (int y = 0; y < tabla.getColumnCount(); y++) {
	            	
	            	Object valorCelda = tabla.getValueAt(x, y);
	            	Cell celda = fila.createCell(y);
	            	celda.setCellValue(valorCelda.toString());
	            	celda.setCellStyle(estiloContenido(libro));
					hoja.autoSizeColumn(y);
	            }   
	        }
			
			//SALIDA DE ARCHIVO
			
			OutputStream stream = new FileOutputStream(dir + nombreFile);
			libro.write(stream);
			libro.close();
			stream.close();
			
			//MENSAJE DE EXITO
			Custom.mensajeExito(parent, nombreFile +  " GUARDADO");

			//ABRIR EL EXCEL CREADO
			File file = new File(dir+nombreFile);
			Runtime.getRuntime().exec("cmd /c start " +dir + nombreFile);
			//Desktop.getDesktop().open(file);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			System.out.print(e.getMessage());
			return;
		}
	}
	
	
	
	
	public static CellStyle estiloCabecera(Workbook libro) {
		
		CellStyle estilo = libro.createCellStyle();
		
		estilo.setLocked(true);
		estilo.setBorderBottom(BorderStyle.MEDIUM);
		//
		estilo.setBorderBottom(BorderStyle.MEDIUM);
		estilo.setBottomBorderColor((short)8);
		estilo.setBorderLeft(BorderStyle.MEDIUM);
		estilo.setLeftBorderColor((short)8);
		estilo.setBorderRight(BorderStyle.MEDIUM);
		estilo.setRightBorderColor((short)8);
		estilo.setBorderTop(BorderStyle.MEDIUM);
		estilo.setTopBorderColor((short)8);
		estilo.setAlignment(HorizontalAlignment.GENERAL);

		// Establecemos el tipo de sombreado de nuestra celda
		estilo.setFillForegroundColor((short)15);
		estilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		return estilo;
		
	}
	
	public static CellStyle estiloContenido(Workbook libro) {
		
		CellStyle estilo = libro.createCellStyle();
		
		estilo.setFillForegroundColor((short)22);
		estilo.setBorderBottom(BorderStyle.HAIR);
		
		return estilo;
		
	}
}
