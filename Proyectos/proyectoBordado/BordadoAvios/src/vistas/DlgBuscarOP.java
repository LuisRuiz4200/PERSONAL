package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCliente;
import arreglos.ArregloEstiloOP;
import arreglos.ArregloOrdenProduccion;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class DlgBuscarOP extends JDialog implements ActionListener, KeyListener, MouseListener{
	private JTable table;
	private JTextField txtOP;
	private JLabel lblOP;
	private JButton btnElegir;
	private DefaultTableModel model;
	private JScrollPane spTable;
	public static String frame;
	
	private ArregloOrdenProduccion arrOP;
	
	
	public static void main (String[] args) {
		//BuscarOP ventana = new BuscarOP();
		//ventana.setVisible(true);
	}
	
	public DlgBuscarOP(JFrame frame, boolean x) {
		super(frame,x);
		
		this.setTitle("BUSCAR OP");
		this.setBounds(0,0,429,326);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		arrOP = new ArregloOrdenProduccion();
		
		table = new JTable();
		table.addMouseListener(this);
		spTable = new JScrollPane();
		spTable.setBounds(10, 105, 393, 171);
		spTable.setViewportView(table);
		getContentPane().add(spTable);
		
		txtOP = new JTextField();
		txtOP.addKeyListener(this);
		txtOP.setBounds(10, 51, 86, 20);
		getContentPane().add(txtOP);
		txtOP.setColumns(10);
		
		lblOP = new JLabel("Orden Pedido");
		lblOP.setBounds(10, 26, 86, 14);
		getContentPane().add(lblOP);
		
		btnElegir = new JButton("Elegir");
		btnElegir.addActionListener(this);
		btnElegir.setBounds(265, 71, 89, 23);
		getContentPane().add(btnElegir);
		
		model = new DefaultTableModel();
		model.addColumn("OP");
		model.addColumn("ESTILO");
		model.addColumn("CLIENTE");
		table.setModel(model);
		
		table.getTableHeader().setBackground(Color.BLACK);
		table.getTableHeader().setForeground(Color.white);
		table.getColumn("OP").setMaxWidth(50);
		table.getColumn("CLIENTE").setMaxWidth(70);
		
		arranque();
		
	}
	//BOTON SELECCIONAR
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnElegir) {
			actionPerformedBtnElegir(e);
		}
	}
	protected void actionPerformedBtnElegir(ActionEvent e) {
		
		exportarOP();
		
		
		
	}
	//EVENTOS DE LA TABLA MOUSE CLIKED
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTable(e);
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
	protected void mouseClickedTable(MouseEvent e) {
		mostrarOP();
	}
	//CAJA DE TEXTO DE OP
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtOP) {
			keyReleasedTxtOP(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtOP(KeyEvent e) {
		buscarOP();
	}
	//METODOS VOID
	
	private void arranque() {
		cargarTabla();
	}
	
	private void cargarTabla() {
		
		ArregloEstiloOP arrEstilo = new ArregloEstiloOP();
		ArregloCliente arrCliente = new ArregloCliente();
		
		model.setRowCount(0);
		
		for(int i=0;i<arrOP.tamano();i++) {
			
			Object[] x = new Object[] {
					arrOP.obtener(i).getNroOp(),
					arrEstilo.buscar(arrOP.obtener(i).getCodEstilo()).getDesEstiloOp(),
					arrCliente.buscar(arrOP.obtener(i).getCodCliente()).getDesCliente()
			};
			model.addRow(x);
		}
		
	}
	private void buscarOP() {
		
		ArregloEstiloOP arrEstilo = new ArregloEstiloOP();
		ArregloCliente arrCliente = new ArregloCliente();
		String reguex = txtOP.getText().trim();
		
		model.setRowCount(0);
		
		for(int i=0;i<arrOP.tamano();i++) {
			
			String nroOp = String.valueOf(arrOP.obtener(i).getNroOp());
			
			if(nroOp.startsWith(reguex)) {
				Object[] x = new Object[] {
						arrOP.obtener(i).getNroOp(),
						arrEstilo.buscar(arrOP.obtener(i).getCodEstilo()).getDesEstiloOp(),
						arrCliente.buscar(arrOP.obtener(i).getCodCliente()).getDesCliente()
				};
				model.addRow(x);
			}else {
				
			}	
		}
	}
	
	private void mostrarOP() {
		
		
		int n = table.getSelectedRow();
		
		String nroOp = table.getValueAt(n, 0).toString();
		
		txtOP.setText(nroOp);
		
		
		
		
	}
	
	private void exportarOP() {
		switch(frame) {
		case "FrmProgramaAcabado":
			FrmProgramaAcabado.txtNroOP.setText(this.txtOP.getText());
			this.dispose();
			break;
		case "":
			break;
		default:
			
		}
	}
	
	
}	
	
