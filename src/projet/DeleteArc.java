package projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import classes.Graphe;
import classes.Sommet;
import classes.UserAccount;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteArc extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> src, dest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteArc frame = new DeleteArc();
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
	public DeleteArc() {
		setTitle("Supprimer relation");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 489, 121);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl = new JLabel("Sommet source :");
		panel.add(lbl);
		
		src = new JComboBox<String>();
		for (UserAccount s : Graphe.relations.keySet()) src.addItem(s.getNom());
		panel.add(src);
		
		JLabel lblNewLabel = new JLabel("Sommet destination");
		panel.add(lblNewLabel);
		
		dest = new JComboBox<String>();
		for (Sommet s : Graphe.relations.get(Graphe.getSommet(src.getSelectedItem().toString()))) dest.addItem(s.getNom());
		panel.add(dest);
		
		src.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adapt();
			}			
		});
		
		JButton btnDel = new JButton("Supprimer la relation");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dest.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "Y'a rien a supprimer","Erreur", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Sommet S = Graphe.getSommet(src.getSelectedItem().toString()), 
						D = Graphe.getSommet(dest.getSelectedItem().toString());
				Graphe.Delete_Arc(S, D);
				//JOptionPane.showMessageDialog(null, S.getNom() + " > " + D.getNom());
				adapt();
			}
		});
		contentPane.add(btnDel, BorderLayout.SOUTH);
	}
	
	private void adapt() {
		dest.removeAllItems();
		for (Sommet s : Graphe.relations.get(Graphe.getSommet(src.getSelectedItem().toString()))) dest.addItem(s.getNom());
	}

}
