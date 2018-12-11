package lab13;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Lab13 extends JFrame {
	private static final long serialVersionUID = 1L;

	private int WIDTH = 300;
	private int HEIGHT = 300;
	private JLabel numberDisplay;

	
	
	public Lab13() {
		setTitle("Keypad");
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		createContents();
		setVisible(true);
	}

	private void createContents() {
		numberDisplay = new JLabel("0");
		//Changes font of number display
		numberDisplay.setFont(new Font("Arial", Font.PLAIN, 40));
		numberDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
	

		JPanel result = new JPanel();
		result.setLayout(new BorderLayout());

		JPanel numbers = new JPanel();
		add(numbers, BorderLayout.CENTER);
		add(result, BorderLayout.NORTH);
		
		result.add(numberDisplay, BorderLayout.EAST);

		//TODO
		//Change panel layout to GridLayout that is 4x3
		numbers.setLayout(new GridLayout(4,3));
		String nums[] = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "C" , "0", "." };
		
		
		//TODO
		//Fill your panel with JButtons with the appropriate text.
		
		for (int i = 0; i < nums.length; i++) {
			
			JButton button = new JButton(nums[i]);
			button.addActionListener(new ButtonsListener());
			numbers.add(button);
			
		}
		//A for loop will work well here.
		//You need to make new JButtons.
		//You need to add the correct action listener to each button.
		//Then you need to add your JButton to the panel

		
		//TODO
		//Add your panel to the center of your JFrame
		
		

	}

	private class ButtonsListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			JButton jb = (JButton) event.getSource();
			String text = jb.getText();
			String result = numberDisplay.getText();
			
			//TODO
			//The jb declared above is the button that was clicked.  Remember how this was done, it may appear on the final.
			//Using the text of jb and the numberDisplay declared above, update numberDisplay as described in the lab description.
			//From here on out it is merely String comparisons and manipulations.
			//You just need to test accordingly and update correctly.
			
			switch(text) {
			
				case  "1":
					if (result.equals("0")) {
						result = "";
					}
					result = result + text;
					numberDisplay.setText(result);
					
					break;
					
				case "2":
					if (result.equals("0")) {
						result = "";
					}
					result = result + text;
					numberDisplay.setText(result);
					break;
					
				case "3":
					if (result.equals("0")) {
						result = "";
					}
					result = result + text;
					numberDisplay.setText(result);
					break;
					
				case "4":
					if (result.equals("0")) {
						result = "";
					}
					result = result + text;
					numberDisplay.setText(result);
				
					break;
					
				case "5":
					if (result.equals("0")) {
						result = "";
					}
					result = result + text;
					numberDisplay.setText(result);
				
					break;
					
				case "6":
					if (result.equals("0")) {
						result = "";
					}
					result = result + text;
					numberDisplay.setText(result);
				
					break;
					
				case "7":
					if (result.equals("0")) {
						result = "";
					}
					result = result + text;
					numberDisplay.setText(result);
				
					break;
					
				case "8":
					if (result.equals("0")) {
						result = "";
					}
					result = result + text;
					numberDisplay.setText(result);
					break;
					
				case  "9":
					if (result.equals("0")) {
						result = "";
					}
					result = result + text;
					numberDisplay.setText(result);
					break;
					
				case "0":
					if(!result.equals("0")) {
						result = result + text;
						numberDisplay.setText(result);
					}

					break;
					
				case  "C":
					result = "0";
					numberDisplay.setText(result);
					break;
					
				case  ".":
					
					if(!result.contains(".")) {
						result = result + text;
						numberDisplay.setText(result);
					}
					break;
			}
			
		}
	}

	public static void main(String[] args) {

		new Lab13();

	}

}
