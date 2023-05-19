package vistas;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCitiConfeccion;
import clases.CitiConfeccion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class FrmCitiConfeccion extends JFrame implements ActionListener, MouseListener{
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
	
	private ArregloCitiConfeccion arrCitiConfeccion = new ArregloCitiConfeccion();
	private JButton btnNuevo;
	
	public static void main (String[] args) {
		FrmCitiConfeccion ventana = new FrmCitiConfeccion();
		ventana.setVisible(true);
	}
	
	public FrmCitiConfeccion() {
		
		this.setTitle("CITI CONFECCION");
		this.setBounds(0,0,488,392);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 27, 434, 108);
		panel.setBorder(new TitledBorder("CITI CONFECCION"));
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
		table.addMouseListener(this);
		spCitiAcabado.setViewportView(table);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("ESTADO");
		table.setModel(modelo);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(329, 146, 89, 23);
		getContentPane().add(btnNuevo);
		
		arranque();
	}
	
	//ACTION RESULT
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
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

	protected void actionPerformedBtnNuevo(ActionEvent e) {
		limpiar();
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
		listarCitiAcabado();
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
		
		CitiConfeccion obj = new CitiConfeccion(codigo,descripcion,estado);
		
		arrCitiConfeccion.adicionar(obj);
		
		arrCitiConfeccion.grabarCitiConfeccion();
		
		limpiar();
		listarCitiAcabado();
	}
	
	private void editar() {
		String codigo = leerCodCiti();
		String descripcion = leerDesCiti();
		String estado = leerEstadoCiti();
		
		CitiConfeccion obj = new CitiConfeccion(codigo,descripcion,estado);
		
		arrCitiConfeccion.editar(obj);
		arrCitiConfeccion.grabarCitiConfeccion();
		
		listarCitiAcabado();
	}
	
	private void eliminar() {
		String codigo = leerCodCiti();
		String descripcion = leerDesCiti();
		String estado = leerEstadoCiti();
		
		CitiConfeccion obj = new CitiConfeccion(codigo,descripcion,estado);
		
		int res = JOptionPane.showConfirmDialog(this, "SEGURO QUIERE ELIMINAR","MENSAJE", JOptionPane.YES_OPTION,0);
		
		if(res == 0) {
			arrCitiConfeccion.eliminar(obj);
			
			arrCitiConfeccion.grabarCitiConfeccion();
			
			listarCitiAcabado();
		}else {
			JOptionPane.showMessageDialog(this, "OPERACION CANCELADA");
		}
		
		
	}
	
	private void listarCitiAcabado() {
		
		modelo.setRowCount(0);
		
		for(int i=0;i<arrCitiConfeccion.tamaño();i++) {
			Object[] x = new Object[] {
				arrCitiConfeccion.obtener(i).getCod_citiConfeccion(),
				arrCitiConfeccion.obtener(i).getDes_citiConfeccion(),
				arrCitiConfeccion.obtener(i).getEstado_citiConfeccion()
			};
			
			modelo.addRow(x);
		}
		
	}
	
	private void mostrarCitiAcabado () {
		int n = table.getSelectedRow();
		
		String codigo = table.getValueAt(n, 0).toString();
		String descripcion = table.getValueAt(n, 1).toString();
		String estado = table.getValueAt(n, 2).toString();
		
		txtCodCiti.setText(codigo);
		txtDesCiti.setText(descripcion);
		txtEstadoCiti.setText(estado);
	}
	//MOUSE CLICKE DE LA TABLA CITI
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
		mostrarCitiAcabado();
	}
}
