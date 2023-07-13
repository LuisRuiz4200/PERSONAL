package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import arreglos.ArregloDetPedidoOP;
import arreglos.ArregloF10;
import arreglos.ArregloPedidoOP;
import arreglos.ArregloProgramaAcabado;
import clases.F10;
import clases.PedidoOP;
import clases.ProgramaAcabado;
import reuzables.Custom;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class DlgListaProgramaAcabado extends JDialog implements ActionListener, KeyListener, MouseListener {
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtNroOP;
	private JButton btnElegir;
	private JLabel lblNroOP;
	private DefaultTableModel modelo;
	
	public static String frame ;

	private ArregloProgramaAcabado arrProgramaAcabado = new ArregloProgramaAcabado();

	public static void main(String[] args) {
		DlgListaProgramaAcabado ventana = new DlgListaProgramaAcabado(null, true);
		ventana.setVisible(true);
	}

	public DlgListaProgramaAcabado(JFrame frame, boolean x) {
		super(frame, x);

		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("LISTA DE PROGRAMA ACABADO");
		this.setBounds(0, 0, 709, 400);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 57, 673, 294);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);

		txtNroOP = new JTextField();
		txtNroOP.addKeyListener(this);
		txtNroOP.setBounds(10, 24, 86, 20);
		getContentPane().add(txtNroOP);
		txtNroOP.setColumns(10);

		btnElegir = new JButton("ELEGIR");
		btnElegir.addActionListener(this);
		btnElegir.setBounds(119, 23, 89, 23);
		getContentPane().add(btnElegir);

		lblNroOP = new JLabel("NRO OP");
		lblNroOP.setBounds(10, 11, 68, 14);
		getContentPane().add(lblNroOP);

		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("NRO OP");
		modelo.addColumn("COLOR");
		modelo.addColumn("PEDIDO");
		modelo.addColumn("PROGRAMA");
		modelo.addColumn("CONFECCION");
		modelo.addColumn("ACABADO");
		modelo.addColumn("OBSERVACION");
		modelo.addColumn("REGISTRADO");
		modelo.addColumn("ACTUALIZADO");
		modelo.addColumn("ESTADO");
		table.setModel(modelo);

		table.setAutoResizeMode(0);

		table.getColumn("ID").setPreferredWidth(40);
		table.getColumn("COLOR").setPreferredWidth(200);
		table.getColumn("CONFECCION").setPreferredWidth(100);
		table.getColumn("ACABADO").setPreferredWidth(100);
		table.getColumn("OBSERVACION").setPreferredWidth(200);
		table.getColumn("REGISTRADO").setPreferredWidth(100);
		table.getColumn("ACTUALIZADO").setPreferredWidth(100);
		table.getColumn("ESTADO").setPreferredWidth(100);

		table.setAutoCreateRowSorter(true);

		arranque();

	}

	private void arranque() {
		cargarTabla();
	}

	private void cargarTabla() {

		modelo.setRowCount(0);
		
		for(int i=0;i<arrProgramaAcabado.tamano();i++) {
			
			ProgramaAcabado obj = arrProgramaAcabado.obtener(i);
			
			Object[] x = new Object[] {
					obj.getCod_programaAcabado(),
					obj.getNro_OP(),
					obj.getCod_colorOP(),
					obj.getCantPed_programaAcabado(),
					obj.getCantProg_programaAcabado(),
					obj.getCod_citiConfeccion(),
					obj.getCod_citiAcabado(),
					obj.getObs_programaAcabado(),
					new SimpleDateFormat("dd MMM yyy").format(obj.getFechaReg_programaAcabado()),
					new SimpleDateFormat("dd MMM yyy").format(obj.getFechaAct_programaAcabado()),
					obj.getEstado_programaAcabado()
					
			};
			
			modelo.addRow(x);
		}

	}

	private void filtrarPorOP() {
		
		String nroOP = String.valueOf(leerNroOP());
		
		
		TableRowSorter<TableModel> filtro = new TableRowSorter<TableModel>(modelo);
		filtro.setRowFilter(RowFilter.regexFilter(nroOP, 1));
		
		table.setRowSorter(filtro);
		
	}
	
	private void exportarData() {
		
		int fila = table.getSelectedRow();
		int nroOP = leerNroOP();
		F10 objF10 = new ArregloF10().buscarPorNroOP(nroOP);
		
		switch(frame) {
		case "FrmPedidoOP":
			
			String idProgramaAcabado = table.getValueAt(fila, 0).toString();
			
			FrmPedidoOP.txtCodPrograma.setText(idProgramaAcabado);
			
			this.dispose();
			
			break;
		case "":
			break;
		default:
			break;
		}
		
	}
	
	private void cargarData() {
		int n = table.getSelectedRow();
		
		int nroOP = (int)table.getValueAt(n, 1);
		
		txtNroOP.setText(nroOP + "");
		
	}

	// GETTES

	private int leerNroOP() {
		int res = 0;
		
		try {
			res =  Integer.parseInt(txtNroOP.getText().trim());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return 0;
		}
		
		return res;
	}

	// ACTION LISTENER
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnElegir) {
			actionPerformedBtnElegir(e);
		}
	}

	protected void actionPerformedBtnElegir(ActionEvent e) {
		exportarData();
	}

	public void keyPressed(KeyEvent e) {
	}

	// KEY LISTENER
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtNroOP) {
			keyReleasedTxtNroOP(e);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	protected void keyReleasedTxtNroOP(KeyEvent e) {
		filtrarPorOP();
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
		cargarData();
	}
}
