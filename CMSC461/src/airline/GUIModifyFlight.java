package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GUIModifyFlight {

	JFrame frmModifyFlight;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblArrivalDatetime;
	private JTextField textField_2;
	private JButton btnSubmit;
	private JLabel label;

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
		
		JLabel lblFlightNumber = new JLabel("Flight number:");
		lblFlightNumber.setHorizontalAlignment(SwingConstants.CENTER);
		frmModifyFlight.getContentPane().add(lblFlightNumber);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		frmModifyFlight.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDepartureDatetime = new JLabel("Departure date/time:");
		lblDepartureDatetime.setHorizontalAlignment(SwingConstants.CENTER);
		frmModifyFlight.getContentPane().add(lblDepartureDatetime);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		frmModifyFlight.getContentPane().add(textField_1);
		
		lblArrivalDatetime = new JLabel("Arrival date/time:");
		lblArrivalDatetime.setHorizontalAlignment(SwingConstants.CENTER);
		frmModifyFlight.getContentPane().add(lblArrivalDatetime);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		frmModifyFlight.getContentPane().add(textField_2);
		
		btnSubmit = new JButton("Submit");
		frmModifyFlight.getContentPane().add(btnSubmit);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frmModifyFlight.getContentPane().add(label);
	}

}
