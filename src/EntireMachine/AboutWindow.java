package EntireMachine;
import javax.swing.*;

public class AboutWindow {
	
	JFrame aFrame;
	JLabel message;
	String details;
	
	public void About() {
		
		details = "Version 1.0\n\n\n"
				+ "Enigma Machine.\n"
				+ "Software implementation of a mechanical device. Mostly interesting.\n" 
				+ "    Copyright (C) 2021  Michael legg\n\n\n" 
				+ " 		This program is free software: you can redistribute it and/or modify\n" 
				+ " it under the terms of the GNU General Public License as published by\n"  
				+ " the Free Software Foundation, either version 3 of the License\n\n" 
				+ " 		This program is distributed in the hope that it will be useful,\n" 
				+ " but WITHOUT ANY WARRANTY; without even the implied warranty of\n"  
				+ " MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n" 
				+ " GNU General Public License for more details.\n\n"  
				+ "    You can view the GNU General Public License at\n" 
				+ " https://www.gnu.org/licenses/.";
		
		aFrame = new JFrame("About");
		aFrame.setBounds(700, 180, 450, 400);
		aFrame.setResizable(false);
		aFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		aFrame.getContentPane().setLayout(null);
		aFrame.setAlwaysOnTop(true);
		
		message = new JLabel("<html>" + details.replaceAll("\n", "<BR>"));
		message.setBounds(25, 15, 400, 350);
		message.setVerticalAlignment(JLabel.TOP);
		aFrame.getContentPane().add(message);
		
		aFrame.setVisible(true);
		
	}

}
