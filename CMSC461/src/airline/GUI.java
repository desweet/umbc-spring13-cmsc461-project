package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GUI {

	private JFrame frmAirlineManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmAirlineManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAirlineManager = new JFrame();
		frmAirlineManager.setTitle("Airline Manager");
		frmAirlineManager.setBounds(100, 100, 450, 300);
		frmAirlineManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
