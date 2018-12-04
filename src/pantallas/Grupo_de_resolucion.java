package pantallas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Rectangle;

import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Grupo_de_resolucion extends JPanel {

	private JFrame padre;
	private JPanel anterior;
	private JPanel panel = this;
	private Rectangle boundsAnterior;
	
	public Grupo_de_resolucion(int idUsuario2,int idgrupo2) {
		
		//                       SACAR EL 2DE ID
		//tiene que venir de la otra interfaz 
		//int 
		int idUsuario=1;
		int idgrupo=1;
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		setBounds(0, 0, 554, 700);
		Color theme = new Color(38, 79, 111);

		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(Grupo_de_resolucion.class.getResource("/imagenes/logo2.png")));
		Logo.setBounds(16, 0, 300, 95);
		this.add(Logo);
		
		Panel barraIzquierda = new Panel();
		barraIzquierda.setBackground(theme);
		barraIzquierda.setBounds(0, 0, 10, 691);
		this.add(barraIzquierda);
		
		JButton cerrar = new JButton("Salir");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			removerPanel();
			}
		});
		cerrar.setBackground(new Color(255, 255, 255));
		cerrar.setBounds(145, 439, 264, 40);
		this.add(cerrar);

		barraIzquierda.setBackground(theme);
		
		Panel tituloSub = new Panel();
		tituloSub.setBounds(93, 126, 368, 3);
		tituloSub.setBackground(theme);
		this.add(tituloSub);
		
		JLabel titulo_pantalla = new JLabel("Grupos de resoluci\u00F3n");
		titulo_pantalla.setVerticalAlignment(SwingConstants.TOP);
		titulo_pantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo_pantalla.setBounds(93, 99, 416, 25);
		this.add(titulo_pantalla);
		
		JButton btnNewButton = new JButton("Registrar clasificacion de tickets");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(145, 233, 264, 40);
		this.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consultar intervenciones asignadas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CU7_ConsultarIntervenciones panelConsultarIntervenciones = new CU7_ConsultarIntervenciones(idUsuario, idgrupo);
				panelConsultarIntervenciones.setPadre(padre);
				panelConsultarIntervenciones.setAnterior(panel);
				panelConsultarIntervenciones.setBoundsAnterior(new Rectangle(0, 0, 554, 700));
				padre.setContentPane(panelConsultarIntervenciones);
				padre.setBounds(panelConsultarIntervenciones.getBounds());
				padre.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(145, 182, 264, 40);
		this.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Buscar clasificacion tickets");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(145, 284, 264, 40);
		this.add(btnNewButton_2);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewButton_1, btnNewButton, btnNewButton_2, cerrar}));
		

	}
	

	public void setPadre(JFrame padre) {
		this.padre = padre;
	}

	public void removerPanel() {
		padre.remove(this);
		padre.setContentPane(anterior);
		padre.setBounds(boundsAnterior);
		padre.setLocationRelativeTo(null);
	}

	public void setAnterior(JPanel anterior) {
		this.anterior = anterior;
	}

	public void setBoundsAnterior(Rectangle bounds) {
		this.boundsAnterior=bounds;
		
	}
}