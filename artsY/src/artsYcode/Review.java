package artsYcode;

public class Review {
	
	private int reviewID;
	private int saleID;
	private int ratingValue;
	private String ratingText;

	//public Review() {}
	
	public Review(int reviewID, int saleID, int ratingValue, String ratingText) {
		this.reviewID = reviewID;
		this.saleID = saleID;
		this.ratingValue = ratingValue;
		this.ratingText = ratingText;
	}
	
	public int getReviewID() {
		return reviewID;
	}

	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	
	public int getSaleID() {
		return saleID;
	}

	public void setSaleID(int saleID) {
		this.saleID = saleID;
	}

	public int getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(int ratingValue) {
		this.ratingValue = ratingValue;
	}

	public String getRatingText() {
		return ratingText;
	}

	public void setRatingText(String ratingText) {
		this.ratingText = ratingText;
	}
	
	
}
