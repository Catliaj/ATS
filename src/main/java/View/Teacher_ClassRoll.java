package View;

import java.awt.Color; import java.awt.Dimension; import java.awt.EventQueue; import java.awt.Font; import java.awt.Image; import java.awt.event.ActionEvent; import java.awt.event.ActionListener; import java.awt.event.MouseAdapter; import java.awt.event.MouseEvent;
import java.util.Collections;

import javax.swing.BorderFactory; import javax.swing.ImageIcon; import javax.swing.JButton; import javax.swing.JComboBox; import javax.swing.DefaultComboBoxModel; import javax.swing.JFrame; import javax.swing.JLabel; import javax.swing.JOptionPane; import javax.swing.JPanel; import javax.swing.JScrollPane; import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.JTable; import javax.swing.border.EmptyBorder; import javax.swing.table.DefaultTableModel; import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import Controller.SidePanelButtonActionListener; import Model.StudentQuery;

public class Teacher_ClassRoll extends JFrame {

private static final long serialVersionUID = 1L;
private JPanel contentPane;
private JTextField textField_SRCode;
private JTextField textField_FirstName;
private JTextField textField_MidIn;
private JTextField textField_Surname;
private JTextField textField_Section;
private JTextField textField_Email;
private JTable table;
public JButton btn_Dashboard;
public JButton btn_Attendance;
public JButton btn_ClassRoll;
public JButton btn_Enrollment;
public JButton btn_Classes;
public JButton btn_Exit;
private JLabel picture;

StudentQuery populate = new StudentQuery();

public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                Teacher_ClassRoll frame = new Teacher_ClassRoll();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public Teacher_ClassRoll() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 1334, 782);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setLocationRelativeTo(null);

    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel lbl_Background = new JLabel("");
    lbl_Background.setIcon(new ImageIcon(Teacher_ClassRoll.class.getResource("/Resources/Background for Class Roll.png")));
    lbl_Background.setBounds(0, 0, 1320, 745);
    contentPane.add(lbl_Background);

    JPanel panel = new JPanel();
    panel.setOpaque(false);
    panel.setBackground(new Color(0, 0, 0, 0));
    panel.setBounds(0, 0, 1320, 745);
    lbl_Background.add(panel);
    panel.setLayout(null);

    picture = new JLabel("");
    picture.setBounds(368, 66, 124, 124);
    
    ImageIcon originalIcon = new ImageIcon("");
    
    Image scaledImage = originalIcon.getImage().getScaledInstance(picture.getWidth(), picture.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon resizedIcon = new ImageIcon(scaledImage);

    picture.setIcon(resizedIcon);
    
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
    btn_ClassRoll.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 4));
    btn_ClassRoll.setBounds(10, 363, 251, 69);
    panel.add(btn_ClassRoll);

    btn_Enrollment = new JButton("Enrollment");
    btn_Enrollment.setForeground(Color.WHITE);
    btn_Enrollment.setFont(new Font("Brush Script MT", Font.BOLD, 40));
    btn_Enrollment.setFocusPainted(false);
    btn_Enrollment.setBackground(new Color(0, 0, 0, 0));
    btn_Enrollment.setOpaque(false);
    btn_Enrollment.setBorder(BorderFactory.createLineBorder(new Color(174, 122, 52), 4));
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

    JLabel lbl_SRCode = new JLabel("SR-Code:");
    lbl_SRCode.setVerticalAlignment(SwingConstants.TOP);
    lbl_SRCode.setForeground(Color.WHITE);
    lbl_SRCode.setFont(new Font("Brush Script MT", Font.BOLD, 24));
    lbl_SRCode.setBounds(331, 221, 131, 35);
    panel.add(lbl_SRCode);

    textField_SRCode = new JTextField();
    textField_SRCode.setHorizontalAlignment(SwingConstants.CENTER);
    textField_SRCode.setForeground(new Color(57, 57, 57));
    textField_SRCode.setFont(new Font("Bahnschrift", Font.BOLD, 20));
    textField_SRCode.setColumns(10);
    textField_SRCode.setBackground(new Color(255, 242, 226));
    textField_SRCode.setBounds(331, 249, 105, 25);
    panel.add(textField_SRCode);

    JLabel lbl_FirstName = new JLabel("First Name:");
    lbl_FirstName.setVerticalAlignment(SwingConstants.TOP);
    lbl_FirstName.setForeground(Color.WHITE);
    lbl_FirstName.setFont(new Font("Brush Script MT", Font.BOLD, 24));
    lbl_FirstName.setBounds(331, 283, 131, 35);
    panel.add(lbl_FirstName);

    textField_FirstName = new JTextField();
    textField_FirstName.setForeground(new Color(57, 57, 57));
    textField_FirstName.setFont(new Font("Bahnschrift", Font.BOLD, 20));
    textField_FirstName.setColumns(10);
    textField_FirstName.setBackground(new Color(255, 242, 226));
    textField_FirstName.setBounds(331, 312, 122, 25);
    panel.add(textField_FirstName);

    JLabel lbl_MidIn = new JLabel("Middle Initial:");
    lbl_MidIn.setVerticalAlignment(SwingConstants.TOP);
    lbl_MidIn.setForeground(Color.WHITE);
    lbl_MidIn.setFont(new Font("Brush Script MT", Font.BOLD, 24));
    lbl_MidIn.setBounds(331, 347, 152, 35);
    panel.add(lbl_MidIn);

    textField_MidIn = new JTextField();
    textField_MidIn.setHorizontalAlignment(SwingConstants.CENTER);
    textField_MidIn.setForeground(new Color(57, 57, 57));
    textField_MidIn.setFont(new Font("Bahnschrift", Font.BOLD, 20));
    textField_MidIn.setColumns(10);
    textField_MidIn.setBackground(new Color(255, 242, 226));
    textField_MidIn.setBounds(331, 375, 30, 25);
    panel.add(textField_MidIn);

    JLabel lbl_Surname = new JLabel("Surname:");
    lbl_Surname.setVerticalAlignment(SwingConstants.TOP);
    lbl_Surname.setForeground(Color.WHITE);
    lbl_Surname.setFont(new Font("Brush Script MT", Font.BOLD, 24));
    lbl_Surname.setBounds(331, 409, 131, 35);
    panel.add(lbl_Surname);

    textField_Surname = new JTextField();
    textField_Surname.setForeground(new Color(57, 57, 57));
    textField_Surname.setFont(new Font("Bahnschrift", Font.BOLD, 20));
    textField_Surname.setColumns(10);
    textField_Surname.setBackground(new Color(255, 242, 226));
    textField_Surname.setBounds(331, 440, 152, 25);
    panel.add(textField_Surname);

    JLabel lbl_Section = new JLabel("Section:");
    lbl_Section.setVerticalAlignment(SwingConstants.TOP);
    lbl_Section.setForeground(Color.WHITE);
    lbl_Section.setFont(new Font("Brush Script MT", Font.BOLD, 24));
    lbl_Section.setBounds(331, 473, 131, 35);
    panel.add(lbl_Section);

    textField_Section = new JTextField();
    textField_Section.setHorizontalAlignment(SwingConstants.CENTER);
    textField_Section.setForeground(new Color(57, 57, 57));
    textField_Section.setFont(new Font("Bahnschrift", Font.BOLD, 20));
    textField_Section.setColumns(10);
    textField_Section.setBackground(new Color(255, 242, 226));
    textField_Section.setBounds(331, 505, 161, 25);
    panel.add(textField_Section);

    JLabel lbl_Email = new JLabel("Email:");
    lbl_Email.setVerticalAlignment(SwingConstants.TOP);
    lbl_Email.setForeground(Color.WHITE);
    lbl_Email.setFont(new Font("Brush Script MT", Font.BOLD, 24));
    lbl_Email.setBounds(331, 540, 131, 35);
    panel.add(lbl_Email);

    textField_Email = new JTextField();
    textField_Email.setForeground(new Color(57, 57, 57));
    textField_Email.setFont(new Font("Bahnschrift", Font.BOLD, 15));
    textField_Email.setColumns(10);
    textField_Email.setBackground(new Color(255, 242, 226));
    textField_Email.setBounds(308, 572, 235, 25);
    panel.add(textField_Email);

    JButton btn_Update = new JButton("Update");
    btn_Update.setForeground(new Color(255, 214, 0));
    btn_Update.setFont(new Font("Bahnschrift", Font.BOLD, 13));
    btn_Update.setFocusPainted(false);
    btn_Update.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
    btn_Update.setBackground(new Color(174, 122, 52));
    btn_Update.setBounds(326, 614, 92, 20);
    panel.add(btn_Update);

    JButton btn_UnEnroll = new JButton("Un-enroll");
    btn_UnEnroll.setForeground(new Color(255, 214, 0));
    btn_UnEnroll.setFont(new Font("Bahnschrift", Font.BOLD, 13));
    btn_UnEnroll.setFocusPainted(false);
    btn_UnEnroll.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
    btn_UnEnroll.setBackground(new Color(174, 122, 52));
    btn_UnEnroll.setBounds(429, 614, 92, 20);
    panel.add(btn_UnEnroll);

    JButton btn_Clear = new JButton("Clear");
    btn_Clear.setForeground(new Color(255, 214, 0));
    btn_Clear.setFont(new Font("Bahnschrift", Font.BOLD, 13));
    btn_Clear.setFocusPainted(false);
    btn_Clear.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
    btn_Clear.setBackground(new Color(174, 122, 52));
    btn_Clear.setBounds(376, 644, 92, 20);
    panel.add(btn_Clear);

    JComboBox<String> comboBox = new JComboBox<>();
    comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Sort By ...", "Sr-Code", "First Name", "Last Name", "Section"}));
    comboBox.setForeground(new Color(57, 57, 57));
    comboBox.setFont(new Font("Bahnschrift", Font.BOLD, 20));
    comboBox.setBorder(BorderFactory.createLineBorder(new Color(57, 57, 57), 4));
    comboBox.setBackground(new Color(255, 214, 0));
    comboBox.setBounds(602, 137, 224, 43);
    comboBox.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedItem = (String) comboBox.getSelectedItem();
            sortTable(selectedItem);
        }
    });
    panel.add(comboBox);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setOpaque(false);
    scrollPane.getViewport().setOpaque(false);
    scrollPane.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 4));
    scrollPane.setBounds(602, 195, 663, 488);
    panel.add(scrollPane);

    table = new JTable();
    table.setOpaque(false);
    table.setBackground(new Color(0, 0, 0, 0));
    table.setForeground(Color.WHITE);
    table.setFont(new Font("Bahnschrift", Font.BOLD, 15));
    table.setModel(new DefaultTableModel(
        new Object[][] {
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},
            {null, null, null, null, null, null},
        },
        new String[] {
            "SR-Code", "First Name", "M.I.", "Surname", "Section", "Email"
        }
    ));

    table.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent evt) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String srCode = table.getValueAt(selectedRow, 0).toString();
                textField_SRCode.setText(srCode);
                textField_FirstName.setText(table.getValueAt(selectedRow, 1).toString());
                textField_MidIn.setText(table.getValueAt(selectedRow, 2).toString());
                textField_Surname.setText(table.getValueAt(selectedRow, 3).toString());
                textField_Section.setText(table.getValueAt(selectedRow, 4).toString());
                textField_Email.setText(table.getValueAt(selectedRow, 5).toString());

                ImageIcon imageIcon = populate.getStudentImage(srCode);
                if (imageIcon != null) {
                    Image image = imageIcon.getImage().getScaledInstance(119, 121, Image.SCALE_SMOOTH);
                    picture.setIcon(new ImageIcon(image));
                } else {
                    picture.setIcon(null);
                    JOptionPane.showMessageDialog(null, "Image not found for Student ID!");
                }
            }
        }
    });

    JButton btn_ViewQR = new JButton("View QR");
    btn_ViewQR.setForeground(new Color(255, 214, 0));
    btn_ViewQR.setFont(new Font("Bahnschrift", Font.BOLD, 13));
    btn_ViewQR.setFocusPainted(false);
    btn_ViewQR.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
    btn_ViewQR.setBackground(new Color(174, 122, 52));
    btn_ViewQR.setBounds(326, 685, 92, 20);
    panel.add(btn_ViewQR);
    
    JButton btn_ViewID = new JButton("View ID");
	btn_ViewID.setForeground(new Color(255, 214, 0));
	btn_ViewID.setFont(new Font("Bahnschrift", Font.BOLD, 13));
	btn_ViewID.setFocusPainted(false);
	btn_ViewID.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
	btn_ViewID.setBackground(new Color(174, 122, 52));
	btn_ViewID.setBounds(429, 685, 92, 20);
	panel.add(btn_ViewID);


	btn_ViewQR.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String srCode = textField_SRCode.getText();
	        if (!srCode.isEmpty()) {
	            ImageIcon qrCodeIcon = populate.getQRCodeImage(srCode);
	            if (qrCodeIcon != null) {
	                Image qrImage = qrCodeIcon.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
	                ImageIcon scaledQrCodeIcon = new ImageIcon(qrImage);
	                JOptionPane.showMessageDialog(null, "", "QR Code", JOptionPane.INFORMATION_MESSAGE, scaledQrCodeIcon);
	            } else {
	                JOptionPane.showMessageDialog(null, "QR Code not found for Student ID!");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Please select a student first!");
	        }
	    }
	});


    populate.populateStudentTable(table);

    JTableHeader tableHeader = table.getTableHeader();
    tableHeader.setFont(new Font("Bahnschrift", Font.BOLD, 17));
    tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 30));
    tableHeader.setBackground(new Color(255, 214, 0));
    tableHeader.setForeground(new Color(57, 57, 57));
    table.setRowHeight(25);
    table.setGridColor(new Color(255, 214, 0));
    scrollPane.setViewportView(table);
	
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
	lbl_TeacherIcon.setBounds(647, 66, 76, 47);
	panel.add(lbl_TeacherIcon);
	
	JLabel lbl_HeaderTitle = new JLabel("Class Roll");
	lbl_HeaderTitle.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_HeaderTitle.setForeground(Color.WHITE);
	lbl_HeaderTitle.setFont(new Font("Brush Script MT", Font.BOLD, 50));
	lbl_HeaderTitle.setBounds(733, 44, 426, 54);
	panel.add(lbl_HeaderTitle);
	
	JLabel lbl_HeaderTitle_Shadow = new JLabel("Class Roll");
	lbl_HeaderTitle_Shadow.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_HeaderTitle_Shadow.setForeground(new Color(57, 57, 57));
	lbl_HeaderTitle_Shadow.setFont(new Font("Brush Script MT", Font.BOLD, 50));
	lbl_HeaderTitle_Shadow.setBounds(735, 46, 426, 54);
	panel.add(lbl_HeaderTitle_Shadow);
	
	JLabel lbl_TeacherIcon_2 = new JLabel("");
	lbl_TeacherIcon_2.setIcon(new ImageIcon(Login_Menu.class.getResource("/Resources/Teacher_Icon.png")));
	lbl_TeacherIcon_2.setBounds(1169, 66, 76, 47);
	panel.add(lbl_TeacherIcon_2);
	

    SidePanelButtonActionListener controller = new SidePanelButtonActionListener(this);
    btn_Dashboard.addActionListener(controller);
    btn_Attendance.addActionListener(controller);
    btn_ClassRoll.addActionListener(controller);
    btn_Enrollment.addActionListener(controller);
    btn_Classes.addActionListener(controller);
    btn_Exit.addActionListener(controller);
}

private void sortTable(String criteria) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    table.setRowSorter(sorter);

    switch (criteria) {
        case "Sr-Code":
            sorter.setSortKeys(Collections.singletonList(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
            break;
        case "First Name":
            sorter.setSortKeys(Collections.singletonList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
            break;
        case "Last Name":
            sorter.setSortKeys(Collections.singletonList(new RowSorter.SortKey(3, SortOrder.ASCENDING)));
            break;
        case "Section":
            sorter.setSortKeys(Collections.singletonList(new RowSorter.SortKey(4, SortOrder.ASCENDING)));
            break;
        default:
            sorter.setSortKeys(null);
            break;
    }
}
}