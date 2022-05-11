package projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Graphe;
import classes.PageAccount;
import classes.Sommet;
import classes.UserAccount;
import classes.testDrawGraph;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class MainFrame extends JFrame {

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
					MainFrame frame = new MainFrame();
					frame.setLocationRelativeTo(null);
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
	public MainFrame() {
		setTitle("Projet Graphe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton drawGraph = new JButton("Dessiner le graphe");
		drawGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			   testDrawGraph.dessiner();
			    
			}
		});
		drawGraph.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel.add(drawGraph);
		
		JButton btnNewButton = new JButton("Caract\u00E9ristiques");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Caracteristiques caract = new Caracteristiques();
				caract.setLocationRelativeTo(null);
				caract.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 2, 5, 5));
		
		JButton addSommet = new JButton("Ajouter un sommet");
		addSommet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddNode addNode = new AddNode();
				addNode.setLocationRelativeTo(null);
				addNode.setVisible(true);
			}
		});
		addSommet.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_1.add(addSommet);
		
		JButton addArc = new JButton("Ajouter une relation");
		addArc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddArc addArc = new AddArc();
				addArc.setLocationRelativeTo(null);
				addArc.setVisible(true);
			}
		});
		addArc.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_1.add(addArc);
		
		JButton delUser = new JButton("Supprimer sommet");
		delUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelNode delNode = new DelNode();
				delNode.setLocationRelativeTo(null);
				delNode.setVisible(true);
			}
		});
		delUser.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_1.add(delUser);
		
		JButton delArc = new JButton("Supprimer relation");
		delArc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteArc deleteArc = new DeleteArc();
				deleteArc.setLocationRelativeTo(null);
				deleteArc.setVisible(true);
			}
		});
		delArc.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_1.add(delArc);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Editer votre graphe");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel_2.add(lblNewLabel);
	}
	
}
