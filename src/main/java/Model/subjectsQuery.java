package Model;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class subjectsQuery 
{
	db_connection dbConnection = new db_connection();
	Connection connection;
	
	public void addSubject(String subjectName, String startTime , String endTime) 
	{
		
		try 
		{
			connection = dbConnection.getConnection();
			String query = "INSERT INTO classes (subject, start_time, end_time,) VALUES (?, ?, ?)";
			java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, subjectName);
			preparedStatement.setString(2, startTime);
			preparedStatement.setString(3, endTime);
			connection.createStatement().executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Subject Added Successfully");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void updateSubject(String subjectName, String startTime, String endTime) {
		try {
			connection = dbConnection.getConnection();
			String query = "UPDATE classes SET subject = ?, start_time = ?, end_time = ? WHERE subject = ?";
			java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, subjectName);
			preparedStatement.setString(2, startTime);
			preparedStatement.setString(3, endTime);
			preparedStatement.setString(4, subjectName);
			connection.createStatement().executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Subject Updated Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteSubject(String subjectName) 
	{
		try 
		{
			connection = dbConnection.getConnection();
			String query = "DELETE FROM classes WHERE subject = ?";
			java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, subjectName);
			connection.createStatement().executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Subject Deleted Successfully");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void populateTable(JTable table) 
	{
		try {
			connection = dbConnection.getConnection();
			String query = "SELECT * FROM classes";
			java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
			defaultTableModel.setRowCount(0);
			while (resultSet.next()) {
				defaultTableModel.addRow(new Object[] { resultSet.getString("subject"),
						resultSet.getString("start_time"), resultSet.getString("end_time") });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
