package EntireMachine;

public class Rotors {
	
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