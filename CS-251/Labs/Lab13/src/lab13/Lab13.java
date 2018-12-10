
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
		add(numberDisplay, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		//TODO
		//Change panel layout to GridLayout that is 4x3
		String nums[] = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "C" , "0", "." };
		
		//TODO
		//Fill your panel with JButtons with the appropriate text.
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
			
			//TODO
			//The jb declared above is the button that was clicked.  Remember how this was done, it may appear on the final.
			//Using the text of jb and the numberDisplay declared above, update numberDisplay as described in the lab description.
			//From here on out it is merely String comparisons and manipulations.
			//You just need to test accordingly and update correctly.
			
			
		}
	}

	public static void main(String[] args) {

		new Lab13();

	}

}
