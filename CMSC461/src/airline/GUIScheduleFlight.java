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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnSubmit;
	private JLabel label;

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
		
		JLabel lblNewLabel = new JLabel("Flight number:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Date:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Source:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Destination:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Departure time:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		frmScheduleFlight.getContentPane().add(textField_4);
		
		JLabel lblArrivalTime = new JLabel("Arrival time:");
		lblArrivalTime.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(lblArrivalTime);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		frmScheduleFlight.getContentPane().add(textField_5);
		
		btnSubmit = new JButton("Submit");
		frmScheduleFlight.getContentPane().add(btnSubmit);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frmScheduleFlight.getContentPane().add(label);
	}

}
