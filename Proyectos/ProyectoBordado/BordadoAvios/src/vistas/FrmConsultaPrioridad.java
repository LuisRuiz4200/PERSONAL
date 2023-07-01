package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloPrioridad;
import clases.Prioridad;
import reuzables.Custom;

@SuppressWarnings("serial")
public class FrmConsultaPrioridad extends JInternalFrame implements ActionListener{
	private JTable tbPrioridad;
	private JScrollPane spTablaPrioridad;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	private ArregloPrioridad arrPrioridad = new ArregloPrioridad();
	private JButton btnElegir;
	
	public static void main (String[] args) {
		FrmConsultaPrioridad ventana = new FrmConsultaPrioridad();
		ventana.setVisible(true);
	}
	
	public FrmConsultaPrioridad() {
		
		this.setTitle("CONSULTA DE PRIORIDADES");
		this.setBounds(0,0,429,326);
		//this.setLocationRelativeTo(this);
		this.getContentPane().setLayout(null);
		
		this.setLocation(40,40);
		this.setClosable(true);
		this.setMaximizable(true);
		this.setIconifiable(true);
		
		spTablaPrioridad = new JScrollPane();
		spTablaPrioridad.setBounds(10, 46, 393, 231);
		getContentPane().add(spTablaPrioridad);
		
		tbPrioridad = new JTable();
		spTablaPrioridad.setViewportView(tbPrioridad);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("NRO OP");
		modelo.addColumn("COLOR");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("OBSERVACION");
		modelo.addColumn("ORDEN");
		modelo.addColumn("FECHA");
		modelo.addColumn("ESTADO");
		tbPrioridad.setModel(modelo);
		
		tbPrioridad.setAutoResizeMode(0);
		
		btnElegir = new JButton("ELEGIR");
		btnElegir.setBounds(314, 11, 89, 23);
		btnElegir.addActionListener(this);
		getContentPane().add(btnElegir);
		
		arranque();
	}
	
	//METODOS VOID
	
	private void arranque() {
		cargarTabla();
	}
	
	private void cargarTabla() {
		modelo.setRowCount(0);
		
		for (int i=0;i<arrPrioridad.tamano();i++) {
			
			Prioridad obj = arrPrioridad.obtener(i);
			
			Object[] x= new Object[] {
					obj.getId_prioridad(),
					obj.getNro_OP(),
					obj.getColor_OP(),
					obj.getDes_prioridad(),
					obj.getObs_prioridad(),
					obj.getOrden_prioridad(),
					new SimpleDateFormat("dd/MM/yyy").format(obj.getFechaReg_prioridad()),
					obj.getEstado_prioridad()
			};
			
			modelo.addRow(x);
		}
	}
	
	private void exportarPrioridad() {
		int n = tbPrioridad.getSelectedRow();
		
		if (n<0) {
			Custom.mensajeAdvertencia(this, "ELIGA UNA DE LAS FILAS EN LA TABLA");
			return;
		}
		
		int idPrioridad =(int) tbPrioridad.getValueAt(n, 0);
		
		FrmPrioridad frame = new FrmPrioridad();
		FrmPrincipal.escritorio.add(frame);
		frame.setVisible(true);
		frame.toFront();
		
		frame.txtIdPrioridad.setText(idPrioridad + "");
		
		frame.btnAgregar.setEnabled(false);
		frame.btnEditar.setEnabled(true);
		frame.btnEliminar.setEnabled(true);
		
		
		
		
		
		this.dispose();
	}

	//ACTION LISTENER
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnElegir) {
			actionPerformedBtnElegir(e);
		}
	}

	private void actionPerformedBtnElegir(ActionEvent e) {
		// TODO Auto-generated method stub
		exportarPrioridad();
	}
	
	
	
}
