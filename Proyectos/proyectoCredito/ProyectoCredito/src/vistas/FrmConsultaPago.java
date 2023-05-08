package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import arreglos.*;
import clases.*;

@SuppressWarnings("serial")
public class FrmConsultaPago extends JInternalFrame implements ActionListener{
	private JTable table;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private ArregloPago arrPago;
	private DefaultTableModel modelo;
	
	
	public static void main(String [] args) {
		
		FrmConsultaPago form = new FrmConsultaPago();
		form.setVisible(true);
		
	}
	
	public FrmConsultaPago() {
		
		setTitle("Consulta de pagos");
		setBounds(100,100,500,300);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		this.getContentPane().setLayout(null);
		
		
		arrPago = new ArregloPago();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 464, 164);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(355, 52, 89, 23);
		getContentPane().add(btnEliminar);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("CLIENTE");
		modelo.addColumn("FECHA");
		modelo.addColumn("ABONO");
		table.setModel(modelo);
		
		arranque();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		
		
	}
	
	//metodos adicionales
	
	void arranque () {
		listar();
	}
	
	void listar () {
		
		ArregloCliente arrCliente = new ArregloCliente();
		
		modelo.setRowCount(0);
		
		for(int i=0;i<arrPago.tamaño();i++) {
			
			Pago p =  arrPago.obtener(i);
			
			Cliente c = arrCliente.buscar(p.getCliente());
			
			Object[] x = {
					p.getCodigo(),
					c.getNombre(),
					p.getFecha(),
					p.getAbono()
			};
			
			modelo.addRow(x);
		}
		
	}
}
