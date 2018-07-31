package artsYtest;

import org.junit.Test;

public class TestHarness {
	
	@Test
	public void overAllTest() {
		ArtsYuserTest userTest = new ArtsYuserTest();
		userTest.userExistanceCheck();
		userTest.getEmail();
		userTest.setEmail();
		userTest.getPassword();
		userTest.setPassword();
		userTest.getUsername();
		userTest.setUsername();
		userTest.getHouseNumber();
		userTest.setHouseNumber();
		userTest.getPostcode();
		userTest.setPostcode();
		userTest.getStreet();
		userTest.setStreet();
		userTest.getCity();
		userTest.setCity();
		userTest.getCounty();
		userTest.setCounty();
		
		ItemTest itemTest = new ItemTest();		
		itemTest.itemExistanceCheck();
		itemTest.getItemID();
		itemTest.setItemID();
		itemTest.getItemSeller();
		itemTest.setItemSeller();
		itemTest.getItemTitle();
		itemTest.setItemTitle();
		itemTest.getItemDescription();
		itemTest.setItemDescription();
		itemTest.getItemPrice();
		itemTest.setItemPrice();
		itemTest.returnPriceInt();
		
		ReviewTest reviewTest = new ReviewTest();	
		reviewTest.reviewExistanceCheck();
		reviewTest.getReviewID();
		reviewTest.setReviewID();
		reviewTest.getSaleID();
		reviewTest.setSaleID();
		reviewTest.getRatingValue();
		reviewTest.setRatingValue();
		reviewTest.getRatingText();
		reviewTest.setRatingText();
		
		SaleTest saleTest = new SaleTest();		
		saleTest.saleExistanceCheck();
		saleTest.getSaleID();
		saleTest.setSaleID();
		saleTest.getItemID();
		saleTest.setItemID();
		saleTest.getBuyer();
		saleTest.setBuyer();
		saleTest.getHouseNumber();
		saleTest.setHouseNumber();
		saleTest.getPostcode();
		saleTest.setPostcode();
		saleTest.getPurchaseDate();
		saleTest.setPurchaseDate();
		saleTest.getPurchaseTime();
		saleTest.setPurchaseTime();
		saleTest.getDeliveryPrice();
		saleTest.setDeliveryPrice();
		saleTest.getDeliveryStatus();
		saleTest.setDeliveryStatus();
		saleTest.returnPriceInt();
	}
	
}
