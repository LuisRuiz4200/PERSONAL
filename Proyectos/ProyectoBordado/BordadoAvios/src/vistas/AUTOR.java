package vistas;

import javax.swing.*;
import java.awt.Font;

@SuppressWarnings("serial")
public class AUTOR extends JDialog{
	private JLabel lblTituloAutor;
	private JLabel lblNombre;
	
	public static void main (String[] args) {
		
	}
	
	public AUTOR(JFrame frame , boolean x) {
		
		super(frame,x);
		
		this.setTitle("DESARROLLADOR");
		this.setBounds(0,0,251,145);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		lblTituloAutor = new JLabel("DESARROLLADO POR:");
		lblTituloAutor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTituloAutor.setBounds(10, 11, 268, 41);
		getContentPane().add(lblTituloAutor);
		
		lblNombre = new JLabel("- LUIS MACHACA RUIZ");
		lblNombre.setBounds(20, 63, 170, 34);
		getContentPane().add(lblNombre);
	}
	
	
}
