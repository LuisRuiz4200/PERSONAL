package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import utils.Tool;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import clases.*;
import arreglos.*;


@SuppressWarnings("serial")
public class FrmCliente extends JInternalFrame implements ActionListener{
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JLabel lblApellido;
	private JTextField txtDni;
	private JLabel lblDni;
	private JTextField txtCodigo;
	private JLabel lblCodigo;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnAgregar;
	private JButton btnModificar;
	private ArregloCliente arrCliente;
	private DefaultTableModel modelo;
	
	
	
	public static void main(String [] args) {
		
		FrmCliente form = new FrmCliente();
		form.setVisible(true);
		
	}
	
	public FrmCliente() {
		
		setTitle("Clientes");
		setBounds(100,100,508,344);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		
		this.getContentPane().setLayout(null);
		
		arrCliente = new ArregloCliente();
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setBounds(10, 22, 119, 14);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 41, 177, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(10, 90, 177, 20);
		getContentPane().add(txtApellido);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setBounds(10, 71, 119, 14);
		getContentPane().add(lblApellido);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(217, 41, 114, 20);
		getContentPane().add(txtDni);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(217, 22, 46, 14);
		getContentPane().add(lblDni);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(388, 30, 86, 20);
		getContentPane().add(txtCodigo);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(388, 11, 46, 14);
		getContentPane().add(lblCodigo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 472, 173);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(214, 89, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(315, 89, 89, 23);
		getContentPane().add(btnModificar);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDO");
		modelo.addColumn("DNI");
		table.setModel(modelo);
		
		arranque();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		
		String codigo = leerCodigo();
		String nombre = leerNombre ();
		String apellido = leerApellido();
		String dni = leerDni();
		
		if(codigo == null || nombre == null || apellido == null || dni == null) {
			Tool.mensajeError(this, "Hay campos sin llenar !");
		}else {
			arrCliente.adicionar(new Cliente (codigo,nombre,apellido,dni));
			arrCliente.grabarCliente();
			Tool.mensajeExito(this, "Se registró el cliente con exito !");
			listar();
		}
		
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
	}
	
	
	//metodos de ingreso
	
	private String leerDni() {
		String res=null;
		
		if(txtDni.getText().trim().length()==0) {
			Tool.mensajeError(this, "Campo del DNI vacio!!");
		}else {
			res = txtDni.getText().trim();
		}
		
		return res;
	}

	private String leerApellido() {
		String res=null;
		
		if(txtApellido.getText().trim().length()==0) {
			Tool.mensajeError(this, "Campo apellidos vacio!!");
		}else {
			res = txtApellido.getText().trim();
		}
		
		return res;
	}

	private String leerNombre() {
		String res=null;
		
		if(txtNombre.getText().trim().length()==0) {
			Tool.mensajeError(this, "Campo nombres vacio!!");
		}else {
			res = txtNombre.getText().trim();
		}
		
		return res;
	}

	private String leerCodigo() {
		String res=null;
		
		if(txtCodigo.getText().trim().length()==0) {
			Tool.mensajeError(this, "Campo codigo vacio!!");
		}else {
			res = txtCodigo.getText().trim();
		}
		
		return res;
	}

	
	//metodos adicionales
	
	void arranque() {
		
		txtCodigo.setText("C" + correlativo());
		
		listar();
	}
	
	void listar() {
		
		modelo.setRowCount(0);
		
		for (int i=0;i<arrCliente.tamaño();i++) {
			Cliente c =  arrCliente.obtener(i);
			
			String codigo =c.getCodigo();
			String nombre = c.getNombre();
			String apellido = c.getApellido();
			String dni = c.getDni();
			
			Object [] x = {codigo,nombre,apellido,dni};
			
			modelo.addRow(x);
			
		}	
	}
	
	int correlativo() {
		
		if(arrCliente.tamaño()==0) {
			return 1 ;
		}else {
			
			String codigo = arrCliente.obtener(arrCliente.tamaño()-1).getCodigo();
			
			return Integer.parseInt(codigo.substring(1))+1 ;
		}
		
	}
	
}
