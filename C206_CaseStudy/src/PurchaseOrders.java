
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Yong Sir Hong, Aug 1, 2021 3:22:38 PM
 */

public class PurchaseOrders {
	
	private String stallName;
	private String ingredients;
	private int quantity;
	
	
	public PurchaseOrders(String stallName, String ingredients, int quantity) {
		this.stallName = stallName;
		this.ingredients = ingredients;
		this.quantity = quantity;
	}


	public String getStallName() {
		return stallName;
	}


	public String getIngredients() {
		return ingredients;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
