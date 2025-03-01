package Model;

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import javax.swing.JOptionPane; 


public class loginQuery { private String username; private String password; private db_connection db; private boolean loginSuccess = false;

public loginQuery(String username, String password) {
    this.username = username;
    this.password = password;
    this.db = new db_connection(); // Initialize db_connection

    try (Connection connection = db.getConnection()) 
    {
        System.out.println("Connected Successfully");
        String query = "SELECT * FROM teacher WHERE username = ? AND password = ?";
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, this.username);
            pst.setString(2, this.password);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    loginSuccess = true;
                    JOptionPane.showMessageDialog(null, "Login Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
}

public boolean loginSuccess() {
    return loginSuccess;
}

public void setUsername(String username) {
    this.username = username;
}

public void setPassword(String password) {
    this.password = password;
}

public String getUsername() {
    return username;
}

public String getPassword() {
    return password;
}
}