package vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import arreglo.ArregloDeuda;
import arreglo.ArregloPersona;
import modelo.Deuda;
import modelo.Persona;
import reuzable.Custom;
import reuzable.TablaRz;

import javax.swing.event.CaretEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("serial")
public class FrmDeuda extends JFrame implements ActionListener, CaretListener, KeyListener, ChangeListener{
	

	public static JTextField txtIdPrestatario;
	public static JTextField txtIdPrestamista;

	private ArregloDeuda arrDeuda = new ArregloDeuda();
	
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private JPanel panelGestionDeuda;
	private JTextField txtIdDeuda;
	private JLabel lblIdDeuda;
	private JTextField txtFechaRegDeuda;
	private JLabel lblFechaRegDeuda;
	private JTextField txtEstado;
	private JLabel lblEstadoDeuda;
	private JPanel panelDeudor;
	private JLabel lblIdDeudor;
	private JButton btnBuscarDeudor;
	private JTextField txtNombreDeudor;
	private JLabel lblNombreDeudor;
	private JTextField txtApellidoDeudor;
	private JLabel lblApellidoDeudor;
	private JTextField txtDniDeudor;
	private JLabel lblDniDeudor;
	private JTextField txtMonto;
	private JLabel lblMonto;
	private JSpinner txtCuota;
	private JLabel lblCuota;
	private JTextField txtInteres;
	private JLabel lblInteres;
	private JTextField txtTotalPago;
	private JLabel lblTotalPago;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JPanel panelConsultaDeudor;
	private JScrollPane spTbDeudaa;
	private JTextField txtFiltro;
	private JComboBox<Object> cboFiltro;
	private JLabel lblFiltrar;
	private JTable tbDeuda;
	private JPanel panelCabecera;
	private JPanel panelCalculable;
	private JPanel panelPrestamista;
	private JLabel lblIdPrestamista;
	private JButton btnBuscarPrestamista;
	private JTextField txtNombrePrestamista;
	private JLabel lblNombrePrestamista;
	private JTextField txtApellidoPrestamista;
	private JLabel lblApellidoPrestamista;
	private JTextField txtDniPrestamista;
	private JLabel lblDniPrestamista;
	
	
	
	public static void main(String [] args) {
		try {
			FrmDeuda form = new FrmDeuda();
			form.setVisible(true);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public FrmDeuda() {
		
		setTitle("DEUDA");
		setSize(700,484);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBounds(117, 74, 10, 10);
		setContentPane(panel);
		panel.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 667, 419);
		panel.add(tabbedPane);
		
		panelGestionDeuda = new JPanel();
		tabbedPane.addTab("Gestion", null, panelGestionDeuda, null);
		panelGestionDeuda.setLayout(null);
		
		panelDeudor = new JPanel();
		panelDeudor.setBorder(new TitledBorder(null, "DEUDOR"));
		panelDeudor.setBounds(10, 91, 642, 77);
		panelGestionDeuda.add(panelDeudor);
		panelDeudor.setLayout(null);
		
		txtIdPrestatario = new JTextField();
		txtIdPrestatario.setColumns(10);
		txtIdPrestatario.addCaretListener(this);
		txtIdPrestatario.setBounds(10, 44, 86, 20);
		panelDeudor.add(txtIdPrestatario);
		
		lblIdDeudor = new JLabel("ID DEUDOR");
		lblIdDeudor.setBounds(10, 28, 86, 14);
		panelDeudor.add(lblIdDeudor);
		
		btnBuscarDeudor = new JButton("...");
		btnBuscarDeudor.addActionListener(this);
		btnBuscarDeudor.setBounds(104, 43, 35, 23);
		panelDeudor.add(btnBuscarDeudor);
		
		txtNombreDeudor = new JTextField();
		txtNombreDeudor.setColumns(10);
		txtNombreDeudor.setBounds(159, 44, 178, 20);
		panelDeudor.add(txtNombreDeudor);
		
		lblNombreDeudor = new JLabel("NOMBRE");
		lblNombreDeudor.setBounds(159, 28, 86, 14);
		panelDeudor.add(lblNombreDeudor);
		
		txtApellidoDeudor = new JTextField();
		txtApellidoDeudor.setColumns(10);
		txtApellidoDeudor.setBounds(347, 44, 178, 20);
		panelDeudor.add(txtApellidoDeudor);
		
		lblApellidoDeudor = new JLabel("APELLIDO");
		lblApellidoDeudor.setBounds(347, 28, 86, 14);
		panelDeudor.add(lblApellidoDeudor);
		
		txtDniDeudor = new JTextField();
		txtDniDeudor.setColumns(10);
		txtDniDeudor.setBounds(535, 44, 97, 20);
		panelDeudor.add(txtDniDeudor);
		
		lblDniDeudor = new JLabel("DNI");
		lblDniDeudor.setBounds(535, 28, 86, 14);
		panelDeudor.add(lblDniDeudor);
		
		txtMonto = new JTextField();
		txtMonto.setColumns(10);
		txtMonto.setBounds(470, 283, 86, 20);
		panelGestionDeuda.add(txtMonto);
		
		lblMonto = new JLabel("MONTO");
		lblMonto.setBounds(470, 267, 86, 14);
		panelGestionDeuda.add(lblMonto);
		
		txtCuota = new JSpinner();
		txtCuota.addChangeListener(this);
		txtCuota.setBounds(566, 283, 86, 20);
		panelGestionDeuda.add(txtCuota);
		
		lblCuota = new JLabel("CUOTA");
		lblCuota.setBounds(566, 267, 86, 14);
		panelGestionDeuda.add(lblCuota);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(10, 357, 89, 23);
		panelGestionDeuda.add(btnAgregar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(116, 357, 89, 23);
		panelGestionDeuda.add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(215, 357, 89, 23);
		panelGestionDeuda.add(btnEliminar);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(314, 357, 89, 23);
		panelGestionDeuda.add(btnNuevo);
		
		panelCabecera = new JPanel();
		panelCabecera.setBounds(10, 13, 642, 67);
		panelCabecera.setBorder(new TitledBorder("CABECERA"));
		panelGestionDeuda.add(panelCabecera);
		panelCabecera.setLayout(null);
		
		txtIdDeuda = new JTextField();
		txtIdDeuda.setBounds(10, 36, 86, 20);
		panelCabecera.add(txtIdDeuda);
		txtIdDeuda.setColumns(10);
		
		lblIdDeuda = new JLabel("ID");
		lblIdDeuda.setBounds(10, 20, 86, 14);
		panelCabecera.add(lblIdDeuda);
		
		txtFechaRegDeuda = new JTextField();
		txtFechaRegDeuda.setBounds(387, 36, 123, 20);
		panelCabecera.add(txtFechaRegDeuda);
		txtFechaRegDeuda.setColumns(10);
		
		lblFechaRegDeuda = new JLabel("FECHA REGISTRO");
		lblFechaRegDeuda.setBounds(387, 20, 123, 14);
		panelCabecera.add(lblFechaRegDeuda);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(538, 36, 86, 20);
		panelCabecera.add(txtEstado);
		txtEstado.setColumns(10);
		
		lblEstadoDeuda = new JLabel("ESTADO");
		lblEstadoDeuda.setBounds(538, 20, 86, 14);
		panelCabecera.add(lblEstadoDeuda);
		
		panelCalculable = new JPanel();
		panelCalculable.setBounds(10, 267, 255, 67);
		panelCalculable.setBorder(new TitledBorder("CALCULABLE"));
		panelGestionDeuda.add(panelCalculable);
		panelCalculable.setLayout(null);
		
		txtInteres = new JTextField();
		txtInteres.setBounds(10, 36, 86, 20);
		panelCalculable.add(txtInteres);
		txtInteres.setColumns(10);
		
		lblInteres = new JLabel("INTERES %");
		lblInteres.setBounds(10, 20, 86, 14);
		panelCalculable.add(lblInteres);
		
		txtTotalPago = new JTextField();
		txtTotalPago.setBounds(106, 36, 86, 20);
		panelCalculable.add(txtTotalPago);
		txtTotalPago.setColumns(10);
		
		lblTotalPago = new JLabel("TOTAL");
		lblTotalPago.setBounds(106, 20, 86, 14);
		panelCalculable.add(lblTotalPago);
		
		panelPrestamista = new JPanel();
		panelPrestamista.setLayout(null);
		panelPrestamista.setBorder(new TitledBorder(null, "PRESTAMISTA"));
		panelPrestamista.setBounds(10, 179, 642, 77);
		panelGestionDeuda.add(panelPrestamista);
		
		txtIdPrestamista = new JTextField();
		txtIdPrestamista.addCaretListener(this);
		txtIdPrestamista.setColumns(10);
		txtIdPrestamista.setBounds(10, 44, 86, 20);
		panelPrestamista.add(txtIdPrestamista);
		
		lblIdPrestamista = new JLabel("ID PRESTAMISTA");
		lblIdPrestamista.setBounds(10, 28, 117, 14);
		panelPrestamista.add(lblIdPrestamista);
		
		btnBuscarPrestamista = new JButton("...");
		btnBuscarPrestamista.addActionListener(this);
		btnBuscarPrestamista.setBounds(104, 43, 35, 23);
		panelPrestamista.add(btnBuscarPrestamista);
		
		txtNombrePrestamista = new JTextField();
		txtNombrePrestamista.setColumns(10);
		txtNombrePrestamista.setBounds(159, 44, 178, 20);
		panelPrestamista.add(txtNombrePrestamista);
		
		lblNombrePrestamista = new JLabel("NOMBRE");
		lblNombrePrestamista.setBounds(159, 28, 86, 14);
		panelPrestamista.add(lblNombrePrestamista);
		
		txtApellidoPrestamista = new JTextField();
		txtApellidoPrestamista.setColumns(10);
		txtApellidoPrestamista.setBounds(347, 44, 178, 20);
		panelPrestamista.add(txtApellidoPrestamista);
		
		lblApellidoPrestamista = new JLabel("APELLIDO");
		lblApellidoPrestamista.setBounds(347, 28, 86, 14);
		panelPrestamista.add(lblApellidoPrestamista);
		
		txtDniPrestamista = new JTextField();
		txtDniPrestamista.setColumns(10);
		txtDniPrestamista.setBounds(535, 44, 97, 20);
		panelPrestamista.add(txtDniPrestamista);
		
		lblDniPrestamista = new JLabel("DNI");
		lblDniPrestamista.setBounds(535, 28, 86, 14);
		panelPrestamista.add(lblDniPrestamista);
		
		panelConsultaDeudor = new JPanel();
		panelConsultaDeudor.setLayout(null);
		tabbedPane.addTab("Consulta", null, panelConsultaDeudor, null);
		
		spTbDeudaa = new JScrollPane();
		spTbDeudaa.setBounds(10, 57, 642, 277);
		panelConsultaDeudor.add(spTbDeudaa);
		
		tbDeuda = new JTable();
		spTbDeudaa.setViewportView(tbDeuda);
		
		txtFiltro = new JTextField();
		txtFiltro.addKeyListener(this);
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(138, 26, 134, 20);
		panelConsultaDeudor.add(txtFiltro);
		
		cboFiltro = new JComboBox<Object>();
		cboFiltro.setBounds(10, 24, 118, 22);
		panelConsultaDeudor.add(cboFiltro);
		
		lblFiltrar = new JLabel("FILTRAR POR");
		lblFiltrar.setBounds(10, 11, 106, 14);
		panelConsultaDeudor.add(lblFiltrar);
		
		
		arranque();
	}
	
	//METODOS
	
	private void arranque() {
		limpiar();
		cargarCboFiltro();
	}
	
	private void limpiar() {
		for (Component obj : panelCabecera.getComponents()) {
			if(obj instanceof JTextField) {
				((JTextField) obj).setText("");
				((JTextField) obj).setEditable(false);
			}
		}
		for (Component obj : panelDeudor.getComponents()) {
			if(obj instanceof JTextField) {
				((JTextField) obj).setText("");
				((JTextField) obj).setEditable(false);
			}
		}
		for (Component obj : panelPrestamista.getComponents()) {
			if(obj instanceof JTextField) {
				((JTextField) obj).setText("");
				((JTextField) obj).setEditable(false);
			}
		}
		
		for (Component obj : panelCalculable.getComponents()) {
			if(obj instanceof JTextField) {
				((JTextField) obj).setText("");
				((JTextField) obj).setEditable(false);
			}
		}
		for (Component obj : panelGestionDeuda.getComponents()) {
			if(obj instanceof JTextField) {
				((JTextField) obj).setText("");
			}
		}
		
		
		
		txtIdDeuda.setText(arrDeuda.correlativo()+"");
		txtEstado.setText("REGISTRADO");
		txtFechaRegDeuda.setText(new SimpleDateFormat("dd/MM/yyy hh:mm:ss").format(new Date()));
		txtInteres.setText("0.00");
		

		listar();
	}
	
	private void adicionar () {
		try {
			int idDeuda = leerIdDeuda();
			int idPrestamista = leerIdPrestamista();
			int idPrestatario = leerIdPrestatario();
			double monto = leerMontoDeuda();
			int nroCuota = leerNroCuota();
			double interesDeuda = leerInteresDeuda();
			Date fechaReg = new Date();
			String estado = leerEstadoDeuda();
			
			Deuda obj = new Deuda();
			
			obj.setId_deuda(idDeuda);
			obj.setId_persona_prestamista(idPrestamista);
			obj.setId__persona_prestatario(idPrestatario);
			obj.setMonto_deuda(monto);
			obj.setCuota_deuda(nroCuota);
			obj.setInteres_deuda(interesDeuda);
			obj.setFechaReg_deuda(fechaReg);
			obj.setEstado_deuda(estado);
			
			arrDeuda.adicionar(obj);
			arrDeuda.grabarData();
			Custom.mensajeExito(this,"Registrado exitosamente" );
			limpiar();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Custom.mensajeError(this, e.getMessage());
		}
		
	}
	
	
	private void editar() {
		try {
			int idDeuda = leerIdDeuda();
			int idPrestamista = leerIdPrestamista();
			int idPrestatario = leerIdPrestatario();
			double monto = leerMontoDeuda();
			int nroCuota = leerNroCuota();
			double interesDeuda = leerInteresDeuda();
			Date fechaReg = new Date();
			String estado = leerEstadoDeuda();
			
			Deuda obj = new Deuda();
			
			obj.setId_deuda(idDeuda);
			obj.setId__persona_prestatario(idPrestatario);
			obj.setId_persona_prestamista(idPrestamista);
			obj.setMonto_deuda(monto);
			obj.setCuota_deuda(nroCuota);
			obj.setInteres_deuda(interesDeuda);
			obj.setFechaReg_deuda(fechaReg);
			obj.setEstado_deuda(estado);
			
			arrDeuda.editar(obj);
			arrDeuda.grabarData();
			Custom.mensajeExito(this,"Editado exitosamente" );
			limpiar();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Custom.mensajeError(this, e.getMessage());
		}
	}
	private void eliminar () {
		try {
			int idDeuda = leerIdDeuda();
			
			arrDeuda.eliminar(idDeuda);
			arrDeuda.grabarData();
			Custom.mensajeExito(this,"Eliminado exitosamente" );
			limpiar();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Custom.mensajeError(this, e.getMessage());
		}
	}
	
	private void listar() {
		Object[] cabecera = new Object[] {"ID","PRESTATARIO","PRESTAMISTA","MONTO","INTERES","CUOTAS","TOTAL","FECHA","ESTADO","EDITAR","ELIMINAR"};
		
		DefaultTableModel modelo = TablaRz.tableModel(cabecera);
		
		ArregloPersona arrDeudor = new ArregloPersona();
		
		JButton btnEditar =new JButton("Editar");
		btnEditar.setBackground(Color.BLUE);
		btnEditar.setVisible(true);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.red);
		btnEliminar.setVisible(true);
		
		for (Deuda obj:arrDeuda.listar()) {
			Object[] cuerpo = new Object[] {
				obj.getId_deuda(),
				arrDeudor.buscar(obj.getId__persona_prestatario()).getNom_persona(),
				arrDeudor.buscar(obj.getId_persona_prestamista()).getNom_persona(),
				obj.getMonto_deuda(),
				obj.getInteres_deuda(),
				obj.getCuota_deuda(),
				obj.getTotal(obj.getMonto_deuda(),obj.getCuota_deuda()),
				new SimpleDateFormat("dd MMM yyy").format(obj.getFechaReg_deuda()),
				obj.getEstado_deuda(),
				btnEditar,
				btnEliminar
				
			};
			modelo.addRow(cuerpo);
		}
		
		
		
		tbDeuda.setDefaultRenderer(Object.class, TablaRz.tableCellRendererModelComponent());
		tbDeuda.setRowHeight(20);
		tbDeuda.setModel(modelo);
		
		tbDeuda.setAutoResizeMode(0);
		TablaRz.autoAjustar(tbDeuda);
		
	}
	
	private void cargarCboFiltro() {
		
		cboFiltro.setSelectedIndex(-1);
		
		for(int i=0;i<tbDeuda.getColumnCount();i++) {
			cboFiltro.addItem(tbDeuda.getColumnName(i));
		}
	}
	
	
	//GETTER
	
	private int leerIdPrestamista() {
		int res = 0;
		
		res = Integer.parseInt(txtIdPrestamista.getText());
		
		return res;
		
	}
	
	private String leerEstadoDeuda() {
		// TODO Auto-generated method stub
		String res = null;
		
		res = txtEstado.getText();
		
		return res;
	}

	private double leerInteresDeuda() {
		// TODO Auto-generated method stub
		double res = 0;
		
		res = Double.parseDouble(txtInteres.getText());
		
		return res;
	}

	private int leerNroCuota() {
		// TODO Auto-generated method stub
		int res = 0;
		
		res = Integer.parseInt(txtCuota.getValue().toString());
		
		return res;
	}

	private double leerMontoDeuda() {
		// TODO Auto-generated method stub
		double res = 0;
		
		res = Double.parseDouble(txtMonto.getText());
		
		return res;
	}

	private int leerIdPrestatario() {
		// TODO Auto-generated method stub
		int res = 0;
		
		res = Integer.parseInt(txtIdPrestatario.getText());
		
		return res;
	}

	private int leerIdDeuda() {
		// TODO Auto-generated method stub
		int res = 0;
		
		res = Integer.parseInt(txtIdDeuda.getText());
		
		return res;
	}

	
	
	
	
	//ACTION LISTENER
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarPrestamista) {
			actionPerformedBtnBuscarPrestamista(e);
		}
		if (e.getSource() == btnBuscarDeudor) {
			actionPerformedBtnBuscarDeudor(e);
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
	protected void actionPerformedBtnBuscarDeudor(ActionEvent e) {
		
		DlgBuscarPersona.frame="FrmDeuda/Persona/Prestatario";
		DlgBuscarPersona dlg = new DlgBuscarPersona(this,true) ;
		dlg.setVisible(true);
	}
	protected void actionPerformedBtnBuscarPrestamista(ActionEvent e) {
		
		DlgBuscarPersona.frame="FrmDeuda/Persona/Prestamista";
		DlgBuscarPersona dlg = new DlgBuscarPersona(this,true);
		dlg.setVisible(true);
	}
	//CARET LISTENER
	public void caretUpdate(CaretEvent e) {
		if (e.getSource() == txtIdPrestamista) {
			caretUpdateTxtIdPrestamista(e);
		}
		if (e.getSource() == txtIdPrestatario) {
			caretUpdateTxtidDeuda(e);
		}
	}
	protected void caretUpdateTxtidDeuda(CaretEvent e) {
		
		if (txtIdPrestatario.getText().isEmpty()) {
			return;
		}
		
		
		try {

			ArregloPersona arrDeudor = new ArregloPersona();
			int idDeudro = Integer.parseInt(txtIdPrestatario.getText());
			
			Persona obj = arrDeudor.buscar(idDeudro);
			
			txtNombreDeudor.setText(obj.getNom_persona());
			txtApellidoDeudor.setText(obj.getApe_persona());
			txtDniDeudor.setText(obj.getDni_persona());
			
		}catch(Exception ex) {
			Custom.mensajeError(this, ex.getMessage());
		}
	}
	protected void caretUpdateTxtIdPrestamista(CaretEvent e) {
		if (txtIdPrestamista.getText().isEmpty()) {
			return;
		}
		
		
		try {
			ArregloPersona arrDeudor = new ArregloPersona();
			int idDeudro = Integer.parseInt(txtIdPrestamista.getText());
			
			Persona obj = arrDeudor.buscar(idDeudro);
			
			txtNombrePrestamista.setText(obj.getNom_persona());
			txtApellidoPrestamista.setText(obj.getApe_persona());
			txtDniPrestamista.setText(obj.getDni_persona());
			
		}catch(Exception ex) {
			Custom.mensajeError(this, ex.getMessage());
		}
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
		Custom.filtrarTabla(tbDeuda, txtFiltro.getText(), cboFiltro.getSelectedIndex());
	}
	//CHANGE LISTENER
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == txtCuota) {
			stateChangedTxtCuota(e);
		}
	}
	protected void stateChangedTxtCuota(ChangeEvent e) {
		if(txtMonto.getText().trim().length()==0) {
			txtInteres.setText("0.00");
			txtTotalPago.setText("0.00");
			return ;
		}
		
		try {
			double interesGenerado = new Deuda ().getInteresGenerado(leerNroCuota(), leerMontoDeuda());
			txtInteres.setText( new DecimalFormat("0.00").format(interesGenerado*100) );
			txtTotalPago.setText(new DecimalFormat("0.00").format(new Deuda().getTotal(leerMontoDeuda(), leerNroCuota())));
		}catch(Exception ex) {
			txtInteres.setText("0.00");
			txtTotalPago.setText("0.00");
		}
	}

}