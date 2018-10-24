package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Mesa_de_ayuda extends JPanel {
	JFrame padre;
	Boolean finalizarPanel=false;

	//private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mesa_de_ayuda frame = new Mesa_de_ayuda();
					frame.setVisible(true);
					
					//PARA QUE APAREZCA CENTRADO
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	 * Create the frame.
	public Mesa_de_ayuda() {
		
		Color theme = new Color(38, 79, 111);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mesa_de_ayuda.class.getResource("/imagenes/favico.png")));
		setTitle("Iniciar sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 568);
		
*/		public Mesa_de_ayuda() {
		Color theme = new Color(38, 79, 111);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		setBounds(0, 0, 460, 568);

		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(Mesa_de_ayuda.class.getResource("/imagenes/logo2.png")));
		Logo.setBounds(16, 0, 300, 95);
		this.add(Logo);
		
		Panel barraIzquierda = new Panel();
		barraIzquierda.setBackground(theme);
		barraIzquierda.setBounds(0, 0, 10, 691);
		this.add(barraIzquierda);
		
		JButton cerrar = new JButton("Salir");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cerrar.setBackground(new Color(255, 255, 255));
		cerrar.setBounds(93, 439, 264, 40);
		this.add(cerrar);

		barraIzquierda.setBackground(theme);
		
		Panel tituloSub = new Panel();
		tituloSub.setBounds(93, 126, 264, 3);
		tituloSub.setBackground(theme);
		this.add(tituloSub);
		
		JLabel titulo_pantalla = new JLabel("Mesa de ayuda");
		titulo_pantalla.setVerticalAlignment(SwingConstants.TOP);
		titulo_pantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo_pantalla.setBounds(93, 99, 416, 25);
		this.add(titulo_pantalla);
		
		JButton consultarTicket = new JButton("Consultar tickets");
		consultarTicket.setBackground(Color.WHITE);
		consultarTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
			public void actionPerformed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					
				}
				
			}
				
		});
		consultarTicket.setBounds(93, 233, 264, 40);
		this.add(consultarTicket);
		
		JButton registrarTicket = new JButton("Registrar ticket");
		registrarTicket.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				CU1_RegistrarT panelRegistrarTicket = new CU1_RegistrarT();
				panelRegistrarTicket.setPadre(padre);
				padre.setContentPane(panelRegistrarTicket);	
				padre.setBounds(panelRegistrarTicket.getBounds());
				padre.setLocationRelativeTo(null);
				try {
					finalizarPanel();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});		
		registrarTicket.setBackground(Color.WHITE);
		registrarTicket.setBounds(93, 182, 264, 40);
		this.add(registrarTicket);
		

	}

	public void setPadre(JFrame padre) {
		this.padre = padre;
	}
	
	public void finalizarPanel() throws Throwable {
		this.finalize();
	}
	
	
}

