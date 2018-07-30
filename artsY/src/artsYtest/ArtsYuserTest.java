package artsYtest;

import static org.junit.Assert.*;
import org.junit.Test;

import artsYcode.ArtsYuser;

public class ArtsYuserTest {

	ArtsYuser user = new ArtsYuser("name@test.co.uk", "abc123", "username", 6, "CT1 2AW");
	
	@Test
	public void userExistanceCheck() {
		assertNotNull(user);
	} 
	
	@Test
	public void getEmail() {
		assertEquals("Email is not the one expected", "name@test.co.uk", user.getEmail());
	}
	
	@Test
	public void setEmail() {
		user.setEmail("henrietta@test.com");
		assertEquals("Email is not the one expected", "henrietta@test.com", user.getEmail());
	}
	
	@Test
	public void getPassword() {
		assertEquals("Email is not the one expected", "abc123", user.getPassword());
	}
	
	@Test
	public void setPassword() {
		user.setPassword("321cba");
		assertEquals("Email is not the one expected", "321cba", user.getPassword());
	}
	
	@Test
	public void getUsername() {
		assertEquals("Username is not the one expected", "username", user.getUsername());
	}
	
	@Test
	public void setUsername() {
		user.setUsername("hentho");
		assertEquals("Username is not the one expected", "hentho", user.getUsername());
	}
	
	@Test
	public void getHouseNumber() {
		assertEquals("House number is not the one expected", 6, user.getHouseNumber());
	}
	
	@Test
	public void setHouseNumber() {
		user.setHouseNumber(7);
		assertEquals("House number is not the one expected", 7, user.getHouseNumber());
	}
	
	@Test
	public void getPostcode() {
		assertEquals("Postcode is not the one expected", "CT1 2AW", user.getPostcode());
	}
	
	@Test
	public void setPostcode() {
		user.setPostcode("M50 3YJ");
		assertEquals("Postcode is not the one expected", "M50 3YJ", user.getPostcode());
	}
			
}
