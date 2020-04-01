package daw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(PlayButtonActionListener.CurrentSession != null)
		{
			PlayButtonActionListener.CurrentSession.interrupt();
			PlayButtonActionListener.CurrentSession = null;
			Home.SetInfoText("Stopped");	
		}
	}
}