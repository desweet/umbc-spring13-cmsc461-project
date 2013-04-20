package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUIBookTicket {

	JFrame frmBookTicket;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

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
		frmBookTicket.setBounds(100, 100, 400, 400);
		frmBookTicket.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBookTicket.setLocationRelativeTo(null);
		frmBookTicket.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label = new JLabel("SSN:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		frmBookTicket.getContentPane().add(textField);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		frmBookTicket.getContentPane().add(textField_1);
		
		JLabel lblAddress = new JLabel("Street:");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		frmBookTicket.getContentPane().add(textField_2);
		
		JLabel lblApartmentNumber = new JLabel("Apartment number:");
		lblApartmentNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblApartmentNumber);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		frmBookTicket.getContentPane().add(textField_5);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblCity);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		frmBookTicket.getContentPane().add(textField_6);
		
		JLabel lblState = new JLabel("State:");
		lblState.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblState);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setColumns(10);
		frmBookTicket.getContentPane().add(textField_7);
		
		JLabel lblZip = new JLabel("Zip:");
		lblZip.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblZip);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setColumns(10);
		frmBookTicket.getContentPane().add(textField_8);
		
		JLabel lblPhone = new JLabel("Phone (home):");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblPhone);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setColumns(10);
		frmBookTicket.getContentPane().add(textField_9);
		
		JLabel lblPhoneoffice = new JLabel("Phone (office):");
		lblPhoneoffice.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblPhoneoffice);
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setColumns(10);
		frmBookTicket.getContentPane().add(textField_11);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblEmail);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setColumns(10);
		frmBookTicket.getContentPane().add(textField_10);
		
		JLabel lblFlightClass = new JLabel("Flight class:");
		lblFlightClass.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblFlightClass);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		frmBookTicket.getContentPane().add(textField_3);
		
		JLabel lblAmountPaid = new JLabel("Amount paid:");
		lblAmountPaid.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblAmountPaid);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		frmBookTicket.getContentPane().add(textField_4);
		
		JLabel lblReservationStatus = new JLabel("Reservation status:");
		lblReservationStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblReservationStatus);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(label_2);
		
		JButton btnSubmit = new JButton("Submit");
		frmBookTicket.getContentPane().add(btnSubmit);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(label_1);
	}

}
