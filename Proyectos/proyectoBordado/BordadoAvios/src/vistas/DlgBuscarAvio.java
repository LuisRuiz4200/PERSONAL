package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import clases.*;
import arreglos.*;

@SuppressWarnings("serial")
public class DlgBuscarAvio extends JDialog implements ActionListener, MouseListener{
	private JTable table;
	private JTextField txtCodAvio;
	private JLabel lblCodAvio;
	private JButton btnAceptar;
	private JLabel lblTipoAvio;
	private JComboBox<Object> cboTipoAvio;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	public static String frame;
	
	
	public static void main (String[] args) {
		//DlgConsultaAvio ventana = new DlgConsultaAvio(,true);
		//ventana.setVisible(true);
	}
	
	public DlgBuscarAvio(JFrame frame, boolean bandera) {
		
		//MODAL 
		super(frame, bandera);
		
		this.setTitle("CONSULTA AVIO");
		this.setBounds(0,0,458,326);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 414, 177);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		txtCodAvio = new JTextField();
		txtCodAvio.setBounds(106, 26, 86, 20);
		getContentPane().add(txtCodAvio);
		txtCodAvio.setColumns(10);
		
		lblCodAvio = new JLabel("Cod. Avio");
		lblCodAvio.setBounds(106, 10, 86, 14);
		getContentPane().add(lblCodAvio);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(335, 39, 89, 23);
		getContentPane().add(btnAceptar);
		
		lblTipoAvio = new JLabel("Tipo Avio");
		lblTipoAvio.setBounds(10, 10, 86, 14);
		getContentPane().add(lblTipoAvio);
		
		cboTipoAvio = new JComboBox<Object>();
		cboTipoAvio.addActionListener(this);
		cboTipoAvio.setBounds(10, 25, 86, 22);
		getContentPane().add(cboTipoAvio);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("COD AVIO");
		modelo.addColumn("TIPO");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("MEDIDA");
		table.setModel(modelo);
		
		arranque();
	}
	
	//ACTION EVENT
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboTipoAvio) {
			actionPerformedCboTipoAvio(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		
		
		int codAvio = (int) table.getValueAt(table.getSelectedRow(), 0);
		
		ArregloAvio arrAvio = new ArregloAvio();
		ArregloUniMed arrUM = new ArregloUniMed();
		
		Avio objAvio = arrAvio.buscar(codAvio);
		
		switch (frame){
			case "FrmIngresoAvio":
				
				FrmIngresoAvio.txtCodAvio.setText(objAvio.getCodAvio() + "");
				
				this.dispose();
				break;
				
			default:
		}		
		
	}
	protected void actionPerformedCboTipoAvio(ActionEvent e) {
	}
	
	//MOUSE EVENT
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
		mostrarAvio();
	}
	
	//METODO DE ENTRADA
	
	private int leerCodAvio (){
		int res = -1;
		
		res = Integer.parseInt(txtCodAvio.getText());
		
		return res;
	}
	
	private String leerTipoAvio() {
		String res = null;
		
		res = cboTipoAvio.getSelectedItem().toString();
		
		return null;
	}
	
	//METODO ADICIONAL
	
	private void arranque() {
		cargarTipoAvio();
		listarAvio();
	}
	
	private void cargarTipoAvio() {
		ArregloTipoAvio arrTipoAvio = new ArregloTipoAvio();
		
		cboTipoAvio.setSelectedIndex(-1);
		
		for (int i=0;i<arrTipoAvio.tamano();i++) {
			
			cboTipoAvio.addItem(arrTipoAvio.obtener(i).getDesTipoAvio());
			
		}
	}
	
	private void listarAvio() {
		
		ArregloAvio arrAvio = new ArregloAvio();
		ArregloTipoAvio arrTipoAvio = new ArregloTipoAvio();
		ArregloUniMed arrUM = new ArregloUniMed();
		
		modelo.setRowCount(0);
		
		for (int i=0;i<arrAvio.tamano();i++) {
			
			Object[] x = {
					arrAvio.obtener(i).getCodAvio(),
					arrTipoAvio.buscar(arrAvio.obtener(i).getCodTipoAvio()).getDesTipoAvio(),
					arrAvio.obtener(i).getDesAvio(),
					arrAvio.obtener(i).getMedidaAvio() + arrUM.buscar(arrAvio.obtener(i).getCodUM()).getDesUM()
			};
			
			modelo.addRow(x);
			
		}
	}
	
	private void mostrarAvio() {
		
		int indice = table.getSelectedRow();
		
		String codAvio = table.getValueAt(indice, 0).toString();
		
		txtCodAvio.setText(codAvio);
		
	}
	

}
