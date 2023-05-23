package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import arreglos.ArregloF10;
import clases.F10;

@SuppressWarnings("serial")
public class FrmF10 extends JFrame implements ActionListener{
	private JTextField txtIdF10;
	private JTextField txtNroOP;
	private JTextField txtCliente;
	private JTextField txtEstilo;
	private JTextField txtColor;
	private JTextField txtPrenda;
	private JButton btnGrabar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JButton btnLista;
	private JLabel lblIdF10;
	private JLabel lblEstilo;
	private JLabel lblNroOP;
	private JLabel lblCliente;
	private JLabel lblColor;
	private JPanel panelF10;
	private JLabel lblPrenda;
	
	private ArregloF10 arrF10 = new ArregloF10();
	
	public static void main (String[] args) {
		FrmF10 ventana = new FrmF10();
		ventana.setVisible(true);
	}
	
	public FrmF10() {
		
		this.setTitle("ORDENES DE LA F10");
		this.setBounds(0,0,560,255);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		panelF10 = new JPanel();
		panelF10.setBounds(10, 23, 499, 113);
		getContentPane().add(panelF10);
		panelF10.setLayout(null);
		
		txtIdF10 = new JTextField();
		txtIdF10.setBounds(10, 27, 86, 20);
		panelF10.add(txtIdF10);
		txtIdF10.setColumns(10);
		
		lblIdF10 = new JLabel("ID F10");
		lblIdF10.setBounds(11, 11, 85, 14);
		panelF10.add(lblIdF10);
		
		txtNroOP = new JTextField();
		txtNroOP.setColumns(10);
		txtNroOP.setBounds(106, 27, 86, 20);
		panelF10.add(txtNroOP);
		
		lblNroOP = new JLabel("NRO OP");
		lblNroOP.setBounds(107, 11, 85, 14);
		panelF10.add(lblNroOP);
		
		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(213, 27, 104, 20);
		panelF10.add(txtCliente);
		
		lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(214, 11, 85, 14);
		panelF10.add(lblCliente);
		
		txtEstilo = new JTextField();
		txtEstilo.setColumns(10);
		txtEstilo.setBounds(10, 74, 186, 20);
		panelF10.add(txtEstilo);
		
		lblEstilo = new JLabel("ESTILO");
		lblEstilo.setBounds(11, 58, 85, 14);
		panelF10.add(lblEstilo);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(218, 74, 172, 20);
		panelF10.add(txtColor);
		
		lblColor = new JLabel("COLOR");
		lblColor.setBounds(219, 58, 85, 14);
		panelF10.add(lblColor);
		
		txtPrenda = new JTextField();
		txtPrenda.setColumns(10);
		txtPrenda.setBounds(342, 27, 86, 20);
		panelF10.add(txtPrenda);
		
		lblPrenda = new JLabel("PRENDA");
		lblPrenda.setBounds(343, 11, 85, 14);
		panelF10.add(lblPrenda);
		
		btnGrabar = new JButton("GRABAR");
		btnGrabar.setBounds(10, 158, 89, 23);
		btnGrabar.addActionListener(this);
		getContentPane().add(btnGrabar);
		
		btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(111, 158, 89, 23);
		btnEditar.addActionListener(this);
		getContentPane().add(btnEditar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(210, 158, 89, 23);
		btnEliminar.addActionListener(this);
		getContentPane().add(btnEliminar);
		
		btnLista = new JButton("LISTA");
		btnLista.setBounds(406, 158, 89, 23);
		btnLista.addActionListener(this);
		getContentPane().add(btnLista);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(309, 158, 89, 23);
		getContentPane().add(btnNuevo);
		
		arranque();
	}
	
	//metodos getter
	
	private String leerColor() {
		// TODO Auto-generated method stub
		String res = null;
		
		res = this.txtColor.getText().trim();
		
		return res;
	}

	private String leerPrenda() {
		// TODO Auto-generated method stub
		String res = null;
		
		res = this.txtPrenda.getText().trim();
		
		return res;
	}

	private String leerEstilo() {
		// TODO Auto-generated method stub
		String res = null;
		
		res = this.txtEstilo.getText().trim();
		
		return res;
	}

	private int leerNroOP() {
		// TODO Auto-generated method stub
		int res = -1;
		
		res = Integer.parseInt(txtNroOP.getText().trim());
		
		return res;
	}

	private String leerCliente() {
		// TODO Auto-generated method stub
		String res = null;
		
		res = this.txtCliente.getText().trim();
		
		return res;
	}

	private int leerIdF10() {
		// TODO Auto-generated method stub
		int res = -1;
		
		res = Integer.parseInt(this.txtIdF10.getText().trim());
		
		return res;
	}

	
	//metodos void
	
	private void arranque() {
		limpiar();
	}
	
	private void adicionar() {
		
		int id = leerIdF10();
		int nroOP = leerNroOP();
		String cliente = leerCliente();
		String estilo = leerEstilo();
		String prenda = leerPrenda();
		String color = leerColor();
		
		F10 obj = new F10(id, nroOP, cliente, estilo, prenda, color);
		
		arrF10.adicionar(obj);
		arrF10.grabarF10();
		
		limpiar();
		
	}
	
	private void eliminar() {
		
	}
	private void editar() {
		
	}
	
	private void limpiar() {
		
		txtIdF10.setText(arrF10.correlativo()+"");
		
		txtIdF10.setEditable(false);
		
		txtNroOP.setText("");
		txtCliente.setText("");
		txtEstilo.setText("");
		txtPrenda.setText("");
		txtColor.setText("");
	}
	
	//ACTION LISTENER
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if(e.getSource()==btnEditar) {
			actionPerformedBtnEditar(e);
			
		}
		if(e.getSource()==btnLista) {
			actionPerformedBtnLista(e);
			
		}
		if(e.getSource()==btnNuevo) {
			actionPerformedBtnNuevo(e);
			
		}
		if(e.getSource()==btnEliminar) {
			actionPerformedBtnEliminar(e);
			
		}
		
	}

	private void actionPerformedBtnEliminar(ActionEvent e) {
		// TODO Auto-generated method stub
		eliminar();
	}

	private void actionPerformedBtnNuevo(ActionEvent e) {
		// TODO Auto-generated method stub
		limpiar();
	}

	private void actionPerformedBtnLista(ActionEvent e) {
		// TODO Auto-generated method stub
		DlgListaF10 dlg = new DlgListaF10(null,true);
		this.dispose();
		dlg.setVisible(true);
	}

	private void actionPerformedBtnEditar(ActionEvent e) {
		// TODO Auto-generated method stub
		editar();
	}

	private void actionPerformedBtnGrabar(ActionEvent e) {
		// TODO Auto-generated method stub
		adicionar();
	}
}
