package projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Graphe;
import classes.PageAccount;
import classes.Sommet;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class AddPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	
	//Graphe graphe = new Graphe();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPage frame = new AddPage();
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
	public AddPage() {
		setTitle("Nouvelle page");
		setBounds(100, 100, 450, 127);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sommet s = new PageAccount(txtNom.getText());
				Graphe.AddSommet(s);
				
				
				//graphe.nodes.add(new Node(txtNom.getText(),0));
				txtNom.setText(null);
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Nom de la page : ");
		panel_1.add(lblNewLabel);
		
		txtNom = new JTextField();
		panel_1.add(txtNom);
		txtNom.setColumns(10);
		
		JButton Rand = new JButton("Random");
		panel.add(Rand);
		Rand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String alpha = "ABCDEFGIJKLMNOPQRSTUVWXYZ";
				String rndnm = "";
				Random rand = new Random();
				int len = rand.nextInt(6);
				while (len < 3 || len > 5) len = rand.nextInt(6);
				rndnm += alpha.charAt(rand.nextInt(alpha.length()));
				for (int i = 1; i < len; ++i) {
					rndnm += Character.toLowerCase(alpha.charAt(rand.nextInt(alpha.length())));
				}
				txtNom.setText(rndnm);
			}
		});
	}

}
