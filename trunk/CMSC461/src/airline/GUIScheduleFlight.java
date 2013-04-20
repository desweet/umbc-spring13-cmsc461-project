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
import java.util.Date;
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
	private JComboBox cbSource;
	private JComboBox cbDestination;

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
		frmScheduleFlight.setBounds(100, 100, 300, 250);
		frmScheduleFlight.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmScheduleFlight.setLocationRelativeTo(null);
		frmScheduleFlight.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblFlightNumber = new JLabel("Flight number:");
		lblFlightNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblFlightNumber);
		
		tfFlightNumber = new JTextField();
		tfFlightNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(tfFlightNumber);
		tfFlightNumber.setColumns(10);
		
		JLabel lblDate = new JLabel("Date (mm/dd/yyyy):");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblDate);
		
		tfDate = new JTextField();
		tfDate.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(tfDate);
		tfDate.setColumns(10);
		
		JLabel lblSource = new JLabel("Source:");
		lblSource.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblSource);
		
		cbSource = new JComboBox();
		cbSource.setModel(new DefaultComboBoxModel(new String[] {"", "New York, NY", "Washington, D.C.", "Baltimore, MD", "Los Angeles, CA", "San Francisco, CA", "Seattle, WA", "Chicago, IL", "Newark, NJ", "Detroit, MI", "Boston, MA", "Raleigh, NC", "Tucson, AZ", "Columbus, OH", "Tampa, FL", "Houston, TX", "Las Vegas, NV", "Minneapolis, MN", "Atlanta, GA", "Pittsburgh, PA", "Toronto, Canada"}));
		frmScheduleFlight.getContentPane().add(cbSource);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblDestination);
		
		cbDestination = new JComboBox();
		cbDestination.setModel(new DefaultComboBoxModel(new String[] {"", "New York, NY", "Washington, D.C.", "Baltimore, MD", "Los Angeles, CA", "San Francisco, CA", "Seattle, WA", "Chicago, IL", "Newark, NJ", "Detroit, MI", "Boston, MA", "Raleigh, NC", "Tucson, AZ", "Columbus, OH", "Tampa, FL", "Houston, TX", "Las Vegas, NV", "Minneapolis, MN", "Atlanta, GA", "Pittsburgh, PA", "Toronto, Canada"}));
		frmScheduleFlight.getContentPane().add(cbDestination);
		
		JLabel lblDepartureTime = new JLabel("Departure time:");
		lblDepartureTime.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblDepartureTime);
		
		tfDepartureTime = new JTextField();
		tfDepartureTime.setHorizontalAlignment(SwingConstants.CENTER);
		tfDepartureTime.setColumns(10);
		frmScheduleFlight.getContentPane().add(tfDepartureTime);
		
		JLabel lblArrivalTime = new JLabel("Arrival time:");
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
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfFlightNumber.getText().trim().equals(""))
					lblSubmitStatus.setText("Required field(s)");
				else if (tfDate.getText().trim().equals(""))
					lblSubmitStatus.setText("Required field(s)");
				else if (String.valueOf(cbSource.getSelectedItem()).trim().equals(""))
					lblSubmitStatus.setText("Required field(s)");
				else if (String.valueOf(cbDestination.getSelectedItem()).trim().equals(""))
					lblSubmitStatus.setText("Required field(s)");
				else if (tfDepartureTime.getText().trim().equals(""))
					lblSubmitStatus.setText("Required field(s)");
				else if (tfArrivalTime.getText().trim().equals(""))
					lblSubmitStatus.setText("Required field(s)");
				else {
					int flightNumber = Integer.parseInt(tfFlightNumber.getText());
					String source = String.valueOf(cbSource.getSelectedItem());
					String destination = String.valueOf(cbDestination.getSelectedItem());
					String departureTime = tfDepartureTime.getText();
					String arrivalTime = tfArrivalTime.getText();
					Date date = null;
					
					try {
						date = new SimpleDateFormat("MM-DD-YYYY").parse(tfDate.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					lblSubmitStatus.setText("");
					System.out.println(date);
				}
			}
		});
		frmScheduleFlight.getContentPane().add(btnSubmit);
		
		lblSubmitStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblSubmitStatus);
	}

}
