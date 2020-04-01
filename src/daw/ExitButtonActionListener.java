package daw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// exit the program
public class ExitButtonActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
