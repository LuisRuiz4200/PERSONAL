package vistas;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import clases.*;
import utils.Tool;
import arreglos.*;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class FrmPago extends JInternalFrame implements ActionListener, KeyListener, ItemListener{
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JTextField txtMonto;
	private JLabel lblMonto;
	private JLabel lblCliente;
	private JComboBox <Object> cboCliente;
	private JDateChooser dcFecha;
	private JLabel lblFecha;
	private JButton btnAgregar;
	private JButton btnModificar;
	private ArregloPago arrPago;
	private JComboBox <Object> cboMedioPago;
	private JLabel lblMedioPago;
	private JPanel panelPago;
	private JPanel panelCliente;
	private JLabel lblNombre;
	private JTextField txtNombre_cliente;
	private JTextField txtApellido_cliente;
	private JLabel lblApellido;
	private JTextField txtDeuda_cliente;
	private JLabel lblDeuda;
	private JTextField txtEstado;
	private JLabel lblEstado;
	
	
	
	public static void main(String [] args) {
		
		FrmPago form = new FrmPago();
		form.setVisible(true);
		
	}
	
	public FrmPago() {
		
		setTitle("Pagos realizados");
		setBounds(100,100,608,310);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		this.getContentPane().setLayout(null);
		
		arrPago = new ArregloPago();
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(368, 239, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(494, 239, 89, 23);
		getContentPane().add(btnModificar);
		
		panelPago = new JPanel();
		panelPago.setBorder(new TitledBorder(null, "PAGO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPago.setBounds(10, 11, 572, 112);
		getContentPane().add(panelPago);
		panelPago.setLayout(null);
		
		lblCodigo = new JLabel("CODIGO");
		lblCodigo.setBounds(10, 18, 46, 14);
		panelPago.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 36, 86, 20);
		panelPago.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtMonto = new JTextField();
		txtMonto.setBounds(10, 80, 86, 20);
		panelPago.add(txtMonto);
		txtMonto.setColumns(10);
		
		lblMonto = new JLabel("MONTO");
		lblMonto.setBounds(10, 62, 46, 14);
		panelPago.add(lblMonto);
		
		lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(117, 17, 77, 14);
		panelPago.add(lblCliente);
		
		cboCliente = new JComboBox<Object>();
		cboCliente.addItemListener(this);
		cboCliente.addKeyListener(this);
		cboCliente.setBounds(117, 34, 160, 22);
		panelPago.add(cboCliente);
		
		dcFecha = new JDateChooser();
		dcFecha.setBounds(301, 36, 124, 20);
		panelPago.add(dcFecha);
		
		lblFecha = new JLabel("FECHA");
		lblFecha.setBounds(301, 18, 46, 14);
		panelPago.add(lblFecha);
		
		cboMedioPago = new JComboBox <Object>();
		cboMedioPago.setBounds(117, 79, 138, 22);
		panelPago.add(cboMedioPago);
		
		lblMedioPago = new JLabel("MEDIO DE PAGO");
		lblMedioPago.setBounds(117, 62, 104, 14);
		panelPago.add(lblMedioPago);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(435, 36, 111, 20);
		panelPago.add(txtEstado);
		txtEstado.setColumns(10);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(435, 18, 77, 14);
		panelPago.add(lblEstado);
		
		panelCliente = new JPanel();
		panelCliente.setBounds(10, 134, 437, 84);
		panelCliente.setBorder(new TitledBorder(null,"CLIENTE"));
		panelCliente.setLayout(null);
		getContentPane().add(panelCliente);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(10, 25, 70, 14);
		panelCliente.add(lblNombre);
		
		txtNombre_cliente = new JTextField();
		txtNombre_cliente.setBounds(10, 41, 115, 20);
		panelCliente.add(txtNombre_cliente);
		txtNombre_cliente.setColumns(10);
		
		txtApellido_cliente = new JTextField();
		txtApellido_cliente.setColumns(10);
		txtApellido_cliente.setBounds(150, 41, 131, 20);
		panelCliente.add(txtApellido_cliente);
		
		lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(150, 25, 86, 14);
		panelCliente.add(lblApellido);
		
		txtDeuda_cliente = new JTextField();
		txtDeuda_cliente.setColumns(10);
		txtDeuda_cliente.setBounds(323, 41, 86, 20);
		panelCliente.add(txtDeuda_cliente);
		
		lblDeuda = new JLabel("DEUDA");
		lblDeuda.setBounds(323, 25, 56, 14);
		panelCliente.add(lblDeuda);
		
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
		
		String codigo = leerCodigo();
		String cliente = leerCliente();
		String fecha = leerFecha ();
		double monto = leerMonto();
		String medioPago = leerMedioPago();
		String estado = leerEstado();
		
		
		if (Double.parseDouble(txtDeuda_cliente.getText())<=leerMonto()) {
			JOptionPane.showMessageDialog(this,"EXCEDE LA CANTIDAD DE LA DEUDA","MENSAJE",0);
			return;
		}
		
		arrPago.adicionar(new Pago(codigo,cliente,monto,fecha,medioPago,estado));
		Tool.mensajeExito(this, "Registro Exitoso");
		arrPago.grabarPago();
		arranque();
		
	}


	protected void actionPerformedBtnModificar(ActionEvent e) {
	}
	
	//Metodos de ingreso
	
	private String leerEstado() {
		String res =  null;
		
		res = txtEstado.getText().trim();
		
		return res;
	}
	
	private String leerMedioPago() {
		return cboMedioPago.getSelectedItem().toString();
	}
	
	private double leerMonto() {
		return Double.parseDouble(txtMonto.getText());
	}

	private String leerFecha() {
		return Tool.sdf.format(dcFecha.getDate());
	}

	private String leerCliente() {
		String res = null;
		
		ArregloCliente arrCliente = new ArregloCliente();
		
		for (int i=0;i<arrCliente.tama�o();i++) {
			if(arrCliente.obtener(i).getNom_cliente().equals(cboCliente.getSelectedItem())) {
				res = arrCliente.obtener(i).getId_cliente();
			}
		}
		return res;
	}

	private String leerCodigo() {
		return txtCodigo.getText();
	}
	
	//Metodos adicionales
	
	void arranque() {
		
		llenarCboCliente();
		cargarMedioPago();
		limpiar();
	}
	
	void llenarCboCliente (){
		
		ArregloCliente arrCliente  = new ArregloCliente();
		
		cboCliente.removeAllItems();
		
		cboCliente.addItem("ELIGA");
		
		for (int i=0;i<arrCliente.tama�o();i++) {
			 cboCliente.addItem(arrCliente.obtener(i).getNom_cliente());
		}
	}
	
	int correlativo() {
		if(arrPago.tama�o()==0) {
			return 1;
		}else {
			return Integer.parseInt(arrPago.obtener(arrPago.tama�o()-1).getId_pago())+1;
		}
	}
	
	void limpiar () {
		txtEstado.setText("REGISTRADO");
		txtEstado.setEditable(false);
		txtCodigo.setText("" + correlativo());
		cboCliente.setSelectedIndex(0);
		dcFecha.setDate(new Date());
		txtMonto.setText("");
		
	}
	
	void cargarMedioPago() {
		
		String[] medioPago = {"EFECTIVO","YAPE","PLIN","TRANFERENCIA"};
		
		cboMedioPago.setModel(new DefaultComboBoxModel(medioPago));
		
	}
	
	void mostrarCliente() {
		String idCliente = leerCliente();
		
		Cliente objCliente = new ArregloCliente().buscar(idCliente);
			
		if (objCliente!=null) {
			
			double deudaAcumulada = new ArregloDeuda().deudaTotal(idCliente) - new ArregloPago().pagoTotal(idCliente);
			
			txtNombre_cliente.setText(objCliente.getNom_cliente());
			txtApellido_cliente.setText(objCliente.getApe_cliente());
			txtDeuda_cliente.setText(deudaAcumulada + "");
		}else {
			txtNombre_cliente.setText("");
			txtApellido_cliente.setText("");
			txtDeuda_cliente.setText("");
		}
		
	}
	//LLAVE LIBERADA DEL COMBO CLIENTE
	public void keyPressed(KeyEvent e) {
		
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == cboCliente) {
			keyReleasedCboCliente(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedCboCliente(KeyEvent e) {
		mostrarCliente();
	}
	
	//MOUSE CLIKED DEL COMBO CLIENTE
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCliente) {
			itemStateChangedCboCliente(e);
		}
	}
	protected void itemStateChangedCboCliente(ItemEvent e) {
		mostrarCliente();
	}
}
