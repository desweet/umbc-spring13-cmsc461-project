package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUIScheduleFlight {

	JFrame frmScheduleFlight;
	private JTextField tfFlightNumber;
	private JTextField tfDate;
	private JTextField tfDepartureTime;
	private JTextField tfArrivalTime;
	private JButton btnSubmit;
	private JLabel lblSubmitStatus;
	private JLabel lblFlightStatus;
	private JLabel lblFlightStatusStatus;
	private JComboBox<String> cbSource;
	private JComboBox<String> cbDestination;
	private JLabel lblAircraftType;
	private JComboBox<String> cbAircraftType;
	private JButton btnAddCities;
	private JLabel lblBlank;
	
	@SuppressWarnings("rawtypes")
	private JComboBox[] cities = new JComboBox[99];
	
	private JTextField[] cityArrival = new JTextField[99];
	private JTextField[] cityDeparture = new JTextField[99];
	
	private int index = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIScheduleFlight window = new GUIScheduleFlight();
					window.frmScheduleFlight.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIScheduleFlight() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScheduleFlight = new JFrame();
		frmScheduleFlight.setResizable(false);
		frmScheduleFlight.setTitle("Schedule Flight");
		frmScheduleFlight.setBounds(100, 100, 400, 300);
		frmScheduleFlight.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmScheduleFlight.setLocationRelativeTo(null);
		frmScheduleFlight.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		final Airline airline = new Airline();
		
		JLabel lblFlightNumber = new JLabel("Flight number:");
		lblFlightNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblFlightNumber);
		
		tfFlightNumber = new JTextField();
		tfFlightNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(tfFlightNumber);
		tfFlightNumber.setColumns(10);
		
		JLabel lblDate = new JLabel("Date (mm-dd-yyyy):");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblDate);
		
		tfDate = new JTextField();
		tfDate.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(tfDate);
		tfDate.setColumns(10);
		
		JLabel lblSource = new JLabel("Source:");
		lblSource.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblSource);
		
		cbSource = new JComboBox<String>();
		cbSource.setModel(new DefaultComboBoxModel<String>(new String[] {"", "New York, NY", "Washington, D.C.", "Baltimore, MD", "Los Angeles, CA", "San Francisco, CA", "Seattle, WA", "Chicago, IL", "Newark, NJ", "Detroit, MI", "Boston, MA", "Raleigh, NC", "Tucson, AZ", "Columbus, OH", "Tampa, FL", "Houston, TX", "Las Vegas, NV", "Minneapolis, MN", "Atlanta, GA", "Pittsburgh, PA", "Toronto, Canada"}));
		frmScheduleFlight.getContentPane().add(cbSource);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblDestination);
		
		cbDestination = new JComboBox<String>();
		cbDestination.setModel(new DefaultComboBoxModel<String>(new String[] {"", "New York, NY", "Washington, D.C.", "Baltimore, MD", "Los Angeles, CA", "San Francisco, CA", "Seattle, WA", "Chicago, IL", "Newark, NJ", "Detroit, MI", "Boston, MA", "Raleigh, NC", "Tucson, AZ", "Columbus, OH", "Tampa, FL", "Houston, TX", "Las Vegas, NV", "Minneapolis, MN", "Atlanta, GA", "Pittsburgh, PA", "Toronto, Canada"}));
		frmScheduleFlight.getContentPane().add(cbDestination);
		
		lblAircraftType = new JLabel("Aircraft type:");
		lblAircraftType.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblAircraftType);
		
		cbAircraftType = new JComboBox<String>();
		cbAircraftType.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Boeing  737", "Boeing  747", "Boeing  767", "Airbus 330", "Airbus 340", "Airbus 350", "Airbus 380"}));
		frmScheduleFlight.getContentPane().add(cbAircraftType);
		
		JLabel lblDepartureTime = new JLabel("Departure date/time:");
		lblDepartureTime.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblDepartureTime);
		
		tfDepartureTime = new JTextField();
		tfDepartureTime.setHorizontalAlignment(SwingConstants.CENTER);
		tfDepartureTime.setColumns(10);
		frmScheduleFlight.getContentPane().add(tfDepartureTime);
		
		JLabel lblArrivalTime = new JLabel("Arrival date/time:");
		lblArrivalTime.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblArrivalTime);
		
		tfArrivalTime = new JTextField();
		tfArrivalTime.setHorizontalAlignment(SwingConstants.CENTER);
		tfArrivalTime.setColumns(10);
		frmScheduleFlight.getContentPane().add(tfArrivalTime);
		
		lblFlightStatus = new JLabel("Flight status:");
		lblFlightStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblFlightStatus);
		
		lblFlightStatusStatus = new JLabel("");
		lblFlightStatusStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblFlightStatusStatus);
		
		lblSubmitStatus = new JLabel("");
		btnSubmit = new JButton("Submit");
		
//		tfFlightNumber.setText("1");
//		tfDate.setText("04-24-2013");
//		cbSource.setSelectedIndex(1);
//		cbDestination.setSelectedIndex(2);
//		cbAircraftType.setSelectedIndex(1);
//		tfDepartureTime.setText("04-25-2013 10:00");
//		tfArrivalTime.setText("04-26-2013 01:00");
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfFlightNumber.getText().trim().equals(""))
					setStatus("", "Required field(s)");
				else if (tfDate.getText().trim().equals(""))
					setStatus("", "Required field(s)");
				else if (String.valueOf(cbSource.getSelectedItem()).trim().equals(""))
					setStatus("", "Required field(s)");
				else if (String.valueOf(cbDestination.getSelectedItem()).trim().equals(""))
					setStatus("", "Required field(s)");
				else if (String.valueOf(cbAircraftType.getSelectedItem()).trim().equals(""))
					setStatus("", "Required field(s)");
				else if (tfDepartureTime.getText().trim().equals(""))
					setStatus("", "Required field(s)");
				else if (tfArrivalTime.getText().trim().equals(""))
					setStatus("", "Required field(s)");
				else if (!complete().equals(""))
					setStatus("", complete());
				else if(!Pattern.matches("[0-9]+", tfFlightNumber.getText().trim()))
					setStatus("", "Invalid flight number");
				else if(!Pattern.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}", tfDate.getText().trim()))
					setStatus("", "Invalid date");
				else if(!Pattern.matches("[0-9]{2}-[0-9]{2}-[0-9]{4} [0-9]{2}:[0-9]{2}", tfDepartureTime.getText().trim()))
					setStatus("", "Invalid departure date");
				else if(!Pattern.matches("[0-9]{2}-[0-9]{2}-[0-9]{4} [0-9]{2}:[0-9]{2}", tfArrivalTime.getText().trim()))
					setStatus("", "Invalid arrival date");
				else {
					int flightNumber = Integer.parseInt(tfFlightNumber.getText());
					String source = String.valueOf(cbSource.getSelectedItem());
					String destination = String.valueOf(cbDestination.getSelectedItem());
					String aircraftType = String.valueOf(cbAircraftType.getSelectedItem());
					
					Date date = null;
					Date departureTime = null;
					Date arrivalTime = null;
					
					try {
						date = new SimpleDateFormat("MM-dd-yyyy").parse(tfDate.getText());
						departureTime = new SimpleDateFormat("MM-dd-yyyy HH:mm").parse(tfDepartureTime.getText());
						arrivalTime = new SimpleDateFormat("MM-dd-yyyy HH:mm").parse(tfArrivalTime.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					Flight flight = new Flight(flightNumber, date, aircraftType, source, destination, departureTime, arrivalTime);
					
					ArrayList<Stop> stops = new ArrayList<Stop>();
					
					if (index > 0) {
						for (int i = 0; i < index; i++) {
							Date arrival = null;
							Date departure = null;
							
							try {
								arrival = new SimpleDateFormat("MM-dd-yyyy HH:mm").parse(cityArrival[i].getText());
								departure = new SimpleDateFormat("MM-dd-yyyy HH:mm").parse(cityDeparture[i].getText());
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							
							// i or i+1?
							stops.add(new Stop(flightNumber, i, String.valueOf(cities[i].getSelectedItem()), arrival, departure));
						}
					}
					
					boolean flightStatus = airline.scheduleFlight(flight, stops);
//					boolean flightStatus = false;
					
					if (flightStatus == false)
						setStatus("Failed", "");
					else
						setStatus("Created", "");
				}
			}
		});
		frmScheduleFlight.getContentPane().add(btnSubmit);
		
		lblSubmitStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblSubmitStatus);
		
		btnAddCities = new JButton("Add Cities");
		btnAddCities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cities[index] = new JComboBox<String>(new String[] {"", "New York, NY", "Washington, D.C.", "Baltimore, MD", "Los Angeles, CA", "San Francisco, CA", "Seattle, WA", "Chicago, IL", "Newark, NJ", "Detroit, MI", "Boston, MA", "Raleigh, NC", "Tucson, AZ", "Columbus, OH", "Tampa, FL", "Houston, TX", "Las Vegas, NV", "Minneapolis, MN", "Atlanta, GA", "Pittsburgh, PA", "Toronto, Canada"});
				cityArrival[index] = new JTextField();
				cityDeparture[index] = new JTextField();
				
				cityArrival[index].setHorizontalAlignment(SwingConstants.CENTER);
				cityDeparture[index].setHorizontalAlignment(SwingConstants.CENTER);
				
				frmScheduleFlight.getContentPane().add(new JLabel("Intermediate city:"));
				frmScheduleFlight.getContentPane().add(cities[index]);
				
				frmScheduleFlight.getContentPane().add(new JLabel("Intermediate arrival date/time:"));
				frmScheduleFlight.getContentPane().add(cityArrival[index]);
				
				frmScheduleFlight.getContentPane().add(new JLabel("Intermediate departure date/time:"));
				frmScheduleFlight.getContentPane().add(cityDeparture[index]);
				
				index++;
				
				frmScheduleFlight.setSize(frmScheduleFlight.getWidth(), frmScheduleFlight.getHeight() + (btnSubmit.getHeight() * 3));
			}
		});
		frmScheduleFlight.getContentPane().add(btnAddCities);
		
		lblBlank = new JLabel("");
		frmScheduleFlight.getContentPane().add(lblBlank);
	}
	
	private String complete() {
		String status = "";
		if (index > 0) {
			for (int i = 0; i < index; i++) {
				if (String.valueOf(cities[i].getSelectedItem()).trim().equals(""))
					status = "Required field(s)";
				else if (cityArrival[i].getText().trim().equals(""))
					status = "Required field(s)";
				else if (cityDeparture[i].getText().trim().equals(""))
					status = "Required field(s)";
				else if(!Pattern.matches("[0-9]{2}-[0-9]{2}-[0-9]{4} [0-9]{2}:[0-9]{2}", cityArrival[i].getText().trim()))
					status = "Invalid arrival date";
				else if(!Pattern.matches("[0-9]{2}-[0-9]{2}-[0-9]{4} [0-9]{2}:[0-9]{2}", cityDeparture[i].getText().trim()))
					status = "Invalid departure date";
			}
		}
		return status;
	}
	
	private void setStatus(String flightStatus, String submitStatus) {
		lblFlightStatusStatus.setText(flightStatus);
		lblSubmitStatus.setText(submitStatus);
	}
}
