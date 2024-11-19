package re;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

public class UserMethods {

	String url = "jdbc:sqlserver://LAPTOP-KBL6NPE4\\SQLEXPRESS;DatabaseName = Lib;integratedSecurity=false; username=sa;password=sa;encrypt=true;trustServerCertificate=true";
	Connection conn;
	String first; 
	String last;
	String street;
	String city;
	String postal;
	String type;
	String id;
	String message;
	String userAdded;
	JTextField textField = new JTextField();

	public void selectUsers()  {
//		//method used to crate a list of all the users
		Vector<String> columnNames = new Vector<String>();
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    JPanel panel = new JPanel(); 
		
		try {
	       
	        conn = DriverManager.getConnection(url);
	        assert conn != null;
	        //asserts that the connection is opened
	        String selectUser = "SELECT * FROM Users";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectUser);
			ResultSetMetaData metaData = rs.getMetaData();
	        int columns = metaData.getColumnCount();
	        for (int i = 1; i <= columns; i++) {
	            columnNames.addElement(metaData.getColumnName(i));
	        }
	        while (rs.next()) {
	            Vector<Object> row = new Vector<Object>(columns);
	            for (int i = 1; i <= columns; i++) {
	                row.addElement(rs.getObject(i));
	            }
	            data.addElement(row);
	        }
	       
	    } catch (Exception e) {
	        System.out.println(e);
	    }
		JTable table = new JTable(data, columnNames);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
	    TableColumn column;
	    for (int i = 0; i < table.getColumnCount(); i++) {
	        column = table.getColumnModel().getColumn(i);
	        column.setMaxWidth(250);
	    }
	    JScrollPane scrollPane = new JScrollPane(table);        
	    panel.add(scrollPane);  
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(panel);         //adding panel to the frame
	    frame.setSize(600, 400); //setting frame size
	    frame.setVisible(true);  //setting visibility true
	
	}


	public void addUser() {
		//method to add new users to the library
		//Valid user type is M or E
		//If user type is invalid then prints a message to let the user know


		try {
			
	        conn = DriverManager.getConnection(url);
	        assert conn != null;
	        //asserts that the connection is opened
	        CallableStatement cs = conn.prepareCall("{call spAddUser(?,?,?)}");
			cs.setString(1, first);
			cs.setString(2, last);
			cs.setString(3, type);
			int result =cs.executeUpdate();
			if(result == 1) {
				message = first + " " + last + " was successfully added";
			}else {
				message = "Invalid User Type";
			}			
			}catch(SQLException se) {				
				
			}
	}
	
	
	


	public void deleteUser() {
		//method to delete a user from the library
		//If the user does not exist it throws a UserDoesNotExistException
		
		try {
			conn = DriverManager.getConnection(url);
			assert conn != null;
			//asserts that the connection is opened
			PreparedStatement deleteData = conn.prepareStatement("DELETE FROM Users WHERE UserID = ?");
			deleteData.setString(1, id);
			int result = deleteData.executeUpdate();
		if (result == 1) {
			message = "User " + id + " has been deleted";
		}else {
			throw new UserDoesNotExistException("User " + id +" doesn't extist");
		}
		}catch (SQLException | UserDoesNotExistException e) {
			message = e.getMessage();
		}		
	}
}
