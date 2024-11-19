package re;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class LogMenu extends JFrame{
	
	//inner generic class that holds the log in methods
	public class LogInMethods<T extends User> {
		//variables used for MemberLogIn
		
		String m = "M";
		
		//variables used for EmployeeLogIn
		String e = "E";
		
		//variables used in both
		int userId;
		int id;
		String type;
		String first;
		String last;
		String userType;
		String logInMessage;
		List<User> userList = new ArrayList<>();
		String url = "jdbc:sqlserver://LAPTOP-KBL6NPE4\\SQLEXPRESS;DatabaseName = Lib;integratedSecurity=false; username=sa;password=sa;encrypt=true;trustServerCertificate=true";
		Connection conn;
		
		public void MemberLogIn() {
			//method used for the member log in
		try {
		conn = DriverManager.getConnection(url);
		assert(conn != null);
		//asserts that the connection is opened
		String query = "SELECT * From Users";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			id = rs.getInt("UserId");
			type  = rs.getString("UserType");
			User user = new User(id, type);
			userList.add(user);
		}
		Optional<User> validateUser = userList.stream().filter(i -> i.getId() == userId).findAny();
		Optional<User> validateType;
			if(validateUser.isPresent()) {
				validateType = validateUser.filter(t -> t.getType().contains(m));
				 	}else{
						throw new UserDoesNotExistException("Invalid User Id");
				 	}
					if(validateType.isPresent()) {
						new MemberMenu();
					}else {
						logInMessage = "User type does not match login choice";
					}
				 	
		
		}catch(SQLException | UserDoesNotExistException e){ 
			logInMessage = e.getMessage();
			
		}
		}
		
		public synchronized void employeeLogIn() {
			//method for the employee log in
			//only one Employee will be logged in at one time
			//To ensure that the database is not altered by two different people
			//adding the same books or user
			try {
				conn = DriverManager.getConnection(url);
				assert(conn != null);
				//asserts that the connection is opened
				String query = "SELECT * From Users";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					id = rs.getInt("UserId");
					type  = rs.getString("UserType");
					User user = new User(id, type);
					userList.add(user);
				}
				Optional<User> validateUser = userList.stream().filter(i -> i.getId() == userId).findAny();
				Optional<User> validateType;
					if(validateUser.isPresent()) {
						validateType = validateUser.filter(t -> t.getType().contains(e));
						 	}else{
								throw new UserDoesNotExistException("Invalid User Id");
						 	}
							if(validateType.isPresent()) {
								new EmployeeMenu();
							}else {
								logInMessage = "User type does not match login choice";
							}
						 			
				}catch(SQLException | UserDoesNotExistException e){ 
					logInMessage = e.getMessage();
					
				}
				}
			
		}
	
	
	//Menu Components
	private static final long serialVersionUID = 1L;
	
	public JButton btnMemLog = new JButton("Member");
	public JButton btnEmpLog = new JButton("Employee");
	public JButton btnAboutUs = new JButton("About Us!");
	public JButton btnNewMember = new JButton("Member Request");
	public JButton btnBookReq = new JButton("Book Request");
	
	public JTextField tfUserId;
	private JTextField tfLogInMessage;
	private JTextArea taFileOutput = new JTextArea();
	
	private JFrame f = new JFrame();
	private JPanel pane = new JPanel();	
	
	//constructors of the LogMenu
	LogInMethods<User> lim = new LogInMethods<>();
	public LogMenu() {
		
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.getContentPane().add(pane);
		
		JPanel ExistingUser = new JPanel();
		ExistingUser.setBackground(new Color(255, 128, 64));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		
		JScrollPane scrollPane = new JScrollPane();
				
		scrollPane.setViewportView(taFileOutput);
				
		JLabel lblNewUsers = new JLabel("New Users");
		lblNewUsers.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		
		JTextPane txtpnWantToKnow = new JTextPane();
		txtpnWantToKnow.setText("Welcome to the Library!  If you are already a member, you know what to do.  If you want to join our library click About Us to find out more, leave your name and press Member Request.  If you want a book we don't have leave us the book and your user Id.  Don't forget to press Send Request.");
				
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewUsers)
						.addComponent(btnNewMember, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
						.addComponent(btnAboutUs, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBookReq, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(txtpnWantToKnow, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewUsers)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAboutUs)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewMember)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBookReq))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(txtpnWantToKnow, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		tfUserId = new JTextField();
		tfUserId.setColumns(10);
				
		JLabel lblUserId = new JLabel("User Id");
		
		tfLogInMessage = new JTextField();
		tfLogInMessage.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Existing Users");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		GroupLayout gl_ExistingUser = new GroupLayout(ExistingUser);
		gl_ExistingUser.setHorizontalGroup(
			gl_ExistingUser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ExistingUser.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ExistingUser.createParallelGroup(Alignment.LEADING)
						.addComponent(tfLogInMessage, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
						.addGroup(gl_ExistingUser.createSequentialGroup()
							.addComponent(btnEmpLog)
							.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
							.addComponent(btnMemLog))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_ExistingUser.createSequentialGroup()
							.addComponent(lblUserId)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfUserId, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_ExistingUser.setVerticalGroup(
			gl_ExistingUser.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ExistingUser.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ExistingUser.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUserId)
						.addComponent(tfUserId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ExistingUser.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEmpLog)
						.addComponent(btnMemLog))
					.addGap(10)
					.addComponent(tfLogInMessage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		ExistingUser.setLayout(gl_ExistingUser);
		pane.setSize(400, 200);
		GroupLayout gl_pane = new GroupLayout(pane);
		gl_pane.setHorizontalGroup(
			gl_pane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pane.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_pane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
						.addGroup(gl_pane.createSequentialGroup()
							.addComponent(ExistingUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_pane.setVerticalGroup(
			gl_pane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_pane.createParallelGroup(Alignment.LEADING)
						.addComponent(ExistingUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
		);
		pane.setLayout(gl_pane);
		f.setSize(756,469);
		f.setVisible(true);
		
		//LogIn Button Events
		
				//Member Log in button event
				//calls MemberLogIn method from the inner class LogInMethods
				btnMemLog.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						lim.userId = Integer.parseInt(tfUserId.getText());
						lim.MemberLogIn();	
						tfLogInMessage.setText(lim.logInMessage);
					}
					});
				//Employee Log in button event
				//calls the EmployeeLogin method from the LogInMethod inner class
				btnEmpLog.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lim.userId = Integer.parseInt(tfUserId.getText());
						lim.employeeLogIn();
						tfLogInMessage.setText(lim.logInMessage);			
						
					}
				});
				//opens the AboutUs.txt file
				btnAboutUs.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
					
						File file = new File("C:\\Users\\jdrou\\eclipse-workspace\\Library\\src\\AboutUs.txt");
						try {
							taFileOutput.read(new BufferedReader(new FileReader(file)), null);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}				
				});
				//after the user alters AboutUs.txt it is saved as NewMember.txt
				btnNewMember.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						File file = new File("C:\\Users\\jdrou\\eclipse-workspace\\Library\\src\\NewMember.txt") ;
					
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter(file));
							bw.append(taFileOutput.getText());
							bw.newLine();
							bw.close();
	                    ;
	                    taFileOutput.read(new BufferedReader(new FileReader(file)), null);;
	                }
	                catch(Exception e2) {
	                }
					}
								 
	        });
				//after user alters AboutUs.txt it saves the file as BookReq.txt
				btnBookReq.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						File file = new File("C:\\Users\\jdrou\\eclipse-workspace\\Library\\src\\BookReq.txt") ;
					
						try {
							BufferedWriter bw = new BufferedWriter(new FileWriter(file));
							bw.append(taFileOutput.getText());
							bw.newLine();
							bw.close();
	                    ;
	                    taFileOutput.read(new BufferedReader(new FileReader(file)), null);;
	                }
	                catch(Exception e2) {
	                }
					}
								 
	        });
			  		
	}
				
	public static void main(String[] args) {
		new LogMenu();

	}
}
