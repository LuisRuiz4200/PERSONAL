package vistas;

import javax.swing.*;
import java.awt.event.ActionListener;
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
	
	public static void main (String[] args) {
		FrmPrincipal ventana = new FrmPrincipal();
		ventana.setVisible(true);
	}
	
	public FrmPrincipal() {
		
		this.setTitle("PRINCIPAL");
		this.setBounds(0,0,987,688);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mniAvio = new JMenuItem("Avios");
		mnMantenimiento.add(mniAvio);
		
		mniTipoAvio = new JMenuItem("Tipo de Avio");
		mnMantenimiento.add(mniTipoAvio);
		
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
}