package daw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

// clears the arrangement check boxes
public class ClearButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (JOptionPane.showConfirmDialog(null, 
	    		"Do you really want to clear the arrangement?",
	    		"Continue?",
	            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	    	for(int i = 0; i < StaticData.MAX_CHANNELS; i++)
	    			Home.SetChannelArrangement(i, new boolean[8]);
		Home.SetInfoText("Arrangement has been cleared.");
	}

}
