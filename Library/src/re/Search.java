package re;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;


public class Search{
	//class that has the methods to search by genre or last name
	//opens a table of the results by clicking the corresponding button
	String url = "jdbc:sqlserver://LAPTOP-KBL6NPE4\\SQLEXPRESS;DatabaseName = Lib;integratedSecurity=false; username=sa;password=sa;encrypt=true;trustServerCertificate=true";
	Connection conn; 
	int columns;
	String lastName;
	String genre;
	Vector<Object> row;
	Vector<Vector<Object>> data;
	Vector<String> columnNames;

	
	public void searchByLastName() {
	columnNames = new Vector<String>();
	data = new Vector<Vector<Object>>();
	JPanel panel = new JPanel(); 
	try {
		conn = DriverManager.getConnection(url);
        assert conn != null;
        String selectLastName = "SELECT Book.BookId, Book.Title, Book.Genre, Author.FirstName, dbo.Author.LastName, dbo.Book.BookStatus"
        		+ " FROM Author INNER JOIN Book_Author ON Author.AuthorID = Book_Author.AuthorID"
        		+ " INNER JOIN dbo.Book ON dbo.Book_Author.BookID = dbo.Book.BookId WHERE LastName = (?)";
		PreparedStatement pstmt = conn.prepareStatement(selectLastName);
		pstmt.setString(1, lastName);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData metaData = rs.getMetaData();
		int columns = metaData.getColumnCount();
		for(int i = 1; i <= columns; i++){
			columnNames.addElement(metaData.getColumnName(i));
		}
		while(rs.next()) {
			Vector<Object> row = new Vector<>(columns);
			for(int i = 1; i <= columns;i++) {
				row.addElement(rs.getObject(i));
			}
			data.addElement(row);
		}
		}catch(SQLException e) {
			
		}
	JTable table = new JTable(data, columnNames);
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
		
	
	public void searchByGenre() {
		columnNames = new Vector<String>();
		data = new Vector<Vector<Object>>();
		JPanel panel = new JPanel(); 
		try {
			conn = DriverManager.getConnection(url);
	        assert conn != null;
	        String selectLastName = "SELECT Book.BookId, Book.Title, Book.Genre, Author.FirstName, dbo.Author.LastName, dbo.Book.BookStatus"
	        		+ " FROM Author INNER JOIN Book_Author ON Author.AuthorID = Book_Author.AuthorID"
	        		+ " INNER JOIN dbo.Book ON dbo.Book_Author.BookID = dbo.Book.BookId WHERE Genre = (?) ORDER BY LastName";
			PreparedStatement pstmt = conn.prepareStatement(selectLastName);
			pstmt.setString(1, genre);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columns = metaData.getColumnCount();
			for(int i = 1; i <= columns; i++){
				columnNames.addElement(metaData.getColumnName(i));
			}
			while(rs.next()) {
				Vector<Object> row = new Vector<>(columns);
				for(int i = 1; i <= columns;i++) {
					row.addElement(rs.getObject(i));
				}
				data.addElement(row);
			}
			}catch(SQLException e) {
				
			}
		JTable table = new JTable(data, columnNames);
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
	
	}
	
	        
	        	
	   
        
	
	

