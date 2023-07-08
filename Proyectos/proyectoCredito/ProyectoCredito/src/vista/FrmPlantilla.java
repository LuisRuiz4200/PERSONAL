package vista;

import javax.swing.*;

@SuppressWarnings("serial")
public class FrmPlantilla extends JFrame{
	
	private JPanel panel;
	
	public static void main(String [] args) {
		
		FrmPlantilla form = new FrmPlantilla();
		form.setVisible(true);
		
	}
	
	public FrmPlantilla() {
		
		setTitle("");
		setSize(500,300);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);
		
		
	}
}
