package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUICheckIn {

	JFrame frmCheckIn;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblSeatNumber;
	private JTextField textField_2;
	private JButton btnSubmit;
	private JLabel label;

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
		frmCheckIn.setBounds(100, 100, 200, 150);
		frmCheckIn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCheckIn.setLocationRelativeTo(null);
		frmCheckIn.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblSsn = new JLabel("SSN:");
		lblSsn.setHorizontalAlignment(SwingConstants.CENTER);
		frmCheckIn.getContentPane().add(lblSsn);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		frmCheckIn.getContentPane().add(textField);
		
		JLabel lblBaggageCarried = new JLabel("Baggage carried:");
		lblBaggageCarried.setHorizontalAlignment(SwingConstants.CENTER);
		frmCheckIn.getContentPane().add(lblBaggageCarried);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		frmCheckIn.getContentPane().add(textField_1);
		
		lblSeatNumber = new JLabel("Seat number:");
		lblSeatNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frmCheckIn.getContentPane().add(lblSeatNumber);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		frmCheckIn.getContentPane().add(textField_2);
		
		btnSubmit = new JButton("Submit");
		frmCheckIn.getContentPane().add(btnSubmit);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frmCheckIn.getContentPane().add(label);
	}

}
