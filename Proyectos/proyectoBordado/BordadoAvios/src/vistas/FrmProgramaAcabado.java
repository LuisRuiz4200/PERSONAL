package vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import arreglos.ArregloCitiAcabado;
import arreglos.ArregloCitiConfeccion;
import arreglos.ArregloCliente;
import arreglos.ArregloColorOP;
import arreglos.ArregloOrdenProduccion;
import arreglos.ArregloProgramaAcabado;
import clases.CitiAcabado;
import clases.CitiConfeccion;
import clases.Cliente;
import clases.OrdenProduccion;
import clases.ProgramaAcabado;
import reuzables.Custom;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;

import com.toedter.calendar.JDateChooser;

import javax.swing.event.CaretEvent;

@SuppressWarnings("serial")
public class FrmProgramaAcabado extends JInternalFrame implements ActionListener, CaretListener{
	private JPanel panelConfeccion;
	private JPanel panelAcabado;
	private JPanel panelOP;
	public static JTextField txtCodCitiConfeccion;
	private JLabel lblCodCitiConfeccion;
	private JTextField txtDesCitiConfeccion;
	private JLabel lblDesCitiConfeccion;
	public static JTextField txtNroOP;
	private JLabel lblNroOP;
	private JTextField txtClienteOP;
	private JLabel lblClienteOP;
	private JLabel lblColorOP;
	public static JTextField txtCodCitiAcabado;
	private JLabel lblCodCitiAcabado;
	private JTextField txtDesCitiAcabado;
	private JLabel lblDesCitiAcabado;
	public static JButton btnGrabar;
	public static JButton btnEliminar;
	public static JButton btnEditar;
	private JButton btnNuevo;
	private JPanel panelPrograma;
	private JTextField txtCantPedido;
	private JLabel lblCantPedido;
	private JTextField txtCantProgramada;
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
	public static JTextArea txtObsPrograma;
	private JLabel lblObsPrograma;
	public static JTextField txtColorOP;
	public static JTextField txtEstiloOP;
	private JLabel lblEstiloOP;
	public static JTextField txtPrendaOP;
	private JLabel lblPrendaOP;
	public static JTextField txtIdF10;
	
	public static void main (String[] args) {
		FrmProgramaAcabado ventana = new FrmProgramaAcabado();
		ventana.setVisible(true);
	}
	
	public FrmProgramaAcabado() {
		
		this.setTitle("PROGRAMA ACABADO");
		this.setBounds(0,0,702,516);
		//this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		this.setIconifiable(true);
		this.setMaximizable(true);
		this.setClosable(true);
		
		panelConfeccion = new JPanel();
		panelConfeccion.setBounds(10, 213, 319, 89);
		panelConfeccion.setBorder(new TitledBorder("CONFECCION"));
		panelConfeccion.setLayout(null);
		getContentPane().add(panelConfeccion);
		
		txtCodCitiConfeccion = new JTextField();
		txtCodCitiConfeccion.addCaretListener(this);
		txtCodCitiConfeccion.setBounds(10, 45, 86, 20);
		panelConfeccion.add(txtCodCitiConfeccion);
		txtCodCitiConfeccion.setColumns(10);
		
		lblCodCitiConfeccion = new JLabel("CODIGO");
		lblCodCitiConfeccion.setBounds(10, 25, 86, 14);
		panelConfeccion.add(lblCodCitiConfeccion);
		
		txtDesCitiConfeccion = new JTextField();
		txtDesCitiConfeccion.setColumns(10);
		txtDesCitiConfeccion.setBounds(153, 45, 150, 20);
		panelConfeccion.add(txtDesCitiConfeccion);
		
		lblDesCitiConfeccion = new JLabel("DESCRIPCION");
		lblDesCitiConfeccion.setBounds(153, 25, 86, 14);
		panelConfeccion.add(lblDesCitiConfeccion);
		
		btnBuscarCitiConfeccion = new JButton("New button");
		btnBuscarCitiConfeccion.addActionListener(this);
		btnBuscarCitiConfeccion.setBounds(106, 44, 37, 23);
		panelConfeccion.add(btnBuscarCitiConfeccion);
		
		panelAcabado = new JPanel();
		panelAcabado.setBounds(10, 315, 319, 89);
		panelAcabado.setBorder(new TitledBorder("ACABADO"));
		panelAcabado.setLayout(null);
		getContentPane().add(panelAcabado);
		
		txtCodCitiAcabado = new JTextField();
		txtCodCitiAcabado.addCaretListener(this);
		txtCodCitiAcabado.setColumns(10);
		txtCodCitiAcabado.setBounds(10, 43, 86, 20);
		panelAcabado.add(txtCodCitiAcabado);
		
		lblCodCitiAcabado = new JLabel("CODIGO");
		lblCodCitiAcabado.setBounds(10, 23, 86, 14);
		panelAcabado.add(lblCodCitiAcabado);
		
		txtDesCitiAcabado = new JTextField();
		txtDesCitiAcabado.setColumns(10);
		txtDesCitiAcabado.setBounds(153, 43, 150, 20);
		panelAcabado.add(txtDesCitiAcabado);
		
		lblDesCitiAcabado = new JLabel("DESCRIPCION");
		lblDesCitiAcabado.setBounds(153, 23, 86, 14);
		panelAcabado.add(lblDesCitiAcabado);
		
		btnBuscarCitiAcabado = new JButton("New button");
		btnBuscarCitiAcabado.addActionListener(this);
		btnBuscarCitiAcabado.setBounds(106, 42, 37, 23);
		panelAcabado.add(btnBuscarCitiAcabado);
		
		panelOP = new JPanel();
		panelOP.setBounds(10, 72, 662, 130);
		panelOP.setBorder(new TitledBorder("ORDEN PROUDCCION"));
		panelOP.setLayout(null);
		getContentPane().add(panelOP);
		
		txtNroOP = new JTextField();
		txtNroOP.addCaretListener(this);
		txtNroOP.addActionListener(this);
		txtNroOP.setColumns(10);
		txtNroOP.setBounds(10, 44, 86, 20);
		panelOP.add(txtNroOP);
		
		lblNroOP = new JLabel("OP");
		lblNroOP.setBounds(10, 24, 86, 14);
		panelOP.add(lblNroOP);
		
		txtClienteOP = new JTextField();
		txtClienteOP.setColumns(10);
		txtClienteOP.setBounds(163, 44, 130, 20);
		panelOP.add(txtClienteOP);
		
		lblClienteOP = new JLabel("CLIENTE");
		lblClienteOP.setBounds(163, 24, 86, 14);
		panelOP.add(lblClienteOP);
		
		lblColorOP = new JLabel("COLOR");
		lblColorOP.setBounds(338, 24, 86, 14);
		panelOP.add(lblColorOP);
		
		btnBuscarOP = new JButton("New button");
		btnBuscarOP.addActionListener(this);
		btnBuscarOP.setBounds(106, 43, 37, 23);
		panelOP.add(btnBuscarOP);
		
		txtColorOP = new JTextField();
		txtColorOP.setBounds(338, 44, 184, 20);
		panelOP.add(txtColorOP);
		txtColorOP.setColumns(10);
		
		txtEstiloOP = new JTextField();
		txtEstiloOP.setColumns(10);
		txtEstiloOP.setBounds(10, 95, 184, 20);
		panelOP.add(txtEstiloOP);
		
		lblEstiloOP = new JLabel("ESTILO");
		lblEstiloOP.setBounds(10, 75, 86, 14);
		panelOP.add(lblEstiloOP);
		
		txtPrendaOP = new JTextField();
		txtPrendaOP.setColumns(10);
		txtPrendaOP.setBounds(222, 95, 121, 20);
		panelOP.add(txtPrendaOP);
		
		lblPrendaOP = new JLabel("PRENDA");
		lblPrendaOP.setBounds(222, 75, 86, 14);
		panelOP.add(lblPrendaOP);
		
		txtIdF10 = new JTextField();
		txtIdF10.setBounds(584, 99, 68, 20);
		panelOP.add(txtIdF10);
		txtIdF10.setColumns(10);
		
		btnGrabar = new JButton("GRABAR");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(10, 447, 89, 23);
		getContentPane().add(btnGrabar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(219, 447, 89, 23);
		getContentPane().add(btnEliminar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(109, 447, 89, 23);
		getContentPane().add(btnEditar);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(318, 447, 89, 23);
		getContentPane().add(btnNuevo);
		
		panelPrograma = new JPanel();
		panelPrograma.setBounds(339, 221, 256, 170);
		getContentPane().add(panelPrograma);
		panelPrograma.setLayout(null);
		
		txtCantPedido = new JTextField();
		txtCantPedido.setColumns(10);
		txtCantPedido.setBounds(10, 31, 86, 20);
		panelPrograma.add(txtCantPedido);
		
		lblCantPedido = new JLabel("PEDIDO");
		lblCantPedido.setBounds(10, 11, 86, 14);
		panelPrograma.add(lblCantPedido);
		
		txtCantProgramada = new JTextField();
		txtCantProgramada.setColumns(10);
		txtCantProgramada.setBounds(106, 31, 86, 20);
		panelPrograma.add(txtCantProgramada);
		
		lblCantPrograma = new JLabel("PROGRAMA");
		lblCantPrograma.setBounds(106, 11, 86, 14);
		panelPrograma.add(lblCantPrograma);
		
		txtObsPrograma = new JTextArea();
		txtObsPrograma.setBounds(10, 100, 198, 59);
		txtObsPrograma.setLineWrap(true);
		txtObsPrograma.setBorder(new EmptyBorder(4,4,4,4));
		panelPrograma.add(txtObsPrograma);
		
		lblObsPrograma = new JLabel("OBSERVACION");
		lblObsPrograma.setBounds(10, 75, 86, 14);
		panelPrograma.add(lblObsPrograma);
		
		btnLista = new JButton("LISTA");
		btnLista.addActionListener(this);
		btnLista.setBounds(417, 447, 89, 23);
		getContentPane().add(btnLista);
		
		txtFechaActualizada = new JDateChooser();
		txtFechaActualizada.setBounds(431, 31, 118, 20);
		getContentPane().add(txtFechaActualizada);
		
		lblFechaActualizada = new JLabel("ACTUALIZACION");
		lblFechaActualizada.setBounds(431, 11, 100, 14);
		getContentPane().add(lblFechaActualizada);
		
		txtEstadoPrograma = new JTextField();
		txtEstadoPrograma.setBounds(586, 31, 86, 20);
		getContentPane().add(txtEstadoPrograma);
		txtEstadoPrograma.setColumns(10);
		
		lblEstadoPrograma = new JLabel("ESTADO");
		lblEstadoPrograma.setBounds(586, 11, 86, 14);
		getContentPane().add(lblEstadoPrograma);
		
		lblCodPrograma = new JLabel("ID PROGRAMA");
		lblCodPrograma.setBounds(13, 11, 86, 14);
		getContentPane().add(lblCodPrograma);
		
		txtCodPrograma = new JTextField();
		txtCodPrograma.addCaretListener(this);
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
		FrmConsultaProgramaAcabado frame = new FrmConsultaProgramaAcabado();
		this.dispose();
		frame.setVisible(true);
		frame.setLocation(40,40);
		frame.toFront();
		FrmPrincipal.escritorio.add(frame);
		
	}
	protected void actionPerformedBtnBuscarOP(ActionEvent e) {

		DlgListaF10.frame = "FrmProgramaAcabado";
		DlgListaF10 buscarOP = new DlgListaF10 ();
		buscarOP.setVisible(true);
	}

	protected void actionPerformedBtnBuscarCitiConfeccion(ActionEvent e) {
		
		DlgBuscarCitiConfeccion.frame = "FrmProgramaAcabado";
		DlgBuscarCitiConfeccion dlg = new DlgBuscarCitiConfeccion(new FrmPrincipal(),true);
		dlg.setVisible(true);
	}

	protected void actionPerformedBtnBuscarCitiAcabado(ActionEvent e) {
		
		DlgBuscarCitiAcabado.frame = "FrmProgramaAcabado";
		DlgBuscarCitiAcabado dlg = new DlgBuscarCitiAcabado(new FrmPrincipal(),true);
		dlg.setVisible(true);
	}
	//CARET CHANGED PARA TXT NRO_OP, COD_CITIS
	public void caretUpdate(CaretEvent e) {
		if (e.getSource() == txtCodCitiAcabado) {
			caretUpdateTxtCodCitiAcabado(e);
		}
		if (e.getSource() == txtCodCitiConfeccion) {
			caretUpdateTxtCodCitiConfeccion(e);
		}
		if (e.getSource() == txtCodPrograma) {
			caretUpdateTxtCodPrograma(e);
		}
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

	protected void caretUpdateTxtCodPrograma(CaretEvent e) {
		try {
			mostrarPrograma();
		}catch(Exception ex) {
			
		}
	}
	

	protected void caretUpdateTxtCodCitiConfeccion(CaretEvent e) {
		try {
			mostrarCitiConfeccion();
		}catch(Exception ex) {
			
		}
	}
	
	protected void caretUpdateTxtCodCitiAcabado(CaretEvent e) {
		try {
			mostratCitiAcabado();
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
		
		if(txtCantProgramada.getText().trim().length()==0) {
			res = 0;
		}else {
			res = Integer.parseInt(this.txtCantProgramada.getText().trim());
		}
		
		return res;
	}	
	
	private int leerCantPedido() {
		int res = -1;
		
		if(txtCantPedido.getText().trim().length()==0) {
			res = 0;
		}else {
			res = Integer.parseInt(this.txtCantPedido.getText().trim());
		}
		
		
		return res;
	}
	
	private String leerColorOP () {
		String res = null;
		
		res = txtColorOP.getText().trim();
		
		return res;
	}
	
	private String leerObservacion () {
		String res = "NINGUNA";
		
		res = FrmProgramaAcabado.txtObsPrograma.getText();
		
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
		
		res = FrmProgramaAcabado.txtCodCitiConfeccion.getText().trim();
		
		return res;
	}
	
	private String leerCitiAcabado() {
		String res = null;
		
		res = FrmProgramaAcabado.txtCodCitiAcabado.getText().trim();
		
		return res;
	}
	
	
	//METODOS VOID
	private void arranque() {
		limpiar();
	}
	private void limpiar() {
		
		FrmProgramaAcabado.txtCodPrograma.setText(arrProgramaAcabado.correlativo()+"");
		FrmProgramaAcabado.txtNroOP.setText("");
		FrmProgramaAcabado.txtNroOP.requestFocus();
		FrmProgramaAcabado.txtCodCitiAcabado.setText("");
		FrmProgramaAcabado.txtCodCitiConfeccion.setText("");
		FrmProgramaAcabado.txtColorOP.setText("");
		FrmProgramaAcabado.txtEstiloOP.setText("");
		FrmProgramaAcabado.txtPrendaOP.setText("");
		FrmProgramaAcabado.txtIdF10.setText("");
		
		this.txtCantPedido.setText("");
		this.txtCantProgramada.setText("");
		this.txtClienteOP.setText("");
		this.txtDesCitiConfeccion.setText("");
		this.txtDesCitiAcabado.setText("");
		this.txtEstadoPrograma.setText("REGISTRADO");
		this.txtFechaActualizada.setDate(new Date());
		

		this.txtDesCitiAcabado.setEditable(false);
		this.txtFechaActualizada.setEnabled(false);
		this.txtDesCitiConfeccion.setEditable(false);
		this.txtEstadoPrograma.setEditable(false);
		this.txtClienteOP.setEditable(false);
		FrmProgramaAcabado.txtNroOP.setEditable(false);
		FrmProgramaAcabado.txtEstiloOP.setEditable(false);
		FrmProgramaAcabado.txtColorOP.setEditable(false);
		FrmProgramaAcabado.txtPrendaOP.setEditable(false);
		FrmProgramaAcabado.txtIdF10.setEditable(false);
		FrmProgramaAcabado.txtCodCitiConfeccion.setEditable(false);
		FrmProgramaAcabado.txtCodCitiAcabado.setEditable(false);		
		FrmProgramaAcabado.txtCodPrograma.setEditable(false);

		
		btnEditar.setEnabled(false);
		btnGrabar.setEnabled(true);
		btnEliminar.setEnabled(false);
		
	}
	
	
	private void adicionar() {
		
		int codPrograma = leerCodPrograma();
		int nroOP = leerNroOP();
		String codColorOP = leerColorOP();
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
		
		if (codPrograma==-1 || nroOP==-1 || codColorOP==null || cantPedido==-1 || cantPrograma==-1 || citiConfeccion==null ||
				 citiAcabado==null || observacion==null || fechaActualizada==null || estado==null) {
			JOptionPane.showMessageDialog(this,"VUELVA A INTENTARLO","MENSAJE",0);
			return;
		}else {
			arrProgramaAcabado.adicionar(obj);
			arrProgramaAcabado.grabarProgramaAcabado();
			Custom.mensajeExito(this, "En hora buena, operacion exitosa");
			limpiar();
		}
	}
	
	private void editar() {

		int codPrograma = leerCodPrograma();
		int nroOP = leerNroOP();
		String codColorOP = leerColorOP();
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
		
		if (codPrograma==-1 || nroOP==-1 || codColorOP==null || cantPedido==-1 || cantPrograma==-1 || citiConfeccion==null ||
				 citiAcabado==null || observacion==null || fechaActualizada==null || estado==null) {
			JOptionPane.showMessageDialog(this,"VUELVA A INTENTARLO","MENSAJE",0);
			return;
		}else {
			arrProgramaAcabado.editar(obj);
			arrProgramaAcabado.grabarProgramaAcabado();
			Custom.mensajeExito(this, "En hora buena, operacion exitosa");
			limpiar();
		}
	}
	
	private void eliminar() {
		int codPrograma = leerCodPrograma();
		int nroOP = leerNroOP();
		String codColorOP = leerColorOP();
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
		
	}

	
	private void mostrarPrograma() {
		ProgramaAcabado obj = arrProgramaAcabado.buscar(leerCodPrograma());
		txtNroOP.setText(obj.getNro_OP()+"");
		txtColorOP.setText(obj.getCod_colorOP());
		txtCodCitiConfeccion.setText(obj.getCod_citiConfeccion());
		txtCodCitiAcabado.setText(obj.getCod_citiAcabado());
		txtCantPedido.setText(obj.getCantPed_programaAcabado()+"");
		txtCantProgramada.setText(obj.getCantProg_programaAcabado()+"");
		txtFechaActualizada.setDate(obj.getFechaAct_programaAcabado());
		txtEstadoPrograma.setText(obj.getEstado_programaAcabado());
		txtObsPrograma.setText(obj.getObs_programaAcabado());
	}
	private void mostrarCitiConfeccion() {
		ArregloCitiConfeccion arrCitiConfeccion = new ArregloCitiConfeccion();
		CitiConfeccion obj=arrCitiConfeccion.buscar(leerCitiConfeccion());
		
		txtDesCitiConfeccion.setText(obj.getDes_citiConfeccion());
		
	}
	private void mostratCitiAcabado() {
		ArregloCitiAcabado arrCitiAcabado = new ArregloCitiAcabado();
		CitiAcabado obj = arrCitiAcabado.buscar(leerCitiAcabado());
		
		
		txtDesCitiAcabado.setText(obj.getDes_citiAcabado());
	}
	
	
}
