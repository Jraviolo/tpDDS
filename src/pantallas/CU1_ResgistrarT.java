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
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JComboBox;

public class CU1_ResgistrarT extends JFrame {
	

	private JPanel contentPane;
	private JTextField textNro_de_ticket;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtDdmmaaaa;
	private JTextField txtHhmm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CU1_ResgistrarT frame = new CU1_ResgistrarT();
					frame.setVisible(true);
					
					//PARA QUE APAREZCA CENTRADO
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CU1_ResgistrarT() {
		setBackground(Color.BLUE);
		
		Color theme = new Color(38, 79, 111);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CU1_ResgistrarT.class.getResource("/imagenes/favico.png")));
		setTitle("Registrar ticket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(CU1_ResgistrarT.class.getResource("/imagenes/logo2.png")));
		Logo.setBounds(16, 0, 300, 95);
		contentPane.add(Logo);
		
		Panel barraIzquierda = new Panel();
		barraIzquierda.setBackground(theme);
		barraIzquierda.setBounds(0, 0, 10, 691);
		contentPane.add(barraIzquierda);
		
		JButton cerrar = new JButton("Cancelar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cerrar.setBackground(new Color(255, 255, 255));

		barraIzquierda.setBackground(theme);
		
		Panel tituloSub = new Panel();
		tituloSub.setBounds(93,126,368,3);
		tituloSub.setBackground(theme);
		contentPane.add(tituloSub);
		
		JLabel titulo_pantalla = new JLabel("Registraci\u00F3n de ticket");
		titulo_pantalla.setVerticalAlignment(SwingConstants.TOP);
		titulo_pantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo_pantalla.setBounds(93, 99, 416, 25);
		contentPane.add(titulo_pantalla);
		cerrar.setBounds(408, 620, 130, 40);
		contentPane.add(cerrar);
		
		JButton imprimir_aceptar = new JButton("Registrar ticket");
		imprimir_aceptar.setForeground(new Color(255, 255, 255));
		imprimir_aceptar.setBackground(theme);
		imprimir_aceptar.setBounds(268, 620, 130, 40);
		contentPane.add(imprimir_aceptar);
		
		JLabel Nro_de_ticket = new JLabel("N\u00FAmero de ticket:");
		Nro_de_ticket.setBounds(93, 157, 141, 20);
		contentPane.add(Nro_de_ticket);
		
		textNro_de_ticket = new JTextField();
		textNro_de_ticket.setEnabled(false);
		textNro_de_ticket.setHorizontalAlignment(SwingConstants.CENTER);
		textNro_de_ticket.setEditable(false);
		textNro_de_ticket.setText("999999999");
		textNro_de_ticket.setBounds(230, 157, 231, 20);
		contentPane.add(textNro_de_ticket);
		textNro_de_ticket.setColumns(10);
		textNro_de_ticket.setDisabledTextColor(Color.BLACK);
		
		JLabel Nro_de_legajo = new JLabel("Nro de legajo:");
		Nro_de_legajo.setBounds(93, 180, 141, 14);
		contentPane.add(Nro_de_ticket);
		
		JLabel lblNroDeLegajo = new JLabel("N\u00FAmero de legajo:");
		lblNroDeLegajo.setBounds(93, 185, 141, 20);
		contentPane.add(lblNroDeLegajo);
		
		textField = new JTextField();
		textField.setBounds(230, 185, 231, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblClasificacionTicket = new JLabel("Clasificaci\u00F3n ticket:");
		lblClasificacionTicket.setBounds(93, 216, 141, 20);
		contentPane.add(lblClasificacionTicket);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(230, 216, 231, 20);
		contentPane.add(comboBox);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n del problema:");
		lblDescripcin.setBounds(93, 247, 223, 14);
		contentPane.add(lblDescripcin);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setBounds(93, 272, 368, 95);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFechaDeApertura = new JLabel("Fecha de apertura:");
		lblFechaDeApertura.setBounds(93, 378, 141, 20);
		contentPane.add(lblFechaDeApertura);
		
		txtDdmmaaaa = new JTextField();
		txtDdmmaaaa.setEnabled(false);
		txtDdmmaaaa.setHorizontalAlignment(SwingConstants.CENTER);
		txtDdmmaaaa.setEditable(false);
		txtDdmmaaaa.setText("dd/mm/aaaa");
		txtDdmmaaaa.setBounds(230, 378, 86, 20);
		contentPane.add(txtDdmmaaaa);
		txtDdmmaaaa.setColumns(10);
		txtDdmmaaaa.setDisabledTextColor(Color.BLACK);
		
		JLabel lblHoraDeApertura = new JLabel("Hora de apertura:");
		lblHoraDeApertura.setBounds(93, 409, 141, 14);
		contentPane.add(lblHoraDeApertura);
		
		txtHhmm = new JTextField();
		txtHhmm.setEnabled(false);
		txtHhmm.setHorizontalAlignment(SwingConstants.CENTER);
		txtHhmm.setEditable(false);
		txtHhmm.setText("hh:mm");
		txtHhmm.setBounds(230, 406, 86, 20);
		contentPane.add(txtHhmm);
		txtHhmm.setColumns(10);
		txtHhmm.setDisabledTextColor(Color.BLACK);
		//txtHhmm.setBorder(null);

	}
}
