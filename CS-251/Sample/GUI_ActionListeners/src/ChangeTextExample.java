import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChangeTextExample extends JFrame {

	JPanel jp;
	JTextField jt;
	JLabel jl;
	
	public ChangeTextExample() {
		setSize(250,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Change text example.");
		createContents();
		setVisible(true);
	}
	
	public void createContents() {
		jp = new JPanel();
		
		jt = new JTextField(20);
		jt.setHorizontalAlignment(JTextField.CENTER);	//makes it so text is centered inside text field
		jt.addActionListener(new clickListener());		//add action listener to text field
		
		jl = new JLabel("Text to change");
		jp.add(jt);
		jp.add(jl);
		
		add(jp);
	}
	
	public class clickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JTextField tmpField = (JTextField) e.getSource();	//get source of event, in this case it will be when you press enter
																//tmpField == jt from above at this point
			jl.setText(tmpField.getText());						//get current text in text field, store it jlabel
			tmpField.setText("");								//reset text field to be empty
		}
		
	}
	
	public static void main(String[] args) {
		new ChangeTextExample();
	}
	
}
