package vistas;

import javax.swing.*;

@SuppressWarnings("serial")
public class FrmPrioridadAcabado extends JFrame{
	
	public static void main (String[] args) {
		FrmPrioridadAcabado ventana = new FrmPrioridadAcabado();
		ventana.setVisible(true);
	}
	
	public FrmPrioridadAcabado() {
		
		this.setTitle("PRIORIDADES DEL PROGRAMA DE ACABADO");
		this.setBounds(0,0,429,326);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
	}
	
	
}
