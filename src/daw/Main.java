package daw;

import java.util.ArrayList;

public class Main {
	public static ArrayList<Channel> Channels = new ArrayList<Channel>(StaticData.MAX_CHANNELS);
	public static int TempoBPM = 120; // Beats Per Minute
	public static boolean Playing = false;
	public static Thread GuiThread = null;
	public static Thread DelayFrameThread = null;

	public static void CreateGui() {
		if(GuiThread != null)
			GuiThread.interrupt();
		Playing = false;
		for (int i = 0; i < StaticData.MAX_CHANNELS; i++)
			Channels.add(i, new Channel(i));
		GuiThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Home Home = new Home();
				Home.pack();
				Home.setVisible(true);
			}
		});
		GuiThread.start();
	}

	public static void main(String[] args) throws InterruptedException {
		CreateGui();
	}
}