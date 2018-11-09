package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import clases.ClasificacionDeTicket;
import gestores.GestorClasificacionDeTicket;
import gestores.GestorTicket;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class CU1_RegistrarT extends JPanel {
	
	private JPanel anterior;
	private JFrame padre;
	private JTextField textNro_de_ticket;
	private JTextField legajo;
	private JTextArea ob;
	private JScrollPane obscroll;
	private JTextField txtDdmmaaaa;
	private JTextField txtHhmm;
	
	private GestorTicket gt=new GestorTicket();
	private GestorClasificacionDeTicket gc=new GestorClasificacionDeTicket();

	public CU1_RegistrarT(int idUsuario2,int idgrupo2) {
		
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
		Logo.setIcon(new ImageIcon(CU1_RegistrarT.class.getResource("/imagenes/logo2.png")));
		Logo.setBounds(16, 0, 300, 95);
		this.add(Logo);

		Panel barraIzquierda = new Panel();
		barraIzquierda.setBackground(theme);
		barraIzquierda.setBounds(0, 0, 10, 691);
		this.add(barraIzquierda);

		barraIzquierda.setBackground(theme);

		Panel tituloSub = new Panel();
		tituloSub.setBounds(93, 126, 368, 3);
		tituloSub.setBackground(theme);
		this.add(tituloSub);

		JLabel titulo_pantalla = new JLabel("Registraci\u00F3n de ticket");
		titulo_pantalla.setVerticalAlignment(SwingConstants.TOP);
		titulo_pantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo_pantalla.setBounds(93, 99, 416, 25);
		this.add(titulo_pantalla);

		
		//NUMERO TICKET
		JLabel Nro_de_ticket = new JLabel("N\u00FAmero de ticket:");
		Nro_de_ticket.setBounds(93, 157, 141, 20);
		this.add(Nro_de_ticket);

		
		//--Pide el ultimo id y le suma 1 para un nuevo ticket
		int idTicket=gt.ultimoIdTicket()+1;
		
		
		textNro_de_ticket = new JTextField();
		textNro_de_ticket.setEnabled(false);
		textNro_de_ticket.setHorizontalAlignment(SwingConstants.CENTER);
		textNro_de_ticket.setEditable(false);
		textNro_de_ticket.setText(String.valueOf(idTicket));
		textNro_de_ticket.setBounds(230, 157, 231, 20);
		this.add(textNro_de_ticket);
		textNro_de_ticket.setColumns(10);
		textNro_de_ticket.setDisabledTextColor(Color.BLACK);

		
		//NUMERO DE LEGAJO
		JLabel lblNroDeLegajo = new JLabel("N\u00FAmero de legajo:");
		lblNroDeLegajo.setBounds(93, 185, 141, 20);
		this.add(lblNroDeLegajo);

		legajo = new JTextField();
		legajo.setBounds(230, 185, 231, 20);
		legajo.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(legajo);
		legajo.setColumns(10);
		
		//CLASIFICACION 
		JLabel lblClasificacionTicket = new JLabel("Clasificaci\u00F3n ticket:");
		lblClasificacionTicket.setBounds(93, 216, 141, 20);
		this.add(lblClasificacionTicket);

		
		ArrayList<ClasificacionDeTicket> c=gc.getClasificaciones();
		
		JComboBox<ClasificacionDeTicket> clasificacion = new JComboBox<ClasificacionDeTicket>();
		for(int j = 0; j < c.size(); j++)
			clasificacion.addItem(c.get(j));
		
		clasificacion.setBounds(230, 216, 231, 20);
		this.add(clasificacion);
		
		

		// DESCRIPICION
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n del problema:");
		lblDescripcin.setBounds(93, 247, 223, 14);
		this.add(lblDescripcin);

		ob = new JTextArea();
		ob.setLineWrap(true);
		ob.setWrapStyleWord(true);
		ob.setBounds(93, 272, 368, 95);
		this.add(ob);
		ob.setColumns(10);
		ob.setText("");

		obscroll = new JScrollPane(ob);
		obscroll.setBounds(93, 272, 368, 95);
		obscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(obscroll);

		// FECHA Y HORA 
			//now is fecha actual
		Date now = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat h = new SimpleDateFormat("hh:mm a");
		String fecha = f.format(now);
		String hora = h.format(now);

		JLabel lblFechaDeApertura = new JLabel("Fecha de apertura:");
		lblFechaDeApertura.setBounds(93, 378, 141, 20);
		this.add(lblFechaDeApertura);

		txtDdmmaaaa = new JTextField();
		txtDdmmaaaa.setHorizontalAlignment(SwingConstants.CENTER);
		txtDdmmaaaa.setEditable(false);
		txtDdmmaaaa.setText(fecha);
		txtDdmmaaaa.setBounds(230, 378, 86, 20);
		this.add(txtDdmmaaaa);
		txtDdmmaaaa.setDisabledTextColor(Color.BLACK);

		JLabel lblHoraDeApertura = new JLabel("Hora de apertura:");
		lblHoraDeApertura.setBounds(93, 409, 141, 14);
		this.add(lblHoraDeApertura);

		txtHhmm = new JTextField();
		txtHhmm.setHorizontalAlignment(SwingConstants.CENTER);
		txtHhmm.setEditable(false);
		txtHhmm.setText(hora);
		txtHhmm.setBounds(230, 406, 86, 20);
		this.add(txtHhmm);
		txtHhmm.setDisabledTextColor(Color.BLACK);

		
		//BOTONES
		JButton registrar = new JButton("Registrar ticket");
		registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(legajo.getText().isEmpty() || ob.getText().isEmpty()) JOptionPane.showMessageDialog(new JPanel(),
					    "Los campos no deben ser nulos.",
					    "Campos nulos",
					    JOptionPane.ERROR_MESSAGE);
				else {
					String leg=legajo.getText();
					if (leg.matches("[0-9]+") && leg.length() > 2) {
						int l=Integer.valueOf(leg);
						
						int idClasificacion= ((ClasificacionDeTicket) clasificacion.getSelectedItem()).getIdClasificacion();
						System.out.println(String.valueOf(idClasificacion));
						
						//gt.registrarTicket(l, idClasificacion, ob.getText(), idUsuiario, idgrupo,now);
						
						Observaciones asd = new Observaciones(new JFrame(),true,idTicket,idUsuario);
						asd.setVisible(true);
						removerPanel();
					}
					else {
						JOptionPane.showMessageDialog(new JPanel(),"Legajo debe contener solo numeros","Error Legajo",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		registrar.setForeground(new Color(255, 255, 255));
		registrar.setBackground(theme);
		registrar.setBounds(268, 620, 130, 40);
		this.add(registrar);

		JButton cerrar = new JButton("Cancelar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPanel();
			}
		});
		cerrar.setBackground(new Color(255, 255, 255));
		cerrar.setBounds(408, 620, 130, 40);
		this.add(cerrar);
	}

	public JFrame getPadre() {
		return padre;
	}

	public void setPadre(JFrame padre) {
		this.padre = padre;
	}
	
	public void removerPanel(){
		padre.remove(this);
		padre.setContentPane(anterior);
	}
	
	public void setAnterior(JPanel anterior) {
		this.anterior=anterior;
	}

}
