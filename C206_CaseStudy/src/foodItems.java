
public class foodItems {
	
	private String name;
	private int sellingPrice;
	
	public foodItems(String name, int sellingPrice) {
		super();
		this.name = name;
		this.sellingPrice = sellingPrice;
	}

	public String getName() {
		return name;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	

}
