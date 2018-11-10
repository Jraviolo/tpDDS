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

import gestores.GestorTicket;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.DefaultComboBoxModel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import clases.ClasificacionDeTicket;
import clases.EstadoTicket;
import clases.GrupoDeResolucion;
import clases.Ticket;
import clasesAuxiliares.TicketAux;

import java.awt.Component;

public class CU2_ConsultarT extends JPanel {

	private JFrame padre;
	private JPanel anterior;
	private JPanel panel = this;
	private JTextField numeroTicket;
	private JTextField numeroLegajo;
	private JTextField fechaApertura;
	private JTextField fechaUltCambio;
	private JComboBox<ClasificacionDeTicket> comboClasificacion;
	private JComboBox<EstadoTicket> comboEstado;
	private JComboBox<GrupoDeResolucion> comboUltGrupo;
	private JButton confreporte;
	private JTable table_1;
	private GestorTicket gt;
	private ConsultarTableModel tableModel;

	public CU2_ConsultarT() {

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
						JOptionPane.showMessageDialog(panel, "Por favor ingrese la fecha con formato DD/MM/AAAA",
								"Fecha invalida", JOptionPane.ERROR_MESSAGE);
						fApVacia = true;
					}
				}

				if (!fUltCVacia) {
					if (fechaUltCambio.getText().length() == 10) {
						fUltCambio = armarFecha(fechaUltCambio.getText());
					} else {
						JOptionPane.showMessageDialog(panel, "Por favor ingrese la fecha con formato DD/MM/AAAA",
								"Fecha invalida", JOptionPane.ERROR_MESSAGE);
						fUltCVacia = true;
					}
				}

				if ((!fApVacia && fApertura.compareTo(fechaActual) >= 0) || (!fUltCVacia
						&& (fUltCambio.compareTo(fechaActual) >= 0 || fUltCambio.compareTo(fApertura) < 0))) {

					JOptionPane.showMessageDialog(panel,
							"La fecha de apertura y/o del último cambio de estado no pueden ser mayores a la fecha actual.",
							"Fecha inválida", JOptionPane.ERROR_MESSAGE);

				} else {
					Integer nroT = null;
					if (!numeroTicket.getText().isEmpty())
						Integer.valueOf(numeroTicket.getText());
					Integer nroL = null;
					if (!numeroLegajo.getText().isEmpty())
						Integer.valueOf(numeroLegajo.getText());
					String clasificacion = ((ClasificacionDeTicket) comboClasificacion.getSelectedItem()).getNombre();
					EstadoTicket estado = (EstadoTicket) comboEstado.getSelectedItem();
					GrupoDeResolucion ultGrupo = (GrupoDeResolucion) comboUltGrupo.getSelectedItem();

					// gt.consultarTicket(nroT, nroL, clasificacion , estado, fApertura, fUltCambio, ultGrupo);

				}
			}
		});
		buscar.setForeground(new Color(255, 255, 255));
		buscar.setBackground(theme);
		buscar.setBounds(1134, 142, 130, 40);
		this.add(buscar);

		numeroTicket = new JTextField();
		numeroTicket.setBounds(204, 142, 134, 20);
		this.add(numeroTicket);
		numeroTicket.setColumns(10);

		numeroLegajo = new JTextField();
		numeroLegajo.setBounds(204, 173, 134, 20);
		this.add(numeroLegajo);
		numeroLegajo.setColumns(10);

		JComboBox<ClasificacionDeTicket> comboClasificacion = new JComboBox();
		comboClasificacion.setModel(new DefaultComboBoxModel(new String[] { "Todas", "asd" }));
		comboClasificacion.setBounds(489, 142, 150, 20);
		this.add(comboClasificacion);

		JComboBox<EstadoTicket> comboEstado = new JComboBox();
		comboEstado.setModel(new DefaultComboBoxModel(new String[] { "Abierto en mesa de ayuda", "Todos" }));
		comboEstado.setBounds(488, 173, 151, 20);
		this.add(comboEstado);

		fechaApertura = new JTextField();
		fechaApertura.setHorizontalAlignment(SwingConstants.CENTER);
		fechaApertura.setBounds(876, 142, 134, 20);
		this.add(fechaApertura);
		fechaApertura.setColumns(10);

		fechaUltCambio = new JTextField();
		fechaUltCambio.setHorizontalAlignment(SwingConstants.CENTER);
		fechaUltCambio.setBounds(876, 173, 134, 20);
		this.add(fechaUltCambio);
		fechaUltCambio.setColumns(10);

		JComboBox<GrupoDeResolucion> comboUltGrupo = new JComboBox();
		comboUltGrupo.setModel(new DefaultComboBoxModel(new String[] { "Todos" }));
		comboUltGrupo.setBounds(326, 204, 150, 20);
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
		lblNewLabel_3.setBounds(661, 142, 223, 20);
		this.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Fecha del ultimo cambio de estado:");
		lblNewLabel_4.setBounds(661, 173, 223, 20);
		this.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Ultimo grupo de resoluci\u00F3n asignado:");
		lblNewLabel_5.setBounds(93, 204, 223, 20);
		this.add(lblNewLabel_5);

		/*
		 * TABLA VIEJA
		 * 
		 * 
		 * table_1 = new JTable(); table_1.setModel(new DefaultTableModel( new
		 * Object[][] { {9999, 9999, "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx", "xxxx",
		 * "dd/mm/aaaa", "xxxx"}, {9999, 9999, "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx",
		 * "xxxx", "dd/mm/aaaa", "xxxx"}, {9999, 9999, "dd/mm/aaaa", "hh:mm", "xxxx",
		 * "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"}, {9999, 9999, "dd/mm/aaaa", "hh:mm",
		 * "xxxx", "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"}, {9999, 9999, "dd/mm/aaaa",
		 * "hh:mm", "xxxx", "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"}, {9999, 9999,
		 * "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"}, {9999,
		 * 9999, "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"},
		 * {9999, 9999, "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx", "xxxx", "dd/mm/aaaa",
		 * "xxxx"}, {9999, 9999, "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx", "xxxx",
		 * "dd/mm/aaaa", "xxxx"}, {9999, 9999, "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx",
		 * "xxxx", "dd/mm/aaaa", "xxxx"}, {9999, 9999, "dd/mm/aaaa", "hh:mm", "xxxx",
		 * "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"}, {9999, 9999, "dd/mm/aaaa", "hh:mm",
		 * "xxxx", "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"}, {9999, 9999, "dd/mm/aaaa",
		 * "hh:mm", "xxxx", "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"}, {9999, 9999,
		 * "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"}, {9999,
		 * 9999, "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"},
		 * {9999, 9999, "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx", "xxxx", "dd/mm/aaaa",
		 * "xxxx"}, {9999, 9999, "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx", "xxxx",
		 * "dd/mm/aaaa", "xxxx"}, {9999, 9999, "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx",
		 * "xxxx", "dd/mm/aaaa", "xxxx"}, {9999, 9999, "dd/mm/aaaa", "hh:mm", "xxxx",
		 * "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"}, {9999, 9999, "dd/mm/aaaa", "hh:mm",
		 * "xxxx", "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"}, {9999, 9999, "dd/mm/aaaa",
		 * "hh:mm", "xxxx", "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"}, {9999, 9999,
		 * "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"}, {9999,
		 * 9999, "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx", "xxxx", "dd/mm/aaaa", "xxxx"},
		 * {9999, 9999, "dd/mm/aaaa", "hh:mm", "xxxx", "xxxx", "xxxx", "dd/mm/aaaa",
		 * "xxxx"},
		 * 
		 * }, new String[] { "Nro ticket", "Nro legajo", "Fecha apertura",
		 * "Hora apertura", "Operador", "Clasificaci\u00F3n actual", "Estado actual",
		 * "Ultimo cambio de estado", "Grupo de resolucion actual" } ) { Class[]
		 * columnTypes = new Class[] { Integer.class, Integer.class, String.class,
		 * String.class, String.class, String.class, String.class, String.class,
		 * String.class }; public Class getColumnClass(int columnIndex) { return
		 * columnTypes[columnIndex]; } }); table_1.setBounds(109, 266, 607, -95);
		 * JScrollPane JS= new JScrollPane(table_1); JS.setSize(1171, 394);
		 * JS.setLocation(93, 235); JS.setPreferredSize(new Dimension(400,400));
		 * this.add(JS); //fin tabla
		 * 
		 */

		// TABLA NUEVA

		table_1 = new JTable(this.tableModel);
		table_1.setFillsViewportHeight(true);
		table_1.setBounds(109, 266, 607, -95);
		JScrollPane JS = new JScrollPane(table_1);
		JS.setSize(1171, 394);
		JS.setLocation(93, 235);
		JS.setPreferredSize(new Dimension(400, 400));
		this.add(JS);

		JButton btnNewButton = new JButton("Derivar ticket");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(547, 640, 130, 40);
		this.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cerrar ticket");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(687, 640, 130, 40);
		this.add(btnNewButton_1);

		JButton btnVerDetalle = new JButton("Ver detalle");
		btnVerDetalle.setBackground(Color.WHITE);
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
		padre.setBounds(anterior.getBounds());
		padre.setLocationRelativeTo(null);
	}

	public void setAnterior(JPanel anterior) {
		this.anterior = anterior;
	}

}
