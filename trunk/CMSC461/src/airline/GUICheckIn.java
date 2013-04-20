package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GUICheckIn {

	JFrame frmCheckIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICheckIn window = new GUICheckIn();
					window.frmCheckIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUICheckIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCheckIn = new JFrame();
		frmCheckIn.setResizable(false);
		frmCheckIn.setTitle("Check In");
		frmCheckIn.setBounds(100, 100, 450, 300);
		frmCheckIn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCheckIn.setLocationRelativeTo(null);
	}

}
