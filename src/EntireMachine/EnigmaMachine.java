package EntireMachine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Rotors selectable, can currently put multiple of same rotor in different slots. All rotors start at position 1.
 
 * Program now runs as accurately as version 0.1.0 but is now split into multiple classes.
 * 
 * Release is at EnigmaMachine Version 0.7.0
 * 
 * Once some time has been spent to add proper comments, increment version by 0.0.1
 * 
 * Implementaion and release plan still to work on:
 * 
 * 0.6.0 implement selectable start position
 * 
 * 0.7.0 change position from number to character representation   <---COMPLETED TO HERE
 * 
 * 0.8.0 add "export to text" button, add "clear all/reset" button
 * 
 * 0.8.5 add top bar menu with "about" or similar. eg. a model tag
 * 
 * 0.8.6 finish adding comments if not already complete.
 * 
 * 1.0.0 package as a full release version 1
 * 
 * 1.1.0 design plugboard and add single cable/connector
 * 
 * 1.2.0 add show/hide plugboard button
 * 
 * 1.3.0 implement full ten "cables"
 * 
 * 1.4.0 add "remove all" button for removing all cables.
 * 
 * 1.5.0 add and implement additional reflectors
 * 
 * 2.0.0 package as full release version 2
 * 
 * 2.0.1 plan additional beautification and functions including:
 * - add drag/drop funtion to connector plugboard
 * - add drag/drop function for rotors
 * - add rotate function for rotors
 * 3.0.0 release as full release version 3
 * 
 * Author: Michael Legg
 */


/*************************************************************************************************************************************************************/

@SuppressWarnings({  "unchecked" })
public class EnigmaMachine {

	private static EnigmaGUI gui = new EnigmaGUI();
	private KeyPressHandler kHandler = new KeyPressHandler();
	private RSlot1Handler r1Handler = new RSlot1Handler();
	private RSlot2Handler r2Handler = new RSlot2Handler();
	private RSlot3Handler r3Handler = new RSlot3Handler();
	private static DisplayUpdate dManager = new DisplayUpdate(gui);
	private R1PosHandler p1Handler = new R1PosHandler();
	private R2PosHandler p2Handler = new R2PosHandler();
	private R3PosHandler p3Handler = new R3PosHandler();
	
	private static String userInput = String.valueOf('\0');
	
	private static String EncodedTranslate = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private static String EncodedReflector1 = "EJMZALYXVBWFCRQUONTSPIKHGD";
//	private static String EncodedReflector2 = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
//	private static String EncodedReflector3 = "FVPJIAOYEDRZXWGCTKUQSBNMHL";

	private static int index, ascii; 
	private static int tempNumHold, testNum, selectedRotor1, selectedRotor2, selectedRotor3;
	private static char tempCharHold;
	private static char pressedKey, encodedKey;

	private static char[][] RotorSlot1 = new char[2][26];
	private static char[][] RotorSlot2 = new char[2][26];
	private static char[][] RotorSlot3 = new char[2][26];
	private static char[][] Reflector = new char[2][26];
	
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
		
		for(index = 0; index < 26; index++) {
			Reflector[0][index] = EncodedTranslate.charAt(index);
			Reflector[1][index] = EncodedReflector1.charAt(index);
		}
		
		gui.GUI(kHandler, r1Handler, r2Handler, r3Handler, p1Handler, p2Handler, p3Handler);
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
		}
		else if (rotorSelect == 2) {
			for(index = 0; index < 26; index++) {
				RotorSlot1[0][index] = EncodedTranslate.charAt(index);
				RotorSlot1[1][index] = Rotors.Rotor2.ReturnCharAt(index);
			}
		}
		else if (rotorSelect == 3) {
			for(index = 0; index < 26; index++) {
				RotorSlot1[0][index] = EncodedTranslate.charAt(index);
				RotorSlot1[1][index] = Rotors.Rotor3.ReturnCharAt(index);
			}
		}
		else if (rotorSelect == 4) {
			for(index = 0; index < 26; index++) {
				RotorSlot1[0][index] = EncodedTranslate.charAt(index);
				RotorSlot1[1][index] = Rotors.Rotor4.ReturnCharAt(index);
			}
		}
		else if (rotorSelect == 5) {
			for(index = 0; index < 26; index++) {
				RotorSlot1[0][index] = EncodedTranslate.charAt(index);
				RotorSlot1[1][index] = Rotors.Rotor5.ReturnCharAt(index);
			}
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
		}
		else if (rotorSelect == 2) {
			for(index = 0; index < 26; index++) {
				RotorSlot2[0][index] = EncodedTranslate.charAt(index);
				RotorSlot2[1][index] = Rotors.Rotor2.ReturnCharAt(index);
			}
		}
		else if (rotorSelect == 3) {
			for(index = 0; index < 26; index++) {
				RotorSlot2[0][index] = EncodedTranslate.charAt(index);
				RotorSlot2[1][index] = Rotors.Rotor3.ReturnCharAt(index);
			}
		}
		else if (rotorSelect == 4) {
			for(index = 0; index < 26; index++) {
				RotorSlot2[0][index] = EncodedTranslate.charAt(index);
				RotorSlot2[1][index] = Rotors.Rotor4.ReturnCharAt(index);
			}
		}
		else if (rotorSelect == 5) {
			for(index = 0; index < 26; index++) {
				RotorSlot2[0][index] = EncodedTranslate.charAt(index);
				RotorSlot2[1][index] = Rotors.Rotor5.ReturnCharAt(index);
			}
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
		}
		else if (rotorSelect == 2) {
			for(index = 0; index < 26; index++) {
				RotorSlot3[0][index] = EncodedTranslate.charAt(index);
				RotorSlot3[1][index] = Rotors.Rotor2.ReturnCharAt(index);
			}
		}
		else if (rotorSelect == 3) {
			for(index = 0; index < 26; index++) {
				RotorSlot3[0][index] = EncodedTranslate.charAt(index);
				RotorSlot3[1][index] = Rotors.Rotor3.ReturnCharAt(index);
			}
		}
		else if (rotorSelect == 4) {
			for(index = 0; index < 26; index++) {
				RotorSlot3[0][index] = EncodedTranslate.charAt(index);
				RotorSlot3[1][index] = Rotors.Rotor4.ReturnCharAt(index);
			}
		}
		else if (rotorSelect == 5) {
			for(index = 0; index < 26; index++) {
				RotorSlot3[0][index] = EncodedTranslate.charAt(index);
				RotorSlot3[1][index] = Rotors.Rotor5.ReturnCharAt(index);
			}
		}
		else {
			System.out.println("Invalid rotorSelect available");
		}
		
		return;
	}
	
	
	//end of Set Rotors sector
	
  /*************************************************************************************************************************************************************/
	
	
	public void PositionSet(int rotorSlotRotate, int selectedRotor, int setPosition) {
		int rotate = 0;
		
		//*********Set Rotor1 Position*******************//
		if (rotorSlotRotate == 1) {
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
		if (rotorSlotRotate == 2) {
			for (rotate = 0; rotate < setPosition-1; rotate++) {
				for(testNum = 0; testNum <=1; testNum++) {
					tempCharHold = RotorSlot2[testNum][0];
				
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
		if (rotorSlotRotate == 3) {
			for (rotate = 0; rotate < setPosition-1; rotate++) {
				for(testNum = 0; testNum <=1; testNum++) {
					tempCharHold = RotorSlot3[testNum][0];
				
					for(index = 1; index <= 25; index++) {
						RotorSlot3[testNum][index-1] = RotorSlot3[testNum][index];
					}
					RotorSlot3[testNum][index-1] = tempCharHold;
				}
			}
			Rotor3Pos = setPosition;
		}
		else{};
		
		System.out.println();
		
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
		
		dManager.updateRotors();
		
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
	
	public static char SendRotor1Pos() {
		return RotorSlot1[1][0];
	}
	
	public static char SendRotor2Pos() {
		return RotorSlot2[1][0];
	}

	public static char SendRotor3Pos() {
		return RotorSlot3[1][0];
	}

	
	  /*************************************************************************************************************************************************************/
	
	 /************************** Handles rotor selection *************************************/
	
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
						gui.comboBoxRotorSelect2.removeItem("I");
						gui.comboBoxRotorSelect3.removeItem("I");
						EnigmaMachine.SetRotor1(1);
						gui.comboBoxRotorSelect1.setVisible(false);
						gui.comboBoxRotor1Display.setText("I");
						gui.comboBoxRotor1Display.setVisible(true);
						break;
						
					case "II":
						selectedRotor1 = 2;
						gui.comboBoxRotorSelect2.removeItem("II");
						gui.comboBoxRotorSelect3.removeItem("II");
						EnigmaMachine.SetRotor1(2);
						gui.comboBoxRotorSelect1.setVisible(false);
						gui.comboBoxRotor1Display.setText("II");
						gui.comboBoxRotor1Display.setVisible(true);
						break;
						
					case "III":
						selectedRotor1 = 3;
						gui.comboBoxRotorSelect2.removeItem("III");
						gui.comboBoxRotorSelect3.removeItem("III");
						EnigmaMachine.SetRotor1(3);
						gui.comboBoxRotorSelect1.setVisible(false);
						gui.comboBoxRotor1Display.setText("III");
						gui.comboBoxRotor1Display.setVisible(true);
						break;
						
					case "IV":
						selectedRotor1 = 4;
						gui.comboBoxRotorSelect2.removeItem("IV");
						gui.comboBoxRotorSelect3.removeItem("IV");
						EnigmaMachine.SetRotor1(4);
						gui.comboBoxRotorSelect1.setVisible(false);
						gui.comboBoxRotor1Display.setText("IV");
						gui.comboBoxRotor1Display.setVisible(true);
						break;
						
					case "V":
						selectedRotor1 = 5;
						gui.comboBoxRotorSelect2.removeItem("V");
						gui.comboBoxRotorSelect3.removeItem("V");
						EnigmaMachine.SetRotor1(5);
						gui.comboBoxRotorSelect1.setVisible(false);
						gui.comboBoxRotor1Display.setText("V");
						gui.comboBoxRotor1Display.setVisible(true);
						break;
					
					case "\0":
						break;
						
					default:
						System.out.println("RSlot1 Error");	
				}
				
				for (int index = 0; index < 26; index++) {
					gui.RotorPos1.insertItemAt(RotorSlot1[1][index], index);
				}
				gui.RotorPos1.setVisible(true);
			}
		} //end of class RotorHandler
		
		public class RSlot2Handler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String r2 = e.getSource().toString();
				r2 = RotorActionSubString.makeSubStr(r2);
				switch (r2) {
				
					case "I":
						selectedRotor2 = 1;
						gui.comboBoxRotorSelect1.removeItem("I");
						gui.comboBoxRotorSelect3.removeItem("I");
						EnigmaMachine.SetRotor2(1);
						gui.comboBoxRotorSelect2.setVisible(false);
						gui.comboBoxRotor2Display.setText("I");
						gui.comboBoxRotor2Display.setVisible(true);
						break;
						
					case "II":
						selectedRotor2 = 2;
						gui.comboBoxRotorSelect1.removeItem("II");
						gui.comboBoxRotorSelect3.removeItem("II");
						EnigmaMachine.SetRotor2(2);
						gui.comboBoxRotorSelect2.setVisible(false);
						gui.comboBoxRotor2Display.setText("II");
						gui.comboBoxRotor2Display.setVisible(true);
						break;
						
					case "III":
						selectedRotor2 = 3;
						gui.comboBoxRotorSelect1.removeItem("III");
						gui.comboBoxRotorSelect3.removeItem("III");
						EnigmaMachine.SetRotor2(3);
						gui.comboBoxRotorSelect2.setVisible(false);
						gui.comboBoxRotor2Display.setText("III");
						gui.comboBoxRotor2Display.setVisible(true);
						break;
						
					case "IV":
						selectedRotor2 = 4;
						gui.comboBoxRotorSelect1.removeItem("IV");
						gui.comboBoxRotorSelect3.removeItem("IV");
						EnigmaMachine.SetRotor2(4);
						gui.comboBoxRotorSelect2.setVisible(false);
						gui.comboBoxRotor2Display.setText("IV");
						gui.comboBoxRotor2Display.setVisible(true);
						break;
						
					case "V":
						selectedRotor2 = 5;
						gui.comboBoxRotorSelect1.removeItem("V");
						gui.comboBoxRotorSelect3.removeItem("V");
						EnigmaMachine.SetRotor2(5);
						gui.comboBoxRotorSelect2.setVisible(false);
						gui.comboBoxRotor2Display.setText("V");
						gui.comboBoxRotor2Display.setVisible(true);
						break;
						
					case "\0":
						break;
						
					default:
						System.out.println("RSlot2 Error");	
				}
				
				for (int index = 0; index < 26; index++) {
					gui.RotorPos2.insertItemAt(RotorSlot2[1][index], index);
				}
				gui.RotorPos2.setVisible(true);
			}
		} //end of class RotorHandler
		
		public class RSlot3Handler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String r3 = e.getSource().toString();
				r3 = RotorActionSubString.makeSubStr(r3);
				switch (r3) {
				
					case "I":
						selectedRotor3 = 1;
						gui.comboBoxRotorSelect1.removeItem("I");
						gui.comboBoxRotorSelect2.removeItem("I");
						EnigmaMachine.SetRotor3(1);
						gui.comboBoxRotorSelect3.setVisible(false);
						gui.comboBoxRotor3Display.setText("I");
						gui.comboBoxRotor3Display.setVisible(true);
						break;
						
					case "II":
						selectedRotor3 = 2;
						gui.comboBoxRotorSelect1.removeItem("II");
						gui.comboBoxRotorSelect2.removeItem("II");
						EnigmaMachine.SetRotor3(2);
						gui.comboBoxRotorSelect3.setVisible(false);
						gui.comboBoxRotor3Display.setText("II");
						gui.comboBoxRotor3Display.setVisible(true);
						break;
						
					case "III":
						selectedRotor3 = 3;
						gui.comboBoxRotorSelect1.removeItem("III");
						gui.comboBoxRotorSelect2.removeItem("III");
						EnigmaMachine.SetRotor3(3);
						gui.comboBoxRotorSelect3.setVisible(false);
						gui.comboBoxRotor3Display.setText("III");
						gui.comboBoxRotor3Display.setVisible(true);
						break;
						
					case "IV":
						selectedRotor3 = 4;
						gui.comboBoxRotorSelect1.removeItem("IV");
						gui.comboBoxRotorSelect2.removeItem("IV");
						EnigmaMachine.SetRotor3(4);
						gui.comboBoxRotorSelect3.setVisible(false);
						gui.comboBoxRotor3Display.setText("IV");
						gui.comboBoxRotor3Display.setVisible(true);
						break;
						
					case "V":
						selectedRotor3 = 5;
						gui.comboBoxRotorSelect1.removeItem("V");
						gui.comboBoxRotorSelect2.removeItem("V");
						EnigmaMachine.SetRotor3(5);
						gui.comboBoxRotorSelect3.setVisible(false);
						gui.comboBoxRotor3Display.setText("V");
						gui.comboBoxRotor3Display.setVisible(true);
						break;
						
					case "\0":
						break;
						
					default:
						System.out.println("RSlot3 Error");	
				}
				
				for (int index = 0; index < 26; index++) {
					gui.RotorPos3.insertItemAt(RotorSlot3[1][index], index);
				}
				gui.RotorPos3.setVisible(true);
			}
		} //end of class RotorHandler
		
		
		/*************************************************************************************************************************************************************/
		
		/************************** Handles rotor positions *************************************/
		
		public class R1PosHandler implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				String rp1 = e.getSource().toString();
				rp1 = RotorActionSubString.makeSubStr(rp1);
				char setChar = rp1.charAt(0);
				
				gui.RotorPos1.setVisible(false);
				gui.SetRotorPos1.setVisible(true);
				gui.SetRotorPos1.setText(String.valueOf(setChar));
				
				int search = 0;
				while (RotorSlot1[1][search] != setChar) {
					search++;
				}
				search++;
				PositionSet(1, selectedRotor1, search);
			}
			
		}
		
		public class R2PosHandler implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				String rp2 = e.getSource().toString();
				rp2 = RotorActionSubString.makeSubStr(rp2);
				char setChar = rp2.charAt(0);
				
				gui.RotorPos2.setVisible(false);
				gui.SetRotorPos2.setVisible(true);
				gui.SetRotorPos2.setText(String.valueOf(setChar));
				
				int search = 0;
				while (RotorSlot2[1][search] != setChar) {
					search++;
				}
				search++;
				PositionSet(2, selectedRotor2, search);
			}
			
		}
		
		public class R3PosHandler implements ActionListener{


			public void actionPerformed(ActionEvent e) {
				String rp3 = e.getSource().toString();
				rp3 = RotorActionSubString.makeSubStr(rp3);
				char setChar = rp3.charAt(0);
				
				gui.RotorPos3.setVisible(false);
				gui.SetRotorPos3.setVisible(true);
				gui.SetRotorPos3.setText(String.valueOf(setChar));
				
				int search = 0;
				while (RotorSlot3[1][search] != setChar) {
					search++;
				}
				search++;
				PositionSet(3, selectedRotor3, search);
			}
			
		}
		
		
		/*************************************************************************************************************************************************************/
		
		public static class RotorActionSubString {
			
			public static String makeSubStr(String e) {
				
				int subStrStart = e.lastIndexOf("selectedItemReminder=") + 21;
				int subStrEnd = e.indexOf(']', subStrStart);
				e = e.substring(subStrStart, subStrEnd);
				
				return e;
			}
			
		}
	
	
} //end of class EnigmaMachine













