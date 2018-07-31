package artsYcode;

public class ArtsYuserBuilder {

	private String email;
	private String password;
	private String username;
	private int houseNumber;
	private String postcode;
	private String street;
	private String city;
	private String county;
	
	public ArtsYuserBuilder() {}
	
	public ArtsYuser buildUser() {
		return new ArtsYuser(email, password, username, houseNumber, postcode, street, city, county);
	}
	
	public ArtsYuserBuilder email (String email) {
		this.email = email;
		return this;
	}
	
	public ArtsYuserBuilder password (String password) {
		this.password = password;
		return this;
	}
	
	public ArtsYuserBuilder username (String username) {
		this.username = username;
		return this;
	}
	
	public ArtsYuserBuilder houseNumber (int houseNumber) {
		this.houseNumber = houseNumber;
		return this;
	}
	
	public ArtsYuserBuilder postcode (String postcode) {
		this.postcode = postcode;
		return this;
	}
	
	public ArtsYuserBuilder street (String street) {
		this.street = street;
		return this;
	}
	
	public ArtsYuserBuilder city (String city) {
		this.city = city;
		return this;
	}
	
	public ArtsYuserBuilder county (String county) {
		this.county = county;
		return this;
	}
		
}
