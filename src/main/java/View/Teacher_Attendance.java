package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import javax.swing.SortOrder;
import Controller.SidePanelButtonActionListener;
import Model.StudentQuery;
import Controller.StudentAttendaceController;
public class Teacher_Attendance extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_Class;
	public JTextField textField_Date;
	public JTextField textField_StudentName;
	public JTextField textField_CheckIn;
	public JTextField textField_CheckOut;
	public JTable table;
	public JButton btn_Dashboard;
	public JButton btn_Attendance;
	public JButton btn_ClassRoll;
	public JButton btn_Enrollment;
	public JButton btn_Classes;
	public JButton btn_Exit;
	public JButton btn_Update;
	public JButton btn_Delete;
	public JButton btn_Clear;
	private JComboBox comboBox;
	StudentQuery populate = new StudentQuery();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher_Attendance frame = new Teacher_Attendance();
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
	public Teacher_Attendance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1334, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Background = new JLabel("");
		lbl_Background.setIcon(new ImageIcon(Teacher_Attendance.class.getResource("/Resources/Background for Student Attendance.png")));
		lbl_Background.setBounds(0, 0, 1320, 745);
		contentPane.add(lbl_Background);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color( 0, 0, 0, 0));
		panel.setBounds(0, 0, 1320, 745);
		lbl_Background.add(panel);
		panel.setLayout(null);
		
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
		btn_Attendance.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 4));
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
		
		
		
		JLabel lbl_Class = new JLabel("Class:");
		lbl_Class.setVerticalAlignment(SwingConstants.TOP);
		lbl_Class.setForeground(Color.WHITE);
		lbl_Class.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_Class.setBounds(330, 158, 131, 35);
		panel.add(lbl_Class);
		
		textField_Class = new JTextField();
		textField_Class.setForeground(new Color(57, 57, 57));
		textField_Class.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_Class.setColumns(10);
		textField_Class.setBackground(new Color(255, 242, 226));
		textField_Class.setBounds(330, 186, 224, 25);
		panel.add(textField_Class);
		
		
		
		JLabel lbl_StudentName = new JLabel("Student Name:");
		lbl_StudentName.setVerticalAlignment(SwingConstants.TOP);
		lbl_StudentName.setForeground(Color.WHITE);
		lbl_StudentName.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_StudentName.setBounds(330, 220, 131, 35);
		panel.add(lbl_StudentName);
		
		textField_StudentName = new JTextField();
		textField_StudentName.setForeground(new Color(57, 57, 57));
		textField_StudentName.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_StudentName.setColumns(10);
		textField_StudentName.setBackground(new Color(255, 242, 226));
		textField_StudentName.setBounds(330, 249, 224, 25);
		panel.add(textField_StudentName);
		
		
		
		JLabel lbl_Date = new JLabel("Date:");
		lbl_Date.setVerticalAlignment(SwingConstants.TOP);
		lbl_Date.setForeground(Color.WHITE);
		lbl_Date.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_Date.setBounds(330, 284, 131, 35);
		panel.add(lbl_Date);
		
		textField_Date = new JTextField();
		textField_Date.setForeground(new Color(57, 57, 57));
		textField_Date.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_Date.setColumns(10);
		textField_Date.setBackground(new Color(255, 242, 226));
		textField_Date.setBounds(330, 312, 224, 25);
		panel.add(textField_Date);
		
		
		
		JLabel lbl_CheckIn = new JLabel("Check-In:");
		lbl_CheckIn.setVerticalAlignment(SwingConstants.TOP);
		lbl_CheckIn.setForeground(Color.WHITE);
		lbl_CheckIn.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_CheckIn.setBounds(330, 346, 131, 35);
		panel.add(lbl_CheckIn);
		
		textField_CheckIn = new JTextField();
		textField_CheckIn.setForeground(new Color(57, 57, 57));
		textField_CheckIn.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_CheckIn.setColumns(10);
		textField_CheckIn.setBackground(new Color(255, 242, 226));
		textField_CheckIn.setBounds(330, 377, 224, 25);
		panel.add(textField_CheckIn);
		
		
		
		JLabel lbl_CheckOut = new JLabel("Check-Out:");
		lbl_CheckOut.setVerticalAlignment(SwingConstants.TOP);
		lbl_CheckOut.setForeground(Color.WHITE);
		lbl_CheckOut.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_CheckOut.setBounds(330, 410, 131, 35);
		panel.add(lbl_CheckOut);
		
		textField_CheckOut = new JTextField();
		textField_CheckOut.setForeground(new Color(57, 57, 57));
		textField_CheckOut.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_CheckOut.setColumns(10);
		textField_CheckOut.setBackground(new Color(255, 242, 226));
		textField_CheckOut.setBounds(330, 442, 224, 25);
		panel.add(textField_CheckOut);
		
		
		
	    btn_Update = new JButton("Update");
		btn_Update.setForeground(new Color(255, 214, 0));
		btn_Update.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		btn_Update.setFocusPainted(false);
		btn_Update.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
		btn_Update.setBackground(new Color(174, 122, 52));
		btn_Update.setBounds(395, 499, 100, 30);
		panel.add(btn_Update);
		
	    btn_Delete = new JButton("Delete");
		btn_Delete.setForeground(new Color(255, 214, 0));
		btn_Delete.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		btn_Delete.setFocusPainted(false);
		btn_Delete.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
		btn_Delete.setBackground(new Color(174, 122, 52));
		btn_Delete.setBounds(395, 539, 100, 30);
		panel.add(btn_Delete);
		
	    btn_Clear = new JButton("Clear");
		btn_Clear.setForeground(new Color(255, 214, 0));
		btn_Clear.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		btn_Clear.setFocusPainted(false);
		btn_Clear.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
		btn_Clear.setBackground(new Color(174, 122, 52));
		btn_Clear.setBounds(395, 579, 100, 30);
		panel.add(btn_Clear);
		
		

	    comboBox = new JComboBox();
		comboBox.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		comboBox.setBackground(new Color(255, 214, 0));
		comboBox.setForeground(new Color(57, 57, 57));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sort by ...", "Class", "Student Name", "Date"}));
		comboBox.setBorder(BorderFactory.createLineBorder(new Color(57, 57, 57), 4));
		comboBox.setBounds(625, 138, 224, 43);
		addComboBoxListener();
		panel.add(comboBox);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false); 
		scrollPane.getViewport().setOpaque(false); 
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 4));
		scrollPane.setBounds(626, 196, 641, 497);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setOpaque(false);
		table.setBackground(new Color(0, 0, 0, 0));
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Class", "Student Name", "Date", "Check-in", "Check-out"
			}
		));
		

		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.getSelectedRow();
		        if (row != -1) {
		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            textField_Class.setText(model.getValueAt(row, 0).toString());
		            textField_StudentName.setText(model.getValueAt(row, 1).toString());
		            textField_Date.setText(model.getValueAt(row, 2).toString());
		            textField_CheckIn.setText(model.getValueAt(row, 3).toString());
		            textField_CheckOut.setText(model.getValueAt(row, 4).toString());
		        }
		    }
		});

		
		populate.populateAttendanceTable(table);
		
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
		
		JLabel lbl_HeaderTitle = new JLabel("Student Attendance");
		lbl_HeaderTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HeaderTitle.setForeground(Color.WHITE);
		lbl_HeaderTitle.setFont(new Font("Brush Script MT", Font.BOLD, 50));
		lbl_HeaderTitle.setBounds(733, 44, 426, 54);
		panel.add(lbl_HeaderTitle);
		
		JLabel lbl_HeaderTitle_Shadow = new JLabel("Student Attendance");
		lbl_HeaderTitle_Shadow.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HeaderTitle_Shadow.setForeground(new Color(57, 57, 57));
		lbl_HeaderTitle_Shadow.setFont(new Font("Brush Script MT", Font.BOLD, 50));
		lbl_HeaderTitle_Shadow.setBounds(735, 46, 426, 54);
		panel.add(lbl_HeaderTitle_Shadow);
		
		JLabel lbl_TeacherIcon_2 = new JLabel("");
		lbl_TeacherIcon_2.setIcon(new ImageIcon(Login_Menu.class.getResource("/Resources/Teacher_Icon.png")));
		lbl_TeacherIcon_2.setBounds(1169, 66, 76, 47);
		panel.add(lbl_TeacherIcon_2);
		
		
		
		//side panel button action listener
		SidePanelButtonActionListener controller = new SidePanelButtonActionListener(this);
		
		btn_Dashboard.addActionListener(controller);
		btn_Attendance.addActionListener(controller);
		btn_ClassRoll.addActionListener(controller);
		btn_Enrollment.addActionListener(controller);
		btn_Classes.addActionListener(controller);
		btn_Exit.addActionListener(controller);
		
		// main controller
		StudentAttendaceController controllermain = new StudentAttendaceController(this);
		btn_Update.addActionListener(controllermain);
		btn_Delete.addActionListener(controllermain);
		btn_Clear.addActionListener(controllermain);
	}
	

	private void addComboBoxListener() {
	    comboBox.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String selectedItem = comboBox.getSelectedItem().toString();
	            DefaultTableModel model = (DefaultTableModel) table.getModel();
	            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
	            table.setRowSorter(sorter);
	
	            switch (selectedItem) {
	                case "Class":
	                    sorter.setSortKeys(Collections.singletonList(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
	                    break;
	                case "Student Name":
	                    sorter.setSortKeys(Collections.singletonList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
	                    break;
	                case "Date":
	                    sorter.setSortKeys(Collections.singletonList(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
	                    break;
	                default:
	                    sorter.setSortKeys(null);
	                    break;
	            }
	        }
	    });
	}

}
