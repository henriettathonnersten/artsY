package artsYcode;

public class ItemBuilder {
	
	private String seller;
	private String title;
	private String description;
	private double price;
	
	public ItemBuilder() {}
	
	public Item buildItem() {
		return new Item(seller, title, description, price); 
	}
	
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

}
