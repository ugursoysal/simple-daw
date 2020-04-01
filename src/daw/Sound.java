package daw;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class Sound {
	private Clip clip;
	private final File File;

	public Sound(File file) {
		this.File = file;
	}

	public void play() { // load and play the clip (for once) and close when it's finished
		try {
			//System.out.println("DEBUG: play sound");
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(File);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.setFramePosition(0);
			clip.start();
			clip.addLineListener(new LineListener() {

				@Override
				public void update(LineEvent arg0) {
					if (arg0.getFramePosition() == clip.getFrameLength()) {
						clip.close();
					}
				}
			});
		} catch (Exception e) {
			Home.SetInfoText("There has been a problem with playing sample file " + File.getName());
			//e.printStackTrace();
		}
	}

	public void stop() { // stop the clip if it's playing
		try {
			if(clip.isRunning())
				clip.close();
		} catch (Exception e) {

		}
	}
}
