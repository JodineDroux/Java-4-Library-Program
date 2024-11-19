package re;


import java.awt.Dimension;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;





public class BookMethods implements BookFunctions{
	
	//connection variables use to connect to the Library database
	String url = "jdbc:sqlserver://LAPTOP-KBL6NPE4\\SQLEXPRESS;DatabaseName = Lib;integratedSecurity=false; username=sa;password=sa;encrypt=true;trustServerCertificate=true";
	Connection conn; 
	
	//shared variables used by multiple methods
	String bookId;
	String title;
	String genre;
	String bookMessage;
	
	//variables used for the BorrowBook() method
	String userId;
	
	//variables used for addBookNewAuthor() method
	String authorFirst;
	String authorLast;
	
	//variables used for the addBookExistingAuthor() method
	String authorId;
	
	//used for getBookListEmp() and getBookListMem()
	int columns;
	Vector<Object> row;
	Vector<Vector<Object>> data;
	Vector<String> columnNames;
	List<String> genreList = new ArrayList<>();
	List<String> authors = new ArrayList<>();
	

	
	public void returnBook() {
		//method to return a book
		//if the book doesn't exist in the library it throws BookIdException
		
		try {
			conn = DriverManager.getConnection(url);
			assert conn != null;
			//asserts that the connection is opened
			String returnBooks = "UPDATE Book SET BookStatus = 'A' WHERE BookId = ?" +
						"DELETE FROM Book_User Where BookId = ?";
			PreparedStatement pstmt = conn.prepareStatement(returnBooks);
			pstmt.setString(1, bookId);
			pstmt.setString(2, bookId);
			int result = pstmt.executeUpdate();
			if(result == 1) {
				bookMessage = "Thank you for returning your book";				
			}else {
				//if the book id that is entered is not a book that is in the library this Exception will be thrown
				throw new BookIdException(bookId + " Is not a valid book");
			}
			}catch(SQLException | BookIdException e) {
			bookMessage = e.getMessage();
		}
	}

	public void borrowBook() {	
		
		//method to borrow a book
		//if a book is already on loan it throws Book on Loan Exception
		//All threads that call this method will go to a Single Thread Pool
		//Whether it is called by a Member or an Employee
		try {
			conn = DriverManager.getConnection(url);
			assert conn != null;
			CallableStatement cs = conn.prepareCall("{call spLoanBook(?,?)}");
			cs.setString(1, bookId);
			cs.setString(2, userId);
			
			int result = cs.executeUpdate();
			
			if(result == 1) {
				bookMessage = "Enjoy your book!";
			}else {
				//this exception will be thrown if the book has been borrowed
				//BookStatus in Book is L then book is borrowed, A, the book is available
				throw new BookOnLoanException("Book is not available");
			}
		}catch(SQLException | BookOnLoanException  e) {
			bookMessage = e.getMessage();
		}
		
	}	

	public void addBookNewAuthor() {
		
		//method to add a book and a non existing author
		try {
		conn = DriverManager.getConnection(url);
		assert (conn != null);
		//asserts that the connection is opened
		CallableStatement cs = conn.prepareCall("{call spAddBook(?,?,?,?)}");
		cs.setString(1, title);
		cs.setString(2, genre);
		cs.setString(3, authorFirst);
		cs.setString(4, authorLast);
		assert(!title.isEmpty() && !genre.isEmpty() &&  !authorFirst.isEmpty() && !authorLast.isEmpty());
		//assert all the input boxes are not empty
		cs.execute();
		bookMessage = title + " has been added to the library";
		}catch(SQLException e) {
			bookMessage = title + " was not added";
		}
	}
	public void addBookExistingAuthor() {	
		
		//method to add a book with an existing author
		
		try {
			
			assert conn != null;
			//asserts that the connection is opened
			conn = DriverManager.getConnection(url);
				CallableStatement cs = conn.prepareCall("{call spAddBookNotAuthor(?,?,?)}");
				cs.setString(1, title);
				cs.setString(2, genre);
				cs.setString(3, authorId);
				//asserts that all the input boxes are not empty
				assert(!title.isEmpty() && !genre.isEmpty() &&  !authorId.isEmpty());
				int result = cs.executeUpdate();
				if(result == 1) {
				bookMessage = "You have added " + title + " to the library";
				}else {
					//if author id is not present in the author table this will be thrown
					throw new AuthorIdMissingException("Author Id does not exist");
				}
			}catch(SQLException | AuthorIdMissingException e) {				
					bookMessage = title + " was not added";
			}
	}
	
	public void deleteBook() {
		
		//method to delete a book
		//if the book Id is not present it prints bookId = does not exist
		try {
			conn = DriverManager.getConnection(url);
			assert conn != null;
			//asserts that the connection is opened
			CallableStatement cs = conn.prepareCall("{call spDeleteBook(?)}");
			cs.setString(1, bookId);
			cs.execute();
			bookMessage = "You have deleted book number " + bookId;
			}catch(SQLException e) {
				bookMessage = bookId + " does not exist";
			}
		
	}
public void getBookListEmp() {
		
		//method to get a list of all the books with the MemberId
		columnNames = new Vector<String>();
	    data = new Vector<Vector<Object>>();
	    JPanel panel = new JPanel(); 
		
		try {
	       
	        Connection conn = DriverManager.getConnection(url);
	        assert conn != null;
	      //asserts that the connection is opened
	        String selectUser = "SELECT Book.BookId, Book.Title, Author.LastName, Author.FirstName, Book.Genre, Book.BookStatus, Book_User.UserID"
	        		+ " FROM Author INNER JOIN Book_Author ON Author.AuthorID = Book_Author.AuthorID" 
	        		+ " INNER JOIN Book ON Book_Author.BookID = Book.BookId"
	        		+ " INNER JOIN Book_User ON Book.BookId = Book_User.BookID"
	        		+ " INNER JOIN Users ON Book_User.UserID = Users.UserID";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectUser);
			ResultSetMetaData metaData = rs.getMetaData();
	        columns = metaData.getColumnCount();
	        for (int i = 1; i <= columns; i++) {
	            columnNames.addElement(metaData.getColumnName(i));
	        }
	        while (rs.next()) {
	            row = new Vector<Object>(columns);
	            for (int i = 1; i <= columns; i++) {
	                row.addElement(rs.getObject(i));
	            }
	            data.addElement(row);
	        }
	       
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	   
		JTable table = new JTable(data, columnNames);
	
		table.setPreferredSize(new Dimension(750,400));
	    TableColumn column;
	    for (int i = 0; i < table.getColumnCount(); i++) {
	        column = table.getColumnModel().getColumn(i);
	        column.setResizable(true);
	    }
	    
	    JScrollPane scrollPane = new JScrollPane(table); 
	    scrollPane.setSize(750,400);
	    panel.add(scrollPane);
	    panel.setSize(750,400);
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(panel);         //adding panel to the frame
	    frame.setSize(750,400);
	    frame.setVisible(true);  //setting visibility true
	}
	public void getBookListMem() {
		
		
		
		//method to get a list of all the books without the memberId
		columnNames = new Vector<String>();
	    data = new Vector<Vector<Object>>();
	    JPanel panel = new JPanel(); 
		
		try {
	       
	        Connection conn = DriverManager.getConnection(url);
	        assert conn != null;
	      //asserts that the connection is opened
	        String selectUser = "SELECT Book.BookId, Book.Title, Book.Genre, Author.FirstName, Author.LastName, Book.BookStatus"
	        		+ " FROM Book INNER JOIN Book_Author ON Book.BookId = Book_Author.BookID"
	        		+ " INNER JOIN Author ON Book_Author.AuthorID = Author.AuthorId";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectUser);
			ResultSetMetaData metaData = rs.getMetaData();
	        columns = metaData.getColumnCount();
	        for (int i = 1; i <= columns; i++) {
	            columnNames.addElement(metaData.getColumnName(i));
	        }
	        while (rs.next()) {
	            row = new Vector<Object>(columns);
	            for (int i = 1; i <= columns; i++) {
	                row.addElement(rs.getObject(i));
	            }
	            data.addElement(row);
	        }
	       
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    
		JTable table = new JTable(data, columnNames);
		table.setSize(1400, 600);
	    TableColumn column;
	    for (int i = 0; i < table.getColumnCount(); i++) {
	        column = table.getColumnModel().getColumn(i);
	        column.setMaxWidth(400);
	    }
	    JScrollPane scrollPane = new JScrollPane(table);        
	    panel.add(scrollPane);  
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(panel);         //adding panel to the frame
	    frame.setSize(600, 400); //setting frame size
	    frame.setVisible(true);  //setting visibility true
	}
	
	public void createAuthorList() {
		//creates a list of authors that is used in the EmployeeMenu to get a list 
		//of authors and the corresponding AuthorId
		columnNames = new Vector<String>();
	    data = new Vector<Vector<Object>>();
	    JPanel panel = new JPanel(); 
		
		try {
	       
	        Connection conn = DriverManager.getConnection(url);
	        assert conn != null;
	      //asserts that the connection is opened
	        String selectUser = "SELECT * FROM Author ORDER BY LastName";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectUser);
			ResultSetMetaData metaData = rs.getMetaData();
	        columns = metaData.getColumnCount();
	        for (int i = 1; i <= columns; i++) {
	            columnNames.addElement(metaData.getColumnName(i));
	        }
	        while (rs.next()) {
	            row = new Vector<Object>(columns);
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
	        column.setMaxWidth(100);
	    }
	    JScrollPane scrollPane = new JScrollPane(table);        
	    panel.add(scrollPane);  
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(panel);         //adding panel to the frame
	    frame.setSize(600, 400); //setting frame size
	    frame.setVisible(true);  //setting visibility true
	}
}
	
	
	


