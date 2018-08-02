package artsYtest;

import static org.junit.Assert.*;

import org.junit.Test;

import artsYcode.Postage;

public class PostageTest {
	
	Postage postage = new Postage();
	
	@Test
	public void existanceCheck() {
		assertNotNull(postage);
	}
	
	@Test
	public void getMediumPackagePostage() {
		assertEquals("Not expected postage", 2855, postage.calculatePostage(60, 45, 45, 18));
	}

}
