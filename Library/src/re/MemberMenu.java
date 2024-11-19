package re;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class MemberMenu extends JFrame{
	
	//Menu components
	private static final long serialVersionUID = 1L;
	private JFrame f3 = new JFrame("User Menu");
	private JPanel mainPane = new JPanel();
	
	public JTextField tfBookId;
	public JTextField tfAuthorSearch;
	public JTextField tfBookStatus;
	public JTextField tfUserId;
	
	public JButton btnBorrowBook = new JButton("Borrow");
	public JButton btnReturnBook = new JButton("Return");
	public JButton btnGetBookList = new JButton("Book List");
	
	//Constructors
	BookMethods b = new BookMethods();
	Search s = new Search();

	public MemberMenu() {
		f3.setTitle("Member Menu");
		f3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f3.setSize(520,400);
		f3.setVisible(true);
		mainPane.setBackground(new Color(0, 64, 128));
		mainPane.setSize(500,300);
		f3.getContentPane().add(mainPane);
		
		JPanel returnBorrowBookPane = new JPanel();
		returnBorrowBookPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		returnBorrowBookPane.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_9_1 = new JLabel("Book Id");
		
		tfBookId = new JTextField();
		tfBookId.setColumns(10);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		
		JSpinner genreSpinner = new JSpinner();
		genreSpinner.setModel(new SpinnerListModel(new String[] {"Fantasy", "Paranormal", "Science Fiction", "Dystopian", "Adventure", "Romance", "Paranormal Romance", "Historical Romance", "Mystery", "Historical Fiction", "Young Adult", "Children's Fiction", "History", "Spirituality", "Religion"}));
		
		JButton btnGenreSearch = new JButton("Search By Genre");
		
		JButton btnAuthorSearch = new JButton("Search By Author");
		
		tfAuthorSearch = new JTextField();
		tfAuthorSearch.setColumns(10);
		
	
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(genreSpinner, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(tfAuthorSearch, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(38)
					.addComponent(btnGenreSearch)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGetBookList)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(btnAuthorSearch)
					.addGap(47))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(genreSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfAuthorSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAuthorSearch)
								.addComponent(btnGenreSearch))
							.addContainerGap(20, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGetBookList))))
		);
		panel.setLayout(gl_panel);
		
		tfBookStatus = new JTextField();
		tfBookStatus.setBackground(new Color(192, 192, 192));
		tfBookStatus.setColumns(10);
		GroupLayout gl_mainPane = new GroupLayout(mainPane);
		gl_mainPane.setHorizontalGroup(
			gl_mainPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_mainPane.createParallelGroup(Alignment.LEADING)
						.addComponent(returnBorrowBookPane, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
					.addGap(558))
				.addGroup(gl_mainPane.createSequentialGroup()
					.addGap(73)
					.addComponent(tfBookStatus, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(618, Short.MAX_VALUE))
		);
		gl_mainPane.setVerticalGroup(
			gl_mainPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(returnBorrowBookPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(tfBookStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(219, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("User Id");
		
		tfUserId = new JTextField();
		tfUserId.setColumns(10);
		GroupLayout gl_returnBorrowBookPane = new GroupLayout(returnBorrowBookPane);
		gl_returnBorrowBookPane.setHorizontalGroup(
			gl_returnBorrowBookPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_returnBorrowBookPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tfUserId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(95)
					.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_returnBorrowBookPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_9_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tfBookId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(93)
					.addComponent(btnBorrowBook, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
		);
		gl_returnBorrowBookPane.setVerticalGroup(
			gl_returnBorrowBookPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_returnBorrowBookPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_returnBorrowBookPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_returnBorrowBookPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_9_1))
						.addGroup(gl_returnBorrowBookPane.createSequentialGroup()
							.addGap(1)
							.addComponent(tfBookId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBorrowBook))
					.addGroup(gl_returnBorrowBookPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_returnBorrowBookPane.createSequentialGroup()
							.addGap(6)
							.addGroup(gl_returnBorrowBookPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnReturnBook)
								.addComponent(lblNewLabel)))
						.addGroup(gl_returnBorrowBookPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfUserId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		returnBorrowBookPane.setLayout(gl_returnBorrowBookPane);
		mainPane.setLayout(gl_mainPane);
		setTitle("User Menu");
		getContentPane().setBackground(new Color(0, 64, 128));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 436, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 263, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		
		//Member Button Events
		
		btnBorrowBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    	
               b.bookId = tfBookId.getText();
               b.userId = tfUserId.getText();              
               b.borrowBook(); 
               tfBookStatus.setText(b.bookMessage);  
            }
       
        });
		
		btnReturnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    	
               b.bookId = tfBookId.getText();
               b.returnBook();
               tfBookStatus.setText(b.bookMessage);
            }
		});
		//creates the book table
		btnGetBookList.addActionListener(e -> b.getBookListMem());
		
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
		
	}
	
	public static void main(String[] args) {
		new MemberMenu();
	}
}
