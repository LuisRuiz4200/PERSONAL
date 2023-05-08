package vistas;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import arreglos.*;
import clases.*;
import utils.Tool;


@SuppressWarnings("serial")
public class FrmGasto extends JInternalFrame implements ActionListener {
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JTextField txtMonto;
	private JLabel lblMonto;
	private JTextField txtMotivo;
	private JLabel lblMotivo;
	private JDateChooser dcFecha;
	private JLabel lblFecha;
	private JTextField txtCuota;
	private JLabel lblCuota;
	private JTextField txtInteres;
	private JLabel lblInteres;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private ArregloGasto arrGasto;
	private JLabel lblCliente;
	private JComboBox<Object> cboCliente;
	private ArregloCliente arrCliente;
	
	
	
	
	public static void main (String[] args) {
		
		FrmGasto form = new FrmGasto ();
		form.setVisible(true);
		
	}
	
	public FrmGasto() {
		
		setTitle("GASTOS");
		setBounds(100,100,603,199);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		
		this.getContentPane().setLayout(null);
		
		
		arrGasto = new ArregloGasto();
		arrCliente = new ArregloCliente();
		
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 29, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtMonto = new JTextField();
		txtMonto.setColumns(10);
		txtMonto.setBounds(10, 78, 86, 20);
		getContentPane().add(txtMonto);
		
		lblMonto = new JLabel("Monto");
		lblMonto.setBounds(10, 60, 46, 14);
		getContentPane().add(lblMonto);
		
		txtMotivo = new JTextField();
		txtMotivo.setColumns(10);
		txtMotivo.setBounds(272, 29, 136, 20);
		getContentPane().add(txtMotivo);
		
		lblMotivo = new JLabel("Motivo");
		lblMotivo.setBounds(272, 11, 46, 14);
		getContentPane().add(lblMotivo);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(445, 29, 125, 20);
		getContentPane().add(dcFecha);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(445, 11, 46, 14);
		getContentPane().add(lblFecha);
		
		txtCuota = new JTextField();
		txtCuota.addActionListener(this);
		txtCuota.setColumns(10);
		txtCuota.setBounds(125, 78, 86, 20);
		getContentPane().add(txtCuota);
		
		lblCuota = new JLabel("Cuotas");
		lblCuota.setBounds(125, 60, 46, 14);
		getContentPane().add(lblCuota);
		
		txtInteres = new JTextField();
		txtInteres.setColumns(10);
		txtInteres.setBounds(244, 78, 86, 20);
		getContentPane().add(txtInteres);
		
		lblInteres = new JLabel("Interes");
		lblInteres.setBounds(244, 60, 46, 14);
		getContentPane().add(lblInteres);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(366, 121, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(481, 121, 89, 23);
		getContentPane().add(btnEliminar);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(113, 11, 72, 14);
		getContentPane().add(lblCliente);
		
		cboCliente = new JComboBox<Object>();
		cboCliente.setBounds(111, 28, 151, 22);
		getContentPane().add(cboCliente);
		
		arranque();		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtCuota) {
			actionPerformedTxtCuota(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
	}
	
	
	protected void actionPerformedTxtCuota(ActionEvent e) {
		
		switch (txtCuota.getText().trim()) {
		case "1":
			txtInteres.setText("" + 0);
			break;
		case "2":
			txtInteres.setText("" + 7.53);
			break;
		case "3":
			txtInteres.setText("" + 5.61);
			break;
		case "6":
			txtInteres.setText("" + 13.42);
			break;
		default:
			txtInteres.setText("");
		}
		
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		
		
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		
		int codigo= leerCodigo();
		String cliente= leerCliente();
		String motivo=leerMotivo();
		double monto=leerMonto();
		String fecha=leerFecha();
		int cuota=leerCuota();
		double interes=leerInteres();
		
		Gasto g= new Gasto(codigo,cliente, motivo,monto,fecha,cuota,interes);
		
		if(codigo==-1 || motivo==null || monto==-1 || fecha==null || cuota==-1 || interes ==-1 ) {
			Tool.mensajeError(this, "Fall� el registro");
		}else {
			arrGasto.adicionar(g);
			Tool.mensajeExito(this, "Se grab� registro");
			limpiar();
			arrGasto.gabrarGasto();
			
		}
		
		
	}
	
	//metodos de ingreso

	private String leerCliente() {
		String res=null;
		
		for (int i=0;i<arrCliente.tama�o();i++) {
			if(arrCliente.obtener(i).getNombre().equals(cboCliente.getSelectedItem())) {
				res = arrCliente.obtener(i).getCodigo();
			}
		}
		
		return res;
	}

	private double leerInteres() {
		double res=-1;
		
		if(txtInteres.getText().trim().length()==0){
			Tool.mensajeError(this, "Error en el campo de intereses");
		}else {
			res = Double.parseDouble(txtInteres.getText().trim());
		}
		
		return res;
	}

	private int leerCuota() {
		int res =-1;
		if(txtCuota.getText().trim().length()==0){
			Tool.mensajeError(this, "Agrege las cuotas");
		}else {
			res = Integer.parseInt(txtCuota.getText().trim());
		}
		return res;
	}

	private String leerFecha() {
		
		String res=null;
		if(dcFecha.getDate().toString().trim().length()==0){
			Tool.mensajeError(this, "Ingrese una fecha !");
		}else {
			res = Tool.sdf.format( dcFecha.getDate());
		}
		return res;
	}

	private double leerMonto() {
		double res=-1;
		if(txtMonto.getText().trim().length()==0){
			Tool.mensajeError(this, "Ingrese el monto!");
		}else {
			res = Double.parseDouble(txtMonto.getText().trim());
		}
		return res;
	}

	private String leerMotivo() {
		String res=null;
		if(txtMotivo.getText().trim().length()==0){
			Tool.mensajeError(this, "Motivos necesarios !");
		}else {
			res = txtMotivo.getText().trim();
		}
		return res;
	}

	private int leerCodigo() {
		int res= -1;
		if(txtCodigo.getText().trim().length()==0){
			Tool.mensajeError(this, "Error de codigo");
		}else {
			res = Integer.parseInt(txtCodigo.getText().trim());
		}
		return res;
	}
	
	
	//metodos adicionales 
	
	int correlativo() {
		
		if(arrGasto.tama�o()==0) {
			return 1;
		}else {
			return (arrGasto.obtener(arrGasto.tama�o()-1).getCodigo())+1;
		} 
	}
	
	void arranque() {
		txtCodigo.setEditable(false);
		txtCodigo.setText("" + correlativo());
		dcFecha.setDate(new Date());
		llenarCboCliente();
	}
	
	void llenarCboCliente() {
		
		cboCliente.removeAllItems();
		
		for (int i = 0 ;i<arrCliente.tama�o();i++) {
			cboCliente.addItem(arrCliente.obtener(i).getNombre());
		}
	}
	
	void limpiar() {
		txtCodigo.setText("" + correlativo());
		txtMotivo.setText("");
		txtMonto.setText("");
		dcFecha.setDate(new Date());
		txtCuota.setText("");
		txtInteres.setText("");
	}
}
