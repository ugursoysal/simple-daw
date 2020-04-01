package daw;

import javax.swing.JOptionPane;

public class Message {
	public static void Error(String errMsg, String caption) {
		JOptionPane.showMessageDialog(null, errMsg, caption, JOptionPane.ERROR_MESSAGE);
		Home.SetInfoText("Error occured");
	}

	public static void Info(String errMsg, String caption) {
		JOptionPane.showMessageDialog(null, errMsg, caption, JOptionPane.INFORMATION_MESSAGE);
	}
}
