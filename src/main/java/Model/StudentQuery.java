package Model;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.db_connection;
import View.Student_Checks;

public class StudentQuery 
{
	private String Sr_Code, FirstName, LastName, UserName, Email, Section, Middle_Initial;
	private Student_Checks checks;
	
	public String getSr_Code() {
		return Sr_Code;
	}

	public void setSr_Code(String sr_Code) {
		Sr_Code = sr_Code;
	}



	private File StudentImage, qrCode;
	
	
	public void addStudent(String FirstName, String Middle_Initial, String Surname,String Sr_Code, String Email, String Section, File StudentImage, byte[] qrCode) {
		setFirstName(FirstName);
		setMiddle_Initial(Middle_Initial);
		setLastName(Surname);
		setSr_Code(Sr_Code);
		setEmail(Email);
		setSection(Section);
		setStudentImage(StudentImage);
		
		db_connection db = new db_connection();
		try {
			Connection connection = db.getConnection();
			String Query = "INSERT INTO STUDENTS(FIRST_NAME, MIDDLE_INITIAL, SURNAME, SR_CODE, EMAIL, SECTION, studentImage, qrcode) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(Query);
			ps.setString(1, getFirstName());
			ps.setString(2, getMiddle_Initial());
			ps.setString(3, getLastName());
			ps.setString(4, getSr_Code());
			ps.setString(5, getSection());
			ps.setString(6, getEmail());
			FileInputStream fis = new FileInputStream(StudentImage);
			ps.setBinaryStream(7, fis, StudentImage.length());
			ps.setBytes(8, qrCode);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Student Added Successfully");
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}
	
	public void UpdateStudent(String FirstName, String Middle_Initial, String Surname,String Sr_Code, String UserName, String Email, String Section, File StudentImage, File qrCode) {
		setFirstName(FirstName);
		setMiddle_Initial(Middle_Initial);
		setLastName(Surname);
		setSr_Code(Sr_Code);
		setUserName(UserName);
		setEmail(Email);
		setSection(Section);
		setStudentImage(StudentImage);
		setQrCode(qrCode);
		db_connection db = new db_connection();
		try {
			Connection connection = db.getConnection();
			String Query = "UPDATE STUDENTS SET FIRST_NAME = ?, MIDDLE_INITIAL = ?, SURNAME = ?, SR_CODE = ?, SECTION = ?, EMAIL = ?, studentImage = ?, qrcode = ? WHERE SR_CODE = ?";
			PreparedStatement ps = connection.prepareStatement(Query);
			ps.setString(1, getFirstName());
			ps.setString(2, getMiddle_Initial());
			ps.setString(3, getLastName());
			ps.setString(4, getSr_Code());
			ps.setString(5, getSection());
			ps.setString(6, getEmail());
			FileInputStream fis = new FileInputStream(StudentImage);
			FileInputStream fis2 = new FileInputStream(qrCode);
			ps.setBinaryStream(7, fis, StudentImage.length());
			ps.setBinaryStream(8, fis2, qrCode.length());
			ps.setString(9, getSr_Code());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Student Updated Successfully");
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	}
	
	
	public void fetchStudent(String Sr_Code) {
		db_connection db = new db_connection();
		
		try {
			Connection connection = db.getConnection();
			String Query = "SELECT * FROM STUDENTS WHERE SR_CODE = ?";
			PreparedStatement ps = connection.prepareStatement(Query);
			ps.setString(1, Sr_Code);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				setFirstName(rs.getString("FIRST_NAME"));
				setMiddle_Initial(rs.getString("MIDDLE_INITIAL"));
				setLastName(rs.getString("SURNAME"));
				setSr_Code(rs.getString("SR_CODE"));
				setSection(rs.getString("SECTION"));
				setStudentImage(new File(rs.getString("studentImage")));
				String Fullname = getFirstName() + " " + getMiddle_Initial() + " " + getLastName();
				String SR_Code = getSr_Code();
				String Section = getSection();
				
				checks.textField_StudentName.setText(Fullname);
				checks.textField_SR_Code.setText(SR_Code);
				checks.textField_Section.setText(Section);
				
				 ImageIcon imageIcon = getStudentImages(Sr_Code);  
		            if (imageIcon != null) {
		                // Resize and display image
		                Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		                checks.lbl_StudentImage.setIcon(new ImageIcon(image));
		            } else {
		                JOptionPane.showMessageDialog(null, "Image not found for Student ID!");
		            }
			}
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		}
	
	}
	

	public void populateStudentTable(JTable table) {
	    db_connection db = new db_connection();
	    try {
	        Connection connection = db.getConnection();
	        String query = "SELECT FIRST_NAME, MIDDLE_INITIAL, SURNAME, SR_CODE, SECTION ,email FROM STUDENTS";
	        PreparedStatement ps = connection.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0); // Clear existing rows
	
	        while (rs.next()) {
	            String firstName = rs.getString("FIRST_NAME");
	            String middleInitial = rs.getString("MIDDLE_INITIAL");
	            String surname = rs.getString("SURNAME");
	            String srCode = rs.getString("SR_CODE");
	            String section = rs.getString("SECTION");
	            String email = rs.getString("email");
	
	            model.addRow(new Object[]{srCode, firstName, middleInitial, surname, section, email});
	        }
	
	        connection.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	    }
	}
	
	

public ImageIcon getStudentImage(String srCode) {
    db_connection db = new db_connection();
    ImageIcon imageIcon = null;
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        connection = db.getConnection();
        String query = "SELECT studentImage FROM STUDENTS WHERE SR_CODE = ?";
        ps = connection.prepareStatement(query);
        ps.setString(1, srCode);
        rs = ps.executeQuery();

        if (rs.next()) {
            // Fetch image as byte array
            byte[] imgBytes = rs.getBytes("studentImage");
            if (imgBytes != null) {
                // Convert bytes to ImageIcon
                imageIcon = new ImageIcon(imgBytes);
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error retrieving student image: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    return imageIcon; // Return image or null
}

public ImageIcon getQRCodeImage(String srCode) {
    db_connection db = new db_connection();
    ImageIcon imageIcon = null;
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        connection = db.getConnection();
        String query = "SELECT qrCode FROM STUDENTS WHERE SR_CODE = ?";
        ps = connection.prepareStatement(query);
        ps.setString(1, srCode);
        rs = ps.executeQuery();

        if (rs.next()) {
            // Fetch image as byte array
            byte[] imgBytes = rs.getBytes("qrCode");
            if (imgBytes != null) {
                // Convert bytes to ImageIcon
                imageIcon = new ImageIcon(imgBytes);
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error retrieving QR code image: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    return imageIcon; // Return image or null
}


    private ImageIcon getStudentImages(String Sr_Code) 
	 {
		 db_connection db = new db_connection();
	        ImageIcon imageIcon = null;
	        try {
	        	Connection connection = db.getConnection(); // Reuse existing DB connection
	            String sql = "SELECT studentImage FROM Students WHERE sr_code = ?";
	            PreparedStatement pstmt = connection.prepareStatement(sql);
	            pstmt.setString(1, Sr_Code);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                // Fetch image as byte array
	                byte[] imgBytes = rs.getBytes("studentImage");
	                if (imgBytes != null) {
	                    // Convert bytes to ImageIcon
	                    imageIcon = new ImageIcon(imgBytes);
	                }
	            }
	            pstmt.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	        }
	        return imageIcon; // Return image or null
	    }
	 
	  public void populateAttendanceTable(JTable table) {
	        db_connection db = new db_connection();
	        try {
	            Connection connection = db.getConnection();
	            String query = "SELECT c.subject, CONCAT(s.FIRST_NAME, ' ', s.MIDDLE_INITIAL, ' ', s.SURNAME) AS fullname, " +
	                           "a.class_date, a.checkin_time, a.checkout_time " +
	                           "FROM attendance a " +
	                           "JOIN classes c ON a.class_id = c.class_id " +
	                           "JOIN students s ON a.student_id = s.student_id";
	            PreparedStatement ps = connection.prepareStatement(query);
	            ResultSet rs = ps.executeQuery();

	            DefaultTableModel model = (DefaultTableModel) table.getModel();
	            model.setRowCount(0); // Clear existing rows

	            while (rs.next()) {
	                String subject = rs.getString("subject");
	                String fullname = rs.getString("fullname");
	                String classDate = rs.getString("class_date");
	                String checkinTime = rs.getString("checkin_time");
	                String checkoutTime = rs.getString("checkout_time");

	                model.addRow(new Object[]{subject, fullname, classDate, checkinTime, checkoutTime});
	            }

	            connection.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
	        }
	    }
	  
	  

public void updateAttendance(String fullname, String date, String checkIn, String checkOut) {
    db_connection db = new db_connection();
    try {
        Connection connection = db.getConnection();

        // Find student_id based on fullname
        String findStudentIdQuery = "SELECT student_id FROM students WHERE CONCAT(FIRST_NAME, ' ', MIDDLE_INITIAL, ' ', SURNAME) = ?";
        PreparedStatement findStudentIdPs = connection.prepareStatement(findStudentIdQuery);
        findStudentIdPs.setString(1, fullname);
        ResultSet rs = findStudentIdPs.executeQuery();

        if (rs.next()) {
            int studentId = rs.getInt("student_id");

            // Update attendance record
            String updateQuery = "UPDATE attendance SET checkin_time = ?, checkout_time = ? " +
                                 "WHERE student_id = ? AND class_date = ?";
            PreparedStatement updatePs = connection.prepareStatement(updateQuery);
            updatePs.setString(1, checkIn);
            updatePs.setString(2, checkOut);
            updatePs.setInt(3, studentId);
            updatePs.setString(4, date);
            int rowsUpdated = updatePs.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Attendance updated successfully for " + fullname);
            } else {
                JOptionPane.showMessageDialog(null, "No attendance record found for the given student and date");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No student found with the given fullname");
        }

        connection.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}


public void deleteAttendance(String fullname, String date) {
    db_connection db = new db_connection();
    try {
        Connection connection = db.getConnection();

        // Find student_id based on fullname
        String findStudentIdQuery = "SELECT student_id FROM students WHERE CONCAT(FIRST_NAME, ' ', MIDDLE_INITIAL, ' ', SURNAME) = ?";
        PreparedStatement findStudentIdPs = connection.prepareStatement(findStudentIdQuery);
        findStudentIdPs.setString(1, fullname);
        ResultSet rs = findStudentIdPs.executeQuery();

        if (rs.next()) {
            int studentId = rs.getInt("student_id");

            // Delete attendance record
            String deleteQuery = "DELETE FROM attendance WHERE student_id = ? AND class_date = ?";
            PreparedStatement deletePs = connection.prepareStatement(deleteQuery);
            deletePs.setInt(1, studentId);
            deletePs.setString(2, date);
            int rowsDeleted = deletePs.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Attendance deleted successfully for " + fullname);
            } else {
                JOptionPane.showMessageDialog(null, "No attendance record found for the given student and date");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No student found with the given fullname");
        }

        connection.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}


	  
	  
	  
	  
	
	
	
	
	 public String getFirstName() {
			return FirstName;
		}



		public void setFirstName(String firstName) {
			FirstName = firstName;
		}



		public String getLastName() {
			return LastName;
		}



		public void setLastName(String lastName) {
			LastName = lastName;
		}



		public String getUserName() {
			return UserName;
		}



		public void setUserName(String userName) {
			UserName = userName;
		}



		public String getEmail() {
			return Email;
		}



		public void setEmail(String email) {
			Email = email;
		}



		public String getSection() {
			return Section;
		}



		public void setSection(String section) {
			Section = section;
		}



		public File getStudentImage() {
			return StudentImage;
		}



		public void setStudentImage(File studentImage) {
			StudentImage = studentImage;
		}



		public File getQrCode() {
			return qrCode;
		}



		public void setQrCode(File qrCode) {
			this.qrCode = qrCode;
		}
		
		public String getMiddle_Initial() {
			return Middle_Initial;
		}



		public void setMiddle_Initial(String middle_Initial) {
			Middle_Initial = middle_Initial;
		}

	
}
