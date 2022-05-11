package projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class AddNode extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNode frame = new AddNode();
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
	public AddNode() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Ajouter sommet");
		setBounds(100, 100, 293, 109);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Choisir le type de sommet ");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnUtilisateur = new JButton("Utilisateur");
		btnUtilisateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUsr addUsr = new AddUsr();
				addUsr.setLocationRelativeTo(null);
				addUsr.setVisible(true);
				setVisible(false);
			}
		});
		panel_1.add(btnUtilisateur);
		
		JButton btnPage = new JButton("Page");
		btnPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPage addPage = new AddPage();
				addPage.setLocationRelativeTo(null);
				addPage.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btnPage);
		
	}

}
