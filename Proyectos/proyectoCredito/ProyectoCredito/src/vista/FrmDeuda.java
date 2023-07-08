package vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;

import arreglo.ArregloDeuda;
import arreglo.ArregloDeudor;
import modelo.Deudor;
import reuzable.Custom;

import javax.swing.event.CaretEvent;

@SuppressWarnings("serial")
public class FrmDeuda extends JFrame implements ActionListener, CaretListener{
	

	public static JTextField txtIdDeudor;
	
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
	private JTextField txtCuota;
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
	
	
	
	public static void main(String [] args) {
		
		FrmDeuda form = new FrmDeuda();
		form.setVisible(true);
		
	}
	
	public FrmDeuda() {
		
		setTitle("DEUDA");
		setBounds(100,100,700,458);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBounds(117, 74, 10, 10);
		setContentPane(panel);
		panel.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 667, 373);
		panel.add(tabbedPane);
		
		panelGestionDeuda = new JPanel();
		tabbedPane.addTab("Gestion", null, panelGestionDeuda, null);
		panelGestionDeuda.setLayout(null);
		
		panelDeudor = new JPanel();
		panelDeudor.setBorder(new TitledBorder(null, "DEUDOR", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDeudor.setBounds(10, 91, 642, 77);
		panelGestionDeuda.add(panelDeudor);
		panelDeudor.setLayout(null);
		
		txtIdDeudor = new JTextField();
		txtIdDeudor.setColumns(10);
		txtIdDeudor.addCaretListener(this);
		txtIdDeudor.setBounds(10, 44, 86, 20);
		panelDeudor.add(txtIdDeudor);
		
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
		txtMonto.setBounds(470, 195, 86, 20);
		panelGestionDeuda.add(txtMonto);
		
		lblMonto = new JLabel("MONTO");
		lblMonto.setBounds(470, 179, 86, 14);
		panelGestionDeuda.add(lblMonto);
		
		txtCuota = new JTextField();
		txtCuota.setColumns(10);
		txtCuota.setBounds(566, 195, 86, 20);
		panelGestionDeuda.add(txtCuota);
		
		lblCuota = new JLabel("CUOTA");
		lblCuota.setBounds(566, 179, 86, 14);
		panelGestionDeuda.add(lblCuota);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(10, 311, 89, 23);
		panelGestionDeuda.add(btnAgregar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(116, 311, 89, 23);
		panelGestionDeuda.add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(215, 311, 89, 23);
		panelGestionDeuda.add(btnEliminar);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(314, 311, 89, 23);
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
		panelCalculable.setBounds(10, 179, 255, 67);
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
		
		panelConsultaDeudor = new JPanel();
		panelConsultaDeudor.setLayout(null);
		tabbedPane.addTab("Consulta", null, panelConsultaDeudor, null);
		
		spTbDeudaa = new JScrollPane();
		spTbDeudaa.setBounds(10, 57, 642, 277);
		panelConsultaDeudor.add(spTbDeudaa);
		
		tbDeuda = new JTable();
		spTbDeudaa.setViewportView(tbDeuda);
		
		txtFiltro = new JTextField();
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
		
		for (Component obj : panelCalculable.getComponents()) {
			if(obj instanceof JTextField) {
				((JTextField) obj).setText("");
				((JTextField) obj).setEditable(false);
			}
		}
		
		txtIdDeuda.setText(arrDeuda.correlativo()+"");
	}
	
	private void adicionar () {
		int idDeuda = leerIdDeuda();
		int idDeudor = leerIdDeudor();
		double monto = leerMontoDeuda();
		int nroCuota = leerNroCuota();
		double interesDeuda = leerInteresDeuda();
		Date fechaReg = new Date();
		String estado = leerEstadoDeuda();
	}
	
	private int leerIdDeuda() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void editar() {
		
	}
	private void eliminar () {
		
	}
	
	private void listar() {
		
	}
	
	
	
	//GETTER
	
	
	
	
	
	//ACTION LISTENER
	public void actionPerformed(ActionEvent e) {
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
	}
	protected void actionPerformedBtnEditar(ActionEvent e) {
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
	}
	protected void actionPerformedBtnBuscarDeudor(ActionEvent e) {
		DlgBuscarDeudor dlg = new DlgBuscarDeudor(this,true);
		dlg.frame="FrmDeuda";
		dlg.setVisible(true);
	}
	//CARET LISTENER
	public void caretUpdate(CaretEvent e) {
		if (e.getSource() == txtIdDeudor) {
			caretUpdateTxtidDeuda(e);
		}
	}
	protected void caretUpdateTxtidDeuda(CaretEvent e) {
		
		if (txtIdDeudor.getText().isEmpty()) {
			return;
		}
		
		
		try {

			ArregloDeudor arrDeudor = new ArregloDeudor();
			int idDeudro = Integer.parseInt(txtIdDeudor.getText());
			
			Deudor obj = arrDeudor.buscar(idDeudro);
			
			txtNombreDeudor.setText(obj.getNom_deudor());
			txtApellidoDeudor.setText(obj.getApe_deudor());
			txtDniDeudor.setText(obj.getDni_deudor());
			
		}catch(Exception ex) {
			Custom.mensajeError(this, ex.getMessage());
		}
	}
}
