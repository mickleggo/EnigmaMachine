package EntireMachine;
import java.awt.*;
import javax.swing.*;
import EntireMachine.EnigmaMachine.ButtonHandler;
import EntireMachine.EnigmaMachine.KeyPressHandler;
import EntireMachine.EnigmaMachine.MenuHandler;
import EntireMachine.EnigmaMachine.R1PosHandler;
import EntireMachine.EnigmaMachine.R2PosHandler;
import EntireMachine.EnigmaMachine.R3PosHandler;
import EntireMachine.EnigmaMachine.RSlot1Handler;
import EntireMachine.EnigmaMachine.RSlot2Handler;
import EntireMachine.EnigmaMachine.RSlot3Handler;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class EnigmaGUI {

	JFrame frame;
	JMenu menuAbout;
	JMenuBar menuBar;
	JButton btnTypeControl, btnClear, btnPrintText;
	JTextPane textMessageDisplay;
	JComboBox RotorPos1, RotorPos2, RotorPos3;
	JLabel SetRotorPos1, SetRotorPos2, SetRotorPos3;
	JLabel lblRotors, lblRotorPosition;
	JLabel comboBoxRotor1Display, comboBoxRotor2Display, comboBoxRotor3Display;
	JComboBox comboBoxRotorSelect1, comboBoxRotorSelect2, comboBoxRotorSelect3;
	
	private static String[] possibleRotors = { String.valueOf('\0'),"I", "II", "III", "IV", "V" };
	

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void GUI(KeyPressHandler kHandler, RSlot1Handler r1Handler, RSlot2Handler r2Handler, RSlot3Handler r3Handler, R1PosHandler p1Handler,
											 R2PosHandler p2Handler, R3PosHandler p3Handler, MenuHandler mHandler, ButtonHandler bHandler) {

		
		frame = new JFrame("Enigma Machine");
		frame.setBounds(900, 200, 450, 425);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textMessageDisplay = new JTextPane();
		textMessageDisplay.setBounds(25, 150, 385, 200);
		frame.getContentPane().add(textMessageDisplay);
		
		menuBar = new JMenuBar();
		
		menuAbout = new JMenu("About");
		menuAbout.addMenuListener(mHandler);
		menuBar.add(menuAbout);
		
		frame.setJMenuBar(menuBar);
		
		
		//***********Add Buttons***********************//
		
		btnTypeControl = new JButton("Select to Type");
		btnTypeControl.setBounds(160, 116, 120, 23);
		btnTypeControl.addKeyListener(kHandler);
		frame.getContentPane().add(btnTypeControl);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(25, 116, 110, 23);
		btnClear.addActionListener(bHandler);
		frame.getContentPane().add(btnClear);
		
		btnPrintText = new JButton("Print to Text");
		btnPrintText.setBounds(305, 116, 110, 23);
		btnPrintText.addActionListener(bHandler);
		frame.getContentPane().add(btnPrintText);
		
		
		
		//***********Rotor Position Select and Display***********************//
		RotorPos1 = new JComboBox();
		RotorPos1.setBounds(275, 75, 50, 25);
		RotorPos1.addActionListener(p1Handler);
		frame.getContentPane().add(RotorPos1);
		RotorPos1.setVisible(false);
		
		RotorPos2 = new JComboBox();
		RotorPos2.setBounds(200, 75, 50, 25);
		RotorPos2.addActionListener(p2Handler);
		frame.getContentPane().add(RotorPos2);
		RotorPos2.setVisible(false);
		
		RotorPos3 = new JComboBox();
		RotorPos3.setBounds(125, 75, 50, 25);
		RotorPos3.addActionListener(p3Handler);
		frame.getContentPane().add(RotorPos3);
		RotorPos3.setVisible(false);
		
		
		SetRotorPos1 = new JLabel("", SwingConstants.CENTER);
		SetRotorPos1.setBounds(275, 75, 50, 25);
		SetRotorPos1.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(SetRotorPos1);
		SetRotorPos1.setVisible(false);
		
		SetRotorPos2 = new JLabel("", SwingConstants.CENTER);
		SetRotorPos2.setBounds(200, 75, 50, 25);
		SetRotorPos2.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(SetRotorPos2);
		SetRotorPos2.setVisible(false);
		
		SetRotorPos3 = new JLabel("", SwingConstants.CENTER);
		SetRotorPos3.setBounds(125, 75, 50, 25);
		SetRotorPos3.setFont(new Font("Tahoma", Font.BOLD, 12));
		frame.getContentPane().add(SetRotorPos3);
		SetRotorPos3.setVisible(false);
		
		
		
		
		//***********Label Boxes********************************************//
		lblRotors = new JLabel("Rotors");
		lblRotors.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRotors.setBounds(204, 10, 46, 14);
		frame.getContentPane().add(lblRotors);
		
		lblRotorPosition = new JLabel("Position");
		lblRotorPosition.setFont(lblRotorPosition.getFont().deriveFont(lblRotorPosition.getFont().getStyle() | Font.BOLD));
		lblRotorPosition.setBounds(200, 60, 46, 14);
		frame.getContentPane().add(lblRotorPosition);
		
		
		//***********Rotor Selection and Display***************************//
		comboBoxRotorSelect1 = new JComboBox(possibleRotors);
		comboBoxRotorSelect1.setBounds(275, 30, 50, 22);
		comboBoxRotorSelect1.addActionListener(r1Handler);
		frame.getContentPane().add(comboBoxRotorSelect1);
		
		comboBoxRotorSelect2 = new JComboBox(possibleRotors);
		comboBoxRotorSelect2.setBounds(200, 30, 50, 22);
		comboBoxRotorSelect2.addActionListener(r2Handler);
		frame.getContentPane().add(comboBoxRotorSelect2);
		
		comboBoxRotorSelect3 = new JComboBox(possibleRotors);
		comboBoxRotorSelect3.setBounds(125, 30, 50, 22);
		comboBoxRotorSelect3.addActionListener(r3Handler);
		frame.getContentPane().add(comboBoxRotorSelect3);
		
		comboBoxRotor1Display = new JLabel("", SwingConstants.CENTER);
		comboBoxRotor1Display.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxRotor1Display.setBounds(275, 30, 50, 22);
		frame.getContentPane().add(comboBoxRotor1Display);
		comboBoxRotor1Display.setVisible(false);
	
		comboBoxRotor2Display = new JLabel("", SwingConstants.CENTER);
		comboBoxRotor2Display.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxRotor2Display.setBounds(200, 30, 50, 22);
		frame.getContentPane().add(comboBoxRotor2Display);
		comboBoxRotor2Display.setVisible(false);
		
		comboBoxRotor3Display = new JLabel("", SwingConstants.CENTER);
		comboBoxRotor3Display.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxRotor3Display.setBounds(125, 30, 50, 22);
		frame.getContentPane().add(comboBoxRotor3Display);
		comboBoxRotor3Display.setVisible(false);
		

		frame.setVisible(true);

		return;
	}

	
}
