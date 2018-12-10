package lab10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ControlPanel extends JPanel {

	
	private JLabel yellowCount;
	private JLabel yVal;
	private JLabel blackCount;
	private JLabel bVal;
	private JButton reset;
	private JLabel win;
	private GameBoard gb;
	
	//TODO
	public ControlPanel(GameBoard gb) {
		
		this.gb = gb;
		createContents();
			
	}
	
	public void createContents() {
		//this = new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		yellowCount = new JLabel("Yellow Count");
		yVal = new JLabel("" + gb.getYellowCount());
		blackCount = new JLabel("Black Count");
		bVal = new JLabel("" + gb.getBlackCount());
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
	
	public void setbValText(int bCount) {
		bVal.setText("" + bCount);
		
	}
	
	public void setyValText(int yCount) {
		yVal.setText("" + yCount);
	}
	
	public void showWin(boolean showWin) {
		if (showWin) {
			win.setVisible(true);
		}
		else {
			win.setVisible(false);
		}
	}
	
	public class resetButtonClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			gb.resetGameBoard();

		}

	}
	
	
}
