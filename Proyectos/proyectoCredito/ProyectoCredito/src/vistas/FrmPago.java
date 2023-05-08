package vistas;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import clases.*;
import utils.Tool;
import arreglos.*;

@SuppressWarnings("serial")
public class FrmPago extends JInternalFrame implements ActionListener{
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JTextField txtAbono;
	private JLabel lblAbono;
	private JLabel lblCliente;
	private JComboBox <Object> cboCliente;
	private JDateChooser dcFecha;
	private JLabel lblFecha;
	private JButton btnAgregar;
	private JButton btnModificar;
	private ArregloPago arrPago;
	
	
	
	public static void main(String [] args) {
		
		FrmPago form = new FrmPago();
		form.setVisible(true);
		
	}
	
	public FrmPago() {
		
		setTitle("Pagos realizados");
		setBounds(100,100,523,198);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		this.getContentPane().setLayout(null);
		
		arrPago = new ArregloPago();
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 29, 86, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtAbono = new JTextField();
		txtAbono.setColumns(10);
		txtAbono.setBounds(10, 73, 86, 20);
		getContentPane().add(txtAbono);
		
		lblAbono = new JLabel("Abono");
		lblAbono.setBounds(10, 55, 46, 14);
		getContentPane().add(lblAbono);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(117, 10, 46, 14);
		getContentPane().add(lblCliente);
		
		cboCliente = new JComboBox<Object>();
		cboCliente.setBounds(117, 27, 160, 22);
		getContentPane().add(cboCliente);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(301, 29, 124, 20);
		getContentPane().add(dcFecha);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(301, 11, 46, 14);
		getContentPane().add(lblFecha);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(210, 85, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(336, 85, 89, 23);
		getContentPane().add(btnModificar);
		
		arranque();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		
		int codigo = leerCodigo();
		String cliente = leerCliente();
		String fecha = leerFecha ();
		double abono = leerAbono();
		
		arrPago.adicionar(new Pago(codigo,cliente,fecha,abono));
		Tool.mensajeExito(this, "Registro Exitoso");
		arrPago.gabrarPago();
		
	}


	protected void actionPerformedBtnModificar(ActionEvent e) {
	}
	
	//Metodos de ingreso
	
	private double leerAbono() {
		return Double.parseDouble(txtAbono.getText());
	}

	private String leerFecha() {
		return Tool.sdf.format(dcFecha.getDate());
	}

	private String leerCliente() {
		String res = null;
		
		ArregloCliente arrCliente = new ArregloCliente();
		
		for (int i=0;i<arrCliente.tama�o();i++) {
			if(arrCliente.obtener(i).getNombre().equals(cboCliente.getSelectedItem())) {
				res = arrCliente.obtener(i).getCodigo();
			}
		}
		return res;
	}

	private int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}
	
	//Metodos adicionales
	
	void arranque() {
		
		llenarCboCliente();
		txtCodigo.setText("" + correlativo());
		dcFecha.setDate(new Date());
	}
	
	void llenarCboCliente (){
		
		ArregloCliente arrCliente  = new ArregloCliente();
		
		cboCliente.removeAllItems();
		
		for (int i=0;i<arrCliente.tama�o();i++) {
			 cboCliente.addItem(arrCliente.obtener(i).getNombre());
		}
	}
	
	int correlativo() {
		if(arrPago.tama�o()==0) {
			return 1;
		}else {
			return arrPago.obtener(arrPago.tama�o()-1).getCodigo()+1;
		}
	}
	
	void limpiar () {
		txtCodigo.setText("" + correlativo());
		cboCliente.setSelectedIndex(-1);
		dcFecha.setDate(new Date());
		txtAbono.setText("");
		
	}
}