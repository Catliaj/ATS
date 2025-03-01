package View;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.util.Properties;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.GlobalHistogramBinarizer;
import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.*;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

public class scan_qr extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField fnameField;
    private JTextField mnameField;
    private JTextField lnameField;
    private Webcam webcam;
    private WebcamPanel webcamPanel;
    private boolean isScanning = true;
    private Result qrResult = null; // Store the QR code detection result

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    scan_qr frame = new scan_qr();
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
    public scan_qr() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Scan QR Code");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(10, 11, 764, 31);
        contentPane.add(lblNewLabel);

        // Initialize Webcam
        webcam = Webcam.getWebcams().get(0);  // Use index 1 if your laptop webcam is second in the list
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setBounds(50, 50, 640, 480);
        contentPane.add(webcamPanel);

        JLabel fnameLabel = new JLabel("First Name:");
        fnameLabel.setBounds(700, 50, 100, 20);
        contentPane.add(fnameLabel);

        fnameField = new JTextField();
        fnameField.setBounds(700, 80, 150, 20);
        contentPane.add(fnameField);
        fnameField.setColumns(10);

        JLabel mnameLabel = new JLabel("Middle Name:");
        mnameLabel.setBounds(700, 120, 100, 20);
        contentPane.add(mnameLabel);

        mnameField = new JTextField();
        mnameField.setBounds(700, 150, 150, 20);
        contentPane.add(mnameField);
        mnameField.setColumns(10);

        JLabel lnameLabel = new JLabel("Last Name:");
        lnameLabel.setBounds(700, 200, 100, 20);
        contentPane.add(lnameLabel);

        lnameField = new JTextField();
        lnameField.setBounds(700, 230, 150, 20);
        contentPane.add(lnameField);
        lnameField.setColumns(10);

    

        // Start a background thread to continuously scan for QR codes
        new Thread(this::startScanning).start();
    }

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
                fetchStudentDetails(qrText);

                // Stop scanning for 10 seconds after successful detection
                isScanning = false;
                Thread.sleep(10000); // 10-second delay
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

    private void fetchStudentDetails(String qrText) {
        String url = "jdbc:mysql://localhost:3306/OES";
        String user = "root";
        String password = "";

        String sql = "SELECT * FROM students_details WHERE CONCAT(fname, ' ', mname, ' ', lname) = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, qrText);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                fnameField.setText(rs.getString("fname"));
                mnameField.setText(rs.getString("mname"));
                lnameField.setText(rs.getString("lname"));

                // Send email to the student
                String studentEmail = rs.getString("email");
                if (studentEmail != null && !studentEmail.isEmpty()) {
                    sendEmail(studentEmail, "Attendance Notification", 
                             fnameField.getText() + " " + mnameField.getText() + " " + lnameField.getText() + " is present.");
                } else {
                    JOptionPane.showMessageDialog(this, "Student email not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No student found with this QR code.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching student details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sendEmail(String to, String subject, String body) {
        String from = "catliaj5@gmail.com"; // Replace with your Gmail
        String appPassword = "vvtg pohv peog ogih"; // Replace with your generated App Password

        String host = "smtp.gmail.com";
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, appPassword);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            JOptionPane.showMessageDialog(this, "Email sent successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error sending email: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}