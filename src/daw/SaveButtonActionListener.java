package daw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;

import javax.swing.JOptionPane;

// saves the track data
public class SaveButtonActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = JOptionPane.showInputDialog(TextData.SAVE_DIALOG_MSG);
		if(s == null) return; // canceled
		TrackModel Track = new TrackModel();
		Track.TrackName = s;
		Track.TrackTempo = Main.TempoBPM;
		TrackFileManagement File = new TrackFileManagement(Track);
		for(int i = 0; i < StaticData.MAX_CHANNELS; i++) {
			if(Main.Channels.get(i) != null && Main.Channels.get(i).IsEnabled()) { // don't save the channel if it's disabled
				Main.Channels.get(i).SetArrangement(Home.GetChannelArrangement(i)); // to set the arrangement value in the channel class
				Track.ChannelData[i] = Main.Channels.get(i);
			}
			Home.SetInfoText("Track " + s + " has been successfully saved");
		}
		try {
			File.save(s);
		} catch (FileNotFoundException | FileSystemException e1) {
			Message.Error("There has been an error with saving the track data, please check the name of your track. ","File error!");
		}

	}
}
