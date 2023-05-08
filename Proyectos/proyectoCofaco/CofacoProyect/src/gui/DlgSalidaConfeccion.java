package gui;

import javax.swing.*;
import java.awt.*;
import arreglos.*;
import clases.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class DlgSalidaConfeccion extends JInternalFrame implements ActionListener, MouseListener {
	
	private Container c;
	private JLabel lblNroOp;
	private JLabel lblSubCorte;
	private JButton btnModificar;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnCancelar;
	private JButton btnGrabar;
	private JLabel lblSupervisor;
	private JLabel lblIngreso;
	private JTextField txtIngreso;
	private JLabel lblSalida;
	private JTextField txtSalida;
	private JLabel lblDevolucion;
	private JTextField txtDevolucion;
	private DefaultTableModel modelo;
	
	private int posicion=-1;
	
	ArregloIngresoSalida aip= new ArregloIngresoSalida();
	private JComboBox <Object>cboSupervisor;
	private JComboBox <Object>cboNroOp;
	private JComboBox <Object>cboSubCorte;
	private JButton btnPorLiquidar;
	private JLabel lblLinea;
	private JTextField txtLinea;
	
	public static void main(String [] args) {
		
		DlgSalidaConfeccion dlgSalidaPiezas = new DlgSalidaConfeccion();
		dlgSalidaPiezas.setVisible(true);
		
	}
	
	public DlgSalidaConfeccion () {
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		setTitle("salida de confeccion");
		setBounds(10,10,799,418);
		
		c=this.getContentPane();
		c.setLayout(null);
		
		lblNroOp = new JLabel("Nro Op :");
		lblNroOp.setBounds(146, 20, 83, 13);
		c.add(lblNroOp);
		
		lblSubCorte = new JLabel("Sub-corte :");
		lblSubCorte.setBounds(279, 20, 83, 13);
		getContentPane().add(lblSubCorte);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(641, 26, 110, 21);
		getContentPane().add(btnModificar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 154, 765, 219);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(277, 95, 85, 21);
		getContentPane().add(btnCancelar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(182, 95, 85, 21);
		getContentPane().add(btnGrabar);
		
		lblSupervisor = new JLabel("Supervisor :");
		lblSupervisor.setBounds(10, 20, 83, 13);
		getContentPane().add(lblSupervisor);
		
		lblIngreso = new JLabel("Ingreso :");
		lblIngreso.setBounds(427, 17, 86, 13);
		getContentPane().add(lblIngreso);
		
		txtIngreso = new JTextField();
		txtIngreso.setBounds(523, 14, 51, 19);
		getContentPane().add(txtIngreso);
		txtIngreso.setColumns(10);
		
		lblSalida = new JLabel("Salida :");
		lblSalida.setBounds(427, 51, 86, 13);
		getContentPane().add(lblSalida);
		
		txtSalida = new JTextField();
		txtSalida.setColumns(10);
		txtSalida.setBounds(523, 48, 51, 19);
		getContentPane().add(txtSalida);
		
		lblDevolucion = new JLabel("Devolucion :");
		lblDevolucion.setBounds(427, 84, 86, 13);
		getContentPane().add(lblDevolucion);
		
		txtDevolucion = new JTextField();
		txtDevolucion.setColumns(10);
		txtDevolucion.setBounds(523, 81, 51, 19);
		getContentPane().add(txtDevolucion);
		
		modelo= new DefaultTableModel();
		modelo.addColumn("FECHA");
		modelo.addColumn("SUPERVISOR");
		modelo.addColumn("LINEA");
		modelo.addColumn("NRO.  OP");
		modelo.addColumn("SUB. CORTE");
		modelo.addColumn("COLOR");
		modelo.addColumn("CLIENTE");
		modelo.addColumn("INGRESO");
		modelo.addColumn("SALIDA");
		modelo.addColumn("DEVOLUCION");
		modelo.addColumn("FALTANTE");
		table.setModel(modelo);
		
		cboSupervisor = new JComboBox<Object>();
		cboSupervisor.addActionListener(this);
		cboSupervisor.setBounds(10, 43, 96, 21);
		getContentPane().add(cboSupervisor);
		
		cboNroOp = new JComboBox<Object>();
		cboNroOp.addActionListener(this);
		cboNroOp.setBounds(146, 43, 96, 21);
		getContentPane().add(cboNroOp);
		
		cboSubCorte = new JComboBox<Object>();
		cboSubCorte.addActionListener(this);
		cboSubCorte.setBounds(279, 43, 85, 21);
		getContentPane().add(cboSubCorte);
		
		btnPorLiquidar = new JButton("PorLiquidar");
		btnPorLiquidar.addActionListener(this);
		btnPorLiquidar.setBounds(641, 61, 110, 21);
		getContentPane().add(btnPorLiquidar);
		
		lblLinea = new JLabel("Linea :");
		lblLinea.setBounds(10, 75, 83, 13);
		getContentPane().add(lblLinea);
		
		txtLinea = new JTextField();
		txtLinea.setColumns(10);
		txtLinea.setBounds(10, 97, 96, 19);
		getContentPane().add(txtLinea);
		
		
		arranque();
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPorLiquidar) {
			actionPerformedBtnPorLiquidar(e);
		}
		if (e.getSource() == cboSubCorte) {
			actionPerformedCboSubCorte(e);
		}
		if (e.getSource() == cboNroOp) {
			actionPerformedCboNroOp(e);
		}
		if (e.getSource() == cboSupervisor) {
			actionPerformedCboSupervisor(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
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
	}
	
	protected void actionPerformedBtnPorLiquidar(ActionEvent e) {
		listarPorLiquidacion();
	}
	
	protected void actionPerformedCboSupervisor(ActionEvent e) {
		cboSubCorte.removeAllItems();
		llenarCboNroOp();
		listarPorSupervisor();
	}
	protected void actionPerformedCboNroOp(ActionEvent e) {
		try {

			llenarCboSubCorte();
		}catch (Exception el) {
			
		}
	}
	protected void actionPerformedCboSubCorte(ActionEvent e) {
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		botonesActivos(true);
		posicion=0;
	}
	protected void actionPerformedBtnGrabar(ActionEvent e) {

		String linea=leerLinea();
		int nroOp=leerCboNroOp();
		int subCorte=leerCboSubCorte();
		int ingreso=leerIngreso();
		int salida=leerSalida();
		int devolucion=leerDevolucion();
		
		IngresoSalida ip= aip.buscar(linea,nroOp, subCorte);
		
		if(posicion==0) {
			if(ip!=null) {
				ip.setIngreso(ingreso);
				ip.setSalida(salida);
				ip.setDevolucion(devolucion);
			}else {
				mensaje("registro no archivado");
			}
		}
		botonesActivos(false);
		listarPorSupervisor();
		aip.grabarIngresoPiezas();
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		botonesActivos(false);
	}
	
	//metodos con retorno 
	
	public String leerLinea() {
		return txtLinea.getText();
	}
	
	public int leerIngreso() {
		if(txtIngreso.getText().trim().equals("")) {
			return 0;
		}else {
			return Integer.parseInt(txtIngreso.getText().trim());
		}
	}
	public int leerSalida() {
		if(txtSalida.getText().trim().equals("")) {
			return 0;
		}else {
			return Integer.parseInt(txtSalida.getText().trim());
		}
	}
	public int leerDevolucion() {
		if(txtDevolucion.getText().trim().equals("")) {
			return 0;
		}else {
			return Integer.parseInt(txtDevolucion.getText().trim());
		}
	}
	public int leerCboNroOp() {
		return Integer.parseInt(cboNroOp.getSelectedItem()+"");
	}
	public int leerCboSubCorte() {
		return Integer.parseInt(cboSubCorte.getSelectedItem()+"");
	}
	public String leerCboSupervisor() {
		return cboSupervisor.getSelectedItem()+"";
	}
	public String restringido(String s) {
		return JOptionPane.showInputDialog(this,s);
	}
	//metodos void 
	
	public void mensaje(String s) {
		JOptionPane.showMessageDialog(this,s,"Alerta",1);
	}
	
	public void listarPorSupervisor() {
		modelo.setRowCount(0);
		for(int i=0;i<aip.tamaño();i++) {
			IngresoSalida is= aip.obtener(i);
			if(is.getSupervisor().equals(leerCboSupervisor())) {
				Object[] x= {
						is.getFecha(),
						is.getSupervisor(),
						is.getLinea(),
						is.getNroOp(),
						is.getSubCorte(),
						is.getColor(),
						is.getCliente(),
						is.getIngreso(),
						is.getSalida(),
						is.getDevolucion(),
						is.faltante()
				};
				modelo.addRow(x);
			}	
		}
	}
	public void listarPorLiquidacion() {
		modelo.setRowCount(0);
		for(int i=0;i<aip.tamaño();i++) {
			IngresoSalida is= aip.obtener(i);
			if(is.getSupervisor().equals(leerCboSupervisor())) {
				if(!(is.faltante().equals("0"))) {
					Object[] x= {
							is.getFecha(),
							is.getSupervisor(),
							is.getLinea(),
							is.getNroOp(),
							is.getSubCorte(),
							is.getColor(),
							is.getCliente(),
							is.getIngreso(),
							is.getSalida(),
							is.getDevolucion(),
							is.faltante()
					};
					modelo.addRow(x);
				}
			}	
		}
	}
	public void arranque() {
		llenarCboSupervisor();
		listarPorSupervisor();
		cuadrosActivos(false);
		botonesActivos(false);
	}
	public void consultar() {
		
		int indice =table.getSelectedRow();
		
		String linea=(String) table.getValueAt(indice, 2);
		int nroOp=(int)table.getValueAt(indice,3);
		int subCorte=(int)table.getValueAt(indice,4);
		
		IngresoSalida is= aip.buscar(linea,nroOp, subCorte);

		
		txtLinea.setText(is.getLinea());
		cboNroOp.setSelectedItem(is.getNroOp());
		cboSubCorte.setSelectedItem(is.getSubCorte());
		txtIngreso.setText(is.getIngreso()+"");
		txtSalida.setText(is.getSalida()+"");
		txtDevolucion.setText(is.getDevolucion()+"");
		
	}
	public void llenarCboSupervisor() {
		
		ArregloColaborador col= new ArregloColaborador();
		
		cboSupervisor.removeAllItems();
		
		for(int i=0;i<col.tamaño();i++) {
			if(col.obtener(i).getTipo().equals("Supervisor")){
				cboSupervisor.addItem(col.obtener(i).getNombre());
			}
		}
		
		
	}
	public void llenarCboNroOp() {
		
		ArregloNroOp op = new ArregloNroOp();
		
		cboNroOp.removeAllItems();
		
		for(int i=0;i<op.tamaño();i++) {
			IngresoSalida is=aip.buscarOp(op.obtener(i).getNroOp());
			
			if(is!=null) {
				if(is.getSupervisor().equals(leerCboSupervisor())){
					cboNroOp.addItem(is.getNroOp());
				}
			}
			
		}
	}
	public void llenarCboSubCorte() {
		
		cboSubCorte.removeAllItems();
		
		/*for(int i=1;i<table.getRowCount();i++) {
			if((int)table.getValueAt(i,4)==leerCboNroOp()) {
				cboSubCorte.addItem(table.getValueAt(i, 2));
			}else {
				
			}
		}*/
		for(int i=0;i<aip.tamaño();i++) {
			if(aip.obtener(i).getNroOp()==leerCboNroOp()) {
				cboSubCorte.addItem(aip.obtener(i).getSubCorte());
			}
		}
	}
	
	
	public void botonesActivos(boolean x) {
		btnModificar.setEnabled(!x);
		btnPorLiquidar.setEnabled(!x);
		btnGrabar.setEnabled(x);
		btnCancelar.setEnabled(x);
	}
	public void cuadrosActivos(boolean x) {
		txtLinea.setEditable(x);
	}
}
