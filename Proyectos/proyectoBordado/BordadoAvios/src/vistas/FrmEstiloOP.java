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
public class FrmEstiloOP extends JFrame implements ActionListener, MouseListener{
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panelBtnMantener;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblCodEstiloOP;
	private JTextField txtCodEstiloOP;
	private JTextField txtDesEstiloOP;
	private JLabel lblDesEstiloOP;
	private JLabel lblCodPrenda;
	private JComboBox <Object>cboCodPrenda;
	private DefaultTableModel modelo;
	private ArregloEstiloOP arrEstiloOP;
	
	public static void main (String[] args) {
		FrmEstiloOP ventana = new FrmEstiloOP();
		ventana.setVisible(true);
	}
	
	public FrmEstiloOP() {
		
		this.setTitle("ESTILO DE OP");
		this.setBounds(0,0,429,326);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(this);
		scrollPane.setBounds(134, 91, 269, 185);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panelBtnMantener = new JPanel();
		panelBtnMantener.setLayout(null);
		panelBtnMantener.setBackground(SystemColor.activeCaption);
		panelBtnMantener.setBounds(10, 170, 111, 106);
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
		
		lblCodEstiloOP = new JLabel("Cod. Estilo");
		lblCodEstiloOP.setBounds(10, 11, 86, 14);
		getContentPane().add(lblCodEstiloOP);
		
		txtCodEstiloOP = new JTextField();
		txtCodEstiloOP.setBounds(10, 27, 86, 20);
		getContentPane().add(txtCodEstiloOP);
		txtCodEstiloOP.setColumns(10);
		
		txtDesEstiloOP = new JTextField();
		txtDesEstiloOP.setColumns(10);
		txtDesEstiloOP.setBounds(122, 27, 86, 20);
		getContentPane().add(txtDesEstiloOP);
		
		lblDesEstiloOP = new JLabel("Descripcion");
		lblDesEstiloOP.setBounds(122, 11, 86, 14);
		getContentPane().add(lblDesEstiloOP);
		
		lblCodPrenda = new JLabel("Prenda");
		lblCodPrenda.setBounds(230, 11, 62, 14);
		getContentPane().add(lblCodPrenda);
		
		cboCodPrenda = new JComboBox<Object>();
		cboCodPrenda.setBounds(230, 26, 111, 22);
		getContentPane().add(cboCodPrenda);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("COD. ESTILO");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("PRENDA");
		table.setModel(modelo);
		
		arrEstiloOP = new ArregloEstiloOP();
		
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
		int codEstiloOP = leerCodEstiloOP();
		String desEstiloOP = leerDesEstiloOP();
		int codPrenda = leerCodPrenda();
		
		EstiloOP estiloOP = new EstiloOP (codEstiloOP,desEstiloOP,codPrenda);
		
		arrEstiloOP.adicionar(estiloOP);
		arrEstiloOP.grabarEstiloOp();
		listarEstiloOP();
		
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == scrollPane) {
			mouseClickedScrollPane(e);
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
	protected void mouseClickedScrollPane(MouseEvent e) {
	}
	
	//METODO DE ENTRADA
	
	private int leerCodEstiloOP () {
		int res=-1;
		
		res = Integer.parseInt(txtCodEstiloOP.getText().trim());
		
		return res;
	}
	
	private String leerDesEstiloOP() {
		String res = null;
		
		res = txtDesEstiloOP.getText().trim();
		
		return res;
	}
	
	private int leerCodPrenda() {
		int res =  -1;
		
		res = cboCodPrenda.getSelectedIndex()+1;
		
		return res;
	}
	
	//METODOS ADICIONALES
	private void arranque() {
		listarEstiloOP();
		cargarPrenda();
	}
	
	private void listarEstiloOP() {
		modelo.setRowCount(0);
		ArregloPrenda arrPrenda= new ArregloPrenda();
		
		for(int i=0;i<arrEstiloOP.tamano();i++) {
			Object[] x = {
					arrEstiloOP.obtener(i).getCodEstiloOp(),
					arrEstiloOP.obtener(i).getDesEstiloOp(),
					arrPrenda.obtener(arrEstiloOP.obtener(i).getCodPrenda()-1).getDesPrenda()
			};
			modelo.addRow(x);
		}
	}
	
	private void cargarPrenda() {
		ArregloPrenda arrPrenda= new ArregloPrenda();
		cboCodPrenda.setSelectedIndex(-1);
		for(int i=0;i<arrPrenda.tamano();i++) {
			cboCodPrenda.addItem(arrPrenda.obtener(i).getDesPrenda().toString());
		}
	}
}
