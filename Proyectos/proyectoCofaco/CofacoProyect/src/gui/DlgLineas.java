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

import arreglos.ArregloColaborador;
import arreglos.ArregloLineas;
import clases.Linea;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class DlgLineas extends JInternalFrame implements ActionListener, MouseListener{
	
	Container  c;
	private JLabel lblLinea;
	private JTextField txtLinea;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private JLabel lblSupervisor;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modelo;
	
	private ArregloLineas al = new ArregloLineas();
	private int posicion =-1;
	private JComboBox <Object>cboSupervisor;
	
	
	public static void main (String[]arg) {
		DlgLineas dlgLineas= new DlgLineas();
		dlgLineas.setVisible(true);
		
	}
	
	public DlgLineas() {
		c=this.getContentPane();
		c.setLayout(null);
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		setTitle("Lineas");
		setBounds(100,100,522,360);
		
		lblLinea = new JLabel("Linea :");
		lblLinea.setBounds(10, 15, 93, 13);
		getContentPane().add(lblLinea);
		
		txtLinea = new JTextField();
		txtLinea.setBounds(95, 12, 96, 19);
		getContentPane().add(txtLinea);
		txtLinea.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 112, 105, 21);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(10, 143, 105, 21);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(10, 172, 105, 21);
		getContentPane().add(btnEliminar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(10, 255, 85, 21);
		getContentPane().add(btnGrabar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(118, 255, 85, 21);
		getContentPane().add(btnCancelar);
		
		lblSupervisor = new JLabel("Supervisor :");
		lblSupervisor.setBounds(10, 46, 93, 13);
		getContentPane().add(lblSupervisor);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(232, 28, 257, 251);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		modelo= new DefaultTableModel();
		modelo.addColumn("LINEA");
		modelo.addColumn("SUPERVISOR");
		table.setModel(modelo);
		
		cboSupervisor = new JComboBox<Object>();
		cboSupervisor.setBounds(95, 41, 113, 21);
		cboSupervisor.addActionListener(this);
		getContentPane().add(cboSupervisor);
		
		arranque();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
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
		if (e.getSource() == cboSupervisor) {
			actionPerformedCboSupervisor(e);
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
	
	
	protected void actionPerformedCboSupervisor(ActionEvent e) {
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		posicion=0;
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		posicion=1;
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		Linea x= al.buscar(leerLinea());
		
		try {
			if(x!=null) {
				if(restringido("coloque la contraseña :" ).equals("luis")) {
					al.eliminar(x);
				}else {
					mensaje("Contraseña incorrecta !");
				}
			}else {
				mensaje("Linea no existe !");
			}
		}catch (Exception el ) {
			mensaje ("Operacion cancelada");
		}
		
		listar();
		al.grabarLineas();
	}
	protected void actionPerformedBtnGrabar(ActionEvent e) {
	
		
		String linea=leerLinea();
		String supervisor=leerCboSupervisor();
		Linea x=al.buscar(linea);
		
		Linea l = new Linea(linea , supervisor); 
		
		if(posicion==0) {
			if(x==null) {
				al.adicionar(l);
			}else {
				mensaje("Linea ya existe !");
			}
			
		}
		if(posicion==1) {
			
			if(x!=null) {
				x.setLinea(linea);
				x.setSupervisor(supervisor);
			}else {
				mensaje("Linea no existe !");
			}
			
			
		}
		al.grabarLineas();
		listar();
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
	}
	//metodos con retorno 
	public String leerLinea() {
		return txtLinea.getText().trim();
	}
	public String leerCboSupervisor() {
		return cboSupervisor.getSelectedItem().toString().trim();
	}
	//metodos void 
	public void mensaje(String s) {
		JOptionPane.showMessageDialog(this,s,"Alerta",1);
	}
	public String restringido(String s) {
		return JOptionPane.showInputDialog(this, s);
	}
	public void listar() {
		modelo.setRowCount(0);
		for(int i=0;i<al.tamaño();i++) {
			Linea l=al.obtener(i);
			Object[] x= {
					l.getLinea(),
					l.getSupervisor()
			};
			modelo.addRow(x);
		}
	}
	public void arranque() {
		llenarCboSupervisor();
		listar();
	}
	public void consultar() {
		
		int indice=table.getSelectedRow();
		
		txtLinea.setText(al.obtener(indice).getLinea());
		cboSupervisor.setSelectedItem(al.obtener(indice).getSupervisor());
	}
	public void llenarCboSupervisor() {
		ArregloColaborador col= new ArregloColaborador();
		
		for(int i =0;i<col.tamaño();i++) {
			if(col.obtener(i).getTipo().equals("Supervisor")) {
				cboSupervisor.addItem(col.obtener(i).getNombre());
			}
		}
	}
	
}
