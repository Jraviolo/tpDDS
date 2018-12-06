package pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import gestores.GestorClasificacionDeTicket;
import gestores.GestorGrupoDeResolucion;
import gestores.GestorTicket;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Rectangle;

import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.DefaultComboBoxModel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import clases.ClasificacionDeTicket;
import clases.EstadoTicket;
import clases.GrupoDeResolucion;
import clases.Ticket;
import clasesAuxiliares.ClasificacionAux;
import clasesAuxiliares.GrupoDeResolucionAux;
import clasesAuxiliares.TicketAux;

import java.awt.Component;

public class CU2_ConsultarT extends JPanel {

	private JFrame padre;
	private JPanel anterior;
	private JPanel panel = this;
	private Rectangle boundsAnterior;
	private JTextField numeroTicket;
	private JTextField numeroLegajo;
	private JTextField fechaApertura;
	private JTextField fechaUltCambio;
	private JComboBox<ClasificacionAux> comboClasificacion;
	private JComboBox<EstadoTicket> comboEstado;
	private JComboBox<GrupoDeResolucion> comboUltGrupo;
	private JButton confreporte;
	private int seleccion;
	private JTable table_1;
	private GestorTicket gt = new GestorTicket();
	private GestorClasificacionDeTicket gc = new GestorClasificacionDeTicket();
	private GestorGrupoDeResolucion ggr = new GestorGrupoDeResolucion();
	private ConsultarTableModel tableModel = new ConsultarTableModel();

	public CU2_ConsultarT(int idUsuario, int idGrupo) {

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		setBounds(0, 0, 1281, 720);
		Color theme = new Color(38, 79, 111);

		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(CU2_ConsultarT.class.getResource("/imagenes/logo2.png")));
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

		JLabel titulo_pantalla = new JLabel("Consultar tickets");
		titulo_pantalla.setVerticalAlignment(SwingConstants.TOP);
		titulo_pantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo_pantalla.setBounds(93, 99, 416, 25);
		this.add(titulo_pantalla);

		numeroTicket = new JTextField();
		numeroTicket.setBounds(204, 142, 134, 20);
		this.add(numeroTicket);
		numeroTicket.setColumns(10);

		numeroLegajo = new JTextField();
		numeroLegajo.setBounds(204, 173, 134, 20);
		this.add(numeroLegajo);
		numeroLegajo.setColumns(10);

		ArrayList<ClasificacionAux> c = gc.getClasificacionesAux();

		JComboBox<ClasificacionAux> comboClasificacion = new JComboBox<ClasificacionAux>();
		comboClasificacion.setModel(new DefaultComboBoxModel(new String[] { "Todas" }));
		for (int j = 0; j < c.size(); j++)
			comboClasificacion.addItem(c.get(j));
		comboClasificacion.setBounds(489, 142, 185, 20);
		this.add(comboClasificacion);

		JComboBox comboEstado = new JComboBox();
		comboEstado.setModel(new DefaultComboBoxModel(new String[] { "Abierto sin derivar", "Abierto derivado",
				"Solucionado a la espera ok", "Cerrado", "Todos" }));
		comboEstado.setBounds(489, 173, 185, 20);
		this.add(comboEstado);

		fechaApertura = new JTextField();
		fechaApertura.setHorizontalAlignment(SwingConstants.CENTER);
		fechaApertura.setBounds(915, 142, 134, 20);
		this.add(fechaApertura);
		fechaApertura.setColumns(10);

		fechaUltCambio = new JTextField();
		fechaUltCambio.setHorizontalAlignment(SwingConstants.CENTER);
		fechaUltCambio.setBounds(915, 173, 134, 20);
		this.add(fechaUltCambio);
		fechaUltCambio.setColumns(10);

		ArrayList<GrupoDeResolucionAux> g = ggr.getGruposAux();

		JComboBox<GrupoDeResolucionAux> comboUltGrupo = new JComboBox<GrupoDeResolucionAux>();
		comboUltGrupo.setModel(new DefaultComboBoxModel(new String[] { "Todos" }));
		for (int j = 0; j < g.size(); j++)
			comboUltGrupo.addItem(g.get(j));
		comboUltGrupo.setBounds(326, 204, 185, 20);
		this.add(comboUltGrupo);

		JLabel lblNewLabel = new JLabel("N\u00FAmero de ticket:");
		lblNewLabel.setBounds(93, 141, 105, 20);
		this.add(lblNewLabel);

		JLabel lblNmeroDeLegajo = new JLabel("N\u00FAmero de legajo:");
		lblNmeroDeLegajo.setBounds(93, 172, 105, 20);
		this.add(lblNmeroDeLegajo);

		JLabel lblNewLabel_1 = new JLabel("Clasificaci\u00F3n actual:");
		lblNewLabel_1.setBounds(369, 141, 223, 20);
		this.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Estado actual:");
		lblNewLabel_2.setBounds(369, 172, 223, 20);
		this.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Fecha de apertura:");
		lblNewLabel_3.setBounds(700, 142, 223, 20);
		this.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Fecha del ultimo cambio de estado:");
		lblNewLabel_4.setBounds(700, 173, 223, 20);
		this.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Ultimo grupo de resoluci\u00F3n asignado:");
		lblNewLabel_5.setBounds(93, 204, 223, 20);
		this.add(lblNewLabel_5);

		table_1 = new JTable(this.tableModel);
		table_1.setFillsViewportHeight(true);
		table_1.setBounds(109, 266, 607, -95);
		JScrollPane JS = new JScrollPane(table_1);
		JS.setSize(1171, 394);
		JS.setLocation(93, 235);
		JS.setPreferredSize(new Dimension(400, 400));
		this.add(JS);

		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int r = table_1.rowAtPoint(e.getPoint());
				seleccion = r;

			}

		});

		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date fechaActual = new Date();
				Date fApertura = null;
				Date fUltCambio = null;

				Boolean fApVacia = fechaApertura.getText().isEmpty();
				Boolean fUltCVacia = fechaUltCambio.getText().isEmpty();

				if (!fApVacia) {
					if (fechaApertura.getText().length() == 10) {
						fApertura = armarFecha(fechaApertura.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Por favor ingrese la fecha con formato DD/MM/AAAA",
								"Fecha invalida", JOptionPane.ERROR_MESSAGE);
						fApVacia = true;
					}
				}

				if (!fUltCVacia) {
					if (fechaUltCambio.getText().length() == 10) {
						fUltCambio = armarFecha(fechaUltCambio.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Por favor ingrese la fecha con formato DD/MM/AAAA",
								"Fecha invalida", JOptionPane.ERROR_MESSAGE);
						fUltCVacia = true;
					}
				}

				if ((!fApVacia && fApertura.compareTo(fechaActual) >= 0) || (!fUltCVacia
						&& (fUltCambio.compareTo(fechaActual) >= 0 || fUltCambio.compareTo(fApertura) < 0))) {

					JOptionPane.showMessageDialog(null,
							"La fecha de apertura y/o del último cambio de estado no pueden ser mayores a la fecha actual.",
							"Fecha inválida", JOptionPane.ERROR_MESSAGE);

				} else {
					Integer nroT = null;
					if (!numeroTicket.getText().isEmpty())
						nroT = Integer.valueOf(numeroTicket.getText());
					Integer nroL = null;
					if (!numeroLegajo.getText().isEmpty())
						nroL = Integer.valueOf(numeroLegajo.getText());
					ClasificacionAux clasificacion;
					if (comboClasificacion.getSelectedItem().toString() == "Todas") {
						clasificacion = null;
					} else {
						clasificacion = ((ClasificacionAux) comboClasificacion.getSelectedItem());
					}
					String estado = new String();
					if (comboEstado.getSelectedItem().toString() == "Todos") {
						estado = null;
					} else {
						estado = comboEstado.getSelectedItem().toString();
					}
					GrupoDeResolucionAux ultGrupo;
					if (comboUltGrupo.getSelectedItem().toString() == "Todos") {
						ultGrupo = null;
					} else {
						ultGrupo = (GrupoDeResolucionAux) comboUltGrupo.getSelectedItem();
					}

					setListaTickets(
							gt.consultarTicket(nroT, nroL, clasificacion, estado, fApertura, fUltCambio, ultGrupo),
							true);

				}
			}
		});
		buscar.setForeground(new Color(255, 255, 255));
		buscar.setBackground(theme);
		buscar.setBounds(1134, 142, 130, 40);
		this.add(buscar);

		JButton btnNewButton = new JButton("Derivar ticket");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TicketAux ticket = tableModel.getTickets().get(seleccion);
				if (ticket.getEstadoActual().equals("Solucionado a la espera ok")
						|| ticket.getEstadoActual().equals("Abierto sin derivar")) {
					CU4_DerivarT panelDerivarTicket = new CU4_DerivarT(ticket, idUsuario);
					panelDerivarTicket.setPadre(padre);
					panelDerivarTicket.setAnterior(panel);
					panelDerivarTicket.setBoundsAnterior(new Rectangle(0, 0, 1281, 720));
					padre.setContentPane(panelDerivarTicket);
					padre.setBounds(panelDerivarTicket.getBounds());
					padre.setLocationRelativeTo(null);

				} else {
					JOptionPane.showMessageDialog(null,
							"No se puede derivar un ticket en estado " + ticket.getEstadoActual(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnNewButton.setBounds(547, 640, 130, 40);
		this.add(btnNewButton);

		JButton btnCerrarTicket = new JButton("Cerrar ticket");
		btnCerrarTicket.setBackground(Color.WHITE);
		btnCerrarTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TicketAux ticket = tableModel.getTickets().get(seleccion);
				if (ticket.getEstadoActual().equals("Solucionado a la espera ok")) {
					CU3_CerrarT panelCerrarTicket = new CU3_CerrarT(ticket.getIdTicket(), idUsuario, idGrupo);
					panelCerrarTicket.setPadre(padre);
					panelCerrarTicket.setAnterior(panel);
					panelCerrarTicket.setBoundsAnterior(new Rectangle(0, 0, 1281, 720));
					padre.setContentPane(panelCerrarTicket);
					padre.setBounds(panelCerrarTicket.getBounds());
					padre.setLocationRelativeTo(null);
				} else {
					JOptionPane.showMessageDialog(null,
							"No se puede cerrar un ticket en estado " + ticket.getEstadoActual(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCerrarTicket.setBounds(687, 640, 130, 40);
		this.add(btnCerrarTicket);

		JButton btnVerDetalle = new JButton("Ver detalle");
		btnVerDetalle.setBackground(Color.WHITE);
		btnVerDetalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TicketAux ticket = tableModel.getTickets().get(seleccion);
				System.out.println("llego");
					CU2_VerDetalle panelVerDetalle = new CU2_VerDetalle(ticket.getIdTicket(), ticket.getLegajo());
					panelVerDetalle.setPadre(padre);
					panelVerDetalle.setAnterior(panel);
					panelVerDetalle.setBoundsAnterior(new Rectangle(0, 0, 1281, 720));
					panelVerDetalle.setListaCambios(gt.getEstadosAux(ticket.getIdTicket()), true);
					padre.setContentPane(panelVerDetalle);
					padre.setBounds(panelVerDetalle.getBounds());
					padre.setLocationRelativeTo(null);

			}
		});
		btnVerDetalle.setBounds(408, 640, 130, 40);
		this.add(btnVerDetalle);

		JButton confreporte;
		confreporte = new JButton("Configurar Reporte");
		confreporte.setForeground(new Color(255, 255, 255));
		confreporte.setBackground(theme);
		confreporte.setBounds(953, 640, 171, 40);
		this.add(confreporte);

		JButton cerrar = new JButton("Cancelar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPanel();
			}
		});
		cerrar.setBackground(new Color(255, 255, 255));
		cerrar.setBounds(1134, 640, 130, 40);
		this.add(cerrar);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { numeroTicket, comboClasificacion,
				fechaApertura, numeroLegajo, comboEstado, fechaUltCambio, comboUltGrupo, buscar }));

	}

	protected Date armarFecha(String text) {
		if (text != null) {
			String s1 = (String) text.subSequence(0, 2);
			String s2 = (String) text.subSequence(3, 5);
			String s3 = (String) text.subSequence(6, 10);

			int dia = Integer.parseInt(s1);
			int mes = Integer.parseInt(s2) - 1;
			int anio = Integer.parseInt(s3) - 1900;
			Date fecha = new Date(anio, mes, dia);
			return fecha;
		} else
			return null;
	}

	public void setListaTickets(ArrayList<TicketAux> listaResultado, boolean actualizar) {
		this.tableModel.setTickets(listaResultado);
		if (actualizar)
			this.tableModel.fireTableDataChanged();
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
