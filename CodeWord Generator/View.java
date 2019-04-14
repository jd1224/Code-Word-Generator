import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View implements ActionListener{

	private JButton create, close, clear;
	private JTextField inputLength, outputPassword, reversedPassword;
	private JTextArea inputLabel;
	
	public View(){
		//Create the frame with basic layout and settings
		JFrame frame = new JFrame("Code Word Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 200);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		Font myFont = new Font("Serif", Font.BOLD, 50);
		//create button panel and buttons
		JPanel buttonPan = new JPanel();
		
		create = new JButton("Create");
		//add action listeners to perform actions
		create.addActionListener(this);
		close = new JButton("Close");
		close.addActionListener(this);
		clear = new JButton("Clear");
		clear.addActionListener(this);
		
		buttonPan.add(create);
		buttonPan.add(clear);
		buttonPan.add(close);
		//end create button panel and buttons
		//create entry field panel and text field
		JPanel entryPanel = new JPanel();
		
		inputLabel = new JTextArea("");
		inputLabel.setOpaque(false);
		inputLabel.setFont(myFont);
		entryPanel.add(inputLabel);
		
		
		//add all of the panels to the main frame
		frame.add(entryPanel, BorderLayout.CENTER);
		frame.add(buttonPan, BorderLayout.SOUTH);
		//set frame to visible to draw all components
		frame.setVisible(true);
	}
	/**
	 *method to create the password and set the
	 *text int the two JTextField objects to the
	 *appropriate String text
	 */
	private void create(){
		
		WordGenerator gen = new WordGenerator();
		String codeWord = gen.getWord()+" "+gen.getWord();
		inputLabel.setText(codeWord);
	}
	
	/**
	 *Helper method to reverse a String
	 *@param orig String to be reversed
	 *@returns String which is the reverse of orig
	 */
	private String reversed(String orig){
		String output = "";
		char[] chars = orig.toCharArray();
		for(int i=chars.length-1;i>=0;i--){
			output = output + chars[i];
		}
		return output;
	}
	/**
	 *Method to clear all text and reset the 
	 *input size to 0
	 */
	private void clear(){
		inputLabel.setText("");		
	}
	/**
	 *implements ActionListner's only method
	 *Uses a switch to choose from the helper
	 *methods to execute the correct action for 
	 *the button pressed
	 */
	public void actionPerformed(ActionEvent e){
		String event = e.getActionCommand();
		
		switch (event){
			case "Create":
				create();
				break;
			case "Clear":
				clear();
				break;
			case "Close":
				System.exit(0);
		}
	}
}