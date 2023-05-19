package vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import arreglos.ArregloCliente;
import arreglos.ArregloColorOP;
import arreglos.ArregloOrdenProduccion;
import arreglos.ArregloProgramaAcabado;
import clases.Cliente;
import clases.OrdenProduccion;
import clases.ProgramaAcabado;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;

import com.toedter.calendar.JDateChooser;

import javax.swing.event.CaretEvent;

@SuppressWarnings("serial")
public class FrmProgramaAcabado extends JFrame implements ActionListener, CaretListener{
	private JPanel panelCitiConfeccion;
	private JPanel panelCitiAcabado;
	private JPanel panelOP;
	private JTextField txtCodCitiConfeccion;
	private JLabel lblCodCitiConfeccion;
	private JTextField txtDesCitiConfeccion;
	private JLabel lblDesCitiConfeccion;
	public static JTextField txtNroOP;
	private JLabel lblNroOP;
	private JTextField txtClienteOP;
	private JLabel lblClienteOP;
	private JComboBox<Object> cboColorOP;
	private JLabel lblColorOP;
	private JTextField txtEstadoCitiConfeccion;
	private JLabel lblEstadoCitiConfeccion;
	private JTextField txtCodCitiAcabado;
	private JLabel lblCodCitiAcabado;
	private JTextField txtDesCitiAcabado;
	private JLabel lblDesCitiAcabado;
	private JTextField txtEstadoCitiAcabado;
	private JLabel lblEstadoCitiAcabado;
	private JButton btnGrabar;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnNuevo;
	private JPanel panelPrograma;
	private JTextField txtCantPedido;
	private JLabel lblCantPedido;
	private JTextField txtCantPrograma;
	private JLabel lblCantPrograma;
	private JButton btnLista;
	private JDateChooser txtFechaActualizada;
	private JLabel lblFechaActualizada;
	private JTextField txtEstadoPrograma;
	private JLabel lblEstadoPrograma;
	private JButton btnBuscarOP;
	private JButton btnBuscarCitiConfeccion;
	private JButton btnBuscarCitiAcabado;
	private JLabel lblCodPrograma;
	public static JTextField txtCodPrograma;
	
	private ArregloProgramaAcabado arrProgramaAcabado = new ArregloProgramaAcabado();
	private JTextArea txtObsPrograma;
	private JLabel lblObsPrograma;
	
	public static void main (String[] args) {
		FrmProgramaAcabado ventana = new FrmProgramaAcabado();
		ventana.setVisible(true);
	}
	
	public FrmProgramaAcabado() {
		
		this.setTitle("PROGRAMA ACABADO");
		this.setBounds(0,0,706,509);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		panelCitiConfeccion = new JPanel();
		panelCitiConfeccion.setBounds(20, 183, 409, 89);
		panelCitiConfeccion.setBorder(new TitledBorder("CITI CONFECCION"));
		panelCitiConfeccion.setLayout(null);
		getContentPane().add(panelCitiConfeccion);
		
		txtCodCitiConfeccion = new JTextField();
		txtCodCitiConfeccion.setBounds(10, 45, 86, 20);
		panelCitiConfeccion.add(txtCodCitiConfeccion);
		txtCodCitiConfeccion.setColumns(10);
		
		lblCodCitiConfeccion = new JLabel("CODIGO");
		lblCodCitiConfeccion.setBounds(10, 25, 86, 14);
		panelCitiConfeccion.add(lblCodCitiConfeccion);
		
		txtDesCitiConfeccion = new JTextField();
		txtDesCitiConfeccion.setColumns(10);
		txtDesCitiConfeccion.setBounds(153, 45, 150, 20);
		panelCitiConfeccion.add(txtDesCitiConfeccion);
		
		lblDesCitiConfeccion = new JLabel("DESCRIPCION");
		lblDesCitiConfeccion.setBounds(153, 25, 86, 14);
		panelCitiConfeccion.add(lblDesCitiConfeccion);
		
		txtEstadoCitiConfeccion = new JTextField();
		txtEstadoCitiConfeccion.setColumns(10);
		txtEstadoCitiConfeccion.setBounds(313, 45, 86, 20);
		panelCitiConfeccion.add(txtEstadoCitiConfeccion);
		
		lblEstadoCitiConfeccion = new JLabel("ESTADO");
		lblEstadoCitiConfeccion.setBounds(313, 25, 86, 14);
		panelCitiConfeccion.add(lblEstadoCitiConfeccion);
		
		btnBuscarCitiConfeccion = new JButton("New button");
		btnBuscarCitiConfeccion.addActionListener(this);
		btnBuscarCitiConfeccion.setBounds(106, 44, 37, 23);
		panelCitiConfeccion.add(btnBuscarCitiConfeccion);
		
		panelCitiAcabado = new JPanel();
		panelCitiAcabado.setBounds(20, 283, 409, 89);
		panelCitiAcabado.setBorder(new TitledBorder("CITI ACABADO"));
		panelCitiAcabado.setLayout(null);
		getContentPane().add(panelCitiAcabado);
		
		txtCodCitiAcabado = new JTextField();
		txtCodCitiAcabado.setColumns(10);
		txtCodCitiAcabado.setBounds(10, 55, 86, 20);
		panelCitiAcabado.add(txtCodCitiAcabado);
		
		lblCodCitiAcabado = new JLabel("CODIGO");
		lblCodCitiAcabado.setBounds(10, 35, 86, 14);
		panelCitiAcabado.add(lblCodCitiAcabado);
		
		txtDesCitiAcabado = new JTextField();
		txtDesCitiAcabado.setColumns(10);
		txtDesCitiAcabado.setBounds(153, 55, 150, 20);
		panelCitiAcabado.add(txtDesCitiAcabado);
		
		lblDesCitiAcabado = new JLabel("DESCRIPCION");
		lblDesCitiAcabado.setBounds(153, 35, 86, 14);
		panelCitiAcabado.add(lblDesCitiAcabado);
		
		txtEstadoCitiAcabado = new JTextField();
		txtEstadoCitiAcabado.setColumns(10);
		txtEstadoCitiAcabado.setBounds(313, 55, 86, 20);
		panelCitiAcabado.add(txtEstadoCitiAcabado);
		
		lblEstadoCitiAcabado = new JLabel("ESTADO");
		lblEstadoCitiAcabado.setBounds(313, 35, 86, 14);
		panelCitiAcabado.add(lblEstadoCitiAcabado);
		
		btnBuscarCitiAcabado = new JButton("New button");
		btnBuscarCitiAcabado.addActionListener(this);
		btnBuscarCitiAcabado.setBounds(106, 54, 37, 23);
		panelCitiAcabado.add(btnBuscarCitiAcabado);
		
		panelOP = new JPanel();
		panelOP.setBounds(22, 72, 407, 100);
		panelOP.setBorder(new TitledBorder("ORDEN PROUDCCION"));
		panelOP.setLayout(null);
		getContentPane().add(panelOP);
		
		txtNroOP = new JTextField();
		txtNroOP.addCaretListener(this);
		txtNroOP.addActionListener(this);
		txtNroOP.setColumns(10);
		txtNroOP.setBounds(10, 53, 86, 20);
		panelOP.add(txtNroOP);
		
		lblNroOP = new JLabel("OP");
		lblNroOP.setBounds(10, 33, 86, 14);
		panelOP.add(lblNroOP);
		
		txtClienteOP = new JTextField();
		txtClienteOP.setColumns(10);
		txtClienteOP.setBounds(163, 53, 102, 20);
		panelOP.add(txtClienteOP);
		
		lblClienteOP = new JLabel("CLIENTE");
		lblClienteOP.setBounds(163, 33, 86, 14);
		panelOP.add(lblClienteOP);
		
		cboColorOP = new JComboBox<Object>();
		cboColorOP.setBounds(275, 53, 122, 20);
		panelOP.add(cboColorOP);
		
		lblColorOP = new JLabel("COLOR");
		lblColorOP.setBounds(275, 33, 86, 14);
		panelOP.add(lblColorOP);
		
		btnBuscarOP = new JButton("New button");
		btnBuscarOP.addActionListener(this);
		btnBuscarOP.setBounds(106, 52, 37, 23);
		panelOP.add(btnBuscarOP);
		
		btnGrabar = new JButton("GRABAR");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(10, 416, 89, 23);
		getContentPane().add(btnGrabar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(219, 416, 89, 23);
		getContentPane().add(btnEliminar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(109, 416, 89, 23);
		getContentPane().add(btnEditar);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(318, 416, 89, 23);
		getContentPane().add(btnNuevo);
		
		panelPrograma = new JPanel();
		panelPrograma.setBounds(439, 72, 241, 233);
		getContentPane().add(panelPrograma);
		panelPrograma.setLayout(null);
		
		txtCantPedido = new JTextField();
		txtCantPedido.setColumns(10);
		txtCantPedido.setBounds(10, 53, 86, 20);
		panelPrograma.add(txtCantPedido);
		
		lblCantPedido = new JLabel("PEDIDO");
		lblCantPedido.setBounds(10, 33, 86, 14);
		panelPrograma.add(lblCantPedido);
		
		txtCantPrograma = new JTextField();
		txtCantPrograma.setColumns(10);
		txtCantPrograma.setBounds(106, 53, 86, 20);
		panelPrograma.add(txtCantPrograma);
		
		lblCantPrograma = new JLabel("PROGRAMA");
		lblCantPrograma.setBounds(106, 33, 86, 14);
		panelPrograma.add(lblCantPrograma);
		
		txtObsPrograma = new JTextArea();
		txtObsPrograma.setBounds(10, 105, 221, 117);
		txtObsPrograma.setLineWrap(true);
		txtObsPrograma.setBorder(new EmptyBorder(4,4,4,4));
		panelPrograma.add(txtObsPrograma);
		
		lblObsPrograma = new JLabel("OBSERVACION");
		lblObsPrograma.setBounds(10, 80, 86, 14);
		panelPrograma.add(lblObsPrograma);
		
		btnLista = new JButton("LISTA");
		btnLista.addActionListener(this);
		btnLista.setBounds(417, 416, 89, 23);
		getContentPane().add(btnLista);
		
		txtFechaActualizada = new JDateChooser();
		txtFechaActualizada.setBounds(439, 31, 118, 20);
		getContentPane().add(txtFechaActualizada);
		
		lblFechaActualizada = new JLabel("ACTUALIZACION");
		lblFechaActualizada.setBounds(439, 11, 100, 14);
		getContentPane().add(lblFechaActualizada);
		
		txtEstadoPrograma = new JTextField();
		txtEstadoPrograma.setBounds(594, 31, 86, 20);
		getContentPane().add(txtEstadoPrograma);
		txtEstadoPrograma.setColumns(10);
		
		lblEstadoPrograma = new JLabel("ESTADO");
		lblEstadoPrograma.setBounds(594, 11, 86, 14);
		getContentPane().add(lblEstadoPrograma);
		
		lblCodPrograma = new JLabel("ID PROGRAMA");
		lblCodPrograma.setBounds(13, 11, 86, 14);
		getContentPane().add(lblCodPrograma);
		
		txtCodPrograma = new JTextField();
		txtCodPrograma.setColumns(10);
		txtCodPrograma.setBounds(13, 31, 86, 20);
		getContentPane().add(txtCodPrograma);
		
		arranque();
	}
	
	// ACTION PERFORMED DE LOS BOTONES
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarCitiAcabado) {
			actionPerformedBtnBuscarCitiAcabado(e);
		}
		if (e.getSource() == btnBuscarCitiConfeccion) {
			actionPerformedBtnBuscarCitiConfeccion(e);
		}
		if (e.getSource() == btnBuscarOP) {
			actionPerformedBtnBuscarOP(e);
		}
		if (e.getSource() == btnLista) {
			actionPerformedBtnLista(e);
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
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
	}
	protected void actionPerformedBtnGrabar(ActionEvent e) {
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
	protected void actionPerformedBtnLista(ActionEvent e) {
		FrmConsultaProgramaAcabado consultaProgramaAcabado = new FrmConsultaProgramaAcabado();
		consultaProgramaAcabado.setVisible(true);
	}
	protected void actionPerformedBtnBuscarOP(ActionEvent e) {

		DlgBuscarOP.frame = "FrmProgramaAcabado";
		DlgBuscarOP buscarOP = new DlgBuscarOP (this,true);
		buscarOP.setVisible(true);
	}

	protected void actionPerformedBtnBuscarCitiConfeccion(ActionEvent e) {
	}

	protected void actionPerformedBtnBuscarCitiAcabado(ActionEvent e) {
	}
	//CARET CHANGED PARA TXT NRO_OP
	public void caretUpdate(CaretEvent e) {
		if (e.getSource() == txtNroOP) {
			caretUpdateTxtNroOP(e);
		}
	}
	protected void caretUpdateTxtNroOP(CaretEvent e) {
		try {
			cargarOP();
		}catch(Exception ex) {
			
		}
	}
	//METODOS GET
	
	private int leerCodPrograma() {
		int res = -1;
		
		res = Integer.parseInt(txtCodPrograma.getText().trim());
		
		return res;
	}
	
	private int leerNroOP() {
		int res = -1;
		
		res = Integer.parseInt(txtNroOP.getText().trim());
		
		return res;
	}
	
	private int leerCantPrograma() {
		int res = -1;
		
		res = Integer.parseInt(this.txtCantPrograma.getText().trim());
		
		return res;
	}	
	
	private int leerCantPedido() {
		int res = -1;
		
		res = Integer.parseInt(this.txtCantPedido.getText().trim());
		
		return res;
	}
	
	private int leerColorOP () {
		int res = -1;
		
		if(cboColorOP.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(this, "ELIGA UN COLOR");
		}else {
			res = this.cboColorOP.getSelectedIndex();
		}
		
		
		return res;
	}
	
	private String leerObservacion () {
		String res = "NINGUNA";
		
		res = this.txtObsPrograma.getText();
		
		return res ;
	}
	
	private String leerEstadoPrograma() {
		String res = null;
		
		res = this.txtEstadoPrograma.getText().trim();
		
		return res;
	}
	
	private Date leerFechaActualizada() {
		Date res = null;
		
		res = this.txtFechaActualizada.getDate();
		
		return res;
	}
	
	private String leerCitiConfeccion() {
		String res = null;
		
		res = this.txtCodCitiConfeccion.getText().trim();
		
		return res;
	}
	
	private String leerCitiAcabado() {
		String res = null;
		
		res = this.txtCodCitiAcabado.getText().trim();
		
		return res;
	}
	
	
	//METODOS VOID
	private void arranque() {
		limpiar();
	}
	private void limpiar() {
		
		FrmProgramaAcabado.txtCodPrograma.setText(arrProgramaAcabado.correlativo()+"");
		FrmProgramaAcabado.txtCodPrograma.setEditable(false);
		FrmProgramaAcabado.txtNroOP.setText("");
		FrmProgramaAcabado.txtNroOP.requestFocus();
		this.txtCantPedido.setText("");
		this.txtCantPrograma.setText("");
		this.txtClienteOP.setText("");
		this.txtClienteOP.setEditable(false);
		this.txtCodCitiAcabado.setText("");
		this.txtCodCitiConfeccion.setText("");
		this.cboColorOP.setSelectedIndex(-1);
		this.txtDesCitiConfeccion.setText("");
		this.txtDesCitiConfeccion.setEditable(false);
		this.txtDesCitiAcabado.setText("");
		this.txtDesCitiAcabado.setEditable(false);
		this.txtEstadoCitiConfeccion.setText("");
		this.txtEstadoCitiConfeccion.setEditable(false);
		this.txtEstadoCitiAcabado.setText("");
		this.txtEstadoCitiAcabado.setEditable(false);
		this.txtEstadoPrograma.setText("REGISTRADO");
		this.txtEstadoPrograma.setEditable(false);
		this.txtFechaActualizada.setDate(new Date());
		this.txtFechaActualizada.setEnabled(false);
		
	}
	
	
	private void adicionar() {
		
		int codPrograma = leerCodPrograma();
		int nroOP = leerNroOP();
		int codColorOP = leerColorOP();
		int cantPedido = leerCantPedido();
		int cantPrograma = leerCantPrograma();
		String citiConfeccion = leerCitiConfeccion();
		String citiAcabado = leerCitiAcabado();
		String observacion = leerObservacion();
		Date fechaActualizada = leerFechaActualizada();
		String estado = leerEstadoPrograma();
		
		ProgramaAcabado obj = new ProgramaAcabado();
		
		obj.setCod_programaAcabado(codPrograma);
		obj.setNro_OP(nroOP);
		obj.setCod_colorOP(codColorOP);
		obj.setCantPed_programaAcabado(cantPedido);
		obj.setCantProg_programaAcabado(cantPrograma);
		obj.setCod_citiConfeccion(citiConfeccion);
		obj.setCod_citiAcabado(citiAcabado);
		obj.setObs_programaAcabado(observacion);
		obj.setFechaAct_programaAcabado(fechaActualizada);
		obj.setEstado_programaAcabado(estado);
		
		arrProgramaAcabado.adicionar(obj);
		arrProgramaAcabado.grabarProgramaAcabado();
		limpiar();
		
		
	}
	
	private void editar() {

		int codPrograma = leerCodPrograma();
		int nroOP = leerNroOP();
		int codColorOP = leerColorOP();
		int cantPedido = leerCantPedido();
		int cantPrograma = leerCantPrograma();
		String citiConfeccion = leerCitiConfeccion();
		String citiAcabado = leerCitiAcabado();
		String observacion = leerObservacion();
		Date fechaActualizada = leerFechaActualizada();
		String estado = leerEstadoPrograma();
		
		ProgramaAcabado obj = new ProgramaAcabado();
		
		obj.setCod_programaAcabado(codPrograma);
		obj.setNro_OP(nroOP);
		obj.setCod_colorOP(codColorOP);
		obj.setCantPed_programaAcabado(cantPedido);
		obj.setCantProg_programaAcabado(cantPrograma);
		obj.setCod_citiConfeccion(citiConfeccion);
		obj.setCod_citiAcabado(citiAcabado);
		obj.setObs_programaAcabado(observacion);
		obj.setFechaAct_programaAcabado(fechaActualizada);
		obj.setEstado_programaAcabado(estado);
		
		arrProgramaAcabado.editar(obj);
		arrProgramaAcabado.grabarProgramaAcabado();
	}
	
	private void eliminar() {
		int codPrograma = leerCodPrograma();
		int nroOP = leerNroOP();
		int codColorOP = leerColorOP();
		int cantPedido = leerCantPedido();
		int cantPrograma = leerCantPrograma();
		String citiConfeccion = leerCitiConfeccion();
		String citiAcabado = leerCitiAcabado();
		String observacion = leerObservacion();
		Date fechaActualizada = leerFechaActualizada();
		String estado = leerEstadoPrograma();
		
		ProgramaAcabado obj = new ProgramaAcabado();
		
		obj.setCod_programaAcabado(codPrograma);
		obj.setNro_OP(nroOP);
		obj.setCod_colorOP(codColorOP);
		obj.setCantPed_programaAcabado(cantPedido);
		obj.setCantProg_programaAcabado(cantPrograma);
		obj.setCod_citiConfeccion(citiConfeccion);
		obj.setCod_citiAcabado(citiAcabado);
		obj.setObs_programaAcabado(observacion);
		obj.setFechaAct_programaAcabado(fechaActualizada);
		obj.setEstado_programaAcabado(estado);
		
		arrProgramaAcabado.editar(obj);
		arrProgramaAcabado.grabarProgramaAcabado();
	}
	
	private void cargarOP(){
		
		ArregloOrdenProduccion arrOP = new ArregloOrdenProduccion() ;
		OrdenProduccion OP = arrOP.buscar(leerNroOP());

		ArregloCliente arrCliente = new ArregloCliente();
		Cliente cliente = arrCliente.buscar(OP.getCodCliente());
		
		
		txtClienteOP.setText(cliente.getDesCliente());
		cargarColor();
		
	}
	
	private void cargarColor() {

		ArregloColorOP arrColorOP = new ArregloColorOP();
		
		cboColorOP.removeAllItems();
		cboColorOP.addItem("ELIGE COLOR");
		
		for (int i =0;i<arrColorOP.tamaño();i++) {
			if (arrColorOP.obtener(i).getNroOP()==leerNroOP()) {
				cboColorOP.addItem(arrColorOP.obtener(i).getDesColorOP());
			}
		}
		
	}
	
	
}
