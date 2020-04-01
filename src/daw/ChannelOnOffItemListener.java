package daw;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChannelOnOffItemListener implements ItemListener {

	private int channelID;

	public ChannelOnOffItemListener(int channelID) {
		this.channelID = channelID;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Home.SetEnableChannel(channelID, e.getStateChange() == ItemEvent.SELECTED);
		Main.Channels.get(channelID).SetEnabled(e.getStateChange() == ItemEvent.SELECTED);
		Home.SetInfoText("Channel " + channelID + " is " + ((e.getStateChange() == ItemEvent.SELECTED) ? "enabled" : "disabled"));
	}
}