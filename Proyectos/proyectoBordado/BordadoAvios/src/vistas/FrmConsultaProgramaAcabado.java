package vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloColorOP;
import arreglos.ArregloF10;
import arreglos.ArregloProgramaAcabado;
import clases.ColorOP;
import clases.F10;
import clases.ProgramaAcabado;
import reuzables.Custom;

import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmConsultaProgramaAcabado extends JInternalFrame implements KeyListener, MouseListener, ActionListener{
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtNroOP;
	private JLabel lblNroOP;
	private DefaultTableModel modelo;
	private ArregloProgramaAcabado arrProgramaAcabado = new ArregloProgramaAcabado();
	private JButton btnEditar;
	private JButton btnAgregar;
	
	public static void main (String[] args) {
		FrmConsultaProgramaAcabado ventana = new FrmConsultaProgramaAcabado();
		ventana.setVisible(true);
	}
	
	public FrmConsultaProgramaAcabado() {
		
		this.setTitle("CONSULTA DEL PROGRAMA DE ACABADOS");
		this.setBounds(0,0,879,467);
		//this.setLocationRelativeTo(this);
		
		this.setClosable(true);
		this.setIconifiable(true);
		this.setMaximizable(true);
		
		this.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 843, 329);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		txtNroOP = new JTextField();
		txtNroOP.addKeyListener(this);
		txtNroOP.setBounds(10, 45, 86, 20);
		getContentPane().add(txtNroOP);
		txtNroOP.setColumns(10);
		
		lblNroOP = new JLabel("NRO OP");
		lblNroOP.setBounds(10, 21, 72, 14);
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
		modelo.addColumn("ACTUALIZADO");
		modelo.addColumn("ESTADO");
		table.setModel(modelo);
		
		table.setAutoResizeMode(0);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(165, 44, 89, 23);
		getContentPane().add(btnEditar);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(272, 44, 89, 23);
		getContentPane().add(btnAgregar);
		
		table.getColumn("ID").setPreferredWidth(40);
		table.getColumn("COLOR").setPreferredWidth(200);
		table.getColumn("CONFECCION").setPreferredWidth(100);
		table.getColumn("ACABADO").setPreferredWidth(100);
		table.getColumn("OBSERVACION").setPreferredWidth(200);
		table.getColumn("ACTUALIZADO").setPreferredWidth(100);
		table.getColumn("ESTADO").setPreferredWidth(100);
		
		table.setAutoCreateRowSorter(true);
		
		arranque();
	}

	//METODOS VOID
	private void arranque() {
		listarProgramaAcabado();
	}
	
	private void listarProgramaAcabado() {
		
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
					new SimpleDateFormat("dd MMM yyy").format(obj.getFechaAct_programaAcabado()),
					obj.getEstado_programaAcabado()
					
			};
			
			modelo.addRow(x);
		}
		
	}
	
	private void filtrarOP() {
		
		modelo.setRowCount(0);
		
		for(int i=0;i<arrProgramaAcabado.tamano();i++) {

			ProgramaAcabado obj = arrProgramaAcabado.obtener(i);
			
			if (String.valueOf(obj.getNro_OP()).startsWith(txtNroOP.getText().trim())) {
				
				Object[] x = new Object[] {
						obj.getCod_programaAcabado(),
						obj.getNro_OP(),
						obj.getCod_colorOP(),
						obj.getCantPed_programaAcabado(),
						obj.getCantProg_programaAcabado(),
						obj.getCod_citiConfeccion(),
						obj.getCod_citiAcabado(),
						obj.getObs_programaAcabado(),
						new SimpleDateFormat("dd MMM yyy").format(obj.getFechaAct_programaAcabado()),
						obj.getEstado_programaAcabado()
				};
				
				modelo.addRow(x);
			}else {
				
			}
			
		}	
	}
	
	private void cargarPrograma() {
		int n = table.getSelectedRow();
		
		String nroOP = table.getValueAt(n, 1).toString();
		
		txtNroOP.setText(nroOP);
	}
	
	
	//KEY RELEASED (LLAVE LIBERADA) PARA TXT_NRO_OP
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtNroOP) {
			keyReleasedTxtNroOP(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtNroOP(KeyEvent e) {
		filtrarOP();
	}
	
	//MOUSE CLIKED
	
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
		cargarPrograma();
	}
	//ACTION PERFORMED
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		if(e.getSource()== btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	private void actionPerformedBtnAgregar(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmProgramaAcabado frame = new FrmProgramaAcabado();
		frame.setVisible(true);
		frame.setLocation(40,40);
		frame.toFront();
		this.dispose();
		FrmPrincipal.escritorio.add(frame);
		
	}

	protected void actionPerformedBtnEditar(ActionEvent e) {
		
		int n = table.getSelectedRow();
		
		if(n==-1) {
			Custom.mensajeAdvertencia(this, "ELIGA UNA FILA DE LA TABLA");
			return;
		}
		
		int nroOP = (int)table.getValueAt(n, 1);
		String colorOP = (String)table.getValueAt(n, 2);
		String confeccion = (String)table.getValueAt(n, 5);
		String acabado = (String)table.getValueAt(n, 6);
		
		ArregloF10 arrF10 = new ArregloF10();
		F10 objF10 = arrF10.buscarPorNroOPYColorOP(nroOP,colorOP);
		
		//INICIALIZACION DE LA NUEVA VENTANA
		FrmProgramaAcabado frame = new FrmProgramaAcabado();
		frame.setVisible(true);
		frame.setLocation(40,40);
		FrmPrincipal.escritorio.add(frame);
		
		//PANEL ORDEN DE PRODUCCION
		FrmProgramaAcabado.txtNroOP.setText(objF10.getNroOP_F10()+"");
		FrmProgramaAcabado.txtClienteOP.setText(objF10.getCliente_F10());
		FrmProgramaAcabado.txtEstiloOP.setText(objF10.getEstilo_F10());
		FrmProgramaAcabado.txtColorOP.setText(objF10.getColor_F10());
		FrmProgramaAcabado.txtPrendaOP.setText(objF10.getPrenda_F10());
		FrmProgramaAcabado.txtIdF10.setText(objF10.getId_F10()+"");
		
		//PANEL CONFECCION Y ACABADO
		FrmProgramaAcabado.txtCodCitiConfeccion.setText(confeccion);
		FrmProgramaAcabado.txtCodCitiAcabado.setText(acabado);
		
		//BOTONES DE FUNCION
		FrmProgramaAcabado.btnGrabar.setEnabled(false);
		FrmProgramaAcabado.btnEditar.setEnabled(true);
		FrmProgramaAcabado.txtNroOP.setEditable(false);
		
		this.dispose();
		
	}
}
