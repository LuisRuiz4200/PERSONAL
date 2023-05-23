package vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class sss extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sss frame = new sss();
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
	public sss() {
		setBounds(100, 100, 450, 300);

	}

}
