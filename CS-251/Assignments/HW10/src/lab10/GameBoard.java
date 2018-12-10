package lab10;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



public class GameBoard extends JPanel {

	public int gridSizeCol = 8;
	public int gridSizeRow = 8;
	private LightsOutCircle[][] gridCopy = new LightsOutCircle[gridSizeCol][gridSizeRow];
	private int yCount = 64;
	private int bCount = 0;
	private ControlPanel cp;
	
	
	public GameBoard() {
		
		this.setLayout(new GridLayout(gridSizeCol, gridSizeRow));
		createContents();
		setVisible(true);	
		
	}
	public void setCP(ControlPanel cp) {
		this.cp = cp;
	}
	
	public void createContents () {
		
		for (int i = 0; i < 8; i++) {
			for (int x = 0; x < 8; x++) {
				LightsOutCircle circle = new LightsOutCircle(x,i);
				circle.setYellow();
				circle.addActionListener(new circleClick());
				gridCopy[i][x] = circle;
				this.add(circle);
			}	
		}
	
	}
	
	public void resetGameBoard() {
		
		for (int i = 0; i < 8; i++) {
			for (int x = 0; x < 8; x++) {
				
				LightsOutCircle tmp = gridCopy[i][x];
				tmp.setYellow();
				tmp.setEnabled(true);
			}
		}
		yCount = 64;
		bCount = 0;
		cp.setbValText(bCount);
		cp.setyValText(yCount);
		cp.showWin(false);
	}
	
	public class circleClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			LightsOutCircle tmpButton = (LightsOutCircle) e.getSource();

		
			int col = tmpButton.col;
			int row = tmpButton.row;
			
			if (col+1 < gridSizeCol) {
				LightsOutCircle tmp = gridCopy[col+1][row];
				flipColor(tmp);
				
			}
			if (col-1 >= 0) {
				LightsOutCircle tmp = gridCopy[col-1][row];
				flipColor(tmp);
				
			}
			if (row+1 < gridSizeRow) {
				LightsOutCircle tmp = gridCopy[col][row+1];
				flipColor(tmp);
				
			}
			if (row-1 >= 0) {
				LightsOutCircle tmp = gridCopy[col][row-1];
				flipColor(tmp);
				
			}	

			if (bCount == 64) {
				
				cp.showWin(true);
				
				for (int i = 0; i < 8; i++) {
					for (int x = 0; x < 8; x++) {
						LightsOutCircle tmp = gridCopy[i][x];
						tmp.setEnabled(false);
						
					}
				}	
			}
			
		}

	}
	
	private void flipColor(LightsOutCircle c) {
		
		if (c.isBlack()) {
			c.setYellow();
			yCount ++;
			bCount--;
		}
		else if(c.isYellow()) {
			c.setBlack();
			yCount--;
			bCount++;
		}
		
		cp.setbValText(bCount);
		cp.setyValText(yCount);
		
	}
	
	public int getYellowCount() {
		return yCount;
	}
	
	public int getBlackCount() {
		return bCount;
	}
	
	
	
}
