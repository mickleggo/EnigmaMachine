package EntireMachine;
import java.awt.*;
import javax.swing.*;
import EntireMachine.EnigmaMachine.KeyPressHandler;

public class EnigmaGUI {

	JFrame frame;
	JButton btnTypeControl;
	JTextPane textMessageDisplay;
	JTextPane textRotorPos1;
	JTextPane textRotorPos2;
	JTextPane textRotorPos3;
	JLabel lblRotors, lblRotorPosition;
	JComboBox comboBoxRotorSelect1, comboBoxRotorSelect2, comboBoxRotorSelect3;
	
	private int ascii, Rotor1Pos, Rotor2Pos, Rotor3Pos;;
	private char pressedKey, encodedKey;
	
	private Container con;
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void EnigmaGUI(KeyPressHandler kHandler) {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnTypeControl = new JButton("Select to Type");
		btnTypeControl.setBounds(125, 116, 200, 23);
		btnTypeControl.addKeyListener(kHandler);
		frame.getContentPane().add(btnTypeControl);
		
		textMessageDisplay = new JTextPane();
		textMessageDisplay.setBounds(25, 150, 385, 200);
		frame.getContentPane().add(textMessageDisplay);
		
		
		//***********Rotor Position Select and Display***********************//
		textRotorPos1 = new JTextPane();
		textRotorPos1.setBounds(275, 75, 50, 25);
		frame.getContentPane().add(textRotorPos1);
		
		textRotorPos2 = new JTextPane();
		textRotorPos2.setBounds(200, 75, 50, 25);
		frame.getContentPane().add(textRotorPos2);
		
		textRotorPos3 = new JTextPane();
		textRotorPos3.setBounds(125, 75, 50, 25);
		frame.getContentPane().add(textRotorPos3);
		
		
		//***********Label Boxes********************************************//
		lblRotors = new JLabel("Rotors");
		lblRotors.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRotors.setBounds(204, 10, 46, 14);
		frame.getContentPane().add(lblRotors);
		
		lblRotorPosition = new JLabel("Position");
		lblRotorPosition.setFont(lblRotorPosition.getFont().deriveFont(lblRotorPosition.getFont().getStyle() | Font.BOLD));
		lblRotorPosition.setBounds(200, 60, 46, 14);
		frame.getContentPane().add(lblRotorPosition);
		
		
		//***********Rotor Selection and Display***************************//
		comboBoxRotorSelect1 = new JComboBox();
		comboBoxRotorSelect1.setBounds(125, 30, 50, 22);
		frame.getContentPane().add(comboBoxRotorSelect1);
		
		comboBoxRotorSelect2 = new JComboBox();
		comboBoxRotorSelect2.setBounds(200, 30, 50, 22);
		frame.getContentPane().add(comboBoxRotorSelect2);
		
		comboBoxRotorSelect3 = new JComboBox();
		comboBoxRotorSelect3.setBounds(275, 30, 50, 22);
		frame.getContentPane().add(comboBoxRotorSelect3);
		
		
		con = frame.getContentPane();
		frame.setVisible(true);

	
	}
	
}
