package Model;


import java.awt.Image; import java.io.File; import java.io.FileInputStream; import java.sql.Connection; import java.sql.PreparedStatement; import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon; import javax.swing.JOptionPane; import View.Student_Checks;

public class Student_ChecksDB { 
	private String Sr_Code, FirstName, LastName, UserName, Email, Section, Middle_Initial; private Student_Checks checks; private File StudentImage, qrCode;

// Constructor to initialize the checks object
public Student_ChecksDB(Student_Checks checks) {
    this.checks = checks;
}

public String getSr_Code() {
    return Sr_Code;
}

public void setSr_Code(String sr_Code) {
    Sr_Code = sr_Code;
}

public void addStudent(String FirstName, String Middle_Initial, String Surname, String Sr_Code, String Email, String Section, File StudentImage, byte[] qrCode) {
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
        String Query = "INSERT INTO STUDENTS(FIRST_NAME, MIDDLE_INITIAL, SURNAME, SR_CODE, SECTION, EMAIL, studentImage, qrcode) VALUES(?,?,?,?,?,?,?,?)";
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

public void UpdateStudent(String FirstName, String Middle_Initial, String Surname, String Sr_Code, String UserName, String Email, String Section, File StudentImage, File qrCode) {
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

private ImageIcon getStudentImages(String Sr_Code) {
    db_connection db = new db_connection();
    ImageIcon imageIcon = null;
    try {
        Connection connection = db.getConnection();
        String sql = "SELECT studentImage FROM Students WHERE sr_code = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, Sr_Code);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            byte[] imgBytes = rs.getBytes("studentImage");
            if (imgBytes != null) {
                imageIcon = new ImageIcon(imgBytes);
            }
        }
        pstmt.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
    return imageIcon;
}

public String getStudentEmail(String srCode) {
    db_connection db = new db_connection();
    String email = null;
    try {
        Connection connection = db.getConnection();
        String query = "SELECT email FROM students WHERE sr_code = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, srCode);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            email = rs.getString("email");
        }
        connection.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
    return email;
}


public void recordAttendance(String className, String srCode, String checkInDate, String checkInTime, String checkOutTime, boolean isCheckIn, String studentEmail) {
    db_connection db = new db_connection();
    EmailService emailService = new EmailService();
    try {
        Connection connection = db.getConnection();

        // Find class_id based on class name
        String classQuery = "SELECT class_id FROM classes WHERE subject = ?";
        PreparedStatement classPs = connection.prepareStatement(classQuery);
        classPs.setString(1, className);
        ResultSet classRs = classPs.executeQuery();
        int classId = 0;
        if (classRs.next()) {
            classId = classRs.getInt("class_id");
        } else {
            JOptionPane.showMessageDialog(null, "Class not found!");
            return;
        }

        // Find student_id based on sr_code
        String studentQuery = "SELECT student_id FROM students WHERE sr_code = ?";
        PreparedStatement studentPs = connection.prepareStatement(studentQuery);
        studentPs.setString(1, srCode);
        ResultSet studentRs = studentPs.executeQuery();
        int studentId = 0;
        if (studentRs.next()) {
            studentId = studentRs.getInt("student_id");
        } else {
            JOptionPane.showMessageDialog(null, "Student not found!");
            return;
        }

        // Check if attendance record exists
        String checkQuery = "SELECT * FROM attendance WHERE class_id = ? AND student_id = ? AND class_date = ?";
        PreparedStatement checkPs = connection.prepareStatement(checkQuery);
        checkPs.setInt(1, classId);
        checkPs.setInt(2, studentId);
        checkPs.setString(3, checkInDate);
        ResultSet checkRs = checkPs.executeQuery();

        if (checkRs.next()) {
            // Record exists, update it
            String updateQuery;
            if (isCheckIn) {
                updateQuery = "UPDATE attendance SET checkin_time = ? WHERE class_id = ? AND student_id = ? AND class_date = ?";
                PreparedStatement updatePs = connection.prepareStatement(updateQuery);
                updatePs.setString(1, checkInTime);
                updatePs.setInt(2, classId);
                updatePs.setInt(3, studentId);
                updatePs.setString(4, checkInDate);
                updatePs.executeUpdate();
                emailService.sendEmail(studentEmail, "Attendance Notification", "You have checked in at " + checkInTime);
            } else {
                updateQuery = "UPDATE attendance SET checkout_time = ? WHERE class_id = ? AND student_id = ? AND class_date = ?";
                PreparedStatement updatePs = connection.prepareStatement(updateQuery);
                updatePs.setString(1, checkOutTime);
                updatePs.setInt(2, classId);
                updatePs.setInt(3, studentId);
                updatePs.setString(4, checkInDate);
                updatePs.executeUpdate();
                emailService.sendEmail(studentEmail, "Attendance Notification", "You have checked out at " + checkOutTime);
            }
        } else {
            // Record does not exist, insert a new one
            String insertQuery = "INSERT INTO attendance (class_id, student_id, class_date, checkin_time, checkout_time) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertPs = connection.prepareStatement(insertQuery);
            insertPs.setInt(1, classId);
            insertPs.setInt(2, studentId);
            insertPs.setString(3, checkInDate);
            if (isCheckIn) {
                insertPs.setString(4, checkInTime);
                insertPs.setString(5, null);
                emailService.sendEmail(studentEmail, "Attendance Notification", "You have checked in at " + checkInTime);
            } else {
                insertPs.setString(4, null);
                insertPs.setString(5, checkOutTime);
                emailService.sendEmail(studentEmail, "Attendance Notification", "You have checked out at " + checkOutTime);
            }
            insertPs.executeUpdate();
        }

        JOptionPane.showMessageDialog(null, "Attendance Recorded Successfully");
        connection.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}




public List<String> fetchSubjects() {
    List<String> subjects = new ArrayList<>();
    db_connection db = new db_connection();
    try {
        Connection connection = db.getConnection();
        String query = "SELECT subject FROM classes";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            subjects.add(rs.getString("subject"));
        }
        connection.close();
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
    return subjects;
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
