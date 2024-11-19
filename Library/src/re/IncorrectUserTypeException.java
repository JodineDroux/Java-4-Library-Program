package re;

@SuppressWarnings("serial")
//exception thrown when the incorrect user type is entered when adding a new user
//user type should be E or M
public class IncorrectUserTypeException extends Exception{
	public IncorrectUserTypeException(String msg) {
		super(msg);
	}

}
