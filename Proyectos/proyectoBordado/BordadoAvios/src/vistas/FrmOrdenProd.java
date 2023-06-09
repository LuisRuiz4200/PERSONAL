package vistas;

import javax.swing.*;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import clases.*;
import arreglos.*;

@SuppressWarnings("serial")
public class FrmOrdenProd extends JInternalFrame implements ActionListener, MouseListener{
	private JPanel panelBtnMantener;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblNroOP;
	private JTextField txtNroOP;
	private JLabel lblCodCliente;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblCodEstilo;
	private JComboBox<Object> cboCodEstilo;
	private JComboBox<Object> cboCodCliente;
	private DefaultTableModel modelo;
	private ArregloOrdenProduccion arrOP;
	
	
	public static void main (String[] args) {
		FrmOrdenProd ventana = new FrmOrdenProd();
		ventana.setVisible(true);
	}
	
	public FrmOrdenProd() {
		
		this.setTitle("ORDEN DE PRODUCCION");
		this.setBounds(0,0,577,326);
		//this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		this.setLocation(50,50);
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
		
		panelBtnMantener = new JPanel();
		panelBtnMantener.setLayout(null);
		panelBtnMantener.setBackground(SystemColor.activeCaption);
		panelBtnMantener.setBounds(10, 170, 111, 106);
		getContentPane().add(panelBtnMantener);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(10, 11, 89, 23);
		panelBtnMantener.add(btnAgregar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(10, 39, 89, 23);
		panelBtnMantener.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(10, 68, 89, 23);
		panelBtnMantener.add(btnEliminar);
		
		lblNroOP = new JLabel("Nro OP");
		lblNroOP.setBounds(10, 11, 67, 14);
		getContentPane().add(lblNroOP);
		
		txtNroOP = new JTextField();
		txtNroOP.setBounds(10, 27, 86, 20);
		getContentPane().add(txtNroOP);
		txtNroOP.setColumns(10);
		
		lblCodCliente = new JLabel("Cod. Cliente");
		lblCodCliente.setBounds(108, 11, 86, 14);
		getContentPane().add(lblCodCliente);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 59, 398, 217);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		lblCodEstilo = new JLabel("Cod. Estilo");
		lblCodEstilo.setBounds(204, 11, 94, 14);
		getContentPane().add(lblCodEstilo);
		
		cboCodEstilo = new JComboBox<Object>();
		cboCodEstilo.setBounds(204, 26, 199, 22);
		getContentPane().add(cboCodEstilo);
		
		cboCodCliente = new JComboBox<Object>();
		cboCodCliente.setBounds(106, 26, 94, 22);
		getContentPane().add(cboCodCliente);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("NRO OP");
		modelo.addColumn("CLIENTE");
		modelo.addColumn("ESTILO");
		table.setModel(modelo);
		//OPCIONES DE TABLA
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);;
		
		arrOP = new ArregloOrdenProduccion();
		
		arranque();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		
		int nroOP = leerNroOP();
		int codCliente = leerCodCliente();
		int codEstilo = leerCodEstilo();
		
		OrdenProduccion OP = new OrdenProduccion(nroOP,codCliente,codEstilo);
		
		arrOP.adicionar(OP);
		arrOP.grabarOrdenProduccion();
		listarOP();
		
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
	}
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
	}
	
	//METODOS DE ENTRADA
	
	private int leerNroOP() {
		int res =-1;
		
		res = Integer.parseInt(txtNroOP.getText().trim());
		
		return res;
	}
	
	private int leerCodCliente() {
		int res = -1;
		
		res = cboCodCliente.getSelectedIndex()+1;
		
		return res;
	}
	
	private int leerCodEstilo() {
		int res =-1;
		
		res = cboCodEstilo.getSelectedIndex()+1;
		
		return res;
	}
	
	
	
	//METODOS ADICIONALES
	private void arranque() {
		listarOP();
		cargarCliente();
		cargarEstilo();
	}
	
	private void listarOP() {
		//INNER JOIN
		ArregloCliente arrCliente = new ArregloCliente ();
		ArregloEstiloOP arrEstiloOP = new ArregloEstiloOP();
		
		modelo.setRowCount(0);
		
		for(int i=0;i<arrOP.tamano();i++) {
			Object[] x = {
					arrOP.obtener(i).getNroOp(),
					arrCliente.obtener(arrOP.obtener(i).getCodCliente()-1).getDesCliente(),
					arrEstiloOP.obtener(arrOP.obtener(i).getCodEstilo()-1).getDesEstiloOp()
			};
			modelo.addRow(x);
		}
	}
	
	private void cargarCliente() {
		ArregloCliente arrCliente = new ArregloCliente ();
		cboCodCliente.setSelectedIndex(-1);
		for(int i=0;i<arrCliente.tamano();i++) {
			cboCodCliente.addItem(arrCliente.obtener(i).getDesCliente());
		}
	}
	
	private void cargarEstilo() {
		ArregloEstiloOP arrEstiloOP = new ArregloEstiloOP();
		cboCodEstilo.setSelectedIndex(-1);
		for(int i=0;i<arrEstiloOP.tamano();i++) {
			cboCodEstilo.addItem(arrEstiloOP.obtener(i).getDesEstiloOp());
		}
	}
}
