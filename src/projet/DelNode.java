package projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Graphe;
import classes.Sommet;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Choice;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DelNode extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> txtNom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelNode frame = new DelNode();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DelNode() {
		setTitle("Supprimer sommet");
		setBounds(100, 100, 425, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JButton btnSupprimer = new JButton("Supprimer");
		panel.add(btnSupprimer);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("Nom du sommet \u00E0 supprimer");
		panel_1.add(lblNewLabel);

		txtNom = new JComboBox<String>();
		for (String s : Graphe.Ensemble_Sommet_Nom()) txtNom.addItem(s);
		panel_1.add(txtNom);
		
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Graphe.Nb_Sommet() <= 0) {
					JOptionPane.showMessageDialog(null, "Graphe est deja vide", "Erreur", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Graphe.Delete_Sommet(Graphe.getSommet(txtNom.getSelectedItem().toString()));
				txtNom.removeItem(txtNom.getSelectedItem());

			}
		});
	}

}
