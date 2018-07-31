package artsYcode;

public class ArtsYuser implements Address {     

	private String email;
	private String password;
	private String username;
	private int houseNumber;
	private String postcode;
	private String street;
	private String city;
	private String county;
	
//	public ArtsYuser() {}  
	
	public ArtsYuser(String email, String password, String username, int houseNumber, String postcode, String street, String city, String county) {
		this.email = email;
		this.password= password;
		this.username= username;;
		this.houseNumber = houseNumber;
		this.postcode = postcode;
		this.street = street;
		this.city = city;
		this.county = county;
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

	@Override
	public int getHouseNumber() {
		return houseNumber;
	}

	@Override
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	@Override
	public String getPostcode() {
		return postcode;
	}

	@Override
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String getStreet() {
		return street;
	}

	@Override
	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String getCounty() {
		return county;
	}

	@Override
	public void setCounty(String county) {
		this.county = county;
	}
	
}
