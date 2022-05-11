package projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.*;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class AddUsr extends JFrame {

	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtAge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUsr frame = new AddUsr();
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
	public AddUsr() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Ajouter");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Sommet s = new UserAccount(txtNom.getText(),Integer.parseInt(txtAge.getText()));
				Graphe.AddSommet(s);
				
				txtNom.setText(null);
				txtAge.setText(null);
			}
		});
		panel.add(btnAdd);
		
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
				txtAge.setText(""+rand.nextInt(150));
			}
		});
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Nom d'utilisateur :");
		panel_1.add(lblNewLabel);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		panel_1.add(txtNom);
		
		JLabel lblNewLabel_1 = new JLabel("Age :");
		panel_1.add(lblNewLabel_1);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		panel_1.add(txtAge);
	}

}
