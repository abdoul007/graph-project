package classes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawGraph extends JComponent {

	private static final long serialVersionUID = 1L;
	private List<Double> xx, yy;

	public DrawGraph() {
		setPreferredSize(new Dimension(800,500));
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		xx = new ArrayList<Double>(); 
		yy = new ArrayList<Double>();
		double x = (2*Math.PI)/Graphe.Nb_Sommet();
		double pi = 0;
		double rayon = Math.min(Math.max(Graphe.Nb_Sommet()*10, 100), 200);
		for (int i = 0; i < Graphe.Nb_Sommet(); ++i) {
			xx.add(Math.cos(pi)*rayon);
			yy.add(Math.sin(pi)*rayon);
			pi += x;
		}
		int sm = 0;
		int ind = 0;
		for (int i = 0; i < Graphe.Nb_Sommet(); ++i) {
			if (Graphe.listSommet.get(i) instanceof UserAccount)
				g.setColor(Color.PINK);
			else g.setColor(Color.GREEN);
			g.fillOval((int) Math.round(xx.get(ind))+400, (int) Math.round(yy.get(ind))+230, 25, 25);
			g.setColor(Color.BLACK);
			String nom = Graphe.Ensemble_Sommet_Nom().get(sm++);
			if (xx.get(ind) < 0 && yy.get(ind) > 0)
				g.drawString(nom, (int) Math.round(xx.get(ind))+400-20, (int) Math.round(yy.get(ind++))+230+35);
			else if (xx.get(ind) > 0 && yy.get(ind) < 0)
				g.drawString(nom, (int) Math.round(xx.get(ind))+400+30, (int) Math.round(yy.get(ind++))+230);
			else if (xx.get(ind) < 0 && yy.get(ind) < 0)
				g.drawString(nom, (int) Math.round(xx.get(ind))+400-15, (int) Math.round(yy.get(ind++))+230);
			else
				g.drawString(nom, (int) Math.round(xx.get(ind))+400+30, (int) Math.round(yy.get(ind++))+230+35);
		}
		for (Sommet s : Graphe.relations.keySet()) {
			ind = Graphe.listSommet.indexOf(s);
			double x1 = (double) xx.get(ind)+400+12.5;
			double y1 = (double) yy.get(ind)+230;
			if ((xx.get(ind) > 0 && yy.get(ind) < 0) || (xx.get(ind) < 0 && yy.get(ind) < 0)) {
				y1 += 25;
			}
			for (Sommet v : Graphe.relations.get(s)) {
				ind = Graphe.listSommet.indexOf(v);
				double x2 = (double) xx.get(ind)+400;
				double y2 = (double) yy.get(ind)+230;
				if ((xx.get(ind) > 0 && yy.get(ind) < 0) || (xx.get(ind) < 0 && yy.get(ind) < 0)) {
					x2 += 12.5;
					y2 += 25;
				}
				else {
					x2 += 12.5;
				}
				if (v instanceof PageAccount)
					g.setColor(new Color(91, 127, 255));
				else g.setColor(Color.BLACK);
				g.drawLine((int) Math.round(x1), (int) Math.round(y1), (int) Math.round(x2), (int) Math.round(y2));
			}
		}
	}
	
}

