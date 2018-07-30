package artsYtest;

import static org.junit.Assert.*;

import org.junit.Test;

import artsYcode.Review;

public class ReviewTest {

	Review review = new Review(6, 0, 5, "Magnificent etc");
	
	@Test 
	public void reviewExistanceCheck() {
		assertNotNull(review);
	}
	
	@Test
	public void getReviewID() {
		assertEquals("The reviewer is not the one expected", 6, review.getReviewID());
	}
	
	@Test
	public void setReviewID() {
		review.setReviewID(13);
		assertEquals("The reviewer is not the one expected", 13, review.getReviewID());
	}
	
	@Test
	public void getSaleID() {
		assertEquals("The sale ID is not the one expected", 0, review.getSaleID());
	}
	
	@Test
	public void setSaleID() {
		review.setSaleID(13);
		assertEquals("The sale ID is not the one expected", 13, review.getSaleID());
	}
	
	@Test
	public void getRatingValue() {
		assertEquals("The rating value is not the one expected", 5, review.getRatingValue());
	}
	
	@Test
	public void setRatingValue() {
		review.setRatingValue(1);
		assertEquals("The rating value is not the one expected", 1, review.getRatingValue());
	}
	
	@Test
	public void getRatingText() {
		assertEquals("The rating is not the one expected", "Magnificent etc", review.getRatingText());
	}
	
	@Test
	public void setRatingText() {
		review.setRatingText("Utter shit etc");
		assertEquals("The rating is not the one expected", "Utter shit etc", review.getRatingText());
	}
	
}
