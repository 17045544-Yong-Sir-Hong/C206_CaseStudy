
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20021437, 1 Aug 2021 3:01:22 pm
 */

public class Poffer {
	private String name;
	private int sellingPrice;
	private String stallname;
	
	public Poffer(String name, int sellingPrice, String stallname) {
		this.name = name;
		this.sellingPrice = sellingPrice;
		this.stallname = stallname;
	}

	public String getName() {
		return name;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}
	
	public String getStallName() {
		return stallname;
	}
}
