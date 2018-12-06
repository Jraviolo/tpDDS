package pantallas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasesAuxiliares.CambioEstadoAux;
import clasesAuxiliares.TicketAux;


public class CU2_VerDetalle extends JPanel{

	
	private JFrame padre;
	private JPanel anterior;
	private Rectangle boundsAnterior;
	private VerDetalleTableModel tableModel = new VerDetalleTableModel();
	
	public CU2_VerDetalle(Integer idTicket, Integer legajo) {
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		setBounds(0, 0, 1281, 720);
		Color theme = new Color(38, 79, 111);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(CU2_VerDetalle.class.getResource("/imagenes/logo2.png")));
		Logo.setBounds(16, 0, 300, 95);
		this.add(Logo);
		
		Panel barraIzquierda = new Panel();
		barraIzquierda.setBackground(theme);
		barraIzquierda.setBounds(0, 0, 10, 691);
		this.add(barraIzquierda);
		
		JButton cerrar = new JButton("Cerrar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cerrar.setBackground(new Color(255, 255, 255));

		barraIzquierda.setBackground(theme);
		
		Panel tituloSub = new Panel();
		tituloSub.setBounds(93, 126, 264, 3);
		tituloSub.setBackground(theme);
		this.add(tituloSub);
		
		JLabel titulo_pantalla = new JLabel("Detalle ticket");
		titulo_pantalla.setVerticalAlignment(SwingConstants.TOP);
		titulo_pantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo_pantalla.setBounds(93, 99, 416, 25);
		this.add(titulo_pantalla);
		cerrar.setBounds(1134, 640, 130, 40);
		this.add(cerrar);
		
		JLabel lblNewLabel = new JLabel("Legajo:");
		lblNewLabel.setBounds(93, 135, 130, 14);
		this.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("99999");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(243, 135, 46, 14);
		this.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido y Nombre");
		lblNewLabel_2.setBounds(93, 160, 130, 14);
		this.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("xxxxxx, xxxxxx xxxxxx");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(243, 160, 190, 14);
		this.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono Interno:");
		lblNewLabel_4.setBounds(93, 185, 130, 14);
		this.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("99999999");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(243, 185, 190, 14);
		this.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tel\u00E9fono Directo:");
		lblNewLabel_6.setBounds(93, 210, 130, 14);
		this.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("99999999");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(243, 210, 190, 14);
		this.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Descripci\u00F3n de cargo:");
		lblNewLabel_8.setBounds(93, 235, 130, 14);
		this.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("xxxxxxxxxx");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(243, 235, 190, 14);
		this.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Ubicaci\u00F3n:");
		lblNewLabel_10.setBounds(93, 260, 130, 14);
		this.add(lblNewLabel_10);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(121, 285, 102, 14);
		this.add(lblCalle);
		
		JLabel lblNewLabel_12 = new JLabel("xxxxxxxxx");
		lblNewLabel_12.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(243, 285, 190, 14);
		this.add(lblNewLabel_12);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(121, 310, 102, 14);
		this.add(lblNmero);
		
		JLabel label = new JLabel("9999");
		label.setFont(new Font("Arial", Font.PLAIN, 12));
		label.setBounds(243, 310, 46, 14);
		this.add(label);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setBounds(121, 335, 46, 14);
		this.add(lblPiso);
		
		JLabel label_1 = new JLabel("99");
		label_1.setFont(new Font("Arial", Font.PLAIN, 12));
		label_1.setBounds(243, 335, 46, 14);
		this.add(label_1);
		
		JLabel lblOficina = new JLabel("Oficina:");
		lblOficina.setBounds(121, 360, 102, 14);
		this.add(lblOficina);
		
		JLabel lblXxxxxxxxxxx = new JLabel("xxxxxxxxxxx");
		lblXxxxxxxxxxx.setFont(new Font("Arial", Font.PLAIN, 12));
		lblXxxxxxxxxxx.setBounds(243, 360, 114, 14);
		this.add(lblXxxxxxxxxxx);
		
		JLabel lblHistorial = new JLabel("Historial:");
		lblHistorial.setBounds(479, 135, 213, 14);
		this.add(lblHistorial);
		
		//inicio tabla
	/*	JTable table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
				{"dd/mm/aaaa", "hh:mm", "xxxxx", "xxxxx", "xxxxx", "xxxxx", "xxxxx"},
			},
			new String[] {
				"Fecha cambio", "Hora cambio", "Operador", "Estado", "Grupo resoluci\u00F3n", "Observaciones", "Clasificaci\u00F3n del ticket"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(489, 210, 421, -49);
		//contentPane.add(table);
		table.setBounds(109, 266, 607, -95);
		JScrollPane JS= new JScrollPane(table);
		JS.setSize(785, 469);
		JS.setLocation(479, 160);
		JS.setPreferredSize(new Dimension(400,400));
		contentPane.add(JS);
		
		//fin tabla
*/
		
		JTable table_1 = new JTable(this.tableModel);
		table_1.setFillsViewportHeight(true);
		table_1.setBounds(489, 210, 421, -49);
		JScrollPane JS = new JScrollPane(table_1);
		JS.setSize(785, 469);
		JS.setLocation(479, 160);
		JS.setPreferredSize(new Dimension(400,400));
		this.add(JS);
		
	}
	
	

	public void setListaCambios(ArrayList<CambioEstadoAux> listaResultado, boolean actualizar) {
		this.tableModel.setCambios(listaResultado);
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