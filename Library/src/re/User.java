package re;
//User class that creates a user object that is used for the login menu
//User object has a userId and a user type
//
public class User {
	private int id;
	private String type;
	
	User(int id, String type){
		this.id = id;
		this.type = type;
	}
	//getters and setters
	int getId(){
		return id;
	}
	void setId(int id) {
		this.id = id;
	}
	String getType() {
		return type;
	}
	void setType(String type) {
		this.type = type;
	}

}
