package vistas;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCitiAcabado;
import clases.CitiAcabado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmCitiAcabado extends JFrame implements ActionListener{
	private JPanel panel;
	private JTextField txtCodCiti;
	private JLabel lblCodCiti;
	private JTextField txtDesCiti;
	private JLabel lblDesCiti;
	private JTextField txtEstadoCiti;
	private JLabel lblEstadoCiti;
	private JButton btnGrabar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JTable table;
	private JScrollPane spCitiAcabado;
	private DefaultTableModel modelo;
	
	private ArregloCitiAcabado arrCitiAcabado = new ArregloCitiAcabado();
	
	public static void main (String[] args) {
		FrmCitiAcabado ventana = new FrmCitiAcabado();
		ventana.setVisible(true);
	}
	
	public FrmCitiAcabado() {
		
		this.setTitle("CITI ACABADO");
		this.setBounds(0,0,488,392);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 27, 434, 108);
		panel.setBorder(new TitledBorder("CITI ACABADO"));
		panel.setLayout(null);
		getContentPane().add(panel);
		
		txtCodCiti = new JTextField();
		txtCodCiti.setBounds(10, 51, 86, 20);
		panel.add(txtCodCiti);
		txtCodCiti.setColumns(10);
		
		lblCodCiti = new JLabel("CODIGO");
		lblCodCiti.setBounds(10, 30, 86, 14);
		panel.add(lblCodCiti);
		
		txtDesCiti = new JTextField();
		txtDesCiti.setColumns(10);
		txtDesCiti.setBounds(122, 51, 156, 20);
		panel.add(txtDesCiti);
		
		lblDesCiti = new JLabel("DESCRIPCION");
		lblDesCiti.setBounds(122, 30, 121, 14);
		panel.add(lblDesCiti);
		
		txtEstadoCiti = new JTextField();
		txtEstadoCiti.setColumns(10);
		txtEstadoCiti.setBounds(304, 51, 114, 20);
		panel.add(txtEstadoCiti);
		
		lblEstadoCiti = new JLabel("ESTADO");
		lblEstadoCiti.setBounds(304, 30, 86, 14);
		panel.add(lblEstadoCiti);
		
		btnGrabar = new JButton("GRABAR");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(10, 146, 89, 23);
		getContentPane().add(btnGrabar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(114, 146, 89, 23);
		getContentPane().add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(222, 146, 89, 23);
		getContentPane().add(btnEliminar);
		
		spCitiAcabado = new JScrollPane();
		spCitiAcabado.setBounds(10, 182, 436, 149);
		getContentPane().add(spCitiAcabado);
		
		table = new JTable();
		spCitiAcabado.setViewportView(table);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("ESTADO");
		table.setModel(modelo);
		
		arranque();
	}
	
	//ACTION RESULT
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
	}
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		adicionar();
	}
	protected void actionPerformedBtnEditar(ActionEvent e) {
		editar();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminar();
	}
	//METODOS DE ENTRADA
	
	public String leerCodCiti() {
		String res = null;
		
		res = txtCodCiti.getText().trim();
		
		return res;
	}
	
	public String leerDesCiti() {
		String res = null;
		
		res = txtDesCiti.getText().trim();
		
		return res;
	}
	
	public String leerEstadoCiti() {
		String res = null;
		
		res = txtEstadoCiti.getText().trim();
		
		return res;
	}
	
	//METODOS VOID
	private void arranque() {
		limpiar();
	}
	
	private void limpiar() {
		txtCodCiti.setText("");
		txtCodCiti.requestFocus();
		txtDesCiti.setText("");
		txtEstadoCiti.setText("REGISTRADO");
	}
	
	private void adicionar() {
		
		String codigo = leerCodCiti();
		String descripcion = leerDesCiti();
		String estado = leerEstadoCiti();
		
		CitiAcabado obj = new CitiAcabado(codigo,descripcion,estado);
		
		arrCitiAcabado.adicionar(obj);
		
		arrCitiAcabado.grabarCitiAcabado();
		
		listarCitiAcabado();
	}
	
	private void editar() {
		String codigo = leerCodCiti();
		String descripcion = leerDesCiti();
		String estado = leerEstadoCiti();
		
		CitiAcabado obj = new CitiAcabado(codigo,descripcion,estado);
		
		arrCitiAcabado.editar(obj);
		arrCitiAcabado.grabarCitiAcabado();
		
		listarCitiAcabado();
	}
	
	private void eliminar() {
		String codigo = leerCodCiti();
		String descripcion = leerDesCiti();
		String estado = leerEstadoCiti();
		
		CitiAcabado obj = new CitiAcabado(codigo,descripcion,estado);
		
		arrCitiAcabado.eliminar(obj);
		
		arrCitiAcabado.grabarCitiAcabado();
		
		listarCitiAcabado();
	}
	
	private void listarCitiAcabado() {
		
		modelo.setRowCount(0);
		
		for(int i=0;i<arrCitiAcabado.tamaño();i++) {
			Object[] x = new Object[] {
				arrCitiAcabado.obtener(i).getCod_citiAcabado(),
				arrCitiAcabado.obtener(i).getDes_citiAcabado(),
				arrCitiAcabado.obtener(i).getEstado_citiAcabado()
			};
			
			modelo.addRow(x);
		}
		
		listarCitiAcabado();
		
	}
	
}
