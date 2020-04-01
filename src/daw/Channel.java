package daw;

import java.io.File;
import java.io.Serializable;

public class Channel implements Runnable, Serializable {
	/**
	 * generated serial version
	 */
	private static final long serialVersionUID = -4778617562151715246L;
	private boolean load; // whether sample file is loaded to the channel
	private File sample; // loaded sample file
	private boolean enabled;
	private boolean[] arrangement;
	private int delay;
	public Channel(int channelID) {
		//System.out.println("channel " + channelID + " created");
		this.delay = 0;
		this.load = false;
		this.enabled = false;
		this.arrangement = new boolean[StaticData.MAX_BARS];
	}
	
	@Override
	public void run() { // play the loaded sample, once
		new Sound(sample).play();

		if(delay != 0) {		
			try {
				Thread.sleep((60000 / Main.TempoBPM) / delay);
			} catch (InterruptedException e) {
				// stop playing
			}
			 new Sound(sample).play();
		}
	}

	public final boolean HasLoad() {
		return this.load;
	}
	public final boolean IsEnabled() {
		return enabled;
	}
	public final void SetEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public final void SetDelay(int delay) {
		this.delay = delay;
	}
	public final void SetArrangement(boolean[] arrangement) {
		for(int i = 0; i < StaticData.MAX_BARS; i++)
			this.arrangement[i] = arrangement[i];
	}
	public final boolean[] GetArrangement() {
		return this.arrangement;
	}
	public final void SetSampleFile(File file) {
		if(file != null && file.exists())
			this.sample = file;
		this.load = true;
	}
}
