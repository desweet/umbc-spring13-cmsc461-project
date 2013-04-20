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
	private JTextField tfSSN;
	private JTextField tfBaggageCarried;
	private JLabel lblSeatNumber;
	private JTextField tfSeatNumber;
	private JButton btnSubmit;
	private JLabel tfSubmitStatus;

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
		
		JLabel lblSSN = new JLabel("SSN:");
		lblSSN.setHorizontalAlignment(SwingConstants.CENTER);
		frmCheckIn.getContentPane().add(lblSSN);
		
		tfSSN = new JTextField();
		tfSSN.setHorizontalAlignment(SwingConstants.CENTER);
		tfSSN.setColumns(10);
		frmCheckIn.getContentPane().add(tfSSN);
		
		JLabel lblBaggageCarried = new JLabel("Baggage carried:");
		lblBaggageCarried.setHorizontalAlignment(SwingConstants.CENTER);
		frmCheckIn.getContentPane().add(lblBaggageCarried);
		
		tfBaggageCarried = new JTextField();
		tfBaggageCarried.setHorizontalAlignment(SwingConstants.CENTER);
		tfBaggageCarried.setColumns(10);
		frmCheckIn.getContentPane().add(tfBaggageCarried);
		
		lblSeatNumber = new JLabel("Seat number:");
		lblSeatNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frmCheckIn.getContentPane().add(lblSeatNumber);
		
		tfSeatNumber = new JTextField();
		tfSeatNumber.setHorizontalAlignment(SwingConstants.CENTER);
		tfSeatNumber.setColumns(10);
		frmCheckIn.getContentPane().add(tfSeatNumber);
		
		btnSubmit = new JButton("Submit");
		frmCheckIn.getContentPane().add(btnSubmit);
		
		tfSubmitStatus = new JLabel("");
		tfSubmitStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmCheckIn.getContentPane().add(tfSubmitStatus);
	}

}
