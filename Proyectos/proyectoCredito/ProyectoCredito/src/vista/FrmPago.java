package vista;

import javax.swing.*;

@SuppressWarnings("serial")
public class FrmPago extends JFrame{
	
	private JPanel panel;
	private JButton btnNewButton;
	
	public static void main(String [] args) {
		
		FrmPago form = new FrmPago();
		form.setVisible(true);
		
	}
	
	public FrmPago() {
		
		setTitle("");
		setSize(500,300);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(196, 111, 89, 23);
		panel.add(btnNewButton);
		
		
	}
}
