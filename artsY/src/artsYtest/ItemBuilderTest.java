package artsYtest;

import static org.junit.Assert.*;

import org.junit.Test;

import artsYcode.ItemBuilder;

public class ItemBuilderTest {
	
	ItemBuilder itemBuilder = new ItemBuilder();
	
	@Test
	public void existanceCheck() {
		assertNotNull(itemBuilder);
	}
	
	@Test
	public void itemCreation() {
		assertEquals("User not created", itemBuilder, itemBuilder.buildItem());			//user som endast håller nullValues?
	}
	
	@Test
	public void setSeller() {
		
	}
	
	@Test
	public void setTitle() {
		
	}
	
	@Test
	public void setDescription() {
		
	}
	
	@Test
	public void setPrice() {
		
	}
	/*
	public ItemBuilder seller (String seller) {
		this.seller = seller;
		return this;
	}
	
	public ItemBuilder title (String title) {
		this.title = title;
		return this;
	}
	public ItemBuilder description (String description) {
		this.description = description;
		return this;
	}
	
	public ItemBuilder price (double price) {
		this.price = price;
		return this;
	}		
	*/
	

}
