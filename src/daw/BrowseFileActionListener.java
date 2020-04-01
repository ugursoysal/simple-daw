package daw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class BrowseFileActionListener implements ActionListener {
	int channelID;

	public BrowseFileActionListener(int channelID) {
		this.channelID = channelID;
	}

	public void actionPerformed(ActionEvent e) {
		new Thread(new Runnable() {
			public void run() {
		//System.out.println("File browser for channel " + channelID);
		try {
			if (Main.Channels.get(channelID) != null) { // check if the channel is enabled
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				Home.SetInfoText("File browser has opened.");
				int returnValue = jfc.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					//System.out.println(selectedFile.getAbsolutePath());
					String[] split = selectedFile.getName().split("\\.");
					//for(int i = 0; i < split.length; i ++) System.out.println(split[i]);
					if (split == null || split.length < 2 && split[split.length - 1] != "wav") {
						Message.Error("This application is configured to support WAV files only.",
								"Unknown File Format");
					}
					Main.Channels.get(channelID).SetSampleFile(selectedFile);
					Home.SetInfoText("Sample file " + selectedFile.getName() + " has loaded to channel " + channelID);
					//System.out.println(selectedFile.getAbsolutePath());
				}
			}else{
				Message.Error("Channel is not enabled.", "Channel Error");
			}
		} catch (Exception x) {
			Message.Error("There is a problem with the file browser.\n\nLogs:\n\n" + x.getStackTrace(),
					"File Browser Error");
			x.printStackTrace();
		}
		}
		}).start(); // start a new thread because audio synchronization is lost without it
	}
}
