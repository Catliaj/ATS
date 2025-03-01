package Model;



import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;
public class db_connection{
	
	private static Connection connection;
	private static db_connection db;
	
	public db_connection(){
		
		connection = null;
		
		try{
			
			connection = DriverManager.getConnection
		    (
		       "jdbc:mysql://localhost:3306/ats", 
		       "root", 
		       "" 	
			);	
			System.out.println("Connected Successfully");
		}
		
		catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "Connection Error"+ e.getMessage());
		}
	}
	
	public static db_connection getDBConnection(){
		
		if(db == null){
			
			db = new db_connection();
		}
		return db;
	}
	
	public Connection getConnection() throws SQLException{
		
		if(connection == null || connection.isClosed()){
			
			connection = DriverManager.getConnection
				    (
				       "jdbc:mysql://localhost:3306/ats", 
				       "root", 
				       "" 	
					);	
		}
		return connection;
	}	
}

