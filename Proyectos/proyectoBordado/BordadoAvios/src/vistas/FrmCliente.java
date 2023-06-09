package vistas;

import javax.swing.*;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import clases.*;
import reuzables.Custom;
import arreglos.*;

@SuppressWarnings("serial")
public class FrmCliente extends JFrame implements ActionListener, MouseListener{
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblCodCliente;
	private JTextField txtCodCliente;
	private JTextField txtDesCliente;
	private JLabel lblDesCliente;
	private JPanel panelBtnMantener;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private DefaultTableModel modelo;
	private ArregloCliente arrCliente;
	
	public static void main (String[] args) {
		FrmCliente ventana = new FrmCliente();
		ventana.setVisible(true);
	}
	
	public FrmCliente() {
		
		this.setTitle("CLIENTE");
		this.setBounds(0,0,429,326);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 63, 273, 202);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		lblCodCliente = new JLabel("Cod Cliente");
		lblCodCliente.setBounds(10, 11, 86, 14);
		getContentPane().add(lblCodCliente);
		
		txtCodCliente = new JTextField();
		txtCodCliente.setBounds(10, 32, 86, 20);
		getContentPane().add(txtCodCliente);
		txtCodCliente.setColumns(10);
		
		txtDesCliente = new JTextField();
		txtDesCliente.setColumns(10);
		txtDesCliente.setBounds(120, 32, 86, 20);
		getContentPane().add(txtDesCliente);
		
		lblDesCliente = new JLabel("Descripcion");
		lblDesCliente.setBounds(120, 11, 86, 14);
		getContentPane().add(lblDesCliente);
		
		panelBtnMantener = new JPanel();
		panelBtnMantener.setLayout(null);
		panelBtnMantener.setBackground(SystemColor.activeCaption);
		panelBtnMantener.setBounds(10, 154, 111, 106);
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
		modelo.addColumn("COD CLIENTE");
		modelo.addColumn("DESCRIPCION");
		table.setModel(modelo);
		
		arrCliente = new ArregloCliente();
		
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
		int codCliente = leerCodCliente();
		String desCliente = leerDesCliente();
		
		Cliente cliente = new Cliente(codCliente,desCliente);
		
		arrCliente.adicionar(cliente);
		arrCliente.grabarCliente();
		listarCliente();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		int codCliente = leerCodCliente();
		String desCliente = leerDesCliente();
		
		boolean find=false;
		
		for (int i=0;i<arrCliente.tamano();i++) {	
			if(codCliente==arrCliente.obtener(i).getCodCliente()) {
				arrCliente.obtener(i).setDesCliente(desCliente);
				arrCliente.grabarCliente();
				Custom.mensajeExito(this, "Modificado con exito !");
				find=true;
				listarCliente();
			}
		}
		
		if(find==false){
			Custom.mensajeError(this, "No se pudo modificar, codigo no existe");
		}
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int codCliente = leerCodCliente();
		
		for  (int i=0;i<arrCliente.tamano();i++) {
			if(codCliente==arrCliente.obtener(i).getCodCliente()) {
				arrCliente.eliminar(arrCliente.obtener(i));
				arrCliente.grabarCliente();
			}
		}
		listarCliente();
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
	// METODOS DE ENTRADA
	
	private int leerCodCliente() {
		int res=-1;
		
		res = Integer.parseInt(txtCodCliente.getText());
		
		return res;
	}
	
	private String leerDesCliente(){
		String res = null;
		
		res = txtDesCliente.getText();
		
		return res;
	}	
	//METODOS ADICIONALES
	
	private void arranque() {
		listarCliente();
	}
	
	private void listarCliente() {
		modelo.setRowCount(0);
		for (int i=0;i<arrCliente.tamano();i++) {
			Object [] x = {
					arrCliente.obtener(i).getCodCliente(),
					arrCliente.obtener(i).getDesCliente()
			};
			modelo.addRow(x);
		}
	}


}
