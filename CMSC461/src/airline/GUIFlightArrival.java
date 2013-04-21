package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class GUIFlightArrival {

	JFrame frmFlightArrival;
	private JLabel lblPassengersStatus;
	private JLabel lblStops;
	private JLabel lblStopsStatus;
	private JLabel lblTimeTaken;
	private JLabel lblTimeTakenStatus;
	private JButton btnGetStats;
	private JLabel lblGetStatsStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIFlightArrival window = new GUIFlightArrival();
					window.frmFlightArrival.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIFlightArrival() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFlightArrival = new JFrame();
		frmFlightArrival.setResizable(false);
		frmFlightArrival.setTitle("Flight Arrival");
		frmFlightArrival.setBounds(100, 100, 200, 160);
		frmFlightArrival.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFlightArrival.setLocationRelativeTo(null);
		frmFlightArrival.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		final Airline airline = new Airline();
		
		JLabel lblFlightNumber = new JLabel("Flight number:");
		lblFlightNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(lblFlightNumber);
		
		final JComboBox<String> cbFlightNumber = new JComboBox<String>();
		cbFlightNumber.setModel(new DefaultComboBoxModel<String>(airline.getFlightNumbers().toArray(new String[airline.getFlightNumbers().size()])));
		frmFlightArrival.getContentPane().add(cbFlightNumber);
		
		JLabel lblPassengers = new JLabel("Passengers:");
		lblPassengers.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(lblPassengers);
		
		lblPassengersStatus = new JLabel("");
		lblPassengersStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(lblPassengersStatus);
		
		lblStops = new JLabel("Stops:");
		lblStops.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(lblStops);
		
		lblStopsStatus = new JLabel("");
		lblStopsStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(lblStopsStatus);
		
		lblTimeTaken = new JLabel("Time taken:");
		lblTimeTaken.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(lblTimeTaken);
		
		lblTimeTakenStatus = new JLabel("");
		lblTimeTakenStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(lblTimeTakenStatus);
		
		btnGetStats = new JButton("Get Stats");
		btnGetStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(cbFlightNumber.getSelectedItem()).trim().equals(""))
					lblGetStatsStatus.setText("Required field(s)");
				
//				get flight object from db
//				get passengers from object
//				get stops from object (total number of stops)
//				get time taken from object or calculate (arrival - departure)
				
				lblGetStatsStatus.setText("Successfully submitted");
			}
		});
		btnGetStats.setHorizontalTextPosition(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(btnGetStats);
		
		lblGetStatsStatus = new JLabel("");
		lblGetStatsStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(lblGetStatsStatus);
	}

}
