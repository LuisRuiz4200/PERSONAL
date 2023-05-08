package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import clases.Circulo;
import clases.Cuadrado;
import interfaces.Figura;

public class FrmInterfaces extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnProcesar;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInterfaces frame = new FrmInterfaces();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmInterfaces() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(23, 24, 85, 21);
		contentPane.add(btnProcesar);
		
		txtS = new JTextArea();
		txtS.setBounds(23, 64, 291, 189);
		contentPane.add(txtS);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		Cuadrado cua=new Cuadrado(10);
		listado(cua);
		
		Circulo cir=new Circulo(5);
		listado(cir);
	}
	void imprimir (String s) {
		txtS.append( s + "\n");
	}
	void listado(Figura x) {
		if(x instanceof Cuadrado) {
			Cuadrado m=(Cuadrado)x;
			imprimir("Figura : " + m.getClass().getName());
			imprimir("Area : " + m.area());
			imprimir(m.dibujar());
		}else if(x instanceof Circulo) {
			Circulo n=(Circulo)x;
			imprimir("Figura : " + n.getClass().getName());
			imprimir("Area : " + n.area());
			imprimir(n.dibujar());
			imprimir(n.rotar());
		}
		
	}
}
