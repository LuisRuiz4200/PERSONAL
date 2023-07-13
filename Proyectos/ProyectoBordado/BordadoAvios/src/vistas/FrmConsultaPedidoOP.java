package vistas;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloDetPedidoOP;
import arreglos.ArregloF10;
import arreglos.ArregloPedidoOP;
import arreglos.ArregloProgramaAcabado;
import clases.PedidoOP;
import reuzables.Custom;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class FrmConsultaPedidoOP extends JInternalFrame implements ActionListener, MouseListener{
	private JTable tbPedidoOP;
	
	private DefaultTableModel modelo;
	private JButton btnElegir;
	private JButton btnEditar;
	private JButton btnAgregar;
	
	private ArregloPedidoOP arrPedidoOP = new ArregloPedidoOP();
	private ArregloDetPedidoOP arrDetPedidoOP = new ArregloDetPedidoOP();
	private JTextField txtIdPedidoOP;
	private JLabel lblIdPedidoOP;
	
	public static void main (String[] args) {
		FrmConsultaPedidoOP ventana = new FrmConsultaPedidoOP();
		ventana.setVisible(true);
	}
	
	public FrmConsultaPedidoOP() {
		
		this.setTitle("CONSULA DE PEDIDOS DE OP");
		this.setBounds(0,0,563,418);
		//this.setLocationRelativeTo(this);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		this.setLocation(40,40);
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
		this.toFront();
		
		JScrollPane spTbPedidoOP = new JScrollPane();
		spTbPedidoOP.setBounds(10, 70, 527, 299);
		getContentPane().add(spTbPedidoOP);
		
		tbPedidoOP = new JTable();
		tbPedidoOP.addMouseListener(this);
		spTbPedidoOP.setViewportView(tbPedidoOP);
		
		btnElegir = new JButton("Elegir");
		btnElegir.addActionListener(this);
		btnElegir.setBounds(167, 38, 89, 23);
		getContentPane().add(btnElegir);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(448, 38, 89, 23);
		getContentPane().add(btnEditar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(349, 38, 89, 23);
		getContentPane().add(btnAgregar);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("NRO OP");
		modelo.addColumn("CLIENTE");
		modelo.addColumn("COLOR");
		modelo.addColumn("ACABADO");
		modelo.addColumn("TOTAL");
		modelo.addColumn("REGISTRO");
		modelo.addColumn("ACTUALIZADO");
		modelo.addColumn("ESTADO");
		tbPedidoOP.setModel(modelo);
		
		tbPedidoOP.setAutoResizeMode(0);
		
		txtIdPedidoOP = new JTextField();
		txtIdPedidoOP.setBounds(10, 39, 60, 20);
		getContentPane().add(txtIdPedidoOP);
		txtIdPedidoOP.setColumns(10);
		
		lblIdPedidoOP = new JLabel("ID");
		lblIdPedidoOP.setBounds(10, 24, 46, 14);
		getContentPane().add(lblIdPedidoOP);
		
		arranque();
	}

	private void arranque() {
		// TODO Auto-generated method stub
		cargarTablaPedidoOP();
	}

	private void cargarTablaPedidoOP() {
		
		ArregloProgramaAcabado arrProgramaAcabado = new ArregloProgramaAcabado();
		ArregloF10 arrF10 = new ArregloF10();
		
		
		modelo.setRowCount(0);
		
		for (PedidoOP obj: arrPedidoOP.listar()) {
			
			int nroOP = arrProgramaAcabado.buscar(obj.getCod_programaAcabado()).getNro_OP();
			String colorOP = arrProgramaAcabado.buscar(obj.getCod_programaAcabado()).getCod_colorOP();
			String acabado = arrProgramaAcabado.buscar(obj.getCod_programaAcabado()).getCod_citiAcabado();
			int totalCantTalla =arrDetPedidoOP.totalCantTallaPorPedido(obj.getId_pedidoOP());
			
			Object [] x = new Object[] {
				obj.getId_pedidoOP(),
				nroOP,
				arrF10.buscarPorNroOPYColorOP(nroOP, colorOP).getCliente_F10(),
				colorOP,
				acabado,
				totalCantTalla,
				new SimpleDateFormat("dd MMM yyy").format(obj.getFechaReg_pedidoOP()),
				new SimpleDateFormat("dd MMM yyy").format(obj.getFechaAct_pedidoOP()),
				obj.getEstado_pedidoOP()
			};
			
			modelo.addRow(x);
		}
	}
	
	private void cargarData() {
		int fila = tbPedidoOP.getSelectedRow();
		
		int idPedidoOP = (int)tbPedidoOP.getValueAt(fila, 0);
		
		txtIdPedidoOP.setText(idPedidoOP+"");
		
	}
	
	private void exportarData() {
		
		PedidoOP obj = arrPedidoOP.buscar(leerIdPedidoOP());
		
		if (Objects.isNull(obj)) {
			return ;
		}
		
		FrmPedidoOP frame = new FrmPedidoOP();
		FrmPrincipal.escritorio.add(frame);
		frame.setVisible(true);
		frame.txtCodPrograma.setText(obj.getCod_programaAcabado()+"");
		frame.txtEstado.setText(obj.getEstado_pedidoOP());
		frame.txtFechaReg.setText(new SimpleDateFormat("dd/MM/yy").format(obj.getFechaReg_pedidoOP()).toString());
		frame.txtFechaAct.setText(new SimpleDateFormat("dd/MM/yy").format(obj.getFechaAct_pedidoOP()).toString());
		frame.txtIdPedidoOP.setText(obj.getId_pedidoOP()+"");
		frame.txtObsPedidoOP.setText(obj.getObs_pedidoOP());
		
		frame.btnAgregar.setEnabled(false);
		frame.btnEditar.setEnabled(true);
		frame.btnEliminar.setEnabled(true);
		
		frame.cargarDetPedidoOP();
		
		this.dispose();
	}
	
	//GETTERS
	
	private int leerIdPedidoOP() {
		int res = 0;
		
		try {
			if(txtIdPedidoOP.getText().trim().length()==0) {
				return 0;
			}
			res = Integer.parseInt(txtIdPedidoOP.getText());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			Custom.mensajeAdvertencia(this, e.getMessage());
		}
		
		return res ;
	}
	
	//ACTION LISTENER
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		if (e.getSource() == btnElegir) {
			actionPerformedBtnElegir(e);
		}
	}
	protected void actionPerformedBtnElegir(ActionEvent e) {
		exportarData();
	}

	protected void actionPerformedBtnEditar(ActionEvent e) {
		exportarData();
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		FrmPedidoOP frame = new FrmPedidoOP();
		FrmPrincipal.escritorio.add(frame);
		frame.setVisible(true);
		
	}
	
	//MOUSE LISTENER
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbPedidoOP) {
			mouseClickedTbPedidoOP(e);
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
	protected void mouseClickedTbPedidoOP(MouseEvent e) {
		cargarData();
	}
}
