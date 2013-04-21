package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class GUIAbout {

	JFrame frmAbout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAbout window = new GUIAbout();
					window.frmAbout.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIAbout() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAbout = new JFrame();
		frmAbout.setResizable(false);
		frmAbout.setTitle("About");
		frmAbout.setBounds(100, 100, 250, 160);
		frmAbout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAbout.setLocationRelativeTo(null);
		frmAbout.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblEvanNehring = new JLabel("Evan Nehring");
		lblEvanNehring.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvanNehring.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmAbout.getContentPane().add(lblEvanNehring);
		
		JLabel lblMatthewPodhorniak = new JLabel("Matthew Podhorniak");
		lblMatthewPodhorniak.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatthewPodhorniak.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmAbout.getContentPane().add(lblMatthewPodhorniak);
		
		JLabel lblDerekSweet = new JLabel("Derek Sweet");
		lblDerekSweet.setHorizontalAlignment(SwingConstants.CENTER);
		lblDerekSweet.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmAbout.getContentPane().add(lblDerekSweet);
		
		JLabel lblStevenZubrowski = new JLabel("Stephen Zubrowski");
		lblStevenZubrowski.setHorizontalAlignment(SwingConstants.CENTER);
		lblStevenZubrowski.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmAbout.getContentPane().add(lblStevenZubrowski);
	}

}
