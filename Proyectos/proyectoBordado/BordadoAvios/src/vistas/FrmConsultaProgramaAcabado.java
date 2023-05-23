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
import java.util.Date;
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
	private JPanel panelProgramaAcabado;
	private JTextField txtColor;
	private JTextField txtAcabado;
	private JTextArea txtObsPrograma;
	private JTextField txtIdPrograma;
	private JLabel lblColor;
	private JLabel lblAcabado;
	private JLabel lblObsPrograma;
	private JLabel lblIdPrograma;
	private JTextField txtEstado;
	private JTextField txtFechaActualizada;
	
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
		scrollPane.setBounds(10, 120, 843, 297);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
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
		
		btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(this);
		btnEditar.setBounds(657, 86, 89, 23);
		getContentPane().add(btnEditar);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(764, 86, 89, 23);
		getContentPane().add(btnAgregar);
		
		table.getColumn("ID").setPreferredWidth(40);
		table.getColumn("COLOR").setPreferredWidth(200);
		table.getColumn("CONFECCION").setPreferredWidth(100);
		table.getColumn("ACABADO").setPreferredWidth(100);
		table.getColumn("OBSERVACION").setPreferredWidth(200);
		table.getColumn("REGISTRADO").setPreferredWidth(100);
		table.getColumn("ACTUALIZADO").setPreferredWidth(100);
		table.getColumn("ESTADO").setPreferredWidth(100);
		
		table.setAutoCreateRowSorter(true);
		
		panelProgramaAcabado = new JPanel();
		panelProgramaAcabado.setBounds(10, 11, 592, 99);
		getContentPane().add(panelProgramaAcabado);
		panelProgramaAcabado.setLayout(null);
		
		txtColor = new JTextField();
		txtColor.setBounds(106, 25, 86, 20);
		panelProgramaAcabado.add(txtColor);
		txtColor.setColumns(10);
		
		txtAcabado = new JTextField();
		txtAcabado.setColumns(10);
		txtAcabado.setBounds(202, 25, 86, 20);
		panelProgramaAcabado.add(txtAcabado);
		
		txtObsPrograma = new JTextArea();
		txtObsPrograma.setBounds(324, 25, 258, 63);
		panelProgramaAcabado.add(txtObsPrograma);
		
		txtIdPrograma = new JTextField();
		txtIdPrograma.setBounds(10, 68, 57, 20);
		panelProgramaAcabado.add(txtIdPrograma);
		txtIdPrograma.setColumns(10);
		
		txtNroOP = new JTextField();
		txtNroOP.setBounds(10, 25, 86, 20);
		panelProgramaAcabado.add(txtNroOP);
		txtNroOP.addKeyListener(this);
		txtNroOP.setColumns(10);
		
		lblNroOP = new JLabel("NRO OP");
		lblNroOP.setBounds(10, 12, 72, 14);
		panelProgramaAcabado.add(lblNroOP);
		
		lblColor = new JLabel("COLOR");
		lblColor.setBounds(106, 12, 72, 14);
		panelProgramaAcabado.add(lblColor);
		
		lblAcabado = new JLabel("ACABADO");
		lblAcabado.setBounds(202, 12, 72, 14);
		panelProgramaAcabado.add(lblAcabado);
		
		lblObsPrograma = new JLabel("PROGRAMA");
		lblObsPrograma.setBounds(324, 12, 72, 14);
		panelProgramaAcabado.add(lblObsPrograma);
		
		lblIdPrograma = new JLabel("ID");
		lblIdPrograma.setBounds(10, 53, 72, 14);
		panelProgramaAcabado.add(lblIdPrograma);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(767, 11, 86, 20);
		getContentPane().add(txtEstado);
		
		txtFechaActualizada = new JTextField();
		txtFechaActualizada.setColumns(10);
		txtFechaActualizada.setBounds(660, 11, 86, 20);
		getContentPane().add(txtFechaActualizada);
		
		arranque();
	}

	//METODOS VOID
	private void arranque() {
		listarProgramaAcabado();
		limpiar();
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
					new SimpleDateFormat("dd MMM yyy").format(obj.getFechaReg_programaAcabado()),
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
	
	private void limpiar() {
		txtIdPrograma.setText("");
		txtNroOP.setText("");
		txtColor.setText("");
		txtAcabado.setText("");
		txtObsPrograma.setText("");
		txtEstado.setText("");
		txtFechaActualizada.setText("");
		
		txtIdPrograma.setEditable(false);
		txtColor.setEditable(false);
		txtAcabado.setEditable(false);
		txtObsPrograma.setEditable(false);
		txtEstado.setEditable(false);
		txtFechaActualizada.setEditable(false);
	}
	
	private void mostrarPrograma() {
		int n = table.getSelectedRow();
		
		String nroOP = table.getValueAt(n, 1).toString();
		int idPrograma = arrProgramaAcabado.buscar((int)table.getValueAt(n, 0)).getCod_programaAcabado();
		String color = arrProgramaAcabado.buscar((int)table.getValueAt(n, 0)).getCod_colorOP();
		String acabado = arrProgramaAcabado.buscar((int)table.getValueAt(n, 0)).getCod_citiAcabado();
		String obsPrograma = arrProgramaAcabado.buscar((int)table.getValueAt(n, 0)).getObs_programaAcabado();
		String estado = arrProgramaAcabado.buscar((int)table.getValueAt(n, 0)).getEstado_programaAcabado();
		Date fechaActualizada = arrProgramaAcabado.buscar((int)table.getValueAt(n, 0)).getFechaAct_programaAcabado();
		
		
		txtIdPrograma.setText(idPrograma + "");
		txtNroOP.setText(nroOP);
		txtColor.setText(color);
		txtAcabado.setText(acabado);
		txtObsPrograma.setText(obsPrograma);
		txtEstado.setText(estado);
		txtFechaActualizada.setText(new SimpleDateFormat("dd MMM yyy").format(fechaActualizada));
		
		
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
		mostrarPrograma();
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
		
		int id = (int) table.getValueAt(n, 0);
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
		
		//RETORNAMOS EL ID DEL DOCUMENTO
		FrmProgramaAcabado.txtCodPrograma.setText(id+"");
		
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
		FrmProgramaAcabado.btnEliminar.setEnabled(true);
		
		this.dispose();
		
	}
}
