package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIBookTicket {

	JFrame frmBookTicket;
	private JTextField tfSSN;
	private JTextField tfName;
	private JTextField tfStreet;
	private JTextField tfFlightClass;
	private JTextField tfAmountPaid;
	private JTextField tfApartmentNumber;
	private JTextField tfCity;
	private JTextField tfState;
	private JTextField tfZip;
	private JTextField tfPhoneHome;
	private JTextField tfEmail;
	private JTextField tfPhoneOffice;
	private JTextField tfFlightNumber;

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
		
		JLabel lblSSN = new JLabel("SSN:");
		lblSSN.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblSSN);
		
		tfSSN = new JTextField();
		tfSSN.setHorizontalAlignment(SwingConstants.CENTER);
		tfSSN.setColumns(10);
		frmBookTicket.getContentPane().add(tfSSN);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblName);
		
		tfName = new JTextField();
		tfName.setHorizontalAlignment(SwingConstants.CENTER);
		tfName.setColumns(10);
		frmBookTicket.getContentPane().add(tfName);
		
		JLabel lblAddress = new JLabel("Street:");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblAddress);
		
		tfStreet = new JTextField();
		tfStreet.setHorizontalAlignment(SwingConstants.CENTER);
		tfStreet.setColumns(10);
		frmBookTicket.getContentPane().add(tfStreet);
		
		JLabel lblApartmentNumber = new JLabel("Apartment number:");
		lblApartmentNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblApartmentNumber);
		
		tfApartmentNumber = new JTextField();
		tfApartmentNumber.setHorizontalAlignment(SwingConstants.CENTER);
		tfApartmentNumber.setColumns(10);
		frmBookTicket.getContentPane().add(tfApartmentNumber);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblCity);
		
		tfCity = new JTextField();
		tfCity.setHorizontalAlignment(SwingConstants.CENTER);
		tfCity.setColumns(10);
		frmBookTicket.getContentPane().add(tfCity);
		
		JLabel lblState = new JLabel("State:");
		lblState.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblState);
		
		tfState = new JTextField();
		tfState.setHorizontalAlignment(SwingConstants.CENTER);
		tfState.setColumns(10);
		frmBookTicket.getContentPane().add(tfState);
		
		JLabel lblZip = new JLabel("Zip:");
		lblZip.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblZip);
		
		tfZip = new JTextField();
		tfZip.setHorizontalAlignment(SwingConstants.CENTER);
		tfZip.setColumns(10);
		frmBookTicket.getContentPane().add(tfZip);
		
		JLabel lblPhoneHome = new JLabel("Phone (home):");
		lblPhoneHome.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblPhoneHome);
		
		tfPhoneHome = new JTextField();
		tfPhoneHome.setHorizontalAlignment(SwingConstants.CENTER);
		tfPhoneHome.setColumns(10);
		frmBookTicket.getContentPane().add(tfPhoneHome);
		
		JLabel lblPhoneOffice = new JLabel("Phone (office):");
		lblPhoneOffice.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblPhoneOffice);
		
		tfPhoneOffice = new JTextField();
		tfPhoneOffice.setHorizontalAlignment(SwingConstants.CENTER);
		tfPhoneOffice.setColumns(10);
		frmBookTicket.getContentPane().add(tfPhoneOffice);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setHorizontalAlignment(SwingConstants.CENTER);
		tfEmail.setColumns(10);
		frmBookTicket.getContentPane().add(tfEmail);
		
		JLabel lblFlightNumber = new JLabel("Flight number:");
		lblFlightNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblFlightNumber);
		
		tfFlightNumber = new JTextField();
		tfFlightNumber.setHorizontalAlignment(SwingConstants.CENTER);
		tfFlightNumber.setColumns(10);
		frmBookTicket.getContentPane().add(tfFlightNumber);
		
		JLabel lblFlightClass = new JLabel("Flight class:");
		lblFlightClass.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblFlightClass);
		
		tfFlightClass = new JTextField();
		tfFlightClass.setHorizontalAlignment(SwingConstants.CENTER);
		tfFlightClass.setColumns(10);
		frmBookTicket.getContentPane().add(tfFlightClass);
		
		JLabel lblAmountPaid = new JLabel("Amount paid:");
		lblAmountPaid.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblAmountPaid);
		
		tfAmountPaid = new JTextField();
		tfAmountPaid.setHorizontalAlignment(SwingConstants.CENTER);
		tfAmountPaid.setColumns(10);
		frmBookTicket.getContentPane().add(tfAmountPaid);
		
		JLabel lblReservationStatus = new JLabel("Reservation status:");
		lblReservationStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblReservationStatus);
		
		final JLabel tfReservationStatus = new JLabel("");
		tfReservationStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(tfReservationStatus);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				tfReservationStatus.setText(tfFlightClass.getText());
			}
		});
		frmBookTicket.getContentPane().add(btnSubmit);
		
		JLabel tfSubmitStatus = new JLabel("");
		tfSubmitStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(tfSubmitStatus);
	}

}
