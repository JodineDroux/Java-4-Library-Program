package re;

@SuppressWarnings("serial")
//Throws an exception that is thrown when a book has already been borrowed
//Used by borrowBook() in BookMethods
public class BookOnLoanException extends Exception{
	public BookOnLoanException(String msg) {
	    super(msg);
	}

}
