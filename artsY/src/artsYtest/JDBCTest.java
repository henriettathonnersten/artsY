package artsYtest;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.Test;

import artsYcode.Address;
import artsYcode.ArtsYuser;
import artsYcode.Item;
import artsYcode.JDBC;
import artsYcode.Sale;

public class JDBCTest {
	
	JDBC database = new JDBC();
	ArtsYuser user = new ArtsYuser("heppy@email.c.uk", "passwordet", "Testersson");
	Address address = new Address(6, "AB14CD", "Silly Street", "Manchester", "Greater Manchester");
	Item item = new Item("henrietta.thonnersten@academytrainee.com", "Title of item", "Description for item", 25.69); 
	Sale sale = new Sale(1, "e@test.com", 7, "CT1 3HG", "2018-02-02", 1225, 5.99);
	
	@Test
	public void existanceCheck() {
		assertNotNull(database);
	}
	
	@Test
	public void logInCheck() {
		assertEquals("Not expected output", true, database.logIn("a@test.com", "hej123"));		
	}
	
	@Test
	public void addUser() {
		assertEquals("User was not added", true, database.addUser(user, address));		//i user???
	}
	
	@Test
	public void tryDuplicateUser() {
		assertEquals("User was added", false, database.addUser(user, address));		//i user???
	}
	
	@Test
	public void addItem() {
		assertEquals("Item was not added", true, database.addItem(item));		//i item
	}
	
	@Test
	public void tryDuplicateItem() {
		assertEquals("Item was added", false, database.addItem(item));		//i item
	}
	
	@Test
	public void addFavourite() {
		Item item = new Item("a@test.com", "Painting 1", "A painting, painted using pencil.", 30.00);
		ArtsYuser user = new ArtsYuser("c@test.com", "hej123", "c_user"); 
		assertEquals("Favourite was not added", true, database.addFavourite(item, user));	//i user eller item?
	}
	
	@Test
	public void removeFavourite() {		
		assertEquals("Favourite was not removed", true, database.removeFavourite(item, user));	//i user eller item?
	}
	
	/*
	@Test
	public void displayItemInfo() {
		assertEquals("Item not found", "OBJECT INNEHÅLLANDE ITEM TO DISPLAY", database.getItem()); 	//detta ska inte vara i Item-classen? 
		//SELECT * FROM item WHERE itemID = ID PARAMETER;
	}

	
	@Test
	public void sale() {
		assertEquals("Sale not added", true, database.perfomSale(sale));	//i sale		!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
	}
	
	@Test 
	public void searchTest() {
		assertEquals("Nothing found", "lista(?) INNEHÅLLANDE ITEM TO DISPLAY", database.getSearchResults());	//eller bara kolla så att det inte är null?
		assertNotNull(database.getSearchResults());										// VAR placera?
		//SELECT * FROM item WHERE title LIKE '%6%' or description LIKE '%pa%';
	}
	
	@Test
	public void getOverviewOfSales() {
		assertEquals("No sales found", "lista(?) INNEHÅLLANDE ITEM TO DISPLAY", database.getSalesOverview(user)); //eller bara kolla så att det inte är null?
		//SELECT * FROM sale, item WHERE sale.item = item.itemID AND seller = "email address from logged in user (the seller)"
	}																					//i user
	
	@Test
	public void getOverviewOfPurchases() {
		assertEquals("No purchases found", "lista(?) INNEHÅLLANDE ITEM TO DISPLAY", database.getPurchaseOverview(user)); //eller bara kolla så att det inte är null?
		//SELECT * FROM sale WHERE buyer = "email address from logged in user (the buyer)";
	}																					//i user
	
	@Test
	public void addReview() {
		int reviewID = 1;	//remove this, and just add 1 instead
		assertEquals("Review not added", true, database.addReview(saleID));	//i review
		//INSERT INTO review (reviewID, sale, ratingValue, ratingText) VALUES ('"+ +"', '"+ saleID +"', '"+ +"', '"+ +"'); //review.Getters
	}
	
	@Test
	public void calculateDelivery() {		!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		int buyerID = 1;
		int sellerID = 2;				
		assertEquals("Postage could not be calculated", "COST OF POSTAGE OF AN ITEM", database.calculatePostage(item, buyerID, sellerID));	//i item?
	} 
	
	@Test
	public void removeItem() {
		assertEquals("Item not removed", true, database.removeItem(item));	//i item
		DELETE FROM item WHERE itemID = ' + "item.getItemID() + "'; 
	}
	*/
	

}
