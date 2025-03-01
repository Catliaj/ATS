package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.Login_Menu;
import View.Login_Teacher;
import View.Student_Checks;
import Model.loginQuery;
import View.Teacher_Dashboard;
public class LoginActionButton implements ActionListener
{
	private Login_Menu loginMenu;
	private Login_Teacher loginTeacher;

    public LoginActionButton(Login_Menu loginMenu) 
    {
        this.loginMenu = loginMenu;
    }
    
	
    

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if (e.getSource() == loginMenu.btn_TeacherLogin) 
		{
			loginMenu.dispose();
			new Login_Teacher().setVisible(true);
		} 
		if (e.getSource() == loginMenu.btn_StudentAttendance) 
		{
			// student.setVisible(true);
			loginMenu.dispose();
			new Student_Checks().setVisible(true);
		}
		
		
		
	}

}
