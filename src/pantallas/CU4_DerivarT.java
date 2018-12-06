package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import clases.GrupoDeResolucion;
import clases.Ticket;
import clasesAuxiliares.ClasificacionAux;
import clasesAuxiliares.GrupoDeResolucionAux;
import clasesAuxiliares.TicketAux;
import gestores.GestorClasificacionDeTicket;
import gestores.GestorGrupoDeResolucion;
import gestores.GestorTicket;

public class CU4_DerivarT extends JPanel {

	private JFrame padre;
	private JPanel anterior;
	private Rectangle boundsAnterior;
	private GestorTicket gt=new GestorTicket();
	private GestorGrupoDeResolucion ggr = new GestorGrupoDeResolucion();
	
	public CU4_DerivarT(TicketAux t, int idUsuario) {

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		setBounds(0, 0, 554, 700);
		Color theme = new Color(38, 79, 111);

		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(CU4_DerivarT.class.getResource("/imagenes/logo2.png")));
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

		JLabel titulo_pantalla = new JLabel("Derivar ticket");
		titulo_pantalla.setVerticalAlignment(SwingConstants.TOP);
		titulo_pantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo_pantalla.setBounds(93, 99, 416, 25);
		this.add(titulo_pantalla);

		//ESTADO ACTUAL

		JLabel lblEstadoActual = new JLabel("Estado actual:");
		lblEstadoActual.setBounds(93, 135, 168, 20);
		this.add(lblEstadoActual);

		JTextField estado = new JTextField();
		estado.setEditable(false);
		estado.setText(t.getEstadoActual());
		estado.setBounds(271, 135, 190, 20);
		this.add(estado);
		estado.setColumns(10);

		//DESCRIPCION 
		JLabel lblDescripcinDelProblema = new JLabel("Descripci\u00F3n del problema:");
		lblDescripcinDelProblema.setBounds(93, 166, 176, 14);
		this.add(lblDescripcinDelProblema);
		
		JTextArea descripcion = new JTextArea();
		descripcion.setLineWrap(true);
		descripcion.setWrapStyleWord(true);
		descripcion.setBounds(93, 191, 368, 95);
		this.add(descripcion);
		descripcion.setColumns(10);
		descripcion.setEditable(false);
		descripcion.setText(t.getDescripcion());
		
		JScrollPane obscroll = new JScrollPane(descripcion);
		obscroll.setBounds(93, 191, 368, 95);
		obscroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(obscroll);

		//NUEVO ESTADO
		JLabel lblNuevoEstado = new JLabel("Nuevo estado:");
		lblNuevoEstado.setBounds(93, 297, 176, 20);
		this.add(lblNuevoEstado);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Abierto derivado" }));
		comboBox.setBounds(271, 297, 190, 20);
		this.add(comboBox);

		

		//CLASIFICACIONES
		
		JLabel lblClasificacinDeTicket = new JLabel("Clasificaci\u00F3n de ticket:");
		lblClasificacinDeTicket.setBounds(93, 328, 168, 20);
		this.add(lblClasificacinDeTicket);

		GestorClasificacionDeTicket gc = new GestorClasificacionDeTicket();
		ArrayList<ClasificacionAux> clasificaciones = gc.getClasificacionesAux();
		JComboBox<ClasificacionAux> comboClasificacion = new JComboBox<ClasificacionAux>();
		
		for (ClasificacionAux c : clasificaciones) {
			comboClasificacion.addItem(c);
			if(c.getId()==t.getClasificacion().getId()) comboClasificacion.setSelectedItem(c);
		}
		comboClasificacion.setBounds(271, 328, 190, 20);
		this.add(comboClasificacion);
		
		
		//GRUPO DE RESOLUCION
		
				JLabel lblNewLabel = new JLabel("Grupo de resoluci\u00F3n:");
				lblNewLabel.setBounds(93, 359, 168, 20);
				this.add(lblNewLabel);
				
				GrupoDeResolucionAux grupo = ggr.getGrupo(t.getClasificacion().getId());
			/*	GestorGrupoDeResolucion ggr = new GestorGrupoDeResolucion();
				GrupoDeResolucionAux grupo = ggr.getGrupo((ClasificacionAux) comboClasificacion.getSelectedItem());
			*/	JComboBox<GrupoDeResolucionAux> comboBox_2 = new JComboBox<GrupoDeResolucionAux>();
				comboBox_2.addItem(grupo);
				comboBox_2.setBounds(271, 359, 190, 20);
				this.add(comboBox_2);
		
		
		//ACCION CLASIFICACIONES
		comboClasificacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idclasif= ((ClasificacionAux)comboClasificacion.getSelectedItem()).getId();
				
				//GrupoDeResolucionAux grupo = actualizarGrupo(grupo,(ClasificacionAux) comboClasificacion.getSelectedItem());
				//comboBox_2.removeAllItems();
				//comboBox_2.addItem(ggr.getGrupo((ClasificacionAux) comboClasificacion.getSelectedItem()));
				
				comboBox_2.removeAllItems();
				
				//BUSCO POR ID DE CLASIFICACION---VER EN GESTOR D GRUPO
				comboBox_2.addItem(ggr.getGrupo(idclasif));
				
			}
		});
		

		
		//OBSERACIONES
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(93, 390, 168, 14);
		this.add(lblObservaciones);
		
		JTextArea observaciones = new JTextArea();
		observaciones.setLineWrap(true);
		observaciones.setWrapStyleWord(true);
		observaciones.setBounds(93, 415, 368, 95);
		this.add(observaciones);
		observaciones.setColumns(10);
		
		JScrollPane obscroll2 = new JScrollPane(observaciones);
		obscroll2.setBounds(93, 415, 368, 95);
		obscroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(obscroll2);
		
		//BOTONES
		
		JButton imprimir_aceptar = new JButton("Aceptar");
		imprimir_aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(observaciones.getText().isEmpty())JOptionPane.showMessageDialog(null,
						"Por favor ingrese una obsevación.",
						"Campos nulos", JOptionPane.ERROR_MESSAGE);
				else {
				GrupoDeResolucionAux g = (GrupoDeResolucionAux) comboBox_2.getSelectedItem();
				ClasificacionAux c = (ClasificacionAux) comboClasificacion.getSelectedItem();
				gt.derivarTicket(t.getIdTicket(), 1, g.getId(), c.getId(), observaciones.getText(), idUsuario);
				removerPanel();
				}
			}
		});
		imprimir_aceptar.setForeground(new Color(255, 255, 255));
		imprimir_aceptar.setBackground(theme);
		imprimir_aceptar.setBounds(268, 620, 130, 40);
		this.add(imprimir_aceptar);
		
		JButton cerrar = new JButton("Cerrar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(anterior.getBounds().height+" adentro "+anterior.getBounds().width); 
				removerPanel();
			}
		});
		cerrar.setBackground(new Color(255, 255, 255));
		cerrar.setBounds(408, 620, 130, 40);
		this.add(cerrar);

	}

	protected GrupoDeResolucionAux actualizarGrupo(GrupoDeResolucionAux grupo, ClasificacionAux c) {
		grupo = ggr.getGrupo(c);
		return grupo;
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
