package artsYtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import artsYcode.ArtsYuserBuilder;

public class ArtsYuserBuilderTest {

	ArtsYuserBuilder userBuilder = new ArtsYuserBuilder();
	
	@Test
	public void existanceCheck() {
		assertNotNull(userBuilder);
	}
	
	
	//förväntar sig en user?! Hur kolla det?
	/*
	@Test
	public void userCreation() {
		assertEquals("User not created", null, userBuilder.buildUser());			//user som endast håller nullValues?
	}
	
	@Test
	public void setEmail() {
		assertEquals("Not expected email", "hi@email.com", userBuilder.email("hi@email.com"));
	}
	
	@Test
	public void setPassword() {
		assertEquals("Not expected password", "abc123", userBuilder.password("abc123"));
	}
	
	@Test
	public void setUsername() {
		assertEquals("Not expected username", "hiABC", userBuilder.username("hiABC"));
	}
	
	@Test
	public void setHouseNumber() {
		assertEquals("Not expected house number", 7, userBuilder.houseNumber(7));
	}
	
	@Test
	public void setPostcode() {
		assertEquals("Not expected postcode", "CT1 2AW", userBuilder.postcode("CT1 2AW"));
	}*/
	
}
