package artsYcode;

public class ArtsYuser { // should implement address and postcode, sa de finns i samma objekt? Eller?  

	private String email;
	private String password;
	private String username;
	private int houseNumber;
	private String postcode;
	
	
	public ArtsYuser() {}  
	
	public ArtsYuser(String email, String password, String username, int houseNumber, String postcode) {
		this.email = email;
		this.password= password;
		this.username= username;;
		this.houseNumber = houseNumber;
		this.postcode = postcode;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	
	
}
