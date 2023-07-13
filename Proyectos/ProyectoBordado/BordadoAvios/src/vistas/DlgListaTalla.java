package vistas;

import javax.security.auth.x500.X500Principal;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import arreglos.ArregloDetPedidoOP;
import arreglos.ArregloTalla;
import clases.Talla;
import reuzables.Custom;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class DlgListaTalla extends JDialog implements ActionListener, ItemListener{
	private JTable tbTalla;
	private JComboBox cboTipoTalla;
	private JButton btnElegir;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	
	private ArregloTalla arrTalla = new ArregloTalla();
	
	public static String frame = "";
	
	public static void main (String[] args) {
		DlgListaTalla ventana = new DlgListaTalla(null,true);
		ventana.setVisible(true);
	}
	
	public DlgListaTalla(JFrame frame, Boolean x) {
		super(frame,x);
		
		this.setTitle("TALLAS");
		this.setBounds(0,0,429,326);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 195, 208);
		getContentPane().add(scrollPane);
		
		tbTalla = new JTable();
		scrollPane.setViewportView(tbTalla);
		
		cboTipoTalla = new JComboBox();
		cboTipoTalla.addItemListener(this);
		cboTipoTalla.setBounds(10, 11, 113, 22);
		getContentPane().add(cboTipoTalla);
		
		btnElegir = new JButton("ELEGIR");
		btnElegir.addActionListener(this);
		btnElegir.setBounds(182, 11, 89, 23);
		getContentPane().add(btnElegir);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("TALLA");
		tbTalla.setModel(modelo);
		
		tbTalla.setAutoResizeMode(0);
		
		tbTalla.getColumn("ID").setPreferredWidth(40);
		tbTalla.getColumn("TALLA").setPreferredWidth(60);
		
		DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
		Alinear.setHorizontalAlignment(SwingConstants.CENTER);//.LEFT .RIGHT .CENTER
	
		tbTalla.getColumn("ID").setCellRenderer(Alinear);
		tbTalla.getColumn("TALLA").setCellRenderer(Alinear);

		
		tbTalla.setAlignmentX(RIGHT_ALIGNMENT);


		arranque();
		
	}

	private void arranque() {
		// TODO Auto-generated method stub
		cargarTablaTalla();
		cargarCboTipoTalla();
	}
	
	private void exportarTalla() {
		
		int [] filas = tbTalla.getSelectedRows();
		
		switch (frame) {
		case "FrmPedidoOP":
			
			FrmPedidoOP.modelo.setRowCount(0);
			
			int item = 1;
			
			for (int n : filas) {
				
				int idTalla =(int) tbTalla.getValueAt(n, 0);
				
				
				Talla objTalla = arrTalla.buscar(idTalla);
				
				FrmPedidoOP.modelo.addRow(new Object[] {item ++,objTalla.getDes_talla(),""});
			}
			
			this.dispose();
			
			break;
		case "":
			break;
		case "2":
			break;
		default:
			
			break;
		}
	}
	
	private void imprimirFilas() {
		
		int [] filas = tbTalla.getSelectedRows();
		
		for (int i=0;i<filas.length;i++) {
			System.out.println(filas[i]);
		}
		
		
		
	}

	private void cargarCboTipoTalla() {

		cboTipoTalla.addItem("TODOS");
		cboTipoTalla.addItem("NUMEROS");
		cboTipoTalla.addItem("LETRAS");
		cboTipoTalla.addItem("PARES");
	}
	
	private void cargarTablaTalla() {
		
		modelo.setRowCount(0);
		
		arrTalla.listar().forEach((c)->modelo.addRow(new Object[] {c.getId_talla(),c.getDes_talla()}));
		
		
	}
	
	private void filtrarTablaTalla() {
		
		TableRowSorter<TableModel> filtro =new TableRowSorter<TableModel>(modelo);
		tbTalla.setRowSorter(filtro);
		
		switch(getTipoTalla()) {
		case 0:
			filtro.setRowFilter(RowFilter.regexFilter("", 1));
			break;
		case 1:
			filtro.setRowFilter(RowFilter.regexFilter("[0-9]$", 1));
			break;
		case 2:
			filtro.setRowFilter(RowFilter.regexFilter("[a-zA-Z]$", 1));
			break;
		case 3:
			filtro.setRowFilter(RowFilter.regexFilter("(0|2|4|6|8)$", 1));
			break;
		default:
			Custom.mensajeAdvertencia(this, "DEFAULT");
			break;
		}
	}
	
	//GETTER
	
	private int getTipoTalla() {
		return cboTipoTalla.getSelectedIndex();
	}
	
	//ACTION LISTENER
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnElegir) {
			actionPerformedBtnElegir(e);
		}
	}
	protected void actionPerformedBtnElegir(ActionEvent e) {
		//imprimirFilas();
		exportarTalla();
	}
	//ITEM LISTENER
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboTipoTalla) {
			itemStateChangedCboTipoTalla(e);
		}
	}
	protected void itemStateChangedCboTipoTalla(ItemEvent e) {
		filtrarTablaTalla();
		return;
	}
}
