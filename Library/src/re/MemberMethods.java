package re;

public class MemberMethods implements BookFunctions{
	//contains the methods that a member can use
	
	//new BookMethods and Search instances that are used to run the methods
	BookMethods b = new BookMethods();
	Search s = new Search();
	
	@Override
	public void returnBook() {		
		b.returnBook();
	}

	@Override
	public void borrowBook() {
		b.borrowBook();
	}
	
	public void SearchByLastName() {
		s.searchByLastName();
		
	}
	public void searchByGenre() {
		s.searchByGenre();

	}

}
