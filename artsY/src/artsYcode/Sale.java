package artsYcode;

public class Sale {	//implements Address 
	
	private static int saleIDcounter = 0;
	private int saleID;
	private int itemID;
	private String buyer;
	private int houseNumber;
	private String postcode;
	//private LocalDateTime saleDateTime;
	private String saleDate;
	private int saleTime;
	private int deliveryPrice;
	private char status;	

	public Sale() {}
	
	public Sale(int itemID, String buyer, int houseNumber, String postcode, String saleDate, int saleTime, double deliveryPrice) {
		this.saleID = saleIDcounter;
		this.itemID = itemID;
		this.buyer = buyer;
		this.houseNumber = houseNumber;
		this.postcode = postcode;
		this.saleDate = saleDate;
		this.saleTime = saleTime;
		this.deliveryPrice = priceAsInteger(deliveryPrice);
		this.status = 'A'; //A = purchase accepted, H = being handled by seller, S = sent, D = delivered 
		increaseIDcounter();
	}

	public int getSaleID() {
		return saleID;
	}

	public void setSaleID(int saleID) {
		this.saleID = saleID;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	
	public int getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(int saleTime) {
		this.saleTime = saleTime;
	}

	public int getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(double deliveryPrice) {
		this.deliveryPrice = priceAsInteger(deliveryPrice);
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public int priceAsInteger(double priceAsDouble) {
		return (int) (priceAsDouble * 100);
	}
	
	public void increaseIDcounter() {
		saleIDcounter++;
	}
	
	
}
