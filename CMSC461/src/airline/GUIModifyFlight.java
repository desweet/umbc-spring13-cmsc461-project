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
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class GUIModifyFlight {

	JFrame frmModifyFlight;
	private JTextField tfDepartureDateTime;
	private JLabel lblArrivalDateTime;
	private JTextField tfArrivalDateTime;
	private JButton btnSubmit;
	private JLabel lblSubmitStatus;
	private JLabel lblFlightStatus;
	private JLabel lblFlightStatusStatus;
	private JComboBox<String> cbStops;
	private JLabel lblStops;

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
		lblStops = new JLabel("Stops:");
		cbStops = new JComboBox<String>();
		
		cbFlightNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (String.valueOf(cbFlightNumber.getSelectedItem()).trim().equals(""))
					setStatus("", "");
				else {
					System.out.println(Integer.parseInt(String.valueOf(cbFlightNumber.getSelectedItem())));
					
					ArrayList<Stop> stops = airline.getStops(Integer.parseInt(String.valueOf(cbFlightNumber.getSelectedItem())));
					
					ArrayList<String> stopCities = new ArrayList<String>();
					for (int i = 0; i < stops.size(); i++) {
						stopCities.add(stops.get(i).getCity());
					}
					
					cbStops.setModel(new DefaultComboBoxModel<String>(stopCities.toArray(new String[airline.getStops(Integer.parseInt(String.valueOf(cbFlightNumber.getSelectedItem()))).size()])));
				}
			}
		});
		cbFlightNumber.setModel(new DefaultComboBoxModel<String>(airline.getFlightNumbers().toArray(new String[airline.getFlightNumbers().size()])));
		frmModifyFlight.getContentPane().add(cbFlightNumber);
		
		lblStops.setHorizontalAlignment(SwingConstants.CENTER);
		frmModifyFlight.getContentPane().add(lblStops);
		
		cbStops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(cbStops.getSelectedItem()).trim().equals(""))
					setStatus("", "");
				else {
					ArrayList<Stop> stops = airline.getStops(Integer.parseInt(String.valueOf(cbFlightNumber.getSelectedItem())));
					
					String city = stops.get(cbStops.getSelectedIndex()).getCity();
					
					System.out.println(city);
				}
			}
		});
		
		frmModifyFlight.getContentPane().add(cbStops);
		
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
		
//		cbFlightNumber.setSelectedIndex(1);
//		tfDepartureDateTime.setText("04-25-2013 10:00");
//		tfArrivalDateTime.setText("04-26-2013 01:00");
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(cbFlightNumber.getSelectedItem()).trim().equals(""))
					setStatus("", "Required field(s)");
				else if (tfDepartureDateTime.getText().trim().equals(""))
					setStatus("", "Required field(s)");
				else if (tfArrivalDateTime.getText().trim().equals(""))
					setStatus("", "Required field(s)");
				else if(!Pattern.matches("[0-9]{2}-[0-9]{2}-[0-9]{4} [0-9]{2}:[0-9]{2}", tfDepartureDateTime.getText().trim()))
					setStatus("", "Invalid departure date");
				else if(!Pattern.matches("[0-9]{2}-[0-9]{2}-[0-9]{4} [0-9]{2}:[0-9]{2}", tfArrivalDateTime.getText().trim()))
					setStatus("", "Invalid arrival date");
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
						setStatus("Failed", "");
					else
						setStatus("Updated", "");
				}
			}
		});
		frmModifyFlight.getContentPane().add(btnSubmit);
		
		lblSubmitStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmModifyFlight.getContentPane().add(lblSubmitStatus);
	}

	private void setStatus(String flightStatus, String submitStatus) {
		lblFlightStatusStatus.setText(flightStatus);
		lblSubmitStatus.setText(submitStatus);
	}
}
