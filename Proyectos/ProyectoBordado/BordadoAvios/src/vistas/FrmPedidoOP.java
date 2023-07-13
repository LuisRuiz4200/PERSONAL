package vistas;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import arreglos.ArregloCitiAcabado;
import arreglos.ArregloDetPedidoOP;
import arreglos.ArregloF10;
import arreglos.ArregloPedidoOP;
import arreglos.ArregloProgramaAcabado;
import arreglos.ArregloTalla;
import clases.CitiAcabado;
import clases.DetPedidoOP;
import clases.F10;
import clases.PedidoOP;
import clases.ProgramaAcabado;
import reuzables.Custom;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

@SuppressWarnings("serial")
public class FrmPedidoOP extends JInternalFrame implements ActionListener, CaretListener{
	private JPanel panelOP;
	public static JTextField txtFechaAct;
	private JLabel lblFechaAct;
	public static JTextField txtEstado;
	private JLabel lblEstado;
	public static JTextField txtFechaReg;
	private JLabel lblFechaReg;
	public static JTextField txtCodPrograma;
	private JLabel lblCodPrograma;
	private JButton btnBuscarProgramaAcabado;
	private JTable tbTalla;
	private JScrollPane spTbTalla;
	public static JButton btnAgregar;
	public static JButton btnEditar;
	public static JButton btnEliminar;
	public static JButton btnNuevo;
	public static JButton btnLista;
	private JTextField txtNroOP;
	private JLabel lblNroOP;
	private JPanel panelAcabado;
	private JTextField txtAcabado;
	private JLabel lblCodAcabado;
	private JTextField txtEstiloOP;
	private JLabel lblEstiloOP;
	private JTextField txtColorOP;
	private JLabel lblColorOP;
	private JTextField txtPrendaOP;
	private JLabel lblPrendaOP;
	private JTextField txtDesAcabado;
	private JLabel lblDesAcabado;
	public static JTextField txtIdPedidoOP;
	private JLabel lblIdPedidoOP;
	private JTextField txtCliente;
	private JLabel lblClienteOP;
	private JButton btnBuscarTalla;
	public static DefaultTableModel modelo;
	public static int[] talla = new int[] {};
	
	private ArregloPedidoOP arrPedidoOP = new ArregloPedidoOP();
	private ArregloDetPedidoOP arrDetPedidoOP = new ArregloDetPedidoOP();
	public static JEditorPane txtObsPedidoOP;
	private JLabel lblObsPedidoOP;
	
	
	public static void main (String[] args) {
		FrmPedidoOP ventana = new FrmPedidoOP();
		ventana.setVisible(true);
	}
	
	public FrmPedidoOP() {
		

		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PEDIDOS DE OP");
		this.setBounds(0,0,565,493);
		//this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		
		this.setLocation(40,40);
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(true);
		this.toFront();
		
		panelOP = new JPanel();
		panelOP.setBounds(10, 74, 507, 121);
		panelOP.setBorder(new TitledBorder("OP DE PROGRAMA"));
		getContentPane().add(panelOP);
		panelOP.setLayout(null);
		
		txtCodPrograma = new JTextField();
		txtCodPrograma.addCaretListener(this);
		txtCodPrograma.setColumns(10);
		txtCodPrograma.setBounds(10, 43, 86, 20);
		panelOP.add(txtCodPrograma);
		
		lblCodPrograma = new JLabel("PROGRAMA");
		lblCodPrograma.setBounds(10, 29, 86, 14);
		panelOP.add(lblCodPrograma);
		
		btnBuscarProgramaAcabado = new JButton("...");
		btnBuscarProgramaAcabado.addActionListener(this);
		btnBuscarProgramaAcabado.setBounds(106, 42, 25, 23);
		panelOP.add(btnBuscarProgramaAcabado);
		
		txtNroOP = new JTextField();
		txtNroOP.setColumns(10);
		txtNroOP.setBounds(141, 43, 86, 20);
		panelOP.add(txtNroOP);
		
		lblNroOP = new JLabel("OP");
		lblNroOP.setBounds(141, 29, 46, 14);
		panelOP.add(lblNroOP);
		
		txtEstiloOP = new JTextField();
		txtEstiloOP.setColumns(10);
		txtEstiloOP.setBounds(237, 43, 155, 20);
		panelOP.add(txtEstiloOP);
		
		lblEstiloOP = new JLabel("ESTILO");
		lblEstiloOP.setBounds(237, 29, 46, 14);
		panelOP.add(lblEstiloOP);
		
		txtColorOP = new JTextField();
		txtColorOP.setColumns(10);
		txtColorOP.setBounds(106, 90, 155, 20);
		panelOP.add(txtColorOP);
		
		lblColorOP = new JLabel("COLOR");
		lblColorOP.setBounds(106, 76, 46, 14);
		panelOP.add(lblColorOP);
		
		txtPrendaOP = new JTextField();
		txtPrendaOP.setColumns(10);
		txtPrendaOP.setBounds(402, 43, 86, 20);
		panelOP.add(txtPrendaOP);
		
		lblPrendaOP = new JLabel("PRENDA");
		lblPrendaOP.setBounds(402, 29, 86, 14);
		panelOP.add(lblPrendaOP);
		
		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(10, 90, 86, 20);
		panelOP.add(txtCliente);
		
		lblClienteOP = new JLabel("CLIENTE");
		lblClienteOP.setBounds(10, 76, 86, 14);
		panelOP.add(lblClienteOP);
		
		txtFechaAct = new JTextField();
		txtFechaAct.setBounds(338, 25, 86, 20);
		getContentPane().add(txtFechaAct);
		txtFechaAct.setColumns(10);
		
		lblFechaAct = new JLabel("ACTUALIZADO");
		lblFechaAct.setBounds(338, 11, 86, 14);
		getContentPane().add(lblFechaAct);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(431, 25, 86, 20);
		getContentPane().add(txtEstado);
		
		lblEstado = new JLabel("ESTADO");
		lblEstado.setBounds(431, 11, 86, 14);
		getContentPane().add(lblEstado);
		
		txtFechaReg = new JTextField();
		txtFechaReg.setColumns(10);
		txtFechaReg.setBounds(242, 25, 86, 20);
		getContentPane().add(txtFechaReg);
		
		lblFechaReg = new JLabel("REGISTRO");
		lblFechaReg.setBounds(242, 11, 86, 14);
		getContentPane().add(lblFechaReg);
		
		spTbTalla = new JScrollPane();
		spTbTalla.setBounds(367, 206, 150, 213);
		getContentPane().add(spTbTalla);
		
		tbTalla = new JTable();
		spTbTalla.setViewportView(tbTalla);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(10, 430, 89, 23);
		getContentPane().add(btnAgregar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(105, 430, 89, 23);
		getContentPane().add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(200, 430, 89, 23);
		getContentPane().add(btnEliminar);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(299, 430, 89, 23);
		getContentPane().add(btnNuevo);
		
		btnLista = new JButton("LISTA");
		btnLista.addActionListener(this);
		btnLista.setBounds(398, 430, 89, 23);
		getContentPane().add(btnLista);
		
		panelAcabado = new JPanel();
		panelAcabado.setLayout(null);
		panelAcabado.setBorder(new TitledBorder("ACABADO"));
		panelAcabado.setBounds(10, 206, 279, 83);
		getContentPane().add(panelAcabado);
		
		txtAcabado = new JTextField();
		txtAcabado.setColumns(10);
		txtAcabado.setBounds(10, 40, 86, 20);
		panelAcabado.add(txtAcabado);
		
		lblCodAcabado = new JLabel("CODIGO");
		lblCodAcabado.setBounds(10, 26, 86, 14);
		panelAcabado.add(lblCodAcabado);
		
		txtDesAcabado = new JTextField();
		txtDesAcabado.setColumns(10);
		txtDesAcabado.setBounds(106, 40, 165, 20);
		panelAcabado.add(txtDesAcabado);
		
		lblDesAcabado = new JLabel("DESCRIPCION");
		lblDesAcabado.setBounds(106, 26, 104, 14);
		panelAcabado.add(lblDesAcabado);
		
		txtIdPedidoOP = new JTextField();
		txtIdPedidoOP.setColumns(10);
		txtIdPedidoOP.setBounds(10, 25, 86, 20);
		getContentPane().add(txtIdPedidoOP);
		
		lblIdPedidoOP = new JLabel("ID");
		lblIdPedidoOP.setBounds(10, 11, 46, 14);
		getContentPane().add(lblIdPedidoOP);
		
		btnBuscarTalla = new JButton("...");
		btnBuscarTalla.addActionListener(this);
		btnBuscarTalla.setBounds(299, 217, 46, 23);
		getContentPane().add(btnBuscarTalla);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ITEM");
		modelo.addColumn("TALLA");
		modelo.addColumn("CANT.");
		
		modelo.setRowCount(1);
		
		tbTalla.setModel(modelo);
		
		tbTalla.setFillsViewportHeight(true);
		
		txtObsPedidoOP = new JEditorPane();
		txtObsPedidoOP.setBounds(10, 324, 330, 83);
		getContentPane().add(txtObsPedidoOP);
		
		lblObsPedidoOP = new JLabel("OBSERVACIONES");
		lblObsPedidoOP.setBounds(10, 299, 114, 14);
		getContentPane().add(lblObsPedidoOP);
		
		arranque();
	}
	
	
	
	private void arranque() {
		// TODO Auto-generated method stub
		limpiar();
	}
	
	public void cargarDetPedidoOP() {
		
		modelo.setRowCount(0);
		
		for (DetPedidoOP obj : arrDetPedidoOP.listar()) {
			
			if (obj.getId_pedidoOP()==leerIdPedidoOP()){
				Object[] x = new Object[] {
						obj.getId_det_pedidoOP(),
						new ArregloTalla().buscar(obj.getId_talla()).getDes_talla(),
						obj.getCant_det_pedidoOP()
				};
				
				modelo.addRow(x);
			}
			
		}
	}
	
	private void adicionar() {
		
		try {
			int id = leerIdPedidoOP();
			int codPrograma = leerCodProgramaAcabado();
			String obs = leerObsPedidoOP();
			Date fechaReg = leerFechaRegPedidoOP();
			Date fechaAct = leerFechaActPedidoOP();
			String estado = leerEstadoPedidoOP();
			
			PedidoOP obj = new PedidoOP(id,codPrograma,obs,fechaReg,fechaAct,estado);
			
			if(adicionarTalla()==false) {
				return;
			}
						
			arrPedidoOP.adicionar(obj);
			arrPedidoOP.grabarPedidoOP();
			
			limpiar();
			
			Custom.mensajeExito(this, "CORRECTO");
			
		}catch(Exception ex) {
			Custom.mensajeAdvertencia(this, ex.getMessage() + "\n"+ " FRMPEDIDO ADICIONAR");
		}
		
	}
	
	
	
	private void editar() {
		try {
			int id = leerIdPedidoOP();
			int codPrograma = leerCodProgramaAcabado();
			String obs = leerObsPedidoOP();
			Date fechaReg = leerFechaRegPedidoOP();
			Date fechaAct = leerFechaActPedidoOP();
			String estado = leerEstadoPedidoOP();
			
			PedidoOP obj = new PedidoOP(id,codPrograma,obs,fechaReg,fechaAct,estado);
			
			if(editarTalla()==false) {
				return;
			}
			
			arrPedidoOP.editar(obj);
			arrPedidoOP.grabarPedidoOP();
			limpiar();
			
			Custom.mensajeExito(this, "UPDATE CORRECTO");
			
		}catch(Exception ex) {
			Custom.mensajeAdvertencia(this, ex.getMessage() + "\n"+ " FRMPEDIDO EDITAR");
		}
		
	}
	
	private void eliminar() {
		try {
			
			int id = leerIdPedidoOP();
			
			if(Custom.mensajeConfirmacion(this, "PEDIDO " + id + " SERA ELIMINADO")!=0) {
				Custom.mensajeAdvertencia(this, "OPERACION CANCELADA");
				return;
			}
			
			if(eliminarTalla()==false) {
				return;
			}
			
			arrPedidoOP.eliminar(id);
			arrPedidoOP.grabarPedidoOP();
			limpiar();
			Custom.mensajeExito(this, "PEDIDO " + id + " ELIMINADO CON EXITO");
			
		}catch(Exception ex) {
			Custom.mensajeError(this, ex.getMessage());
		}
	}
	
	private boolean adicionarTalla() {
		
		boolean tallaAgregada = false;
		
		try {
			
			for (int i=0;i<tbTalla.getRowCount();i++) {
				if (tbTalla.getValueAt(i, 2).toString().equals("")) {
					Custom.mensajeError(this, "ITEM " + (i+1) + " VACIO");
					return tallaAgregada;
				}
			}
			
			for (int i=0;i<tbTalla.getRowCount();i++) {
				
					
				int idPedido = leerIdPedidoOP();
				int idDetPedido =(int) tbTalla.getValueAt(i, 0);
				int idTalla = new ArregloTalla().buscarPorDesTalla((String) tbTalla.getValueAt(i, 1)).getId_talla();
				int cantTalla = Integer.parseInt(tbTalla.getValueAt(i, 2).toString());
				
				
				DetPedidoOP obj = new DetPedidoOP(idPedido,idDetPedido,idTalla,cantTalla);
				
				arrDetPedidoOP.adicionar(obj);
				arrDetPedidoOP.grabarDetPedidoOP();
				
				tallaAgregada = true;
				
			}
			
			Custom.mensajeExito(this, (tbTalla.getRowCount() ) + " TALLAS REGISTRADAS");
			
			
		}catch (Exception ex) {
			Custom.mensajeAdvertencia(this, ex.getMessage() + " \n adicionar talla");
		}
		
		return tallaAgregada;
	}
	
	
	private boolean editarTalla() {
		
		boolean tallaEditada = false;
		
		try {
			
			for (int i=0;i<tbTalla.getRowCount();i++) {
				if (tbTalla.getValueAt(i, 2).toString().equals("")) {
					Custom.mensajeError(this, "ITEM " + (i+1) + " VACIO");
					return tallaEditada;
				}
			}
			
			for (int i=0;i<tbTalla.getRowCount();i++) {
				
				int idPedido = leerIdPedidoOP();
				int idDetPedido =(int) tbTalla.getValueAt(i, 0);
				int idTalla = new ArregloTalla().buscarPorDesTalla((String) tbTalla.getValueAt(i, 1)).getId_talla();
				int cantTalla =Integer.parseInt(tbTalla.getValueAt(i, 2).toString());
				
				
				DetPedidoOP obj = new DetPedidoOP(idPedido,idDetPedido,idTalla,cantTalla);
				
				arrDetPedidoOP.editar(obj);
				arrDetPedidoOP.grabarDetPedidoOP();
				tallaEditada = true;
			}
			
			Custom.mensajeExito(this, (tbTalla.getRowCount() ) + " TALLAS EDITADAS");
			
			
		}catch (Exception ex) {
			Custom.mensajeAdvertencia(this, ex.getMessage() + " \n editar talla");
			adicionarTalla();
		}
		
		return tallaEditada;
	}
	
	private boolean eliminarTalla() {
		
		boolean tallaEliminada = false;
		
		for (int i=0;i<tbTalla.getRowCount();i++) {
			if (tbTalla.getValueAt(i, 2).toString().equals("")) {
				Custom.mensajeError(this, "ITEM " + (i+1) + " VACIO");
				return tallaEliminada;
			}
		}
		
		try {
			for (int i=0;i<tbTalla.getRowCount();i++) {
				
				int idPedido = leerIdPedidoOP();
				int idDetPedido =(int) tbTalla.getValueAt(i, 0);				
				
				arrDetPedidoOP.eliminar(idPedido,idDetPedido);
				arrDetPedidoOP.grabarDetPedidoOP();
				tallaEliminada= true;
			}
			
			Custom.mensajeExito(this, (tbTalla.getColumnCount()) + " TALLAS ELIMINADAS");
			
			
		}catch (Exception ex) {
			Custom.mensajeAdvertencia(this, ex.getMessage() + " \n eliminar talla");
		}
		
		return tallaEliminada;
	}
	
	private void limpiar() {
		
		for (Component textBox :panelOP.getComponents()) {
			
			if (textBox instanceof JTextField) {
				((JTextField)textBox).setEditable(false);
				((JTextField) textBox).setText("");
			}
			
		}
		
		for (Component textBox :panelAcabado.getComponents()) {
			
			if (textBox instanceof JTextField) {
				((JTextField)textBox).setEditable(false);
				((JTextField) textBox).setText("");
			}
			
		}
		
		for (Component textBox :this.getContentPane().getComponents()) {
			
			if (textBox instanceof JTextField) {
				((JTextField)textBox).setEditable(false);
				((JTextField) textBox).setText("");
			}
			
		}
		
		modelo.setRowCount(0);
		modelo.addRow(new Object[] {});
		
		txtIdPedidoOP.setText(arrPedidoOP.correlativo() + "");
		txtEstado.setText("REGISTRADO");
		txtFechaReg.setText(new SimpleDateFormat("dd/mm/yy").format(new Date()));
		txtFechaAct.setText(new SimpleDateFormat("dd/mm/yy").format(new Date()));
		
		txtObsPedidoOP.setText("");
		
		btnAgregar.setEnabled(true);
		btnEditar.setEnabled(false);
		btnEliminar.setEnabled(false);
		
	}
	
	//GETTER
	
	private String leerEstadoPedidoOP() {
		// TODO Auto-generated method stub
		return txtEstado.getText();
	}
	
	private Date leerFechaActPedidoOP() {
		// TODO Auto-generated method stub
		return new Date();
	}

	private Date leerFechaRegPedidoOP() {
		// TODO Auto-generated method stub
		return new Date();
	}

	private int leerCodProgramaAcabado() {
		// TODO Auto-generated method stub
		int res = 0;
		
		res =  Integer.parseInt(txtCodPrograma.getText().trim());
		
		return res;
	}

	private int leerIdPedidoOP() {
		// TODO Auto-generated method stub
		return Integer.parseInt(txtIdPedidoOP.getText());
	}
	
	private String leerObsPedidoOP() {
		return txtObsPedidoOP.getText().toUpperCase().trim();
	}

	//ACTION LISTENER
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarTalla) {
			actionPerformedBtnBuscarTalla(e);
		}
		if (e.getSource() == btnBuscarProgramaAcabado) {
			actionPerformedBtnBuscarProgramaAcabado(e);
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
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
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
		
		FrmConsultaPedidoOP frame = new FrmConsultaPedidoOP();
		FrmPrincipal.escritorio.add(frame);
		frame.setVisible(true);
		this.dispose();
		
	}
	protected void actionPerformedBtnBuscarProgramaAcabado(ActionEvent e) {
		
		DlgListaProgramaAcabado.frame = "FrmPedidoOP";
		
		DlgListaProgramaAcabado dlg = new DlgListaProgramaAcabado(null,true);
		dlg.setVisible(true);
	}
	protected void actionPerformedBtnBuscarTalla(ActionEvent e) {
		
		DlgListaTalla.frame = "FrmPedidoOP";
		
		DlgListaTalla dlg = new DlgListaTalla(null,true);
		dlg.setVisible(true);
		
	}
	
	//CARE LISTENER
	public void caretUpdate(CaretEvent e) {
		if (e.getSource() == txtCodPrograma) {
			caretUpdateTxtCodPrograma(e);
		}
	}
	protected void caretUpdateTxtCodPrograma(CaretEvent e) {
		
		if(txtCodPrograma.getText().trim().length()==0) {
			return;
		}
		
		ArregloProgramaAcabado arrProgramaAcabado = new ArregloProgramaAcabado();
		ArregloF10 arrF10 = new ArregloF10();
		ArregloCitiAcabado arrAcabado = new ArregloCitiAcabado();
		
		int codProgramaAcabado = leerCodProgramaAcabado();
		
		ProgramaAcabado objProgramaAcabado = arrProgramaAcabado.buscar(codProgramaAcabado);
		F10 objF10 = arrF10.buscarPorNroOP(objProgramaAcabado.getNro_OP());
		CitiAcabado objAcabado = arrAcabado.buscar(objProgramaAcabado.getCod_citiAcabado());
		
		if(Objects.isNull(objProgramaAcabado)) return;
		if(Objects.isNull(objF10)) return;
		if(Objects.isNull(objAcabado))return;
		
		txtColorOP.setText(objProgramaAcabado.getCod_colorOP());
		txtNroOP.setText(objProgramaAcabado.getNro_OP()+"");
		txtCliente.setText(objF10.getCliente_F10());
		txtEstiloOP.setText(objF10.getEstilo_F10());
		txtPrendaOP.setText(objF10.getPrenda_F10());
		
		txtAcabado.setText(objProgramaAcabado.getCod_citiAcabado());
		txtDesAcabado.setText(objAcabado.getDes_citiAcabado());
		
		
	}
}
