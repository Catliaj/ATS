package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

import java.awt.Image;

public class View_ID extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btn_Close;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_ID frame = new View_ID();
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
	public View_ID() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_ID.class.getResource("/Resources/CAF_Logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Background = new JLabel("");
		lbl_Background.setIcon(new ImageIcon(View_ID.class.getResource("/Resources/ViewID Background.png")));
		lbl_Background.setBounds(0, 0, 900, 685);
		contentPane.add(lbl_Background);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color( 0, 0, 0, 0));
		panel.setBounds(0, 0, 900, 685);
		lbl_Background.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lbl_Front = new JLabel("FRONT");
		lbl_Front.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Front.setForeground(Color.WHITE);
		lbl_Front.setFont(new Font("Bahnschrift", Font.BOLD, 40));
		lbl_Front.setBounds(161, 58, 166, 50);
		panel.add(lbl_Front);
		
		
		
		JLabel lbl_HeaderTitle = new JLabel("CATALYST of ALL FUTURES");
		lbl_HeaderTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HeaderTitle.setForeground(Color.WHITE);
		lbl_HeaderTitle.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lbl_HeaderTitle.setBounds(167, 121, 232, 41);
		panel.add(lbl_HeaderTitle);
		
		JLabel lbl_HeaderTitle_1 = new JLabel("UNIVERSITY");
		lbl_HeaderTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HeaderTitle_1.setForeground(Color.WHITE);
		lbl_HeaderTitle_1.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lbl_HeaderTitle_1.setBounds(157, 140, 232, 41);
		panel.add(lbl_HeaderTitle_1);
		
		JLabel lbl_SubHeader = new JLabel("The National  Vocational University");
		lbl_SubHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SubHeader.setVerticalAlignment(SwingConstants.TOP);
		lbl_SubHeader.setForeground(Color.WHITE);
		lbl_SubHeader.setFont(new Font("Brush Script MT", Font.BOLD, 18));
		lbl_SubHeader.setBounds(161, 172, 232, 32);
		panel.add(lbl_SubHeader);
		
		
		
		JLabel lbl_StudentImage = new JLabel("");
		lbl_StudentImage.setBounds(176, 209, 139, 139);
		
		ImageIcon originalIcon = new ImageIcon("");
	      
        Image scaledImage = originalIcon.getImage().getScaledInstance(lbl_StudentImage.getWidth(), lbl_StudentImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        lbl_StudentImage.setIcon(resizedIcon);
		
		panel.add(lbl_StudentImage);
		
		
		
		JLabel lbl_Fname_MidIn = new JLabel("");
		lbl_Fname_MidIn.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Fname_MidIn.setForeground(Color.WHITE);
		lbl_Fname_MidIn.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lbl_Fname_MidIn.setBounds(98, 373, 294, 41);
		panel.add(lbl_Fname_MidIn);
		
		JLabel lbl_Surname = new JLabel("");
		lbl_Surname.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Surname.setForeground(Color.WHITE);
		lbl_Surname.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lbl_Surname.setBounds(98, 403, 294, 41);
		panel.add(lbl_Surname);
		
		
		
		JLabel lbl_Section = new JLabel("");
		lbl_Section.setVerticalAlignment(SwingConstants.TOP);
		lbl_Section.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Section.setForeground(Color.WHITE);
		lbl_Section.setFont(new Font("Brush Script MT", Font.BOLD, 35));
		lbl_Section.setBounds(127, 442, 232, 41);
		panel.add(lbl_Section);
		
		
		
		JLabel lbl_QR_Small = new JLabel("");
		lbl_QR_Small.setBounds(90, 498, 55, 55);
		

        ImageIcon originalIcon_2 = new ImageIcon("");
      
        Image scaledImage_2 = originalIcon_2.getImage().getScaledInstance(lbl_QR_Small.getWidth(), lbl_QR_Small.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedIcon_2 = new ImageIcon(scaledImage_2);

        lbl_QR_Small.setIcon(resizedIcon_2);
        
        panel.add(lbl_QR_Small);
		
		
		
		JLabel lbl_SRCode = new JLabel("SR-CODE:");
		lbl_SRCode.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SRCode.setForeground(Color.WHITE);
		lbl_SRCode.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lbl_SRCode.setBounds(158, 514, 81, 22);
		panel.add(lbl_SRCode);
		
		JLabel lbl_SRCODE_fillup = new JLabel("");
		lbl_SRCODE_fillup.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SRCODE_fillup.setForeground(Color.WHITE);
		lbl_SRCODE_fillup.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lbl_SRCODE_fillup.setBounds(245, 508, 139, 38);
		panel.add(lbl_SRCODE_fillup);
		
		
		
		JLabel lbl_Motto = new JLabel("With our skills, we will build a new world.");
		lbl_Motto.setVerticalAlignment(SwingConstants.TOP);
		lbl_Motto.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Motto.setForeground(Color.WHITE);
		lbl_Motto.setFont(new Font("Brush Script MT", Font.PLAIN, 18));
		lbl_Motto.setBounds(105, 566, 278, 19);
		panel.add(lbl_Motto);
		
		
		
		JLabel lbl_Back = new JLabel("BACK");
		lbl_Back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Back.setForeground(Color.WHITE);
		lbl_Back.setFont(new Font("Bahnschrift", Font.BOLD, 40));
		lbl_Back.setBounds(586, 60, 139, 38);
		panel.add(lbl_Back);
		
		
		
		JLabel lbl_SRCode_back = new JLabel("SR-CODE:");
		lbl_SRCode_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SRCode_back.setForeground(Color.WHITE);
		lbl_SRCode_back.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lbl_SRCode_back.setBounds(615, 130, 81, 22);
		panel.add(lbl_SRCode_back);
		
		JLabel lbl_SRCODE_fillup_back = new JLabel("");
		lbl_SRCODE_fillup_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SRCODE_fillup_back.setForeground(Color.WHITE);
		lbl_SRCODE_fillup_back.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lbl_SRCODE_fillup_back.setBounds(586, 150, 139, 38);
		panel.add(lbl_SRCODE_fillup_back);
		
		
		
		JLabel lbl_Email = new JLabel("Email:");
		lbl_Email.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Email.setForeground(Color.WHITE);
		lbl_Email.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lbl_Email.setBounds(619, 457, 81, 22);
		panel.add(lbl_Email);
		
		JLabel lbl_Email_fillup = new JLabel("");
		lbl_Email_fillup.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Email_fillup.setForeground(Color.WHITE);
		lbl_Email_fillup.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		lbl_Email_fillup.setBounds(496, 480, 316, 22);
		panel.add(lbl_Email_fillup);
		
		
		
		JLabel lbl_Note_1 = new JLabel("Note: If found, please contact the email above");
		lbl_Note_1.setVerticalAlignment(SwingConstants.TOP);
		lbl_Note_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Note_1.setForeground(Color.WHITE);
		lbl_Note_1.setFont(new Font("Brush Script MT", Font.PLAIN, 20));
		lbl_Note_1.setBounds(497, 512, 316, 24);
		panel.add(lbl_Note_1);
		
		JLabel lbl_Note_1_1 = new JLabel("or return to the nearest CAF University");
		lbl_Note_1_1.setVerticalAlignment(SwingConstants.TOP);
		lbl_Note_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Note_1_1.setForeground(Color.WHITE);
		lbl_Note_1_1.setFont(new Font("Brush Script MT", Font.PLAIN, 20));
		lbl_Note_1_1.setBounds(497, 534, 316, 32);
		panel.add(lbl_Note_1_1);
		
		JLabel lbl_Note_1_1_1 = new JLabel("registrar office.");
		lbl_Note_1_1_1.setVerticalAlignment(SwingConstants.TOP);
		lbl_Note_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Note_1_1_1.setForeground(Color.WHITE);
		lbl_Note_1_1_1.setFont(new Font("Brush Script MT", Font.PLAIN, 20));
		lbl_Note_1_1_1.setBounds(497, 555, 316, 30);
		panel.add(lbl_Note_1_1_1);
		
		
		
		
        JLabel lbl_QR_Big = new JLabel();
        lbl_QR_Big.setBounds(547, 210, 225, 225);

        ImageIcon originalIcon_3 = new ImageIcon("");
      
        Image scaledImage_3 = originalIcon_3.getImage().getScaledInstance(lbl_QR_Big.getWidth(), lbl_QR_Big.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedIcon_3 = new ImageIcon(scaledImage_3);

        lbl_QR_Big.setIcon(resizedIcon_3);

        panel.add(lbl_QR_Big);


		
		
		
		btn_Close = new JButton("Close");
		btn_Close.setForeground(Color.WHITE);
		btn_Close.setFont(new Font("Brush Script MT", Font.BOLD, 20));
		btn_Close.setFocusPainted(false);
		btn_Close.setBackground(new Color(0, 0, 0, 0));
		btn_Close.setOpaque(false);
		btn_Close.setBorder(BorderFactory.createLineBorder(new Color(174, 122, 52), 4));
		btn_Close.setBounds(772, 640, 118, 35);
		panel.add(btn_Close);
	}
}
