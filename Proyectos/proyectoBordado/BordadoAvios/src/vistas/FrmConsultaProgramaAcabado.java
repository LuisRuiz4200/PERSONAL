package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

import arreglos.ArregloColorOP;
import arreglos.ArregloF10;
import arreglos.ArregloProgramaAcabado;
import clases.ColorOP;
import clases.F10;
import clases.ProgramaAcabado;
import reuzables.Custom;
import reuzables.Excel;
import reuzables.ExcelAspose;

import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import java.util.stream.Stream;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmConsultaProgramaAcabado extends JInternalFrame implements KeyListener, MouseListener, ActionListener{
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtNroOP;
	private JLabel lblNroOP;
	private DefaultTableModel modelo;
	private ArregloProgramaAcabado arrProgramaAcabado = new ArregloProgramaAcabado();
	private JButton btnEditar;
	private JButton btnAgregar;
	private JPanel panelProgramaAcabado;
	private JTextField txtColor;
	private JTextField txtAcabado;
	private JTextPane txtObsPrograma;
	private JTextField txtIdPrograma;
	private JLabel lblColor;
	private JLabel lblAcabado;
	private JLabel lblObsPrograma;
	private JLabel lblIdPrograma;
	private JTextField txtEstado;
	private JTextField txtFechaActualizada;
	private JLabel lblFechaActPrograma;
	private JLabel lblEstadoPrograma;
	private JTextField txtCliente;
	private JLabel lblCliente;
	private JButton btnExportarExcel;
	
	public static void main (String[] args) {
		FrmConsultaProgramaAcabado ventana = new FrmConsultaProgramaAcabado();
		ventana.setVisible(true);
	}
	
	public FrmConsultaProgramaAcabado() {
		
		this.setTitle("CONSULTA DEL PROGRAMA DE ACABADOS");
		this.setBounds(0,0,879,467);
		//this.setLocationRelativeTo(this);
		
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(true);
		
		this.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 843, 297);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("NRO OP");
		modelo.addColumn("COLOR");
		modelo.addColumn("PEDIDO");
		modelo.addColumn("PROGRAMA");
		modelo.addColumn("CONFECCION");
		modelo.addColumn("ACABADO");
		modelo.addColumn("OBSERVACION");
		modelo.addColumn("REGISTRADO");
		modelo.addColumn("ACTUALIZADO");
		modelo.addColumn("ESTADO");
		table.setModel(modelo);
		
		table.setAutoResizeMode(0);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(657, 98, 89, 23);
		getContentPane().add(btnEditar);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(764, 98, 89, 23);
		getContentPane().add(btnAgregar);
		
		table.getColumn("ID").setPreferredWidth(40);
		table.getColumn("COLOR").setPreferredWidth(250);
		table.getColumn("CONFECCION").setPreferredWidth(100);
		table.getColumn("ACABADO").setPreferredWidth(100);
		table.getColumn("OBSERVACION").setPreferredWidth(200);
		table.getColumn("REGISTRADO").setPreferredWidth(100);
		table.getColumn("ACTUALIZADO").setPreferredWidth(100);
		table.getColumn("ESTADO").setPreferredWidth(100);
		
		table.setAutoCreateRowSorter(true);
		
		
		
		panelProgramaAcabado = new JPanel();
		panelProgramaAcabado.setBounds(10, 11, 592, 99);
		getContentPane().add(panelProgramaAcabado);
		panelProgramaAcabado.setLayout(null);
		
		txtColor = new JTextField();
		txtColor.setBounds(106, 25, 208, 20);
		panelProgramaAcabado.add(txtColor);
		txtColor.setColumns(10);
		
		txtAcabado = new JTextField();
		txtAcabado.setColumns(10);
		txtAcabado.setBounds(228, 68, 86, 20);
		panelProgramaAcabado.add(txtAcabado);
		
		txtObsPrograma = new JTextPane();
		txtObsPrograma.setBounds(324, 25, 258, 63);
		panelProgramaAcabado.add(txtObsPrograma);
		
		txtIdPrograma = new JTextField();
		txtIdPrograma.setBounds(10, 68, 57, 20);
		panelProgramaAcabado.add(txtIdPrograma);
		txtIdPrograma.setColumns(10);
		
		txtNroOP = new JTextField();
		txtNroOP.setBounds(10, 25, 86, 20);
		panelProgramaAcabado.add(txtNroOP);
		txtNroOP.addKeyListener(this);
		txtNroOP.setColumns(10);
		
		lblNroOP = new JLabel("NRO OP");
		lblNroOP.setBounds(10, 12, 72, 14);
		panelProgramaAcabado.add(lblNroOP);
		
		lblColor = new JLabel("COLOR");
		lblColor.setBounds(106, 12, 72, 14);
		panelProgramaAcabado.add(lblColor);
		
		lblAcabado = new JLabel("ACABADO");
		lblAcabado.setBounds(228, 55, 72, 14);
		panelProgramaAcabado.add(lblAcabado);
		
		lblObsPrograma = new JLabel("OBSERVACION");
		lblObsPrograma.setBounds(324, 12, 105, 14);
		panelProgramaAcabado.add(lblObsPrograma);
		
		lblIdPrograma = new JLabel("ID");
		lblIdPrograma.setBounds(10, 53, 72, 14);
		panelProgramaAcabado.add(lblIdPrograma);
		
		txtCliente = new JTextField();
		txtCliente.setText("");
		txtCliente.setColumns(10);
		txtCliente.setBounds(106, 69, 112, 20);
		panelProgramaAcabado.add(txtCliente);
		
		lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(106, 56, 72, 14);
		panelProgramaAcabado.add(lblCliente);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(753, 33, 86, 20);
		getContentPane().add(txtEstado);
		
		txtFechaActualizada = new JTextField();
		txtFechaActualizada.setColumns(10);
		txtFechaActualizada.setBounds(612, 33, 134, 20);
		getContentPane().add(txtFechaActualizada);
		
		lblFechaActPrograma = new JLabel("FECHA ACTUALIZADA");
		lblFechaActPrograma.setBounds(612, 11, 134, 14);
		getContentPane().add(lblFechaActPrograma);
		
		lblEstadoPrograma = new JLabel("ESTADO");
		lblEstadoPrograma.setBounds(756, 11, 92, 14);
		getContentPane().add(lblEstadoPrograma);
		
		btnExportarExcel = new JButton("EXCEL");
		btnExportarExcel.addActionListener(this);
		btnExportarExcel.setBounds(657, 64, 89, 23);
		getContentPane().add(btnExportarExcel);
		
		arranque();
	}

	//METODOS VOID
	private void arranque() {

		limpiar();
		listarProgramaAcabado();
	}
	
	private void listarProgramaAcabado() {
		
		modelo.setRowCount(0);
		
		for(int i=0;i<arrProgramaAcabado.tamano();i++) {
			
			ProgramaAcabado obj = arrProgramaAcabado.obtener(i);
			
			Object[] x = new Object[] {
					obj.getCod_programaAcabado(),
					obj.getNro_OP(),
					obj.getCod_colorOP(),
					obj.getCantPed_programaAcabado(),
					obj.getCantProg_programaAcabado(),
					obj.getCod_citiConfeccion(),
					obj.getCod_citiAcabado(),
					obj.getObs_programaAcabado(),
					new SimpleDateFormat("dd MMM yyy").format(obj.getFechaReg_programaAcabado()),
					new SimpleDateFormat("dd MMM yyy").format(obj.getFechaAct_programaAcabado()),
					obj.getEstado_programaAcabado()
					
			};
			
			modelo.addRow(x);
		}
	}
	
	private void filtrarOP() {
		
		String nroOP = txtNroOP.getText();
		
		TableRowSorter<TableModel> filtro = new TableRowSorter<TableModel>(modelo);
		table.setRowSorter(filtro);
		filtro.setRowFilter(RowFilter.regexFilter(nroOP, 1));;
		
	}
	
	private void limpiar() {
		
		txtIdPrograma.setText("");
		txtNroOP.setText("");
		txtColor.setText("");
		txtAcabado.setText("");
		txtObsPrograma.setText("");
		txtEstado.setText("");
		txtFechaActualizada.setText("");
		
		txtIdPrograma.setEditable(false);
		txtColor.setEditable(false);
		txtAcabado.setEditable(false);
		txtObsPrograma.setEditable(false);
		txtEstado.setEditable(false);
		txtFechaActualizada.setEditable(false);
		txtCliente.setEditable(false);
		
		txtNroOP.requestFocus();
	}
	
	private void mostrarPrograma() {
		int n = table.getSelectedRow();
		
		ArregloF10 arrF10 = new ArregloF10();
		
		int nroOP =(int) table.getValueAt(n, 1);
		int idPrograma = arrProgramaAcabado.buscar((int)table.getValueAt(n, 0)).getCod_programaAcabado();
		String color = arrProgramaAcabado.buscar((int)table.getValueAt(n, 0)).getCod_colorOP();
		String acabado = arrProgramaAcabado.buscar((int)table.getValueAt(n, 0)).getCod_citiAcabado();
		String obsPrograma = arrProgramaAcabado.buscar((int)table.getValueAt(n, 0)).getObs_programaAcabado();
		String estado = arrProgramaAcabado.buscar((int)table.getValueAt(n, 0)).getEstado_programaAcabado();
		Date fechaActualizada = arrProgramaAcabado.buscar((int)table.getValueAt(n, 0)).getFechaAct_programaAcabado();
		String cliente = arrF10.buscarPorNroOPYColorOP(nroOP, color).getCliente_F10();
		
		txtIdPrograma.setText(idPrograma + "");
		txtNroOP.setText(nroOP + "");
		txtColor.setText(color);
		txtAcabado.setText(acabado);
		txtObsPrograma.setText(obsPrograma);
		txtEstado.setText(estado);
		txtFechaActualizada.setText(new SimpleDateFormat("dd MMM yyy hh:mm:ss").format(fechaActualizada));
		txtCliente.setText(cliente);
		
	}
	
	
	//KEY RELEASED (LLAVE LIBERADA) PARA TXT_NRO_OP
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtNroOP) {
			keyReleasedTxtNroOP(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtNroOP(KeyEvent e) {
		filtrarOP();
		
		if(txtNroOP.getText().length()<5) {
			txtColor.setText("");
			txtEstado.setText("");
			txtAcabado.setText("");
			txtFechaActualizada.setText("");
			txtIdPrograma.setText("");
			txtObsPrograma.setText("");
			txtCliente.setText("");
		}
	}
	
	//MOUSE CLIKED
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTable(MouseEvent e) {
		mostrarPrograma();
	}
	//ACTION PERFORMED
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExportarExcel) {
			actionPerformedBtnExportarExcel(e);
		}
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		if(e.getSource()== btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	private void actionPerformedBtnAgregar(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmProgramaAcabado frame = new FrmProgramaAcabado();
		FrmPrincipal.escritorio.add(frame);
		frame.setVisible(true);
		this.dispose();
		
	}

	private void actionPerformedBtnEditar(ActionEvent e) {
		
		int n = table.getSelectedRow();
		
		if(n==-1) {
			Custom.mensajeAdvertencia(this, "ELIGA UNA FILA DE LA TABLA");
			return;
		}
		
		int id = (int) table.getValueAt(n, 0);
		
		int nroOP = arrProgramaAcabado.buscar(id).getNro_OP();
		String colorOP = arrProgramaAcabado.buscar(id).getCod_colorOP();
		String confeccion = arrProgramaAcabado.buscar(id).getCod_citiConfeccion();
		String acabado = arrProgramaAcabado.buscar(id).getCod_citiAcabado();
		String obsPrograma = arrProgramaAcabado.buscar(id).getObs_programaAcabado();
		Date fechaReg = arrProgramaAcabado.buscar(id).getFechaReg_programaAcabado();
		
		ArregloF10 arrF10 = new ArregloF10();
		F10 objF10 = arrF10.buscarPorNroOPYColorOP(nroOP,colorOP);
		
		//INICIALIZACION DE LA NUEVA VENTANA
		FrmProgramaAcabado frame = new FrmProgramaAcabado();
		FrmPrincipal.escritorio.add(frame);
		frame.setVisible(true);
		
		//RETORNAMOS EL ID DEL DOCUMENTO
		FrmProgramaAcabado.txtCodPrograma.setText(id+"");
		
		//PANEL ORDEN DE PRODUCCION
		FrmProgramaAcabado.txtNroOP.setText(objF10.getNroOP_F10()+"");
		FrmProgramaAcabado.txtClienteOP.setText(objF10.getCliente_F10());
		FrmProgramaAcabado.txtEstiloOP.setText(objF10.getEstilo_F10());
		FrmProgramaAcabado.txtColorOP.setText(objF10.getColor_F10());
		FrmProgramaAcabado.txtPrendaOP.setText(objF10.getPrenda_F10());
		FrmProgramaAcabado.txtIdF10.setText(objF10.getId_F10()+"");
		
		//PANEL CONFECCION Y ACABADO
		FrmProgramaAcabado.txtCodCitiConfeccion.setText(confeccion);
		FrmProgramaAcabado.txtCodCitiAcabado.setText(acabado);
		
		//OBSERVACIONES Y FECHA DE REGISTRO
		FrmProgramaAcabado.txtObsPrograma.setText(obsPrograma);
		FrmProgramaAcabado.txtFechaReg.setText(new SimpleDateFormat("dd/MM/yyy").format(fechaReg).toString());
		
		//BOTONES DE FUNCION
		FrmProgramaAcabado.btnGrabar.setEnabled(false);
		FrmProgramaAcabado.btnEditar.setEnabled(true);
		FrmProgramaAcabado.txtNroOP.setEditable(false);
		FrmProgramaAcabado.btnEliminar.setEnabled(true);
		
		this.dispose();
		
	}
	protected void actionPerformedBtnExportarExcel(ActionEvent e) {
		
		Excel.generarExcel(this, "ProgramaAcabdo", table);
		//FrmPrincipal.reiniciar();
		
	}
}
