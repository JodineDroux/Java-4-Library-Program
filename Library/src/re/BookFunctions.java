package re;

//Book interface that has functions a book will use
public interface BookFunctions {
	
	
	abstract void returnBook();
	abstract void borrowBook();
	default void addBookNewAuthor() {
	}
	default void removeBook() {
	}
	default void addBookExistingAuthor(){
		
	}
	
	

}
