package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCliente;
import clases.Cliente;


@SuppressWarnings("serial")
public class DlgCliente extends JInternalFrame implements ActionListener, MouseListener{
	
	private Container c;
	
	private JScrollPane spS;
	private JLabel lblCodigo;
	private JLabel lblCliente;
	private JTable table;
	private DefaultTableModel modelo;
	private JTextField txtCodigo;
	private JTextField txtCliente;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JButton btnCancelar;
	
	ArregloCliente ac= new ArregloCliente();
	
	private int posicion=-1;
	
	
	public static void main (String[] args) {
		DlgCliente dlgCliente = new DlgCliente();
		dlgCliente.setVisible(true);
	}
	
	public DlgCliente() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100,100,500,288);
		setTitle("Cliente");
		
		c=this.getContentPane();
		getContentPane().setLayout(null);
		
		lblCodigo= new JLabel("Codigo : ");
		lblCodigo.setBounds(10, 22, 75, 20);
		c.add(lblCodigo);
		
		
		lblCliente=new JLabel("Cliente : ");
		lblCliente.setBounds(10, 62, 75, 20);
		c.add(lblCliente);
		
		spS=new JScrollPane();
		spS.setBounds(240, 24, 237, 175);
		c.add(spS);
		
		table=new JTable();
		table.addMouseListener(this);
		spS.setViewportView(table);
		
		modelo=new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("CLIENTE");
		table.setModel(modelo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(95, 23, 96, 19);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(95, 63, 96, 19);
		getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(10, 105, 118, 21);
		btnAdicionar.addActionListener(this);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(10, 136, 118, 21);
		btnModificar.addActionListener(this);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(10, 167, 118, 21);
		btnEliminar.addActionListener(this);
		getContentPane().add(btnEliminar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(43, 210, 85, 21);
		btnGrabar.addActionListener(this);
		getContentPane().add(btnGrabar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(138, 210, 85, 21);
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);
		
		arranque();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if(e.getSource()==btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if(e.getSource()==btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if(e.getSource()==btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if(e.getSource()==btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	
	@Override
	public void mouseClicked (MouseEvent e) {
		if(e.getSource()==table) {
			mouseClickedTable(e);
		}
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
	
	//actions
	
	protected void mouseClickedTable(MouseEvent e) {
		consultar();
	}
	
	protected void actionPerformedBtnAdicionar(ActionEvent e){
		correlativo();
		botonesActivos(true);
		posicion=0;
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		botonesActivos(true);
		posicion=1;
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {

		String cliente= leerNombreCli();
		
		Cliente c=ac.buscarCliente(cliente);
		
		
		try {
			if(c!=null) {
				if(restringido("escriba la contraseña").equals("luis")) {
					ac.eliminar(c);
				}else {
					mensaje("Contraseña incorrecta");
				}
			}
		}catch (Exception el) {
			mensaje("Operacion cancelada");
		}
		
		ac.grabarCliente();
		listar();
	}
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		
		String codigo = leerCodigo();
		String cliente= leerNombreCli();
		
		Cliente c=ac.buscarCliente(cliente);
		
		if(posicion==0) {
			if(c==null) {
				ac.adicionar(new Cliente(ac.correlativo(),cliente));
			}else {
				mensaje ("Cliente ya registrado");
			}
		}
		if(posicion==1) {
			if(c!=null) {
				c.setCodigo(codigo);
				c.setNombreCli(cliente);
			}else {
				mensaje ("Cliente no existe en la tabla");
			}
		}
		ac.grabarCliente();
		botonesActivos(false);
		listar();
		
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		botonesActivos(false);
	}
	
	//metodos con retorno
	
	public String leerCodigo() {
		return txtCodigo.getText();
	}
	public String leerNombreCli() {
		return txtCliente.getText();
	}
	public String restringido(String s) {
		return JOptionPane.showInputDialog(this,s);
	}

	
	
	//metodos void
	
	public void mensaje(String cad) {
		JOptionPane.showMessageDialog(this, cad,"Atencion",1);
	}
	public void listar() {
		
		modelo.setRowCount(0);
		
		for(int i=0;i<ac.tamaño();i++) {
			Cliente c= ac.obtener(i);
			
			Object[] o= {
				c.getCodigo(),
				c.getNombreCli()
			};
			
			modelo.addRow(o);
		}
		
	}
	public void consultar() {
		int indice=table.getSelectedRow();
		
		Cliente c=ac.buscarCliente((String)table.getValueAt(indice,1));
		
		txtCodigo.setText(c.getCodigo());
		txtCliente.setText(c.getNombreCli());
		
		
	}
	
	public void arranque() {
		correlativo();
		cuadrosActivos(false);
		botonesActivos(false);
		listar();
	}
	
	public void correlativo() {
		txtCodigo.setText("" + ac.correlativo());
	}
	
	public void cuadrosActivos(boolean x) {
		txtCodigo.setEditable(false);
	}
	public void botonesActivos(boolean x) {
		btnAdicionar.setEnabled(!x);
		btnModificar.setEnabled(!x);
		btnEliminar.setEnabled(!x);
		btnGrabar.setEnabled(x);
		btnCancelar.setEnabled(x);
	}
	
	
	
	
	
}
