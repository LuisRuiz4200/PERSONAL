package vistas;

import javax.swing.*;

import arreglos.*;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements ActionListener{
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnBordado;
	private JMenu mnAyuda;
	private JMenuItem mniIngresoAvio;
	private JMenuItem mniAvio;
	private JMenuItem mniTipoAvio;
	private JMenuItem mniConsultaIngresoAvio;
	private JMenu mnAcabado;
	private JMenuItem mniProgramaAcabado;
	private JMenuItem mniConsultaProgramaAcabado;
	private JMenu mnCitis;
	private JMenuItem mniCitiConfeccion;
	private JMenuItem mniCitiAcabado;
	private JMenu mnAvios;
	private JMenuItem mniEstiloOP;
	private JMenu mnDataBase;
	private JMenuItem mniColorOP;
	private JMenuItem mniOrdenProduccion;
	private JMenuItem mniPrenda;
	private JMenuItem mniCliente;
	private JMenuItem mniActualizar;
	public static JDesktopPane escritorio;
	
	public static void main (String[] args) {
		FrmPrincipal ventana = new FrmPrincipal();
		ventana.setVisible(true);
	}
	
	public FrmPrincipal() {
		
		this.setTitle("PRINCIPAL");
		this.setBounds(0,0,987,647);
		this.setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mniActualizar = new JMenuItem("ACTUALIZAR");
		mniActualizar.addActionListener(this);
		mnArchivo.add(mniActualizar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mnDataBase = new JMenu("DATA BASE");
		mnMantenimiento.add(mnDataBase);
		
		mniEstiloOP = new JMenuItem("ESTILO OP");
		mniEstiloOP.addActionListener(this);
		mnDataBase.add(mniEstiloOP);
		
		mniColorOP = new JMenuItem("COLOR OP");
		mniColorOP.addActionListener(this);
		mnDataBase.add(mniColorOP);
		
		mniOrdenProduccion = new JMenuItem("ORDEN PRODUCCION");
		mniOrdenProduccion.addActionListener(this);
		mnDataBase.add(mniOrdenProduccion);
		
		mniPrenda = new JMenuItem("PRENDA");
		mniPrenda.addActionListener(this);
		mnDataBase.add(mniPrenda);
		
		mniCliente = new JMenuItem("CLIENTE");
		mniCliente.addActionListener(this);
		mnDataBase.add(mniCliente);
		
		mnAvios = new JMenu("AVIOS");
		mnMantenimiento.add(mnAvios);
		
		mniAvio = new JMenuItem("Avios");
		mnAvios.add(mniAvio);
		
		mniTipoAvio = new JMenuItem("Tipo de Avio");
		mnAvios.add(mniTipoAvio);
		
		mnCitis = new JMenu("CITIS");
		mnMantenimiento.add(mnCitis);
		
		mniCitiConfeccion = new JMenuItem("CitiConfeccion");
		mniCitiConfeccion.addActionListener(this);
		mnCitis.add(mniCitiConfeccion);
		
		mniCitiAcabado = new JMenuItem("CitiAcabado");
		mniCitiAcabado.addActionListener(this);
		mnCitis.add(mniCitiAcabado);
		
		mnAcabado = new JMenu("Acabado");
		menuBar.add(mnAcabado);
		
		mniProgramaAcabado = new JMenuItem("Programa de acabado");
		mniProgramaAcabado.addActionListener(this);
		mnAcabado.add(mniProgramaAcabado);
		
		mniConsultaProgramaAcabado = new JMenuItem("Consultar Programa de Acabado");
		mniConsultaProgramaAcabado.addActionListener(this);
		mnAcabado.add(mniConsultaProgramaAcabado);
		
		mnBordado = new JMenu("Bordado");
		menuBar.add(mnBordado);
		
		mniIngresoAvio = new JMenuItem("Ingreso de Avios");
		mniIngresoAvio.addActionListener(this);
		mnBordado.add(mniIngresoAvio);
		
		mniConsultaIngresoAvio = new JMenuItem("Consulta Ingreso Avio");
		mnBordado.add(mniConsultaIngresoAvio);
		mniConsultaIngresoAvio.addActionListener(this);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(escritorio, BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.mniActualizar) {
			actionPerformedMniActualizar(e);
		}
		if (e.getSource() == this.mniCliente) {
			actionPerformedMniCliente(e);
		}
		if (e.getSource() == this.mniEstiloOP) {
			actionPerformedMniEstiloOP(e);
		}
		if (e.getSource() == this.mniColorOP) {
			actionPerformedMniColorOP(e);
		}
		if (e.getSource() == this.mniOrdenProduccion) {
			actionPerformedMniOrdenProduccion(e);
		}
		if (e.getSource() == this.mniPrenda) {
			actionPerformedMniPrenda(e);
		}
		//
		if (e.getSource() == mniCitiAcabado) {
			actionPerformedMniCitiAcabado(e);
		}
		if (e.getSource() == mniCitiConfeccion) {
			actionPerformedMniCitiConfeccion(e);
		}
		if (e.getSource() == mniConsultaProgramaAcabado) {
			actionPerformedMniConsultaProgramaAcabado(e);
		}
		if (e.getSource() == mniProgramaAcabado) {
			actionPerformedMniProgramaAcabado(e);
		}
		if (e.getSource() == mniConsultaIngresoAvio) {
			actionPerformedMniConsultaIngresoAvio(e);
		}
		if (e.getSource() == mniIngresoAvio) {
			actionPerformedMniIngresoAvio(e);
		}
	}
	
	

	//ARCHIVO
	
	private void actionPerformedMniActualizar(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmPrincipal frame = new FrmPrincipal();
		frame.setVisible(true);
		this.dispose();
	}

	//BORDADO - AVIOS
	protected void actionPerformedMniIngresoAvio(ActionEvent e) {
		FrmIngresoAvio ventana = new FrmIngresoAvio();
		escritorio.add(ventana);
		ventana.setVisible(true);
		ventana.toFront();
	}
	protected void actionPerformedMniConsultaIngresoAvio(ActionEvent e) {
		FrmConsultaIngresoAvio ventana = new FrmConsultaIngresoAvio();
		ventana.setVisible(true);
	}
	//ACABADO
	protected void actionPerformedMniProgramaAcabado(ActionEvent e) {
		FrmProgramaAcabado frame = new FrmProgramaAcabado();
		escritorio.add(frame);
		frame.setVisible(true);
		frame.setLocation(40,40);
		frame.toFront();
	}
	protected void actionPerformedMniConsultaProgramaAcabado(ActionEvent e) {
		FrmConsultaProgramaAcabado frame = new FrmConsultaProgramaAcabado();
		escritorio.add(frame);
		frame.setVisible(true);
		frame.setLocation(40,40);
		frame.toFront();
	}
	//MANTENIMIENTO - CITIS
	protected void actionPerformedMniCitiConfeccion(ActionEvent e) {
		FrmCitiConfeccion frame = new FrmCitiConfeccion();
		escritorio.add(frame);
		frame.setVisible(true);
		frame.setLocation(40,40);
		frame.toFront();
	}
	protected void actionPerformedMniCitiAcabado(ActionEvent e) {
		FrmCitiAcabado frame = new FrmCitiAcabado();
		escritorio.add(frame);
		frame.setVisible(true);
		frame.setLocation(40,40);
		frame.toFront();
	}
	//MANTENIMIENTO - DATA BASE
	private void actionPerformedMniPrenda(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmPrenda frame = new FrmPrenda();
		frame.setVisible(true);
	}

	private void actionPerformedMniOrdenProduccion(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmOrdenProd frame = new FrmOrdenProd();
		frame.setVisible(true);
	}

	private void actionPerformedMniColorOP(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmColorOP frame = new FrmColorOP();
		frame.setVisible(true);
	}

	private void actionPerformedMniEstiloOP(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmEstiloOP frame = new FrmEstiloOP();
		frame.setVisible(true);
	}
	private void actionPerformedMniCliente(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmCliente frame = new FrmCliente();
		frame.setVisible(true);
	}

}
