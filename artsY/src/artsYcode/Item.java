package artsYcode;

public class Item {

	private static int itemIDcounter = 0;
	private int itemID;
	private String seller;
	private String title;
	private String description;
	private int price;
	
//	public Item() {}
	
	public Item(String seller, String title, String description, double price) {
		//höjd, bredd, djup, vikt (för porto!)
		this.itemID = itemIDcounter;
		this.seller = seller;
		this.title = title;
		this.description = description;
		this.price = priceAsInteger(price);		
		increaseIDcounter();		
	}
	
	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = priceAsInteger(price);
	}

	public int priceAsInteger(double priceAsDouble) {
		return (int) (priceAsDouble * 100);
	}
	
	public void increaseIDcounter() {
		itemIDcounter++;
	}
}
