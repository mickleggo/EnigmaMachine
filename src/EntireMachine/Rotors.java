package EntireMachine;

public class Rotors {
	
	private Rotor1 R1 = new Rotor1();
	private Rotor2 R2 = new Rotor2();
	private Rotor3 R3 = new Rotor3();
	private Rotor4 R4 = new Rotor4();
	private Rotor5 R5 = new Rotor5();
	
	/*************************************************************************************************************************************************************/
	
	public static class Rotor1 {

		private static String EncodedRotor1 = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
	
		public static char ReturnCharAt(int index) {
			return EncodedRotor1.charAt(index);
		}
		
	}
	
	/*************************************************************************************************************************************************************/

	public static class Rotor2 {

		private static String EncodedRotor2 = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
	
		public static char ReturnCharAt(int index) {
			return EncodedRotor2.charAt(index);
		}
	
	}
	
	/*************************************************************************************************************************************************************/
	
	public static class Rotor3 {

		private static String EncodedRotor3 = "BDFHJLCPRTXVZNYEIWGAKMUSQO";

		public static char ReturnCharAt(int index) {
			return EncodedRotor3.charAt(index);
		}

	}
	
	/*************************************************************************************************************************************************************/
	
	public static class Rotor4 {

		private static String EncodedRotor4 = "ESOVPZJAYQUIRHXLNFTGKDCMWB";

		public static char ReturnCharAt(int index) {
			return EncodedRotor4.charAt(index);
		}

	}
	
	/*************************************************************************************************************************************************************/
	
	public static class Rotor5 {

		private static String EncodedRotor5 = "VZBRGITYUPSDNHLXAWMJQOFECK";

		public static char ReturnCharAt(int index) {
			return EncodedRotor5.charAt(index);
		}
		
	}
	
	/*************************************************************************************************************************************************************/

}