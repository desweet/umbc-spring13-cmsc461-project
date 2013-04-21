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

public class GUIModifyFlight {

	JFrame frmModifyFlight;
	private JTextField tfDepartureDateTime;
	private JLabel lblArrivalDateTime;
	private JTextField tfArrivalDateTime;
	private JButton btnSubmit;
	private JLabel tfSubmitStatus;

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
		frmModifyFlight.setBounds(100, 100, 300, 150);
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
		
		btnSubmit = new JButton("Submit");
		frmModifyFlight.getContentPane().add(btnSubmit);
		
		tfSubmitStatus = new JLabel("");
		tfSubmitStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmModifyFlight.getContentPane().add(tfSubmitStatus);
	}

}
