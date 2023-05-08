package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloColaborador;
import clases.Colaborador;

@SuppressWarnings("serial")
public class DlgColaborador extends JInternalFrame implements ActionListener, MouseListener{
	
	Container c;
	
	private JComboBox<Object> cboTipo;
	private JLabel lblTipo;
	private JTextField txtTipo;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnAdicionar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private JScrollPane spS;
	private JTable table;
	private DefaultTableModel modelo;
	private int posicion=-1;
	
	//instancia al arreglo colaborador
	ArregloColaborador col= new ArregloColaborador();
	
	
	
	
	public static void main(String [] arg) {
		DlgColaborador dlgColaborador= new DlgColaborador();
		dlgColaborador.setVisible(true);
	}
	public DlgColaborador() {
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		setBounds(100,100,600,300);
		setTitle("Colaborador");
		
		c=this.getContentPane();
		c.setLayout(null);
		
		lblCodigo = new JLabel ("Codigo :");
		lblCodigo.setBounds(23,20,80,20);
		c.add(lblCodigo);
		
		txtCodigo= new JTextField();
		txtCodigo.setBounds(103,20,80,20);
		c.add(txtCodigo);
		
		lblNombre= new JLabel("Nombres :");
		lblNombre.setBounds(23,50,80,20);
		c.add(lblNombre);
		
		txtNombre= new JTextField();
		txtNombre.setBounds(103,50,80,20);
		c.add(txtNombre);
		
		lblApellido= new JLabel("Apellidos :");
		lblApellido.setBounds(23,80,80,20);
		c.add(lblApellido);
		
		txtApellido= new JTextField();
		txtApellido.setBounds(103,80,80,20);
		c.add(txtApellido);
		
		btnAdicionar= new JButton("Adicionar");
		btnAdicionar.setBounds(210,90,90,20);
		btnAdicionar.addActionListener(this);
		c.add(btnAdicionar);
		
		btnModificar= new JButton("Modificar");
		btnModificar.setBounds(210,120,90,20);
		btnModificar.addActionListener(this);
		c.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(210,150,90,20);
		btnEliminar.addActionListener(this);
		c.add(btnEliminar);
		
		spS= new JScrollPane();
		spS.setBounds(310,15,260,220);
		c.add(spS);
		
		table= new JTable ();
		table.addMouseListener(this);
		spS.setViewportView(table);
		
		modelo= new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		table.setModel(modelo);
		
		btnGrabar=new JButton("Grabar");
		btnGrabar.setBounds(38,215,95,20);
		btnGrabar.addActionListener(this);
		c.add(btnGrabar);
		
		btnCancelar=new JButton("Cancelar");
		btnCancelar.setBounds(148,215,95,20);
		btnCancelar.addActionListener(this);
		c.add(btnCancelar);
		
		cboTipo = new JComboBox<Object>();
		cboTipo.setModel(new DefaultComboBoxModel<Object>(new String[] {"Obrero", "Supervisor"}));
		cboTipo.addActionListener(this);
		cboTipo.setBounds(210, 13, 90, 21);
		getContentPane().add(cboTipo);
		
		lblTipo = new JLabel("Tipo :");
		lblTipo.setBounds(23, 110, 80, 20);
		getContentPane().add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setBounds(103, 110, 80, 20);
		getContentPane().add(txtTipo);
		
		arranque();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboTipo) {
			actionPerformedCboTipo(e);
		}
		
		if(e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTable(e);
		}
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	protected void mouseClickedTable(MouseEvent e) {
		consultar();
	}
	
	public void actionPerformedCboTipo(ActionEvent e) {
		txtTipo.setText(leerCboTipo());
	}
	
	public void actionPerformedBtnGrabar(ActionEvent e) {
		
		int codigo=leerCodigo();
		String nombre=leerNombre();
		String apellido=leerApellido();
		String tipo=leerCboTipo();
		
		Colaborador c=col.buscar(codigo);
		
		
		
		if(posicion==0) {
			if(c==null) {
				col.adicionar(new Colaborador(codigo,nombre,apellido,tipo));
			}else {
				mensaje ("codigo ya existe");
			}
		
		}
		if(posicion==1 ) {
			if(c!=null) {
				c.setNombre(nombre);
				c.setApellido(apellido);
				c.setTipo(tipo);
			}else {
				mensaje("codigo no existe");
			}
			
		}
		
		col.grabarColaborador();
		botonesActivos(false);
		listar();
		
		
	}
	public void actionPerformedBtnCancelar(ActionEvent e) {
		cuadrosActivos(false); 
		botonesActivos(false);
	}
	
	public void actionPerformedBtnAdicionar (ActionEvent e) {
		posicion=0;	
		botonesActivos(true);
		cuadrosActivos(true);
		txtCodigo.setEditable(true);
	}
	public void actionPerformedBtnModificar (ActionEvent e) {
		posicion=1;
		botonesActivos(true);
		cuadrosActivos(true);
	}
	public void actionPerformedBtnEliminar(ActionEvent e) {
		
		Colaborador c= col.buscar(leerCodigo());
		
		try {
			if(c !=null) {
				if(restringido("coloque la contraseña").equals("luis")) {
					col.eliminar(c);
				}
				else {
					mensaje("contraseña incorrecta");
				}
			}
			else {
				mensaje("no se encontró el codigo");
			}
		} catch (Exception el) {
			mensaje ("Operacion cancelada");
		}
		
		col.grabarColaborador();
		listar();
		
		
	}
	
	//metodos get
	
	public int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}
	public String leerNombre() {
		return txtNombre.getText();
	}
	public String leerApellido() {
		if(txtApellido.getText().equals("")) {
			return " - ";
		}else {
			return txtApellido.getText();	
		}
	}
	public String leerCboTipo() {
		return cboTipo.getSelectedItem().toString().trim();
	}
	public String restringido(String s) {
		return JOptionPane.showInputDialog(this,s);
	}
	
	// metodos void 
	public void mensaje (String s ){
		JOptionPane.showMessageDialog(this,s,"Alerta",1);
	}
	public void consultar() {
		int indice=table.getSelectedRow();
		
		int codigo=(int)table.getValueAt(indice, 0);
		
		Colaborador c=col.buscar(codigo);
		
		String nombre=c.getNombre();
		String apellido=c.getApellido();
		String tipo= c.getTipo();
		
		txtCodigo.setText(codigo + "");
		txtNombre.setText(nombre);
		txtApellido.setText(apellido);
		cboTipo.setSelectedItem(tipo);
		
	}
	public void listar() {
		
		modelo.setRowCount(0);
		
		for(int i = 0; i<col.tamaño();i++) {
			Colaborador c= col.obtener(i);
			Object[] x= {
					c.getCodigo(),
					c.getNombre(),
					c.getApellido(),
			};
			modelo.addRow(x);
		}
	}
	public void arranque () {
		cuadrosActivos(false);
		botonesActivos(false);
		listar();
	}
	public void cuadrosActivos (boolean x) {
		txtCodigo.setEditable(false);
		txtNombre.setEditable(x);
		txtApellido.setEditable(x);
		txtTipo.setEditable(false);
		cboTipo.setEnabled(x);
	}
	public void botonesActivos(boolean x) {
		btnGrabar.setEnabled(x);
		btnCancelar.setEnabled(x);
		btnAdicionar.setEnabled(!x);
		btnModificar.setEnabled(!x);
		btnEliminar.setEnabled(!x);
	}	
	
}
