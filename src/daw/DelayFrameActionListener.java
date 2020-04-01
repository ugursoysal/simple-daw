package daw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelayFrameActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Main.DelayFrameThread != null)
			Main.DelayFrameThread.interrupt();
		Main.DelayFrameThread = new Thread(new Runnable() {
			@Override
			public void run() {
				DelaySettings Frame = new DelaySettings();
				Frame.pack();
				Frame.setVisible(true);
			}
		});
		Main.DelayFrameThread.start();
		
	}

}
