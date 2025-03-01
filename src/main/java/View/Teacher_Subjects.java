package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Controller.SidePanelButtonActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;


public class Teacher_Subjects extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Subject;
	private JTextField textField_End;
	private JTextField textField_Start;
	private JTable table;
	public JButton btn_Dashboard;
	public JButton btn_Attendance;
	public JButton btn_ClassRoll;
	public JButton btn_Enrollment;
	public JButton btn_Classes;
	public JButton btn_Exit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher_Subjects frame = new Teacher_Subjects();
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
	public Teacher_Subjects() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1334, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Background = new JLabel("");
		lbl_Background.setIcon(new ImageIcon(Teacher_Subjects.class.getResource("/Resources/Background for Student Attendance.png")));
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
		btn_Classes.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 4));
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
		
		
		
		JLabel lbl_Subject = new JLabel("Subject:");
		lbl_Subject.setVerticalAlignment(SwingConstants.TOP);
		lbl_Subject.setForeground(Color.WHITE);
		lbl_Subject.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_Subject.setBounds(315, 153, 131, 35);
		panel.add(lbl_Subject);
		
		textField_Subject = new JTextField();
		textField_Subject.setForeground(new Color(57, 57, 57));
		textField_Subject.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_Subject.setColumns(10);
		textField_Subject.setBackground(new Color(255, 242, 226));
		textField_Subject.setBounds(315, 181, 171, 25);
		panel.add(textField_Subject);
		
		
		
		JLabel lbl_Start = new JLabel("Start-time::");
		lbl_Start.setVerticalAlignment(SwingConstants.TOP);
		lbl_Start.setForeground(Color.WHITE);
		lbl_Start.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_Start.setBounds(315, 215, 131, 35);
		panel.add(lbl_Start);
		
		textField_Start = new JTextField();
		textField_Start.setForeground(new Color(57, 57, 57));
		textField_Start.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_Start.setColumns(10);
		textField_Start.setBackground(new Color(255, 242, 226));
		textField_Start.setBounds(315, 244, 171, 25);
		panel.add(textField_Start);
		
		
		
		JLabel lbl_End = new JLabel("End-time::");
		lbl_End.setVerticalAlignment(SwingConstants.TOP);
		lbl_End.setForeground(Color.WHITE);
		lbl_End.setFont(new Font("Brush Script MT", Font.BOLD, 24));
		lbl_End.setBounds(315, 279, 147, 35);
		panel.add(lbl_End);
		
		textField_End = new JTextField();
		textField_End.setForeground(new Color(57, 57, 57));
		textField_End.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		textField_End.setColumns(10);
		textField_End.setBackground(new Color(255, 242, 226));
		textField_End.setBounds(315, 307, 171, 25);
		panel.add(textField_End);
		
		
		
		JButton btn_Update = new JButton("Update");
		btn_Update.setForeground(new Color(255, 214, 0));
		btn_Update.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		btn_Update.setFocusPainted(false);
		btn_Update.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
		btn_Update.setBackground(new Color(174, 122, 52));
		btn_Update.setBounds(370, 361, 92, 20);
		panel.add(btn_Update);
		
		JButton btn_Delete = new JButton("Delete");
		btn_Delete.setForeground(new Color(255, 214, 0));
		btn_Delete.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		btn_Delete.setFocusPainted(false);
		btn_Delete.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
		btn_Delete.setBackground(new Color(174, 122, 52));
		btn_Delete.setBounds(370, 391, 92, 20);
		panel.add(btn_Delete);
		
		JButton btn_Clear = new JButton("Clear");
		btn_Clear.setForeground(new Color(255, 214, 0));
		btn_Clear.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		btn_Clear.setFocusPainted(false);
		btn_Clear.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 2));
		btn_Clear.setBackground(new Color(174, 122, 52));
		btn_Clear.setBounds(370, 421, 92, 20);
		panel.add(btn_Clear);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false); 
		scrollPane.getViewport().setOpaque(false); 
		scrollPane.setBorder(BorderFactory.createLineBorder(new Color(255, 214, 0), 4));
		scrollPane.setBounds(626, 142, 641, 546);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setOpaque(false);
		table.setBackground(new Color(0, 0, 0, 0));
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Subject", "Start-time", "End-time"
			}
		));
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 30));
		tableHeader.setBackground(new Color(255, 214, 0));
		tableHeader.setForeground(new Color(57, 57, 57));
		table.setRowHeight(25);
		table.setGridColor(new Color(255, 214, 0));
		scrollPane.setViewportView(table);
		
		//side panel action button
		
		SidePanelButtonActionListener controller = new SidePanelButtonActionListener(this);
		btn_Dashboard.addActionListener(controller);
		btn_Attendance.addActionListener(controller);
		btn_ClassRoll.addActionListener(controller);
		btn_Enrollment.addActionListener(controller);
		btn_Classes.addActionListener(controller);
		btn_Exit.addActionListener(controller);
	}

}
