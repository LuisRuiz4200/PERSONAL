package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import arreglos.ArregloF10;
import arreglos.ArregloPrioridad;
import clases.F10;
import clases.Prioridad;
import reuzables.Custom;

@SuppressWarnings("serial")
public class FrmPrioridad extends JInternalFrame implements ActionListener,CaretListener{
	private JPanel panelOP;
	private JPanel panelPrioridad;
	public static JButton btnAgregar;
	public static JButton btnEditar;
	public static JButton btnEliminar;
	public static JButton btnNuevo;
	private JButton btnLista;
	public static JTextField txtIdPrioridad;
	private JLabel lblIdPrioridad;
	private JTextField txtFechaRegPrioridad;
	private JLabel lblFechaRegPrioridad;
	private JTextField txtEstadoPrioridad;
	private JLabel lblEstadoPrioridad;
	public static JTextField txtNroOP;
	private JLabel lblNroOP;
	private JTextField txtClienteOP;
	private JLabel lblClienteOP;
	public static JTextField txtColorOP;
	private JLabel lblColorOP;
	private JTextField txtEstiloOP;
	private JLabel lblEstiloOP;
	private JTextField txtPrendaOP;
	private JLabel lblPrendaOP;
	private JLabel lblDescripcion;
	private JEditorPane txtDescripcion;
	private JEditorPane txtObservacion;
	private JLabel lblObservacion;
	private JScrollPane spDescripcion;
	private JScrollPane spObservacion;
	private JTextField txtOrdenPrioridad;
	private JLabel lblOrdenPrioridad;
	
	private ArregloPrioridad arrPrioridad = new ArregloPrioridad();
	private JButton btnBuscarOP;
	public static JTextField txtIdF10;
	
	public static void main (String[] args) {
		FrmPrioridad ventana = new FrmPrioridad();
		ventana.setVisible(true);
	}
	
	public FrmPrioridad() {
		
		this.setTitle("PRIORIDADES");
		this.setBounds(0,0,526,502);
		//this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		this.setLocation(40,40);
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
		
		panelOP = new JPanel();
		panelOP.setBounds(10, 59, 490, 97);
		getContentPane().add(panelOP);
		panelOP.setLayout(null);
		
		txtNroOP = new JTextField();
		txtNroOP.setColumns(10);
		txtNroOP.setBounds(10, 24, 86, 20);
		txtNroOP.addCaretListener(this);
		panelOP.add(txtNroOP);
		
		lblNroOP = new JLabel("NRO OP");
		lblNroOP.setBounds(10, 11, 86, 14);
		panelOP.add(lblNroOP);
		
		txtClienteOP = new JTextField();
		txtClienteOP.setColumns(10);
		txtClienteOP.setBounds(154, 24, 86, 20);
		panelOP.add(txtClienteOP);
		
		lblClienteOP = new JLabel("CLIENTE");
		lblClienteOP.setBounds(154, 11, 86, 14);
		panelOP.add(lblClienteOP);
		
		txtColorOP = new JTextField();
		txtColorOP.setColumns(10);
		txtColorOP.setBounds(267, 24, 180, 20);
		panelOP.add(txtColorOP);
		
		lblColorOP = new JLabel("COLOR");
		lblColorOP.setBounds(267, 11, 86, 14);
		panelOP.add(lblColorOP);
		
		txtEstiloOP = new JTextField();
		txtEstiloOP.setColumns(10);
		txtEstiloOP.setBounds(10, 68, 195, 20);
		panelOP.add(txtEstiloOP);
		
		lblEstiloOP = new JLabel("ESTILO");
		lblEstiloOP.setBounds(10, 55, 86, 14);
		panelOP.add(lblEstiloOP);
		
		txtPrendaOP = new JTextField();
		txtPrendaOP.setColumns(10);
		txtPrendaOP.setBounds(236, 68, 86, 20);
		panelOP.add(txtPrendaOP);
		
		lblPrendaOP = new JLabel("PRENDA");
		lblPrendaOP.setBounds(236, 55, 86, 14);
		panelOP.add(lblPrendaOP);
		
		btnBuscarOP = new JButton("...");
		btnBuscarOP.setBounds(106, 23, 39, 23);
		btnBuscarOP.addActionListener(this);
		panelOP.add(btnBuscarOP);
		
		txtIdF10 = new JTextField();
		txtIdF10.setBounds(421, 68, 59, 20);
		panelOP.add(txtIdF10);
		txtIdF10.setColumns(10);
		
		panelPrioridad = new JPanel();
		panelPrioridad.setBounds(10, 167, 490, 252);
		getContentPane().add(panelPrioridad);
		panelPrioridad.setLayout(null);
		
		lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setBounds(10, 67, 86, 14);
		panelPrioridad.add(lblDescripcion);
		
		spDescripcion = new JScrollPane();
		spDescripcion.setBounds(10, 82, 215, 159);
		panelPrioridad.add(spDescripcion);
		
		txtDescripcion = new JEditorPane();
		//txtDescripcion.setLineWrap(true);
		spDescripcion.setViewportView(txtDescripcion);
		
		spObservacion = new JScrollPane();
		spObservacion.setBounds(265, 82, 215, 159);
		panelPrioridad.add(spObservacion);
		
		txtObservacion = new JEditorPane();
		//txtObservacion.setLineWrap(true);
		spObservacion.setViewportView(txtObservacion);
		
		lblObservacion = new JLabel("OBSERVACION");
		lblObservacion.setBounds(265, 67, 86, 14);
		panelPrioridad.add(lblObservacion);
		
		txtOrdenPrioridad = new JTextField();
		txtOrdenPrioridad.setColumns(10);
		txtOrdenPrioridad.setBounds(10, 36, 86, 20);
		panelPrioridad.add(txtOrdenPrioridad);
		
		lblOrdenPrioridad = new JLabel("ORDEN");
		lblOrdenPrioridad.setBounds(10, 23, 86, 14);
		panelPrioridad.add(lblOrdenPrioridad);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(10, 430, 89, 23);
		btnAgregar.addActionListener(this);
		getContentPane().add(btnAgregar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(109, 430, 89, 23);
		btnEditar.addActionListener(this);
		getContentPane().add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(208, 430, 89, 23);
		btnEliminar.addActionListener(this);
		getContentPane().add(btnEliminar);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(309, 430, 89, 23);
		btnNuevo.addActionListener(this);
		getContentPane().add(btnNuevo);
		
		btnLista = new JButton("LISTA");
		btnLista.setBounds(408, 430, 89, 23);
		btnLista.addActionListener(this);
		getContentPane().add(btnLista);
		
		txtIdPrioridad = new JTextField();
		txtIdPrioridad.setBounds(10, 24, 86, 20);
		txtIdPrioridad.addCaretListener(this);
		getContentPane().add(txtIdPrioridad);
		txtIdPrioridad.setColumns(10);
		
		lblIdPrioridad = new JLabel("PRIORIDAD");
		lblIdPrioridad.setBounds(10, 11, 86, 14);
		getContentPane().add(lblIdPrioridad);
		
		txtFechaRegPrioridad = new JTextField();
		txtFechaRegPrioridad.setColumns(10);
		txtFechaRegPrioridad.setBounds(297, 24, 86, 20);
		getContentPane().add(txtFechaRegPrioridad);
		
		lblFechaRegPrioridad = new JLabel("FECHA REG.");
		lblFechaRegPrioridad.setBounds(297, 11, 86, 14);
		getContentPane().add(lblFechaRegPrioridad);
		
		txtEstadoPrioridad = new JTextField();
		txtEstadoPrioridad.setColumns(10);
		txtEstadoPrioridad.setBounds(393, 24, 86, 20);
		getContentPane().add(txtEstadoPrioridad);
		
		lblEstadoPrioridad = new JLabel("ESTADO");
		lblEstadoPrioridad.setBounds(393, 11, 86, 14);
		getContentPane().add(lblEstadoPrioridad);
		
		arranque();
	}

	private void arranque() {
		// TODO Auto-generated method stub
		limpiar();
	}
	
	private void limpiar() {
		// TODO Auto-generated method stub
		panelOP.setEnabled(false);
		
		txtNroOP.setText("");
		txtColorOP.setText("");
		txtClienteOP.setText("");
		txtEstiloOP.setText("");
		txtPrendaOP.setText("");
		
		txtIdPrioridad.setText(arrPrioridad.correlativo()+"");
		txtFechaRegPrioridad.setText(new SimpleDateFormat("dd/MM/yyy").format(new Date()));
		txtEstadoPrioridad.setText("REGISTRADO");
		txtObservacion.setText("");
		txtDescripcion.setText("");
		txtOrdenPrioridad.setText("1");
		txtIdF10.setText("");
		
		txtFechaRegPrioridad.setEditable(false);
		txtIdPrioridad.setEditable(false);
		txtEstadoPrioridad.setEditable(false);
		txtEstiloOP.setEditable(false);
		txtClienteOP.setEditable(false);
		txtColorOP.setEditable(false);
		txtPrendaOP.setEditable(false);
		txtIdF10.setEditable(false);
		
		btnAgregar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnEliminar.setEnabled(false);
	}
	
	private void agregar() {
		
		try {
			
			int id = leerIdPrioridad();
			int nroOP = leerNroOP();
			String colorOP = leerColorOP();
			String descripcion = leerDesPrioridad();
			String observacion = leerObsPrioridad();
			int orden = leerOrdenPrioridad();
			Date fechaReg =new Date();
			String estado = leerEstadoPrioridad();
			
			Prioridad obj = new Prioridad(id,nroOP,colorOP,descripcion,observacion,orden,fechaReg,estado);
			
			arrPrioridad.adicionar(obj);
			arrPrioridad.grabarPrioridad();
			
			Custom.mensajeExito(this, "En hora buena, prioridad " + id + " agregado a la lista");
			
			new FrmPrincipal().mostrarPrioridad();
			
			limpiar();
			
		}catch(Exception ex) {
			Custom.mensajeAdvertencia(this, ex.getMessage() + "\n metodo agregar");
		}
	}
	
	
	
	private void editar () {
		try {
			
			int id = leerIdPrioridad();
			int nroOP = leerNroOP();
			String colorOP = leerColorOP();
			String descripcion = leerDesPrioridad();
			String observacion = leerObsPrioridad();
			int orden = leerOrdenPrioridad();
			Date fechaReg =new Date();
			String estado = leerEstadoPrioridad();
			
			Prioridad obj = new Prioridad(id,nroOP,colorOP,descripcion,observacion,orden,fechaReg,estado);
			
			arrPrioridad.editar(obj);
			arrPrioridad.grabarPrioridad();
			
			Custom.mensajeExito(this, "En hora buena, prioridad " + id + " actualizado");
			
			limpiar();
			
		}catch(Exception ex) {
			Custom.mensajeAdvertencia(this, ex.getMessage() + "\n metodo editar");
		}
	}
	
	private void eliminar () {
		
		try {
			
			int id = leerIdPrioridad();
			int res = Custom.mensajeConfirmacion(this, "LA PRIORIDAD " + id + " SERA ELIMINADO") ;
			
			Prioridad obj = arrPrioridad.buscar(id);
					
			if(res == 0 ) {
				arrPrioridad.eliminar(obj);
				arrPrioridad.grabarPrioridad();
				
				Custom.mensajeExito(this, "En hora buena, prioridad " + id + " eliminado");
				
				limpiar();
			}else {
				Custom.mensajeAdvertencia(this, "OPERACION CANCELADA");
			}
			
			
			
		}catch(Exception ex) {
			Custom.mensajeAdvertencia(this, ex.getMessage() + "\n metodo eliminar");
		}
		
	}

	//METODOS GETTER
	
	private int leerIdPrioridad() {
		int res = -1;
		
		res = Integer.parseInt(txtIdPrioridad.getText().trim());
		
		return res;
	}
	private int leerNroOP() {
		int res = -1;
		
		res = Integer.parseInt(txtNroOP.getText().trim());
		
		return res;
	}
	private String leerColorOP() {
		String res = null;
		
		res = txtColorOP.getText().trim();
		
		return res;
	}
	private int leerOrdenPrioridad() {
		int res = -1;
		
		res = Integer.parseInt(txtOrdenPrioridad.getText().trim());
		
		return res;
	}
	private String leerObsPrioridad() {
		String res = null;
		
		res = txtObservacion.getText().trim();
		
		return res;
	}
	private String leerDesPrioridad() {
		String res = null;
		
		res = txtDescripcion.getText().trim();
		
		return res;
	}
	private String leerEstadoPrioridad() {
		String res = null;
		
		res = txtEstadoPrioridad.getText().trim();
		
		return res;
	}
	private Date leerFechaRegPrioridad() {
		Date res = null;
		
		try {
			res = new Date( new SimpleDateFormat().parse(txtFechaRegPrioridad.getText().trim()).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			Custom.mensajeAdvertencia(this, e.getMessage());
		}
		
		return res;
	}
	
	//EVENTOS
	//ACTION LISTENER
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource()==btnEditar) {

			actionPerformedBtnEditar(e);
		}
		if (e.getSource()==btnEliminar) {

			actionPerformedBtnEliminar(e);
		}
		if (e.getSource()==btnNuevo) {

			actionPerformedBtnNuevo(e);
		}
		if (e.getSource()==btnLista) {

			actionPerformedBtnLista(e);
		}
		if (e.getSource()==btnBuscarOP) {

			actionPerformedBtnBuscarOP(e);
		}
	}

	private void actionPerformedBtnBuscarOP(ActionEvent e) {
		// TODO Auto-generated method stub
		DlgListaF10.frame = "FrmPrioridad";
		DlgListaF10 frame = new DlgListaF10(null,true);
		frame.setVisible(true);
		
	}

	private void actionPerformedBtnLista(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmConsultaPrioridad frame = new FrmConsultaPrioridad();
		this.dispose();
		FrmPrincipal.escritorio.add(frame);
		frame.setVisible(true);
		frame.toFront();
		
	}

	private void actionPerformedBtnNuevo(ActionEvent e) {
		// TODO Auto-generated method stub
		limpiar();
	}

	private void actionPerformedBtnEliminar(ActionEvent e) {
		// TODO Auto-generated method stub
		eliminar();
	}

	private void actionPerformedBtnEditar(ActionEvent e) {
		// TODO Auto-generated method stub
		editar();
	}

	private void actionPerformedBtnAgregar(ActionEvent e) {
		// TODO Auto-generated method stub
		agregar();
	}
	//CARET LISTENER
	@Override
	public void caretUpdate(CaretEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==txtNroOP) {
			caretUpdateTxtNroOP(e);
		}
		if(e.getSource()==txtIdPrioridad) {
			caretUpdateTxtIdPrioridad(e);
		}
	}

	private void caretUpdateTxtIdPrioridad(CaretEvent e) {
		// TODO Auto-generated method stub
		
		try {
			ArregloF10 arrF10 = new ArregloF10();
			
			Prioridad obj = arrPrioridad.buscar(Integer.parseInt(txtIdPrioridad.getText()));
			
			F10 objF10 =  arrF10.buscarPorNroOPYColorOP(obj.getNro_OP(),obj.getColor_OP());
			

			txtIdF10.setText(objF10.getId_F10() + "");
			txtNroOP.setText(obj.getNro_OP() + "");
			txtColorOP.setText(obj.getColor_OP());
			
			txtOrdenPrioridad.setText(obj.getOrden_prioridad() + "");
			txtDescripcion.setText(obj.getDes_prioridad());
			txtObservacion.setText(obj.getObs_prioridad());
			txtEstadoPrioridad.setText(obj.getEstado_prioridad());
			//txtFechaRegPrioridad.setText(new SimpleDateFormat("dd/MM/yyy").format(obj.getFechaReg_prioridad()));
			
		}catch(Exception ex) {
			
		}
		
		
	}

	private void caretUpdateTxtNroOP(CaretEvent e) {
		// TODO Auto-generated method stub
		ArregloF10 arrF10 = new ArregloF10();
		F10 obj =  arrF10.buscar(Integer.parseInt(txtIdF10.getText()));
		
		txtClienteOP.setText(obj.getCliente_F10());
		txtEstiloOP.setText(obj.getEstilo_F10());
		txtPrendaOP.setText(obj.getPrenda_F10());
	}
	
	
	
}
