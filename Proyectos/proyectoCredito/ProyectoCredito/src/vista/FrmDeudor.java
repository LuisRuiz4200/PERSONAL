package vista;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import arreglo.ArregloDeudor;
import modelo.Deudor;
import reuzable.Custom;

import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FrmDeudor extends JFrame implements ActionListener, KeyListener{
	

	public static JTextField txtIdDeudor;
	private ArregloDeudor arrDeudor = new ArregloDeudor();
	
	private JLabel lblIdDeudor;
	private JTextField txtDniDeudor;
	private JLabel lblDniDeudor;
	private JTextField txtApellidoDeudor;
	private JLabel lblApellidoDeudor;
	private JTextField txtNombreDeudor;
	private JLabel lblNombreDeudor;
	private JTabbedPane tpDeudor;
	private JPanel panelGestionDeudor;
	private JPanel panelConsultaDeudor;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JTable tbDeudor;
	private JScrollPane spTbDeudor;
	private JTextField txtFiltro;
	private JComboBox<Object> cboFiltro;
	private JLabel lblFiltrar;
	private JTextField txtFechaReg;
	private JLabel lblFechaReg;
	private JTextField txtFechaAct;
	private JLabel lblFechaAct;
	private JTextField txtEstado;
	private JLabel lblEstado;
	private JPanel panelCabecera;
	
	
	public static void main(String [] args) {
		
		FrmDeudor form = new FrmDeudor();
		form.setVisible(true);
		
	}
	
	public FrmDeudor() {
		
		setTitle("DEUDOR");
		setBounds(100,100,620,362);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		tpDeudor = new JTabbedPane(JTabbedPane.TOP);
		tpDeudor.setBounds(10, 11, 573, 281);
		getContentPane().add(tpDeudor);
		
		panelGestionDeudor = new JPanel();
		tpDeudor.addTab("Gestion", null, panelGestionDeudor, null);
		panelGestionDeudor.setLayout(null);
		
		txtDniDeudor = new JTextField();
		txtDniDeudor.setBounds(20, 156, 166, 20);
		panelGestionDeudor.add(txtDniDeudor);
		txtDniDeudor.setColumns(10);
		
		lblDniDeudor = new JLabel("DNI");
		lblDniDeudor.setBounds(20, 140, 86, 14);
		panelGestionDeudor.add(lblDniDeudor);
		
		txtNombreDeudor = new JTextField();
		txtNombreDeudor.setBounds(20, 109, 166, 20);
		panelGestionDeudor.add(txtNombreDeudor);
		txtNombreDeudor.setColumns(10);
		
		lblNombreDeudor = new JLabel("NOMBRE");
		lblNombreDeudor.setBounds(20, 93, 86, 14);
		panelGestionDeudor.add(lblNombreDeudor);
		
		txtApellidoDeudor = new JTextField();
		txtApellidoDeudor.setBounds(208, 109, 166, 20);
		panelGestionDeudor.add(txtApellidoDeudor);
		txtApellidoDeudor.setColumns(10);
		
		lblApellidoDeudor = new JLabel("APELLIDO");
		lblApellidoDeudor.setBounds(208, 93, 86, 14);
		panelGestionDeudor.add(lblApellidoDeudor);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(10, 219, 89, 23);
		panelGestionDeudor.add(btnAgregar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(109, 219, 89, 23);
		panelGestionDeudor.add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(208, 219, 89, 23);
		panelGestionDeudor.add(btnEliminar);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(307, 219, 89, 23);
		panelGestionDeudor.add(btnNuevo);
		
		panelCabecera = new JPanel();
		panelCabecera.setBounds(10, 11, 548, 71);
		panelCabecera.setBorder(new TitledBorder("CABECERA"));
		panelGestionDeudor.add(panelCabecera);
		panelCabecera.setLayout(null);
		
		txtIdDeudor = new JTextField();
		txtIdDeudor.setBounds(10, 40, 86, 20);
		panelCabecera.add(txtIdDeudor);
		txtIdDeudor.setColumns(10);
		
		lblIdDeudor = new JLabel("ID");
		lblIdDeudor.setBounds(10, 24, 86, 14);
		panelCabecera.add(lblIdDeudor);
		
		txtFechaReg = new JTextField();
		txtFechaReg.setBounds(192, 40, 103, 20);
		panelCabecera.add(txtFechaReg);
		txtFechaReg.setColumns(10);
		
		lblFechaReg = new JLabel("REGISTRO");
		lblFechaReg.setBounds(192, 24, 86, 14);
		panelCabecera.add(lblFechaReg);
		
		txtFechaAct = new JTextField();
		txtFechaAct.setBounds(305, 40, 103, 20);
		panelCabecera.add(txtFechaAct);
		txtFechaAct.setColumns(10);
		
		lblFechaAct = new JLabel("ACTUALIZACION");
		lblFechaAct.setBounds(305, 24, 103, 14);
		panelCabecera.add(lblFechaAct);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(429, 40, 103, 20);
		panelCabecera.add(txtEstado);
		txtEstado.setColumns(10);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(429, 24, 86, 14);
		panelCabecera.add(lblEstado);
		
		panelConsultaDeudor = new JPanel();
		tpDeudor.addTab("Consulta", null, panelConsultaDeudor, null);
		panelConsultaDeudor.setLayout(null);
		
		spTbDeudor = new JScrollPane();
		spTbDeudor.setBounds(10, 57, 522, 154);
		panelConsultaDeudor.add(spTbDeudor);
		
		tbDeudor = new JTable();
		spTbDeudor.setViewportView(tbDeudor);
		
		txtFiltro = new JTextField();
		txtFiltro.addKeyListener(this);
		txtFiltro.setBounds(138, 26, 134, 20);
		panelConsultaDeudor.add(txtFiltro);
		txtFiltro.setColumns(10);
		
		cboFiltro = new JComboBox<Object>();
		cboFiltro.setBounds(10, 24, 118, 22);
		panelConsultaDeudor.add(cboFiltro);
		
		lblFiltrar = new JLabel("FILTRAR POR");
		lblFiltrar.setBounds(10, 11, 106, 14);
		panelConsultaDeudor.add(lblFiltrar);
		
		arranque();
		
	}

	private void arranque() {
		// TODO Auto-generated method stub
		limpiar();
		cargarCboFiltro();
	}
	
	private void limpiar() {
		// TODO Auto-generated method stub
		
		for (Component obj: this.panelGestionDeudor.getComponents() ) {
			if (obj instanceof JTextField) {
				((JTextField) obj).setText("");
			}
		}
		
		for (Component obj: this.panelCabecera.getComponents()) {
			if (obj instanceof JTextField) {
				((JTextField) obj).setEditable(false);
			}
		}
		

		txtIdDeudor.setText(arrDeudor.correlativo() + "");
		txtFechaReg.setText(new SimpleDateFormat("dd/MM/yyy hh:mm").format(new Date()));
		txtEstado.setText("REGISTRADO");
		
		listarDeudor();
	}
	private void agregar(){
		int id = Integer.parseInt(txtIdDeudor.getText());
		String nombre = txtNombreDeudor.getText();
		String apellido = txtApellidoDeudor.getText();
		String dni = txtDniDeudor.getText();
		String estado = txtEstado.getText();
		Date fechaReg = new Date();
		
		
		Deudor obj = new Deudor();
		
		obj.setId_deudor(id);
		obj.setNom_deudor(nombre);
		obj.setApe_deudor(apellido);
		obj.setDni_deudor(dni);
		obj.setFechaReg_deudor(fechaReg);
		obj.setEstado_deudor(estado);
		
		arrDeudor.adicionar(obj);
		arrDeudor.grabarData();
		
		Custom.mensajeExito(this, "AGREGADO");
		
		limpiar();
		
		
	}
	
	private void editar() {
		int id = Integer.parseInt(txtIdDeudor.getText());
		String nombre = txtNombreDeudor.getText();
		String apellido = txtApellidoDeudor.getText();
		String dni = txtDniDeudor.getText();
		Date fechaAct = new Date();
		
		Deudor obj = new Deudor();
		
		obj.setId_deudor(id);
		obj.setNom_deudor(nombre);
		obj.setApe_deudor(apellido);
		obj.setDni_deudor(dni);
		obj.setFechaAct_deudor(fechaAct);
		
		arrDeudor.editar(obj);
		arrDeudor.grabarData();
		
		Custom.mensajeExito(this, "EDITADO");
		
		limpiar();
		
	}
	private void eliminar() {
		int id = Integer.parseInt(txtIdDeudor.getText());
		
		arrDeudor.eliminar(id);
		arrDeudor.grabarData();
		
		Custom.mensajeExito(this, "ELIMINADO");
		
		limpiar();
	}
	
	private void listarDeudor() {
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.setColumnIdentifiers(new Object[] {"ID","NOMBRE","APELLIDO","DNI"});
		
		for (Deudor obj: arrDeudor.listar()) {
			Object[] x = new Object[] {
				obj.getId_deudor(),
				obj.getNom_deudor(),
				obj.getApe_deudor(),
				obj.getDni_deudor()
			};
			modelo.addRow(x);
		}
		tbDeudor.setModel(modelo);
	}
	
	private void cargarCboFiltro() {
		for (int i = 0;i<tbDeudor.getColumnCount();i++) {
			String nombreColumna = tbDeudor.getColumnName(i).toString();
			cboFiltro.addItem(nombreColumna);
		}
	}
	
	private void filtrarTablaDeudor() {
		String filtroString = txtFiltro.getText();
		
		TableRowSorter<TableModel> filtro = new TableRowSorter<TableModel>(tbDeudor.getModel());
		filtro.setRowFilter(RowFilter.regexFilter(filtroString, cboFiltro.getSelectedIndex()));
		tbDeudor.setRowSorter(filtro);
		
		
	}
	
	//ACTION LISTENER
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
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		agregar();
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
	
	//KEY LISTENER
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtFiltro) {
			keyReleasedTxtFiltro(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtFiltro(KeyEvent e) {
		filtrarTablaDeudor();
	}
}
