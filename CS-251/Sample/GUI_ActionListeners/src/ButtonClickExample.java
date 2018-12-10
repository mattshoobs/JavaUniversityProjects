import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonClickExample extends JFrame {

	JPanel jp;
	JLabel label;
	JButton jb1;
	JButton jb2;
	JButton jb3;
	JButton jb4 = null;		//used to hold past button pushed
	int count = 1;			//used to hold number of times a button is clicked

	public ButtonClickExample() {
		setSize(300,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Button Click Example");
		setLocationRelativeTo(null);
		createContents();
		setVisible(true);
	}

	public void createContents() {
		jp = new JPanel();
		label = new JLabel("");
		jb1 = new JButton("Button 1");
		jb1.addActionListener(new buttonClick1());		//add the action listener to each button
		jb2 = new JButton("Button 2");
		jb2.addActionListener(new buttonClick1());
		jb3 = new JButton("Button 3");
		jb3.addActionListener(new buttonClick1());

		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jp.add(label);
		add(jp);

	}

	public class buttonClick1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton tmpButton = (JButton) e.getSource();

			//if jb4 is the same as the buttom pushed, means consecutive push
			if(jb4 == tmpButton) {
				label.setText(tmpButton.getText() + " was clicked " + ++count + " time(s).");
			} else {
				//if not, then a different button was clicked.
				jb4 = tmpButton;
				count = 1;
				label.setText(tmpButton.getText() + " was clicked " + count + " time(s).");
			}

		}

	}

	//A more simple actionlistener, it only changes the text.
	//To use this, add to your JButtons above.
	//Remember to only have one action assigned to a button.
	public class buttonClick2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton tmpButton = (JButton) e.getSource();
			label.setText(tmpButton.getText() + " was clicked.");

		}

	}

	public static void main(String[] args) {
		new ButtonClickExample();
	}

}
