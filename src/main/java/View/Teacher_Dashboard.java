
package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import Controller.SidePanelButtonActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.db_connection;
import javax.swing.SwingConstants;

public class Teacher_Dashboard extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JButton btn_Dashboard;
    public JButton btn_Attendance;
    public JButton btn_ClassRoll;
    public JButton btn_Enrollment;
    public JButton btn_Classes;
    public JButton btn_Exit;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Teacher_Dashboard frame = new Teacher_Dashboard();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Teacher_Dashboard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1334, 782);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbl_Background = new JLabel("");
        lbl_Background.setIcon(new ImageIcon(Teacher_Dashboard.class.getResource("/Resources/Background for Dashboard.png")));
        lbl_Background.setBounds(0, 0, 1320, 745);
        contentPane.add(lbl_Background);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setBackground(new Color(0, 0, 0, 0));
        panel.setBounds(0, 0, 1320, 745);
        lbl_Background.add(panel);
        panel.setLayout(null);

        btn_Dashboard = new JButton("Dashboard");
        btn_Dashboard.setForeground(new Color(255, 255, 255));
        btn_Dashboard.setFont(new Font("Brush Script MT", Font.BOLD, 40));
        btn_Dashboard.setBackground(new Color(0, 0, 0, 0));
        btn_Dashboard.setOpaque(false);
        btn_Dashboard.setFocusPainted(false);
        btn_Dashboard.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 4));
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
		lbl_TeacherIcon.setBounds(495, 67, 76, 47);
		panel.add(lbl_TeacherIcon);
		
		JLabel lbl_HeaderTitle = new JLabel("Dashboard");
		lbl_HeaderTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HeaderTitle.setForeground(Color.WHITE);
		lbl_HeaderTitle.setFont(new Font("Brush Script MT", Font.BOLD, 50));
		lbl_HeaderTitle.setBounds(581, 46, 426, 54);
		panel.add(lbl_HeaderTitle);
		
		JLabel lbl_HeaderTitle_Shadow = new JLabel("Dashboard");
		lbl_HeaderTitle_Shadow.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HeaderTitle_Shadow.setForeground(new Color(57, 57, 57));
		lbl_HeaderTitle_Shadow.setFont(new Font("Brush Script MT", Font.BOLD, 50));
		lbl_HeaderTitle_Shadow.setBounds(583, 48, 426, 54);
		panel.add(lbl_HeaderTitle_Shadow);
		
		JLabel lbl_TeacherIcon_2 = new JLabel("");
		lbl_TeacherIcon_2.setIcon(new ImageIcon(Login_Menu.class.getResource("/Resources/Teacher_Icon.png")));
		lbl_TeacherIcon_2.setBounds(1017, 67, 76, 47);
		panel.add(lbl_TeacherIcon_2);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setFont(new Font("Bahnschrift", Font.BOLD, 20));
        comboBox.setBackground(new Color(255, 214, 0));
        comboBox.setForeground(new Color(57, 57, 57));
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Filter by Day", "Filter by Week", "Filter by Month"}));
        comboBox.setBorder(BorderFactory.createLineBorder(new Color(57, 57, 57), 4));
        comboBox.setBounds(404, 136, 224, 43);
        panel.add(comboBox);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFilter = (String) comboBox.getSelectedItem();
                updateEnrollmentData(selectedFilter);
            }
        });

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(415, 202, 763, 481);
        panel.add(panel_1);
        panel_1.setLayout(new java.awt.BorderLayout());

        // Add the line chart to panel_1
        DefaultCategoryDataset dataset = createDataset();
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Student Attendance",
                "Date",
                "Attendance",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(763, 481));
        panel_1.add(chartPanel, java.awt.BorderLayout.CENTER);

        // Fetch and display enrollment data
        updateEnrollmentData("Filter by Day");

        SidePanelButtonActionListener controller = new SidePanelButtonActionListener(this);
        btn_Dashboard.addActionListener(controller);
        btn_Attendance.addActionListener(controller);
        btn_ClassRoll.addActionListener(controller);
        btn_Enrollment.addActionListener(controller);
        btn_Classes.addActionListener(controller);
        btn_Exit.addActionListener(controller);
    }

    private void updateEnrollmentData(String filter) {
        int[] enrollments = getEnrollmentsByFilter(filter);
        // Process the enrollments data as needed
    }

    private int[] getEnrollmentsByFilter(String filter) {
        int[] enrollments = new int[8];
        db_connection db = new db_connection();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = db.getConnection();
            String query = "";
            switch (filter) {
                case "Filter by Day":
                    query = "SELECT DAYOFWEEK(class_date) as day, COUNT(*) as count FROM ATTENDANCE GROUP BY day";
                    break;
                case "Filter by Week":
                    query = "SELECT WEEK(class_date) as week, COUNT(*) as count FROM ATTENDANCE GROUP BY week";
                    break;
                case "Filter by Month":
                    query = "SELECT MONTH(class_date) as month, COUNT(*) as count FROM ATTENDANCE GROUP BY month";
                    break;
            }
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int index = rs.getInt(1);
                int count = rs.getInt("count");
                enrollments[index - 1] = count; // Adjust index based on filter
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return enrollments;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<Attendance> attendanceList = getAttendanceData();

        for (Attendance attendance : attendanceList) {
            dataset.addValue(attendance.getCount(), "Attendance", attendance.getDate());
        }

        return dataset;
    }

    private List<Attendance> getAttendanceData() {
        List<Attendance> attendanceList = new ArrayList<>();
        db_connection db = new db_connection();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	
            connection = db.getConnection();
            String query = "SELECT class_date, COUNT(*) as count FROM ATTENDANCE GROUP BY class_date";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String date = rs.getString("class_date");
                int count = rs.getInt("count");
                attendanceList.add(new Attendance(date, count));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return attendanceList;
    }

    public List<Attendance> filterAttendanceData(List<Attendance> attendanceList, String startDate, String endDate) {
        List<Attendance> filteredList = new ArrayList<>();

        for (Attendance attendance : attendanceList) {
            if (attendance.getDate().compareTo(startDate) >= 0 && attendance.getDate().compareTo(endDate) <= 0) {
                filteredList.add(attendance);
            }
        }

        return filteredList;
    }
}

class Attendance {
    private String date;
    private int count;

    public Attendance(String date, int count) {
        this.date = date;
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public int getCount() {
        return count;
    }
}
