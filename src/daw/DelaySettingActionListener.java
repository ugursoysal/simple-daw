package daw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelaySettingActionListener implements ActionListener {

	private int channelID;
	public DelaySettingActionListener(int channelID) {
		this.channelID = channelID;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Main.DelayFrameThread != null)
			if(Main.Channels.get(channelID) != null && Main.Channels.get(channelID).IsEnabled()) {
				Main.Channels.get(channelID).SetDelay(DelaySettings.GetDelay(channelID));
			}
	}

}
