package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import arreglo.ArregloPersona;
import modelo.Persona;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class DlgBuscarPersona extends JDialog implements ActionListener, MouseListener{
	
	private ArregloPersona arrpersona = new ArregloPersona();
	
	public static String frame ;
	
	private JPanel panel;
	private JPanel panelConsultapersona;
	private JTextField txtFiltro;
	private JComboBox<Object> cboFiltro;
	private JLabel lblFiltrar;
	private JTable table;
	private JScrollPane spTable;
	private JButton btnElegir;
	
	public static void main(String [] args) {
		
		DlgBuscarPersona form = new DlgBuscarPersona(null,true);
		form.setVisible(true);
		
	}
	
	public DlgBuscarPersona(JFrame frame, boolean x) {
		super(frame,x);
		
		setTitle("BUSCAR persona - " + this.frame);
		setSize(590,300);
		this.setLocationRelativeTo(frame);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);
		
		panelConsultapersona = new JPanel();
		panelConsultapersona.setLayout(null);
		panelConsultapersona.setBounds(10, 11, 542, 222);
		panel.add(panelConsultapersona);
		
		txtFiltro = new JTextField();
		txtFiltro.setColumns(10);
		txtFiltro.setBounds(138, 26, 134, 20);
		panelConsultapersona.add(txtFiltro);
		
		cboFiltro = new JComboBox<Object>();
		cboFiltro.setBounds(10, 24, 118, 22);
		panelConsultapersona.add(cboFiltro);
		
		lblFiltrar = new JLabel("FILTRAR POR");
		lblFiltrar.setBounds(10, 11, 106, 14);
		panelConsultapersona.add(lblFiltrar);
		
		spTable = new JScrollPane();
		spTable.setBounds(10, 57, 512, 150);
		panelConsultapersona.add(spTable);
		
		table = new JTable();
		table.addMouseListener(this);
		spTable.setViewportView(table);
		
		btnElegir = new JButton("ELEGIR");
		btnElegir.addActionListener(this);
		btnElegir.setBounds(282, 25, 89, 23);
		panelConsultapersona.add(btnElegir);
		
		
		
		arranque();
		
	}
	
	private void arranque() {
		listar();
		cargarCboFiltro();
	}
	
	private void listar() {
		
		Object[] cabecera = new Object[] {"ID","NOMBRE","APELLIDO","DNI","ESTADO"};

		DefaultTableModel modelo = new DefaultTableModel(cabecera,0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		
		for (Persona obj : arrpersona.listar()) {
			Object[] cuerpo = new Object[] {
				obj.getId_persona(),
				obj.getNom_persona(),
				obj.getApe_persona(),
				obj.getDni_persona(),
				obj.getEstado_persona()
			};
			
			modelo.addRow(cuerpo);
		}
		
		table.setModel(modelo);
		
	}
	
	private void cargarCboFiltro() {
		
		cboFiltro.setSelectedIndex(-1);
		
		for (int i=0;i<table.getColumnCount();i++) {
			cboFiltro.addItem(table.getColumnName(i));
		}
	}
	
	private void importarData() {
		
		int fila = table.getSelectedRow();
		int id =(int) table.getValueAt(fila, 0);
		
		switch(frame) {
		case "FrmDeuda/Persona/Prestatario":
			FrmDeuda.txtIdPrestatario.setText(id+"");
			this.dispose();
			break;
		case "FrmDeuda/Persona/Prestamista":
			FrmDeuda.txtIdPrestamista.setText(id+"");
			this.dispose();
			break;
		case "FrmPago/Persona/Prestatario":
			FrmPago.txtIdPrestatario.setText(id + "");
			this.dispose();
			break;
		default:
			break;
		}
	}
	
	
	
	//ACTION LISTENER
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnElegir) {
			actionPerformedBtnElegir(e);
		}
	}
	protected void actionPerformedBtnElegir(ActionEvent e) {
		importarData();
	}
	
	//MOUSE LISTENER
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
		
		
		int fila = table.getSelectedRow();
		int columna = cboFiltro.getSelectedIndex();
		String filtro = table.getValueAt(fila, columna).toString();
		
		txtFiltro.setText(filtro);
	}
}
