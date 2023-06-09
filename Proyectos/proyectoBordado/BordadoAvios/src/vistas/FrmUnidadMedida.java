package vistas;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import clases.*;
import reuzables.Custom;
import arreglos.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class FrmUnidadMedida extends JFrame implements MouseListener, ActionListener{
	private JTable table;
	private JPanel panelBtnMantener;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblCodUM;
	private JTextField txtCodUM;
	private JTextField txtDesUM;
	private JLabel lblDesUM;
	private DefaultTableModel modelo;
	private ArregloUniMed arrUM ;
	private JScrollPane scrollPane;
	
	public static void main (String[] args) {
		FrmUnidadMedida ventana = new FrmUnidadMedida();
		ventana.setVisible(true);
	}
	
	public FrmUnidadMedida() {
		
		this.setTitle("UNIDAD MEDIDA");
		this.setBounds(0,0,429,326);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(204, 106, 178, 150);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(this);
		
		panelBtnMantener = new JPanel();
		panelBtnMantener.setLayout(null);
		panelBtnMantener.setBackground(SystemColor.activeCaption);
		panelBtnMantener.setBounds(10, 157, 111, 106);
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
		
		lblCodUM = new JLabel("Cod. UM");
		lblCodUM.setBounds(10, 21, 57, 14);
		getContentPane().add(lblCodUM);
		
		txtCodUM = new JTextField();
		txtCodUM.setBounds(10, 41, 86, 20);
		getContentPane().add(txtCodUM);
		txtCodUM.setColumns(10);
		
		txtDesUM = new JTextField();
		txtDesUM.setColumns(10);
		txtDesUM.setBounds(123, 41, 86, 20);
		getContentPane().add(txtDesUM);
		
		lblDesUM = new JLabel("Descripci\u00F3n");
		lblDesUM.setBounds(123, 21, 86, 14);
		getContentPane().add(lblDesUM);
		
		modelo = new DefaultTableModel ();
		modelo.addColumn("COD. UM");
		modelo.addColumn("DESCRIPCION");
		table.setModel(modelo);
		
		arrUM = new ArregloUniMed();
		
		arranque();
		
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
		
		int codUM = leerCodUM();
		String desUM = leerDesUM();
		
		UnidadMedida UM = new UnidadMedida(codUM,desUM);
		
		arrUM.adicionar(UM);
		arrUM.grabarUnidadMedida();
		Custom.mensajeExito(this, "Agregado exitoso");
		listarUM();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
	}
	
	//METODOS DE ENTRADA
	
	private int leerCodUM() {
		int res =-1;
		
		res = Integer.parseInt(txtCodUM.getText().trim());
		
		return res;
	}
	
	private String leerDesUM() {
		String res = null;
		
		res = txtDesUM.getText().trim();
		
		return res;
	}
	
	
	//METODOS ADICIONALES
	
	private void arranque() {
		
	}
	
	private void listarUM() {
		modelo.setRowCount(0);
		
		for(int i=0;i<arrUM.tamano();i++) {
			Object[]x= {
					arrUM.obtener(i).getCodUM(),
					arrUM.obtener(i).getDesUM()
			};
			modelo.addRow(x);
		}
	}
}
