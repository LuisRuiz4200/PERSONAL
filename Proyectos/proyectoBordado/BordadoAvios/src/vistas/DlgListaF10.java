package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloF10;
import clases.F10;

@SuppressWarnings("serial")
public class DlgListaF10 extends JDialog implements KeyListener,ActionListener,MouseListener{
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private ArregloF10 arrF10 = new ArregloF10();
	private JTextField txtNroOP;
	private JLabel lblNroOP;
	public static String frame;
	private JButton btnElegir;
	private JButton btnEditar;
	private JButton btnAgregar;
	
	public static void main (String[] args) {
	}
	
	public DlgListaF10(JFrame frame, boolean bandera) {
		super(frame,bandera);
		this.setTitle("LISTA DE F10");
		this.setBounds(0,0,625,326);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 589, 203);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("OP");
		modelo.addColumn("CLIENTE");
		modelo.addColumn("ESTILO");
		modelo.addColumn("PRENDA");
		modelo.addColumn("COLOR");
		table.setModel(modelo);
		
		table.getColumn("ID").setPreferredWidth(40);
		table.getColumn("OP").setPreferredWidth(40);
		table.getColumn("CLIENTE").setPreferredWidth(70);
		table.getColumn("ESTILO").setPreferredWidth(200);
		table.getColumn("PRENDA").setPreferredWidth(100);
		table.getColumn("COLOR").setPreferredWidth(200);
		
		table.setAutoResizeMode(0);
		table.setAutoCreateRowSorter(true);
		
		txtNroOP = new JTextField();
		txtNroOP.setBounds(10, 39, 86, 20);
		getContentPane().add(txtNroOP);
		txtNroOP.addKeyListener(this);
		txtNroOP.setColumns(10);
		
		lblNroOP = new JLabel("NRO OP");
		lblNroOP.setBounds(10, 14, 59, 14);
		getContentPane().add(lblNroOP);
		
		btnElegir = new JButton("ELEGIR");
		btnElegir.setBounds(124, 38, 89, 23);
		btnElegir.addActionListener(this);
		getContentPane().add(btnElegir);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(357, 40, 89, 23);
		getContentPane().add(btnEditar);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(456, 40, 89, 23);
		getContentPane().add(btnAgregar);
		
		arranque();
	}
	
	//METODOS VOID
	private void arranque() {
		cargarTablaF10();
	}
	
	
	private void cargarTablaF10() {
		modelo.setRowCount(0);
		
		for(int i=0; i<arrF10.tamano();i++) {
			Object[] x = new Object[] {
				arrF10.obtener(i).getId_F10(),
				arrF10.obtener(i).getNroOP_F10(),
				arrF10.obtener(i).getCliente_F10(),
				arrF10.obtener(i).getEstilo_F10(),
				arrF10.obtener(i).getPrenda_F10(),
				arrF10.obtener(i).getColor_F10()
			};
			
			modelo.addRow(x);
		}
		
	}
	
	private void filtrarListaF10PorOP() {
		modelo.setRowCount(0);
		
		for(int i=0; i<arrF10.tamano();i++) {
			
			String nroOP = String.valueOf(arrF10.obtener(i).getNroOP_F10());
			
			if(nroOP.startsWith(txtNroOP.getText())) {
				Object[] x = new Object[] {
						arrF10.obtener(i).getId_F10(),
						arrF10.obtener(i).getNroOP_F10(),
						arrF10.obtener(i).getCliente_F10(),
						arrF10.obtener(i).getEstilo_F10(),
						arrF10.obtener(i).getPrenda_F10(),
						arrF10.obtener(i).getColor_F10()
					};
					
					modelo.addRow(x);
			}
		}
	}
	
	private void exportarData() {
		
		int id =(int) table.getValueAt(table.getSelectedRow(), 0);
		F10 objF10 = arrF10.buscar(id);
		
		switch(frame) {
		case "FrmProgramaAcabado":
			FrmProgramaAcabado.txtNroOP.setText(objF10.getNroOP_F10()+"");
			FrmProgramaAcabado.txtColorOP.setText(objF10.getColor_F10());
			FrmProgramaAcabado.txtEstiloOP.setText(objF10.getEstilo_F10());
			FrmProgramaAcabado.txtPrendaOP.setText(objF10.getPrenda_F10());
			FrmProgramaAcabado.txtIdF10.setText(objF10.getId_F10()+"");
			FrmProgramaAcabado.txtClienteOP.setText(objF10.getCliente_F10());
			
			this.dispose();
			
			break;
		}
	}
	
	//KEY LISTENER
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == txtNroOP) {
			keyReleasedTxtNroOP(e);
		}
	}

	private void keyReleasedTxtNroOP(KeyEvent e) {
		// TODO Auto-generated method stub
		filtrarListaF10PorOP();
		
	}
	
	//Action Performed

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		// TODO Auto-generated method stub
		if(e.getSource()==btnElegir) {
			actionPerformedBtnElegir(e);
		}
		
	}

	private void actionPerformedBtnElegir(ActionEvent e) {
		// TODO Auto-generated method stub
		exportarData();
	}
	
	//Mouse Event
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table) {
			mouseClickedTable(e);
		}
	}

	private void mouseClickedTable(MouseEvent e) {
		// TODO Auto-generated method stub
		int n = table.getSelectedRow();
		String nroOPString = table.getValueAt(n, 1).toString();
		txtNroOP.setText(nroOPString);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	protected void actionPerformedBtnEditar(ActionEvent e) {
		
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		FrmF10 frame = new FrmF10();
		this.dispose();
		frame.setVisible(true);
		frame.toFront();
	}
}
