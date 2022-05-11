package projet;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import classes.Graphe;
import classes.Sommet;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Caracteristiques extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caracteristiques frame = new Caracteristiques();
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
	public Caracteristiques() {
		setTitle("Caract\u00E9ristiques");
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAgeMoy = new JButton("Age Moyenne");
		btnAgeMoy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, Graphe.age_moyen());
				
			}
		});
		contentPane.add(btnAgeMoy);
		
		JButton btnNbSommets = new JButton("Nombre de sommets");
		btnNbSommets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, Graphe.Nb_Sommet());
			}
		});
		contentPane.add(btnNbSommets);
		
		JButton btnNbArcs = new JButton("Nombre d'arcs");
		btnNbArcs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, Graphe.Nb_Arcs());

			
			}
		});
		contentPane.add(btnNbArcs);
		
		JButton btnNbPages = new JButton("Nombre des pages");
		btnNbPages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, Graphe.nb_page_account());

				;
			}
		});
		contentPane.add(btnNbPages);
		
		JButton btnNbUtilisateurs = new JButton("Nombre utilisateurs");
		btnNbUtilisateurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, Graphe.nb_user_account());

				;
			}
		});
		contentPane.add(btnNbUtilisateurs);
		
		JButton btnNewButton = new JButton("List des arcs");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String abs = "";
				for (Sommet s : Graphe.relations.keySet()) {
					for (Sommet v : Graphe.relations.get(s)) {
						abs += s.getNom() + " -> " + v.getNom() + "\n";
					}
				}
				JOptionPane.showMessageDialog(null, abs);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnPageRank = new JButton("Page Rank");
		btnPageRank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String abs = "";
				for (Sommet s : Graphe.rank().keySet()) {
					abs += s.getNom() + " -> " + Graphe.rank().get(s) + "\n";
				}
				JOptionPane.showMessageDialog(null, abs);
			}
		});
		contentPane.add(btnPageRank);
		
		JButton btnListAdj = new JButton("Liste d'adjascence");
		btnListAdj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphe.graphe_to_file();
			}
		});
		contentPane.add(btnListAdj);
		
		JButton btnInfo_Node = new JButton("Information Sommet");
		btnInfo_Node.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Info info = new Info();
				info.setLocationRelativeTo(null);
				info.setVisible(true);
			}
		});
		contentPane.add(btnInfo_Node);
		
		/*
		JButton btnNewButton11 = new JButton("page rank");
		btnNewButton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String abs = "";
				for (Sommet s : Graphe.rank().navigableKeySet()) {
					abs += s.getNom() + " -> " + Graphe.rank().get(s) + "\n";
				}
				JOptionPane.showMessageDialog(null, abs);
			}
		});
		contentPane.add(btnNewButton11);*/

	}

}
