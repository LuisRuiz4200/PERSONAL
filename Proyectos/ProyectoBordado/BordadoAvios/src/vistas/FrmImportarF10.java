package vistas;

import javax.swing.*;

import arreglos.ArregloF10;
import clases.F10;
import reuzables.Custom;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmImportarF10 extends JInternalFrame implements ActionListener{
	
	private ArregloF10 arrF10 = new ArregloF10();
	
	private JPanel panel;
	private JTextPane txtF10;
	private JScrollPane scrollPane;
	private JButton btnAgregar;
	private JLabel lblNroOP;
	private JLabel lblClienteOP;
	private JLabel lblEstiloOP;
	private JLabel lblPrendaOP;
	private JLabel lblColorOP;
	
	public static void main (String[] args) {
		FrmImportarF10 ventana = new FrmImportarF10();
		ventana.setVisible(true);
	}
	
	public FrmImportarF10() {
		
		this.setTitle("IMPORTAR F10");
		this.setBounds(0,0,471,326);
		//this.setLocationRelativeTo(this);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocation(40, 40);
		this.toFront();
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
		
		panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 298, 211);
		panel.add(scrollPane);
		
		txtF10 = new JTextPane();
		scrollPane.setViewportView(txtF10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(337, 76, 89, 23);
		panel.add(btnAgregar);
		
		lblNroOP = new JLabel("OP");
		lblNroOP.setBounds(10, 41, 46, 14);
		panel.add(lblNroOP);
		
		lblClienteOP = new JLabel("CLIENTE");
		lblClienteOP.setBounds(42, 41, 75, 14);
		panel.add(lblClienteOP);
		
		lblEstiloOP = new JLabel("ESTILO");
		lblEstiloOP.setBounds(114, 41, 68, 14);
		panel.add(lblEstiloOP);
		
		lblPrendaOP = new JLabel("PRENDA");
		lblPrendaOP.setBounds(180, 41, 64, 14);
		panel.add(lblPrendaOP);
		
		lblColorOP = new JLabel("COLOR");
		lblColorOP.setBounds(254, 41, 54, 14);
		panel.add(lblColorOP);
	}
	
	
	//METODOS
	
	private void importarF10() {
		
		int contador = 0;
		int excluido = 0;
		String texto = null;
		Object[] linea = new Object[] {};
		Object[] valor = new Object[] {};
		
		texto = txtF10.getText();
		
		for (int i = 0 ; i<(linea = texto.split("\n")).length;i++) {
			
			String lineaString = linea[i].toString();
			valor = lineaString.split(";");
			
			if (arrF10.buscarPorNroOPYColorOP(Integer.parseInt(valor[0].toString()),valor[4].toString())==null) {

				contador ++;
				
				F10 obj = new F10();
				
				try {
					
					obj.setId_F10(arrF10.correlativo());
					obj.setNroOP_F10(Integer.parseInt(valor[0].toString()));
					obj.setCliente_F10(valor[1].toString());
					obj.setEstilo_F10(valor[2].toString());
					obj.setPrenda_F10(valor[3].toString());
					obj.setColor_F10(valor[4].toString());
					
					arrF10.adicionar(obj);
					arrF10.grabarF10();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Custom.mensajeError(this, e.getMessage());
				}
				
			}else {
				excluido ++;
				//System.out.println(lineaString + "\n");
			}
		}

		Custom.mensajeExito(this, contador + " nuevas filas agregadas y " + excluido + " excluidos");
		
	}
	
	//ACTION LISTENER
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		importarF10();
	}
}
