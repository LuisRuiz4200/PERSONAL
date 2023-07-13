package vistas;

import javax.swing.*;

@SuppressWarnings("serial")
public class Template extends JFrame{
	
	private JPanel panel;
	
	public static void main (String[] args) {
		Template ventana = new Template();
		ventana.setVisible(true);
	}
	
	public Template() {
		
		this.setTitle("PLANTILLA");
		this.setBounds(0,0,429,326);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		panel = new JPanel();
		this.setContentPane(panel);
		panel.setLayout(null);
	}
	
	
}
