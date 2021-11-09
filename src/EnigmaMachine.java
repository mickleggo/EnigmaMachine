import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Currently runs correctly with Rotor Slots 1, 2, and 3 hard set as rotors 1, 2, and 3 respectively. All rotors start at position 1.
 * Testing however has shown that everything runs correctly on the side of encrypting and decrypting.
 * 
 * There is additional code added not currently used as I have started on the next stage however setting up a working as is version for
 * github to fall back on. Additionally the entire program is currently one class. I do intent to change this to at least two classes
 * in the future.
 * 
 * Release as version 0.1.0
 * 
 * Author: Michael Legg
 */


/*************************************************************************************************************************************************************/

public class EnigmaMachine {

	private JFrame frame;
	private String userInput = "";
	
	private String EncodedTranslate = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private String EncodedRotor1 = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
	private String EncodedRotor2 = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
	private String EncodedRotor3 = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
	private String EncodedRotor4 = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
	private String EncodedRotor5 = "VZBRGITYUPSDNHLXAWMJQOFECK";
	
	private String EncodedReflector1 = "EJMZALYXVBWFCRQUONTSPIKHGD";
	private String EncodedReflector2 = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
	private String EncodedReflector3 = "FVPJIAOYEDRZXWGCTKUQSBNMHL";
	
	

	private int index, tempNumHold, testNum, selectedRotor1, selectedRotor2, selectedRotor3;
	private char tempCharHold;

	private char[][] RotorSlot1 = new char[2][26];
	private char[][] RotorSlot2 = new char[2][26];
	private char[][] RotorSlot3 = new char[2][26];
	private char[][] Reflector = new char[2][26];
	
	private int[][] RotorAvailable = new int[2][5];

	/*
	 * RotorAvailable built into two columns. Column 0 are the Rotors 1 through 5. Column 1 will be 1 or 0 for if it is available or not (boolean).
	 */
	
	private int Rotor1Pos = 1;
	private int Rotor2Pos = 1;
	private int Rotor3Pos = 1;
	
	
	
  /*************************************************************************************************************************************************************/	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnigmaMachine window = new EnigmaMachine();
					window.frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	
  /*************************************************************************************************************************************************************/

	
	/**
	 * Create the application.
	 */
	public EnigmaMachine() {
		
		for(index = 0; index < 5; index++) {
			RotorAvailable[0][index] = index;
			RotorAvailable[1][index] = 1;
		}
		
		for(index = 0; index < 26; index++) {
			Reflector[0][index] = EncodedTranslate.charAt(index);
			Reflector[1][index] = EncodedReflector1.charAt(index);
		}
		
		
		/********** Places rotors for testing******************/
		
		for(index = 0; index < 26; index++) {
			RotorSlot1[0][index] = EncodedTranslate.charAt(index);
			RotorSlot1[1][index] = EncodedRotor1.charAt(index);
		}
		
		for(index = 0; index < 26; index++) {
			RotorSlot2[0][index] = EncodedTranslate.charAt(index);
			RotorSlot2[1][index] = EncodedRotor2.charAt(index);
		}
		
		for(index = 0; index < 26; index++) {
			RotorSlot3[0][index] = EncodedTranslate.charAt(index);
			RotorSlot3[1][index] = EncodedRotor3.charAt(index);
		}
		
		
		
		RunningApp();
	}
	

  /*************************************************************************************************************************************************************/

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void RunningApp() {

		
		
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
				char encodedKey;
				
				if (ascii >= 65 && ascii <= 90) {
					encodedKey = EncodeChar(pressedKey, ascii);	
					userInput += encodedKey;
				}
				else {}
				
				CheckNewLine();
				textMessageDisplay.setText(userInput);
					
				textRotorPos1.setText("" + Rotor1Pos);
				textRotorPos2.setText("" + Rotor2Pos);
				textRotorPos3.setText("" + Rotor3Pos);				
				
			}
		});
		
	}
	
	
  /*************************************************************************************************************************************************************/
	
	
	public void InsertRotors(int rotorPosition, int rotorSelect) {
		
		//****************Rotor1 setup*********************//
		if (rotorPosition == 1) {
			if (rotorSelect == 1) {
				for(index = 0; index < 26; index++) {
					RotorSlot1[0][index] = EncodedTranslate.charAt(index);
					RotorSlot1[1][index] = EncodedRotor1.charAt(index);
				}
				RotorAvailable[1][0] = 0;
			}
			else if (rotorSelect == 2) {
				for(index = 0; index < 26; index++) {
					RotorSlot1[0][index] = EncodedTranslate.charAt(index);
					RotorSlot1[1][index] = EncodedRotor2.charAt(index);
				}
				RotorAvailable[1][1] = 0;
			}
			else if (rotorSelect == 3) {
				for(index = 0; index < 26; index++) {
					RotorSlot1[0][index] = EncodedTranslate.charAt(index);
					RotorSlot1[1][index] = EncodedRotor3.charAt(index);
				}
				RotorAvailable[1][2] = 0;
			}
			else if (rotorSelect == 4) {
				for(index = 0; index < 26; index++) {
					RotorSlot1[0][index] = EncodedTranslate.charAt(index);
					RotorSlot1[1][index] = EncodedRotor4.charAt(index);
				}
				RotorAvailable[1][3] = 0;
			}
			else if (rotorSelect == 5) {
				for(index = 0; index < 26; index++) {
					RotorSlot1[0][index] = EncodedTranslate.charAt(index);
					RotorSlot1[1][index] = EncodedRotor5.charAt(index);
				}
				RotorAvailable[1][4] = 0;
			}
			else {
				System.out.println("Invalid rotorSelect available");
			}
		}
		else {};
		
		
		//****************Rotor2 setup*********************//
		if (rotorPosition == 2) {
			if (rotorSelect == 1) {
				for(index = 0; index < 26; index++) {
					RotorSlot2[0][index] = EncodedTranslate.charAt(index);
					RotorSlot2[1][index] = EncodedRotor1.charAt(index);
				}
				RotorAvailable[1][0] = 0;
			}
			else if (rotorSelect == 2) {
				for(index = 0; index < 26; index++) {
					RotorSlot2[0][index] = EncodedTranslate.charAt(index);
					RotorSlot2[1][index] = EncodedRotor2.charAt(index);
				}
				RotorAvailable[1][1] = 0;
			}
			else if (rotorSelect == 3) {
				for(index = 0; index < 26; index++) {
					RotorSlot2[0][index] = EncodedTranslate.charAt(index);
					RotorSlot2[1][index] = EncodedRotor3.charAt(index);
				}
				RotorAvailable[1][2] = 0;
			}
			else if (rotorSelect == 4) {
				for(index = 0; index < 26; index++) {
					RotorSlot2[0][index] = EncodedTranslate.charAt(index);
					RotorSlot2[1][index] = EncodedRotor4.charAt(index);
				}
				RotorAvailable[1][3] = 0;
			}
			else if (rotorSelect == 5) {
				for(index = 0; index < 26; index++) {
					RotorSlot2[0][index] = EncodedTranslate.charAt(index);
					RotorSlot2[1][index] = EncodedRotor5.charAt(index);
				}
				RotorAvailable[1][4] = 0;
			}
			else {
				System.out.println("Invalid rotorSelect available");
			}
		}
		else {};
			
		
		//****************Rotor3 setup*********************//
		if (rotorPosition == 3) {
			if (rotorSelect == 1) {
				for(index = 0; index < 26; index++) {
					RotorSlot3[0][index] = EncodedTranslate.charAt(index);
					RotorSlot3[1][index] = EncodedRotor1.charAt(index);
				}
				RotorAvailable[0][0] = 0;
			}
			else if (rotorSelect == 2) {
				for(index = 0; index < 26; index++) {
					RotorSlot3[0][index] = EncodedTranslate.charAt(index);
					RotorSlot3[1][index] = EncodedRotor1.charAt(index);
				}
				RotorAvailable[1][0] = 0;
			}
			else if (rotorSelect == 3) {
				for(index = 0; index < 26; index++) {
					RotorSlot3[0][index] = EncodedTranslate.charAt(index);
					RotorSlot3[1][index] = EncodedRotor1.charAt(index);
				}
				RotorAvailable[2][0] = 0;
			}
			else if (rotorSelect == 4) {
				for(index = 0; index < 26; index++) {
					RotorSlot3[0][index] = EncodedTranslate.charAt(index);
					RotorSlot3[1][index] = EncodedRotor1.charAt(index);
				}
				RotorAvailable[3][0] = 0;
			}
			else if (rotorSelect == 5) {
				for(index = 0; index < 26; index++) {
					RotorSlot3[0][index] = EncodedTranslate.charAt(index);
					RotorSlot3[1][index] = EncodedRotor1.charAt(index);
				}
				RotorAvailable[4][0] = 0;
			}
			else {
				System.out.println("Invalid rotorSelect available");
			}	
		}
		else {};
		
	}//end of InsertRotors()
	
	
  /*************************************************************************************************************************************************************/
	
	
	public void PositionSet(int selectedRotor, int setPosition) {
		int rotate = 0;
		
		//*********Set Rotor1 Position*******************//
		if (selectedRotor == 1) {
			for (rotate = 0; rotate < setPosition-1; rotate++) {
				for(testNum = 0; testNum <=1; testNum++) {
					tempCharHold = RotorSlot1[testNum][0];
				
					for(index = 1; index <= 25; index++) {
						RotorSlot1[testNum][index-1] = RotorSlot1[testNum][index];
					}
					RotorSlot1[testNum][index-1] = tempCharHold;
				}
			}
			Rotor1Pos = setPosition;
		}
		else{};
		
		
		//*********Set Rotor2 Position*******************//
		if (selectedRotor == 2) {
			for (rotate = 0; rotate < setPosition-1; rotate++) {
				for(testNum = 0; testNum <=1; testNum++) {
					tempCharHold = RotorSlot1[testNum][0];
				
					for(index = 1; index <= 25; index++) {
						RotorSlot2[testNum][index-1] = RotorSlot2[testNum][index];
					}
					RotorSlot2[testNum][index-1] = tempCharHold;
				}
			}
			Rotor2Pos = setPosition;
		}
		else{};
		
		
		//*********Set Rotor3 Position*******************//
		if (selectedRotor == 3) {
			for (rotate = 0; rotate < setPosition-1; rotate++) {
				for(testNum = 0; testNum <=1; testNum++) {
					tempCharHold = RotorSlot1[testNum][0];
				
					for(index = 1; index <= 25; index++) {
						RotorSlot3[testNum][index-1] = RotorSlot3[testNum][index];
					}
					RotorSlot3[testNum][index-1] = tempCharHold;
				}
			}
			Rotor3Pos = setPosition;
		}
		else{};
		
		return;
	}//end of PositionSet()
	
	
  /*************************************************************************************************************************************************************/
	
	
	public char EncodeChar(char pressed, int asciiValue) {
		int ascii = (asciiValue - 65);
		char output;
		
		
		//Key Input
		char input = pressed;
		
			
		//Input to Rotor1
		input = RotorSlot1[0][ascii];
		//Through Rotor1
		index = 0;
		while(RotorSlot1[1][index] != input) {
			index++;
		}
		

		//Input to Rotor2
		input = RotorSlot2[0][index];
		//Through Rotor2
		index = 0;
		while(RotorSlot2[1][index] != input) {
			index++;
		}
		
		
		//Input to Rotor3
		input = RotorSlot3[0][index];
		//Through Rotor3
		index = 0;
		while(RotorSlot3[1][index] != input) {
			index++;
		}
		
		
		//Input to Reflector
		input = Reflector[0][index];
		//Through Reflector
		input = Reflector[1][index];
		index = 0;
		while(Reflector[0][index] != input) {
			index++;
		}
		
		
		//Input to Rotor3
		input = RotorSlot3[1][index];
		//Through Rotor3
		index = 0;
		while(RotorSlot3[0][index] != input) {
			index++;
		}
		
		
		//Input to Rotor2
		input = RotorSlot2[1][index];
		//Through Rotor2
		index = 0;
		while(RotorSlot2[0][index] != input) {
			index++;
		}

		
		//Input to Rotor1
		input = RotorSlot1 [1][index];
		//Through Rotor1
		index = 0;
		while(RotorSlot1[0][index] != input) {
			index++;
		}

		
		//Rotor1 to Output
		output = (char)(index+65);

		
		CycleRotors();
		
		return output;
	}
	
	
  /*************************************************************************************************************************************************************/
	
	
	public void CycleRotors() {
		
		//Rotate Rotor 1;
		for(testNum = 0; testNum <=1; testNum++) {
			tempCharHold = RotorSlot1[testNum][0];
			
			for(index = 1; index <= 25; index++) {
				RotorSlot1[testNum][index-1] = RotorSlot1[testNum][index];
			}
			RotorSlot1[testNum][index-1] = tempCharHold;
		}
		Rotor1Pos++;
		
		//Check if Rotor 1 is back at start
		if (Rotor1Pos > 26) {
			Rotor1Pos = 1;
			
			//Rotate Rotor 2
			for(testNum = 0; testNum <=1; testNum++) {
				tempCharHold = RotorSlot2[testNum][0];
				
				for(index = 1; index <= 25; index++) {
					RotorSlot2[testNum][index-1] = RotorSlot2[testNum][index];
				}
				RotorSlot2[testNum][index-1] = tempCharHold;
			}
			Rotor2Pos++;
		}
		
		//Check if Rotor 2 is back at start
		if (Rotor2Pos > 26) {
			Rotor2Pos = 1;
			
			//Rotate Rotor 3
			for(testNum = 0; testNum <=1; testNum++) {
				tempCharHold = RotorSlot3[testNum][0];
				
				for(index = 1; index <= 25; index++) {
					RotorSlot3[testNum][index-1] = RotorSlot3[testNum][index];
				}
				RotorSlot3[testNum][index-1] = tempCharHold;
			}
			Rotor3Pos++;
		}
		
		if (Rotor3Pos > 26) {
			Rotor3Pos = 1;
		}
				
		return;
	}
	
	
  /*************************************************************************************************************************************************************/

	
	public void CheckNewLine() {
		testNum = 0;
		tempNumHold = userInput.length();
		testNum = tempNumHold % 45;
		
		if (tempNumHold > 0 && testNum == 0) {
			userInput += "\r\n";
		}
		
		return;
	}
	
	
  /*************************************************************************************************************************************************************/
	
	
	
} //end of class













