package EntireMachine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Rotors selectable, can currently put multiple of same rotor in different slots. All rotors start at position 1.
 
 * Program now runs as accurately as version 0.1.0 but is now split into multiple classes.
 * 
 * Release as EnigmaMachine Version 0.3.0
 * 
 * Once some time has been spent to add proper comments, increment version by 0.0.1
 * 
 * Work still to be done:
 * - Implement rest of Rotor Selection features such
 * as only being able to use each rotor in one place and with one rotor
 * selected, remove from other lists.
 * - Implement Selecting start position
 * - Implement Display letter for for rotor position (as per original enigma machine)
 * - add clear button to remove all text and other selections, ie: rotors, position.
 * - add button to export encrypted/decrypted message to txt file.
 * - implement plug board
 * 
 * Author: Michael Legg
 */


/*************************************************************************************************************************************************************/

public class EnigmaMachine {

	private EnigmaGUI gui = new EnigmaGUI();
	private KeyPressHandler kHandler = new KeyPressHandler();
	private RSlot1Handler r1Handler = new RSlot1Handler();
	private RSlot2Handler r2Handler = new RSlot2Handler();
	private RSlot3Handler r3Handler = new RSlot3Handler();
	private DisplayUpdate dManager = new DisplayUpdate(gui);
	
	private static String userInput = String.valueOf('\0');
	
	private static String[] possibleRotors = { String.valueOf('\0'),"I", "II", "III", "IV", "V" };
	
	private static String EncodedTranslate = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private static String EncodedReflector1 = "EJMZALYXVBWFCRQUONTSPIKHGD";
	private static String EncodedReflector2 = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
	private static String EncodedReflector3 = "FVPJIAOYEDRZXWGCTKUQSBNMHL";

	private static int index, ascii; 
	private static int tempNumHold, testNum, selectedRotor1, selectedRotor2, selectedRotor3;
	private static char tempCharHold;
	private static char pressedKey, encodedKey;

	private static char[][] RotorSlot1 = new char[2][26];
	private static char[][] RotorSlot2 = new char[2][26];
	private static char[][] RotorSlot3 = new char[2][26];
	private static char[][] Reflector = new char[2][26];
	
	private static boolean[] RotorAvailable = new boolean[5];
	
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
			RotorAvailable[index] = true;
		}
		
		for(index = 0; index < 26; index++) {
			Reflector[0][index] = EncodedTranslate.charAt(index);
			Reflector[1][index] = EncodedReflector1.charAt(index);
		}
		
		gui.EnigmaGUI(kHandler, r1Handler, r2Handler, r3Handler);
		dManager.updateDisplay();
	
	}
	
	
  /*************************************************************************************************************************************************************/
	
	/*********************************** Set Rotors *****************************************/
	
	//****************Rotor1 setup*********************//
	
	public static void SetRotor1(int rotorSelect) {
		
		if (rotorSelect == 1) {
			for(index = 0; index < 26; index++) {
				RotorSlot1[0][index] = EncodedTranslate.charAt(index);
				RotorSlot1[1][index] = Rotors.Rotor1.ReturnCharAt(index);
			}
			RotorAvailable[0] = false;
		}
		else if (rotorSelect == 2) {
			for(index = 0; index < 26; index++) {
				RotorSlot1[0][index] = EncodedTranslate.charAt(index);
				RotorSlot1[1][index] = Rotors.Rotor2.ReturnCharAt(index);
			}
			RotorAvailable[1] = false;
		}
		else if (rotorSelect == 3) {
			for(index = 0; index < 26; index++) {
				RotorSlot1[0][index] = EncodedTranslate.charAt(index);
				RotorSlot1[1][index] = Rotors.Rotor3.ReturnCharAt(index);
			}
			RotorAvailable[2] = false;
		}
		else if (rotorSelect == 4) {
			for(index = 0; index < 26; index++) {
				RotorSlot1[0][index] = EncodedTranslate.charAt(index);
				RotorSlot1[1][index] = Rotors.Rotor4.ReturnCharAt(index);
			}
			RotorAvailable[3] = false;
		}
		else if (rotorSelect == 5) {
			for(index = 0; index < 26; index++) {
				RotorSlot1[0][index] = EncodedTranslate.charAt(index);
				RotorSlot1[1][index] = Rotors.Rotor5.ReturnCharAt(index);
			}
			RotorAvailable[4] = false;
		}
		else {
			System.out.println("Invalid rotorSelect available");
		}	
		
		return;
	}
	
	//****************Rotor2 setup*********************//
	
	public static void SetRotor2(int rotorSelect) {
		
		if (rotorSelect == 1) {
			for(index = 0; index < 26; index++) {
				RotorSlot2[0][index] = EncodedTranslate.charAt(index);
				RotorSlot2[1][index] = Rotors.Rotor1.ReturnCharAt(index);
			}
			RotorAvailable[0] = false;
		}
		else if (rotorSelect == 2) {
			for(index = 0; index < 26; index++) {
				RotorSlot2[0][index] = EncodedTranslate.charAt(index);
				RotorSlot2[1][index] = Rotors.Rotor2.ReturnCharAt(index);
			}
			RotorAvailable[1] = false;
		}
		else if (rotorSelect == 3) {
			for(index = 0; index < 26; index++) {
				RotorSlot2[0][index] = EncodedTranslate.charAt(index);
				RotorSlot2[1][index] = Rotors.Rotor3.ReturnCharAt(index);
			}
			RotorAvailable[2] = false;
		}
		else if (rotorSelect == 4) {
			for(index = 0; index < 26; index++) {
				RotorSlot2[0][index] = EncodedTranslate.charAt(index);
				RotorSlot2[1][index] = Rotors.Rotor4.ReturnCharAt(index);
			}
			RotorAvailable[3] = false;
		}
		else if (rotorSelect == 5) {
			for(index = 0; index < 26; index++) {
				RotorSlot2[0][index] = EncodedTranslate.charAt(index);
				RotorSlot2[1][index] = Rotors.Rotor5.ReturnCharAt(index);
			}
			RotorAvailable[4] = false;
		}
		else {
			System.out.println("Invalid rotorSelect available");
		}
		
		return;
	}
	
	
		//****************Rotor3 setup*********************//
	
	public static void SetRotor3(int rotorSelect) {	
	
		if (rotorSelect == 1) {
			for(index = 0; index < 26; index++) {
				RotorSlot3[0][index] = EncodedTranslate.charAt(index);
				RotorSlot3[1][index] = Rotors.Rotor1.ReturnCharAt(index);
			}
			RotorAvailable[0] = false;
		}
		else if (rotorSelect == 2) {
			for(index = 0; index < 26; index++) {
				RotorSlot3[0][index] = EncodedTranslate.charAt(index);
				RotorSlot3[1][index] = Rotors.Rotor2.ReturnCharAt(index);
			}
			RotorAvailable[1] = false;
		}
		else if (rotorSelect == 3) {
			for(index = 0; index < 26; index++) {
				RotorSlot3[0][index] = EncodedTranslate.charAt(index);
				RotorSlot3[1][index] = Rotors.Rotor3.ReturnCharAt(index);
			}
			RotorAvailable[2] = false;
		}
		else if (rotorSelect == 4) {
			for(index = 0; index < 26; index++) {
				RotorSlot3[0][index] = EncodedTranslate.charAt(index);
				RotorSlot3[1][index] = Rotors.Rotor4.ReturnCharAt(index);
			}
			RotorAvailable[3] = false;
		}
		else if (rotorSelect == 5) {
			for(index = 0; index < 26; index++) {
				RotorSlot3[0][index] = EncodedTranslate.charAt(index);
				RotorSlot3[1][index] = Rotors.Rotor5.ReturnCharAt(index);
			}
			RotorAvailable[4] = false;
		}
		else {
			System.out.println("Invalid rotorSelect available");
		}
		
		return;
	}
	
	
	//end of Set Rotors sector
	
  /*************************************************************************************************************************************************************/
	
	
	public void PositionSet(int selectedRotor, int setPosition) {
		int rotate = 0;
		
//		//*********Set Rotor1 Position*******************//
//		if (selectedRotor == 1) {
//			for (rotate = 0; rotate < setPosition-1; rotate++) {
//				for(testNum = 0; testNum <=1; testNum++) {
//					tempCharHold = RotorSlot1[testNum][0];
//				
//					for(index = 1; index <= 25; index++) {
//						RotorSlot1[testNum][index-1] = RotorSlot1[testNum][index];
//					}
//					RotorSlot1[testNum][index-1] = tempCharHold;
//				}
//			}
//			Rotor1Pos = setPosition;
//		}
//		else{};
//		
//		
//		//*********Set Rotor2 Position*******************//
//		if (selectedRotor == 2) {
//			for (rotate = 0; rotate < setPosition-1; rotate++) {
//				for(testNum = 0; testNum <=1; testNum++) {
//					tempCharHold = RotorSlot1[testNum][0];
//				
//					for(index = 1; index <= 25; index++) {
//						RotorSlot2[testNum][index-1] = RotorSlot2[testNum][index];
//					}
//					RotorSlot2[testNum][index-1] = tempCharHold;
//				}
//			}
//			Rotor2Pos = setPosition;
//		}
//		else{};
//		
//		
//		//*********Set Rotor3 Position*******************//
//		if (selectedRotor == 3) {
//			for (rotate = 0; rotate < setPosition-1; rotate++) {
//				for(testNum = 0; testNum <=1; testNum++) {
//					tempCharHold = RotorSlot1[testNum][0];
//				
//					for(index = 1; index <= 25; index++) {
//						RotorSlot3[testNum][index-1] = RotorSlot3[testNum][index];
//					}
//					RotorSlot3[testNum][index-1] = tempCharHold;
//				}
//			}
//			Rotor3Pos = setPosition;
//		}
//		else{};
//		
//		return;
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
	
	public static int SendRotor1Selections() {
		return selectedRotor1;
	}
	
	public static int SendRotor2Selections() {
		return selectedRotor2;
	}
	
	public static int SendRotor3Selections() {
		return selectedRotor3;
	}
	
	public static String availableRotor(int i) {
		if (RotorAvailable[i] == true) {
			return possibleRotors[i+1];
		}
		else {
			return "false";
		}
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
		
		
		public class RSlot1Handler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String r1 = e.getSource().toString();
				r1 = RotorActionSubString.makeSubStr(r1);
				switch (r1) {
				
					case "I":
						selectedRotor1 = 1;
						EnigmaMachine.SetRotor1(1);
						break;
						
					case "II":
						selectedRotor1 = 2;
						EnigmaMachine.SetRotor1(2);
						break;
						
					case "III":
						selectedRotor1 = 3;
						EnigmaMachine.SetRotor1(3);
						break;
						
					case "IV":
						selectedRotor1 = 4;
						EnigmaMachine.SetRotor1(4);
						break;
						
					case "V":
						selectedRotor1 = 5;
						EnigmaMachine.SetRotor1(5);
						break;
						
					default:
						System.out.println("RSlot1 Error");	
				}
			}
		} //end of class RotorHandler
		
		public class RSlot2Handler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String r2 = e.getSource().toString();
				r2 = RotorActionSubString.makeSubStr(r2);
				switch (r2) {
					case "I":
						selectedRotor2 = 1;
						EnigmaMachine.SetRotor2(1);
						break;
						
					case "II":
						selectedRotor2 = 2;
						EnigmaMachine.SetRotor2(2);
						break;
						
					case "III":
						selectedRotor2 = 3;
						EnigmaMachine.SetRotor2(3);
						break;
						
					case "IV":
						selectedRotor2 = 4;
						EnigmaMachine.SetRotor2(4);
						break;
						
					case "V":
						selectedRotor2 = 5;
						EnigmaMachine.SetRotor2(5);
						break;
					default:
						System.out.println("RSlot2 Error");	
				}
			}
		} //end of class RotorHandler
		
		public class RSlot3Handler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String r3 = e.getSource().toString();
				r3 = RotorActionSubString.makeSubStr(r3);
				switch (r3) {
					case "I":
						selectedRotor3 = 1;
						EnigmaMachine.SetRotor3(1);
						break;
						
					case "II":
						selectedRotor3 = 2;
						EnigmaMachine.SetRotor2(2);
						break;
						
					case "III":
						selectedRotor3 = 3;
						EnigmaMachine.SetRotor3(3);
						break;
						
					case "IV":
						selectedRotor3 = 4;
						EnigmaMachine.SetRotor3(4);
						break;
						
					case "V":
						selectedRotor3 = 5;
						EnigmaMachine.SetRotor3(5);
						break;
						
					default:
						System.out.println("RSlot3 Error");	
				}
			}
		} //end of class RotorHandler
		
		public static class RotorActionSubString {
			
			public static String makeSubStr(String e) {
				
				int subStrStart = e.lastIndexOf("selectedItemReminder=") + 21;
				int subStrEnd = e.indexOf(']', subStrStart);
				e = e.substring(subStrStart, subStrEnd);
				
				return e;
			}
			
		}
	
	
} //end of class EnigmaMachine













