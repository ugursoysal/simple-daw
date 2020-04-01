package daw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class NewButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(Main.Playing)
			Message.Error("Please stop the playback before creating a new project.", "Error");
	    if (JOptionPane.showConfirmDialog(null, 
	    		"Do you really want to create a new project? All unsaved changes will be lost.",
	    		"Continue?",
	            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	    	Main.CreateGui();
		Home.SetInfoText("New project has been opened");
	}

}
