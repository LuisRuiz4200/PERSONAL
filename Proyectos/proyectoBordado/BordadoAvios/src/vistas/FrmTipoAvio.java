package vistas;

import javax.swing.JFrame;
import javax.swing.table.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import clases.*;
import reuzables.Custom;
import arreglos.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


@SuppressWarnings("serial")
public class FrmTipoAvio extends JFrame implements ActionListener, KeyListener, MouseListener {
	
	private DefaultTableModel model;
	private JLabel lblCodTipoAvio;
	private JTextField txtCodTipoAvio;
	private JLabel lblDesTipoAvio;
	private JTextField txtDesTipoAvio;
	private JTable table;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private ArregloTipoAvio arrTipoAvio;
	
	public static void main (String[] args) {
		FrmTipoAvio ventana = new FrmTipoAvio();
		ventana.setVisible(true);
	}
	
	public FrmTipoAvio() {
		
		this.setTitle("TIPO DE AVIO");
		this.setBounds(0,0,429,326);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		lblCodTipoAvio = new JLabel("Cod. Tipo Avio");
		lblCodTipoAvio.setBounds(10, 22, 113, 14);
		getContentPane().add(lblCodTipoAvio);
		
		txtCodTipoAvio = new JTextField();
		txtCodTipoAvio.setBounds(10, 37, 86, 20);
		getContentPane().add(txtCodTipoAvio);
		txtCodTipoAvio.setColumns(10);
		
		lblDesTipoAvio = new JLabel("Descripcion");
		lblDesTipoAvio.setBounds(10, 68, 113, 14);
		getContentPane().add(lblDesTipoAvio);
		
		txtDesTipoAvio = new JTextField();
		txtDesTipoAvio.setBounds(10, 81, 86, 20);
		getContentPane().add(txtDesTipoAvio);
		txtDesTipoAvio.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(147, 22, 255, 232);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.addMouseListener(this);
		table.addKeyListener(this);
		scrollPane.setViewportView(table);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(10, 124, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(10, 158, 89, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(10, 192, 89, 23);
		getContentPane().add(btnEliminar);
		
		model = new DefaultTableModel();
		model.addColumn("COD AVIO");
		model.addColumn("DESCRIPCION");
		table.setModel(model);
		
		
		arrTipoAvio = new ArregloTipoAvio();
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
		
		int codTipoAvio = leerCodTipoAvio();
		String desTipoAvio = leerDesTipoAvio();
		
		arrTipoAvio.adicionar(new TipoAvio(codTipoAvio,desTipoAvio));
		arrTipoAvio.grabarTipoAvio();
		
		listarTipoAvio();
		limpiar();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
		int codTipoAvio = leerCodTipoAvio();
		String desTipoAvio = leerDesTipoAvio();
		
		for(int i=0;i<arrTipoAvio.tamano();i++) {
			if(codTipoAvio==arrTipoAvio.obtener(i).getCodTipoAvio()) {
				arrTipoAvio.obtener(i).setDesTipoAvio(desTipoAvio);
				arrTipoAvio.grabarTipoAvio();
			}
		}	
		
		listarTipoAvio();
		limpiar();
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		int codTipoAvio = leerCodTipoAvio();
		
		for(int i=0;i<arrTipoAvio.tamano();i++) {
			if(codTipoAvio==arrTipoAvio.obtener(i).getCodTipoAvio()) {
				if(Custom.mensajeConfirmacion(this,"SEGURO QUIERE ELIMINAR ESTA FILA")==0) {
					arrTipoAvio.eliminar(arrTipoAvio.obtener(i));
					arrTipoAvio.grabarTipoAvio();
				}else {
					Custom.mensajeAdvertencia(this, "Operacion cancelada");
				}
			}
		}	
		
		listarTipoAvio();
		limpiar();
		
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
		int indice = table.getSelectedRow();
		
		txtCodTipoAvio.setText(model.getValueAt(indice, 0).toString());
		txtDesTipoAvio.setText(model.getValueAt(indice, 1).toString());
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == table) {
			keyReleasedTable(e);
		}
		
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTable(KeyEvent e) {
		int indice = table.getSelectedRow();
		
		txtCodTipoAvio.setText(model.getValueAt(indice, 0).toString());
		txtDesTipoAvio.setText(model.getValueAt(indice, 1).toString());

	}
	
	//METODOS DE LECTURA
	private int leerCodTipoAvio() {
		int res = -1;
		
		res = Integer.parseInt(txtCodTipoAvio.getText());
		
		return res;
	}
	
	private String leerDesTipoAvio() {
		String res = null;
		
		res = txtDesTipoAvio.getText();
		
		return res;
	}
	//METODOS ADICIONALES
	
	public void arranque() {
		listarTipoAvio();
		correlativo();
	}
	
	public void listarTipoAvio() {
		
		model.setRowCount(0);
		
		for (int i=0;i<arrTipoAvio.tamano();i++) {
			Object[] x = {
				arrTipoAvio.obtener(i).getCodTipoAvio(),
				arrTipoAvio.obtener(i).getDesTipoAvio()
			};
			model.addRow(x);
		}
		
	}
	
	public void correlativo() {
		int n = 0;
		
		if(arrTipoAvio.tamano()==0) {
			txtCodTipoAvio.setText("" + 1);
		}else 
			n = arrTipoAvio.obtener(arrTipoAvio.tamano()-1).getCodTipoAvio()+1;
			txtCodTipoAvio.setText("" + n);
	}
	
	public void limpiar() {
		correlativo();
		txtDesTipoAvio.setText("");
	}
	

}
