package vistas;

import javax.swing.*;

@SuppressWarnings("serial")
public class BuscarCliente extends JFrame{
	
	
	
	public static void main(String [] args) {
		
		BuscarCliente form = new BuscarCliente();
		form.setVisible(true);
		
	}
	
	public BuscarCliente() {
		
		setTitle("");
		setBounds(100,100,500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(null);
		
	}
	
}
