package daw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

// loads the track data
public class LoadButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Main.Playing) {
			Message.Error("Please stop the current arrangement first.", "Error");
		} else {
			String s = JOptionPane.showInputDialog(TextData.LOAD_DIALOG_MSG);
			if(s == null) return; // canceled
			TrackFileManagement File = new TrackFileManagement(s);
			if(File.Track == null)
				Message.Error("There has been an error while loading the track data.", "File error!");
			else {
				TrackModel NewTrack = File.Track;
				Main.TempoBPM = NewTrack.TrackTempo;
				for(int i = 0; i < StaticData.MAX_CHANNELS; i++)
				{
					if(NewTrack.ChannelData[i] != null)
						Main.Channels.set(i, NewTrack.ChannelData[i]);
					if(File.Track.ChannelData[i] != null && File.Track.ChannelData[i].IsEnabled()) {
						Home.SetEnableChannel(i, File.Track.ChannelData[i].IsEnabled());
						Home.SetChannelArrangement(i, File.Track.ChannelData[i].GetArrangement());
					}else {
						Home.SetEnableChannel(i, false);
					}
				}
				Home.SetInfoText("Track " + s + " has been successfully loaded");
			}
		}
	}

}
