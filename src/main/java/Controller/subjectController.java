package Controller;
import Model.subjectsQuery;
import View.Teacher_Subjects;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class subjectController implements ActionListener
{
    private subjectsQuery subjectQuery;
    private Teacher_Subjects teacher_subjects;
    
    public subjectController(Teacher_Subjects teacher_subjects) {
		this.teacher_subjects = teacher_subjects;
	}
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == teacher_subjects.btn_Add)
        {
            String subjectName = teacher_subjects.textField_Subject.getText();
            String startTime = teacher_subjects.textField_Start.getText();
            String endTime = teacher_subjects.textField_End.getText();
            subjectQuery.addSubject(subjectName, startTime, endTime);
            teacher_subjects.textField_Subject.setText("");
			teacher_subjects.textField_Start.setText("");
			teacher_subjects.textField_End.setText("");
        }
        else if(e.getSource() == teacher_subjects.btn_Update)
        {
        	String subjectName = teacher_subjects.textField_Subject.getText();
            String startTime = teacher_subjects.textField_Start.getText();
            String endTime = teacher_subjects.textField_End.getText();
            subjectQuery.updateSubject(subjectName, startTime, endTime);
            teacher_subjects.textField_Subject.setText("");
			teacher_subjects.textField_Start.setText("");
			teacher_subjects.textField_End.setText("");
        }
        else if(e.getSource() == teacher_subjects.btn_Delete) 
        {
            String subjectName = teacher_subjects.textField_Subject.getText();
            subjectQuery.deleteSubject(subjectName);
            teacher_subjects.textField_Subject.setText("");
			teacher_subjects.textField_Start.setText("");
			teacher_subjects.textField_End.setText("");
        }
		else if (e.getSource() == teacher_subjects.btn_Clear) {
			teacher_subjects.textField_Subject.setText("");
			teacher_subjects.textField_Start.setText("");
			teacher_subjects.textField_End.setText("");
		}
    }
}

	
	
	
	
	

