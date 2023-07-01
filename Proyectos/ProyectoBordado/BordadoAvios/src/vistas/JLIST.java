package vistas;

import javax.swing.*;

@SuppressWarnings("serial")
public class JLIST extends JFrame{
	private JList list;
	private JToggleButton tglbtnNewToggleButton;
	private JEditorPane editorPane;
	private JScrollPane scrollPane;
	private JSlider slider;
	
	public static void main (String[] args) {
		JLIST ventana = new JLIST();
		ventana.setVisible(true);
	}
	
	public JLIST() {
		
		this.setTitle("JLIST");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0,0,429,326);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"LUIS", "MACHACA ", "RUIZ"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 34, 121, 243);
		getContentPane().add(list);
		
		tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(203, 11, 121, 23);
		getContentPane().add(tglbtnNewToggleButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 91, 169, 160);
		getContentPane().add(scrollPane);
		
		editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
		slider = new JSlider();
		slider.setBounds(139, 58, 200, 23);
		getContentPane().add(slider);
	}
}
