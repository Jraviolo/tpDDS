package pantallas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.GrupoDeResolucion;
import clasesAuxiliares.ClasificacionAux;
import clasesAuxiliares.GrupoDeResolucionAux;
import gestores.GestorGrupoDeResolucion;
import gestores.GestorTicket;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class Observaciones extends JDialog {
	

	private JPanel contentPane;
	private JTextArea textField;
	private JScrollPane obscroll;
	
	private GestorTicket gt=new GestorTicket();
	private GestorGrupoDeResolucion gg=new GestorGrupoDeResolucion();

	public Observaciones(Frame parent, boolean modal,int idTicket,int idUsuario,int idclasificacion) {
		super(parent, modal);
		Color theme = new Color(38, 79, 111);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Observaciones.class.getResource("/imagenes/favico.png")));
		setTitle("Registrar ticket - Observaciones");
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100,100,544,600);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(Observaciones.class.getResource("/imagenes/logo2.png")));
		Logo.setBounds(16, 0, 300, 95);
		contentPane.add(Logo);
		
		Panel barraIzquierda = new Panel();
		barraIzquierda.setBackground(theme);
		barraIzquierda.setBounds(0, 0, 10, 691);
		contentPane.add(barraIzquierda);

		barraIzquierda.setBackground(theme);
		
		Panel tituloSub = new Panel();
		tituloSub.setBounds(93,126,368,3);
		tituloSub.setBackground(theme);
		contentPane.add(tituloSub);
		
		//OBSERVACIONES
		
		JLabel titulo_pantalla = new JLabel("Observaciones");
		titulo_pantalla.setVerticalAlignment(SwingConstants.TOP);
		titulo_pantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo_pantalla.setBounds(93, 99, 416, 25);
		contentPane.add(titulo_pantalla);
		
		textField = new JTextArea();
		textField.setBounds(93, 135, 368, 200);
		textField.setLineWrap(true);
		textField.setWrapStyleWord(true);
		contentPane.add(textField);
		textField.setColumns(10);
		
		obscroll = new JScrollPane(textField);
		obscroll.setBounds(93, 135, 368, 200);
		obscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(obscroll);
		
		
		//MULTICHECK
		
		JRadioButton rdbtnResuelto = new JRadioButton("Resuelto");
		rdbtnResuelto.setBounds(93, 363, 109, 23);
		contentPane.add(rdbtnResuelto);
		
		JRadioButton rdbtnEderivarAGrupo = new JRadioButton("Derivar a grupo de soporte:");
		rdbtnEderivarAGrupo.setBounds(93, 389, 223, 23);
		contentPane.add(rdbtnEderivarAGrupo);
		
		//combobox grupos
		
		
		
		
		JComboBox<GrupoDeResolucionAux> comboBox = new JComboBox<GrupoDeResolucionAux>();
		/*
		ArrayList<GrupoDeResolucionAux> c=gg.getGruposAux();
		for(int j = 0; j < c.size(); j++)
			comboBox.addItem(c.get(j));*/
		
		GrupoDeResolucionAux g=gg.getGrupo(idclasificacion);
		comboBox.addItem(g);
		comboBox.setBounds(93, 420, 368, 23);
		contentPane.add(comboBox);
		comboBox.setEnabled(false);
		
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnResuelto);
		group.add(rdbtnEderivarAGrupo);
		
		
		
		rdbtnEderivarAGrupo.addItemListener(new ItemListener() {
			 
		    @Override
		    public void itemStateChanged(ItemEvent event) {
		        int state = event.getStateChange();
		        if (state == ItemEvent.SELECTED)comboBox.setEnabled(true);
		        else if (state == ItemEvent.DESELECTED)	comboBox.setEnabled(false);
		    }
		});
		
		
		//BOTON
		JButton imprimir_aceptar = new JButton("Finalizar");
		imprimir_aceptar.addActionListener( e ->{
			
			if(textField.getText().isEmpty() || textField.getText().length()>299) {
				JOptionPane.showMessageDialog(new JPanel(),"El campo observaciones no puede estar vacio","Error",JOptionPane.ERROR_MESSAGE);
			}
			else if(!rdbtnResuelto.isSelected() && !rdbtnEderivarAGrupo.isSelected()) {
				JOptionPane.showMessageDialog(new JPanel(),"Debe seleccionar una opcion","Error",JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				String selectedOption = "";
				if (rdbtnResuelto.isSelected()) {
					selectedOption = "Marcar el ticket como RESUELTO";
				} else if (rdbtnEderivarAGrupo.isSelected()) {
					selectedOption = "DERIVAR A GRUPO ";
				}
				
				
				Object[] options = { "Confirmar", "Cancelar" };
				int op = JOptionPane.showOptionDialog(null, selectedOption, "Warning",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);
				
				if (op==0) {
					if (rdbtnResuelto.isSelected()) {
						int idgrupo=1;
						gt.cerrarTicket(idTicket,textField.getText(),idUsuario,idgrupo);
					} else if (rdbtnEderivarAGrupo.isSelected()) {
						//derivar
						int idGrupo = ((GrupoDeResolucionAux) comboBox.getSelectedItem()).getId();
						gt.derivarTicket(idTicket,textField.getText(),idUsuario,idGrupo);

					}
					this.setVisible(false);
				}
				
				
			}
		});
		imprimir_aceptar.setForeground(new Color(255, 255, 255));
		imprimir_aceptar.setBackground(theme);
		imprimir_aceptar.setBounds(331,501,130,40);
		contentPane.add(imprimir_aceptar);
	}
}
