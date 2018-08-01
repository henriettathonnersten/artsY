package artsYtest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import artsYcode.Address;

public class AddressTest {

	Address address = new Address(6, "CT1 2AW", "Mill Lane", "Canterbury", "Kent");
	
	@Test
	public void getHouseNumber() {
		assertEquals("House number is not the one expected", 6, address.getHouseNumber());
	}
	
	@Test
	public void setHouseNumber() {
		address.setHouseNumber(7);
		assertEquals("House number is not the one expected", 7, address.getHouseNumber());
	}
	
	@Test
	public void getPostcode() {
		assertEquals("Postcode is not the one expected", "CT1 2AW", address.getPostcode());
	}
	
	@Test
	public void setPostcode() {
		address.setPostcode("M50 3YJ");
		assertEquals("Postcode is not the one expected", "M50 3YJ", address.getPostcode());
	}
	
	@Test
	public void getStreet() {
		assertEquals("Street is not the one expected", "Mill Lane", address.getStreet());
	}
	
	@Test
	public void setStreet() {
		address.setStreet("Canterbury Avenue");
		assertEquals("Street is not the one expected", "Canterbury Avenue", address.getStreet());
	}
	
	@Test
	public void getCity() {
		assertEquals("City is not the one expected", "Canterbury", address.getCity());
	}
	
	@Test
	public void setCity() {
		address.setCity("Manchester");
		assertEquals("City is not the one expected", "Manchester", address.getCity());
	}
	
	@Test
	public void getCounty() {
		assertEquals("County is not the one expected", "Kent", address.getCounty());
	}
	
	@Test
	public void setCounty() {
		address.setCounty("Greater Manchester");
		assertEquals("County is not the one expected", "Greater Manchester", address.getCounty());
	}
	
}
