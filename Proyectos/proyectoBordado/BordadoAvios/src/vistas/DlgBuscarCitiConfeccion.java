package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCitiConfeccion;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class DlgBuscarCitiConfeccion extends JDialog implements ActionListener, KeyListener, MouseListener{
	private JTable table;
	private JTextField txtCitiConfeccion;
	private JLabel lblCitiConfeccion;
	private JButton btnElegir;
	private DefaultTableModel model;
	private JScrollPane spTable;
	public static String frame;
	
	private ArregloCitiConfeccion arrCitiConfeccion;
	
	
	public static void main (String[] args) {
		//BuscarOP ventana = new BuscarOP();
		//ventana.setVisible(true);
	}
	
	public DlgBuscarCitiConfeccion(JFrame frame, boolean x) {
		super(frame,x);
		
		this.setTitle("BUSCAR OP");
		this.setBounds(0,0,429,326);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		arrCitiConfeccion = new ArregloCitiConfeccion();
		
		table = new JTable();
		table.addMouseListener(this);
		spTable = new JScrollPane();
		spTable.setBounds(10, 105, 393, 171);
		spTable.setViewportView(table);
		getContentPane().add(spTable);
		
		txtCitiConfeccion = new JTextField();
		txtCitiConfeccion.addKeyListener(this);
		txtCitiConfeccion.setBounds(10, 51, 86, 20);
		getContentPane().add(txtCitiConfeccion);
		txtCitiConfeccion.setColumns(10);
		
		lblCitiConfeccion = new JLabel("CITI CONFECCION");
		lblCitiConfeccion.setBounds(10, 26, 120, 14);
		getContentPane().add(lblCitiConfeccion);
		
		btnElegir = new JButton("Elegir");
		btnElegir.addActionListener(this);
		btnElegir.setBounds(265, 71, 89, 23);
		getContentPane().add(btnElegir);
		
		model = new DefaultTableModel();
		model.addColumn("CITI");
		model.addColumn("DESCRIPCION");
		model.addColumn("ESTADO");
		table.setModel(model);
		
		table.getTableHeader().setBackground(Color.BLACK);
		table.getTableHeader().setForeground(Color.white);
		table.getColumn("CITI").setMaxWidth(50);
		table.getColumn("DESCRIPCION").setMaxWidth(70);
		
		arranque();
		
	}
	//BOTON SELECCIONAR
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnElegir) {
			actionPerformedBtnElegir(e);
		}
	}
	protected void actionPerformedBtnElegir(ActionEvent e) {
		
		exportarCiti();
		
		
		
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
		mostrarCiti();
	}
	//CAJA DE TEXTO DE OP
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtCitiConfeccion) {
			keyReleasedTxtOP(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtOP(KeyEvent e) {
		buscarCiti();
	}
	//METODOS VOID
	
	private void arranque() {
		cargarTabla();
	}
	
	private void cargarTabla() {
		
		model.setRowCount(0);
		
		for(int i=0;i<arrCitiConfeccion.tamaño();i++) {
			
			Object[] x = new Object[] {
					arrCitiConfeccion.obtener(i).getCod_citiConfeccion(),
					arrCitiConfeccion.obtener(i).getDes_citiConfeccion(),
					arrCitiConfeccion.obtener(i).getEstado_citiConfeccion()
			};
			model.addRow(x);
		}
		
	}
	private void buscarCiti() {
		
		String reguex = txtCitiConfeccion.getText().trim();
		
		model.setRowCount(0);
		
		for(int i=0;i<arrCitiConfeccion.tamaño();i++) {
			
			String codCiti = String.valueOf(arrCitiConfeccion.obtener(i).getCod_citiConfeccion());
			
			if(codCiti.startsWith(reguex)) {
				Object[] x = new Object[] {
						arrCitiConfeccion.obtener(i).getCod_citiConfeccion(),
						arrCitiConfeccion.obtener(i).getDes_citiConfeccion(),
						arrCitiConfeccion.obtener(i).getEstado_citiConfeccion()
				};
				model.addRow(x);
			}else {
				
			}	
		}
	}
	
	private void mostrarCiti() {
		
		
		int n = table.getSelectedRow();
		
		String nroOp = table.getValueAt(n, 0).toString();
		
		txtCitiConfeccion.setText(nroOp);
		
		
		
		
	}
	
	private void exportarCiti() {
		switch(frame) {
		case "FrmProgramaAcabado":
			FrmProgramaAcabado.txtCodCitiConfeccion.setText(this.txtCitiConfeccion.getText());
			this.dispose();
			break;
		case "":
			break;
		default:
			
		}
	}
	
	
}	
	
