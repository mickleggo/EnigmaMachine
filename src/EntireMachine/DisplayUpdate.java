package EntireMachine;

public class DisplayUpdate {
	
	private EnigmaGUI gui;

	public DisplayUpdate(EnigmaGUI UI) {
		gui = UI;
	}
	
	
	public void updateDisplay() {
		
		String userInput = EnigmaMachine.SendUserInput();
		gui.textMessageDisplay.setText(userInput);
		
	}
	
	public void updateRotors() {
		
		char rot1Pos = EnigmaMachine.SendRotor1Pos();
		char rot2Pos = EnigmaMachine.SendRotor2Pos();
		char rot3Pos = EnigmaMachine.SendRotor3Pos();
		
		gui.SetRotorPos1.setText(String.valueOf(rot1Pos));
		gui.SetRotorPos2.setText(String.valueOf(rot2Pos));
		gui.SetRotorPos3.setText(String.valueOf(rot3Pos));

		
	}
	
}
