package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class GUIScheduleFlight {

	JFrame frmScheduleFlight;
	private JTextField tfFlightNumber;
	private JTextField tfDate;
	private JTextField tfSource;
	private JTextField tfDestination;
	private JTextField tfDepartureTime;
	private JTextField tfArrivalTime;
	private JButton btnSubmit;
	private JLabel lblSubmitStatus;

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
		frmScheduleFlight.setBounds(100, 100, 300, 200);
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
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblDate);
		
		tfDate = new JTextField();
		tfDate.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(tfDate);
		tfDate.setColumns(10);
		
		JLabel lblSource = new JLabel("Source:");
		lblSource.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblSource);
		
		tfSource = new JTextField();
		tfSource.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(tfSource);
		tfSource.setColumns(10);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblDestination);
		
		tfDestination = new JTextField();
		tfDestination.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(tfDestination);
		tfDestination.setColumns(10);
		
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
		
		btnSubmit = new JButton("Submit");
		frmScheduleFlight.getContentPane().add(btnSubmit);
		
		lblSubmitStatus = new JLabel("");
		lblSubmitStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblSubmitStatus);
	}

}
