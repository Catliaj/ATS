package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class GenerateQRCode extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField fnameField, mnameField, lnameField;
    private JLabel qrLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GenerateQRCode frame = new GenerateQRCode();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GenerateQRCode() {
        setTitle("QR Code Generator with Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 494, 520);
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        // Top Panel for Input Fields
        JPanel topPanel = new JPanel(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns, with gaps
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        fnameField = new JTextField();
        mnameField = new JTextField();
        lnameField = new JTextField();

        topPanel.add(new JLabel("First Name:"));
        topPanel.add(fnameField);
        topPanel.add(new JLabel("Middle Name:"));
        topPanel.add(mnameField);
        topPanel.add(new JLabel("Last Name:"));
        topPanel.add(lnameField);

        JButton generateButton = new JButton("Generate & Save to DB");
        topPanel.add(new JLabel()); // Empty label for spacing
        topPanel.add(generateButton);

        // Center Panel for QR Code Display
        qrLabel = new JLabel("", SwingConstants.CENTER);
        qrLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Add Panels to Frame
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(qrLabel, BorderLayout.CENTER);

        // Button Action
        generateButton.addActionListener(e -> generateAndSaveQRCode());
    }

    private void generateAndSaveQRCode() {
        String firstname = fnameField.getText().trim();
        String middlename = mnameField.getText().trim();
        String lastname = lnameField.getText().trim();

        if (firstname.isEmpty() || lastname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "First Name and Last Name are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Combine names for QR Code content
            String fullName = firstname + " " + middlename + " " + lastname;

            // Generate QR Code
            int size = 250;
            BitMatrix matrix = new MultiFormatWriter().encode(fullName, BarcodeFormat.QR_CODE, size, size);
            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(matrix);

            // Show QR Code in GUI
            qrLabel.setIcon(new ImageIcon(qrImage));

            // Convert QR Code to Byte Array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(qrImage, "PNG", baos);
            byte[] qrBytes = baos.toByteArray();

            // Save to Database
            saveToDatabase(firstname, middlename, lastname, qrBytes);

            JOptionPane.showMessageDialog(this, "QR Code saved to database!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error generating QR Code.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveToDatabase(String firstname, String middlename, String lastname, byte[] qrBytes) {
        String url = "jdbc:mysql://localhost:3306/OES";
        String user = "root";
        String password = "";

        String sql = "INSERT INTO students_details (fname, mname, lname, qrcode) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, firstname);
            pstmt.setString(2, middlename);
            pstmt.setString(3, lastname);
            pstmt.setBytes(4, qrBytes);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}