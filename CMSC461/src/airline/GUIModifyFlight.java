package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GUIModifyFlight {

	JFrame frmModifyFlight;
	private JTextField tfDepartureDateTime;
	private JLabel lblArrivalDateTime;
	private JTextField tfArrivalDateTime;
	private JButton btnSubmit;
	private JLabel lblSubmitStatus;
	private JLabel lblFlightStatus;
	private JLabel lblFlightStatusStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIModifyFlight window = new GUIModifyFlight();
					window.frmModifyFlight.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIModifyFlight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModifyFlight = new JFrame();
		frmModifyFlight.setResizable(false);
		frmModifyFlight.setTitle("Modify Flight");
		frmModifyFlight.setBounds(100, 100, 300, 180);
		frmModifyFlight.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmModifyFlight.setLocationRelativeTo(null);
		frmModifyFlight.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		final Airline airline = new Airline();
		
		JLabel lblFlightNumber = new JLabel("Flight number:");
		lblFlightNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frmModifyFlight.getContentPane().add(lblFlightNumber);
		
		final JComboBox<String> cbFlightNumber = new JComboBox<String>();
		cbFlightNumber.setModel(new DefaultComboBoxModel<String>(airline.getFlightNumbers().toArray(new String[airline.getFlightNumbers().size()])));
		frmModifyFlight.getContentPane().add(cbFlightNumber);
		
		JLabel lblDepartureDateTime = new JLabel("Departure date/time:");
		lblDepartureDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		frmModifyFlight.getContentPane().add(lblDepartureDateTime);
		
		tfDepartureDateTime = new JTextField();
		tfDepartureDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		tfDepartureDateTime.setColumns(10);
		frmModifyFlight.getContentPane().add(tfDepartureDateTime);
		
		lblArrivalDateTime = new JLabel("Arrival date/time:");
		lblArrivalDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		frmModifyFlight.getContentPane().add(lblArrivalDateTime);
		
		tfArrivalDateTime = new JTextField();
		tfArrivalDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		tfArrivalDateTime.setColumns(10);
		frmModifyFlight.getContentPane().add(tfArrivalDateTime);
		
		lblFlightStatus = new JLabel("Flight status:");
		lblFlightStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmModifyFlight.getContentPane().add(lblFlightStatus);
		
		lblFlightStatusStatus = new JLabel("");
		lblFlightStatusStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmModifyFlight.getContentPane().add(lblFlightStatusStatus);
		
		lblSubmitStatus = new JLabel("");
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(cbFlightNumber.getSelectedItem()).trim().equals(""))
					lblSubmitStatus.setText("Required field(s)");
				else if (tfDepartureDateTime.getText().trim().equals(""))
					lblSubmitStatus.setText("Required field(s)");
				else if (tfArrivalDateTime.getText().trim().equals(""))
					lblSubmitStatus.setText("Required field(s)");
				else {
					int flightNumber = Integer.parseInt(String.valueOf(cbFlightNumber.getSelectedItem()));
					
					Date departureTime = null;
					Date arrivalTime = null;
					
					try {
						departureTime = new SimpleDateFormat("MM-dd-yyyy HH:mm").parse(tfDepartureDateTime.getText());
						arrivalTime = new SimpleDateFormat("MM-dd-yyyy HH:mm").parse(tfArrivalDateTime.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					boolean modifyStatus = airline.modifyFlight(flightNumber, departureTime, arrivalTime);
					
					if (modifyStatus == false)
						lblFlightStatusStatus.setText("Failed");
					else
						lblFlightStatusStatus.setText("Updated");
					
					lblSubmitStatus.setText("");
				}
			}
		});
		frmModifyFlight.getContentPane().add(btnSubmit);
		
		lblSubmitStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmModifyFlight.getContentPane().add(lblSubmitStatus);
	}

}
