package daw;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystemException;

// save and read track file
public class TrackFileManagement extends TrackModel {

	/**
	 * generated serial version
	 */
	private static final long serialVersionUID = 3195144187168638113L;

	public TrackModel Track;
	public TrackFileManagement(TrackModel Model) {
		this.Track = Model;
	}
	public TrackFileManagement(String filename) {
		try {
			this.Track = load(filename);
		} catch (FileNotFoundException e) {
			this.Track = null;
		}
	}
	public void printrack() {
		System.out.println(" --> " + Track.TrackName + " | " + Track.TrackTempo);
		for(int i = 0; i < StaticData.MAX_CHANNELS; i++)
			if(Track.ChannelData[i] != null) {
				System.out.println("\nchannel " + i + ": " + Track.ChannelData[i].IsEnabled() + " arrangement: ");
				for(int j = 0; j < StaticData.MAX_BARS; j++)
					System.out.print(" " + Track.ChannelData[i].GetArrangement()[j]);
			}
	}
	public void save(String filename) throws FileNotFoundException, FileSystemException {
		FileOutputStream fos = null;

		ObjectOutputStream oos = null;
		try {

		fos = new FileOutputStream(filename);
		
		oos = new ObjectOutputStream(fos);
		
		oos.writeObject(Track);
		printrack();
		System.out.println("Serialized data is saved in " + filename);
		
		oos.close();
		
		fos.close();
		
		} catch (IOException e) {
		
		e.printStackTrace();
		
		} 
	}
	public TrackModel load(String filename) throws FileNotFoundException {
		FileInputStream fis = null;

		ObjectInputStream ois = null;
		try {

		fis = new FileInputStream(filename);
		
		ois = new ObjectInputStream(fis);
		
		Track = (TrackModel)ois.readObject();
		printrack();
				
		ois.close();
		
		fis.close();
		
		} catch (Exception e) {
		
		e.printStackTrace();
		
		} 
		return Track;
	}

}
