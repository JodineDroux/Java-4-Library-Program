package re;

@SuppressWarnings("serial")
//throws an exception if the user id being deleted does exist in the user table
//used in deleteUser() in UserMethods
public class UserDoesNotExistException extends Exception {
	
	public UserDoesNotExistException(String msg) {
		super (msg);
	}

}
