package re;

@SuppressWarnings("serial")
//throws an exception when the author Id doen not exist in Author table
//used when adding a book that uses an existing author
public class AuthorIdMissingException extends Exception {
	public AuthorIdMissingException(String msg) {
		super(msg);
	}

}
