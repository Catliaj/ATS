package Controller;
import View.Teacher_Attendance;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.StudentQuery;

public class StudentAttendaceController implements ActionListener
{
	private Teacher_Attendance attendance;
	StudentQuery query = new StudentQuery();
	public StudentAttendaceController (Teacher_Attendance attendance) 
	{
		this.attendance = attendance;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == attendance.btn_Update)
		{
			String fullname = attendance.textField_StudentName.getText();
			String date = attendance.textField_Date.getText();
			String Check_in = attendance.textField_CheckIn.getText();
			String Check_out = attendance.textField_CheckOut.getText();
			query.updateAttendance(fullname, date, Check_in, Check_out);
			query.populateAttendanceTable(attendance.table);
			clearTextFields();
		}
		else if(e.getSource() == attendance.btn_Delete)
		{
			String fullname = attendance.textField_StudentName.getText();
			String date = attendance.textField_Date.getText();
			query.deleteAttendance(fullname, date);
			query.populateAttendanceTable(attendance.table);
			clearTextFields();
		}
		else if(e.getSource() == attendance.btn_Clear)
		{
			clearTextFields();
		}
	}
	

	private void clearTextFields() {
		attendance.textField_Class.setText("");
	    attendance.textField_StudentName.setText("");
	    attendance.textField_Date.setText("");
	    attendance.textField_CheckIn.setText("");
	    attendance.textField_CheckOut.setText("");
	}

	
	
	
	
}
