package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.Login_Teacher;
import View.Teacher_Dashboard;
import Model.loginQuery;

public class teacherLogin implements ActionListener
{
    private Login_Teacher loginTeacher;
    
	public teacherLogin(Login_Teacher loginTeacher) 
	{
		this.loginTeacher = loginTeacher;
	}
    
    
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if (e.getSource() == loginTeacher.btn_Login) 
		{
			String username = loginTeacher.textField_Username.getText();
			String password = String.valueOf(loginTeacher.passwordField.getPassword());
			loginQuery login = new loginQuery(username, password);
			if(login.loginSuccess())
			{
				loginTeacher.dispose();
				new Teacher_Dashboard().setVisible(true);	
				
			}
			
		}
		
	}

}
