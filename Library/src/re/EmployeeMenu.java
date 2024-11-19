package re;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerListModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JSpinner;


public class EmployeeMenu extends JFrame{
	/**
	 * 
	 */
	//User menu components
	private static final long serialVersionUID = 1L;
	public JFrame f2 = new JFrame();
	private JPanel mainPane = new JPanel();
	private JPanel userPane = new JPanel();
	
	public JTextField tfUserId = new JTextField();
	public JTextField tfUserFirstName = new JTextField();
	public JTextField tfUserLastName = new JTextField();
	public JTextField tfUserType = new JTextField();
	public JTextField tfUserStatus = new JTextField();
	
	public JButton btnaddUser = new JButton("Add User");
	public JButton btndeleteUser = new JButton("Delete User");
	public JButton btnuserList = new JButton("List All Users");
	
	private JLabel userLabel = new JLabel("User Options");
	private final JLabel lblNewLabel = new JLabel("First Name");
	private final JLabel lblNewLabel_1 = new JLabel("Last Name");
	private final JLabel lblNewLabel_2 = new JLabel("User Type");
	
	private final JLabel lblNewLabel_3 = new JLabel("User Id");
	private final JPanel addUserPane = new JPanel();
	private final JPanel delUserPane = new JPanel();
	
	


	//Book Menu components
	
	public JButton btnaddBookAuthor = new JButton("Add Book");
	public JButton btnGetBookList = new JButton("All Books");
	public JButton btnAuthorList = new JButton("Authors");
	public JButton btnDeleteBook = new JButton("Delete Book");
	public JButton btnaddBookAuthorId = new JButton("Add Book");
	public JButton btnBorrowBook = new JButton("Borrow");
	public JButton btnReturnBook = new JButton("Return");
	public JButton btnGenreSearch = new JButton("Search By Genre");
	public JButton btnAuthorSearch = new JButton("Search By Author");
	public JButton btnBookOnLoan = new JButton("Books On Loan");
	
	public JTextField tfTitle = new JTextField();
	public JTextField tfAuthorFirst = new JTextField();
	public JTextField tfAuthorLast = new JTextField();
	public JTextField tfTitle1 = new JTextField();
	public JTextField tfAuthorId = new JTextField();
	public JTextField tfBookIdD = new JTextField();
	public JTextField tfUserIDBR;
	public JTextField tfBookIdBR = new JTextField();
	public JTextField tfBookStatus = new JTextField();
	public JTextField tfAuthorSearch = new JTextField();
	
	public JSpinner genreSpinner = new JSpinner();
	
	private final JPanel delBookPane = new JPanel();
	private final JPanel bookPane = new JPanel();
	private final JPanel addBookAuthorIdPane = new JPanel();
	private final JPanel addBookAuthorPane = new JPanel();
	private final JLabel lblNewLabel_5 = new JLabel("Title");
	private final JPanel returnBorrowBookPane = new JPanel();
	private final JPanel panel = new JPanel();
	
	private final JLabel lblNewLabel_6 = new JLabel("First Name");
	private final JLabel lblNewLabel_7 = new JLabel("Last Name");
	private final JLabel lblNewLabel_8 = new JLabel("Genre");
	private final JLabel lblNewLabel_4 = new JLabel("Book Options");
	private final JLabel lblNewLabel_5_1 = new JLabel("Title");
	private final JLabel lblNewLabel_6_1 = new JLabel("Author Id");
	private final JLabel lblNewLabel_8_1 = new JLabel("Genre");
	private final JLabel lblNewLabel_9 = new JLabel("Book Id");
	private final JLabel lblNewLabel_9_1 = new JLabel("Book Id");
			
	
	// class constructors and variables
	UserMethods u = new UserMethods();
	Search s = new Search();
	BookMethods b = new BookMethods();
	String url = "jdbc:sqlserver://LAPTOP-KBL6NPE4\\SQLEXPRESS;DatabaseName = Lib;integratedSecurity=false; username=sa;password=sa;encrypt=true;trustServerCertificate=true";
	

	
	
	public EmployeeMenu() {
		f2.setSize(750, 500);
		mainPane.setSize(700,600);
		tfBookStatus.setColumns(10);
		tfBookStatus.setBackground(Color.LIGHT_GRAY);
		tfBookIdBR.setColumns(10);
		returnBorrowBookPane.setBackground(new Color(255, 255, 255));
		returnBorrowBookPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblNewLabel_10 = new JLabel("User Id");
		
		tfUserIDBR = new JTextField();
		tfUserIDBR.setColumns(10);
		GroupLayout gl_returnBorrowBookPane = new GroupLayout(returnBorrowBookPane);
		gl_returnBorrowBookPane.setHorizontalGroup(
			gl_returnBorrowBookPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_returnBorrowBookPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_returnBorrowBookPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_9_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_returnBorrowBookPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_returnBorrowBookPane.createSequentialGroup()
							.addGap(18)
							.addComponent(tfBookIdBR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_returnBorrowBookPane.createSequentialGroup()
							.addGap(18)
							.addComponent(tfUserIDBR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(93)
					.addGroup(gl_returnBorrowBookPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnBorrowBook, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnReturnBook, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
					.addGap(64))
		);
		gl_returnBorrowBookPane.setVerticalGroup(
			gl_returnBorrowBookPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_returnBorrowBookPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_returnBorrowBookPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9_1)
						.addComponent(btnBorrowBook)
						.addComponent(tfBookIdBR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_returnBorrowBookPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReturnBook)
						.addComponent(lblNewLabel_10)
						.addComponent(tfUserIDBR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		returnBorrowBookPane.setLayout(gl_returnBorrowBookPane);
		tfBookIdD.setColumns(10);
		tfAuthorId.setColumns(10);
		tfTitle1.setColumns(10);
		addBookAuthorIdPane.setBackground(new Color(255, 255, 255));
		addBookAuthorIdPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"Fantasy", "Paranormal", "Science Fiction", "Dystopian", "Adventure", "Romance", "Paranormal Romance", "Historical Romance", "Mystery", "Historical Fiction", "Young Adult", "Children's Fiction", "History", "Spirituality", "Religion"}));
		
		
		
		
		
		GroupLayout gl_addBookAuthorIdPane = new GroupLayout(addBookAuthorIdPane);
		gl_addBookAuthorIdPane.setHorizontalGroup(
			gl_addBookAuthorIdPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addBookAuthorIdPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_addBookAuthorIdPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_addBookAuthorIdPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblNewLabel_5_1)
							.addComponent(lblNewLabel_6_1, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
						.addComponent(lblNewLabel_8_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_addBookAuthorIdPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_addBookAuthorIdPane.createSequentialGroup()
							.addGroup(gl_addBookAuthorIdPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tfAuthorId)
								.addComponent(tfTitle1, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(125, Short.MAX_VALUE))
						.addGroup(gl_addBookAuthorIdPane.createSequentialGroup()
							.addComponent(btnAuthorList)
							.addPreferredGap(ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
							.addComponent(btnaddBookAuthorId)
							.addGap(26))))
		);
		gl_addBookAuthorIdPane.setVerticalGroup(
			gl_addBookAuthorIdPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addBookAuthorIdPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_addBookAuthorIdPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5_1)
						.addComponent(tfTitle1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_addBookAuthorIdPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6_1)
						.addComponent(tfAuthorId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_addBookAuthorIdPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8_1)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_addBookAuthorIdPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAuthorList)
						.addComponent(btnaddBookAuthorId))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		mainPane.setSize(1,500);
		addBookAuthorIdPane.setLayout(gl_addBookAuthorIdPane);
		tfAuthorLast.setColumns(10);
		tfAuthorFirst.setColumns(10);
		tfTitle.setColumns(10);
		addBookAuthorPane.setBackground(new Color(255, 255, 255));
		addBookAuthorPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel_4.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		bookPane.setBackground(new Color(64, 128, 128));
		tfUserStatus.setBackground(new Color(192, 192, 192));
		tfUserStatus.setColumns(10);
		delUserPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		delUserPane.setBackground(new Color(255, 255, 255));
		addUserPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		addUserPane.setBackground(new Color(255, 255, 255));
		f2.setTitle("Employee Menu");
		f2.setSize(1000,500);
		f2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f2.getContentPane();
		f2.getContentPane().add(mainPane);
		GroupLayout gl_userPane = new GroupLayout(userPane);
		gl_userPane.setHorizontalGroup(
			gl_userPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_userPane.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addComponent(addUserPane, GroupLayout.PREFERRED_SIZE, 505, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_userPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(delUserPane, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_userPane.createSequentialGroup()
							.addComponent(btnuserList)
							.addGap(158))
						.addGroup(gl_userPane.createSequentialGroup()
							.addComponent(tfUserStatus, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
							.addGap(19)))
					.addGap(14))
				.addGroup(Alignment.LEADING, gl_userPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(userLabel)
					.addContainerGap(817, Short.MAX_VALUE))
		);
		gl_userPane.setVerticalGroup(
			gl_userPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_userPane.createSequentialGroup()
					.addGap(6)
					.addComponent(userLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_userPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_userPane.createSequentialGroup()
							.addComponent(delUserPane, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnuserList)
							.addGap(28)
							.addComponent(tfUserStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(addUserPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		tfUserId.setColumns(10);
		GroupLayout gl_delUserPane = new GroupLayout(delUserPane);
		gl_delUserPane.setHorizontalGroup(
			gl_delUserPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_delUserPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addGap(18)
					.addComponent(tfUserId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
					.addComponent(btndeleteUser)
					.addContainerGap())
		);
		gl_delUserPane.setVerticalGroup(
			gl_delUserPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_delUserPane.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addGroup(gl_delUserPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(tfUserId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btndeleteUser))
					.addGap(30))
		);
		delUserPane.setLayout(gl_delUserPane);
		GroupLayout gl_addUserPane = new GroupLayout(addUserPane);
		gl_addUserPane.setHorizontalGroup(
			gl_addUserPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addUserPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_addUserPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_addUserPane.createSequentialGroup()
							.addGroup(gl_addUserPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel))
							.addGap(36)
							.addGroup(gl_addUserPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tfUserFirstName, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfUserLastName)))
						.addGroup(gl_addUserPane.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tfUserType, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnaddUser)))
					.addContainerGap(292, GroupLayout.PREFERRED_SIZE))
		);
		gl_addUserPane.setVerticalGroup(
			gl_addUserPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addUserPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_addUserPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(tfUserFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_addUserPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(tfUserLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_addUserPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(tfUserType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnaddUser))
					.addContainerGap(117, Short.MAX_VALUE))
		);
		addUserPane.setLayout(gl_addUserPane);
		userLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		userPane.setBackground(new Color(64, 128, 128));
		userPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		userPane.setLayout(gl_userPane);
		GroupLayout gl_mainPane = new GroupLayout(mainPane);
		gl_mainPane.setHorizontalGroup(
			gl_mainPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_mainPane.createParallelGroup(Alignment.LEADING)
						.addComponent(bookPane, GroupLayout.PREFERRED_SIZE, 967, GroupLayout.PREFERRED_SIZE)
						.addComponent(userPane, GroupLayout.DEFAULT_SIZE, 967, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_mainPane.setVerticalGroup(
			gl_mainPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(userPane, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookPane, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(171, Short.MAX_VALUE))
		);
		GroupLayout gl_bookPane = new GroupLayout(bookPane);
		gl_bookPane.setHorizontalGroup(
			gl_bookPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bookPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_bookPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addGroup(gl_bookPane.createSequentialGroup()
							.addGroup(gl_bookPane.createParallelGroup(Alignment.LEADING)
								.addComponent(addBookAuthorIdPane, 0, 0, Short.MAX_VALUE)
								.addComponent(addBookAuthorPane, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(gl_bookPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(returnBorrowBookPane, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
								.addComponent(delBookPane, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_bookPane.createSequentialGroup()
									.addComponent(tfBookStatus, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
									.addGap(9)))))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		gl_bookPane.setVerticalGroup(
			gl_bookPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bookPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_bookPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_bookPane.createSequentialGroup()
							.addComponent(delBookPane, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(returnBorrowBookPane, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_bookPane.createSequentialGroup()
							.addComponent(addBookAuthorPane, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(addBookAuthorIdPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(tfBookStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		
		
		genreSpinner.setModel(new SpinnerListModel(new String[] {"Fantasy", "Paranormal", "Science Fiction", "Dystopian", "Adventure", "Romance", "Paranormal Romance", "Historical Romance", "Mystery", "Historical Fiction", "Young Adult", "Children's Fiction", "History", "Spirituality", "Religion"}));
		
		
		tfAuthorSearch.setColumns(10);
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(genreSpinner, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(tfAuthorSearch, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(btnBookOnLoan)
							.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
							.addComponent(btnGetBookList)
							.addGap(66))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnGenreSearch)
							.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
							.addComponent(btnAuthorSearch)
							.addGap(47))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(genreSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfAuthorSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAuthorSearch)
						.addComponent(btnGenreSearch))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBookOnLoan)
						.addComponent(btnGetBookList))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(gl_panel);
		delBookPane.setBackground(new Color(255, 255, 255));
		GroupLayout gl_delBookPane = new GroupLayout(delBookPane);
		gl_delBookPane.setHorizontalGroup(
			gl_delBookPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_delBookPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tfBookIdD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(94)
					.addComponent(btnDeleteBook)
					.addGap(58))
		);
		gl_delBookPane.setVerticalGroup(
			gl_delBookPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_delBookPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_delBookPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9)
						.addComponent(btnDeleteBook)
						.addComponent(tfBookIdD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		delBookPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		delBookPane.setLayout(gl_delBookPane);
		
		JSpinner spinner1 = new JSpinner();
		spinner1.setModel(new SpinnerListModel(new String[] {"Fantasy", "Paranormal", "Science Fiction", "Dystopian", "Adventure", "Romance", "Paranormal Romance", "Historical Romance", "Mystery", "Historical Fiction", "Young Adult", "Children's Fiction", "History", "Spirituality", "Religion"}));
		GroupLayout gl_addBookAuthorPane = new GroupLayout(addBookAuthorPane);
		gl_addBookAuthorPane.setHorizontalGroup(
			gl_addBookAuthorPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addBookAuthorPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_addBookAuthorPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_addBookAuthorPane.createSequentialGroup()
							.addGroup(gl_addBookAuthorPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
							.addGap(18))
						.addGroup(gl_addBookAuthorPane.createSequentialGroup()
							.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_addBookAuthorPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_addBookAuthorPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(tfAuthorLast)
							.addComponent(tfAuthorFirst)
							.addComponent(tfTitle, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_addBookAuthorPane.createSequentialGroup()
							.addComponent(spinner1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnaddBookAuthor)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_addBookAuthorPane.setVerticalGroup(
			gl_addBookAuthorPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addBookAuthorPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_addBookAuthorPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(tfTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_addBookAuthorPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(tfAuthorFirst, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_addBookAuthorPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(tfAuthorLast, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_addBookAuthorPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(spinner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_addBookAuthorPane.createSequentialGroup()
					.addContainerGap(93, Short.MAX_VALUE)
					.addComponent(btnaddBookAuthor)
					.addContainerGap())
		);
		addBookAuthorPane.setLayout(gl_addBookAuthorPane);
		bookPane.setLayout(gl_bookPane);
		
		
		//User Button Events
		
		btnaddUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
               u.first = tfUserFirstName.getText();
               u.last = tfUserLastName.getText();
               u.type = tfUserType.getText();
       		   u.addUser();
               tfUserStatus.setText(u.message);
            }
       
        });
		
		btndeleteUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	u.id = tfUserId.getText();
            	u.deleteUser();
            	tfUserStatus.setText(u.message);
               
            }
       
        });
		//lambda to create the user table
		btnuserList.addActionListener(e -> u.selectUsers());
		
		btnaddBookAuthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    	
               b.title = tfTitle.getText();
               b.authorFirst = tfAuthorFirst.getText();
               b.authorLast = tfAuthorLast.getText();
               b.genre = spinner1.getValue().toString();
               b.addBookNewAuthor();
               tfBookStatus.setText(b.bookMessage);
            }
        });
		
		btnaddBookAuthorId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    	
            	b.title = tfTitle1.getText();            	
            	b.authorId = tfAuthorId.getText();
            	b.genre = spinner.getValue().toString();
                b.addBookExistingAuthor();
                tfBookStatus.setText(b.bookMessage);

            }

		});
		
		//Book Button Events
		     
		
		
		btnAuthorSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	s.lastName = tfAuthorSearch.getText();
            	s.searchByLastName();         	
            }
            
        });
		
		btnGenreSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.genre = genreSpinner.getValue().toString();
				s.searchByGenre();
				
			}
			
		});
		
		btnBorrowBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    	
               b.bookId = tfBookIdBR.getText();
               b.userId = tfUserIDBR.getText();              
               b.borrowBook(); 
               tfBookStatus.setText(b.bookMessage);  
            }
       
        });
		
		btnReturnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    	
               b.bookId = tfBookIdBR.getText();
               b.returnBook();
               tfBookStatus.setText(b.bookMessage);
            }
		});
		
		btnDeleteBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    	
               b.bookId = tfBookIdD.getText(); 
               b.deleteBook();
               tfBookStatus.setText(b.bookMessage);
            }
            
        });
		
		// button events for getting a full list of the books, and the list with the 
		//corresponding userId with a loaned book
		btnGetBookList.addActionListener(e -> b.getBookListMem());
		btnBookOnLoan.addActionListener(e-> b.getBookListEmp());
		//button event to create a list of authors
		btnAuthorList.addActionListener(e -> b.createAuthorList());
				
	
		
		mainPane.setLayout(gl_mainPane);
		
		
		f2.setSize(1000, 1500);
		f2.setVisible(true);
	}
	 

	public static void main(String[] args) {
		new EmployeeMenu();

	}
}
