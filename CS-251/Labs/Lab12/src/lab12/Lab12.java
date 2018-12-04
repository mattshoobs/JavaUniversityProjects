package lab12;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lab12 extends JFrame {

	public Lab12() {
		
		// TODO Set the title of the Frame to CS251 Calculator
		setTitle("CS2251 Calculator");	
		// TODO set the size of the Frame to 600 x 600
		setSize(600, 600);
		// TODO Make the Frame non-resizable
		setResizable(false);
		// TODO place the frame in the middle of the screen
		setLocationRelativeTo(null);
		// TODO Terminate the program, if we click on the close button of the titlebar.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createComponents();
		//TODO set the frame to visible
		setVisible(true);
	}

	public void createComponents() {

		JPanel numKeysPanel = new JPanel();
		numKeysPanel.setLayout(new GridLayout(4,3));
		
		JPanel operationKeysPanel = new JPanel(new GridLayout(2,2)); 
		
		
		JButton num1 = new JButton("1");
		JButton num2 = new JButton("2");
		JButton num3 = new JButton("3");
		JButton num4 = new JButton("4");
		JButton num5 = new JButton("5");
		JButton num6 = new JButton("6");
		JButton num7 = new JButton("7");
		JButton num8 = new JButton("8");
		JButton num9 = new JButton("9");
		JLabel emptyCell1 = new JLabel("");
		JLabel emptyCell2 = new JLabel("");
		JButton decimalPoint = new JButton(".");

		//TODO Add num1, num2,....decimalPoint to the numKeysPanel panel

		numKeysPanel.add(num1);
		numKeysPanel.add(num2);
		numKeysPanel.add(num3);
		numKeysPanel.add(num4);
		numKeysPanel.add(num5);
		numKeysPanel.add(num6);
		numKeysPanel.add(num7);
		numKeysPanel.add(num8);
		numKeysPanel.add(num9);
		numKeysPanel.add(emptyCell1);
		numKeysPanel.add(emptyCell2);
		numKeysPanel.add(decimalPoint);
		
		
		//TODO Create four JButtons with + - * /
		JButton add = new JButton("+");
		JButton subtract = new JButton("-");
		JButton multiply = new JButton("*");
		JButton divide = new JButton("/");
		//TODO Add the JButtons you have created to the operationKeysPanel panel
		operationKeysPanel.add(add);
		operationKeysPanel.add(subtract);
		operationKeysPanel.add(multiply);
		operationKeysPanel.add(divide);
	    //TODO Add numKeysPanel to the center region of the JFrame
		add(numKeysPanel);
		
		//TODO Add operationKeysPanel to the East region of the JFrame
		add(operationKeysPanel, BorderLayout.EAST);
		
		//TODO Create a JTextField object with text "0" and make the JTextField disabled
		JTextField result = new JTextField("0");
		result.setEnabled(false);
		//TODO add the JTextField object to the North region of the JFrame
		add(result, BorderLayout.NORTH);
	
	}

	
public static void main(String[]args){
	new Lab12();
}


	

}
