package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GUIBookTicket {

	JFrame frmBookTicket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIBookTicket window = new GUIBookTicket();
					window.frmBookTicket.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIBookTicket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBookTicket = new JFrame();
		frmBookTicket.setResizable(false);
		frmBookTicket.setTitle("Book Ticket");
		frmBookTicket.setBounds(100, 100, 450, 300);
		frmBookTicket.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBookTicket.setLocationRelativeTo(null);
	}

}
