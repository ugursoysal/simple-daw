package daw;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.util.ArrayList;

public class DelaySettings extends JFrame {

	/**
	 * generated serial version id
	 */
	private static final long serialVersionUID = -1349082240310050033L;
	private JPanel contentPane;
	private final String[] delayOptions = {"no delay", "1/2", "1/3", "1/4", "1/5", "1/6", "1/7", "1/8" };
	private static ArrayList<JComboBox<String>> comboBox = new ArrayList<JComboBox<String>>(StaticData.MAX_CHANNELS);
	private static DelaySettings frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DelaySettings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DelaySettings() {

		for (int i = 0; i < StaticData.MAX_CHANNELS; i++) {
			comboBox.add(i, new JComboBox<String>(delayOptions));
			comboBox.get(i).addActionListener(new DelaySettingActionListener(i));
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 79);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("Channel 1:");
		panel.add(label);
		
		panel.add(comboBox.get(0));
		
		JLabel label_1 = new JLabel("Channel 2:");
		panel.add(label_1);

		panel.add(comboBox.get(1));
		
		JLabel label_2 = new JLabel("Channel 3:");
		panel.add(label_2);
		
		panel.add(comboBox.get(2));
		
		JLabel label_3 = new JLabel("Channel 4:");
		panel.add(label_3);
		
		panel.add(comboBox.get(3));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		contentPane.add(panel_1, BorderLayout.SOUTH);
	}

		/**
		 * Get the delay setting from combo boxes
		 */
		public static final int GetDelay(int channelID) {
			return comboBox.get(channelID).getSelectedIndex();
		}

}
