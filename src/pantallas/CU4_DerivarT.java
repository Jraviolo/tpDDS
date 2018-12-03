package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
	private GestorTicket gt;
	
	
	public CU4_DerivarT(TicketAux t,int idUsuario) {

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
		tituloSub.setBounds(93, 126, 264, 3);
		tituloSub.setBackground(theme);
		this.add(tituloSub);
		
		JLabel titulo_pantalla = new JLabel("Derivac\u00F3n de ticket");
		titulo_pantalla.setVerticalAlignment(SwingConstants.TOP);
		titulo_pantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo_pantalla.setBounds(93, 99, 416, 25);
		this.add(titulo_pantalla);
		
		JButton imprimir_aceptar = new JButton("Aceptar");
		imprimir_aceptar.setForeground(new Color(255, 255, 255));
		imprimir_aceptar.setBackground(theme);
		imprimir_aceptar.setBounds(994, 640, 130, 40);
		this.add(imprimir_aceptar);
		
		JLabel lblEstadoActual = new JLabel("Estado actual:");
		lblEstadoActual.setBounds(93, 135, 168, 20);
		this.add(lblEstadoActual);
		
		JTextField estado = new JTextField();
		estado.setEditable(false);
		estado.setText(t.getEstadoActual());
		estado.setBounds(271, 135, 86, 20);
		this.add(estado);
		estado.setColumns(10);
		
		JLabel lblDescripcinDelProblema = new JLabel("Descripci\u00F3n del problema:");
		lblDescripcinDelProblema.setBounds(93, 166, 176, 14);
		this.add(lblDescripcinDelProblema);
		
		JTextField descripcion = new JTextField();
		descripcion.setHorizontalAlignment(SwingConstants.LEFT);
		descripcion.setEditable(false);
		descripcion.setBounds(93, 191, 264, 95);
		this.add(descripcion);
		descripcion.setColumns(10);
		
		JLabel lblNuevoEstado = new JLabel("Nuevo estado:");
		lblNuevoEstado.setBounds(93, 297, 176, 20);
		this.add(lblNuevoEstado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Abierto derivado"}));
		comboBox.setBounds(271, 297, 86, 20);
		this.add(comboBox);
		
		JLabel lblClasificacinDeTicket = new JLabel("Clasificaci\u00F3n de ticket:");
		lblClasificacinDeTicket.setBounds(93, 328, 168, 20);
		this.add(lblClasificacinDeTicket);
		
		GestorClasificacionDeTicket gc = new GestorClasificacionDeTicket();
		ArrayList<ClasificacionAux> clasificaciones = gc.getClasificacionesAux();
		JComboBox<ClasificacionAux> comboClasificacion = new JComboBox<ClasificacionAux>();
		for(ClasificacionAux c: clasificaciones){
			comboClasificacion.addItem(c);
		}
		comboClasificacion.setBounds(271, 328, 86, 20);
		this.add(comboClasificacion);
		

		JLabel lblNewLabel = new JLabel("Grupo de resoluci\u00F3n:");
		lblNewLabel.setBounds(93, 359, 168, 20);
		this.add(lblNewLabel);
		
		GestorGrupoDeResolucion ggr = new GestorGrupoDeResolucion();
		GrupoDeResolucionAux grupo = ggr.getGrupo((ClasificacionAux)comboClasificacion.getSelectedItem());
		JComboBox<GrupoDeResolucionAux> comboBox_2 = new JComboBox<GrupoDeResolucionAux>();
			comboBox_2.addItem(grupo);	
		comboBox_2.setBounds(271, 359, 86, 20);
		this.add(comboBox_2);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(93, 390, 168, 14);
		this.add(lblObservaciones);
		
		JTextField observaciones = new JTextField();
		observaciones.setBounds(93, 415, 264, 95);
		this.add(observaciones);
		observaciones.setColumns(10);
		

	}
	
	public void setPadre(JFrame padre) {
		this.padre = padre;
	}

	public void removerPanel() {
		padre.remove(this);
		padre.setContentPane(anterior);
		padre.setBounds(anterior.getBounds());
		padre.setLocationRelativeTo(null);
	}

	public void setAnterior(JPanel anterior) {
		this.anterior = anterior;
	}
}
