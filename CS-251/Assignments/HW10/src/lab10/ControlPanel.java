package lab10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ControlPanel extends JPanel {

	
	JLabel yellowCount;
	JLabel yVal;
	JLabel blackCount;
	JLabel bVal;
	JButton reset;
	JLabel win;
	GameBoard gb;
	
	//TODO
	public ControlPanel(GameBoard gb) {
		
		this.gb = gb;
		createContents();
			
	}
	
	public void createContents() {
		//this = new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		yellowCount = new JLabel("Yellow Count");
		yVal = new JLabel("" + gb.yCount);
		blackCount = new JLabel("Black Count");
		bVal = new JLabel("" + gb.bCount);
		win = new JLabel("You Win!");
		reset = new JButton("Reset");
		reset.addActionListener(new resetButtonClick());
		
		this.add(yellowCount);
		this.add(yVal);
		this.add(blackCount);
		this.add(bVal);
		this.add(win);
		this.add(reset);
		win.setVisible(false);
		
		
	}
	
	
	public class resetButtonClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			gb.resetGameBoard();

		}

	}
	
	
}
