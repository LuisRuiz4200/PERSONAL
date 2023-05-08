package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

public class Ventana extends JFrame implements ActionListener {

	Container c;
	
	JLabel lblRadio;
	JTextField txtRadio;
	JButton btnProcesar;
	JScrollPane spS;
	JTextArea txtS;
	
	

	public static void main (String[] arg) {
		Ventana v= new Ventana();
		v.setVisible(true);
		
		try {
            // select Look and Feel 
           UIManager.setLookAndFeel( "com.jtattoo.plaf.smart.SmartLookAndFeel" );
           // inicia la aplicación 
           new Ventana();
       }
       catch (Exception ex) {
           ex.printStackTrace();
       }
		
		/*List <String> letras = new ArrayList<String>();
		
		letras.add("b");
		letras.add("e");
		letras.add("a");
		letras.add("d");
		letras.add("c");
		
		Collections.sort(letras);
		
		for(String elemento:letras) {
			System.out.println(elemento);
		}*/
	}

	
	public Ventana() {
		
super("Minimal-Frame-Application");
        
        // setup menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menu.setMnemonic(0);
        JMenuItem menuItem = new JMenuItem("Exit");
        menuItem.setMnemonic(0);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_MASK));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        menu.add(menuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
        
        // setup widgets
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(0, 4, 4, 4));
        JScrollPane westPanel = new JScrollPane(new JTree());
        JEditorPane editor = new JEditorPane("text/plain", "Hello World");
        JScrollPane eastPanel = new JScrollPane(editor);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, westPanel,eastPanel);
        splitPane.setDividerLocation(148);
        contentPanel.add(splitPane, BorderLayout.CENTER);
        setContentPane(contentPanel);
        
        // add listeners
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        // show application
        setLocation(32, 32);
        setSize(400, 300);
        show();
		
		/*c=this.getContentPane();
		c.setLayout(null);
		
		lblRadio=new JLabel("Radio: ");
		lblRadio.setBounds(10,10,50,24);
		c.add(lblRadio);
		
		txtRadio=new JTextField();
		txtRadio.setBounds(70,10,60,24);
		c.add(txtRadio);
		
		btnProcesar=new JButton("Procesar");
		btnProcesar.setBounds(140,10,90,24);
		btnProcesar.addActionListener(this);
		c.add(btnProcesar);
		
		spS=new JScrollPane();
		spS.setBounds(10,40,230,230);
		c.add(spS);
		
		
		txtS=new JTextArea();
		spS.setViewportView(txtS);
		
		setSize(300,400);
		setTitle("Circulo");
		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		double r=Double.parseDouble(txtRadio.getText());
		double a=3.1416*r*r;
		
		txtS.setText("Area : " + a);
	}
}
