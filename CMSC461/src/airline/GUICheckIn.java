package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

public class GUICheckIn {

	JFrame frmCheckIn;
	private JTextField tfBaggageCarried;
	private JLabel lblSeatNumber;
	private JTextField tfSeatNumber;
	private JButton btnSubmit;
	private JLabel lblSubmitStatus;
	private JLabel lblPassengerStatus;
	private JLabel lblPassengerStatusStatus;

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
		frmCheckIn.setBounds(100, 100, 280, 170);
		frmCheckIn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCheckIn.setLocationRelativeTo(null);
		frmCheckIn.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		final Airline airline = new Airline();
		
		JLabel lblSSN = new JLabel("SSN:");
		lblSSN.setHorizontalAlignment(SwingConstants.CENTER);
		frmCheckIn.getContentPane().add(lblSSN);
		
		final JComboBox<String> cbSSN = new JComboBox<String>();
		cbSSN.setModel(new DefaultComboBoxModel<String>(airline.getPassengers().toArray(new String[airline.getPassengers().size()])));
		frmCheckIn.getContentPane().add(cbSSN);
		
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
		
		lblPassengerStatus = new JLabel("Passenger status:");
		lblPassengerStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmCheckIn.getContentPane().add(lblPassengerStatus);
		
		lblPassengerStatusStatus = new JLabel("");
		lblPassengerStatusStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmCheckIn.getContentPane().add(lblPassengerStatusStatus);
		
		lblSubmitStatus = new JLabel("");
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(cbSSN.getSelectedItem()).trim().equals(""))
					lblSubmitStatus.setText("Required field(s)");
				else if (tfBaggageCarried.getText().trim().equals(""))
					lblSubmitStatus.setText("Required field(s)");
				else if (tfSeatNumber.getText().trim().equals(""))
					lblSubmitStatus.setText("Required field(s)");
				else if(!Pattern.matches("[0-9]+", tfBaggageCarried.getText().trim()))
					lblSubmitStatus.setText("Invalid baggage carried");
				else if(!Pattern.matches("[0-9]+", tfSeatNumber.getText().trim()))
					lblSubmitStatus.setText("Invalid seat number");
				else {
					double ssn = Double.parseDouble(String.valueOf(cbSSN.getSelectedItem()));
					int baggageCarried = Integer.parseInt(tfBaggageCarried.getText());
					int seatNumber = Integer.parseInt(tfSeatNumber.getText());
					
					boolean checkInStatus = airline.checkIn(ssn, baggageCarried, seatNumber);
					
					if (checkInStatus == false)
						lblPassengerStatusStatus.setText("Failed");
					else
						lblPassengerStatusStatus.setText("Updated");
					
					lblSubmitStatus.setText("");
				}
			}
		});
		frmCheckIn.getContentPane().add(btnSubmit);
		
		
		lblSubmitStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmCheckIn.getContentPane().add(lblSubmitStatus);
	}

}
