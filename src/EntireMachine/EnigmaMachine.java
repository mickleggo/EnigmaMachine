package EntireMachine;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Currently runs correctly with Rotor Slots 1, 2, and 3 hard set as rotors 1, 2, and 3 respectively. All rotors start at position 1.
 * Testing however has shown that everything runs correctly on the side of encrypting and decrypting.
 * 
 * There is additional code added not currently used as I have started on the next stage however setting up a working as is version for
 * github to fall back on. 
 * 
 * Program now runs as accurately as version 0.1.0 but is now split into multiple classes.
 * 
 * Release as version 0.2.0
 * 
 * Once some time has been spent to add proper comments, increment version by 0.0.1
 * 
 * Next version will work on selecting rotors.
 * 
 * Author: Michael Legg
 */


/*************************************************************************************************************************************************************/

public class EnigmaMachine {

	private EnigmaGUI gui = new EnigmaGUI();
	private KeyPressHandler kHandler = new KeyPressHandler();
	private DisplayUpdate dManager = new DisplayUpdate(gui);
	
	private static String userInput = String.valueOf('\0');
	
	private static String EncodedTranslate = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private static String EncodedRotor1 = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
	private static String EncodedRotor2 = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
	private static String EncodedRotor3 = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
	private static String EncodedRotor4 = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
	private static String EncodedRotor5 = "VZBRGITYUPSDNHLXAWMJQOFECK";
	
	private static String EncodedReflector1 = "EJMZALYXVBWFCRQUONTSPIKHGD";
	private static String EncodedReflector2 = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
	private static String EncodedReflector3 = "FVPJIAOYEDRZXWGCTKUQSBNMHL";

	private static int index, ascii; 
	private static int tempNumHold, testNum, selectedRotor1, selectedRotor2, selectedRotor3;
	private static char tempCharHold, output;
	private static char pressedKey, encodedKey;

	private static char[][] RotorSlot1 = new char[2][26];
	private static char[][] RotorSlot2 = new char[2][26];
	private static char[][] RotorSlot3 = new char[2][26];
	private static char[][] Reflector = new char[2][26];
	
	private static int[][] RotorAvailable = new int[2][5];

	/*
	 * RotorAvailable built into two columns. Column 0 are the Rotors 1 through 5. Column 1 will be 1 or 0 for if it is available or not (boolean).
	 */
	
	private static int Rotor1Pos = 1;
	private static int Rotor2Pos = 1;
	private static int Rotor3Pos = 1;
	
	
	
  /*************************************************************************************************************************************************************/	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		new EnigmaMachine();
		
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
		
		gui.EnigmaGUI(kHandler);
	
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

	
	public static void PassKeyPress() {
		
		encodedKey = '\0';
		
		if (ascii >= 65 && ascii <= 90) {
			EncodeChar();
				userInput += String.valueOf(encodedKey);
		}
		else {}
		
		CheckNewLine();
		
	return;
	} 
	
	
  /*************************************************************************************************************************************************************/
	
	
	public static void EncodeChar() {
		
		ascii = (ascii - 65);
		
		//Key Input
		char input = pressedKey;
		
			
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
		encodedKey = (char)(index+65);

		
		CycleRotors();
		
		return;
	}
	
	
  /*************************************************************************************************************************************************************/
	
	
	public static void CycleRotors() {
		
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

	
	public static void CheckNewLine() {
		testNum = 0;
		tempNumHold = userInput.length();
		testNum = tempNumHold % 45;
		
		if (tempNumHold > 0 && testNum == 0) {
			userInput += "\r\n";
		}
		
		return;
	}
	
	
  /*************************************************************************************************************************************************************/
	
	public static String SendUserInput() {
		return userInput;
	}
	
	public static int SendRotor1Pos() {
		return Rotor1Pos;
	}
	
	public static int SendRotor2Pos() {
		return Rotor2Pos;
	}

	public static int SendRotor3Pos() {
	return Rotor3Pos;
}

	
	  /*************************************************************************************************************************************************************/
	
		public class KeyPressHandler implements KeyListener {

			public void keyPressed(KeyEvent e) {
				ascii = e.getKeyCode();
				pressedKey = e.getKeyChar();
				pressedKey = Character.toUpperCase(pressedKey);
				EnigmaMachine.PassKeyPress();
				dManager.updateDisplay();
				
			}

			public void keyTyped(KeyEvent e) {
			}
			
			public void keyReleased(KeyEvent e) {
			}


				
		
		} //end of class KeyPressHandler
	
	
} //end of class EnigmaMachine













