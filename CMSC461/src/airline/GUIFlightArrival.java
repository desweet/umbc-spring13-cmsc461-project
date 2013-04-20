package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Point;

public class GUIFlightArrival {

	JFrame frmFlightArrival;
	private JTextField textField;
	private JLabel label_1;
	private JLabel lblStops;
	private JLabel label_3;
	private JLabel lblTimeTaken;
	private JLabel label_2;
	private JButton btnGetFlightInfo;
	private JLabel label_4;

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
		
		JLabel label = new JLabel("Flight number:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		frmFlightArrival.getContentPane().add(textField);
		
		JLabel lblNumberOfPassengers = new JLabel("Passengers:");
		lblNumberOfPassengers.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(lblNumberOfPassengers);
		
		label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(label_1);
		
		lblStops = new JLabel("Stops:");
		lblStops.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(lblStops);
		
		label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(label_3);
		
		lblTimeTaken = new JLabel("Time taken:");
		lblTimeTaken.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(lblTimeTaken);
		
		label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(label_2);
		
		btnGetFlightInfo = new JButton("Get Stats");
		btnGetFlightInfo.setHorizontalTextPosition(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(btnGetFlightInfo);
		
		label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		frmFlightArrival.getContentPane().add(label_4);
	}

}
