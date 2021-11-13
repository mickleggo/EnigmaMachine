package EntireMachine;

public class DisplayUpdate {
	
	private EnigmaGUI gui;

	public DisplayUpdate(EnigmaGUI UI) {
		gui = UI;
	}
	
	
	public void updateDisplay() {
		
		String userInput = EnigmaMachine.SendUserInput();
		gui.textMessageDisplay.setText(userInput);
		
		int Rotor1Pos = EnigmaMachine.SendRotor1Pos();
		int Rotor2Pos = EnigmaMachine.SendRotor2Pos();
		int Rotor3Pos = EnigmaMachine.SendRotor3Pos();
		gui.textRotorPos1.setText("" + Rotor1Pos);
		gui.textRotorPos2.setText("" + Rotor2Pos);
		gui.textRotorPos3.setText("" + Rotor3Pos);
		
	}
	
//	public void updateRotorSelection() {
//		
//		String[] displayRotors = new String[5];
//		String passStr = "\0";
//		int dRotorLength = 0;
//		
//		for (int index = 0; index < 5; index++) {
//			try {
//				passStr = EnigmaMachine.availableRotor(index);
//			}
//			catch (Exception e){
//				System.out.println("catch error in DisplayUpdate.updateRotorSelection()");
//			}
//			
//			if (passStr == "false") {	
//			}
//			else {
//				displayRotors[dRotorLength] = passStr; 
//				dRotorLength++;
//			}
//			
//		}
//		
//	}
	
}
