package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class GUILogin {

	private JFrame frmLogin;
	private JTextField tfUsername;
	private JButton btnLogin;
	private JLabel lblLoginStatus;
	private JPasswordField tfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILogin window = new GUILogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUILogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Airline Manager");
		frmLogin.setBounds(100, 100, 300, 150);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.setLocationRelativeTo(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		
		tfUsername = new JTextField();
		tfUsername.setHorizontalAlignment(SwingConstants.CENTER);
		tfUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblLoginStatus = new JLabel("");
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tfUsername.getText().trim().equals(""))
					lblLoginStatus.setText("Required field(s)");
				else if (new String(tfPassword.getPassword()).equals(""))
					lblLoginStatus.setText("Required field(s)");
				else {
					if (tfUsername.getText().equals("admin") && new String(tfPassword.getPassword()).equals("password")) {
						frmLogin.dispose();
						try {
							GUIMain main = new GUIMain();
							main.frmMain.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					else
						lblLoginStatus.setText("Incorrect details");
				}
					
			}
		});
		frmLogin.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		frmLogin.getContentPane().add(lblUsername);
		frmLogin.getContentPane().add(tfUsername);
		frmLogin.getContentPane().add(lblPassword);
		
		tfPassword = new JPasswordField();
		tfPassword.setHorizontalAlignment(SwingConstants.CENTER);
		frmLogin.getContentPane().add(tfPassword);
		frmLogin.getContentPane().add(btnLogin);
		
		lblLoginStatus.setHorizontalAlignment(SwingConstants.CENTER);
		frmLogin.getContentPane().add(lblLoginStatus);
	}

}
