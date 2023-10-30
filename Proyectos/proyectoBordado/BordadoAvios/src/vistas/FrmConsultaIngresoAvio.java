package vistas;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import arreglos.ArregloIngresoAvio;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmConsultaIngresoAvio extends JFrame implements ActionListener {
	public static void main(String[] args) {
		FrmConsultaIngresoAvio ventana = new FrmConsultaIngresoAvio();
		ventana.setVisible(true);
	}

	private JTable table;
	private JButton btnConsultar;
	private JDateChooser dcFecha;
	private DefaultTableModel model;
	private JLabel lblFecha;
	private JScrollPane spTable;
	
	private ArregloIngresoAvio arrIngAvio;

	public FrmConsultaIngresoAvio() {

		this.setTitle("LISTA DE INGRESO DE AVIOS");
		this.setBounds(0, 0, 622, 459);
		this.setLocationRelativeTo(this);
		getContentPane().setLayout(null);

		table = new JTable();
		
		spTable = new JScrollPane();
		spTable.setBounds(10, 74, 586, 335);
		spTable.setViewportView(table);
		getContentPane().add(spTable);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(199, 40, 110, 23);
		getContentPane().add(btnConsultar);

		dcFecha = new JDateChooser();
		dcFecha.setBounds(10, 43, 123, 20);
		getContentPane().add(dcFecha);

		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 23, 50, 14);
		getContentPane().add(lblFecha);
		
		
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("NRO OP");
		model.addColumn("COD. AVIO");
		model.addColumn("CANT");
		model.addColumn("FECHA");
		table.setModel(model);
		
		arrIngAvio = new ArregloIngresoAvio();
		
		arranque();
		
	}
	//ACTION PERFORMED BOTON CONSULTAR
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		
	}
	
	//METODOS VOID
	
	private void arranque() {
		dcFecha.setDate(new Date());
		cargarTabla();
	}
	
	private void cargarTabla() {
		
		model.setRowCount(0);
		
		for (int i=0;i<arrIngAvio.tama�o();i++) {
			Object[] x = new Object[] {
					arrIngAvio.obtener(i).getNroVale(),
					arrIngAvio.obtener(i).getNroOP(),
					arrIngAvio.obtener(i).getCodAvio(),
					arrIngAvio.obtener(i).getCantAvio(),
					arrIngAvio.obtener(i).getFechaAvio()
					
			};
			
			model.addRow(x);
		}
	}
}