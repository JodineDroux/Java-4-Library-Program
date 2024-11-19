package re;

@SuppressWarnings("serial")
//if a book does not exist in the library or is not available this exception is thrown
//used in the return book method
public class BookIdException extends Exception {
	public BookIdException(String msg) {
		super(msg);
	}

}
