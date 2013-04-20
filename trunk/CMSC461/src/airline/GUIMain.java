package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIMain {

	private JFrame frmAirlineManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain window = new GUIMain();
					window.frmAirlineManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAirlineManager = new JFrame();
		frmAirlineManager.setResizable(false);
		frmAirlineManager.setTitle("Airline Manager");
		frmAirlineManager.setBounds(100, 100, 450, 300);
		frmAirlineManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAirlineManager.setLocationRelativeTo(null);
		
		JButton btnScheduleFlight = new JButton("Schedule Flight");
		btnScheduleFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GUIScheduleFlight scheduleFlight = new GUIScheduleFlight();
					scheduleFlight.frmScheduleFlight.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnScheduleFlight.setBounds(10, 11, 200, 70);
		
		JButton btnBookTicket = new JButton("Book Ticket");
		btnBookTicket.setBounds(224, 11, 200, 70);
		btnBookTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GUIBookTicket bookTicket = new GUIBookTicket();
					bookTicket.frmBookTicket.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		frmAirlineManager.getContentPane().setLayout(null);
		frmAirlineManager.getContentPane().add(btnScheduleFlight);
		frmAirlineManager.getContentPane().add(btnBookTicket);
		
		JButton btnCheckIn = new JButton("Check In");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GUICheckIn checkIn = new GUICheckIn();
					checkIn.frmCheckIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnCheckIn.setBounds(224, 92, 200, 70);
		frmAirlineManager.getContentPane().add(btnCheckIn);
		
		JButton btnModifyFlight = new JButton("Modify Flight");
		btnModifyFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GUIModifyFlight modifyFlight = new GUIModifyFlight();
					modifyFlight.frmModifyFlight.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnModifyFlight.setBounds(10, 92, 200, 70);
		frmAirlineManager.getContentPane().add(btnModifyFlight);
		
		JButton btnFlightArrival = new JButton("Flight Arrival");
		btnFlightArrival.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GUIFlightArrival flightArrival = new GUIFlightArrival();
					flightArrival.frmFlightArrival.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnFlightArrival.setBounds(10, 173, 200, 70);
		frmAirlineManager.getContentPane().add(btnFlightArrival);
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GUIAbout about = new GUIAbout();
					about.frmAbout.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnAbout.setBounds(224, 173, 200, 70);
		frmAirlineManager.getContentPane().add(btnAbout);
	}
}
