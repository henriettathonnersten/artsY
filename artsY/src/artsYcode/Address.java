package artsYcode;

public class Address {

	private int houseNumber;
	private String postcode;
	private String street;
	private String city;
	private String county;
	
	public Address (int houseNumber, String postcode, String street, String city, String county) {
		this.houseNumber = houseNumber;
		this.postcode = postcode;
		this.street = street;
		this.city = city;
		this.county = county;
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
	 
	public String getStreet() {
		return street;
	}
	 
	public void setStreet(String street) {
		this.street = street;
	}
	 
	public String getCity() {
		return city;
	}
	 
	public void setCity(String city) {
		this.city = city;
	}
	 
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}
	
}
