package pantallas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasesAuxiliares.ClasificacionAux;
import clasesAuxiliares.GrupoDeResolucionAux;
import clasesAuxiliares.IntervencionAux;
import clasesAuxiliares.TicketAux;
import gestores.GestorIntervenciones;

public class CU7_ConsultarIntervenciones extends JPanel {

	private JFrame padre;
	private JPanel anterior;
	private JPanel panel = this;
	private Rectangle boundsAnterior;
	private JTextField fechaDesde;
	private JTextField fechaHasta;
	private JTextField numeroTicket;
	private JTextField numeroLegajo;
	private JTable table_1;
	private Integer seleccion;
	private ConsultarIntTableModel tableModel = new ConsultarIntTableModel();
	private GestorIntervenciones gi = new GestorIntervenciones();

	public CU7_ConsultarIntervenciones(Integer idUsuario, Integer idGrupo) {

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		setBounds(0, 0, 1281, 720);
		Color theme = new Color(38, 79, 111);

		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(CU7_ConsultarIntervenciones.class.getResource("/imagenes/logo2.png")));
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

		JLabel titulo_pantalla = new JLabel("Consultar intervenciones");
		titulo_pantalla.setVerticalAlignment(SwingConstants.TOP);
		titulo_pantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo_pantalla.setBounds(93, 99, 416, 25);
		this.add(titulo_pantalla);

		JLabel lblCriteriosDeBusqueda = new JLabel("Criterios de busqueda:");
		lblCriteriosDeBusqueda.setBounds(93, 135, 170, 14);
		this.add(lblCriteriosDeBusqueda);

		JLabel lblEstado = new JLabel("Estado intervención:");
		lblEstado.setBounds(93, 160, 80, 17);
		this.add(lblEstado);

		JComboBox comboEstado = new JComboBox();
		comboEstado.setModel(
				new DefaultComboBoxModel(new String[] { "Asignada", "En espera", "Terminada", "Trabajando", "Todos" }));
		comboEstado.setBounds(271, 157, 190, 20);
		this.add(comboEstado);

		JLabel lblNewLabel = new JLabel("Fecha desde:");
		lblNewLabel.setBounds(93, 188, 149, 17);
		this.add(lblNewLabel);

		fechaDesde = new JTextField();
		fechaDesde.setHorizontalAlignment(SwingConstants.CENTER);
		fechaDesde.setText("");
		fechaDesde.setBounds(271, 185, 190, 20);
		this.add(fechaDesde);
		fechaDesde.setColumns(10);

		JLabel lblFechaHasta = new JLabel("Fecha hasta:");
		lblFechaHasta.setBounds(93, 216, 149, 17);
		this.add(lblFechaHasta);

		fechaHasta = new JTextField();
		fechaHasta.setHorizontalAlignment(SwingConstants.CENTER);
		fechaHasta.setText("");
		fechaHasta.setBounds(271, 213, 190, 20);
		this.add(fechaHasta);
		fechaHasta.setColumns(10);

		JLabel lblNmeroTicket = new JLabel("N\u00FAmero ticket:");
		lblNmeroTicket.setBounds(492, 157, 149, 20);
		this.add(lblNmeroTicket);

		numeroTicket = new JTextField();
		numeroTicket.setBounds(670, 157, 190, 20);
		this.add(numeroTicket);
		numeroTicket.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero de legajo:");
		lblNewLabel_1.setBounds(492, 188, 149, 20);
		this.add(lblNewLabel_1);

		numeroLegajo = new JTextField();
		numeroLegajo.setBounds(670, 188, 190, 20);
		this.add(numeroLegajo);
		numeroLegajo.setColumns(10);
		/*
		 * ///INICIO TABLA table_1 = new JTable(); table_1.setModel(new
		 * DefaultTableModel( new Object[][] { {9999, 9999, "xxxxxxxxx", "xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999,
		 * 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx",
		 * "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx", "xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999,
		 * 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx",
		 * "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx", "xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999,
		 * 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx",
		 * "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx", "xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999,
		 * 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx",
		 * "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx", "xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999,
		 * 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx",
		 * "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx", "xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999,
		 * 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx",
		 * "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx", "xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999,
		 * 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx",
		 * "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx", "xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999,
		 * 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx",
		 * "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx", "xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999,
		 * 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx",
		 * "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx", "xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999,
		 * 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx",
		 * "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx", "xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999,
		 * 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx",
		 * "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx",
		 * "xxxxxxxxx"}, {9999, 9999, "xxxxxxxxx", "xxxxxxxxx",
		 * "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"}, }, new
		 * String[] { "Nro de ticket", "Nro legajo",
		 * "Clasificaci\u00F3n actual del ticket", "Estado del ticket",
		 * "Fecha de apertura", "Estado intervenci\u00F3n",
		 * "Fecha asignaci\u00F3n intervenci\u00F3n", "Grupo Resoluci\u00F3n",
		 * "Observaciones intervenci\u00F3n" } ) { Class[] columnTypes = new Class[] {
		 * Integer.class, Integer.class, String.class, String.class, String.class,
		 * String.class, String.class, String.class, String.class }; public Class
		 * getColumnClass(int columnIndex) { return columnTypes[columnIndex]; } });
		 * 
		 * 
		 */

		table_1 = new JTable(this.tableModel);
		table_1.setFillsViewportHeight(true);
		// table_1.setBounds(109, 266, 607, -95);
		JScrollPane JS = new JScrollPane(table_1);
		// JS.setSize(1171, 394);
		// JS.setLocation(93, 235);
		// JS.setPreferredSize(new Dimension(400, 400));
		// this.add(JS);

		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int r = table_1.rowAtPoint(e.getPoint());
				seleccion = r;

			}

		});

		table_1.setBounds(93, 187, 1, 1);
		// contentPane.add(table_1);
		// JScrollPane JS= new JScrollPane(table_1);
		JS.setSize(1171, 372);
		JS.setLocation(93, 257);
		JS.setPreferredSize(new Dimension(400, 400));
		this.add(JS);

		/// FIN TABLA

		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date fechaActual = new Date();
				Date fDesde = null;
				Date fHasta = null;

				Boolean fDesdeVacia = fechaDesde.getText().isEmpty();
				Boolean fHastaVacia = fechaHasta.getText().isEmpty();

				if (!fDesdeVacia) {
					if (fechaDesde.getText().length() == 10) {
						fDesde = armarFecha(fechaDesde.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Por favor ingrese la fecha con formato DD/MM/AAAA",
								"Fecha invalida", JOptionPane.ERROR_MESSAGE);
						fDesdeVacia = true;
					}
				}

				if (!fHastaVacia) {
					if (fechaHasta.getText().length() == 10) {
						fHasta = armarFecha(fechaHasta.getText());
					} else {
						JOptionPane.showMessageDialog(null, "Por favor ingrese la fecha con formato DD/MM/AAAA",
								"Fecha invalida", JOptionPane.ERROR_MESSAGE);
						fHastaVacia = true;
					}
				}

				if ((!fDesdeVacia && fDesde.compareTo(fechaActual) >= 0)
						|| (!fHastaVacia && (fHasta.compareTo(fechaActual) >= 0 ||(!fDesdeVacia && !fHastaVacia && fHasta.compareTo(fDesde) < 0)))) {

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
					String estado = new String();
					if (comboEstado.getSelectedItem().toString() == "Todos") {
						estado = null;
					} else {
						estado = comboEstado.getSelectedItem().toString();
					}

					setListaIntervenciones(gi.consultarIntervenciones(estado, fDesde, fHasta, nroT, nroL), true);

				}
			}
		});
		buscar.setForeground(new Color(255, 255, 255));
		buscar.setBackground(theme);
		buscar.setBounds(1134, 160, 130, 40);
		this.add(buscar);
		JButton btnNewButton = new JButton("Actualizar \r\nEstado");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IntervencionAux intervencion = tableModel.getIntervenciones().get(seleccion);
				if (intervencion.getGrupoActual().getId()==idGrupo) {
					CU8_ActualizarIntervencion panelActualizarInt = new CU8_ActualizarIntervencion(intervencion,
							(int) intervencion.getIdTicket(), idUsuario, idGrupo);
					panelActualizarInt.setPadre(padre);
					panelActualizarInt.setAnterior(panel);
					panelActualizarInt.setBoundsAnterior(new Rectangle(0, 0, 1281, 720));
					padre.setContentPane(panelActualizarInt);
					padre.setBounds(panelActualizarInt.getBounds());
					padre.setLocationRelativeTo(null);
				} else {
					JOptionPane.showMessageDialog(null,
							"No se pueden actualizar las intervenciones asignadas a otros grupos.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(482, 640, 150, 40);
		this.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Comentar");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(642, 640, 150, 40);
		this.add(btnNewButton_1);

		JButton cerrar = new JButton("Cancelar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerPanel();
			}
		});
		cerrar.setBackground(new Color(255, 255, 255));
		cerrar.setBounds(1134, 640, 130, 40);
		this.add(cerrar);

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

	public void setListaIntervenciones(ArrayList<IntervencionAux> listaResultado, boolean actualizar) {
		this.tableModel.setIntervenciones(listaResultado);
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
		this.boundsAnterior = bounds;

	}
}
