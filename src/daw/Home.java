package daw;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;

/*
 * Generated in WindowsBuilder ( GUI Builder for Java Swing )
 * */
public class Home extends JFrame {

	private static JButton btnBrowse[] = new JButton[StaticData.MAX_CHANNELS];
	private static JCheckBox checkBox[][] = new JCheckBox[StaticData.MAX_CHANNELS][StaticData.MAX_BARS];
	private static JCheckBox checkBoxON[] = new JCheckBox[StaticData.MAX_CHANNELS];
	private static JTextPane txtInfo = new JTextPane();	/**
	 * generated serial version id
	 */
	private static final long serialVersionUID = 7187545235119375199L;
	private JPanel contentPane;

	/**
	 * Show the frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					Message.Error(
							"An error occured while loading the main frame. Please contact the developer.\n\nLogs:\n\n"
									+ e.getStackTrace(),
							"Error!");
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		for (int i = 0; i < StaticData.MAX_CHANNELS; i++) 
			btnBrowse[i] = new JButton(TextData.BROWSE);

		setTitle("Simple DAW");
		setBackground(Color.BLACK);
		setType(Type.UTILITY);
		// setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 430);
		contentPane = new JPanel();
		JPanel panel = new JPanel();
		JMenuBar menuBar = new JMenuBar();
		JMenu mnFile = new JMenu(TextData.FILE);
		JMenuItem mntmNew = new JMenuItem(TextData.NEW);
		mntmNew.addActionListener(new NewButtonActionListener());
		JMenuItem mntmSave = new JMenuItem(TextData.SAVE);
		JMenuItem mntmLoad = new JMenuItem(TextData.LOAD);
		JMenu mnEdit = new JMenu(TextData.EDIT);
		JMenuItem mntmClear = new JMenuItem(TextData.CLEAR);
		mntmClear.addActionListener(new ClearButtonActionListener());
		JMenuItem mntmTempo = new JMenuItem(TextData.TEMPO);
		mntmTempo.addActionListener(new TempoButtonActionListener());
		JMenuItem mntmDelay = new JMenuItem(TextData.DELAY);
		mntmDelay.addActionListener(new DelayFrameActionListener());
		JMenu mnAbout = new JMenu(TextData.ABOUT);
		JMenuItem mntmInfo = new JMenuItem(TextData.INFO);
		JMenuItem mntmExit = new JMenuItem(TextData.EXIT);

		JTextField txtSimpleDigitalAudio = new JTextField();
		JPanel panel_3 = new JPanel();
		JPanel panel_1 = new JPanel();
		JPanel panel_4 = new JPanel();
		JPanel panel_5 = new JPanel();
		JPanel panel_6 = new JPanel();
		JPanel panel_7 = new JPanel();
		JPanel panel_2 = new JPanel();

		for (int i = 0; i < StaticData.MAX_CHANNELS; i++) {
			checkBoxON[i] = new JCheckBox(TextData.CHANNEL_ON);
			checkBoxON[i].addItemListener(new ChannelOnOffItemListener(i));
		}

		for (int i = 0; i < StaticData.MAX_CHANNELS; i++)
			for (int j = 0; j < StaticData.MAX_BARS; j++) {
				checkBox[i][j] = new JCheckBox(String.valueOf(j + 1));
				checkBox[i][j].setEnabled(false);
			}

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);

		JSplitPane splitPane = new JSplitPane();
		JButton btnPlay = new JButton(TextData.PLAY);
		JButton btnStop = new JButton(TextData.STOP);

		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		panel.setBackground(Color.LIGHT_GRAY);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);

		menuBar.setBackground(Color.LIGHT_GRAY);
		panel.add(menuBar);

		mnFile.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnFile);
		mnFile.add(mntmNew);
		mnFile.add(mntmSave);
		mntmSave.addActionListener(new SaveButtonActionListener());
		mnFile.add(mntmLoad);
		mntmLoad.addActionListener(new LoadButtonActionListener());
		mnFile.add(mntmExit);
		mnEdit.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mnEdit);
		mnEdit.add(mntmClear);
		mnEdit.add(mntmTempo);
		mnEdit.add(mntmDelay);
		menuBar.add(mnAbout);
		mntmInfo.addActionListener(new AboutActionListener());
		mntmExit.addActionListener(new ExitButtonActionListener());
		mnAbout.add(mntmInfo);

		txtSimpleDigitalAudio.setEditable(false);
		txtSimpleDigitalAudio.setBackground(Color.LIGHT_GRAY);
		txtSimpleDigitalAudio.setHorizontalAlignment(SwingConstants.RIGHT);
		txtSimpleDigitalAudio.setText(TextData.TITLE);
		panel.add(txtSimpleDigitalAudio);
		txtSimpleDigitalAudio.setBorder(null);
		txtSimpleDigitalAudio.setColumns(TextData.TITLE.length());
		txtSimpleDigitalAudio.setHighlighter(null);
		contentPane.add(panel_3, BorderLayout.CENTER);

		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(checkBoxON[0]).addGap(18)
						.addComponent(checkBox[0][0], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[0][1], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[0][2], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[0][3], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[0][4], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[0][5], GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[0][6], GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[0][7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnBrowse[0], GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(19, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(checkBox[0][0])
								.addComponent(checkBox[0][1]).addComponent(checkBox[0][2]).addComponent(checkBox[0][3])
								.addComponent(checkBox[0][4]).addComponent(checkBox[0][5]).addComponent(checkBox[0][6])
								.addComponent(checkBox[0][7]).addComponent(btnBrowse[0]))
						.addComponent(checkBoxON[0]))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup().addContainerGap().addComponent(checkBoxON[1]).addGap(18)
						.addComponent(checkBox[1][0], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[1][1], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[1][2], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[1][3], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[1][4], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[1][5], GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[1][6], GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[1][7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnBrowse[1], GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(34, Short.MAX_VALUE)));
		gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_4
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE).addComponent(checkBox[1][0])
								.addComponent(checkBox[1][1]).addComponent(checkBox[1][2]).addComponent(checkBox[1][3])
								.addComponent(checkBox[1][4]).addComponent(checkBox[1][5]).addComponent(checkBox[1][6])
								.addComponent(checkBox[1][7]).addComponent(btnBrowse[1]))
						.addComponent(checkBoxON[1]))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_4.setLayout(gl_panel_4);

		gl_panel_5.setHorizontalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup().addContainerGap().addComponent(checkBoxON[2]).addGap(18)
						.addComponent(checkBox[2][0], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[2][1], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[2][2], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[2][3], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[2][4], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[2][5], GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[2][6], GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[2][7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnBrowse[2], GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(31, Short.MAX_VALUE)));
		gl_panel_5.setVerticalGroup(gl_panel_5.createParallelGroup(Alignment.LEADING).addGap(0, 41, Short.MAX_VALUE)
				.addGroup(gl_panel_5.createSequentialGroup().addContainerGap().addGroup(gl_panel_5
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE).addComponent(checkBox[2][0])
								.addComponent(checkBox[2][1]).addComponent(checkBox[2][2]).addComponent(checkBox[2][3])
								.addComponent(checkBox[2][4]).addComponent(checkBox[2][5]).addComponent(checkBox[2][6])
								.addComponent(checkBox[2][7]).addComponent(btnBrowse[2]))
						.addComponent(checkBoxON[2])).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_5.setLayout(gl_panel_5);

		gl_panel_6.setHorizontalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup().addContainerGap().addComponent(checkBoxON[3]).addGap(18)
						.addComponent(checkBox[3][0], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[3][1], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[3][2], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[3][3], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[3][4], GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[3][5], GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[3][6], GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(checkBox[3][7], GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnBrowse[3], GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(28, Short.MAX_VALUE)));
		gl_panel_6.setVerticalGroup(gl_panel_6.createParallelGroup(Alignment.LEADING).addGap(0, 41, Short.MAX_VALUE)
				.addGap(0, 41, Short.MAX_VALUE)
				.addGroup(gl_panel_6.createSequentialGroup().addContainerGap().addGroup(gl_panel_6
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE).addComponent(checkBox[3][0])
								.addComponent(checkBox[3][1]).addComponent(checkBox[3][2]).addComponent(checkBox[3][3])
								.addComponent(checkBox[3][4]).addComponent(checkBox[3][5]).addComponent(checkBox[3][6])
								.addComponent(checkBox[3][7]).addComponent(btnBrowse[3]))
						.addComponent(checkBoxON[3])).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_6.setLayout(gl_panel_6);

		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap(85, Short.MAX_VALUE)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 479, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_3.createSequentialGroup()
										.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 453,
												GroupLayout.PREFERRED_SIZE)
										.addGap(26)))
						.addContainerGap())
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap()
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(23, Short.MAX_VALUE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addGap(5)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(40, Short.MAX_VALUE)));

		panel_7.add(splitPane);
		btnPlay.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("play.png")));
		splitPane.setLeftComponent(btnPlay);
		btnPlay.addActionListener(new PlayButtonActionListener());

		btnStop.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("stop.png")));
		splitPane.setRightComponent(btnStop);
		btnStop.addActionListener(new StopButtonActionListener());
		panel_3.setLayout(gl_panel_3);

		panel_2.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_2, BorderLayout.SOUTH);

		for (int i = 0; i < StaticData.MAX_CHANNELS; i++) {
			btnBrowse[i].addActionListener(new BrowseFileActionListener(i));
			btnBrowse[i].setEnabled(false);
		}

		txtInfo.setBackground(Color.LIGHT_GRAY);
		//txtInfo.setText("Info text will be displayed here.");
		panel_2.add(txtInfo);
	}
	/**
	 * Sets the informational text field
	 */
	public static final void SetInfoText(String info) {
		txtInfo.setText(info);
	}
	/**
	 * Enable/disable channels
	 */
	public static final void SetEnableChannel(int channelID, boolean on) {
		for (int i = 0; i < StaticData.MAX_BARS; i++) {
			checkBox[channelID][i].setEnabled(on);
			checkBox[channelID][i].setFont(new Font(checkBox[channelID][i].getFont().getName(), Font.PLAIN, checkBox[channelID][i].getFont().getSize()));
		}
		btnBrowse[channelID].setEnabled(on);
		checkBoxON[channelID].setSelected(on);
	}
	/**
	 * Get channel arrangement information to a boolean array
	 */
	public static final boolean[] GetChannelArrangement(int channelID) {
		if(!Main.Channels.get(channelID).IsEnabled())// channel is not enabled so we don't need the arrangement
			return null;
		boolean[] active = new boolean[StaticData.MAX_BARS];
		for (int i = 0; i < StaticData.MAX_BARS; i++)
			active[i] = checkBox[channelID][i].isSelected();
		return active;
	}
	/**
	 * Set channel arrangement to a specific boolean array
	 */
	public static final void SetChannelArrangement(int channelID, boolean[] arrangement) {
		for (int i = 0; i < StaticData.MAX_BARS; i++)
			checkBox[channelID][i].setSelected(arrangement[i]);
	}	
	/**
	 * Changes the font of currently playing bar to bold
	 */
	public static final void SetActiveBar(int channelID, int checkBoxID, boolean active) { // sets the currently playing checkbox's text bold
		 Font newFont = new Font(checkBox[channelID][checkBoxID].getFont().getName(), (active) ? Font.BOLD :  Font.PLAIN, checkBox[channelID][checkBoxID].getFont().getSize());
		 checkBox[channelID][checkBoxID].setFont(newFont);
		 //System.out.print("ch: " + channelID + " cbID: " + checkBoxID + " active: " + active);
	}
}
