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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasesAuxiliares.IntervencionAux;
import clasesAuxiliares.TicketAux;


public class CU7_ConsultarIntervenciones extends JPanel {
		

		private JFrame padre;
		private JPanel anterior;
		private Rectangle boundsAnterior;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTable table_1;
		private Integer seleccion;
		private ConsultarIntTableModel tableModel = new ConsultarIntTableModel();
		
		public CU7_ConsultarIntervenciones(int idUsuario, int idGrupo) {

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
			tituloSub.setBounds(93,126,368,3);
			tituloSub.setBackground(theme);
			this.add(tituloSub);
			
			JLabel titulo_pantalla = new JLabel("Consultar intervenciones");
			titulo_pantalla.setVerticalAlignment(SwingConstants.TOP);
			titulo_pantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
			titulo_pantalla.setBounds(93, 99, 416, 25);
			this.add(titulo_pantalla);
			
			
			JButton buscar = new JButton("Buscar");
			buscar.setForeground(new Color(255, 255, 255));
			buscar.setBackground(theme);
			buscar.setBounds(1134, 160, 130, 40);
			this.add(buscar);
			
			JLabel lblCriteriosDeBusqueda = new JLabel("Criterios de busqueda:");
			lblCriteriosDeBusqueda.setBounds(93, 135, 170, 14);
			this.add(lblCriteriosDeBusqueda);
			
			JLabel lblEstado = new JLabel("Estado");
			lblEstado.setBounds(93, 160, 46, 17);
			this.add(lblEstado);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Asignada", "Todos"}));
			comboBox.setBounds(271, 157, 190, 20);
			this.add(comboBox);
			
			JLabel lblNewLabel = new JLabel("Fecha desde:");
			lblNewLabel.setBounds(93, 188, 149, 17);
			this.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setText("/    /");
			textField.setBounds(271, 185, 190, 20);
			this.add(textField);
			textField.setColumns(10);
			
			JLabel lblFechaHasta = new JLabel("Fecha hasta:");
			lblFechaHasta.setBounds(93, 216, 149, 17);
			this.add(lblFechaHasta);
			
			textField_1 = new JTextField();
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_1.setText("/    /");
			textField_1.setBounds(271, 213, 190, 20);
			this.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNmeroTicket = new JLabel("N\u00FAmero ticket:");
			lblNmeroTicket.setBounds(492, 157, 149, 20);
			this.add(lblNmeroTicket);
			
			textField_2 = new JTextField();
			textField_2.setBounds(670, 157, 190, 20);
			this.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("N\u00FAmero de legajo:");
			lblNewLabel_1.setBounds(492, 188, 149, 20);
			this.add(lblNewLabel_1);
			
			textField_3 = new JTextField();
			textField_3.setBounds(670, 188, 190, 20);
			this.add(textField_3);
			textField_3.setColumns(10);
	/*		
			///INICIO TABLA
					table_1 = new JTable();
					table_1.setModel(new DefaultTableModel(
						new Object[][] {
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
							{9999, 9999, "xxxxxxxxx", "xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "dd/mm/aaaa","xxxxxxxxx", "xxxxxxxxx"},
						},
						new String[] {
							"Nro de ticket", "Nro legajo", "Clasificaci\u00F3n actual del ticket", "Estado del ticket", "Fecha de apertura", "Estado intervenci\u00F3n", "Fecha asignaci\u00F3n intervenci\u00F3n", "Grupo Resoluci\u00F3n", "Observaciones intervenci\u00F3n"
						}
					) {
						Class[] columnTypes = new Class[] {
							Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
					
					
		*/
			
			table_1 = new JTable(this.tableModel);
			table_1.setFillsViewportHeight(true);
		//	table_1.setBounds(109, 266, 607, -95);
			JScrollPane JS = new JScrollPane(table_1);
		//	JS.setSize(1171, 394);
		//	JS.setLocation(93, 235);
		//	JS.setPreferredSize(new Dimension(400, 400));
		//	this.add(JS);

			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					int r = table_1.rowAtPoint(e.getPoint());
					seleccion = r;

				}

			});
	
					table_1.setBounds(93, 187, 1, 1);
//					contentPane.add(table_1);
		//			JScrollPane JS= new JScrollPane(table_1);
					JS.setSize(1171, 372);
					JS.setLocation(93, 257);
					JS.setPreferredSize(new Dimension(400,400));
					this.add(JS);
					
			///FIN TABLA
			 
			 
					JButton btnNewButton = new JButton("Actualizar \r\nEstado");
					btnNewButton.setBackground(Color.WHITE);
					btnNewButton.setBounds(714, 640, 130, 40);
					this.add(btnNewButton);
					
					JButton btnNewButton_1 = new JButton("Comentar");
					btnNewButton_1.setBackground(Color.WHITE);
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
						}
					});
					btnNewButton_1.setBounds(854, 640, 130, 40);
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
			this.boundsAnterior=bounds;
			
		}
}
