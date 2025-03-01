package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controller.LoginActionButton;

public class Login_Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btn_TeacherLogin;
	public JButton btn_StudentAttendance;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Menu frame = new Login_Menu();
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
	public Login_Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login_Menu.class.getResource("/Resources/CAF_Logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Background = new JLabel("");
		lbl_Background.setIcon(new ImageIcon(Login_Menu.class.getResource("/Resources/Login Menu Background.png")));
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
		lbl_TeacherIcon.setBounds(431, 131, 76, 47);
		panel.add(lbl_TeacherIcon);
		
		JLabel lbl_TeacherLogin = new JLabel("Teacher Login");
		lbl_TeacherLogin.setForeground(new Color(255, 255, 255));
		lbl_TeacherLogin.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_TeacherLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TeacherLogin.setBounds(403, 187, 131, 35);
		panel.add(lbl_TeacherLogin);
		LoginActionButton controller = new LoginActionButton(this);
		
	    btn_TeacherLogin = new JButton("");
		btn_TeacherLogin.setBounds(357, 110, 223, 128);
		btn_TeacherLogin.setBackground(new Color(0, 0, 0, 0));
		btn_TeacherLogin.setOpaque(false);
		btn_TeacherLogin.addActionListener(controller);
		panel.add(btn_TeacherLogin);
		
		
		
		JLabel lbl_StudentIcon = new JLabel("");
		lbl_StudentIcon.setIcon(new ImageIcon(Login_Menu.class.getResource("/Resources/Student_Icon.png")));
		lbl_StudentIcon.setBounds(439, 266, 63, 67);
		panel.add(lbl_StudentIcon);
		
		JLabel lbl_StudentAttendance = new JLabel("Student Attendance");
		lbl_StudentAttendance.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_StudentAttendance.setForeground(Color.WHITE);
		lbl_StudentAttendance.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_StudentAttendance.setBounds(373, 333, 194, 35);
		panel.add(lbl_StudentAttendance);
		
	    btn_StudentAttendance = new JButton("");
		btn_StudentAttendance.setBackground(new Color(0, 0, 0, 0));
		btn_StudentAttendance.setOpaque(false);
		btn_StudentAttendance.setBounds(357, 253, 223, 128);
		btn_StudentAttendance.addActionListener(controller);
		panel.add(btn_StudentAttendance);
	}
}
