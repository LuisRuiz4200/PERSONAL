package vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class FrmDeuda extends JFrame{
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private JPanel panelGestionDeuda;
	private JTextField txtidDeuda;
	private JLabel lblIdDeuda;
	private JTextField txtFechaRegDeuda;
	private JLabel lblFechaRegDeuda;
	private JTextField txtEstado;
	private JLabel lblEstadoDeuda;
	private JPanel panelDeudor;
	private JTextField txtIdDeudor;
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
	
	
	
	public static void main(String [] args) {
		
		FrmDeuda form = new FrmDeuda();
		form.setVisible(true);
		
	}
	
	public FrmDeuda() {
		
		setTitle("DEUDA");
		setBounds(100,100,693,428);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBounds(117, 74, 10, 10);
		setContentPane(panel);
		panel.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 5, 667, 373);
		panel.add(tabbedPane);
		
		panelGestionDeuda = new JPanel();
		tabbedPane.addTab("Gestion", null, panelGestionDeuda, null);
		panelGestionDeuda.setLayout(null);
		
		txtidDeuda = new JTextField();
		txtidDeuda.setBounds(10, 29, 86, 20);
		panelGestionDeuda.add(txtidDeuda);
		txtidDeuda.setColumns(10);
		
		lblIdDeuda = new JLabel("ID");
		lblIdDeuda.setBounds(10, 13, 86, 14);
		panelGestionDeuda.add(lblIdDeuda);
		
		txtFechaRegDeuda = new JTextField();
		txtFechaRegDeuda.setColumns(10);
		txtFechaRegDeuda.setBounds(397, 29, 123, 20);
		panelGestionDeuda.add(txtFechaRegDeuda);
		
		lblFechaRegDeuda = new JLabel("FECHA REGISTRO");
		lblFechaRegDeuda.setBounds(397, 13, 123, 14);
		panelGestionDeuda.add(lblFechaRegDeuda);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(548, 29, 86, 20);
		panelGestionDeuda.add(txtEstado);
		
		lblEstadoDeuda = new JLabel("ESTADO");
		lblEstadoDeuda.setBounds(548, 13, 86, 14);
		panelGestionDeuda.add(lblEstadoDeuda);
		
		panelDeudor = new JPanel();
		panelDeudor.setBorder(new TitledBorder(null, "DEUDOR", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDeudor.setBounds(10, 60, 642, 77);
		panelGestionDeuda.add(panelDeudor);
		panelDeudor.setLayout(null);
		
		txtIdDeudor = new JTextField();
		txtIdDeudor.setColumns(10);
		txtIdDeudor.setBounds(10, 44, 86, 20);
		panelDeudor.add(txtIdDeudor);
		
		lblIdDeudor = new JLabel("ID DEUDOR");
		lblIdDeudor.setBounds(10, 28, 86, 14);
		panelDeudor.add(lblIdDeudor);
		
		btnBuscarDeudor = new JButton("...");
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
		txtMonto.setBounds(10, 165, 86, 20);
		panelGestionDeuda.add(txtMonto);
		
		lblMonto = new JLabel("MONTO");
		lblMonto.setBounds(10, 149, 86, 14);
		panelGestionDeuda.add(lblMonto);
		
		txtCuota = new JTextField();
		txtCuota.setColumns(10);
		txtCuota.setBounds(106, 165, 86, 20);
		panelGestionDeuda.add(txtCuota);
		
		lblCuota = new JLabel("CUOTA");
		lblCuota.setBounds(106, 149, 86, 14);
		panelGestionDeuda.add(lblCuota);
		
		txtInteres = new JTextField();
		txtInteres.setColumns(10);
		txtInteres.setBounds(429, 165, 86, 20);
		panelGestionDeuda.add(txtInteres);
		
		lblInteres = new JLabel("INTERES %");
		lblInteres.setBounds(429, 149, 86, 14);
		panelGestionDeuda.add(lblInteres);
		
		txtTotalPago = new JTextField();
		txtTotalPago.setColumns(10);
		txtTotalPago.setBounds(525, 165, 86, 20);
		panelGestionDeuda.add(txtTotalPago);
		
		lblTotalPago = new JLabel("TOTAL");
		lblTotalPago.setBounds(525, 149, 86, 14);
		panelGestionDeuda.add(lblTotalPago);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(10, 311, 89, 23);
		panelGestionDeuda.add(btnAgregar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(116, 311, 89, 23);
		panelGestionDeuda.add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(215, 311, 89, 23);
		panelGestionDeuda.add(btnEliminar);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(314, 311, 89, 23);
		panelGestionDeuda.add(btnNuevo);
		
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
		
	}
	
}
