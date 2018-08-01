package artsYtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import artsYcode.Item;

public class ItemTest {
		
	Item item = new Item("henrietta@test.com", "A painting", "A description of said painting", 13.33);
	
	@Test
	public void itemExistanceCheck() {
		assertNotNull(item);
	} 
	
	@Test
	public void getItemID() {
		assertEquals("The item ID is not the one expected", 1, item.getItemID());
	}
	
	@Test
	public void setItemID() {
		item.setItemID(13);
		assertEquals("The item ID is not the one expected", 13, item.getItemID());
	}
	
	@Test
	public void getItemSeller() {
		assertEquals("The item seller is not the one expected", "henrietta@test.com", item.getSeller());
	}
	
	@Test
	public void setItemSeller() {
		item.setSeller("name@test.co.uk");
		assertEquals("The item seller is not the one expected", "name@test.co.uk", item.getSeller());
	}
	
	@Test
	public void getItemTitle() {
		assertEquals("The item title is not the one expected", "A painting", item.getTitle());
	}
	
	@Test
	public void setItemTitle() {
		item.setTitle("An actual name");
		assertEquals("The item seller is not the one expected", "An actual name", item.getTitle());
	}
	
	@Test
	public void getItemDescription() {
		assertEquals("The item description is not the one expected", "A description of said painting", item.getDescription());
	}
	
	@Test
	public void setItemDescription() {
		item.setDescription("Something about sizes and inspiration and colours etc.");
		assertEquals("The item description is not the one expected", "Something about sizes and inspiration and colours etc.", item.getDescription());
	}

	@Test
	public void getItemPrice() {
		assertEquals("The item price is not the one expected", 1333, item.getPrice(), 0.0);
	}
	
	@Test
	public void setItemPrice() {
		item.setPrice(66.66);
		assertEquals("The item price is not the one expected", 6666, item.getPrice(), 0.00);
	}

	@Test
	public void returnPriceInt() {
		assertEquals("The converted price is not the one expected", 6666, item.priceAsInteger(66.66), 0.00);
	}

}
