package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Color;
import java.awt.Component;

import javax.swing.table.TableCellRenderer;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.*;
import clases.NroOp;
import clases.OrdenP;
import javax.swing.JComboBox;


@SuppressWarnings({ "serial", "unused" })
public class DlgOrdenes extends JInternalFrame implements ActionListener, MouseListener,TableCellRenderer {

	private Container contentPanel;
	private JTextField txtNroOp;
	private JTextField txtColor;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private DefaultTableModel modelo;
	private JLabel lblNroOp ;
	private JLabel lblColor ;
	private JLabel lblCliente ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgOrdenes dialog = new DlgOrdenes();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	/**
	 * Create the dialog.
	 */
	public DlgOrdenes() {
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		setTitle("Detalle de OP");
		setBounds(100, 100, 670, 298);
		
		contentPanel= this.getContentPane();
		getContentPane().setLayout(null);
		
		lblNroOp = new JLabel("Nro Op:");
		lblNroOp.setBounds(10, 22, 45, 13);
		contentPanel.add(lblNroOp);

		lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 45, 45, 13);
		contentPanel.add(lblColor);
	
		lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 71, 45, 13);
		contentPanel.add(lblCliente);
	
		txtNroOp = new JTextField();
		txtNroOp.setBounds(83, 19, 75, 19);
		contentPanel.add(txtNroOp);
		txtNroOp.setColumns(10);
	
		txtColor = new JTextField();
		txtColor.setBounds(83, 42, 186, 19);
		contentPanel.add(txtColor);
		txtColor.setColumns(10);
	
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 111, 102, 21);
		contentPanel.add(btnAdicionar);
	
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(10, 142, 102, 21);
		contentPanel.add(btnModificar);
	
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(10, 173, 102, 21);
		contentPanel.add(btnEliminar);
	
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(68, 217, 85, 21);
		contentPanel.add(btnGrabar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(163, 217, 85, 21);
		contentPanel.add(btnCancelar);	
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(308, 20, 338, 231);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		
		scrollPane.setViewportView(table);
		
		modelo= new DefaultTableModel();
		modelo.addColumn("NRO. OP");
		modelo.addColumn("COLOR");
		modelo.addColumn("CLIENTE");
		table.setModel(modelo);
		
		cboCliente = new JComboBox <String>();
		cboCliente.addActionListener(this);
		cboCliente.setBounds(83, 67, 104, 21);
		contentPanel.add(cboCliente);
		
		//arranques
		botonesActivos(false);
		arranque();
		listar();
	}
	
	//variable global 
	
	ArregloOrdenes ao=new ArregloOrdenes();
	ArregloNroOp op= new ArregloNroOp();
	int posicion=-1;
	private JComboBox <String> cboCliente;
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboCliente) {
			actionPerformedCboCliente(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
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
		consultar();
	}
	
	//acciones
	protected void actionPerformedCboCliente(ActionEvent e) {
		
		
		
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		posicion=0;
		botonesActivos(true);
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		posicion=1;
		botonesActivos(true);
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		int nroOp=leerNroOp();
		String color=leerColor();
		OrdenP x=ao.buscar(nroOp,color);
		
		try {
			if(restringido("contraseña").equals("luis")) {
				if(x!=null) {
					ao.eliminar(x);
				}else {
					mensaje ("op no encontrada!");
				}
			}else {
				mensaje("contraseña incorrecta");
			}
		}
		catch(Exception el){
			mensaje("Operacion cancelada");
		}
		

		listar();
		ao.grabarOrdenes();
		agregarOp();
	}
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		
		try {
			
			int nroOp=leerNroOp();

			String color=leerColor();
			String cliente=leerCboCliente();
			
			OrdenP x=ao.buscar(nroOp,color);
			NroOp y=op.buscar(nroOp);
			
			if(posicion==0) {
				
				if(x==null) {
					OrdenP o=new OrdenP(nroOp,color,cliente);
					ao.adicionar(o);
					if(y==null) {
						NroOp n= new NroOp(nroOp);
						op.adicionar(n);
					}else {
						
					}
					
				}else {
					mensaje("nro op y color ya existen !!");
				}
				
			} 
			
			if(posicion==1) {
				if(x!=null) {
					x.setNroOp(nroOp);
					x.setColor(color);
					x.setCliente(cliente);
				}else {
					mensaje ("op no encontrado");
				}
			}
		}
		catch (Exception el) {
			mensaje("Valores invalidos!");
		}
		
		
		listar();
		ao.grabarOrdenes();
		agregarOp();
		botonesActivos(false);
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		botonesActivos(false);
	}
	
	//metodos get
	public int leerNroOp() {
		return Integer.parseInt(txtNroOp.getText());
	}
	public String leerColor() {
		return txtColor.getText();
	}
	
	public String restringido(String s) {
		return JOptionPane.showInputDialog(this,s);
	}
	public String leerCboCliente() {
		return cboCliente.getSelectedItem().toString();
	}
	
	//metodos void 
	public void mensaje(String s) {
		JOptionPane.showMessageDialog(this,s);
	}
	
	public void listar() {
		
		OrdenP o;
		
		modelo.setRowCount(0);
		for(int i=0;i<ao.tamaño();i++) {
			o=ao.obtener(i);
			Object [] fila= {
				o.getNroOp(),
				o.getColor(),
				o.getCliente()
			};
			modelo.addRow(fila);
		}
	}
	public void consultar() {
		OrdenP o=ao.obtener(table.getSelectedRow());
		
		txtNroOp.setText(""+o.getNroOp());
		txtColor.setText(o.getColor());
		cboCliente.setSelectedItem(o.getCliente());
	}
	public void botonesActivos(boolean b) {
		btnGrabar.setEnabled(b);
		btnCancelar.setEnabled(b);
		btnAdicionar.setEnabled(!b);
		btnModificar.setEnabled(!b);
		btnEliminar.setEnabled(!b);
	}
	
	public void llenarCboCliente() {
		
		ArregloCliente ac= new ArregloCliente();
		
		for(int i=0;i<ac.tamaño();i++) {
			cboCliente.addItem(ac.obtener(i).getNombreCli());
		}
	}
	
	public void arranque() {
		llenarCboCliente();
		cuadrosActivos(false);
		agregarOp();
	}
	
	public void cuadrosActivos(boolean x) {
	}
	
	public void agregarOp() {
		
		ArregloNroOp op= new ArregloNroOp();
		
		for (int i=0;i<op.tamaño();i++) {
			NroOp x= op.obtener(i);
			op.eliminar(x);
		}
		
		for(int i=0;i<ao.tamaño();i++) {
			int nroOp= ao.obtener(i).getNroOp();
			if(op.buscar(nroOp)==null) {
				op.adicionar(new NroOp(nroOp));
			}
		}
		
		op.grabarNroOp();
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JComponent jcomponent = null;
		
		if(value instanceof String) {
			jcomponent=new JLabel((String)value);
			((JLabel)jcomponent).setHorizontalAlignment(SwingConstants.CENTER);
		}
		jcomponent.setBackground(new Color(65,65,65));
		return jcomponent;
	}
	
}
