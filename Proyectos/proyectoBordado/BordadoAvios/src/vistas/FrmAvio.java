package vistas;

import javax.swing.*;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import clases.*;
import arreglos.*;

@SuppressWarnings("serial")
public class FrmAvio extends JFrame implements ActionListener, MouseListener{
	private JLabel lblCodTipoAvio;
	private JComboBox <Object>cboCodTipoAvio;
	private JLabel lblCodAvio;
	private JTextField txtCodAvio;
	private JTextField txtDesAvio;
	private JLabel lblDesAvio;
	private JTextField txtMedidaAvio;
	private JLabel lblMedidaAvio;
	private JComboBox <Object>cboCodUnidadMedida;
	private JLabel lblCodUnidadMedida;
	private JTable table;
	private JPanel panelBtnMantener;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private ArregloAvio arrAvio;
	
	
	public static void main (String[] args) {
		FrmAvio ventana = new FrmAvio();
		ventana.setVisible(true);
	}
	
	public FrmAvio() {
		
		this.setTitle("MANTENIMIENTO AVIO");
		this.setBounds(0,0,556,322);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		lblCodTipoAvio = new JLabel("Tipo de Avio");
		lblCodTipoAvio.setBounds(106, 11, 111, 14);
		getContentPane().add(lblCodTipoAvio);
		
		cboCodTipoAvio = new JComboBox<Object>();
		cboCodTipoAvio.setBounds(106, 28, 111, 22);
		getContentPane().add(cboCodTipoAvio);
		
		lblCodAvio = new JLabel("Cod. Avio");
		lblCodAvio.setBounds(10, 11, 86, 14);
		getContentPane().add(lblCodAvio);
		
		txtCodAvio = new JTextField();
		txtCodAvio.setBounds(10, 29, 86, 20);
		getContentPane().add(txtCodAvio);
		txtCodAvio.setColumns(10);
		
		txtDesAvio = new JTextField();
		txtDesAvio.setColumns(10);
		txtDesAvio.setBounds(234, 29, 220, 20);
		getContentPane().add(txtDesAvio);
		
		lblDesAvio = new JLabel("Descripcion");
		lblDesAvio.setBounds(234, 11, 86, 14);
		getContentPane().add(lblDesAvio);
		
		txtMedidaAvio = new JTextField();
		txtMedidaAvio.setColumns(10);
		txtMedidaAvio.setBounds(10, 78, 80, 20);
		getContentPane().add(txtMedidaAvio);
		
		lblMedidaAvio = new JLabel("Medida");
		lblMedidaAvio.setBounds(10, 60, 46, 14);
		getContentPane().add(lblMedidaAvio);
		
		cboCodUnidadMedida = new JComboBox<Object>();
		cboCodUnidadMedida.setBounds(106, 76, 67, 22);
		getContentPane().add(cboCodUnidadMedida);
		
		lblCodUnidadMedida = new JLabel("UM");
		lblCodUnidadMedida.setBounds(106, 59, 46, 14);
		getContentPane().add(lblCodUnidadMedida);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(183, 81, 343, 182);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		panelBtnMantener = new JPanel();
		panelBtnMantener.setLayout(null);
		panelBtnMantener.setBackground(SystemColor.activeCaption);
		panelBtnMantener.setBounds(10, 157, 111, 106);
		getContentPane().add(panelBtnMantener);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(10, 11, 89, 23);
		panelBtnMantener.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(10, 39, 89, 23);
		panelBtnMantener.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(10, 68, 89, 23);
		panelBtnMantener.add(btnEliminar);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("COD. AVIO");
		modelo.addColumn("TIPO");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("MEDIDA");
		modelo.addColumn("UM");
		table.setModel(modelo);
		
		arrAvio = new ArregloAvio();

		//PROPIEDADES DE LA TABLA
		table.setAutoResizeMode(0);
		
		arranque();
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		int codAvio = leerCodAvio();
		int codTipoAvio = leerCodTipoAvio();
		String desAvio = leerDesAvio();
		String medidaAvio = leerMedidaAvio();
		int codUnidadMedida = leerCodUnidadMedida();
		
		Avio avio = new Avio (codAvio,codTipoAvio,desAvio,medidaAvio,codUnidadMedida);
		
		arrAvio.adicionar(avio);
		arrAvio.grabarAvio();
		listarAvio();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
	}
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
	}
	
	//METODOS DE ENTRADA
	
	private int leerCodAvio() {
		int res = -1;
		
		res = Integer.parseInt(txtCodAvio.getText().trim());
		
		return res;
	}
	
	private int leerCodTipoAvio() {
		int res = -1;
		
		res = cboCodTipoAvio.getSelectedIndex()+1;
		
		return res;
	}
	
	private String leerDesAvio() {
		String res = null;
		
		res = txtDesAvio.getText();
		
		return res;
	}
	
	private String leerMedidaAvio() {
		String res = null;
		
		res=txtMedidaAvio.getText();
		
		return res;
	}
	
	private int leerCodUnidadMedida() {
		int res = -1;
		
		res=cboCodUnidadMedida.getSelectedIndex()+1;
		
		return res;
	}
	
	//METODOS ADICIONALES
	
	private void arranque() {
		cargarTipoAvio();
		listarAvio();
		cargarUnidadMedida();
	}
	
	private void listarAvio () {
		
		ArregloTipoAvio arrTipoAvio = new ArregloTipoAvio();
		ArregloUniMed arrUnidadMedida = new ArregloUniMed();
		
		modelo.setRowCount(0);
		for(int i=0;i<arrAvio.tamano();i++) {
			Object[] x = {
				arrAvio.obtener(i).getCodAvio(),
				arrTipoAvio.buscar(arrAvio.obtener(i).getCodTipoAvio()).getDesTipoAvio(),
				arrAvio.obtener(i).getDesAvio(),
				arrAvio.obtener(i).getMedidaAvio(),
				arrUnidadMedida.buscar(arrAvio.obtener(i).getCodUM()).getDesUM()
			};
			
			modelo.addRow(x);
			
		}
	}
	
	private void cargarTipoAvio() {
		ArregloTipoAvio arrTipoAvio = new ArregloTipoAvio();
		
		cboCodTipoAvio.setSelectedIndex(-1);
		
		for (int i=0;i<arrTipoAvio.tamano();i++) {
			cboCodTipoAvio.addItem(arrTipoAvio.obtener(i).getDesTipoAvio());
		}
	}
	
	private void cargarUnidadMedida() {
		ArregloUniMed arrUM = new ArregloUniMed();
		
		cboCodUnidadMedida.setSelectedIndex(-1);
		
		for(int i=0;i<arrUM.tamano();i++) {
			cboCodUnidadMedida.addItem(arrUM.obtener(i).getDesUM());
		}
	}
}
