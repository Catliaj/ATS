package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.sarxos.webcam.Webcam;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.GlobalHistogramBinarizer;
import Model.Student_ChecksDB;
import Controller.SidePanelButtonActionListener;

public class Student_Checks extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_SR_Code;
	public JTextField textField_Section;
	public JTextField textField_StudentName;
	public JTextField txtCheckedin;
	public JTextField textField_DateToday;
	public JTextField textField_TimeNow;
	private Webcam webcam;
	private WebcamPanel webcamPanel;
    private boolean isScanning = true;
    private Result qrResult = null;
    public JLabel lbl_StudentImage;
    private  JComboBox  comboBox;
    private JButton btn_Exit;
    Student_ChecksDB checks = new Student_ChecksDB(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Checks frame = new Student_Checks();
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
	public Student_Checks() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Student_Checks.class.getResource("/Resources/CAF_Logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1334, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Background = new JLabel("");
		lbl_Background.setIcon(new ImageIcon(Student_Checks.class.getResource("/Resources/Background for Student CheckinCheckout.png")));
		lbl_Background.setBounds(0, 0, 1320, 745);
		contentPane.add(lbl_Background);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color( 0, 0, 0, 0));
		panel.setBounds(0, 0, 1320, 745);
		lbl_Background.add(panel);
		panel.setLayout(null);
		
	    btn_Exit = new JButton("Exit");
		btn_Exit.setForeground(Color.WHITE);
		btn_Exit.setFont(new Font("Brush Script MT", Font.BOLD, 40));
		btn_Exit.setFocusPainted(false);
		btn_Exit.setBackground(new Color(0, 0, 0, 0));
		btn_Exit.setOpaque(false);
		btn_Exit.setBorder(BorderFactory.createLineBorder(new Color(174, 122, 52), 4));
		btn_Exit.setBounds(10, 636, 251, 69);
		panel.add(btn_Exit);
		
		webcam = Webcam.getWebcams().get(0);  // Use index 1 if your laptop webcam is second in the list
        webcam.setViewSize(WebcamResolution.VGA.getSize());
		
		
        comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select a Subject"}));
		comboBox.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		comboBox.setBackground(new Color(255, 214, 0));
		comboBox.setForeground(new Color(57, 57, 57));
		comboBox.setBorder(BorderFactory.createLineBorder(new Color(57, 57, 57), 4));
		comboBox.setBounds(513, 126, 302, 32);
		panel.add(comboBox);
		
		
		
	    lbl_StudentImage = new JLabel("");
		lbl_StudentImage.setBounds(390, 209, 126, 126);
		panel.add(lbl_StudentImage);
		
		
		
		textField_SR_Code = new JTextField();
		textField_SR_Code.setEditable(false);
		textField_SR_Code.setForeground(new Color(57, 57, 57));
		textField_SR_Code.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_SR_Code.setColumns(10);
		textField_SR_Code.setBackground(new Color(255, 242, 226));
		textField_SR_Code.setBounds(562, 302, 134, 37);
		panel.add(textField_SR_Code);
		
		
		
		textField_Section = new JTextField();
		textField_Section.setEditable(false);
		textField_Section.setForeground(new Color(57, 57, 57));
		textField_Section.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_Section.setColumns(10);
		textField_Section.setBackground(new Color(255, 242, 226));
		textField_Section.setBounds(735, 302, 134, 37);
		panel.add(textField_Section);
		
		
		
		textField_StudentName = new JTextField();
		textField_StudentName.setEditable(false);
		textField_StudentName.setForeground(new Color(57, 57, 57));
		textField_StudentName.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_StudentName.setColumns(10);
		textField_StudentName.setBackground(new Color(255, 242, 226));
		textField_StudentName.setBounds(334, 410, 589, 54);
		panel.add(textField_StudentName);
		
		
		
		txtCheckedin = new JTextField();
		txtCheckedin.setEditable(false);
		txtCheckedin.setHorizontalAlignment(SwingConstants.CENTER);
		txtCheckedin.setForeground(new Color(57, 57, 57));
		txtCheckedin.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		txtCheckedin.setBackground(new Color(255, 214, 0));
		txtCheckedin.setBorder(BorderFactory.createLineBorder(new Color(57, 57, 57), 6));
		txtCheckedin.setBounds(410, 485, 438, 81);
		panel.add(txtCheckedin);
		
		
		
		textField_DateToday = new JTextField();
		textField_DateToday.setEditable(false);
		textField_DateToday.setForeground(new Color(57, 57, 57));
		textField_DateToday.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_DateToday.setColumns(10);
		textField_DateToday.setBackground(new Color(255, 242, 226));
		textField_DateToday.setBounds(584, 579, 185, 37);
		panel.add(textField_DateToday);
		
		
		
		textField_TimeNow = new JTextField();
		textField_TimeNow.setEditable(false);
		textField_TimeNow.setForeground(new Color(57, 57, 57));
		textField_TimeNow.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_TimeNow.setColumns(10);
		textField_TimeNow.setBackground(new Color(255, 242, 226));
		textField_TimeNow.setBounds(604, 630, 142, 37);
		panel.add(textField_TimeNow);
		
		JLabel lbl_SRCode = new JLabel("SR-Code:");
		lbl_SRCode.setVerticalAlignment(SwingConstants.TOP);
		lbl_SRCode.setForeground(Color.WHITE);
		lbl_SRCode.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_SRCode.setBounds(562, 270, 100, 32);
		panel.add(lbl_SRCode);
		
		JLabel lbl_Section = new JLabel("Section:");
		lbl_Section.setVerticalAlignment(SwingConstants.TOP);
		lbl_Section.setForeground(Color.WHITE);
		lbl_Section.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_Section.setBounds(735, 270, 100, 32);
		panel.add(lbl_Section);
		
		JLabel lbl_StudentName = new JLabel("Student Name:");
		lbl_StudentName.setVerticalAlignment(SwingConstants.TOP);
		lbl_StudentName.setForeground(Color.WHITE);
		lbl_StudentName.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_StudentName.setBounds(334, 378, 134, 32);
		panel.add(lbl_StudentName);
		
		JLabel lbl_Subject = new JLabel("Subject:");
		lbl_Subject.setVerticalAlignment(SwingConstants.TOP);
		lbl_Subject.setForeground(Color.WHITE);
		lbl_Subject.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_Subject.setBounds(434, 126, 100, 32);
		panel.add(lbl_Subject);
		
		JLabel lbl_Date = new JLabel("Date:");
		lbl_Date.setVerticalAlignment(SwingConstants.TOP);
		lbl_Date.setForeground(Color.WHITE);
		lbl_Date.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_Date.setBounds(522, 584, 65, 32);
		panel.add(lbl_Date);
		
		JLabel lbl_Time = new JLabel("Time:");
		lbl_Time.setVerticalAlignment(SwingConstants.TOP);
		lbl_Time.setForeground(Color.WHITE);
		lbl_Time.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_Time.setBounds(544, 635, 65, 32);
		panel.add(lbl_Time);
		
		JLabel lbl_Note = new JLabel("Note:");
		lbl_Note.setVerticalAlignment(SwingConstants.TOP);
		lbl_Note.setForeground(Color.WHITE);
		lbl_Note.setFont(new Font("Brush Script MT", Font.BOLD, 30));
		lbl_Note.setBounds(1003, 434, 100, 32);
		panel.add(lbl_Note);
		
		JLabel lbl_Note_2 = new JLabel("Scan your      code for");
		lbl_Note_2.setVerticalAlignment(SwingConstants.TOP);
		lbl_Note_2.setForeground(Color.WHITE);
		lbl_Note_2.setFont(new Font("Brush Script MT", Font.BOLD, 30));
		lbl_Note_2.setBounds(1003, 476, 255, 32);
		panel.add(lbl_Note_2);
		
		JLabel lbl_Note_QR = new JLabel("QR");
		lbl_Note_QR.setVerticalAlignment(SwingConstants.TOP);
		lbl_Note_QR.setForeground(Color.WHITE);
		lbl_Note_QR.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lbl_Note_QR.setBounds(1114, 478, 54, 32);
		panel.add(lbl_Note_QR);
		
		JLabel lbl_Note_3 = new JLabel("attendance.");
		lbl_Note_3.setVerticalAlignment(SwingConstants.TOP);
		lbl_Note_3.setForeground(Color.WHITE);
		lbl_Note_3.setFont(new Font("Brush Script MT", Font.BOLD, 30));
		lbl_Note_3.setBounds(1003, 515, 255, 32);
		panel.add(lbl_Note_3);
		
		JLabel lbl_Note_4 = new JLabel("•Once for Check-in.");
		lbl_Note_4.setVerticalAlignment(SwingConstants.TOP);
		lbl_Note_4.setForeground(Color.WHITE);
		lbl_Note_4.setFont(new Font("Brush Script MT", Font.BOLD, 30));
		lbl_Note_4.setBounds(1000, 574, 255, 32);
		panel.add(lbl_Note_4);
		
		JLabel lbl_Note_5 = new JLabel("•Another for Check-out.");
		lbl_Note_5.setVerticalAlignment(SwingConstants.TOP);
		lbl_Note_5.setForeground(Color.WHITE);
		lbl_Note_5.setFont(new Font("Brush Script MT", Font.BOLD, 30));
		lbl_Note_5.setBounds(1000, 624, 276, 32);
		panel.add(lbl_Note_5);
		
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
		
		JLabel lbl_StudentIcon = new JLabel("");
		lbl_StudentIcon.setIcon(new ImageIcon(Login_Menu.class.getResource("/Resources/Student_Icon.png")));
		lbl_StudentIcon.setBounds(345, 48, 63, 67);
		panel.add(lbl_StudentIcon);
		
		JLabel lbl_HeaderTitle = new JLabel("Student Attendance");
		lbl_HeaderTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HeaderTitle.setForeground(Color.WHITE);
		lbl_HeaderTitle.setFont(new Font("Brush Script MT", Font.BOLD, 50));
		lbl_HeaderTitle.setBounds(410, 46, 438, 54);
		panel.add(lbl_HeaderTitle);
		
		JLabel lbl_HeaderTitle_Shadow = new JLabel("Student Attendance");
		lbl_HeaderTitle_Shadow.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HeaderTitle_Shadow.setForeground(new Color(57, 57, 57));
		lbl_HeaderTitle_Shadow.setFont(new Font("Brush Script MT", Font.BOLD, 50));
		lbl_HeaderTitle_Shadow.setBounds(412, 48, 438, 54);
		panel.add(lbl_HeaderTitle_Shadow);
		
		JLabel lbl_StudentIcon_2 = new JLabel("");
		lbl_StudentIcon_2.setIcon(new ImageIcon(Login_Menu.class.getResource("/Resources/Student_Icon.png")));
		lbl_StudentIcon_2.setBounds(851, 49, 63, 67);
		panel.add(lbl_StudentIcon_2);
		webcamPanel = new WebcamPanel(webcam);
		webcamPanel.setBounds(1003, 142, 255, 254);
		panel.add(webcamPanel);
		
		SidePanelButtonActionListener controller = new SidePanelButtonActionListener(this);
		btn_Exit.addActionListener(controller);
		
		
		JLabel lbl_QR = new JLabel("");
		webcamPanel.add(lbl_QR);
		populateComboBox();
		new Thread(this::startScanning).start();
	}
	

	 private Map<String, Boolean> checkInStatusMap = new HashMap<>();

	    // Existing code...

	    private void startScanning() {
	        while (isScanning) {
	            try {
	                // Capture an image from the webcam
	                BufferedImage image = webcam.getImage();

	                // Convert the image to grayscale
	                BufferedImage grayscaleImage = new BufferedImage(
	                    image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
	                Graphics g = grayscaleImage.getGraphics();
	                g.drawImage(image, 0, 0, null);
	                g.dispose();

	                // Decode the QR code from the grayscale image
	                BinaryBitmap binaryBitmap = new BinaryBitmap(new GlobalHistogramBinarizer(new BufferedImageLuminanceSource(grayscaleImage)));
	                qrResult = new MultiFormatReader().decode(binaryBitmap);

	                // Get the text from the QR code
	                String qrText = qrResult.getText();
	                System.out.println("QR Code Text: " + qrText);

	                // Fetch student details from the database
	                checks.fetchStudent(qrText);

	                // Get current date and time
	                String currentDate = getDate();
	                String currentTime = getTime();
	                String classID = comboBox.getSelectedItem().toString();

	                // Check the check-in status
	                boolean isCheckedIn = checkInStatusMap.getOrDefault(qrText, false);

	             // Fetch student email from the database
	                String studentEmail = checks.getStudentEmail(qrText);

	                // Record attendance
	                if (!isCheckedIn) {
	                    checks.recordAttendance(classID, qrText, currentDate, currentTime, null, true, studentEmail);
	                    txtCheckedin.setText("Checked In");
	                    txtCheckedin.setBackground(Color.GREEN); // Check-in
	                    checkInStatusMap.put(qrText, true);
	                } else {
	                    checks.recordAttendance(classID, qrText, currentDate, null, currentTime, false, studentEmail);
	                    txtCheckedin.setText("Checked Out");
	                    txtCheckedin.setBackground(Color.RED); // Check-out
	                    checkInStatusMap.put(qrText, false);
	                }

	                textField_DateToday.setText(currentDate);
	                textField_TimeNow.setText(currentTime);

	                // Stop scanning for 10 seconds after successful detection
	                isScanning = false;
	                Thread.sleep(10000); // 10-second delay
	                clearTextFields(); // Clear text fields
	                isScanning = true; // Resume scanning
	            } catch (NotFoundException e) {
	                // QR code not found, continue scanning
	                qrResult = null; // Reset the QR code result
	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	            // Repaint the webcam panel
	            webcamPanel.repaint();

	            // Add a small delay to avoid high CPU usage
	            try {
	                Thread.sleep(500); // Adjust the delay as needed
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		
		
		private void clearTextFields() {
		    textField_SR_Code.setText("");
		    textField_Section.setText("");
		    textField_StudentName.setText("");
		    txtCheckedin.setText("");
		    textField_DateToday.setText("");
		    textField_TimeNow.setText("");
		    lbl_StudentImage.setIcon(null); // Reset the student image
		}




	
	 public String getDate() 
	 {
	        LocalDate date = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        return date.format(formatter);
	 }

	 public String getTime() 
	 { 
		 LocalTime time = LocalTime.now(); 
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a"); 
		 return time.format(formatter); 
	}
	 
	 private void populateComboBox() {
	        List<String> subjects = checks.fetchSubjects();
	        for (String subject : subjects) {
	            comboBox.addItem(subject);
	        }
	    }
}
