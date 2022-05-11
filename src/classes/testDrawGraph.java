package classes;

import javax.swing.JFrame;
public class testDrawGraph {
	//Here is some example syntax for the GraphDraw class
    public static void dessiner() {
    	JFrame frame = new JFrame();
    	frame.add(new DrawGraph());   	
    	frame.pack();
    	frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
    }
    
}