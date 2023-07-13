package vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

import arreglo.ArregloMedioPago;
import arreglo.ArregloPago;
import arreglo.ArregloPersona;
import modelo.Pago;
import modelo.Persona;
import reuzable.Custom;
import reuzable.TablaRz;

import javax.swing.event.CaretEvent;

@SuppressWarnings("serial")
public class FrmPago extends JInternalFrame implements ActionListener, CaretListener{
	
	public static JTextField txtIdPago;
	public static JTextField txtIdPrestatario;

	private ArregloPago arrPago = new ArregloPago();
	
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private JPanel panelGestionPago;
	private JPanel panelPrestatario;
	private JLabel lblIdPrestatario;
	private JButton btnBuscarPrestatario;
	private JTextField txtNombrePrestatario;
	private JLabel lblNombrePrestatario;
	private JTextField txtApellidoPrestatario;
	private JLabel lblApellidoPrestatario;
	private JTextField txtDniPrestatario;
	private JLabel lblDniPrestatario;
	private JPanel panelCabecera;
	private JLabel lblIdPago;
	private JTextField txtFechaActPago;
	private JLabel lblFechaActPago;
	private JTextField txtEstadoPago;
	private JLabel lblEstadoPago;
	private JTextField txtFechaRegPago;
	private JLabel lblFechaRegPago;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JPanel panelPago;
	private JComboBox cboMedioPago;
	private JTextField txtMontoPago;
	private JLabel lblMedioPago;
	private JLabel lblMontoPago;
	private JPanel panelConsultaPago;
	private JScrollPane spTbPago;
	private JTextField textField;
	private JComboBox<Object> cboFiltro;
	private JLabel lblFiltrar;
	private JTable tbPago;
	
	public static void main(String [] args) {
		
		FrmPago form = new FrmPago();
		form.setVisible(true);
		
	}
	
	public FrmPago() {
		
		setTitle("PAGO");
		setSize(732,421);
		//setLocationRelativeTo(this);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);

		setLocation(60,60);

		
		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 696, 360);
		panel.add(tabbedPane);
		
		panelGestionPago = new JPanel();
		tabbedPane.addTab("GESTION", null, panelGestionPago, null);
		panelGestionPago.setLayout(null);
		
		panelPrestatario = new JPanel();
		panelPrestatario.setLayout(null);
		panelPrestatario.setBorder(new TitledBorder(null, "PRESTATARIO"));
		panelPrestatario.setBounds(10, 88, 642, 77);
		panelGestionPago.add(panelPrestatario);
		
		txtIdPrestatario = new JTextField();
		txtIdPrestatario.addCaretListener(this);
		txtIdPrestatario.setColumns(10);
		txtIdPrestatario.setBounds(10, 44, 86, 20);
		panelPrestatario.add(txtIdPrestatario);
		
		lblIdPrestatario = new JLabel("ID");
		lblIdPrestatario.setBounds(10, 28, 86, 14);
		panelPrestatario.add(lblIdPrestatario);
		
		btnBuscarPrestatario = new JButton("...");
		btnBuscarPrestatario.addActionListener(this);
		btnBuscarPrestatario.setBounds(104, 43, 35, 23);
		panelPrestatario.add(btnBuscarPrestatario);
		
		txtNombrePrestatario = new JTextField();
		txtNombrePrestatario.setColumns(10);
		txtNombrePrestatario.setBounds(159, 44, 178, 20);
		panelPrestatario.add(txtNombrePrestatario);
		
		lblNombrePrestatario = new JLabel("NOMBRE");
		lblNombrePrestatario.setBounds(159, 28, 86, 14);
		panelPrestatario.add(lblNombrePrestatario);
		
		txtApellidoPrestatario = new JTextField();
		txtApellidoPrestatario.setColumns(10);
		txtApellidoPrestatario.setBounds(347, 44, 178, 20);
		panelPrestatario.add(txtApellidoPrestatario);
		
		lblApellidoPrestatario = new JLabel("APELLIDO");
		lblApellidoPrestatario.setBounds(347, 28, 86, 14);
		panelPrestatario.add(lblApellidoPrestatario);
		
		txtDniPrestatario = new JTextField();
		txtDniPrestatario.setColumns(10);
		txtDniPrestatario.setBounds(535, 44, 97, 20);
		panelPrestatario.add(txtDniPrestatario);
		
		lblDniPrestatario = new JLabel("DNI");
		lblDniPrestatario.setBounds(535, 28, 86, 14);
		panelPrestatario.add(lblDniPrestatario);
		
		panelCabecera = new JPanel();
		panelCabecera.setLayout(null);
		panelCabecera.setBorder(new TitledBorder("CABECERA"));
		panelCabecera.setBounds(10, 10, 642, 67);
		panelGestionPago.add(panelCabecera);
		
		txtIdPago = new JTextField();
		txtIdPago.setColumns(10);
		txtIdPago.setBounds(10, 36, 86, 20);
		panelCabecera.add(txtIdPago);
		
		lblIdPago = new JLabel("ID");
		lblIdPago.setBounds(10, 20, 86, 14);
		panelCabecera.add(lblIdPago);
		
		txtFechaActPago = new JTextField();
		txtFechaActPago.setColumns(10);
		txtFechaActPago.setBounds(387, 36, 123, 20);
		panelCabecera.add(txtFechaActPago);
		
		lblFechaActPago = new JLabel("FECHA ACTUALIZADA");
		lblFechaActPago.setBounds(387, 20, 123, 14);
		panelCabecera.add(lblFechaActPago);
		
		txtEstadoPago = new JTextField();
		txtEstadoPago.setColumns(10);
		txtEstadoPago.setBounds(538, 36, 86, 20);
		panelCabecera.add(txtEstadoPago);
		
		lblEstadoPago = new JLabel("ESTADO");
		lblEstadoPago.setBounds(538, 20, 86, 14);
		panelCabecera.add(lblEstadoPago);
		
		txtFechaRegPago = new JTextField();
		txtFechaRegPago.setColumns(10);
		txtFechaRegPago.setBounds(254, 36, 123, 20);
		panelCabecera.add(txtFechaRegPago);
		
		lblFechaRegPago = new JLabel("FECHA REGISTRO");
		lblFechaRegPago.setBounds(254, 20, 123, 14);
		panelCabecera.add(lblFechaRegPago);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(10, 298, 89, 23);
		panelGestionPago.add(btnAgregar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(116, 298, 89, 23);
		panelGestionPago.add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(215, 298, 89, 23);
		panelGestionPago.add(btnEliminar);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(314, 298, 89, 23);
		panelGestionPago.add(btnNuevo);
		
		panelPago = new JPanel();
		panelPago.setBorder(new TitledBorder("PAGO"));
		panelPago.setBounds(10, 176, 331, 77);
		panelGestionPago.add(panelPago);
		panelPago.setLayout(null);
		
		cboMedioPago = new JComboBox();
		cboMedioPago.setBounds(10, 44, 172, 22);
		panelPago.add(cboMedioPago);
		
		txtMontoPago = new JTextField();
		txtMontoPago.setBounds(214, 45, 107, 20);
		panelPago.add(txtMontoPago);
		txtMontoPago.setColumns(10);
		
		lblMedioPago = new JLabel("MEDIO DE PAGO");
		lblMedioPago.setBounds(10, 29, 127, 14);
		panelPago.add(lblMedioPago);
		
		lblMontoPago = new JLabel("MONTO");
		lblMontoPago.setBounds(214, 29, 107, 14);
		panelPago.add(lblMontoPago);
		
		panelConsultaPago = new JPanel();
		panelConsultaPago.setLayout(null);
		tabbedPane.addTab("CONSULTA", null, panelConsultaPago, null);
		
		spTbPago = new JScrollPane();
		spTbPago.setBounds(10, 57, 642, 264);
		panelConsultaPago.add(spTbPago);
		
		tbPago = new JTable();
		spTbPago.setViewportView(tbPago);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(138, 26, 134, 20);
		panelConsultaPago.add(textField);
		
		cboFiltro = new JComboBox<Object>();
		cboFiltro.setSelectedIndex(-1);
		cboFiltro.setBounds(10, 24, 118, 22);
		panelConsultaPago.add(cboFiltro);
		
		lblFiltrar = new JLabel("FILTRAR POR");
		lblFiltrar.setBounds(10, 11, 106, 14);
		panelConsultaPago.add(lblFiltrar);
		
		arranque();
	}
	
	private void arranque() {
		limpiar();
		cargarCboMedioPago();
	}
	
	private void adicionar() {
		int idPago = leerIdPago();
		Date fechaReg = leerFechaRegPago();
		String estadoPago = leerestadoPago();
		int idPrestatario = leerIdPrestatario();
		int idMedioPago = leerIdMedioPago();
		double montoPago = leerMontoPago();
		
		Pago obj = new Pago();
		
		obj.setId_pago(idPago);
		obj.setFechaReg_pago(fechaReg);
		obj.setEstado_pago(estadoPago);
		obj.setId_persona_prestatario(idPrestatario);
		obj.setId_medioPago(idMedioPago);
		obj.setMonto_pago(montoPago);
		
		arrPago.adicionar(obj);
		arrPago.grabarData();
		
		Custom.mensajeExito(this, "Agregado correctamente");
		limpiar();
		
	}
	
	
	private void editar() {
		int idPago = leerIdPago();
		Date fechaReg = leerFechaRegPago();
		Date fechaAct = leerFechaActPago();
		String estadoPago = leerestadoPago();
		int idPrestatario = leerIdPrestatario();
		int idMedioPago = leerIdMedioPago();
		double montoPago = leerMontoPago();
		
		Pago obj = new Pago();
		
		obj.setId_pago(idPago);
		obj.setFechaReg_pago(fechaReg);
		obj.setFechaAct_pago(fechaAct);
		obj.setEstado_pago(estadoPago);
		obj.setId_persona_prestatario(idPrestatario);
		obj.setId_medioPago(idMedioPago);
		obj.setMonto_pago(montoPago);
		
		arrPago.editar(obj);
		arrPago.grabarData();
		
		Custom.mensajeExito(this, "Editado correctamente");
		limpiar();

	}
	
	private void eliminar() {
		int idPago = leerIdPago();
		
		
		arrPago.eliminar(idPago);
		arrPago.grabarData();
		
		Custom.mensajeExito(this, "Eliminado correctamente");
		limpiar();

	}
	
	private void listar() {
		Object [] cabecera = new Object[] {"ID","PRESTATARIO","MEDIO DE PAGO","MONTO","REGISTRADO","ACTUALIZADO","ESTADO"};
		
		DefaultTableModel modelo = TablaRz.tableModel(cabecera);
		
		ArregloPersona arrPersona = new ArregloPersona();
		ArregloMedioPago arrMedioPago = new ArregloMedioPago();
		
		for (Pago obj: arrPago.listar()) {
			Object[] x = new Object[] {
				obj.getId_pago(),
				arrPersona.buscar(obj.getId_persona_prestatario()).getNom_persona(),
				arrMedioPago.buscar(obj.getId_medioPago()).getDes_medioPago(),
				obj.getMonto_pago(),
				new SimpleDateFormat("dd MMM yyy hh:mm:ss").format(obj.getFechaReg_pago()),
				((obj.getFechaAct_pago()==null)?"":new SimpleDateFormat("dd MMM yyy hh:mm:ss").format(obj.getFechaAct_pago())),
				obj.getEstado_pago()
			};
			modelo.addRow(x);
		}
		
		tbPago.setModel(modelo);
		tbPago.setAutoResizeMode(0);
		TablaRz.autoAjustar(tbPago);
		
	}
	
	private void limpiar() {
		
		for (Component obj : this.panelCabecera.getComponents()) {
			if (obj instanceof JTextField) {
				((JTextField)obj).setEditable(false);
				((JTextField)obj).setText("");
			}
		}
		
		for (Component obj : this.panelPrestatario.getComponents()) {
			if (obj instanceof JTextField) {
				((JTextField)obj).setEditable(false);
				((JTextField)obj).setText("");
			}
		}
		
		txtIdPago.setText(arrPago.correlativo()+"");
		txtEstadoPago.setText("REGISTRADO");
		txtFechaRegPago.setText(new SimpleDateFormat("dd/MM/yyy hh:mm:ss").format(new Date()));
		
		listar();
		
	}
	
	private void cargarCboMedioPago() {
		ArregloMedioPago arrMedioPago = new ArregloMedioPago();
		
		cboMedioPago.setSelectedIndex(-1);
		
		arrMedioPago.listar().forEach((c)->cboMedioPago.addItem(c.getDes_medioPago()));
	}
	
	//GETTER Y SETTER
	
	private double leerMontoPago() {
		double res = 0;
		
		res = Double.parseDouble(txtMontoPago.getText().trim());
		
		return res;
	}

	private int leerIdMedioPago() {
		int res =  0;
		
		res = cboMedioPago.getSelectedIndex()+1;
		
		return res;
	}

	private int leerIdPrestatario() {
		int res = 0;
		
		res = Integer.parseInt(txtIdPrestatario.getText());
		
		return res;
	}

	private String leerestadoPago() {
		String res = null;
		
		res = txtEstadoPago.getText();
		
		return res;
	}

	private Date leerFechaActPago() {
		Date res = null;
		
		res = new Date();
		
		return res;
	}

	private Date leerFechaRegPago() {
		Date res = null;
		
		res = new Date();
		
		return res;
	}

	private int leerIdPago() {
		int res = 0;
		
		res = Integer.parseInt(txtIdPago.getText());
		
		return res;
	}

	
	//ACTION LISTENER
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarPrestatario) {
			actionPerformedBtnBuscarPrestatario(e);
		}
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
	protected void actionPerformedBtnBuscarPrestatario(ActionEvent e) {
		DlgBuscarPersona.frame = "FrmPago/Persona/Prestatario";
		DlgBuscarPersona dlg = new DlgBuscarPersona(null,true);
		dlg.setVisible(true);
	}
	
	//CARET LISTENER
	public void caretUpdate(CaretEvent e) {
		if (e.getSource() == txtIdPrestatario) {
			caretUpdateTxtIdPrestatario(e);
		}
	}
	protected void caretUpdateTxtIdPrestatario(CaretEvent e) {
		if (txtIdPrestatario.getText().isEmpty()) {
			return ;
		}
		
		ArregloPersona arrPersona = new ArregloPersona();
		Persona obj = arrPersona.buscar(leerIdPrestatario());
		
		txtNombrePrestatario.setText(obj.getNom_persona());
		txtApellidoPrestatario.setText(obj.getApe_persona());
		txtDniPrestatario.setText(obj.getDni_persona());
	}
}
