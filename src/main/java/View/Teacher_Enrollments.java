package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.time.Year;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import Controller.SidePanelButtonActionListener;
import Controller.TeacherEnrollmentActionListener;

public class Teacher_Enrollments extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_SRCode;
	public JTextField textField_FirstName;
	public JTextField textField_MidIn;
	public JTextField textField_Surname;
	public JTextField textField_Section;
	public JTextField textField_email;
	public JTextField textField_Image;
	public JTextField textField_SRCode_Confirm;
	public JTextField textField_Name_Confirm;
	public JTextField textField_Section_Confirm;
	public JTextField textField_Email_Confirm;
	public JButton btn_Dashboard;
	public JButton btn_Attendance;
	public JButton btn_ClassRoll;
	public JButton btn_Enrollment;
	public JButton btn_Classes;
	public JButton btn_Exit;
	public JButton btn_Enroll;
	public JButton btn_Confirm;
	public JButton btn_BrowseImg;
	public JButton btn_Clear;
	public JLabel lbl_QR;
	public JLabel picture;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher_Enrollments frame = new Teacher_Enrollments();
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
	public Teacher_Enrollments() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1334, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Background = new JLabel("");
		lbl_Background.setIcon(new ImageIcon(Teacher_Enrollments.class.getResource("/Resources/Background for Enrollment and Student Checkin_Checkout.png")));
		lbl_Background.setBounds(0, 0, 1320, 745);
		contentPane.add(lbl_Background);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color( 0, 0, 0, 0));
		panel.setBounds(0, 0, 1320, 745);
		lbl_Background.add(panel);
		panel.setLayout(null);
	    
	    picture = new JLabel("");
	    picture.setBounds(404, 147, 124, 122);
	    panel.add(picture);
		
	    btn_Dashboard = new JButton("Dashboard");
		btn_Dashboard.setForeground(new Color(255, 255, 255));
		btn_Dashboard.setFont(new Font("Brush Script MT", Font.BOLD, 40));
		btn_Dashboard.setBackground(new Color(0, 0, 0, 0));
		btn_Dashboard.setOpaque(false);
		btn_Dashboard.setFocusPainted(false);
		btn_Dashboard.setBorder(BorderFactory.createLineBorder(new Color(174, 122, 52), 4));
		btn_Dashboard.setBounds(10, 205, 251, 69);
		panel.add(btn_Dashboard);
		
	    btn_Attendance = new JButton("Attendance");
		btn_Attendance.setForeground(Color.WHITE);
		btn_Attendance.setFont(new Font("Brush Script MT", Font.BOLD, 40));
		btn_Attendance.setFocusPainted(false);
		btn_Attendance.setBackground(new Color(0, 0, 0, 0));
		btn_Attendance.setOpaque(false);
		btn_Attendance.setBorder(BorderFactory.createLineBorder(new Color(174, 122, 52), 4));
		btn_Attendance.setBounds(10, 284, 251, 69);
		panel.add(btn_Attendance);
		
	    btn_ClassRoll = new JButton("Class Roll");
		btn_ClassRoll.setForeground(Color.WHITE);
		btn_ClassRoll.setFont(new Font("Brush Script MT", Font.BOLD, 40));
		btn_ClassRoll.setFocusPainted(false);
		btn_ClassRoll.setBackground(new Color(0, 0, 0, 0));
		btn_ClassRoll.setOpaque(false);
		btn_ClassRoll.setBorder(BorderFactory.createLineBorder(new Color(174, 122, 52), 4));
		btn_ClassRoll.setBounds(10, 363, 251, 69);
		panel.add(btn_ClassRoll);
		
	    btn_Enrollment = new JButton("Enrollment");
		btn_Enrollment.setForeground(Color.WHITE);
		btn_Enrollment.setFont(new Font("Brush Script MT", Font.BOLD, 40));
		btn_Enrollment.setFocusPainted(false);
		btn_Enrollment.setBackground(new Color(0, 0, 0, 0));
		btn_Enrollment.setOpaque(false);
		btn_Enrollment.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 4));
		btn_Enrollment.setBounds(10, 442, 251, 69);
		panel.add(btn_Enrollment);
		
	    btn_Classes = new JButton("Classes");
		btn_Classes.setForeground(Color.WHITE);
		btn_Classes.setFont(new Font("Brush Script MT", Font.BOLD, 40));
		btn_Classes.setFocusPainted(false);
		btn_Classes.setBackground(new Color(0, 0, 0, 0));
		btn_Classes.setOpaque(false);
		btn_Classes.setBorder(BorderFactory.createLineBorder(new Color(174, 122, 52), 4));
		btn_Classes.setBounds(10, 520, 251, 69);
		panel.add(btn_Classes);
		
	    btn_Exit = new JButton("Exit");
		btn_Exit.setForeground(Color.WHITE);
		btn_Exit.setFont(new Font("Brush Script MT", Font.BOLD, 40));
		btn_Exit.setFocusPainted(false);
		btn_Exit.setBackground(new Color(0, 0, 0, 0));
		btn_Exit.setOpaque(false);
		btn_Exit.setBorder(BorderFactory.createLineBorder(new Color(174, 122, 52), 4));
		btn_Exit.setBounds(10, 636, 251, 69);
		panel.add(btn_Exit);
		
		
		
		JLabel lbl_StudentImage = new JLabel("Image:");
		lbl_StudentImage.setVerticalAlignment(SwingConstants.TOP);
		lbl_StudentImage.setForeground(Color.WHITE);
		lbl_StudentImage.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_StudentImage.setBounds(546, 183, 131, 35);
		panel.add(lbl_StudentImage);
		
		textField_Image = new JTextField();
		textField_Image.setForeground(new Color(57, 57, 57));
		textField_Image.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_Image.setColumns(10);
		textField_Image.setBackground(new Color(255, 242, 226));
		textField_Image.setBounds(546, 216, 313, 25);
		panel.add(textField_Image);
		
	    btn_BrowseImg = new JButton("Browse");
		btn_BrowseImg.setForeground(new Color(255, 214, 0));
		btn_BrowseImg.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		btn_BrowseImg.setFocusPainted(false);
		btn_BrowseImg.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
		btn_BrowseImg.setBackground(new Color(174, 122, 52));
		btn_BrowseImg.setBounds(770, 251, 90, 20);
		panel.add(btn_BrowseImg);
		
		
		
		JLabel lbl_SRCode = new JLabel("SR-Code:");
		lbl_SRCode.setVerticalAlignment(SwingConstants.TOP);
		lbl_SRCode.setForeground(Color.WHITE);
		lbl_SRCode.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_SRCode.setBounds(339, 308, 131, 35);
		panel.add(lbl_SRCode);
		
		textField_SRCode = new JTextField();
		textField_SRCode.setForeground(new Color(57, 57, 57));
		textField_SRCode.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_SRCode.setColumns(10);
		textField_SRCode.setBackground(new Color(255, 242, 226));
		textField_SRCode.setBounds(339, 339, 114, 32);
		panel.add(textField_SRCode);
		
		
		
		JLabel lbl_FirstName = new JLabel("First Name:");
		lbl_FirstName.setVerticalAlignment(SwingConstants.TOP);
		lbl_FirstName.setForeground(Color.WHITE);
		lbl_FirstName.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_FirstName.setBounds(339, 386, 131, 35);
		panel.add(lbl_FirstName);
		
		textField_FirstName = new JTextField();
		textField_FirstName.setForeground(new Color(57, 57, 57));
		textField_FirstName.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_FirstName.setColumns(10);
		textField_FirstName.setBackground(new Color(255, 242, 226));
		textField_FirstName.setBounds(339, 416, 172, 32);
		panel.add(textField_FirstName);
		
		
		
		JLabel lbl_MidIn = new JLabel("Middle Initial:");
		lbl_MidIn.setVerticalAlignment(SwingConstants.TOP);
		lbl_MidIn.setForeground(Color.WHITE);
		lbl_MidIn.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_MidIn.setBounds(571, 386, 147, 35);
		panel.add(lbl_MidIn);
		
		textField_MidIn = new JTextField();
		textField_MidIn.setForeground(new Color(57, 57, 57));
		textField_MidIn.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_MidIn.setColumns(10);
		textField_MidIn.setBackground(new Color(255, 242, 226));
		textField_MidIn.setBounds(571, 416, 56, 32);
		panel.add(textField_MidIn);
		
		
		
		JLabel lbl_Surname = new JLabel("Surname:");
		lbl_Surname.setVerticalAlignment(SwingConstants.TOP);
		lbl_Surname.setForeground(Color.WHITE);
		lbl_Surname.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_Surname.setBounds(747, 385, 96, 35);
		panel.add(lbl_Surname);
		
		textField_Surname = new JTextField();
		textField_Surname.setForeground(new Color(57, 57, 57));
		textField_Surname.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_Surname.setColumns(10);
		textField_Surname.setBackground(new Color(255, 242, 226));
		textField_Surname.setBounds(747, 416, 172, 32);
		panel.add(textField_Surname);
		
		
		
		JLabel lbl_Section = new JLabel("Section:");
		lbl_Section.setVerticalAlignment(SwingConstants.TOP);
		lbl_Section.setForeground(Color.WHITE);
		lbl_Section.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_Section.setBounds(339, 463, 131, 35);
		panel.add(lbl_Section);
		
		textField_Section = new JTextField();
		textField_Section.setForeground(new Color(57, 57, 57));
		textField_Section.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_Section.setColumns(10);
		textField_Section.setBackground(new Color(255, 242, 226));
		textField_Section.setBounds(339, 493, 113, 32);
		panel.add(textField_Section);
		
		
		
		JLabel lbl_Email = new JLabel("Email:");
		lbl_Email.setVerticalAlignment(SwingConstants.TOP);
		lbl_Email.setForeground(Color.WHITE);
		lbl_Email.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_Email.setBounds(339, 540, 131, 35);
		panel.add(lbl_Email);
		
		textField_email = new JTextField();
		textField_email.setForeground(new Color(57, 57, 57));
		textField_email.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_email.setColumns(10);
		textField_email.setBackground(new Color(255, 242, 226));
		textField_email.setBounds(339, 569, 296, 32);
		panel.add(textField_email);
		
		
		
	    btn_Confirm = new JButton("Confirm");
		btn_Confirm.setForeground(new Color(255, 214, 0));
		btn_Confirm.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		btn_Confirm.setFocusPainted(false);
		btn_Confirm.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
		btn_Confirm.setBackground(new Color(174, 122, 52));
		btn_Confirm.setBounds(490, 633, 133, 38);
		panel.add(btn_Confirm);
		
	    btn_Clear = new JButton("Clear");
		btn_Clear.setForeground(new Color(255, 214, 0));
		btn_Clear.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		btn_Clear.setFocusPainted(false);
		btn_Clear.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
		btn_Clear.setBackground(new Color(174, 122, 52));
		btn_Clear.setBounds(636, 633, 131, 38);
		panel.add(btn_Clear);
		
		
		
	    lbl_QR = new JLabel("");
		lbl_QR.setBounds(1003, 132, 255, 255);
		panel.add(lbl_QR);
		
		textField_SRCode_Confirm = new JTextField();
		textField_SRCode_Confirm.setForeground(new Color(57, 57, 57));
		textField_SRCode_Confirm.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_SRCode_Confirm.setColumns(10);
		textField_SRCode_Confirm.setBackground(new Color(255, 242, 226));
		textField_SRCode_Confirm.setBounds(998, 421, 132, 32);
		panel.add(textField_SRCode_Confirm);
		
		textField_Name_Confirm = new JTextField();
		textField_Name_Confirm.setForeground(new Color(57, 57, 57));
		textField_Name_Confirm.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_Name_Confirm.setColumns(10);
		textField_Name_Confirm.setBackground(new Color(255, 242, 226));
		textField_Name_Confirm.setBounds(998, 466, 265, 32);
		panel.add(textField_Name_Confirm);
		
		textField_Section_Confirm = new JTextField();
		textField_Section_Confirm.setForeground(new Color(57, 57, 57));
		textField_Section_Confirm.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_Section_Confirm.setColumns(10);
		textField_Section_Confirm.setBackground(new Color(255, 242, 226));
		textField_Section_Confirm.setBounds(998, 510, 178, 32);
		panel.add(textField_Section_Confirm);
		
		textField_Email_Confirm = new JTextField();
		textField_Email_Confirm.setForeground(new Color(57, 57, 57));
		textField_Email_Confirm.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_Email_Confirm.setColumns(10);
		textField_Email_Confirm.setBackground(new Color(255, 242, 226));
		textField_Email_Confirm.setBounds(998, 555, 266, 32);
		panel.add(textField_Email_Confirm);
		
	    btn_Enroll = new JButton("Enroll");
		btn_Enroll.setForeground(new Color(255, 214, 0));
		btn_Enroll.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		btn_Enroll.setFocusPainted(false);
		btn_Enroll.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
		btn_Enroll.setBackground(new Color(174, 122, 52));
		btn_Enroll.setBounds(1064, 626, 133, 38);
		panel.add(btn_Enroll);
		
		
		JLabel lbl_Logo = new JLabel("");
		lbl_Logo.setIcon(new ImageIcon(Teacher_Attendance.class.getResource("/Resources/Logo_Small.png")));
		lbl_Logo.setBounds(77, 17, 105, 125);
		panel.add(lbl_Logo);
		
		JLabel lbl_ABM_1 = new JLabel("ATTENDANCE TRACKER");
		lbl_ABM_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ABM_1.setForeground(Color.WHITE);
		lbl_ABM_1.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lbl_ABM_1.setBounds(40, 138, 184, 25);
		panel.add(lbl_ABM_1);
		
		JLabel lbl_ABM_2 = new JLabel("SYSTEM");
		lbl_ABM_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ABM_2.setForeground(Color.WHITE);
		lbl_ABM_2.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lbl_ABM_2.setBounds(41, 158, 184, 25);
		panel.add(lbl_ABM_2);
		
		JLabel lbl_TeacherIcon = new JLabel("");
		lbl_TeacherIcon.setIcon(new ImageIcon(Login_Menu.class.getResource("/Resources/Teacher_Icon.png")));
		lbl_TeacherIcon.setBounds(330, 64, 76, 47);
		panel.add(lbl_TeacherIcon);
		
		JLabel lbl_HeaderTitle = new JLabel("Student Enrollment");
		lbl_HeaderTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HeaderTitle.setForeground(Color.WHITE);
		lbl_HeaderTitle.setFont(new Font("Brush Script MT", Font.BOLD, 50));
		lbl_HeaderTitle.setBounds(416, 46, 426, 54);
		panel.add(lbl_HeaderTitle);
		
		JLabel lbl_HeaderTitle_Shadow = new JLabel("Student Enrollment");
		lbl_HeaderTitle_Shadow.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HeaderTitle_Shadow.setForeground(new Color(57, 57, 57));
		lbl_HeaderTitle_Shadow.setFont(new Font("Brush Script MT", Font.BOLD, 50));
		lbl_HeaderTitle_Shadow.setBounds(418, 48, 426, 54);
		panel.add(lbl_HeaderTitle_Shadow);
		
		JLabel lbl_TeacherIcon_2 = new JLabel("");
		lbl_TeacherIcon_2.setIcon(new ImageIcon(Login_Menu.class.getResource("/Resources/Teacher_Icon.png")));
		lbl_TeacherIcon_2.setBounds(853, 64, 76, 47);
		panel.add(lbl_TeacherIcon_2);
		
		//side panel action button
		SidePanelButtonActionListener controller = new SidePanelButtonActionListener(this);
		btn_Dashboard.addActionListener(controller);
		btn_Attendance.addActionListener(controller);
		btn_ClassRoll.addActionListener(controller);
		btn_Enrollment.addActionListener(controller);
		btn_Classes.addActionListener(controller);
		btn_Exit.addActionListener(controller);
		
		// button for enrollment
		TeacherEnrollmentActionListener enroll = new TeacherEnrollmentActionListener(this);
		btn_BrowseImg.addActionListener(enroll);
		btn_Confirm.addActionListener(enroll);
		btn_Enroll.addActionListener(enroll);
		
		textField_SRCode.setText(generateSRCode());
		
		setVisible(true);
		
		
	}
	
	public static String generateSRCode() {
	    // Get the last two digits of the current year
	    int year = Year.now().getValue() % 100;

	    // Generate a random five-digit number
	    Random random = new Random();
	    int randomNumber = 10000 + random.nextInt(90000);

	    // Combine year and random number to form the SR-Code
	    return String.format("%02d-%05d", year, randomNumber);
	}
}
