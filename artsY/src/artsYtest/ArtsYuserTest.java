package artsYtest;

import static org.junit.Assert.*;
import org.junit.Test;

import artsYcode.ArtsYuser;

public class ArtsYuserTest {

	ArtsYuser user = new ArtsYuser("name@test.co.uk", "abc123", "username");
	
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
			
}
