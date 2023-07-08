package vista;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements ActionListener{
	
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnConsulta;
	private JMenuItem mniDeuda;
	private JMenuItem mniConsultaDeuda;
	private JMenuItem mniCliente;
	private JDesktopPane escritorio;
	private JMenuItem mntiPago;
	private JMenuItem mniConsultaPago;
	private JMenu mnTransaccion;
	
	
	
	public static void main(String [] args) {
		
		FrmPrincipal form = new FrmPrincipal();
		form.setVisible(true);
		
	}
	
	public FrmPrincipal() {
		
		setTitle("Proyecto Crediticio");
		setSize(931,511);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//this.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		this.setContentPane(panel);
		
		escritorio= new JDesktopPane();
		escritorio.setBackground(Color.DARK_GRAY);
		getContentPane().add(escritorio);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mniDeuda = new JMenuItem("Deudas");
		mniDeuda.addActionListener(this);
		
		mniCliente = new JMenuItem("Clientes");
		mniCliente.addActionListener(this);
		mnMantenimiento.add(mniCliente);
		mnMantenimiento.add(mniDeuda);
		
		mnTransaccion = new JMenu("Transaccion");
		menuBar.add(mnTransaccion);
		
		mntiPago = new JMenuItem("Pagos");
		mnTransaccion.add(mntiPago);
		mntiPago.addActionListener(this);
		
		mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		mniConsultaDeuda = new JMenuItem("Consulta de deudas");
		mniConsultaDeuda.addActionListener(this);
		mnConsulta.add(mniConsultaDeuda);
		
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
		if (e.getSource() == mniConsultaDeuda) {
			actionPerformedMniConsultaDeuda(e);
		}
		if (e.getSource() == mniDeuda) {
			actionPerformedMniDeuda(e);
		}
		if (e.getSource() == mniConsultaPago) {
			actionPerformedMniConsultaPago(e);
		}
	}
	
	//MANTENIMIENTO
	
	protected void actionPerformedMniCliente(ActionEvent e) {
	}
	
	protected void actionPerformedMniDeuda(ActionEvent e) {
		
	}
	
	//TRANSACCION
	
	protected void actionPerformedMntiPago(ActionEvent e) {
	}
	
	//CONSULTA
	
	protected void actionPerformedMniConsultaDeuda(ActionEvent e) {
	}
	
	
	protected void actionPerformedMniConsultaPago(ActionEvent e) {
	}
}
