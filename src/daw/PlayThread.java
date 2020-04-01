package daw;

public class PlayThread implements Runnable {

	/* Calculation: (60.000 / TempoBPM = one beat in milliseconds) / 2 */
	@Override
	public void run() {
		loop:
		while(true) {
				for(int j = 0; j < StaticData.MAX_BARS; j++) {
					for(int i = 0; i < StaticData.MAX_CHANNELS; i++) {
						Home.SetActiveBar(i, j, true);
						boolean[] arrangement = Home.GetChannelArrangement(i); // get the arrangement every cycle in case it may have been changed
						if(arrangement != null && Main.Channels.get(i) != null && Main.Channels.get(i).HasLoad() && arrangement[j]) {
							new Thread(Main.Channels.get(i)).start(); // play the sound
						}
					}					
					try {				
						Thread.sleep(60000 / Main.TempoBPM / 2); // wait between bars according to the tempo setting
					} catch (InterruptedException e) {
						break loop;
					}
					for(int i = 0; i < StaticData.MAX_CHANNELS; i++)
							Home.SetActiveBar(i, j, false);
				}
		}
	}

}
