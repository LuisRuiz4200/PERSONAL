package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloConfeccion;
import arreglos.ArregloIngresoDefectos;
import arreglos.ArregloNroOp;
import arreglos.ArregloOrdenes;
import clases.IngresoDefecto;


@SuppressWarnings("serial")
public class DlgIngresoDefectos extends JInternalFrame implements ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JDesktopPane escritorio;
	private JLabel lblOrdenP;
	private JButton btnIngresar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblColor;
	private JTextField txtNroGuia;
	private JLabel lblNroGuia;
	private JTextField txtMotivo;
	private JLabel lblMotivo;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloTallas;
	private JButton btnNuevaOp;
	private JButton btnActualizar;
	private JLabel lblConfeccion;
	private JComboBox <Object> cboConfeccion;
	private JTextField txtTalla0;
	private JTextField txtTalla2;
	private JTextField txtTalla4;
	private JTextField txtTalla6;
	private JTextField txtTalla8;
	private JTextField txtTalla10;
	private JTextField txtTalla12;
	private JTextField txtTalla14;
	private JLabel lblTalla0;
	private JLabel lblTalla2;
	private JLabel lblTalla4;
	private JLabel lblTalla6;
	private JLabel lblTalla8;
	private JLabel lblTalla10;
	private JLabel lblTalla12;
	private JLabel lblTalla14;
	private JTextField txtTalla16;
	private JLabel lblTalla16;
	private JTextField txtTalla18;
	private JLabel lblTalla18;
	private JTextField txtTalla20;
	private JLabel lblTalla20;
	private JTextArea txtS;
	private JComboBox <Object>cboNroOp;
	private JComboBox <Object> cboColor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DlgIngresoDefectos dialog = new DlgIngresoDefectos();
		dialog.setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public DlgIngresoDefectos() {
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		setTitle("ingresos");
		setBounds(10, 10, 857, 472);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		escritorio = new JDesktopPane();
		contentPanel.add(escritorio, BorderLayout.CENTER);
		
		lblOrdenP = new JLabel("Orden Produccion:");
		lblOrdenP.setBounds(20, 24, 138, 13);
		contentPanel.add(lblOrdenP);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(700, 20, 114, 21);
		contentPanel.add(btnIngresar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(700, 51, 114, 21);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(700, 82, 114, 21);
		contentPanel.add(btnEliminar);
		
		lblColor = new JLabel("Color:");
		lblColor.setBounds(148, 24, 110, 13);
		contentPanel.add(lblColor);
		
		txtNroGuia = new JTextField();
		txtNroGuia.setBounds(168, 82, 96, 19);
		contentPanel.add(txtNroGuia);
		txtNroGuia.setColumns(10);
		
		lblNroGuia = new JLabel("Nro Guia:");
		lblNroGuia.setBounds(20, 85, 110, 13);
		contentPanel.add(lblNroGuia);
		
		txtMotivo = new JTextField();
		txtMotivo.setBounds(168, 111, 96, 19);
		contentPanel.add(txtMotivo);
		txtMotivo.setColumns(10);
		
		lblMotivo = new JLabel("Motivo:");
		lblMotivo.setBounds(20, 114, 110, 13);
		contentPanel.add(lblMotivo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 238, 566, 184);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(359, 128, 85, 21);
		contentPanel.add(btnGrabar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(459, 128, 85, 21);
		contentPanel.add(btnCancelar);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("FECHA");
		modelo.addColumn("CONFECCION");
		modelo.addColumn("NRO. GUIA");
		modelo.addColumn("NRO. OP");
		modelo.addColumn("COLOR");
		modelo.addColumn("TOTAL");
		modelo.addColumn("MOTIVO");
		table.setModel(modelo);
		
		cboNroOp = new JComboBox<Object>();
		cboNroOp.addActionListener(this);
		cboNroOp.setBounds(20, 43, 114, 21);
		contentPanel.add(cboNroOp);
		
		cboColor = new JComboBox<Object>();
		cboColor.addActionListener(this);
		cboColor.setBounds(148, 43, 114, 21);
		contentPanel.add(cboColor);
		
		btnNuevaOp = new JButton("NuevaOp");
		btnNuevaOp.addActionListener(this);
		btnNuevaOp.setBounds(416, 16, 107, 21);
		contentPanel.add(btnNuevaOp);
		
		btnActualizar = new JButton("\u25BA");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(459, 47, 64, 21);
		contentPanel.add(btnActualizar);
		
		lblConfeccion = new JLabel("Confeccion:");
		lblConfeccion.setBounds(272, 24, 110, 13);
		contentPanel.add(lblConfeccion);
		
		cboConfeccion = new JComboBox<Object>();
		cboConfeccion.addActionListener(this);
		cboConfeccion.setBounds(272, 43, 114, 21);
		contentPanel.add(cboConfeccion);
		
		modeloTallas = new DefaultTableModel();
		modeloTallas.addColumn("talla 0");
		modeloTallas.addColumn("talla 2");
		modeloTallas.addColumn("talla 4");
		modeloTallas.addColumn("talla 6");
		modeloTallas.addColumn("talla 8");
		modeloTallas.addColumn("talla 10");
		modeloTallas.addColumn("talla 12");
		modeloTallas.addColumn("talla 14");
		modeloTallas.addColumn("talla 16");
		modeloTallas.addColumn("talla 18");
		modeloTallas.addColumn("talla 20");
		modeloTallas.addColumn("TOTAL");
		
		txtTalla0 = new JTextField();
		txtTalla0.setBounds(10, 199, 51, 19);
		contentPanel.add(txtTalla0);
		txtTalla0.setColumns(10);
		
		txtTalla2 = new JTextField();
		txtTalla2.setColumns(10);
		txtTalla2.setBounds(71, 199, 51, 19);
		contentPanel.add(txtTalla2);
		
		txtTalla4 = new JTextField();
		txtTalla4.setColumns(10);
		txtTalla4.setBounds(132, 199, 51, 19);
		contentPanel.add(txtTalla4);
		
		txtTalla6 = new JTextField();
		txtTalla6.setColumns(10);
		txtTalla6.setBounds(191, 199, 51, 19);
		contentPanel.add(txtTalla6);
		
		txtTalla8 = new JTextField();
		txtTalla8.setColumns(10);
		txtTalla8.setBounds(252, 199, 51, 19);
		contentPanel.add(txtTalla8);
		
		txtTalla10 = new JTextField();
		txtTalla10.setColumns(10);
		txtTalla10.setBounds(312, 199, 51, 19);
		contentPanel.add(txtTalla10);
		
		txtTalla12 = new JTextField();
		txtTalla12.setColumns(10);
		txtTalla12.setBounds(373, 199, 51, 19);
		contentPanel.add(txtTalla12);
		
		txtTalla14 = new JTextField();
		txtTalla14.setColumns(10);
		txtTalla14.setBounds(434, 199, 51, 19);
		contentPanel.add(txtTalla14);
		
		lblTalla0 = new JLabel("talla0:");
		lblTalla0.setBounds(10, 180, 51, 13);
		contentPanel.add(lblTalla0);
		
		lblTalla2 = new JLabel("talla2:");
		lblTalla2.setBounds(71, 180, 51, 13);
		contentPanel.add(lblTalla2);
		
		lblTalla4 = new JLabel("talla4:");
		lblTalla4.setBounds(132, 180, 51, 13);
		contentPanel.add(lblTalla4);
		
		lblTalla6 = new JLabel("Talla6:");
		lblTalla6.setBounds(191, 180, 51, 13);
		contentPanel.add(lblTalla6);
		
		lblTalla8 = new JLabel("Talla8:");
		lblTalla8.setBounds(252, 180, 51, 13);
		contentPanel.add(lblTalla8);
		
		lblTalla10 = new JLabel("Talla10:");
		lblTalla10.setBounds(312, 180, 51, 13);
		contentPanel.add(lblTalla10);
		
		lblTalla12 = new JLabel("Talla12:");
		lblTalla12.setBounds(373, 180, 51, 13);
		contentPanel.add(lblTalla12);
		
		lblTalla14 = new JLabel("Talla14:");
		lblTalla14.setBounds(434, 180, 51, 13);
		contentPanel.add(lblTalla14);
		
		txtTalla16 = new JTextField();
		txtTalla16.setColumns(10);
		txtTalla16.setBounds(495, 199, 51, 19);
		contentPanel.add(txtTalla16);
		
		lblTalla16 = new JLabel("Talla16:");
		lblTalla16.setBounds(495, 180, 51, 13);
		contentPanel.add(lblTalla16);
		
		txtTalla18 = new JTextField();
		txtTalla18.setColumns(10);
		txtTalla18.setBounds(556, 199, 51, 19);
		contentPanel.add(txtTalla18);
		
		lblTalla18 = new JLabel("Talla18:");
		lblTalla18.setBounds(556, 180, 51, 13);
		contentPanel.add(lblTalla18);
		
		txtTalla20 = new JTextField();
		txtTalla20.setColumns(10);
		txtTalla20.setBounds(617, 199, 51, 19);
		contentPanel.add(txtTalla20);
		
		lblTalla20 = new JLabel("Talla20:");
		lblTalla20.setBounds(617, 180, 51, 13);
		contentPanel.add(lblTalla20);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtS.setBounds(586, 238, 244, 184);
		contentPanel.add(txtS);
		
		//arranques
		arranque();
		
	}
	
	//varibale global
	ArregloIngresoDefectos ai=new ArregloIngresoDefectos();
	private int  posicion =-1;
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboConfeccion) {
			actionPerformedCboConfeccion(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnNuevaOp) {
			actionPerformedBtnNuevaOp(e);
		}
		if (e.getSource() == cboColor) {
			actionPerformedCboColor(e);
		}
		if (e.getSource() == cboNroOp) {
			actionPerformedCboNroOp(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
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
		consultar();
		reporte();
	}
	
	
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		DlgIngresoDefectos dlgIngesoDefectos= new DlgIngresoDefectos();
		dlgIngesoDefectos.setVisible(true);
		FrmPrincipal.escritorio.add(dlgIngesoDefectos);
		this.dispose();
	}
	protected void actionPerformedBtnNuevaOp(ActionEvent e) {
		DlgOrdenes dlgOrdenes=new DlgOrdenes();
		dlgOrdenes.setVisible(true);
		FrmPrincipal.escritorio.add(dlgOrdenes);
		dlgOrdenes.toFront();
	}
	
	protected void actionPerformedCboConfeccion(ActionEvent e) {
		
	}
	
	protected void actionPerformedCboColor(ActionEvent e) {
		
	}
	protected void actionPerformedCboNroOp(ActionEvent e) {
		llenarCboColor();
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		posicion=0;
		botonesActivos(true);
		cuadrosActivos(true);
		limpiar();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
		posicion=1;
		botonesActivos(true);
		cuadrosActivos(true);
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		try {
			int nroGuia=leerNroGuia();
			
			IngresoDefecto in=ai.buscarNroGuia(nroGuia);
			String cuadro=restringido("contraseña");
			
			if(cuadro.equals("luis")) {
				
				if(in!=null) {
					ai.eliminar(in);
				}else{
					mensaje("no existen registros !");
				}
			}
			else {
				mensaje("contraseña incorrecta");
			}
		}
		catch(Exception el) {
			mensaje("Operacion cancelada");
		}
		
		
		listar();
		ai.grabarIngresos();
			
		
		
		
	}
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		try {
			
			int nroGuia=leerNroGuia();
			int nroOp=leerCboNroOp();
			int talla0=leerTalla0();
			int talla2=leerTalla2();
			int talla4=leerTalla4();
			int talla6=leerTalla6();
			int talla8=leerTalla8();
			int talla10=leerTalla10();
			int talla12=leerTalla12();
			int talla14=leerTalla14();
			int talla16=leerTalla16();
			int talla18=leerTalla18();
			int talla20=leerTalla20();
			String confeccion=leerCboConfeccion();
			String color=leerCboColor();
			String motivo=leerMotivo();
			
			
			IngresoDefecto x=ai.buscarNroGuia(nroGuia);
			
			if(posicion==0) {
				if(x==null) {
					ai.adicionar(new IngresoDefecto(ai.correlativo(),fechaActual(),confeccion,nroGuia,nroOp,color, motivo,
							talla0,talla2,talla4,talla6,talla8,talla10,talla12,talla14,talla16,talla18,talla20));
					cuadrosActivos(false);
				}else {
					mensaje ("el nro de guia existe !");
					cuadrosActivos(true);
				}
			}
			if(posicion==1) {
				if(x!=null) {
					x.setNroGuia(nroGuia);
					x.setConfeccion(confeccion);
					x.setOrdenP(nroOp);
					x.setColor(color);
					x.setMotivo(motivo);
					x.setTalla0(talla0);
					x.setTalla2(talla2);
					x.setTalla4(talla4);
					x.setTalla6(talla6);
					x.setTalla8(talla8);
					x.setTalla10(talla10);
					x.setTalla12(talla12);
					x.setTalla14(talla14);
					x.setTalla16(talla16);
					x.setTalla18(talla18);
					x.setTalla20(talla20);
					
				}else {
					mensaje("sin registros");
				}
				cuadrosActivos(false);
				reporte();
			}
		}catch (Exception el){
			mensaje("valores invalidos!");
		}
		
		listar();
		botonesActivos(false);
		ai.grabarIngresos();
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		botonesActivos(false);
		cuadrosActivos(false);
	}
	//metodos get
	public int leerNroGuia() {
		return Integer.parseInt(txtNroGuia.getText().trim());
	}
	
	public String leerMotivo() {
		return txtMotivo.getText().trim();
	}
	
	public String leerCboConfeccion() {
		return cboConfeccion.getSelectedItem() + "";
	}
	public int leerCboNroOp() {
		return (int) cboNroOp.getSelectedItem();
	}
	public String leerCboColor() {
		return cboColor.getSelectedItem() + "";
	}
	
	public String restringido(String s) {
		return JOptionPane.showInputDialog(this,s);
	}
	public String fechaActual() {
		return new SimpleDateFormat ("dd/MM/yyyy").format (new Date());
	}
	public int leerTalla0() {
		
		if((txtTalla0.getText().trim()).equals("")) {
			return 0;
		}else {
			return Integer.parseInt(txtTalla0.getText().trim());
		}
	}
	public int leerTalla2() {
		if((txtTalla2.getText().trim()).equals("")) {
			return 0;
		}else {
			return Integer.parseInt(txtTalla2.getText().trim());
		}
	}
	public int leerTalla4() {
		if((txtTalla4.getText().trim()).equals("")) {
			return 0;
		}else {
			return Integer.parseInt(txtTalla4.getText().trim());
		}
	}
	public int leerTalla6() {
		if((txtTalla6.getText().trim()).equals("")) {
			return 0;
		}else {
			return Integer.parseInt(txtTalla6.getText().trim());
		}
	}
	public int leerTalla8() {
		if((txtTalla8.getText().trim()).equals("")) {
			return 0;
		}else {
			return Integer.parseInt(txtTalla8.getText().trim());
		}
	}
	public int leerTalla10() {
		if((txtTalla10.getText().trim()).equals("")) {
			return 0;
		}else {
			return Integer.parseInt(txtTalla10.getText().trim());
		}
	}
	public int leerTalla12() {
		if((txtTalla12.getText().trim()).equals("")) {
			return 0;
		}else {
			return Integer.parseInt(txtTalla12.getText().trim());
		}
	}
	public int leerTalla14() {
		if((txtTalla14.getText().trim()).equals("")) {
			return 0;
		}else {
			return Integer.parseInt(txtTalla14.getText().trim());
		}
	}
	public int leerTalla16() {
		if((txtTalla16.getText().trim()).equals("")) {
			return 0;
		}else {
			return Integer.parseInt(txtTalla16.getText().trim());
		}
	}
	public int leerTalla18() {
		if((txtTalla18.getText().trim()).equals("")) {
			return 0;
		}else {
			return Integer.parseInt(txtTalla18.getText().trim());
		}
	}
	public int leerTalla20() {
		if((txtTalla20.getText().trim()).equals("")) {
			return 0;
		}else {
			return Integer.parseInt(txtTalla20.getText().trim());	
		}
	}
	//metodos void 
	public void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	public void imprimir(String s) {
		txtS.append(s + "\n");
	}
	public void listar(){
		
		modelo.setRowCount(0);
		
		for(int i=0;i<ai.tamaño();i++) {
			IngresoDefecto in=ai.obtener(i);
			Object []o={
					fechaActual(),
					in.getConfeccion(),
					in.getNroGuia(),
					in.getOrdenP(),
					in.getColor(),
					in.total(),
					in.getMotivo()
			};
			modelo.addRow(o);
		}
		
		
	}
	public void reporte () {
		int indice=table.getSelectedRow();
		IngresoDefecto id =ai.obtener(indice);
		int numTalla = 0;
		int suma = 0;
		
		Object [] talla = {
				id.getTalla0(),
				id.getTalla2(),
				id.getTalla4(),
				id.getTalla6(),
				id.getTalla8(),
				id.getTalla10(),
				id.getTalla12(),
				id.getTalla14(),
				id.getTalla16(),
				id.getTalla18(),
				id.getTalla20()
				};
		txtS.setText("");
		
		for (int i=0;i<talla.length;i++) {
			
			if ((int)talla[i]!=0) {
				
				imprimir("Talla " + numTalla+ " = " +talla[i]);
			}
			numTalla += 2;
			suma += (int)talla[i];
		}
		imprimir ("=================");
		imprimir ("TOTAL : " + suma );
	}
	/*public void listarTallas() {
		modeloTallas.setRowCount(0);
		int i=table.getSelectedRow();
		Ingresos in=ai.obtener(i);
		Object[] o= {
				in.getTalla0(),
				in.getTalla2(),
				in.getTalla4(),
				in.getTalla6(),
				in.getTalla8(),
				in.getTalla10(),
				in.getTalla12(),
				in.getTalla14(),
				in.getTalla16(),
				in.getTalla18(),
				in.getTalla20(),
				in.total()
		};
		modeloTallas.addRow(o);
		
	}*/
	public void llenarCboNroOp() {
		
		ArregloNroOp op=new ArregloNroOp();
		
		cboNroOp.removeAllItems();
		
		for(int i=0;i<op.tamaño();i++) {

			int x=op.obtener(i).getNroOp();
			cboNroOp.addItem(x);
			
		}
	}
	public void llenarCboColor() {
		ArregloOrdenes ao=new ArregloOrdenes();
	
		int opCbo=Integer.valueOf(cboNroOp.getSelectedItem().toString());
		
		cboColor.removeAllItems();
		
		for(int i=0;i<ao.tamaño();i++) {
			if(ao.obtener(i).getNroOp()==opCbo) {
				cboColor.addItem(ao.obtener(i).getColor());
			}
		}
		
		
	}
	public void llenarCboConfeccion() {
		ArregloConfeccion ac= new ArregloConfeccion();
		for(int i=0;i<ac.tamaño();i++) {
			String c=ac.obtener(i).getCodigoCiti();
			cboConfeccion.addItem("citi" + c);
		}
	}
	public void cuadrosActivos(boolean x) {
		txtS.setEditable(false);
		txtNroGuia.setEditable(x);
		txtMotivo.setEditable(x);
		txtTalla0.setEditable(x);
		txtTalla2.setEditable(x);
		txtTalla4.setEditable(x);
		txtTalla6.setEditable(x);
		txtTalla8.setEditable(x);
		txtTalla10.setEditable(x);
		txtTalla12.setEditable(x);
		txtTalla14.setEditable(x);
		txtTalla16.setEditable(x);
		txtTalla18.setEditable(x);
		txtTalla20.setEditable(x);
	}
	public void botonesActivos(boolean x) {
		btnGrabar.setEnabled(x);
		btnCancelar.setEnabled(x);
		btnIngresar.setEnabled(!x);
		btnModificar.setEnabled(!x);
		btnEliminar.setEnabled(!x);
	}
	public void consultar() {
		
		int i=table.getSelectedRow();
		IngresoDefecto in=ai.obtener(i);
		
		txtNroGuia.setText("" + in.getNroGuia());
		cboConfeccion.setSelectedItem(in.getConfeccion());
		cboNroOp.setSelectedItem(in.getOrdenP());
		cboColor.setSelectedItem(in.getColor());
		txtMotivo.setText(in.getMotivo());
		txtTalla0.setText("" +in.getTalla0());
		txtTalla2.setText("" +in.getTalla2());
		txtTalla4.setText("" +in.getTalla4());
		txtTalla6.setText("" +in.getTalla6());
		txtTalla8.setText("" +in.getTalla8());
		txtTalla10.setText("" +in.getTalla10());
		txtTalla12.setText("" +in.getTalla12());
		txtTalla14.setText("" +in.getTalla14());
		txtTalla16.setText("" +in.getTalla16());
		txtTalla18.setText("" +in.getTalla18());
		txtTalla20.setText("" +in.getTalla20());
	}
	public void arranque() {
		llenarCboConfeccion();
		llenarCboNroOp();
		cuadrosActivos(false);
		botonesActivos(false);

		listar();
	}
	public void limpiar(){
		txtS.setText("");
		txtNroGuia.setText("");
		txtMotivo.setText("");
		txtTalla0.setText("");
		txtTalla2.setText("");
		txtTalla4.setText("");
		txtTalla6.setText("");
		txtTalla8.setText("");
		txtTalla10.setText("");
		txtTalla12.setText("");
		txtTalla14.setText("");
		txtTalla16.setText("");
		txtTalla18.setText("");
		txtTalla20.setText("");
	}
	
}
