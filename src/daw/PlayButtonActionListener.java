package daw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButtonActionListener implements ActionListener {
	public static Thread CurrentSession = null;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(CurrentSession == null) {
			CurrentSession = new Thread(new PlayThread());
			CurrentSession.start();
			Home.SetInfoText("Playing");
		} else {
			Home.SetInfoText("Already playing");
		}
	}

}
