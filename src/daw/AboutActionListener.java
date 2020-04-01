package daw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Message.Info(TextData.ABOUT_MSG, TextData.ABOUT);
	}
}
