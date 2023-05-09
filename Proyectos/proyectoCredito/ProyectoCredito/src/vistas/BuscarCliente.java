package vistas;

import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCliente;
import arreglos.ArregloDeuda;
import arreglos.ArregloPago;
import clases.Cliente;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class BuscarCliente extends JFrame implements KeyListener{
	private JTable tbCliente;
	private JScrollPane spCliente;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JButton btnElegir;
	private DefaultTableModel modelCliente;
	
	
	public static void main(String [] args) {
		
		BuscarCliente form = new BuscarCliente();
		form.setVisible(true);
		
	}
	
	public BuscarCliente() {
		
		setTitle("BUSCAR CLIENTE");
		setBounds(100,100,500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(null);
		
		spCliente = new JScrollPane();
		spCliente.setBounds(10, 63, 464, 187);
		getContentPane().add(spCliente);
		
		tbCliente = new JTable();
		spCliente.setViewportView(tbCliente);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(this);
		txtNombre.setBounds(10, 33, 126, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(10, 11, 79, 14);
		getContentPane().add(lblNombre);
		
		btnElegir = new JButton("ELEGIR");
		btnElegir.setBounds(215, 32, 89, 23);
		getContentPane().add(btnElegir);
		
		modelCliente = new DefaultTableModel();
		modelCliente.addColumn("ID");
		modelCliente.addColumn("NOMBRE");
		modelCliente.addColumn("APELLIDO");
		modelCliente.addColumn("DEUDA");
		tbCliente.setModel(modelCliente);
		
		arranque();
		
	}
	
	private void arranque() {
		cargarCliente();
	}
	
	private void cargarCliente() {
		modelCliente.setRowCount(0);
		
		for (int i=0;i<new ArregloCliente().tama�o();i++) {
			
			Cliente obj = new ArregloCliente().obtener(i);
			
			double deudaTotal= new ArregloDeuda().deudaTotal(obj.getId_cliente())-new ArregloPago().pagoTotal(obj.getId_cliente());
			
			Object[]x = new Object[] {
				obj.getId_cliente(),
				obj.getNom_cliente(),
				obj.getApe_cliente(),
				"S/."  + deudaTotal
			};
			
			modelCliente.addRow(x);
		}
		
	}
	
	private void cargarClientePorNombre() {
		modelCliente.setRowCount(0);
		
		for (int i=0;i<new ArregloCliente().tama�o();i++) {
			
			Cliente obj = new ArregloCliente().obtener(i);
			
			String nombreCliente = txtNombre.getText().trim();
			double deudaTotal= new ArregloDeuda().deudaTotal(obj.getId_cliente())-new ArregloPago().pagoTotal(obj.getId_cliente());
			
			if (obj.getNom_cliente().matches("["+nombreCliente+"].*")) {

				Object[]x = new Object[] {
					obj.getId_cliente(),
					obj.getNom_cliente(),
					obj.getApe_cliente(),
					"S/."  + deudaTotal
				};
				
				modelCliente.addRow(x);
			}
			
			/*Object[]x = new Object[] {
				obj.getId_cliente(),
				obj.getNom_cliente(),
				obj.getApe_cliente(),
				"S/."  + deudaTotal
			};
			
			modelCliente.addRow(x);*/
		}
	}
	//LLAVE LIBERADA TXT NOMBRE
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtNombre) {
			keyReleasedTxtNombre(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtNombre(KeyEvent e) {
		
		cargarClientePorNombre();
	}
}
