package artsYtest;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Test;

import artsYcode.Sale;

public class SaleTest {
	
	//LocalDateTime saleDateTime = LocalDateTime.of(2014, 4, 15, 11, 30);
	Sale sale = new Sale(0, "henrietta@test.com", 6, "CT1 2AW", "2018-08-23", 1225, 5.99);
	
	@Test
	public void saleExistanceCheck() {
		assertNotNull(sale);
	}
	
	@Test
	public void getSaleID() {
		assertEquals("The sale ID is not the one expected", 0, sale.getSaleID());
	}
	
	@Test
	public void setSaleID() {
		sale.setSaleID(13);
		assertEquals("The sale ID is not the one expected", 13, sale.getSaleID());
	}

	@Test
	public void getItemID() {
		assertEquals("The item ID is not the one expected", 0, sale.getItemID());
	}
	
	@Test
	public void setItemID() {
		sale.setItemID(13);
		assertEquals("The item ID is not the one expected", 13, sale.getItemID());
	}
	
	@Test
	public void getBuyer() {
		assertEquals("The reviewer is not the one expected", "henrietta@test.com", sale.getBuyer());
	}
	
	@Test
	public void setBuyer() {
		sale.setBuyer("hentho@test.co.uk");
		assertEquals("The reviewer is not the one expected", "hentho@test.co.uk", sale.getBuyer());
	}
	
	@Test
	public void getHouseNumber() {
		assertEquals("House number is not the one expected", 6, sale.getHouseNumber());
	}
	
	@Test
	public void setHouseNumber() {
		sale.setHouseNumber(7);
		assertEquals("House number is not the one expected", 7, sale.getHouseNumber());
	}
	
	@Test
	public void getPostcode() {
		assertEquals("Postcode is not the one expected", "CT1 2AW", sale.getPostcode());
	}
	
	@Test
	public void setPostcode() {
		sale.setPostcode("M50 3YJ");
		assertEquals("Postcode is not the one expected", "M50 3YJ", sale.getPostcode());
	}
	
	//////	TO BE UPDATED WHEN BETTER DATE HANDLING IS CONJURED UP
	@Test
	public void getPurchaseDate() {
		assertEquals("The date and time fo the purchase is not the one expected", "2018-08-23", sale.getSaleDate());
	}
	
	@Test
	public void setPurchaseDate() {
		sale.setSaleDate("2008-03-14");
		assertEquals("The date and time fo the purchase is not the one expected", "2008-03-14", sale.getSaleDate());
	}
	
	@Test
	public void getPurchaseTime() {
		assertEquals("The date and time fo the purchase is not the one expected", 1225, sale.getSaleTime());
	}
	
	@Test
	public void setPurchaseTime() {
		sale.setSaleTime(1335);
		assertEquals("The date and time fo the purchase is not the one expected", 1335, sale.getSaleTime());
	}
	
	//////
	
	@Test
	public void getDeliveryPrice() {
		assertEquals("The item price is not the one expected", 599, sale.getDeliveryPrice(), 0.00);
	}
	
	@Test
	public void setDeliveryPrice() {
		sale.setDeliveryPrice(66.66);
		assertEquals("The item price is not the one expected", 6666, sale.getDeliveryPrice(), 0.00);
	}
	
	@Test
	public void getDeliveryStatus() {
		assertEquals("The status is not the one expected", 'A', sale.getStatus());
	}
	
	@Test
	public void setDeliveryStatus() {
		sale.setStatus('S');
		assertEquals("The status is not the one expected", 'S', sale.getStatus());
	}	

	@Test
	public void returnPriceInt() {
		assertEquals("The converted delivery price is not the one expected", 6666, sale.priceAsInteger(66.66), 0.00);
	}
	
	@Test
	public void calculatePostage() {
		//placera postageberäkning i item? Utifrån mått och vikt!
	}

}
