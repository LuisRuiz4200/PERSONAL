package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCliente;
import arreglos.ArregloDeuda;
import arreglos.ArregloPago;
import clases.Cliente;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class DlgBuscarCliente extends JFrame implements KeyListener, ActionListener, MouseListener{
	private JTable tbCliente;
	private JScrollPane spCliente;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JButton btnElegir;
	private DefaultTableModel modelCliente;
	public static String frame;
	private JTextField txtIdCliente;
	private JLabel lblIdCliente;
	
	
	public static void main(String [] args) {
		
		DlgBuscarCliente form = new DlgBuscarCliente();
		form.setVisible(true);
		
	}
	
	public DlgBuscarCliente() {
		
		setTitle("BUSCAR CLIENTE");
		setBounds(100,100,500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(null);
		
		spCliente = new JScrollPane();
		spCliente.setBounds(10, 63, 464, 187);
		getContentPane().add(spCliente);
		
		tbCliente = new JTable();
		tbCliente.addMouseListener(this);
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
		btnElegir.addActionListener(this);
		btnElegir.setBounds(373, 29, 89, 23);
		getContentPane().add(btnElegir);
		
		modelCliente = new DefaultTableModel();
		modelCliente.addColumn("ID");
		modelCliente.addColumn("NOMBRE");
		modelCliente.addColumn("APELLIDO");
		modelCliente.addColumn("DEUDA");
		tbCliente.setModel(modelCliente);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(260, 32, 86, 20);
		getContentPane().add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		lblIdCliente = new JLabel("ID CLIENTE");
		lblIdCliente.setBounds(260, 11, 86, 14);
		getContentPane().add(lblIdCliente);
		
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
			
			
			if (nombreCliente.length()==0){
				
				Object[]x = new Object[] {
						obj.getId_cliente(),
						obj.getNom_cliente(),
						obj.getApe_cliente(),
						"S/."  + deudaTotal
				};
			
				modelCliente.addRow(x);
			}else if (obj.getNom_cliente().matches("("+nombreCliente+").*")) {

				Object[]x = new Object[] {
					obj.getId_cliente(),
					obj.getNom_cliente(),
					obj.getApe_cliente(),
					"S/."  + deudaTotal
				};
				
				modelCliente.addRow(x);
			}	
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnElegir) {
			actionPerformedBtnElegir(e);
		}
	}
	//ACTION PERFORMET DEL BOTON ELEGIR
	protected void actionPerformedBtnElegir(ActionEvent e) {
		
		String idCliente = tbCliente.getValueAt(tbCliente.getSelectedRow(),0).toString();
		
		Cliente objCliente = new ArregloCliente().buscar(idCliente);
		
		switch(frame){
		case "FrmDeuda":
			FrmDeuda.cboCliente.setSelectedItem(objCliente.getNom_cliente());
			this.dispose();
			break;
		case "FrmPago":
			FrmPago.cboCliente.setSelectedItem(objCliente.getNom_cliente());
			this.dispose();
			break;
		default:
			
		}
		
		
	}
	
	//MOUSE CLIKED DE LA TABLA CLIENTE
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbCliente) {
			mouseClickedTbCliente(e);
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
	protected void mouseClickedTbCliente(MouseEvent e) {
		String idCliente = tbCliente.getValueAt(tbCliente.getSelectedRow(),0).toString();
		String nomCliente = tbCliente.getValueAt(tbCliente.getSelectedRow(),1).toString();
		
		txtIdCliente.setText(idCliente);
		txtNombre.setText(nomCliente);
	}
}