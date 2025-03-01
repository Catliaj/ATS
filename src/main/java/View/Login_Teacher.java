package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import Controller.teacherLogin;


public class Login_Teacher extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_Username;
	public JPasswordField passwordField;
	public JButton btn_Login;
	public JButton btn_Back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Teacher frame = new Login_Teacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_Teacher() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login_Teacher.class.getResource("/Resources/CAF_Logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Background = new JLabel("");
		lbl_Background.setIcon(new ImageIcon(Login_Teacher.class.getResource("/Resources/Teacher Login Background.png")));
		lbl_Background.setBounds(0, 0, 685, 490);
		contentPane.add(lbl_Background);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color( 0, 0, 0, 0));
		panel.setBounds(0, 0, 685, 490);
		lbl_Background.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lbl_CompanyLogo = new JLabel("");
		lbl_CompanyLogo.setIcon(new ImageIcon(Login_Menu.class.getResource("/Resources/Logo_Big.png")));
		lbl_CompanyLogo.setBounds(164, 116, 105, 125);
		panel.add(lbl_CompanyLogo);
		
		JLabel lbl_ABM_1 = new JLabel("ATTENDANCE");
		lbl_ABM_1.setForeground(new Color(255, 255, 255));
		lbl_ABM_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ABM_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lbl_ABM_1.setBounds(131, 252, 184, 40);
		panel.add(lbl_ABM_1);
		
		JLabel lbl_ABM_2 = new JLabel("TRACKER");
		lbl_ABM_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ABM_2.setForeground(Color.WHITE);
		lbl_ABM_2.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lbl_ABM_2.setBounds(131, 289, 184, 40);
		panel.add(lbl_ABM_2);
		
		JLabel lbl_ABM_3 = new JLabel("SYSTEM");
		lbl_ABM_3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ABM_3.setForeground(Color.WHITE);
		lbl_ABM_3.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lbl_ABM_3.setBounds(131, 328, 184, 40);
		panel.add(lbl_ABM_3);
		
		
		
		JLabel lbl_TeacherIcon = new JLabel("");
		lbl_TeacherIcon.setIcon(new ImageIcon(Login_Menu.class.getResource("/Resources/Teacher_Icon.png")));
		lbl_TeacherIcon.setBounds(437, 90, 76, 47);
		panel.add(lbl_TeacherIcon);
		
		JLabel lbl_TeacherLogin = new JLabel("Teacher Login");
		lbl_TeacherLogin.setForeground(new Color(255, 255, 255));
		lbl_TeacherLogin.setFont(new Font("Brush Script MT", Font.BOLD, 30));
		lbl_TeacherLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TeacherLogin.setBounds(390, 148, 171, 35);
		panel.add(lbl_TeacherLogin);
		
		
		
		
		JLabel lbl_Username = new JLabel("Username:");
		lbl_Username.setVerticalAlignment(SwingConstants.TOP);
		lbl_Username.setForeground(Color.WHITE);
		lbl_Username.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_Username.setBounds(390, 195, 131, 35);
		panel.add(lbl_Username);
		
		textField_Username = new JTextField();
		textField_Username.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_Username.setForeground(new Color(57, 57, 57));
		textField_Username.setBackground(new Color(255, 242, 226));
		textField_Username.setBounds(390, 223, 171, 25);
		panel.add(textField_Username);
		textField_Username.setColumns(10);
		
		
		
		JLabel lbl_Password = new JLabel("Password:");
		lbl_Password.setVerticalAlignment(SwingConstants.TOP);
		lbl_Password.setForeground(Color.WHITE);
		lbl_Password.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_Password.setBounds(390, 257, 131, 35);
		panel.add(lbl_Password);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setForeground(new Color(57, 57, 57));
		passwordField.setBackground(new Color(255, 242, 226));
		passwordField.setBounds(390, 286, 171, 25);
		panel.add(passwordField);
		
		
		
	    btn_Login = new JButton("Log-in");
		btn_Login.setForeground(new Color(255, 214, 0));
		btn_Login.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		btn_Login.setBackground(new Color(174, 122, 52));
		btn_Login.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
		btn_Login.setFocusPainted(false);
		btn_Login.setBounds(429, 336, 92, 20);
		panel.add(btn_Login);
		
	    btn_Back = new JButton("Back");
		btn_Back.setForeground(new Color(255, 214, 0));
		btn_Back.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		btn_Back.setBackground(new Color(174, 122, 52));
		btn_Back.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
		btn_Back.setFocusPainted(false);
		btn_Back.setBounds(429, 366, 92, 20);
		
		// action listener for the buttons
		teacherLogin controller = new teacherLogin(this);
		btn_Login.addActionListener(controller);
		btn_Back.addActionListener(controller);
		
		panel.add(btn_Back);
	}
}
