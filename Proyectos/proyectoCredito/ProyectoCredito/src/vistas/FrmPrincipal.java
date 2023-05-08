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
	private JMenu mnConsulta;
	private JMenuItem mniGasto;
	private JMenuItem mniConsultaGasto;
	private JMenuItem mniCliente;
	private JDesktopPane escritorio;
	private JMenuItem mntiPago;
	private JMenuItem mniConsultaPago;
	
	
	
	public static void main(String [] args) {
		
		FrmPrincipal form = new FrmPrincipal();
		form.setVisible(true);
		
	}
	
	public FrmPrincipal() {
		
		setTitle("Proyecto Crediticio");
		setBounds(100,100,703,446);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.getContentPane().setLayout(null);
		
		escritorio= new JDesktopPane();
		escritorio.setBackground(Color.DARK_GRAY);
		getContentPane().add(escritorio);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mniGasto = new JMenuItem("Gastos ");
		mniGasto.addActionListener(this);
		
		mniCliente = new JMenuItem("Clientes");
		mniCliente.addActionListener(this);
		mnMantenimiento.add(mniCliente);
		mnMantenimiento.add(mniGasto);
		
		mntiPago = new JMenuItem("Pagos");
		mntiPago.addActionListener(this);
		mnMantenimiento.add(mntiPago);
		
		mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		mniConsultaGasto = new JMenuItem("Consulta de gastos");
		mniConsultaGasto.addActionListener(this);
		mnConsulta.add(mniConsultaGasto);
		
		mniConsultaPago = new JMenuItem("Consulta de pagos");
		mniConsultaPago.addActionListener(this);
		mnConsulta.add(mniConsultaPago);
		
	}
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == mntiPago) {
			actionPerformedMntiPago(e);
		}
		if (e.getSource() == mniCliente) {
			actionPerformedMniCliente(e);
		}
		if (e.getSource() == mniConsultaGasto) {
			actionPerformedMniConsultaGasto(e);
		}
		if (e.getSource() == mniGasto) {
			actionPerformedMniGasto(e);
		}
		if (e.getSource() == mniConsultaPago) {
			actionPerformedMniConsultaPago(e);
		}
	}
	protected void actionPerformedMniGasto(ActionEvent e) {
		
		FrmGasto form = new FrmGasto();
		form.setVisible(true);
		//form.setLocationRelativeTo(this);
		escritorio.add(form).setLocation(0,0);
		form.toFront();
		
	}
	protected void actionPerformedMniConsultaGasto(ActionEvent e) {
		FrmConsultaGasto form = new FrmConsultaGasto();
		form.setVisible(true);
		//form.setLocationRelativeTo(this);
		escritorio.add(form).setLocation(0,0);
		form.toFront();
	}
	protected void actionPerformedMniCliente(ActionEvent e) {
		FrmCliente form = new FrmCliente();
		form.setVisible(true);
		//form.setLocationRelativeTo(this);
		escritorio.add(form).setLocation(0,0);
		form.toFront();
	}
	protected void actionPerformedMntiPago(ActionEvent e) {
		FrmPago form = new FrmPago();
		form.setVisible(true);
		//form.setLocationRelativeTo(this);
		escritorio.add(form).setLocation(0,0);
		form.toFront();
	}
	protected void actionPerformedMniConsultaPago(ActionEvent e) {
		FrmConsultaPago form = new FrmConsultaPago();
		form.setVisible(true);
		//form.setLocationRelativeTo(this);
		escritorio.add(form).setLocation(0,0);
		form.toFront();
	}
}
