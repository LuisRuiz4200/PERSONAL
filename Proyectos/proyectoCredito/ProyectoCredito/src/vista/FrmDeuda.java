package vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import arreglo.ArregloDeuda;
import arreglo.ArregloDeudor;
import modelo.Deuda;
import modelo.Deudor;
import reuzable.Custom;

import javax.swing.event.CaretEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FrmDeuda extends JFrame implements ActionListener, CaretListener, KeyListener{
	

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
		panelDeudor.setBorder(new TitledBorder(null, "DEUDOR"));
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
		txtCuota.addCaretListener(this);
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
		listar();
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
		
	}
	
	private void adicionar () {
		try {
			int idDeuda = leerIdDeuda();
			int idDeudor = leerIdDeudor();
			double monto = leerMontoDeuda();
			int nroCuota = leerNroCuota();
			double interesDeuda = leerInteresDeuda();
			Date fechaReg = new Date();
			String estado = leerEstadoDeuda();
			
			Deuda obj = new Deuda();
			
			obj.setId_deuda(idDeuda);
			obj.setId_deudor(idDeudor);
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
			int idDeudor = leerIdDeudor();
			double monto = leerMontoDeuda();
			int nroCuota = leerNroCuota();
			double interesDeuda = leerInteresDeuda();
			Date fechaReg = new Date();
			String estado = leerEstadoDeuda();
			
			Deuda obj = new Deuda();
			
			obj.setId_deuda(idDeuda);
			obj.setId_deudor(idDeudor);
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
		Object[] cabecera = new Object[] {"ID","DEUDOR","MONTO","INTERES","CUOTAS","TOTAL","FECHA","ESTADO","EDITAR","ELIMINAR"};
		
		DefaultTableModel modelo = new DefaultTableModel(cabecera,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		ArregloDeudor arrDeudor = new ArregloDeudor();
		
		JButton btnEditar =new JButton("Editar");
		btnEditar.setBackground(Color.BLUE);
		btnEditar.setVisible(true);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.red);
		btnEliminar.setVisible(true);
		
		for (Deuda obj:arrDeuda.listar()) {
			Object[] cuerpo = new Object[] {
				obj.getId_deuda(),
				arrDeudor.buscar(obj.getId_deudor()).getNom_deudor(),
				obj.getMonto_deuda(),
				obj.getInteres_deuda(),
				obj.getCuota_deuda(),
				obj.getTotal(obj.getMonto_deuda(),obj.getCuota_deuda()),
				new SimpleDateFormat("dd MMM yyy").format(obj.getFechaReg_deuda()),
				obj.getEstado_deuda(),
				btnEditar,
				btnEliminar
				
			};
			
			this.tbDeuda.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
				@Override
				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
						boolean hasFocus, int row, int column) {
					// TODO Auto-generated method stub
					if( value instanceof JButton) {
						return (JButton) value;
					}
					
					return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				}
			});
			
			modelo.addRow(cuerpo);
		}
		
		tbDeuda.setRowHeight(20);
		tbDeuda.setModel(modelo);
		
	}
	
	private void cargarCboFiltro() {
		
		cboFiltro.setSelectedIndex(-1);
		
		for(int i=0;i<tbDeuda.getColumnCount();i++) {
			cboFiltro.addItem(tbDeuda.getColumnName(i));
		}
	}
	
	
	//GETTER
	
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
		
		res = Integer.parseInt(txtCuota.getText());
		
		return res;
	}

	private double leerMontoDeuda() {
		// TODO Auto-generated method stub
		double res = 0;
		
		res = Double.parseDouble(txtMonto.getText());
		
		return res;
	}

	private int leerIdDeudor() {
		// TODO Auto-generated method stub
		int res = 0;
		
		res = Integer.parseInt(txtIdDeudor.getText());
		
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
		DlgBuscarDeudor dlg = new DlgBuscarDeudor(this,true);
		dlg.frame="FrmDeuda";
		dlg.setVisible(true);
	}
	//CARET LISTENER
	public void caretUpdate(CaretEvent e) {
		if (e.getSource() == txtCuota) {
			caretUpdateTxtCuota(e);
		}
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
	protected void caretUpdateTxtCuota(CaretEvent e) {
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
}
