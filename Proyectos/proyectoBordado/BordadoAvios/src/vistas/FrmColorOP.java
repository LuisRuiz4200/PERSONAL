package vistas;

import javax.swing.*;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import clases.*;
import arreglos.*;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class FrmColorOP extends JFrame implements ActionListener, MouseListener{
	private JLabel lblNroOP;
	private JComboBox <Object> cboNroOP;
	private JLabel lblDesColorOP;
	private JTextField txtDesColorOP;
	private JTextField txtCodColorOP;
	private JLabel lblCodColorOP;
	private JPanel panelBtnMantener;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private ArregloColorOP arrColorOP;
	
	public static void main (String[] args) {
		FrmColorOP ventana = new FrmColorOP();
		ventana.setVisible(true);
	}
	
	public FrmColorOP() {
		
		this.setTitle("COLOR DE OP");
		this.setBounds(0,0,429,326);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		lblNroOP = new JLabel("Nro OP");
		lblNroOP.setBounds(10, 11, 46, 14);
		getContentPane().add(lblNroOP);
		
		cboNroOP = new JComboBox<Object>();
		cboNroOP.setBounds(10, 28, 97, 22);
		getContentPane().add(cboNroOP);
		
		lblDesColorOP = new JLabel("Descripcion");
		lblDesColorOP.setBounds(10, 61, 97, 14);
		getContentPane().add(lblDesColorOP);
		
		txtDesColorOP = new JTextField();
		txtDesColorOP.setBounds(10, 80, 132, 20);
		getContentPane().add(txtDesColorOP);
		txtDesColorOP.setColumns(10);
		
		txtCodColorOP = new JTextField();
		txtCodColorOP.setColumns(10);
		txtCodColorOP.setBounds(117, 30, 86, 20);
		getContentPane().add(txtCodColorOP);
		
		lblCodColorOP = new JLabel("Cod. Color");
		lblCodColorOP.setBounds(117, 11, 86, 14);
		getContentPane().add(lblCodColorOP);
		
		panelBtnMantener = new JPanel();
		panelBtnMantener.setLayout(null);
		panelBtnMantener.setBackground(SystemColor.activeCaption);
		panelBtnMantener.setBounds(10, 158, 111, 106);
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(175, 80, 191, 196);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("NRO OP");
		modelo.addColumn("COD. COLOR");
		modelo.addColumn("DESCRIPCION");
		table.setModel(modelo);
		
		//TABLA PERSONALIZADA
		table.setAutoResizeMode(0);
		
		arrColorOP = new ArregloColorOP();
		
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
		
		int nroOP= leerNroOP();
		int codColorOP = leerCodColorOP();
		String desColorOP = leerDesColorOP();
		
		ColorOP colorOP = new ColorOP (nroOP, codColorOP, desColorOP);
		
		arrColorOP.adicionar(colorOP);
		arrColorOP.grabarColorOP();
		listarColorOP();
		
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
		int res= -1;
		
		res = Integer.parseInt(cboNroOP.getSelectedItem().toString());
		
		return res;
	}
	
	private int leerCodColorOP() {
		int res=-1;
		
		res = Integer.parseInt(txtCodColorOP.getText().trim());
		
		return res;
	}
	
	private String leerDesColorOP() {
		String res = null;
		
		res = txtDesColorOP.getText().trim();
		
		return res;
	}
	
	//METODOS BASISCOS
	
	private void arranque() {
		listarColorOP();
		cargarNroOP();
	}
	
	private void listarColorOP() {
		modelo.setRowCount(0);
		
		for (int i=0; i<arrColorOP.tamano();i++) {
			Object[] x = {
					arrColorOP.obtener(i).getNroOP(),
					arrColorOP.obtener(i).getCodColorOP(),
					arrColorOP.obtener(i).getDesColorOP()
			};
			
			modelo.addRow(x);
		}
	}
	
	private void cargarNroOP() {
		
		ArregloOrdenProduccion arrOP = new ArregloOrdenProduccion();
		
		cboNroOP.setSelectedIndex(-1);
		
		for(int i=0;i<arrOP.tamano();i++) {
			cboNroOP.addItem(arrOP.obtener(i).getNroOp());
		}
		
		
	}
	
}
