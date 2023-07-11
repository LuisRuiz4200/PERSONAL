package vista;

import javax.swing.*;

@SuppressWarnings("serial")
public class FrmPago extends JFrame{
	
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private JPanel panelGestionPago;
	private JPanel panelConsultaPago;
	private JPanel panel_1;
	private JTextField textField;
	private JLabel lblNewLabel;
	
	public static void main(String [] args) {
		
		FrmPago form = new FrmPago();
		form.setVisible(true);
		
	}
	
	public FrmPago() {
		
		setTitle("PAGO");
		setSize(606,378);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		this.setContentPane(panel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 570, 317);
		panel.add(tabbedPane);
		
		panelGestionPago = new JPanel();
		tabbedPane.addTab("GESTION", null, panelGestionPago, null);
		panelGestionPago.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 545, 66);
		panelGestionPago.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 35, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel_1.add(lblNewLabel);
		
		panelConsultaPago = new JPanel();
		tabbedPane.addTab("CONSULTA", null, panelConsultaPago, null);
		panelConsultaPago.setLayout(null);
		
		
	}
}
