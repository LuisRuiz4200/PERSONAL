package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import clases.*;
import utils.Tool;
import arreglos.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class FrmConsultaDeuda extends JInternalFrame implements ActionListener{
	private JTable table;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane;
	private ArregloDeuda arrGasto;
	private JButton btnEliminar;
	
	
	public static void main(String [] args) {
		
		FrmConsultaDeuda form = new FrmConsultaDeuda();
		form.setVisible(true);
		
	}
	
	public FrmConsultaDeuda() {
		
		setTitle("Consulta de gasto");
		setBounds(100,100,560,359);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		this.getContentPane().setLayout(null);
		
		arrGasto =  new ArregloDeuda();
		
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
		modelo.addColumn("Monto");
		modelo.addColumn("Cuota");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Interes");
		modelo.addColumn("Fecha");
		table.setModel(modelo);
		
		
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
			String codigo = modelo.getValueAt(indice, 0).toString();
			Deuda g = arrGasto.buscar(codigo);
			
			if(g!=null) {
				if(Tool.mensajeConfirmacion(this, "Se eliminara la fila con el codigo: " + g.getId_deuda())==0) {
					arrGasto.eliminar(g);
					arrGasto.grabarGasto();
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
		
		for(int i=0; i<arrGasto.tamaño();i++) {
			Deuda g = arrGasto.obtener(i);
			
			Cliente c = arrCliente.buscar(g.getId_cliente());
			
			String codigo= g.getId_deuda();
			String cliente = c.getNom_cliente();
			String motivo= g.getDes_deuda();
			double monto = g.getMonto_deuda();
			String fecha = g.getFecha_deuda();
			int cuota = g.getCuota_deuda();
			double interes = g.getInteres_deuda();
			
			Object[] x = {codigo,cliente,monto,cuota,motivo,interes,fecha};
			
			modelo.addRow(x);
		}
		
	}
	
	
}
