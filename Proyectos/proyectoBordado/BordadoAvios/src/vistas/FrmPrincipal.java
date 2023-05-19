package vistas;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements ActionListener{
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnTransaccion;
	private JMenu mnAyuda;
	private JMenuItem mniIngresoAvio;
	private JMenuItem mniAvio;
	private JMenuItem mniTipoAvio;
	private JMenu mnConsulta;
	private JMenuItem mniConsultaIngresoAvio;
	private JMenu mnAcabado;
	private JMenuItem mniProgramaAcabado;
	private JMenuItem mniConsultaProgramaAcabado;
	private JDesktopPane escritorio;
	private JMenu mnCitis;
	private JMenuItem mniCitiConfeccion;
	private JMenuItem mniCitiAcabado;
	private JMenu mnAvios;
	
	public static void main (String[] args) {
		FrmPrincipal ventana = new FrmPrincipal();
		ventana.setVisible(true);
	}
	
	public FrmPrincipal() {
		
		this.setTitle("PRINCIPAL");
		this.setBounds(0,0,987,688);
		this.setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(Color.LIGHT_GRAY);
		this.getContentPane().add(escritorio);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
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
		
		mnTransaccion = new JMenu("Transaccion");
		menuBar.add(mnTransaccion);
		
		mniIngresoAvio = new JMenuItem("Ingreso de Avios");
		mniIngresoAvio.addActionListener(this);
		mnTransaccion.add(mniIngresoAvio);
		
		mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		mniConsultaIngresoAvio = new JMenuItem("Consulta Ingreso Avio");
		mniConsultaIngresoAvio.addActionListener(this);
		mnConsulta.add(mniConsultaIngresoAvio);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
	}
	public void actionPerformed(ActionEvent e) {
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
	//TRANSACCION
	protected void actionPerformedMniIngresoAvio(ActionEvent e) {
		FrmIngresoAvio ventana = new FrmIngresoAvio();
		ventana.setVisible(true);
	}
	//CONSULTA
	protected void actionPerformedMniConsultaIngresoAvio(ActionEvent e) {
		FrmConsultaIngresoAvio ventana = new FrmConsultaIngresoAvio();
		ventana.setVisible(true);
	}
	//ACABADO
	protected void actionPerformedMniProgramaAcabado(ActionEvent e) {
		FrmProgramaAcabado frame = new FrmProgramaAcabado();
		frame.setVisible(true);
		escritorio.add(frame);
	}
	protected void actionPerformedMniConsultaProgramaAcabado(ActionEvent e) {
		FrmConsultaProgramaAcabado frame = new FrmConsultaProgramaAcabado();
		frame.setVisible(true);
		frame.setLocationRelativeTo(this);
		escritorio.add(frame);
	}
	//MANTENIMIENTO - CITIS
	protected void actionPerformedMniCitiConfeccion(ActionEvent e) {
		FrmCitiConfeccion frame = new FrmCitiConfeccion();
		frame.setVisible(true);
		escritorio.add(frame);
	}
	protected void actionPerformedMniCitiAcabado(ActionEvent e) {
		FrmCitiAcabado frame = new FrmCitiAcabado();
		frame.setVisible(true);
		escritorio.add(frame);
	}
}
