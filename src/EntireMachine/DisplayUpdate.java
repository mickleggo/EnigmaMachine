package EntireMachine;

public class DisplayUpdate {
	
	private EnigmaGUI gui;
	private static String[] possibleRotors = { String.valueOf('\0'),"I", "II", "III", "IV", "V" };

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
	
	@SuppressWarnings("unchecked")
	public void resetDisplay() {
		
		gui.textMessageDisplay.setText("");
		
		gui.SetRotorPos1.setVisible(false);
		gui.SetRotorPos2.setVisible(false);
		gui.SetRotorPos3.setVisible(false);
		
		gui.RotorPos1.setVisible(false);
		gui.RotorPos2.setVisible(false);
		gui.RotorPos3.setVisible(false);
		
		gui.comboBoxRotor1Display.setVisible(false);
		gui.comboBoxRotor2Display.setVisible(false);
		gui.comboBoxRotor3Display.setVisible(false);
		
		gui.comboBoxRotorSelect1.setVisible(true);
		gui.comboBoxRotorSelect2.setVisible(true);
		gui.comboBoxRotorSelect3.setVisible(true);
		
		
		gui.comboBoxRotorSelect1.removeAllItems();
		for (int index = 0; index < possibleRotors.length ; index++) {
			gui.comboBoxRotorSelect1.addItem(possibleRotors[index]);
		}
		
		
		gui.comboBoxRotorSelect2.removeAllItems();
		for (int index = 0; index < possibleRotors.length ; index++) {
			gui.comboBoxRotorSelect2.addItem(possibleRotors[index]);
		}
		
		
		gui.comboBoxRotorSelect3.removeAllItems();
		for (int index = 0; index < possibleRotors.length ; index++) {
			gui.comboBoxRotorSelect3.addItem(possibleRotors[index]);
		}
		
		
	}
	
}
