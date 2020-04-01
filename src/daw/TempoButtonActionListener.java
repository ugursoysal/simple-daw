package daw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

// change tempo of the track
public class TempoButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = JOptionPane.showInputDialog(TextData.TEMPO_DIALOG_MSG);
		if(s == null) return; // canceled
		if(!isNumeric(s))
			Message.Error("Tempo should be a numerical value.", "Error");
		Main.TempoBPM = Integer.valueOf(s);
		Home.SetInfoText("Tempo has been set to " + Main.TempoBPM);
	}
    public static boolean isNumeric(final String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}