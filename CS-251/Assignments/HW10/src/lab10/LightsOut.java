package lab10;

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class LightsOut extends JFrame {

	ControlPanel cp;
	GameBoard gb;
	
	public LightsOut() {
	    	
	    	setLayout(new BorderLayout());
		
			setTitle("CS2251 Lights Out");	
			setSize(800, 750);		
			setResizable(false);
			setLocationRelativeTo(null);
			gb = new GameBoard();
			cp = new ControlPanel(gb);
			gb.cp = cp;
			
			add(gb, BorderLayout.CENTER);
			add(cp, BorderLayout.EAST);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
	}
	
	public static void main(String[] args) {
		new LightsOut();
	}
	
	
}
