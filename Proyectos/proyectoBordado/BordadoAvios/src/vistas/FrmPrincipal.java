package vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;

import arreglos.*;
import clases.Prioridad;
import reuzables.Custom;

import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Font;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements ActionListener{
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnBordado;
	private JMenu mnAyuda;
	private JMenuItem mniIngresoAvio;
	private JMenuItem mniAvio;
	private JMenuItem mniTipoAvio;
	private JMenuItem mniConsultaIngresoAvio;
	private JMenu mnAcabado;
	private JMenuItem mniProgramaAcabado;
	private JMenuItem mniConsultaProgramaAcabado;
	private JMenu mnCitis;
	private JMenuItem mniCitiConfeccion;
	private JMenuItem mniCitiAcabado;
	private JMenu mnAvios;
	private JMenuItem mniEstiloOP;
	private JMenu mnDataBase;
	private JMenuItem mniColorOP;
	private JMenuItem mniOrdenProduccion;
	private JMenuItem mniPrenda;
	private JMenuItem mniCliente;
	private JMenuItem mniActualizar;
	public static JDesktopPane escritorio;
	private JMenu mnMantenimientoAcabado;
	private JMenu mnConsultaAcabado;
	private JMenuItem mniPrioridad;
	private JMenuItem mniConsultaPrioridad;
	private JPanel panelPrioridad;
	private JTextPane txtPrioridad;
	private JScrollPane spPrioridad;
	private JLabel lblTituloPrioridad;
	private JMenuItem mniAutor;
	private JMenuItem mnHojaMarcacion;
	private JLabel lblUser;
	private JMenuItem mniImportarF10;
	
	public static void main (String[] args) {
		
		 try {
             UIManager.setLookAndFeel(new com.jtattoo.plaf.mint.MintLookAndFeel()); // linea para cambiar LookAndFeel
         } catch (UnsupportedLookAndFeelException ex) {
             Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
         }
		 
		FrmPrincipal ventana = new FrmPrincipal();
		ventana.setVisible(true);
		
	}
	
	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/img/cofaco2.png")));
		
		this.setTitle("PRINCIPAL");
		this.setBounds(0,0,987,647);
		this.setLocationRelativeTo(this);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mniActualizar = new JMenuItem("ACTUALIZAR");
		mniActualizar.addActionListener(this);
		mnArchivo.add(mniActualizar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mnDataBase = new JMenu("DATA BASE");
		mnMantenimiento.add(mnDataBase);
		
		mniEstiloOP = new JMenuItem("ESTILO OP");
		mniEstiloOP.addActionListener(this);
		
		mniImportarF10 = new JMenuItem("IMPORTAR LISTA F10");
		mniImportarF10.addActionListener(this);
		mnDataBase.add(mniImportarF10);
		mnDataBase.add(mniEstiloOP);
		
		mniColorOP = new JMenuItem("COLOR OP");
		mniColorOP.addActionListener(this);
		mnDataBase.add(mniColorOP);
		
		mniOrdenProduccion = new JMenuItem("ORDEN PRODUCCION");
		mniOrdenProduccion.addActionListener(this);
		mnDataBase.add(mniOrdenProduccion);
		
		mniPrenda = new JMenuItem("PRENDA");
		mniPrenda.addActionListener(this);
		mnDataBase.add(mniPrenda);
		
		mniCliente = new JMenuItem("CLIENTE");
		mniCliente.addActionListener(this);
		mnDataBase.add(mniCliente);
		
		mnAvios = new JMenu("AVIOS");
		mnMantenimiento.add(mnAvios);
		
		mniAvio = new JMenuItem("Avios");
		mnAvios.add(mniAvio);
		
		mniTipoAvio = new JMenuItem("Tipo de Avio");
		mnAvios.add(mniTipoAvio);
		
		mnCitis = new JMenu("CITIS");
		mnMantenimiento.add(mnCitis);
		
		mniCitiConfeccion = new JMenuItem("CitiConfeccion");
		mniCitiConfeccion.addActionListener(this);
		mnCitis.add(mniCitiConfeccion);
		
		mniCitiAcabado = new JMenuItem("CitiAcabado");
		mniCitiAcabado.addActionListener(this);
		mnCitis.add(mniCitiAcabado);
		
		mnAcabado = new JMenu("Acabado");
		menuBar.add(mnAcabado);
		
		mnMantenimientoAcabado = new JMenu("Mantenimiento");
		mnAcabado.add(mnMantenimientoAcabado);
		
		mniProgramaAcabado = new JMenuItem("Programa de acabado");
		mnMantenimientoAcabado.add(mniProgramaAcabado);
		
		mniPrioridad = new JMenuItem("Prioridades");
		mniPrioridad.addActionListener(this);
		
		mnHojaMarcacion = new JMenuItem("Hoja de marcacion");
		mnHojaMarcacion.addActionListener(this);
		mnMantenimientoAcabado.add(mnHojaMarcacion);
		mnMantenimientoAcabado.add(mniPrioridad);
		mniProgramaAcabado.addActionListener(this);
		
		mnConsultaAcabado = new JMenu("Consulta");
		mnAcabado.add(mnConsultaAcabado);
		
		mniConsultaProgramaAcabado = new JMenuItem("Consultar Programa de Acabado");
		mnConsultaAcabado.add(mniConsultaProgramaAcabado);
		
		mniConsultaPrioridad = new JMenuItem("Consultar Prioridades");
		mniConsultaPrioridad.addActionListener(this);
		mnConsultaAcabado.add(mniConsultaPrioridad);
		mniConsultaProgramaAcabado.addActionListener(this);
		
		mnBordado = new JMenu("Bordado");
		menuBar.add(mnBordado);
		
		mniIngresoAvio = new JMenuItem("Ingreso de Avios");
		mniIngresoAvio.addActionListener(this);
		mnBordado.add(mniIngresoAvio);
		
		mniConsultaIngresoAvio = new JMenuItem("Consulta Ingreso Avio");
		mnBordado.add(mniConsultaIngresoAvio);
		mniConsultaIngresoAvio.addActionListener(this);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mniAutor = new JMenuItem("DESARROLLADOR");
		mniAutor.addActionListener(this);
		mnAyuda.add(mniAutor);
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(escritorio, BorderLayout.CENTER);
		
		panelPrioridad = new JPanel();
		panelPrioridad.setBounds(573, 11, 388, 565);
		escritorio.add(panelPrioridad);
		panelPrioridad.setLayout(null);
		
		spPrioridad = new JScrollPane();
		spPrioridad.setBounds(10, 62, 368, 492);
		panelPrioridad.add(spPrioridad);
		
		txtPrioridad = new JTextPane();
		//txtPrioridad.setLineWrap(true);
		txtPrioridad.setBorder(new EmptyBorder(4,4,4,4));
		spPrioridad.setViewportView(txtPrioridad);
		
		lblTituloPrioridad = new JLabel("PRIORIDADES");
		lblTituloPrioridad.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTituloPrioridad.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPrioridad.setBounds(10, 21, 368, 30);
		panelPrioridad.add(lblTituloPrioridad);
		
		lblUser = new JLabel("USER");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUser.setBounds(10, 11, 175, 32);
		escritorio.add(lblUser);
		

		arranque();
		
	}
	
	

	//METODOS VOID
	
	private void arranque() {
		mostrarPrioridad();
		limpiar();
	}
	
	public static void reiniciar() {
		new FrmPrincipal().setVisible(true);
		
	}
	
	public  void mostrarPrioridad() {
		
		ArregloPrioridad arrPrioridad = new ArregloPrioridad();
		String texto = "NO HAY PRIORIDADES";
		StringBuffer textoAnidado = new StringBuffer();
		int nroID = 0;
		
		if(arrPrioridad.tamano()==0) {
			txtPrioridad.setText(texto);		
			return;
		}
		
		
		for(int i=0;i<arrPrioridad.tamano();i++) {
			Prioridad obj = arrPrioridad.obtener(i);
			
			if(obj.getEstado_prioridad().equals("REGISTRADO")) {
				nroID ++;
				
				texto = "NRO ID	: " + nroID +"	FECHA : " + new SimpleDateFormat("dd MMM yyy hh:mm:ss").format(obj.getFechaReg_prioridad()) +"\n" +
						"OP	: " + obj.getNro_OP() + "\n" +
						"COLOR	: " + obj.getColor_OP() + "\n\n" +
						"__________________DESCRIPCION__________________\n\n" + obj.getDes_prioridad().toUpperCase() + "\n\n"+
						"================================================" + "\n\n";
				
				textoAnidado.append(texto);
				
				txtPrioridad.setText(textoAnidado.toString());
			}
		}
		
		
	}
	
	private void limpiar(){
		txtPrioridad.setEditable(false);
		
		String user = System.getProperty("user.name");
		
		
		lblUser.setText("USUARIO: "+user);
		
		
	}
	
	//ACTION LISTENER
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mniImportarF10) {
			actionPerformedMniImportarF10(e);
		}
		if (e.getSource() == mnHojaMarcacion) {
			actionPerformedMnHojaMarcacion(e);
		}
		if(e.getSource() == this.mniActualizar) {
			actionPerformedMniActualizar(e);
		}
		if (e.getSource() == this.mniCliente) {
			actionPerformedMniCliente(e);
		}
		if (e.getSource() == this.mniEstiloOP) {
			actionPerformedMniEstiloOP(e);
		}
		if (e.getSource() == this.mniColorOP) {
			actionPerformedMniColorOP(e);
		}
		if (e.getSource() == this.mniOrdenProduccion) {
			actionPerformedMniOrdenProduccion(e);
		}
		if (e.getSource() == this.mniPrenda) {
			actionPerformedMniPrenda(e);
		}
		if (e.getSource()== this.mniPrioridad) {
			actionPerformedMniPrioridad(e);
		}
		if (e.getSource()== this.mniConsultaPrioridad) {
			actionPerformedMniConsultaPrioridad(e);
		}
		if(e.getSource()==this.mniAutor) {
			actionPerformedMniAutor(e);
		}
		//
		if (e.getSource() == mniCitiAcabado) {
			actionPerformedMniCitiAcabado(e);
		}
		if (e.getSource() == mniCitiConfeccion) {
			actionPerformedMniCitiConfeccion(e);
		}
		if (e.getSource() == mniConsultaProgramaAcabado) {
			actionPerformedMniConsultaProgramaAcabado(e);
		}
		if (e.getSource() == mniProgramaAcabado) {
			actionPerformedMniProgramaAcabado(e);
		}
		if (e.getSource() == mniConsultaIngresoAvio) {
			actionPerformedMniConsultaIngresoAvio(e);
		}
		if (e.getSource() == mniIngresoAvio) {
			actionPerformedMniIngresoAvio(e);
		}
	}
	
	

	//ARCHIVO



	private void actionPerformedMniActualizar(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			//this.update(this.getGraphics());
			this.mostrarPrioridad();
		}catch(Exception ex) {
			Custom.mensajeError(this, ex.getMessage());
		}
		
	}

	//BORDADO - AVIOS
	protected void actionPerformedMniIngresoAvio(ActionEvent e) {
		FrmIngresoAvio ventana = new FrmIngresoAvio();
		escritorio.add(ventana);
		ventana.setVisible(true);
	}
	protected void actionPerformedMniConsultaIngresoAvio(ActionEvent e) {
		
	}
	//ACABADO
	protected void actionPerformedMniProgramaAcabado(ActionEvent e) {
		FrmProgramaAcabado frame = new FrmProgramaAcabado();
		escritorio.add(frame);
		frame.setVisible(true);
		frame.setLocation(40,40);
		frame.toFront();
	}
	protected void actionPerformedMniConsultaProgramaAcabado(ActionEvent e) {
		FrmConsultaProgramaAcabado frame = new FrmConsultaProgramaAcabado();
		escritorio.add(frame);
		frame.setVisible(true);
		frame.setLocation(40,40);
		frame.toFront();
	}

	protected void actionPerformedMnHojaMarcacion(ActionEvent e) {
		FrmPedidoOP frame = new FrmPedidoOP();
		escritorio.add(frame);
		frame.setVisible(true);
		
	}
	
	
	private void actionPerformedMniConsultaPrioridad(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmConsultaPrioridad frame = new FrmConsultaPrioridad();
		escritorio.add(frame);
		frame.setVisible(true);
		frame.toFront();
	}

	private void actionPerformedMniPrioridad(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmPrioridad frame = new FrmPrioridad();
		escritorio.add(frame);
		frame.setVisible(true);
		frame.toFront();
	}
	//MANTENIMIENTO - CITIS
	protected void actionPerformedMniCitiConfeccion(ActionEvent e) {
		FrmCitiConfeccion frame = new FrmCitiConfeccion();
		escritorio.add(frame);
		frame.setVisible(true);
		frame.setLocation(40,40);
		frame.toFront();
	}
	protected void actionPerformedMniCitiAcabado(ActionEvent e) {
		FrmCitiAcabado frame = new FrmCitiAcabado();
		escritorio.add(frame);
		frame.setVisible(true);
		frame.setLocation(40,40);
		frame.toFront();
	}
	//MANTENIMIENTO - DATA BASE

	protected void actionPerformedMniImportarF10(ActionEvent e) {
		FrmImportarF10 frame = new FrmImportarF10();
		escritorio.add(frame);
		frame.setVisible(true);
	}
	private void actionPerformedMniPrenda(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmPrenda frame = new FrmPrenda();
		frame.setVisible(true);
	}

	private void actionPerformedMniOrdenProduccion(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmOrdenProd frame = new FrmOrdenProd();
		frame.setVisible(true);
	}

	private void actionPerformedMniColorOP(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmColorOP frame = new FrmColorOP();
		frame.setVisible(true);
	}

	private void actionPerformedMniEstiloOP(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmEstiloOP frame = new FrmEstiloOP();
		frame.setVisible(true);
	}
	private void actionPerformedMniCliente(ActionEvent e) {
		// TODO Auto-generated method stub
		FrmCliente frame = new FrmCliente();
		frame.setVisible(true);
	}
	//AYUDA

	private void actionPerformedMniAutor(ActionEvent e) {
		// TODO Auto-generated method stub
		AUTOR dlg = new AUTOR(null,true);
		dlg.setVisible(true);
	}
}
