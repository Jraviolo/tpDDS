package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clasesAuxiliares.IntervencionAux;
import gestores.GestorBaseDeDatos;
import gestores.GestorTicket;

public class CU8_ActualizarIntervencion extends JPanel {

	private JFrame padre;
	private JPanel anterior;
	private Rectangle boundsAnterior;
	private GestorTicket gt=new GestorTicket();
	private GestorBaseDeDatos gbd=new GestorBaseDeDatos();

	public CU8_ActualizarIntervencion(IntervencionAux intervencion,int idTicket, int idUsuario, int idGrupo) {

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
		JLabel EstadoActual = new JLabel("Estado actual:");
		EstadoActual.setBounds(93, 157, 141, 20);
		this.add(EstadoActual);

		JTextField textEstado = new JTextField();
		textEstado.setEnabled(false);
		textEstado.setHorizontalAlignment(SwingConstants.CENTER);
		textEstado.setEditable(false);
		textEstado.setText(intervencion.getEstadoIntervencion());
		textEstado.setBounds(188, 157, 271, 20);
		this.add(textEstado);
		textEstado.setColumns(10);
		textEstado.setDisabledTextColor(Color.BLACK);

		//DESCRIPCION
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n del problema:");
		lblDescripcin.setBounds(93, 188, 223, 14);
		this.add(lblDescripcin);

		JTextField campoDescripcion = new JTextField();
		campoDescripcion.setEditable(false);
		campoDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		campoDescripcion.setBounds(93, 213, 366, 95);
		this.add(campoDescripcion);
		campoDescripcion.setColumns(10);
		campoDescripcion.setText(gbd.getDescripcionTicket(idTicket));
		
		//NUEVO ESTADO
		
		JLabel lblNuevoEstado = new JLabel("Nuevo estado:");
		lblNuevoEstado.setBounds(93, 319, 141, 20);
		this.add(lblNuevoEstado);

		JComboBox Estado = new JComboBox();
		Estado.setBounds(188, 319, 271, 20);
		this.add(Estado);
		
		System.out.println(intervencion.getIdIntervencion());

		//CLASIFICACION
		JLabel lblClasificacionTicket = new JLabel("Clasificaci\u00F3n del ticket:");
		lblClasificacionTicket.setBounds(93, 347, 141, 20);
		this.add(lblClasificacionTicket);

		JComboBox Clasificacion = new JComboBox();
		Clasificacion.setBounds(227, 348, 232, 20);
		this.add(Clasificacion);

		//OBSERVACIONES
		JLabel lblFechaDeApertura = new JLabel("Observaciones:");
		lblFechaDeApertura.setBounds(93, 378, 141, 20);
		this.add(lblFechaDeApertura);

		JTextField campoObservaciones = new JTextField();
		campoObservaciones.setHorizontalAlignment(SwingConstants.LEFT);
		campoObservaciones.setColumns(10);
		campoObservaciones.setBounds(93, 401, 366, 95);
		this.add(campoObservaciones);
		// txtHhmm.setBorder(null);

		
		//botones
		JButton imprimir_aceptar = new JButton("Aceptar");
		imprimir_aceptar.setForeground(new Color(255, 255, 255));
		imprimir_aceptar.setBackground(theme);
		imprimir_aceptar.setBounds(268, 620, 130, 40);
		this.add(imprimir_aceptar);

		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPanel();
			}
		});
		cancelar.setBackground(new Color(255, 255, 255));
		cancelar.setBounds(408, 620, 130, 40);
		this.add(cancelar);
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