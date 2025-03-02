package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import View.*;
import View.Teacher_ClassRoll;

public class SidePanelButtonActionListener implements ActionListener {
    private Object currentView; // Can hold any view object

    public SidePanelButtonActionListener(Object currentView) {
        this.currentView = currentView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();

        if (sourceButton.getText().equalsIgnoreCase("Dashboard")) 
        {
            switchView(new Teacher_Dashboard());
            
        } 
        else if (sourceButton.getText().equalsIgnoreCase("Attendance")) 
        {
            switchView(new Teacher_Attendance());
        } 
        else if (sourceButton.getText().equalsIgnoreCase("Class Roll")) 
        {
            switchView(new Teacher_ClassRoll());
        } 
        else if (sourceButton.getText().equalsIgnoreCase("Enrollment")) 
        {
            switchView(new Teacher_Enrollments());
        } 
        else if (sourceButton.getText().equalsIgnoreCase("Classes")) 
        {
            switchView(new Teacher_Subjects());
        } 
        else if (sourceButton.getText().equalsIgnoreCase("Exit")) 
        {
            switchView(new Login_Menu());
        }
        
    }

    private void switchView(Object newView) 
    {
        if (currentView instanceof Teacher_Dashboard) 
        {
            ((Teacher_Dashboard) currentView).dispose();
        } 
        else if (currentView instanceof Teacher_Enrollments) 
        {
            ((Teacher_Enrollments) currentView).dispose();
        } 
        else if (currentView instanceof Teacher_ClassRoll) 
        {
            ((Teacher_ClassRoll) currentView).dispose();
        } 
        else if (currentView instanceof Teacher_Attendance) 
        {
            ((Teacher_Attendance) currentView).dispose();
        } 
        else if (currentView instanceof Teacher_Subjects) 
        {
            ((Teacher_Subjects) currentView).dispose();
        } 
        else if (currentView instanceof Login_Menu) 
        {
            ((Login_Menu) currentView).dispose();
        }
        else if(currentView instanceof Student_Checks)
        {
        	((Student_Checks)currentView).dispose();
        }
        ((javax.swing.JFrame) newView).setVisible(true);
    }
}
