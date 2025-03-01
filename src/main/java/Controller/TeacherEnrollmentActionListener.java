package Controller;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.time.Year;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import View.Teacher_Enrollments;
import Model.StudentQuery;

public class TeacherEnrollmentActionListener implements ActionListener {
	private Teacher_Enrollments teacherEnrollments;
	private File selectedImage;
	private byte[] qrBytes;
	StudentQuery enrollStudent = new StudentQuery();
	
	public byte[] getQrBytes() {
		return qrBytes;
	}

	public void setQrBytes(byte[] qrBytes) {
		this.qrBytes = qrBytes;
	}

	public TeacherEnrollmentActionListener(Teacher_Enrollments teacherEnrollments) {
		this.teacherEnrollments = teacherEnrollments;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == teacherEnrollments.btn_Enroll) 
		{
			
			String Sr_Code = teacherEnrollments.textField_SRCode.getText();
			String FirstName = teacherEnrollments.textField_FirstName.getText();
			String MiddleName = teacherEnrollments.textField_MidIn.getText();
			String LastName = teacherEnrollments.textField_Surname.getText();
			String Section = teacherEnrollments.textField_Section.getText();
			String email = teacherEnrollments.textField_email.getText();
			enrollStudent.addStudent( FirstName, MiddleName, LastName, Sr_Code, Section, email, selectedImage, getQrBytes());
	        JOptionPane.showMessageDialog(null, "Student Enrolled Successfully", "Enrollment", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (e.getSource() == teacherEnrollments.btn_BrowseImg) 
		{
			
			JFileChooser filechoose = new JFileChooser();
			filechoose.setDialogTitle("Select an Image");
			filechoose.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));
			int result = filechoose.showOpenDialog(null);
					
			if(result == JFileChooser.APPROVE_OPTION)
			{
				ImageIcon imageIcon = new ImageIcon(filechoose.getSelectedFile().getAbsolutePath());
				Image image = imageIcon.getImage().getScaledInstance(124, 122, Image.SCALE_SMOOTH);
				selectedImage = filechoose.getSelectedFile();
				teacherEnrollments.picture.setIcon(new ImageIcon(image));
				teacherEnrollments.textField_Image.setText(selectedImage.getAbsolutePath());
			}
			
		}
		
		else if (e.getSource() == teacherEnrollments.btn_Confirm) 
		{
			int confirm = JOptionPane.showConfirmDialog(null,
					"Are You Sure About Your Details?",
					"Enroll Student ", JOptionPane.YES_NO_OPTION);
			
			if (confirm == JOptionPane.YES_OPTION) 
			{
				generateAndSaveQRCode();
				teacherEnrollments.textField_SRCode_Confirm.setText(teacherEnrollments.textField_SRCode.getText());
				String Fullname = teacherEnrollments.textField_FirstName.getText() + " " + teacherEnrollments.textField_MidIn.getText() + " " + teacherEnrollments.textField_Surname.getText();
				teacherEnrollments.textField_Name_Confirm.setText(Fullname);
				teacherEnrollments.textField_Section_Confirm.setText(teacherEnrollments.textField_Section.getText());
				teacherEnrollments.textField_Email_Confirm.setText(teacherEnrollments.textField_email.getText());
			}
			
		}
		

	}
	
	
	private void generateAndSaveQRCode() 
	{ 
		String firstName = teacherEnrollments.textField_FirstName.getText(); String middleName = teacherEnrollments.textField_MidIn.getText(); String lastName = teacherEnrollments.textField_Surname.getText();
		String srCode = teacherEnrollments.textField_SRCode.getText(); String section = teacherEnrollments.textField_Section.getText();

	if (firstName.isEmpty() || lastName.isEmpty()) {
	    JOptionPane.showMessageDialog(null, "First Name and Last Name are required.", "Error", JOptionPane.ERROR_MESSAGE);
	    return;
	}

	try {
	    // Combine information for QR Code content
	    String qrContent = String.format(srCode);

	    // Generate QR Code
	    int size = 250;
	    BitMatrix matrix = new MultiFormatWriter().encode(qrContent, BarcodeFormat.QR_CODE, size, size);
	    BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(matrix);

	    // Show QR Code in GUI
	    teacherEnrollments.lbl_QR.setIcon(new ImageIcon(qrImage));

	    // Convert QR Code to Byte Array
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(qrImage, "PNG", baos);
	    byte[] qrBytes = baos.toByteArray();
	    
	    setQrBytes(qrBytes);

	    JOptionPane.showMessageDialog(null, "generating QR Code!", "Success", JOptionPane.INFORMATION_MESSAGE);
	} catch (Exception e) {
	    e.printStackTrace();
	    JOptionPane.showMessageDialog(null, "Error generating QR Code.", "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	}
	
	
	
	

}
