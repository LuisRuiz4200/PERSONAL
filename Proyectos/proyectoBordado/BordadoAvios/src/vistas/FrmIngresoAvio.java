package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import arreglos.*;
import clases.*;
import reuzables.Custom;

import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FrmIngresoAvio extends JFrame implements ActionListener, MouseListener, KeyListener{
	private JPanel panelOrdenProduccion;
	private JLabel lblNroVale;
	private JTextField txtNroVale;
	private JPanel PanelAvio;
	public static JTextField txtNroOP;
	private JLabel lblNroOP;
	public static JTextField txtClienteOP;
	private JLabel lblClienteOP;
	public static JTextField txtEstiloOP;
	private JLabel lblEstiloOP;
	private JButton btnBuscarOP;
	private JTextField txtFechaAvio;
	private JLabel lblFechaAvio;
	public static JTextField txtCodAvio;
	private JLabel lblCodAvio;
	private JButton btnBuscarAvio;
	public static JTextField txtDesAvio;
	private JLabel lblDesAvio;
	public static JTextField txtMedidaAvio;
	private JLabel lblMedidaAvio;
	private JTextField txtCantAvio;
	private JLabel lblCantAvio;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panelBtnMantener;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	private DefaultTableModel modelo;
	private ArregloIngresoAvio arrIngresoAvio;
	private JButton btnLimpiar;
	
	
	public static void main (String[] args) {
		FrmIngresoAvio ventana = new FrmIngresoAvio();
		ventana.setVisible(true);
	}
	
	public FrmIngresoAvio() {
		
		this.setTitle("INGRESO AVIOS");
		this.setBounds(0,0,747,540);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		panelOrdenProduccion = new JPanel();
		panelOrdenProduccion.setBorder(new TitledBorder(null, "Orden de Produccion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOrdenProduccion.setBounds(238, 11, 306, 127);
		getContentPane().add(panelOrdenProduccion);
		panelOrdenProduccion.setLayout(null);
		
		txtClienteOP = new JTextField();
		txtClienteOP.setColumns(10);
		txtClienteOP.setBounds(10, 45, 162, 20);
		panelOrdenProduccion.add(txtClienteOP);
		
		lblClienteOP = new JLabel("Cliente");
		lblClienteOP.setBounds(10, 25, 46, 14);
		panelOrdenProduccion.add(lblClienteOP);
		
		txtEstiloOP = new JTextField();
		txtEstiloOP.setColumns(10);
		txtEstiloOP.setBounds(10, 96, 264, 20);
		panelOrdenProduccion.add(txtEstiloOP);
		
		lblEstiloOP = new JLabel("Estilo");
		lblEstiloOP.setBounds(10, 76, 46, 14);
		panelOrdenProduccion.add(lblEstiloOP);
		
		lblNroVale = new JLabel("Nro  Vale");
		lblNroVale.setBounds(572, 11, 86, 14);
		getContentPane().add(lblNroVale);
		
		txtNroVale = new JTextField();
		txtNroVale.setBounds(572, 31, 136, 20);
		getContentPane().add(txtNroVale);
		txtNroVale.setColumns(10);
		
		PanelAvio = new JPanel();
		PanelAvio.setBorder(new TitledBorder(null, "Avio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PanelAvio.setBounds(238, 145, 483, 91);
		getContentPane().add(PanelAvio);
		PanelAvio.setLayout(null);
		
		txtDesAvio = new JTextField();
		txtDesAvio.setColumns(10);
		txtDesAvio.setBounds(10, 45, 267, 20);
		PanelAvio.add(txtDesAvio);
		
		lblDesAvio = new JLabel("Descripcion");
		lblDesAvio.setBounds(10, 25, 96, 14);
		PanelAvio.add(lblDesAvio);
		
		txtMedidaAvio = new JTextField();
		txtMedidaAvio.setColumns(10);
		txtMedidaAvio.setBounds(302, 45, 108, 20);
		PanelAvio.add(txtMedidaAvio);
		
		lblMedidaAvio = new JLabel("Medida");
		lblMedidaAvio.setBounds(302, 25, 46, 14);
		PanelAvio.add(lblMedidaAvio);
		
		txtNroOP = new JTextField();
		txtNroOP.addKeyListener(this);
		txtNroOP.setBounds(10, 31, 86, 20);
		getContentPane().add(txtNroOP);
		txtNroOP.setColumns(10);
		
		lblNroOP = new JLabel("Nro OP");
		lblNroOP.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNroOP);
		
		btnBuscarOP = new JButton("Buscar OP");
		btnBuscarOP.addActionListener(this);
		btnBuscarOP.setBounds(105, 30, 123, 23);
		getContentPane().add(btnBuscarOP);
		
		txtFechaAvio = new JTextField();
		txtFechaAvio.setColumns(10);
		txtFechaAvio.setBounds(572, 79, 136, 20);
		getContentPane().add(txtFechaAvio);
		
		lblFechaAvio = new JLabel("Fecha ingreso");
		lblFechaAvio.setBounds(572, 59, 107, 14);
		getContentPane().add(lblFechaAvio);
		
		txtCodAvio = new JTextField();
		txtCodAvio.setColumns(10);
		txtCodAvio.addKeyListener(this);
		txtCodAvio.setBounds(10, 82, 86, 20);
		getContentPane().add(txtCodAvio);
		
		lblCodAvio = new JLabel("Cod. Avio");
		lblCodAvio.setBounds(10, 62, 86, 14);
		getContentPane().add(lblCodAvio);
		
		btnBuscarAvio = new JButton("Buscar Avio");
		btnBuscarAvio.addActionListener(this);
		btnBuscarAvio.setBounds(105, 81, 123, 23);
		getContentPane().add(btnBuscarAvio);
		
		txtCantAvio = new JTextField();
		txtCantAvio.setColumns(10);
		txtCantAvio.setBounds(10, 153, 86, 20);
		getContentPane().add(txtCantAvio);
		
		lblCantAvio = new JLabel("Cantidad");
		lblCantAvio.setBounds(10, 133, 86, 14);
		getContentPane().add(lblCantAvio);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 258, 711, 232);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		panelBtnMantener = new JPanel();
		panelBtnMantener.setLayout(null);
		panelBtnMantener.setBackground(SystemColor.activeCaption);
		panelBtnMantener.setBounds(117, 133, 111, 106);
		getContentPane().add(panelBtnMantener);
		
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
		
		modelo = new DefaultTableModel();
		modelo.addColumn("NRO VALE");
		modelo.addColumn("FECHA INGRESO");
		modelo.addColumn("NRO OP");
		modelo.addColumn("CLIENTE");
		modelo.addColumn("ESTILO");
		modelo.addColumn("COD AVIO");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("MEDIDA");
		modelo.addColumn("CANTIDAD");
		modelo.addColumn("ACCION");
		table.setModel(modelo);
		//PROPIEDADES DE LA TABLA
		table.setAutoResizeMode(0);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(10, 213, 89, 23);
		getContentPane().add(btnLimpiar);
		table.getColumn("DESCRIPCION").setPreferredWidth(200);
		table.getColumn("ESTILO").setPreferredWidth(180);
		table.getColumn("NRO VALE").setPreferredWidth(90);
		table.getColumn("FECHA INGRESO").setPreferredWidth(120);
		
		
		arrIngresoAvio = new ArregloIngresoAvio();
		
		arranque();
	}
	//ACTION EVENT
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnBuscarAvio) {
			actionPerformedBtnBuscarAvio(e);
		}
		if (e.getSource() == btnBuscarOP) {
			actionPerformedBtnBuscarOP(e);
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
		String nroVale= leerNroVale();
		int nroOP = leerNroOP();
		int codAvio= leerCodAvio();
		int cantAvio = leerCantAvio();
		String fechaAvio = leerFechaAvio();
		
		IngresoAvio ingresoAvio = new IngresoAvio(nroVale,nroOP,codAvio,fechaAvio,cantAvio);
		
		arrIngresoAvio.adicionar(ingresoAvio);
		arrIngresoAvio.grabarIngresoAvios();
		Custom.mensajeExito(this, "REGISTRO DEL VALE " + leerNroVale());
		limpiar();
		listarIngresoAvio();
		
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		String nroVale = leerNroVale();
		
		IngresoAvio ingresoAvio = arrIngresoAvio.buscar(nroVale);
		
		if(ingresoAvio !=null) {
			ingresoAvio.setNroOP(leerNroOP());
			ingresoAvio.setFechaAvio(leerFechaAvio());
			ingresoAvio.setCodAvio(leerCodAvio());
			ingresoAvio.setCantAvio(leerCantAvio());
		}else {
			Custom.mensajeError(this, "NO ENCONTRAMOS EL NRO VALE");
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
	}
	protected void actionPerformedBtnBuscarOP(ActionEvent e) {
		
		DlgBuscarOP dg = new DlgBuscarOP(new FrmPrincipal(),true);
		dg.setLocationRelativeTo(this);
		dg.setVisible(true);
		
	}
	protected void actionPerformedBtnBuscarAvio(ActionEvent e) {
		
		DlgBuscarAvio consultaAvio = new DlgBuscarAvio(this,true);
		DlgBuscarAvio.source="FrmIngresoAvio";
		consultaAvio.setVisible(true);
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		limpiar();
		Custom.mensajeAdvertencia(this, "Cuadros limpios");
	}
	//MOUSE EVENT 
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
	}
	//TXT ENTER
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtNroOP && e.getKeyCode() == KeyEvent.VK_ENTER) {
			keyReleasedTxtNroOP(e);
		}
		if (e.getSource() == txtCodAvio && e.getKeyCode() == KeyEvent.VK_ENTER) {
			keyReleasedTxtCodAvio(e);
		}
	}


	public void keyTyped(KeyEvent e) {
	}
	
	private void keyReleasedTxtCodAvio(KeyEvent e) {
		ArregloAvio arrAvio = new ArregloAvio();
		ArregloUniMed arrUM = new ArregloUniMed();
		
		int codAvio = leerCodAvio();
		
		if(arrAvio.buscar(codAvio)!=null) {
			txtDesAvio.setText(arrAvio.buscar(codAvio).getDesAvio());
			txtMedidaAvio.setText(arrAvio.buscar(codAvio).getCodUM() + " " +arrUM.buscar(arrAvio.buscar(codAvio).getCodUM()).getDesUM());
		}else {
			Custom.mensajeError(this, "AVIO NO REGISTRADO");
			limpiarAvio();
		}
		
	}
	protected void keyReleasedTxtNroOP(KeyEvent e) {
		
		ArregloCliente arrCliente = new ArregloCliente();
		ArregloEstiloOP arrEstiloOP = new ArregloEstiloOP();
		ArregloOrdenProduccion arrOP = new ArregloOrdenProduccion();
		
		int nroOP = leerNroOP();
		
		
		if(arrOP.buscar(nroOP)!=null) {
			String desEstilo = arrEstiloOP.buscar(arrOP.buscar(nroOP).getCodEstilo()).getDesEstiloOp() ;
			String desCliente = arrCliente.buscar(arrOP.buscar(nroOP).getCodCliente()).getDesCliente();
			
			txtClienteOP.setText(desCliente);
			txtEstiloOP.setText(desEstilo);
		}else {
			Custom.mensajeError(this, "NO EXISTE LA OP");
			limpiarOrdenProduccion();
		}
		

		
	}
	
	//METODOS DE ENTRADA
	
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
	
	private String leerFechaAvio() {
		String res = null;
		
		res = txtFechaAvio.getText().trim();
		
		return res;
	}
	
	//METODOS ADICIONALES
	private void arranque() {
		listarIngresoAvio();
		correlativo();
		limpiar();
	}
	
	private void listarIngresoAvio(){
		
		ArregloAvio arrAvio = new ArregloAvio();
		ArregloOrdenProduccion arrOrdenProd = new ArregloOrdenProduccion();
		ArregloUniMed arrUM = new ArregloUniMed();
		ArregloEstiloOP arrEstiloOP = new ArregloEstiloOP();
		ArregloCliente arrCliente = new ArregloCliente();
		
		modelo.setRowCount(0);
		for (int i=0;i<arrIngresoAvio.tamano();i++) {
			
			Object []x = {
					arrIngresoAvio.obtener(i).getNroVale(),
					arrIngresoAvio.obtener(i).getFechaAvio(),
					arrIngresoAvio.obtener(i).getNroOP(),
					arrCliente.buscar(arrOrdenProd.buscar(arrIngresoAvio.obtener(i).getNroOP()).getCodCliente()).getDesCliente(),
					arrEstiloOP.buscar(arrOrdenProd.buscar(arrIngresoAvio.obtener(i).getNroOP()).getCodEstilo()).getDesEstiloOp(),
					arrIngresoAvio.obtener(i).getCodAvio(),
					arrAvio.buscar(arrIngresoAvio.obtener(i).getCodAvio()).getDesAvio(),
					arrAvio.buscar(arrIngresoAvio.obtener(i).getCodAvio()).getMedidaAvio()+" "+arrUM.buscar(arrAvio.buscar(arrIngresoAvio.obtener(i).getCodAvio()).getCodUM()).getDesUM(),
					arrIngresoAvio.obtener(i).getCantAvio()
			};
			modelo.addRow(x);
		}
	}
	
	private void limpiarOrdenProduccion () {
		txtClienteOP.setText("");
		txtEstiloOP.setText("");
	}
	private void limpiarAvio() {
		txtDesAvio.setText("");
		txtMedidaAvio.setText("");
	}
	
	private void correlativo() {
		
		DecimalFormat ft = new DecimalFormat("0000000");
		
		String nroVale = "001-";
		
		if(arrIngresoAvio.tamano()==0) {
			txtNroVale.setText(nroVale + ft.format(1));
		}else {
			txtNroVale.setText(nroVale + ft.format(Integer.parseInt(arrIngresoAvio.obtener(arrIngresoAvio.tamano()-1).getNroVale().substring(4)) + 1));
		}

		
	}
	private void limpiar() {
		correlativo();
		txtNroOP.setText("");
		txtCodAvio.setText("");
		txtCantAvio.setText("");
		txtFechaAvio.setText(new SimpleDateFormat("dd. MMM yyyy").format(new Date()));
		limpiarOrdenProduccion();
		limpiarAvio();
	}


}
