package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.EstadoIntervencion;
import clasesAuxiliares.ClasificacionAux;
import clasesAuxiliares.IntervencionAux;
import gestores.GestorBaseDeDatos;
import gestores.GestorClasificacionDeTicket;
import gestores.GestorTicket;

public class CU8_ActualizarIntervencion extends JPanel {

	private JFrame padre;
	private JPanel anterior;
	private Rectangle boundsAnterior;
	private GestorTicket gt=new GestorTicket();
	private GestorBaseDeDatos gbd=new GestorBaseDeDatos();
	private GestorClasificacionDeTicket gc=new GestorClasificacionDeTicket();

	public CU8_ActualizarIntervencion(IntervencionAux intervencion,int idTicket, int idUsuario, int idGrupo) {

		
		String clasificacionActual=intervencion.getClasificacion().getNombre();
		String estadoActual=intervencion.getEstadoIntervencion();
		int idIntervencion=intervencion.getIdIntervencion();
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		setBounds(0, 0, 554, 700);
		Color theme = new Color(38, 79, 111);

		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(CU8_ActualizarIntervencion.class.getResource("/imagenes/logo2.png")));
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

		JLabel titulo_pantalla = new JLabel("Actualizar estado de la intervención");
		titulo_pantalla.setVerticalAlignment(SwingConstants.TOP);
		titulo_pantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo_pantalla.setBounds(93, 99, 416, 25);
		this.add(titulo_pantalla);

		//ESTADO ACTUAL
		JLabel ea = new JLabel("Estado actual:");
		ea.setBounds(93, 157, 141, 20);
		this.add(ea);

		JTextField textEstado = new JTextField();
		textEstado.setEnabled(false);
		textEstado.setHorizontalAlignment(SwingConstants.CENTER);
		textEstado.setEditable(false);
		textEstado.setText(estadoActual);
		textEstado.setBounds(188, 157, 271, 20);
		this.add(textEstado);
		textEstado.setColumns(10);
		textEstado.setDisabledTextColor(Color.BLACK);

		//DESCRIPCION		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n del problema:");
		lblDescripcin.setBounds(93, 188, 223, 14);
		this.add(lblDescripcin);
		
		JTextArea ob = new JTextArea();
		ob.setLineWrap(true);
		ob.setWrapStyleWord(true);
		ob.setBounds(93, 213, 366, 95);
		this.add(ob);
		ob.setColumns(10);
		ob.setText(gbd.getDescripcionTicket(idTicket));
		ob.setEditable(false);
		
		
		JScrollPane obscroll = new JScrollPane(ob);
		obscroll.setBounds(93, 213, 366, 95);
		obscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(obscroll);
		
		//NUEVO ESTADO
		
		JLabel lblNuevoEstado = new JLabel("Nuevo estado:");
		lblNuevoEstado.setBounds(93, 319, 141, 20);
		this.add(lblNuevoEstado);
		
		ArrayList<EstadoIntervencion> estados=this.estadosIntervencion(estadoActual);
		JComboBox<EstadoIntervencion> Estado = new JComboBox<EstadoIntervencion>();
		Estado.setBounds(188, 319, 271, 20);
		this.add(Estado);
		for(EstadoIntervencion e:estados)Estado.addItem(e);
		
		
		System.out.println(intervencion.getIdIntervencion());

		//CLASIFICACION
		JLabel lblClasificacionTicket = new JLabel("Clasificaci\u00F3n del ticket:");
		lblClasificacionTicket.setBounds(93, 347, 141, 20);
		this.add(lblClasificacionTicket);

		ArrayList<ClasificacionAux> clasificaciones=gc.getClasificacionesAux(idGrupo);
		JComboBox<ClasificacionAux> Clasificacion = new JComboBox<ClasificacionAux>();
		for(ClasificacionAux c:clasificaciones) {
			Clasificacion.addItem(c);
			if(clasificacionActual.equals(c.getNombre())) Clasificacion.setSelectedItem(c);
		}
		
		
		Clasificacion.setBounds(227, 348, 232, 20);
		this.add(Clasificacion);

		//OBSERVACIONES
		JLabel lblFechaDeApertura = new JLabel("Observaciones:");
		lblFechaDeApertura.setBounds(93, 378, 141, 20);
		this.add(lblFechaDeApertura);
		
		JTextArea campoObservaciones = new JTextArea();
		campoObservaciones.setLineWrap(true);
		campoObservaciones.setWrapStyleWord(true);
		campoObservaciones.setBounds(93, 401, 366, 95);
		this.add(campoObservaciones);
		campoObservaciones.setColumns(10);
		
		
		JScrollPane obscroll2 = new JScrollPane(campoObservaciones);
		obscroll2.setBounds(93, 401, 366, 95);
		obscroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(obscroll2);

		//box mesa
		JCheckBox Mesachckbx = new JCheckBox();
		Mesachckbx .setBounds(93, 503, 305, 23);
		add(Mesachckbx);
		if(estadoActual.equals("Asignada")) Mesachckbx.setText("Este ticket no pertenece a este grupo");
		if(estadoActual.equals("Trabajando")) Mesachckbx.setText("Solicitar otra intervencion");
		
		if(((EstadoIntervencion)Estado.getSelectedItem()).getId()==1) {
			Mesachckbx.setSelected(false);
			Mesachckbx.setEnabled(false);
		}
		else if(((EstadoIntervencion)Estado.getSelectedItem()).getId()==3) {
			Mesachckbx.setSelected(false);
			Mesachckbx.setEnabled(false);
		}
		else if(((EstadoIntervencion)Estado.getSelectedItem()).getId()==2 && estadoActual.equals("Asignada")) {
			Mesachckbx.setSelected(true);
			Mesachckbx.setEnabled(false);
		}
		else Mesachckbx.setEnabled(true);
		
		//botones
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idEstadoIntervencion=((EstadoIntervencion)Estado.getSelectedItem()).getId();
				int idClasificacion=((ClasificacionAux)Clasificacion.getSelectedItem()).getId();
				String obs= campoObservaciones.getText();
				boolean mesa=Mesachckbx.isSelected();
				
				System.out.println("id intervencion:"+idEstadoIntervencion);
				System.out.println("id clasificacion:" +idClasificacion);
				System.out.println("obs:"+obs);
				System.out.println("mesa:"+mesa);
				
				if(obs.isEmpty()) JOptionPane.showMessageDialog(null,
						"Por favor ingrese una obsevación.",
						"Campos nulos", JOptionPane.ERROR_MESSAGE);
				else {gt.ActualizarEstadoI(idTicket,idIntervencion, idEstadoIntervencion, idClasificacion, obs, idUsuario, mesa);
				removerPanel();}
			}
		});
		aceptar.setForeground(new Color(255, 255, 255));
		aceptar.setBackground(theme);
		aceptar.setBounds(268, 620, 130, 40);
		this.add(aceptar);

		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPanel();
			}
		});
		cancelar.setBackground(new Color(255, 255, 255));
		cancelar.setBounds(408, 620, 130, 40);
		this.add(cancelar);
		
		//ACCCION ESTADO
		Estado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(((EstadoIntervencion)Estado.getSelectedItem()).getId()==1) {
					Mesachckbx.setSelected(false);
					Mesachckbx.setEnabled(false);
				}
				else if(((EstadoIntervencion)Estado.getSelectedItem()).getId()==3) {
					Mesachckbx.setSelected(false);
					Mesachckbx.setEnabled(false);
				}
				else if(((EstadoIntervencion)Estado.getSelectedItem()).getId()==2 && estadoActual.equals("Asignada")) {
					Mesachckbx.setSelected(true);
					Mesachckbx.setEnabled(false);
				}
				else Mesachckbx.setEnabled(true);
				
			}
		});
	}

	public ArrayList<EstadoIntervencion> estadosIntervencion(String estadoActual) {
		ArrayList<EstadoIntervencion> estados=new ArrayList<EstadoIntervencion>();
		EstadoIntervencion e1;
		if(estadoActual.equals("Asignada")) {
			e1=gbd.buscarEstadoIntervencion(2);
			estados.add(e1);
			e1=gbd.buscarEstadoIntervencion(3);
			estados.add(e1);
		}
		else if(estadoActual.equals("Trabajando")) {
			e1=gbd.buscarEstadoIntervencion(1);
			estados.add(e1);
			e1=gbd.buscarEstadoIntervencion(2);
			estados.add(e1);
		}
		return estados;
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