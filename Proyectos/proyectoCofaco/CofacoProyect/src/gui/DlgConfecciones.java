package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloConfeccion;
import clases.Confeccion;

@SuppressWarnings("serial")
public class DlgConfecciones extends JInternalFrame implements ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodCiti;
	private JTextField txtCodCiti;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfecciones dialog = new DlgConfecciones();
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfecciones() {
		
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		
		setTitle("Citis de confeccion");
		setBounds(100, 100, 558, 337);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCodCiti = new JLabel("Codigo Citi:");
		lblCodCiti.setBounds(10, 22, 83, 13);
		contentPanel.add(lblCodCiti);
		
		txtCodCiti = new JTextField();
		txtCodCiti.setBounds(103, 19, 96, 19);
		contentPanel.add(txtCodCiti);
		txtCodCiti.setColumns(10);
		
		lblNombre = new JLabel("Nombre Citi:");
		lblNombre.setBounds(10, 55, 83, 13);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(103, 52, 96, 19);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(22, 116, 119, 21);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(22, 149, 119, 21);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar ");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(22, 180, 119, 21);
		contentPanel.add(btnEliminar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(10, 240, 85, 21);
		contentPanel.add(btnGrabar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(105, 240, 85, 21);
		contentPanel.add(btnCancelar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(232, 20, 290, 246);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		modelo= new DefaultTableModel();
		modelo.addColumn("COD. CITI");
		modelo.addColumn("NOMBRE");
		table.setModel(modelo);
		
		//arranque
		listar();
		botonesActivos(false);
		
	}
	
	//variable global
	
	ArregloConfeccion ac= new ArregloConfeccion();
	int posicion =-1;
	
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
	
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		
		posicion=0;
		botonesActivos(true);
		
		
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
		posicion=1;
		botonesActivos(true);
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		try {
			
			if(restringido("Ingrese la contrase�a").equals("luis")) {
				
				String codCiti=Integer.toString(leerCodigoCiti());
				Confeccion c=ac.buscar((codCiti));
				
				if(c!=null) {
					ac.eliminar(c);
				}else {
					mensaje("no hay registro");
				}
				
				
			}else {
				mensaje("contrase�a no es correcta");
			}
			
		}catch (Exception el) {
			mensaje("Operacion cancelada");
		}
		
		
		
		listar();
		ac.grabarConfeccion();
	}
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		
		try {
			
			int codCiti=leerCodigoCiti();
			String codCitiString=Integer.toString(codCiti);
			if(codCiti<10) {
				codCitiString="0" + codCiti;
			} 
			String nombre=leerNombre();
			Confeccion x=ac.buscar(codCiti +"");
			
			//constructor
			Confeccion c=new Confeccion(codCitiString,nombre);
			
			if(posicion==0) {
				
				if(x==null) {
					ac.adicionar(c);
				}
				else {
					mensaje ("se repite !");
				}
				
			}
			if(posicion==1) {
				
				
				if(x!=null) {
					x.setCodigoCiti(codCitiString);
					x.setNombre(nombre);
				} else {
					mensaje("no existe");
				}
			}
		}
		catch (Exception e1) {
			mensaje("valores invalidos");
		}

		
		

		listar();
		ac.grabarConfeccion();
		botonesActivos(false);
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		botonesActivos(false);
	}
	//atributos con retorno 
	public int leerCodigoCiti() {
		return Integer.parseInt(txtCodCiti.getText().trim());
	}
	public String leerNombre () {
		return txtNombre.getText().trim();
	}
	public String restringido(String s) {
		return JOptionPane.showInputDialog(this,s);
	}
	//metodos void
	public void listar () {
		Confeccion c;
		modelo.setRowCount(0);
		for (int i=0;i<ac.tama�o();i++) {
			c=ac.obtener(i);
			Object [] x= {
					"citi " + c.getCodigoCiti(),
					c.getNombre()
			};
			modelo.addRow(x);
		}
	}
	public void mensaje (String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	public void consultar () {
		int i=table.getSelectedRow();
		Confeccion c=ac.obtener(i);
		
		txtCodCiti.setText(c.getCodigoCiti());
		txtNombre.setText(c.getNombre());
	}

	
	public void botonesActivos(boolean c) {
		btnCancelar.setEnabled(c);
		btnGrabar.setEnabled(c);
		btnAdicionar.setEnabled(!c);
		btnModificar.setEnabled(!c);
		btnEliminar.setEnabled(!c);
	}
	
	
	
}
