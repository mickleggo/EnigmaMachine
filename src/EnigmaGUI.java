import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class EnigmaGUI {

	private JFrame frame;
	
	public static void StartEnigmaGUI() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnigmaGUI window = new EnigmaGUI();
					window.frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	public EnigmaGUI() {

		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnTypeControl = new JButton("Select to Type");
		
		btnTypeControl.setBounds(125, 116, 200, 23);
		frame.getContentPane().add(btnTypeControl);
		
		JTextPane textMessageDisplay = new JTextPane();
		textMessageDisplay.setBounds(25, 150, 385, 200);
		frame.getContentPane().add(textMessageDisplay);
		
		
		//***********Rotor Position Select and Display***********************//
		JTextPane textRotorPos1 = new JTextPane();
		textRotorPos1.setBounds(275, 75, 50, 25);
		frame.getContentPane().add(textRotorPos1);
		
		JTextPane textRotorPos2 = new JTextPane();
		textRotorPos2.setBounds(200, 75, 50, 25);
		frame.getContentPane().add(textRotorPos2);
		
		JTextPane textRotorPos3 = new JTextPane();
		textRotorPos3.setBounds(125, 75, 50, 25);
		frame.getContentPane().add(textRotorPos3);
		
		
		//***********Label Boxes********************************************//
		JLabel lblRotors = new JLabel("Rotors");
		lblRotors.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRotors.setBounds(204, 10, 46, 14);
		frame.getContentPane().add(lblRotors);
		
		JLabel lblRotorPosition = new JLabel("Position");
		lblRotorPosition.setFont(lblRotorPosition.getFont().deriveFont(lblRotorPosition.getFont().getStyle() | Font.BOLD));
		lblRotorPosition.setBounds(200, 60, 46, 14);
		frame.getContentPane().add(lblRotorPosition);
		
		
		//***********Rotor Selection and Display***************************//
		JComboBox comboBoxRotorSelect1 = new JComboBox();
		comboBoxRotorSelect1.setBounds(125, 30, 50, 22);
		frame.getContentPane().add(comboBoxRotorSelect1);
		
		JComboBox comboBoxRotorSelect2 = new JComboBox();
		comboBoxRotorSelect2.setBounds(200, 30, 50, 22);
		frame.getContentPane().add(comboBoxRotorSelect2);
		
		JComboBox comboBoxRotorSelect3 = new JComboBox();
		comboBoxRotorSelect3.setBounds(275, 30, 50, 22);
		frame.getContentPane().add(comboBoxRotorSelect3);
		
		btnTypeControl.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int ascii = e.getKeyCode();
				char pressedKey = e.getKeyChar();
				pressedKey = Character.toUpperCase(pressedKey);
				
				char encodedKey = EnigmaMachine.PassKeyPress(pressedKey, ascii);;
				
				EnigmaMachine.CheckNewLine();
				
				String userInput = EnigmaMachine.SendUserInput();
				textMessageDisplay.setText(userInput);
					
				int Rotor1Pos, Rotor2Pos, Rotor3Pos;
				
				Rotor1Pos = EnigmaMachine.SendRotor1Pos();
				Rotor2Pos = EnigmaMachine.SendRotor2Pos();
				Rotor3Pos = EnigmaMachine.SendRotor3Pos();
				
				textRotorPos1.setText("" + Rotor1Pos);
				textRotorPos2.setText("" + Rotor2Pos);
				textRotorPos3.setText("" + Rotor3Pos);				
				
			}
		});
		
	}
	
	
}
