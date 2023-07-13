package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import arreglos.*;
import clases.*;
import reuzables.Custom;
import reuzables.Excel;

import javax.swing.border.TitledBorder;

import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

@SuppressWarnings("serial")
public class FrmIngresoAvio extends JInternalFrame implements ActionListener, MouseListener, KeyListener, CaretListener {


	public static JTextField txtNroOP;
	public static JTextField txtCodAvio;
	
	private DefaultTableModel modelo;
	private ArregloIngresoAvio arrIngresoAvio;
	private JTabbedPane tpIngresoAvio;
	private JPanel panelGestionIngresoAvio;
	private JPanel panelOrdenProduccion;
	private JTextField txtClienteOP;
	private JLabel lblClienteOP;
	private JTextField txtEstiloOP;
	private JLabel lblEstiloOP;
	private JButton btnBuscarOP;
	private JLabel lblNroOP;
	private JLabel lblNroVale;
	private JTextField txtNroVale;
	private JPanel PanelAvio;
	private JTextField txtDesAvio;
	private JLabel lblDesAvio;
	private JTextField txtMedidaAvio;
	private JLabel lblMedidaAvio;
	private JButton btnBuscarAvio;
	private JLabel lblCodAvio;
	private JTextField txtCantAvio;
	private JLabel lblCantAvio;
	private JTextField txtFechaAvio;
	private JLabel lblFechaAvio;
	private JScrollPane scrollPane;
	private JPanel panelBtnMantener;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private JTextField txtIdIngresoAvio;
	private JLabel lblIdIngresoAvio;
	private JTextField txtEstadoIngresoAvio;
	private JLabel lblEstado‌IngresoAvio;
	private JPanel panelIngresoAvio;
	private JPanel panelConsultaIngresoAvio;
	private JTable table;
	private JButton btnExcel;
	private JTextField txtId;
	private JTextField txtFiltro;
	private JComboBox cboFiltro;
	private JLabel lblFilto;

	public static void main(String[] args) {
		FrmIngresoAvio ventana = new FrmIngresoAvio();
		ventana.setVisible(true);
	}

	public FrmIngresoAvio() {

		this.setTitle("INGRESO AVIOS");
		this.setBounds(0, 0, 747, 363);

		this.setLocation(40, 40);
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);

		panelIngresoAvio = new JPanel();

		panelIngresoAvio.setLayout(new BorderLayout());
		this.setContentPane(panelIngresoAvio);

		tpIngresoAvio = new JTabbedPane(JTabbedPane.TOP);
		panelIngresoAvio.add(tpIngresoAvio);

		panelGestionIngresoAvio = new JPanel();
		panelGestionIngresoAvio.setLayout(null);
		tpIngresoAvio.addTab("Gestion", null, panelGestionIngresoAvio, null);

		panelOrdenProduccion = new JPanel();
		panelOrdenProduccion.setLayout(null);
		panelOrdenProduccion.setBorder(
				new TitledBorder(null, "Orden de Produccion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOrdenProduccion.setBounds(10, 64, 534, 91);
		panelGestionIngresoAvio.add(panelOrdenProduccion);

		txtClienteOP = new JTextField();
		txtClienteOP.setColumns(10);
		txtClienteOP.setBounds(162, 45, 86, 20);
		panelOrdenProduccion.add(txtClienteOP);

		lblClienteOP = new JLabel("Cliente");
		lblClienteOP.setBounds(162, 25, 46, 14);
		panelOrdenProduccion.add(lblClienteOP);

		txtEstiloOP = new JTextField();
		txtEstiloOP.setColumns(10);
		txtEstiloOP.setBounds(258, 45, 264, 20);
		panelOrdenProduccion.add(txtEstiloOP);

		lblEstiloOP = new JLabel("Estilo");
		lblEstiloOP.setBounds(258, 25, 46, 14);
		panelOrdenProduccion.add(lblEstiloOP);

		btnBuscarOP = new JButton("...");
		btnBuscarOP.addActionListener(this);
		btnBuscarOP.setBounds(105, 44, 31, 23);
		panelOrdenProduccion.add(btnBuscarOP);

		txtNroOP = new JTextField();
		txtNroOP.addCaretListener(this);
		txtNroOP.setColumns(10);
		txtNroOP.setBounds(10, 45, 86, 20);
		panelOrdenProduccion.add(txtNroOP);

		lblNroOP = new JLabel("Nro OP");
		lblNroOP.setBounds(10, 25, 46, 14);
		panelOrdenProduccion.add(lblNroOP);

		lblNroVale = new JLabel("Nro  Vale");
		lblNroVale.setBounds(66, 11, 86, 14);
		panelGestionIngresoAvio.add(lblNroVale);

		txtNroVale = new JTextField();
		txtNroVale.setColumns(10);
		txtNroVale.setBounds(66, 31, 136, 20);
		panelGestionIngresoAvio.add(txtNroVale);

		PanelAvio = new JPanel();
		PanelAvio.setLayout(null);
		PanelAvio.setBorder(new TitledBorder(null, "Avio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PanelAvio.setBounds(10, 164, 534, 125);
		panelGestionIngresoAvio.add(PanelAvio);

		txtDesAvio = new JTextField();
		txtDesAvio.setColumns(10);
		txtDesAvio.setBounds(146, 45, 238, 20);
		PanelAvio.add(txtDesAvio);

		lblDesAvio = new JLabel("Descripcion");
		lblDesAvio.setBounds(146, 25, 96, 14);
		PanelAvio.add(lblDesAvio);

		txtMedidaAvio = new JTextField();
		txtMedidaAvio.setColumns(10);
		txtMedidaAvio.setBounds(394, 45, 108, 20);
		PanelAvio.add(txtMedidaAvio);

		lblMedidaAvio = new JLabel("Medida");
		lblMedidaAvio.setBounds(394, 25, 46, 14);
		PanelAvio.add(lblMedidaAvio);

		btnBuscarAvio = new JButton("...");
		btnBuscarAvio.addActionListener(this);
		btnBuscarAvio.setBounds(105, 44, 31, 23);
		PanelAvio.add(btnBuscarAvio);

		txtCodAvio = new JTextField();
		txtCodAvio.addCaretListener(this);
		txtCodAvio.setColumns(10);
		txtCodAvio.setBounds(10, 45, 86, 20);
		PanelAvio.add(txtCodAvio);

		lblCodAvio = new JLabel("Cod. Avio");
		lblCodAvio.setBounds(10, 25, 86, 14);
		PanelAvio.add(lblCodAvio);

		txtCantAvio = new JTextField();
		txtCantAvio.setColumns(10);
		txtCantAvio.setBounds(10, 94, 86, 20);
		PanelAvio.add(txtCantAvio);

		lblCantAvio = new JLabel("Cantidad");
		lblCantAvio.setBounds(10, 74, 86, 14);
		PanelAvio.add(lblCantAvio);

		txtFechaAvio = new JTextField();
		txtFechaAvio.setColumns(10);
		txtFechaAvio.setBounds(455, 31, 136, 20);
		panelGestionIngresoAvio.add(txtFechaAvio);

		lblFechaAvio = new JLabel("Fecha ingreso");
		lblFechaAvio.setBounds(455, 11, 107, 14);
		panelGestionIngresoAvio.add(lblFechaAvio);

		panelBtnMantener = new JPanel();
		panelBtnMantener.setLayout(null);
		panelBtnMantener.setBackground(SystemColor.activeCaption);
		panelBtnMantener.setBounds(601, 129, 111, 106);
		panelGestionIngresoAvio.add(panelBtnMantener);

		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(10, 11, 89, 23);
		panelBtnMantener.add(btnAgregar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(10, 39, 89, 23);
		panelBtnMantener.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(10, 68, 89, 23);
		panelBtnMantener.add(btnEliminar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(611, 246, 89, 23);
		panelGestionIngresoAvio.add(btnLimpiar);

		txtIdIngresoAvio = new JTextField();
		txtIdIngresoAvio.setColumns(10);
		txtIdIngresoAvio.setBounds(10, 31, 46, 20);
		panelGestionIngresoAvio.add(txtIdIngresoAvio);

		lblIdIngresoAvio = new JLabel("ID");
		lblIdIngresoAvio.setBounds(10, 11, 46, 14);
		panelGestionIngresoAvio.add(lblIdIngresoAvio);

		txtEstadoIngresoAvio = new JTextField();
		txtEstadoIngresoAvio.setColumns(10);
		txtEstadoIngresoAvio.setBounds(601, 31, 86, 20);
		panelGestionIngresoAvio.add(txtEstadoIngresoAvio);

		lblEstado‌IngresoAvio = new JLabel("Estado");
		lblEstado‌IngresoAvio.setBounds(601, 11, 86, 14);
		panelGestionIngresoAvio.add(lblEstado‌IngresoAvio);

		panelConsultaIngresoAvio = new JPanel();
		tpIngresoAvio.addTab("Consulta", null, panelConsultaIngresoAvio, null);
		panelConsultaIngresoAvio.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 706, 209);

		panelConsultaIngresoAvio.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnExcel = new JButton("EXCEL");
		btnExcel.addActionListener(this);
		btnExcel.setBounds(596, 52, 89, 23);
		panelConsultaIngresoAvio.add(btnExcel);
		
		txtId = new JTextField();
		txtId.setBounds(630, 11, 86, 20);
		panelConsultaIngresoAvio.add(txtId);
		txtId.setColumns(10);
		
		txtFiltro = new JTextField();
		txtFiltro.addKeyListener(this);
		txtFiltro.setBounds(122, 34, 86, 20);
		panelConsultaIngresoAvio.add(txtFiltro);
		txtFiltro.setColumns(10);
		
		cboFiltro = new JComboBox();
		cboFiltro.setBounds(10, 33, 102, 22);
		panelConsultaIngresoAvio.add(cboFiltro);
		
		lblFilto = new JLabel("FILTRAR POR");
		lblFilto.setBounds(10, 14, 89, 14);
		panelConsultaIngresoAvio.add(lblFilto);

		arrIngresoAvio = new ArregloIngresoAvio();

		arranque();
	}

	// METODOS ADICIONALES
	private void arranque() {
		listarIngresoAvio();
		cargarCboFiltro();
		limpiar();
	}

	
	private void cargarCboFiltro() {
		
		int totalColumna = table.getColumnCount();
		
		for (int i=0;i<totalColumna;i++) {
			String nombreColumna = table.getColumnName(i);
			cboFiltro.addItem(nombreColumna);
		}
	}
	
	private void filtrarTablaIngresoAvio() {
		
		int nroColumna = cboFiltro.getSelectedIndex();
		String filtro = txtFiltro.getText().trim();
		
		TableRowSorter<TableModel> filtrador = new TableRowSorter<TableModel>(table.getModel()) ;
		filtrador.setRowFilter(RowFilter.regexFilter(filtro, nroColumna));
		table.setRowSorter(filtrador);
		
	}
	
	private void listarIngresoAvio() {
		
		Object[] cabeceraTabla = new Object[] { "ID", "NRO VALE", "NRO OP", "COD AVIO", "CANT", "FECHA","ESTADO" };
		int[] anchoColumna = new int[] {40,200,100,150,50,180,100};
		modelo = new DefaultTableModel(cabeceraTabla, 0);
		
		table.setModel(modelo);

		for (int i=0;i<table.getColumnCount();i++) {
			table.getColumn(cabeceraTabla[i]).setPreferredWidth(anchoColumna[i]);
		}
		
		for (IngresoAvio obj : arrIngresoAvio.listar()) {

			Object[] x = { 
					obj.getId_ingresoAvio(),
					obj.getNroVale_ingresoAvio(),
					obj.getNroOP(),
					obj.getCodAvio(),
					obj.getCant_ingresoAvio(),
					new SimpleDateFormat("dd/MM/yyy hh:mm:ss").format(obj.getFechaReg_ingresoAvio()),
					obj.getEstado_ingresoAvio()
			};
			modelo.addRow(x);

		}
		
		
		
	}

	

	private void agregar() {
		try {
			int id = leerIdIngresoAvio();
			String nroVale = leerNroVale();
			int nroOP = leerNroOP();
			int codAvio = leerCodAvio();
			int cantAvio = leerCantAvio();
			Date fecha = leerFechaAvio();
			String estado = leerEstadoIngresoAvio();
			
			IngresoAvio obj = new IngresoAvio();
			
			obj.setId_ingresoAvio(id);
			obj.setNroVale_ingresoAvio(nroVale);
			obj.setNroOP(nroOP);
			obj.setCodAvio(codAvio);
			obj.setCant_ingresoAvio(cantAvio);
			obj.setFechaReg_ingresoAvio(fecha);
			obj.setEstado_ingresoAvio(estado);
			
			arrIngresoAvio.adicionar(obj);
			arrIngresoAvio.grabarIngresoAvios();
			
			Custom.mensajeExito(this, "AGREGADO !");
			
			limpiar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Custom.mensajeAdvertencia(this, e.getMessage());
		}
		
		
	}

	private void editar() {
		try {
			int id = leerIdIngresoAvio();
			String nroVale = leerNroVale();
			int nroOP = leerNroOP();
			int codAvio = leerCodAvio();
			int cantAvio = leerCantAvio();
			Date fecha = leerFechaAvio();
			String estado = leerEstadoIngresoAvio();
			
			IngresoAvio obj = new IngresoAvio();
			
			obj.setId_ingresoAvio(id);
			obj.setNroVale_ingresoAvio(nroVale);
			obj.setNroOP(nroOP);
			obj.setCodAvio(codAvio);
			obj.setCant_ingresoAvio(cantAvio);
			obj.setFechaReg_ingresoAvio(fecha);
			obj.setEstado_ingresoAvio(estado);
			
			arrIngresoAvio.editar(obj);
			arrIngresoAvio.grabarIngresoAvios();
			
			Custom.mensajeExito(this, "EDITADO !");
			
			limpiar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Custom.mensajeAdvertencia(this, e.getMessage());
		}
	}

	private void eliminar() {
		
		try {
			int id = leerIdIngresoAvio();
			
			
			arrIngresoAvio.eliminar(id);
			arrIngresoAvio.grabarIngresoAvios();
			
			Custom.mensajeExito(this, "ELIMINADO !");
			
			limpiar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Custom.mensajeAdvertencia(this, e.getMessage());
		}
	}

	private void limpiar() {


		for (Component obj : panelOrdenProduccion.getComponents()) {
			if (obj instanceof JTextField) {
				((JTextField) obj).setText("");
				((JTextField) obj).setEditable(false);
				
				if(((JTextField) obj).isEditable()) {
					((JTextField) obj).setBackground(Color.yellow);;
				}
			}
		}

		for (Component obj : PanelAvio.getComponents()) {
			if (obj instanceof JTextField) {
				((JTextField) obj).setText("");
				((JTextField) obj).setEditable(false);
				txtCantAvio.setEditable(true);
				
				if(((JTextField) obj).isEditable()) {
					((JTextField) obj).setBackground(Color.yellow);;
				}
			}
		}

		for (Component obj : panelGestionIngresoAvio.getComponents()) {
			if (obj instanceof JTextField) {
				((JTextField) obj).setText("");
				((JTextField) obj).setEditable(false);
				
				txtNroVale.setEditable(true);
				txtIdIngresoAvio.setText(arrIngresoAvio.correlativo() + "");
				txtEstadoIngresoAvio.setText("REGISTRADO");
				txtFechaAvio.setText(new SimpleDateFormat("dd/MM/yyy hh:mm:ss").format(new Date()));
				
				if(((JTextField) obj).isEditable()) {
					((JTextField) obj).setBackground(Color.yellow);;
				}
			}
			
			
		}
		
		listarIngresoAvio();

		

	}

	// METODOS DE ENTRADA

	
	private String leerEstadoIngresoAvio() {
		String res = null;
		
		res = txtEstadoIngresoAvio.getText().trim();
		
		return res;
	}
	
	private int leerIdIngresoAvio() {
		int res = 0;
		
		res = Integer.parseInt(txtIdIngresoAvio.getText().trim());
		
		return res;
	}
	
	private String leerNroVale() {
		String res = null;

		res = txtNroVale.getText().trim();

		return res;
	}

	private int leerNroOP() {
		int res = -1;

		res = Integer.parseInt(txtNroOP.getText().trim());

		return res;
	}

	private int leerCodAvio() {
		int res = -1;

		res = Integer.parseInt(txtCodAvio.getText().trim());

		return res;
	}

	private int leerCantAvio() {
		int res = -1;

		res = Integer.parseInt(txtCantAvio.getText().trim());

		return res;
	}

	private Date leerFechaAvio() {
		Date res = null;

		try {
			res = new SimpleDateFormat("dd/MM/yyy hh:mm:ss").parse(txtFechaAvio.getText().trim());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	// ACTION EVENT
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExcel) {
			actionPerformedBtnExcel(e);
		}
		if (e.getSource() == btnBuscarAvio) {
			actionPerformedBtnBuscarAvio(e);
		}
		if (e.getSource() == btnBuscarOP) {
			actionPerformedBtnBuscarOP(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
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
		agregar();
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		editar();
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminar();
	}

	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiar();
	}

	protected void actionPerformedBtnBuscarOP(ActionEvent e) {
		DlgListaF10 dlg = new DlgListaF10(null,true);
		dlg.frame = "FrmIngresoAvio";
		dlg.setVisible(true);
	}

	protected void actionPerformedBtnBuscarAvio(ActionEvent e) {
		DlgBuscarAvio dlg = new DlgBuscarAvio(null,true);
		dlg.frame = "FrmIngresoAvio";
		dlg.setVisible(true);
		
	}

	// MOUSE EVENT
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	// KEY LISTENER
	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtFiltro) {
			keyReleasedTxtFiltro(e);
		}
		if (e.getSource() == txtNroOP && e.getKeyCode() == KeyEvent.VK_ENTER) {
			keyReleasedTxtNroOP(e);
		}
		if (e.getSource() == txtCodAvio && e.getKeyCode() == KeyEvent.VK_ENTER) {
			keyReleasedTxtCodAvio(e);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyReleasedTxtCodAvio(KeyEvent e) {
		ArregloAvio arrAvio = new ArregloAvio();
		ArregloUniMed arrUM = new ArregloUniMed();

		int codAvio = leerCodAvio();

		if (arrAvio.buscar(codAvio) != null) {
			txtDesAvio.setText(arrAvio.buscar(codAvio).getDesAvio());
			txtMedidaAvio.setText(arrAvio.buscar(codAvio).getCodUM() + " "
					+ arrUM.buscar(arrAvio.buscar(codAvio).getCodUM()).getDesUM());
		} else {
			Custom.mensajeError(this, "AVIO NO REGISTRADO");

		}

	}
	

	protected void keyReleasedTxtFiltro(KeyEvent e) {
		try {
			filtrarTablaIngresoAvio();
		}catch(Exception ex) {
			Custom.mensajeAdvertencia(this, ex.getMessage());
		}
	}

	protected void keyReleasedTxtNroOP(KeyEvent e) {

		ArregloCliente arrCliente = new ArregloCliente();
		ArregloEstiloOP arrEstiloOP = new ArregloEstiloOP();
		ArregloOrdenProduccion arrOP = new ArregloOrdenProduccion();

		int nroOP = leerNroOP();

		if (arrOP.buscar(nroOP) != null) {
			String desEstilo = arrEstiloOP.buscar(arrOP.buscar(nroOP).getCodEstilo()).getDesEstiloOp();
			String desCliente = arrCliente.buscar(arrOP.buscar(nroOP).getCodCliente()).getDesCliente();

			txtClienteOP.setText(desCliente);
			txtEstiloOP.setText(desEstilo);
		} else {
			Custom.mensajeError(this, "NO EXISTE LA OP");

		}

	}
	public void caretUpdate(CaretEvent e) {
		if (e.getSource() == txtCodAvio) {
			caretUpdateTxtCodAvio(e);
		}
		if (e.getSource() == txtNroOP) {
			caretUpdateTxtNroOP(e);
		}
	}
	protected void caretUpdateTxtNroOP(CaretEvent e) {
		
		try {
			int nroOP = leerNroOP();
			ArregloF10 arrF10 = new ArregloF10();
			F10 obj = arrF10.buscarPorNroOP(nroOP);
			
			txtClienteOP.setText(obj.getCliente_F10());
			txtEstiloOP.setText(obj.getEstilo_F10());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			return;
		}
		
	}
	protected void caretUpdateTxtCodAvio(CaretEvent e) {
		
		try {
			int codAvio = leerCodAvio();
			ArregloAvio arrAvio = new ArregloAvio();
			Avio obj = arrAvio.buscar(codAvio);
			
			txtDesAvio.setText(obj.getDesAvio());
			
			
		}catch (Exception ex){
		}
		
	}
	protected void actionPerformedBtnExcel(ActionEvent e) {
		
		Excel.generarExcel(this, "IngresoAvio", table);
	}
}
