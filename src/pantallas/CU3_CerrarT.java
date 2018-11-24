package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gestores.GestorTicket;

public class CU3_CerrarT extends JPanel {

	private JFrame padre;
	private JPanel anterior;
	private GestorTicket gt;
	
	
	public CU3_CerrarT(int idTicket,int idUsuario) {

		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		setBounds(0, 0, 554, 700);
		Color theme = new Color(38, 79, 111);

		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(CU3_CerrarT.class.getResource("/imagenes/logo2.png")));
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

		JLabel titulo_pantalla = new JLabel("Cerrar ticket");
		titulo_pantalla.setVerticalAlignment(SwingConstants.TOP);
		titulo_pantalla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo_pantalla.setBounds(93, 99, 416, 25);
		this.add(titulo_pantalla);



		JLabel lblNuevoEstadoDel = new JLabel("Nuevo estado del ticket:");
		lblNuevoEstadoDel.setBounds(93, 135, 190, 14);
		this.add(lblNuevoEstadoDel);

		JLabel lblCerrado = new JLabel("Cerrado");
		lblCerrado.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCerrado.setBounds(304, 135, 46, 14);
		this.add(lblCerrado);

		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(93, 160, 190, 14);
		this.add(lblObservaciones);

		JTextField observaciones = new JTextField();
		observaciones.setBounds(93, 185, 264, 164);
		this.add(observaciones);
		observaciones.setColumns(10);

		

		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String obs = observaciones.getText();
				if(obs==null) {
					JOptionPane.showMessageDialog(null,
							"Por favor ingrese una obsevación.",
							"Campos nulos", JOptionPane.ERROR_MESSAGE);
				}
				else {
				gt.cerrarTicket(idTicket, obs, idUsuario);
				}
			}
		});
		aceptar.setForeground(new Color(255, 255, 255));
		aceptar.setBackground(theme);
		aceptar.setBounds(994, 640, 130, 40);
		this.add(aceptar);
		

		JButton cerrar = new JButton("Cerrar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cerrar.setBackground(new Color(255, 255, 255));
		cerrar.setBounds(1134, 640, 130, 40);
		this.add(cerrar);
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
