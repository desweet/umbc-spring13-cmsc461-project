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
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUIBookTicket {

	JFrame frmBookTicket;
	private JTextField tfSSN;
	private JTextField tfFirstName;
	private JTextField tfStreet;
	private JTextField tfAmountPaid;
	private JTextField tfApartmentNumber;
	private JTextField tfCity;
	private JTextField tfState;
	private JTextField tfZip;
	private JTextField tfPhoneHome;
	private JTextField tfEmail;
	private JTextField tfPhoneOffice;
	private JTextField tfLastName;
	private JTextField tfAge;
	private JLabel lblPassengerStatusStatus;
	private JLabel lblReservationStatusStatus;
	private JLabel lblSubmitStatus;

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
		frmBookTicket.setBounds(100, 100, 400, 500);
		frmBookTicket.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBookTicket.setLocationRelativeTo(null);
		frmBookTicket.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		final Airline airline = new Airline();
		
		JLabel lblSSN = new JLabel("SSN:");
		lblSSN.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblSSN);
		
		tfSSN = new JTextField();
		tfSSN.setHorizontalAlignment(SwingConstants.CENTER);
		tfSSN.setColumns(10);
		frmBookTicket.getContentPane().add(tfSSN);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblFirstName);
		
		tfFirstName = new JTextField();
		tfFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		tfFirstName.setColumns(10);
		frmBookTicket.getContentPane().add(tfFirstName);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblLastName);
		
		tfLastName = new JTextField();
		tfLastName.setHorizontalAlignment(SwingConstants.CENTER);
		tfLastName.setColumns(10);
		frmBookTicket.getContentPane().add(tfLastName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblAge);
		
		tfAge = new JTextField();
		tfAge.setHorizontalAlignment(SwingConstants.CENTER);
		tfAge.setColumns(10);
		frmBookTicket.getContentPane().add(tfAge);
		
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
		
		final JComboBox<String> cbFlightNumber = new JComboBox<String>();
		cbFlightNumber.setModel(new DefaultComboBoxModel<String>(airline.getFlightNumbers().toArray(new String[airline.getFlightNumbers().size()])));
		frmBookTicket.getContentPane().add(cbFlightNumber);
		
		JLabel lblFlightClass = new JLabel("Flight class:");
		lblFlightClass.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblFlightClass);
		
		final JComboBox<String> cbFlightClass = new JComboBox<String>();
		cbFlightClass.setModel(new DefaultComboBoxModel<String>(new String[] {"", "First", "Business", "Economy"}));
		frmBookTicket.getContentPane().add(cbFlightClass);
		
		JLabel lblAmountPaid = new JLabel("Amount paid:");
		lblAmountPaid.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblAmountPaid);
		
		tfAmountPaid = new JTextField();
		tfAmountPaid.setHorizontalAlignment(SwingConstants.CENTER);
		tfAmountPaid.setColumns(10);
		frmBookTicket.getContentPane().add(tfAmountPaid);
		
		JLabel lblPassengerStatus = new JLabel("Passenger status:");
		lblPassengerStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblPassengerStatus);
		
		lblPassengerStatusStatus = new JLabel("");
		lblPassengerStatusStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblPassengerStatusStatus);
		
		JLabel lblReservationStatus = new JLabel("Reservation status:");
		lblReservationStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblReservationStatus);
		
		lblReservationStatusStatus = new JLabel("");
		lblReservationStatusStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblReservationStatusStatus);
		
		lblSubmitStatus = new JLabel("");
		
//		tfSSN.setText("123456789");
//		tfFirstName.setText("Derek");
//		tfLastName.setText("Sweet");
//		tfAge.setText("22");
//		tfStreet.setText("Fallston Valley Drive");
//		tfCity.setText("Fallston");
//		tfState.setText("MD");
//		tfZip.setText("21047");
//		tfPhoneHome.setText("4108039778");
//		tfPhoneOffice.setText("4439779169");
//		tfEmail.setText("desweet3@gmail.com");
//		cbFlightNumber.setSelectedIndex(1);
//		cbFlightClass.setSelectedIndex(1);
//		tfAmountPaid.setText("100");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfSSN.getText().trim().equals(""))
					setStatus("", "", "Required field(s)");
				else if (tfFirstName.getText().trim().equals(""))
					setStatus("", "", "Required field(s)");
				else if (tfLastName.getText().trim().equals(""))
					setStatus("", "", "Required field(s)");
				else if (tfAge.getText().trim().equals(""))
					setStatus("", "", "Required field(s)");
				else if (tfStreet.getText().trim().equals(""))
					setStatus("", "", "Required field(s)");
				else if (tfCity.getText().trim().equals(""))
					setStatus("", "", "Required field(s)");
				else if (tfState.getText().trim().equals(""))
					setStatus("", "", "Required field(s)");
				else if (tfZip.getText().trim().equals(""))
					setStatus("", "", "Required field(s)");
				else if (tfPhoneHome.getText().trim().equals("") && tfPhoneOffice.getText().trim().equals(""))
					setStatus("", "", "Required field(s)");
				else if (tfEmail.getText().trim().equals(""))
					setStatus("", "", "Required field(s)");
				else if (String.valueOf(cbFlightNumber.getSelectedItem()).trim().equals(""))
					setStatus("", "", "Required field(s)");
				else if (String.valueOf(cbFlightClass.getSelectedItem()).trim().equals(""))
					setStatus("", "", "Required field(s)");
				else if (tfAmountPaid.getText().trim().equals(""))
					setStatus("", "", "Required field(s)");
				else if(!Pattern.matches("[0-9]{9}", tfSSN.getText().trim()))
					setStatus("", "", "Invalid SSN");
				else if(!Pattern.matches("[0-9]+", tfAge.getText().trim()))
					setStatus("", "", "Invalid age");
				else if(!Pattern.matches("[0-9]+", tfApartmentNumber.getText().trim()) && !tfApartmentNumber.getText().trim().equals(""))
					setStatus("", "", "Invalid apartment number");
				else if(!Pattern.matches("[0-9]{5}", tfZip.getText().trim()))
					setStatus("", "", "Invalid zip");
				else if(!Pattern.matches("[0-9]{10}", tfPhoneHome.getText().trim()) && !tfPhoneHome.getText().trim().equals(""))
					setStatus("", "", "Invalid home phone");
				else if(!Pattern.matches("[0-9]{10}", tfPhoneOffice.getText().trim()) && !tfPhoneOffice.getText().trim().equals(""))
					setStatus("", "", "Invalid office phone");
				else if(!Pattern.matches("[0-9]+", tfAmountPaid.getText().trim()))
					setStatus("", "", "Invalid amount paid");
				else {
					double ssn = Double.parseDouble(tfSSN.getText());
					String firstName = tfFirstName.getText();
					String lastName = tfLastName.getText();
					int age = Integer.parseInt(tfAge.getText());
					String street = tfStreet.getText();
					String city = tfCity.getText();
					String state = tfState.getText();
					int zip = Integer.parseInt(tfZip.getText());
					
					int apartmentNumber = 0;
					double phoneHome = 0;
					double phoneOffice = 0;
					
					if (!tfApartmentNumber.getText().trim().equals(""))
						apartmentNumber = Integer.parseInt(tfApartmentNumber.getText());
					if (!tfPhoneHome.getText().trim().equals(""))
						phoneHome = Double.parseDouble(tfPhoneHome.getText());
					if (!tfPhoneOffice.getText().trim().equals(""))
						phoneOffice = Double.parseDouble(tfPhoneOffice.getText());
					
					Passenger passenger = new Passenger(ssn,
														firstName,
														lastName,
														age,
														street,
														apartmentNumber,
														city,
														state,
														zip,
														phoneHome,
														phoneOffice);
					
					int flightNumber = Integer.parseInt(String.valueOf(cbFlightNumber.getSelectedItem()));
					String flightClass = String.valueOf(cbFlightClass.getSelectedItem()).toLowerCase();
					double amountPaid = Double.parseDouble(tfAmountPaid.getText());
					int bags = 0;
					
					Reservation reservation = new Reservation(flightNumber, ssn, flightClass, amountPaid, bags);
					
					boolean passengerStatus = airline.addPassenger(passenger);
					String reservationStatus = airline.makeReservation(reservation);
//					boolean passengerStatus = false;
//					String reservationStatus = "failed";
					
					if (passengerStatus == false)
					{
						lblPassengerStatusStatus.setText("Already exists");
						
						if (reservationStatus.equals("confirmed"))
							lblReservationStatusStatus.setText("Confirmed");
						else if (reservationStatus.equals("waiting"))
							lblReservationStatusStatus.setText("Waiting");
						else
							lblReservationStatusStatus.setText("Failed");
					}
						
					else
					{
						lblPassengerStatusStatus.setText("Created");
						
						if (reservationStatus.equals("confirmed"))
							lblReservationStatusStatus.setText("Confirmed");
						else if (reservationStatus.equals("waiting"))
							lblReservationStatusStatus.setText("Waiting");
						else
							lblReservationStatusStatus.setText("Failed");
					}
					
					lblSubmitStatus.setText("");
				}	
			}
		});
		
		frmBookTicket.getContentPane().add(btnSubmit);
		
		lblSubmitStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmBookTicket.getContentPane().add(lblSubmitStatus);
	}
	
	private void setStatus(String passengerStatus, String reservationStatus, String submitStatus) {
		lblPassengerStatusStatus.setText(passengerStatus);
		lblReservationStatusStatus.setText(reservationStatus);
		lblSubmitStatus.setText(submitStatus);
	}

}
