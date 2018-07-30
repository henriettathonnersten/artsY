package artsYtest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import artsYcode.JDBC;

public class JDBCTest {
	
	JDBC database = new JDBC();

	@Test
	public void existanceCheck() {
		assertNotNull(database);
	}
	
	@Test
	public void logInCheck() {
		assertEquals("Not expected output", true, database.logIn("a@test.com", "hej123"));		
	}
	
/*	@Test
	public void addUser() {
		assertEquals("Not expected output", "hej", database.addUser("hepp", "hepp@email.c.uk", "passwordet", "A street", "6", null, "AB12CD", "Cityplace", "Kent"));		
	}*/

}
