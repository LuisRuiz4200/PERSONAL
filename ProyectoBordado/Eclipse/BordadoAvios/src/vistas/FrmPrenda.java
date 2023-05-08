package vistas;

import javax.swing.*;
import java.awt.SystemColor;
import javax.swing.table.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import clases.*;
import reuzables.Custom;
import arreglos.*;

@SuppressWarnings("serial")
public class FrmPrenda extends JFrame implements ActionListener{
	private JTable table;
	private JLabel lblCodPrenda;
	private JTextField txtCodPrenda;
	private JLabel lblDesPrenda;
	private JTextField txtDesPrenda;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel panelBtnMantener;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private ArregloPrenda arrPrenda;
	
	public static void main (String[] args) {
		FrmPrenda ventana = new FrmPrenda();
		ventana.setVisible(true);
	}
	
	public FrmPrenda() {
		
		this.setTitle("PRENDA");
		this.setBounds(0,0,429,326);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(166, 25, 237, 235);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblCodPrenda = new JLabel("Cod. Prenda");
		lblCodPrenda.setBounds(10, 25, 75, 14);
		getContentPane().add(lblCodPrenda);
		
		txtCodPrenda = new JTextField();
		txtCodPrenda.setBounds(10, 38, 61, 20);
		getContentPane().add(txtCodPrenda);
		txtCodPrenda.setColumns(10);
		
		lblDesPrenda = new JLabel("Prenda");
		lblDesPrenda.setBounds(10, 69, 75, 14);
		getContentPane().add(lblDesPrenda);
		
		txtDesPrenda = new JTextField();
		txtDesPrenda.setBounds(10, 84, 111, 20);
		getContentPane().add(txtDesPrenda);
		txtDesPrenda.setColumns(10);
		
		panelBtnMantener = new JPanel();
		panelBtnMantener.setBackground(SystemColor.activeCaption);
		panelBtnMantener.setBounds(10, 154, 111, 106);
		getContentPane().add(panelBtnMantener);
		panelBtnMantener.setLayout(null);
		
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
		
		model = new DefaultTableModel();
		model.addColumn("COD. PRENDA");
		model.addColumn("DESCRIPCION");
		table.setModel(model);
		
		arrPrenda = new ArregloPrenda();
		
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
		int codPrenda = leerCodPrenda();
		String desPrenda = leerDesPrenda();
		
		Prenda prenda = new Prenda(codPrenda,desPrenda);
		
		arrPrenda.adicionar(prenda);
		arrPrenda.grabarPrenda();
		
		listarPrenda();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		int codPrenda = leerCodPrenda();
		String desPrenda = leerDesPrenda();
		
		for(int i=0; i<arrPrenda.tamaño();i++) {
			if(codPrenda == arrPrenda.obtener(i).getCodPrenda()) {
				arrPrenda.obtener(i).setDesPrenda(desPrenda);
				Custom.mensajeExito(this, "Modificado con exito");
			}
		}
		
		listarPrenda();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int codPrenda = leerCodPrenda();
		
		for(int i=0; i<arrPrenda.tamaño();i++) {
			if(codPrenda == arrPrenda.obtener(i).getCodPrenda()) {
				if(Custom.mensajeConfirmacion(this, "SEGURO QUIERE ELIMINAR ESTA FILA")==0) {
					arrPrenda.eliminar(arrPrenda.obtener(i));
					arrPrenda.grabarPrenda();
				}else {
					Custom.mensajeAdvertencia(this, "Operacion cancelada");
				}
			}
		}
		
		listarPrenda();
	}
	
	//METODOS DE LECTURA
	
	private int leerCodPrenda() {
		int res=-1;
		
		res = Integer.parseInt(txtCodPrenda.getText());
		
		return res;
	}
	
	private String leerDesPrenda() {
		String res = null;
		
		res = txtDesPrenda.getText();
		
		return res;
	}
	
	//METODOS ADICIONALES
	
	private void arranque() {
		listarPrenda();
	}
	
	private void listarPrenda() {
		model.setRowCount(0);
		for(int i=0;i<arrPrenda.tamaño();i++) {
			Object[] x = {
				arrPrenda.obtener(i).getCodPrenda(),
				arrPrenda.obtener(i).getDesPrenda()
			};
			model.addRow(x);
		}
	}
}
