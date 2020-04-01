package daw;

import java.io.Serializable;

public class TrackModel implements Serializable {

	/**
	 * generated serial version
	 */
	private static final long serialVersionUID = -7709277038286664500L;
	public String TrackName;
	public int TrackTempo;
	public Channel[] ChannelData = new Channel[StaticData.MAX_CHANNELS];
}
