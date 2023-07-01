package vistas;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class OpendDialog extends JFrame implements ActionListener{
	private JTextArea txtArea;
	private JScrollPane spTxtArea;
	private JButton btnAbrir;
	private JButton btnGuardar;
	private JButton btnImg;
	private JLabel lblImg;
	
	public static void main (String[] args) {
		OpendDialog ventana = new OpendDialog();
		ventana.setVisible(true);
	}
	
	public OpendDialog() {
		
		this.setTitle("PRUEBA DE DIALOGO WINDOW");
		this.setBounds(0,0,429,326);
		this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		spTxtArea = new JScrollPane();
		spTxtArea.setBounds(27, 42, 215, 235);
		getContentPane().add(spTxtArea);
		
		txtArea = new JTextArea();
		spTxtArea.setViewportView(txtArea);
		
		btnAbrir = new JButton("ABRIR");
		btnAbrir.addActionListener(this);
		btnAbrir.setBounds(266, 53, 106, 23);
		getContentPane().add(btnAbrir);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(266, 87, 106, 23);
		getContentPane().add(btnGuardar);
		
		btnImg = new JButton("IMAGEN");
		btnImg.addActionListener(this);
		btnImg.setBounds(266, 121, 106, 23);
		getContentPane().add(btnImg);
		
		lblImg = new JLabel("");
		lblImg.setBounds(266, 153, 137, 124);
		getContentPane().add(lblImg);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnImg) {
			actionPerformedBtnImg(e);
		}
		if (e.getSource() == btnAbrir) {
			actionPerformedBtnAbrir(e);
		}
	}
	protected void actionPerformedBtnAbrir(ActionEvent e) {
		FileDialog dlgFile = new FileDialog(this);
		dlgFile.setVisible(true);
		
		String nombreArchivo = dlgFile.getFile();
		File[] dirArchivo = dlgFile.getFiles();
		
		File archivo = new File(dirArchivo[0].toString());
		BufferedReader br = null;
		
		String directorio = dlgFile.getDirectory();
		String nombreFile = dlgFile.getFile();
		String texto = "";
		
		try {
			br = new BufferedReader (new FileReader(directorio + nombreFile));
			
			txtArea.setText("");
			txtArea.setText(dlgFile + " \n");
			
			while ((texto=br.readLine())!=null) {
				txtArea.append(texto + "\n");
			}
			
			
			
			br.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public boolean accept(File f) {
		if (f.isDirectory()) return true;
		String name = f.getName().toLowerCase();
		return name.endsWith("html") || name.endsWith("htm");
		}
	
	protected void actionPerformedBtnImg(ActionEvent e) {
		FileDialog dlgFile = new FileDialog(this);
		dlgFile.setVisible(true);
	
		
		String directorio = dlgFile.getDirectory();
		String nombreFile = dlgFile.getFile();
		String texto = "";
		
		Image img = new ImageIcon(directorio + nombreFile).getImage();
		ImageIcon img2 = new ImageIcon(new ImageIcon(directorio+nombreFile).getImage().getScaledInstance(100, 100, Image.SCALE_FAST));
		
		
		lblImg.setIcon(img2);
		txtArea.setText(img2.getImage()+"");

		
	}
}
