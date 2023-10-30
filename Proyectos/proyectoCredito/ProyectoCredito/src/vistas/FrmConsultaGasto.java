package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import clases.*;
import utils.Tool;
import arreglos.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class FrmConsultaGasto extends JInternalFrame implements ActionListener{
	private JTable table;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;
	private ArregloGasto arrGasto;
	private JButton btnEliminar;
	
	
	public static void main(String [] args) {
		
		FrmConsultaGasto form = new FrmConsultaGasto();
		form.setVisible(true);
		
	}
	
	public FrmConsultaGasto() {
		
		setTitle("Consulta de gasto");
		setBounds(100,100,560,359);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		this.getContentPane().setLayout(null);
		
		arrGasto =  new ArregloGasto();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 524, 237);
		getContentPane().add(scrollPane);
		
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		modelo= new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Cliente");
		modelo.addColumn("Motivo");
		modelo.addColumn("Monto");
		modelo.addColumn("Fecha");
		modelo.addColumn("Cuota");
		modelo.addColumn("Interes");
		modelo.addColumn("Monto Mensual");
		table.setModel(modelo);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(155);
		table.getColumnModel().getColumn(7).setPreferredWidth(95);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(407, 38, 89, 23);
		getContentPane().add(btnEliminar);
		
		arranque();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		try {
			int indice = table.getSelectedRow();
			int codigo = (int)modelo.getValueAt(indice, 0);
			Gasto g = arrGasto.buscar(codigo);
			
			if(g!=null) {
				if(Tool.mensajeConfirmacion(this, "Se eliminara la fila con el codigo: " + g.getCodigo())==0) {
					arrGasto.eliminar(g);
					arrGasto.gabrarGasto();
					listar();
				}	
			}
		}catch(Exception ex) {
			Tool.mensajeError(this,ex.getMessage());
		}
		
		
		
		
	}
	
	void arranque() {
		listar();
	}
	
	void listar(){
		
		ArregloCliente arrCliente = new ArregloCliente();
		
		modelo.setRowCount(0);
		
		for(int i=0; i<arrGasto.tamano();i++) {
			Gasto g = arrGasto.obtener(i);
			
			Cliente c = arrCliente.buscar(g.getCliente());
			
			int codigo= g.getCodigo();
			String cliente = c.getNombre();
			String motivo= g.getMotivo();
			double monto = g.getMonto();
			String fecha = g.getFecha();
			int cuota = g.getCuota();
			double interes = g.getInteres();
			double montoMensual = g.montoMensual();
			
			Object[] x = {codigo,cliente,motivo,monto,fecha,cuota,interes,montoMensual};
			
			modelo.addRow(x);
		}
		
	}
	
	
}
