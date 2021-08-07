import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<foodItems> foodItemList = new ArrayList<foodItems>();

		ArrayList<Poffer> pofferList = new ArrayList<Poffer>();

		ArrayList<PurchaseOrders> PurchaseOrdersList = new ArrayList<PurchaseOrders>();

		ArrayList<stall> stallList = new ArrayList<stall>();

		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				canteenAdministratorMenu();

				int pick = Helper.readInt("Enter option to select a choice > ");

				if (pick == 1) {

					canteenAdminFunction();
					int function = Helper.readInt("Enter option to select a function > ");

					if (function == 1) {
						addNewStall(stallList);
					} else if (function == 2) {
						viewAllstall(stallList);
					} else if (function == 3) {
						deleteStall(stallList);
					} else {
						System.out.println("Invalid function");
					}

				} else if (pick == 2) {
					foodItemsFunction();

					int function = Helper.readInt("Enter option to select a function > ");

					if (function == 1) {
						addFoodItems(foodItemList);
					} else if (function == 2) {
						viewAllFoodItems(foodItemList);
					} else if (function == 3) {
						deleteFoodItems(foodItemList);
					} else {
						System.out.println("Invalid function");
					}

				}

			} else if (option == 2) {
				Helper.line(80, "-");
				System.out.println("Stall Staff Users");
				Helper.line(80, "-");
				System.out.println("1. Purchase Orders of Ingredients");
				System.out.println("2. Promotion Offers \n");

				int choice = Helper.readInt("Enter option to select a choice > ");

				if (choice == 1) {

					Helper.line(80, "-");
					System.out.println("PURCHASE ORDERS OF INGREDIENTS");
					Helper.line(80, "-");
					System.out.println("1. Add Purchase Orders Of Ingredeints");
					System.out.println("2. View Purchase Order Of Ingredients");
					System.out.println("3. Delete Purchase Orders Of Ingredients ");
					System.out.println("4. Update Purchase Orders Of Ingredients \n");

					int function = Helper.readInt("Enter option to select a function > ");

					if (function == 1) {
						PurchaseOrders pO1 = addPurchasesOrder();
						addPurchasesOrder(PurchaseOrdersList, pO1);
					} else if (function == 2) {
						String storeName = viewPurchasesOrder();
						viewPurchasesOrder(PurchaseOrdersList, storeName);
					} else if (function == 3) {
						PurchaseOrders pO3 = deletePurchasesOrder();
						deletePurchasesOrder(PurchaseOrdersList, pO3);
					} else if (function == 4) {
//						updatePurchasesOrderQuantity(PurchaseOrdersList, pO);
						PurchaseOrders pO4 = updatePurchasesOrderQuantity();
						updatePurchasesOrderQuantity(PurchaseOrdersList, pO4);
					}
					else
					{
						System.out.println("Invalid function");
					}

				} else if (choice == 2) {
					Helper.line(80, "-");
					System.out.println("PROMOTION OFFERS");
					Helper.line(80, "-");
					System.out.println("1. Add Promotion Offers");
					System.out.println("2. View Promotion Offers");
					System.out.println("3. Delete Promotion Offers");
					System.out.println("4. Update Promotion Offers\n");

					int function = Helper.readInt("Enter option to select a function > ");

					if (function == 1) {
						C206_CaseStudy.addPoffer(pofferList);
					} else if (function == 2) {
						C206_CaseStudy.viewAllPoffer(pofferList);
					} else if (function == 3) {
						C206_CaseStudy.deletePoffer(pofferList);
					} else if (function == 4) {
						C206_CaseStudy.updatePoffer(pofferList);
					} else {
						System.out.println("Invalid function");
					}

				} else {
					System.out.println("Invalid choice");
				}

			} else if (option == 3) {
				System.out.println("Thank you for using Canteen Automation System (CAS)!");
			} else {
				System.out.println("Invalid option");
			}
		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("CANTEEN AUTOMATION SYSTEM (CAS)");
		System.out.println("1. Canteen Administrator");
		System.out.println("2. Stall Staff");
		System.out.println("3. Quit \n");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void addPoffer(ArrayList<Poffer> pofferList) {
		setHeader("ADD PROMOTION OFFERS MENU");
		String name = Helper.readString("Enter New Promotion Offer Name > ");
		Integer price = Helper.readInt("Enter New Promotion Offer Selling Price ($3 to $15) > $");
		String stallname = Helper.readString("Enter Stall Name > ");

		int count = 0;

		if (!(name.isEmpty()) || (price >= 3 && price <= 15) || !(stallname.isEmpty())) {
			for (int i = 0; i < pofferList.size(); i++) {
				if (pofferList.get(i).getStallName().contains(stallname)) {
					count++;
				}
			}
			if (count < 1) {
				pofferList.add(new Poffer(name, price, stallname));
				System.out.println("New promotion offer has been successfully added into the menu!");
			} else {
				System.out.println("There can only be one promotion offer per stall per day.");
			}
		} else {
			System.out.println("Price MUST be between $3 to $15");
		}
	}

	public static String retrieveAllPoffer(ArrayList<Poffer> PofferList) {
		String output = "";

		for (int i = 0; i < PofferList.size(); i++) {

			output += String.format("%-10s $%-19d %-10s\n", PofferList.get(i).getName(),
					PofferList.get(i).getSellingPrice(), PofferList.get(i).getStallName());
		}
		return output;
	}

	public static void viewAllPoffer(ArrayList<Poffer> PofferList) {
		setHeader("VIEW PROMOTION OFFERS MENU");
		String output = String.format("%-10s %-20s %-10s\n", "NAME", "SELLING PRICE", "STALL NAME");
		output += retrieveAllPoffer(PofferList);
		System.out.println(output);
	}

	public static void deletePoffer(ArrayList<Poffer> pofferList) {
		setHeader("DELETE PROMOTION OFFERS MENU");
		String name = Helper.readString("Enter promotion offer name to delete > ");
		char confirm = Helper.readChar("Are you sure (Y/N) > ");

		for (int i = 0; i < pofferList.size(); i++) {
			if (pofferList.get(i).getName().equals(name) && confirm == 'Y' || confirm == 'y') {
				pofferList.remove(i);
				System.out.println(name + " has been successfully deleted!");
			}
		}
	}

	public static void updatePoffer(ArrayList<Poffer> pofferList) {
		setHeader("UPDATE PROMOTION OFFERS MENU");
		String name = Helper.readString("Enter promotion offer name to update > ");

		for (int i = 0; i < pofferList.size(); i++) {
			if (pofferList.get(i).getName().equals(name)) {
				String newname = Helper.readString("Enter new promotion offer name > ");
				int price = Helper.readInt("Enter new price of promotion offer > ");
				if ((price >= 3 && price <= 15)) {
					pofferList.get(i).setName(newname);
					pofferList.get(i).setSellingPrice(price);
					System.out.println("Promotion offer updated!");
				} else {
					System.out.println("Price MUST be between $3 to $15");
				}
			} else {
				System.out.println("Name not found");
			}
		}
	}

	public static void canteenAdministratorMenu() {
		C206_CaseStudy.setHeader("CANTEEN ADMINISTRATOR");
		System.out.println("1. Stall");
		System.out.println("2. Food Items in Menu \n");
	}

	public static void canteenAdminFunction() {
		Helper.line(80, "-");
		System.out.println("STALL ITEMS IN MENU");
		Helper.line(80, "-");
		System.out.println("1. Add a New Stall");
		System.out.println("2. View an Existing Stall");
		System.out.println("3. Delete an Existing Stall");
	}

	public static void addNewStall(ArrayList<stall> stallList) {
		Helper.line(80, "-");
		String stallName = Helper.readString("Enter New Stall Name >");
		LocalDate today = LocalDate.now();
		String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
		System.out.println("Date of Stall >" + formattedDate);

		if (!(stallList.contains(stallName)) && stallList.size() <= 10) {
			stallList.add(new stall(stallName));

			System.out.println("New Stall has been sucessfully added");
		} else {
			System.out.println("The Stall is currently existng");
		}

	}

	public static String retrieveAllstall(ArrayList<stall> stallList) {
		String output = "";

		for (int i = 0; i < stallList.size(); i++) {

			output += String.format("%-10s \n", stallList.get(i).getStallName());

		}
		return output;
	}

	public static void viewAllstall(ArrayList<stall> stallList) {
		C206_CaseStudy.setHeader("STALL");
		String output = String.format("%-10s\n", "NAME");
		output += retrieveAllstall(stallList);
		System.out.println(output);
	}

	public static void deleteStall(ArrayList<stall> stallList) {
		Helper.line(80, "-");
		System.out.println("DELETE STALL");
		Helper.line(80, "-");

		String stallname = Helper.readString("Enter Stall Name to delete > ");
		char confirm = Helper.readChar("Are you sure (Y/N)> ");

		for (int i = 0; i < stallList.size(); i++) {
			if (stallname == stallList.get(i).getStallName() && confirm == 'Y' || confirm == 'y') {
				stallList.remove(i);
				System.out.println(stallname + " has been successfully deleted");
			}else if (confirm == 'N' || confirm == 'n'){
				System.out.println(stallname + " deletion has been cancelled ");	
			}else {
				System.out.println("Delete has Failed");
				
			}
		}
	}

	public static void foodItemsFunction() {
		C206_CaseStudy.setHeader("FOOD ITEMS IN MENU");
		System.out.println("1. Add Food Items to Menu");
		System.out.println("2. View Food Items in Menu");
		System.out.println("3. Delete Food Items in Menu \n");
	}

	public static void addFoodItems(ArrayList<foodItems> foodItemList) {
		C206_CaseStudy.setHeader("ADD FOOD ITEMS TO MENU");
		String name = Helper.readString("Enter New Food Item Name > ");
		Integer price = Helper.readInt("Enter New Food Item Selling Price ($3 to $15) > $");

		if (!(name.isEmpty()) && price >= 3 && price <= 15) {
			foodItemList.add(new foodItems(name, price));
			System.out.println("New food item has been successfully added into the menu!");

		} else {
			System.out.println("Please enter a selling price between $3 to $15");
		}

	}

	public static String retrieveAllFoodItems(ArrayList<foodItems> foodItemList) {
		String output = "";

		for (int i = 0; i < foodItemList.size(); i++) {

			output += String.format("%-10s $%-10d\n", foodItemList.get(i).getName(),
					foodItemList.get(i).getSellingPrice());
		}
		return output;
	}

	public static void viewAllFoodItems(ArrayList<foodItems> foodItemList) {
		C206_CaseStudy.setHeader("VIEW FOOD ITEMS IN MENU");
		String output = String.format("%-10s %-10s\n", "NAME", "SELLING PRICE");
		output += retrieveAllFoodItems(foodItemList);
		System.out.println(output);
	}

	public static void deleteFoodItems(ArrayList<foodItems> foodItemList) {
		C206_CaseStudy.setHeader("DELETE FOOD ITEMS IN MENU");

		String name = Helper.readString("Enter food item name to delete > ");
		char confirm = Helper.readChar("Are you sure (Y/N) > ");

		for (int i = 0; i < foodItemList.size(); i++) {
			if (foodItemList.get(i).getName().equals(name)) {
				if (confirm == 'Y') {
					foodItemList.remove(i);
					System.out.println(name + " has been successfully deleted!");
				} else {
					System.out.println("Delete Cancelled!");
				}

			} else {
				System.out.println("Delete Failed!");
				break;
			}
		}

	}
	
	public static void updateFoodItems(ArrayList<foodItems> foodItemList) {
		
	}

	
	public static PurchaseOrders addPurchasesOrder() //Sir Hong
	{
		{
			String stallName = Helper.readString("Enter Stall Name > ");
			String ingredients = Helper.readString("Enter ingredients to buy > ");
			int quantity = Helper.readInt("Enter the number of quantity to buy >");
			
			PurchaseOrders pO = new PurchaseOrders(stallName, ingredients, quantity);

			
			return pO;
		
		}
	}
	public static void addPurchasesOrder(ArrayList<PurchaseOrders> PurchaseOrdersList, PurchaseOrders pO) //Sir Hong
	{
		String stallName = pO.getStallName();
		String ingredients = pO.getIngredients();
		int quantity = pO.getQuantity();
		int count = 0;
	
		if (stallName.isEmpty() || ingredients.isEmpty() || quantity <= 0) {
			System.out.println("New Ingredients has not been added into the Purchases Order!");
		}

		else {
			for (int i = 0; i < PurchaseOrdersList.size(); i++) {
				if (PurchaseOrdersList.get(i).getStallName().contains(stallName)) {
					count++;
				}
			}
			if (count < 8) {
				PurchaseOrdersList.add(new PurchaseOrders(stallName, ingredients, quantity));
				System.out.println("New Ingredients has been successfully added into the Purchases Order!");
			} else {
				System.out.println("Exceeded the number of purchase order for this week!");
			}
		}
	}
	
	public static String viewPurchasesOrder() //Sir Hong
	{
		Helper.line(80, "-");
		System.out.println("VIEW PURCHASE ORDER OF INGREDIENTS");
		Helper.line(80, "-");
		
		String storeName = Helper.readString("Enter the Stall Name to view the Purchases Order > ");
		
		return storeName;
		
	}
	
	public static void viewPurchasesOrder(ArrayList<PurchaseOrders> PurchaseOrdersList, String storeName) //Sir Hong
	{
		boolean isValid = false;
		String output = String.format("%-20s %-20s %-20s\n", "Stall Name", "Ingredients", "Quantity");
		
		for (PurchaseOrders pO : PurchaseOrdersList) 
		{
			if(pO.getStallName().contentEquals(storeName))
			{
				output += String.format("%-20s %-20s %-20d\n", pO.getStallName(), pO.getIngredients(), pO.getQuantity());
				isValid = true;
			}
		}
		
		if(isValid == false)
		{
				output = "Stall Name cannot be found in the system!";
		}
		System.out.println(output);

	}
	
	
	public static PurchaseOrders deletePurchasesOrder() //Sir Hong
	{
		Helper.line(80, "-");
		System.out.println("DELETE PURCHASE ORDER OF INGREDIENTS");
		Helper.line(80, "-");
		
		String stallName = Helper.readString("Enter Stall Name to delete > ");
		String ingredientsName = Helper.readString("Enter Ingredients to delete > ");
		
		PurchaseOrders pO = new PurchaseOrders(stallName, ingredientsName, 1);
		
		return pO;
	}

	
	public static void deletePurchasesOrder(ArrayList<PurchaseOrders> PurchaseOrdersList, PurchaseOrders pO) //Sir Hong
	{
		
		boolean isValid = false;
		boolean isDeleted = false;
		String stallName = pO.getStallName();
		String ingredientsName = pO.getIngredients();
		
		
		for (int i = 0; i < PurchaseOrdersList.size(); i++) {
			if (PurchaseOrdersList.get(i).getStallName().equals(stallName) && PurchaseOrdersList.get(i).getIngredients().equals(ingredientsName)) {
				char confirm = Helper.readChar("Are you sure (Y/N) > ");
				
				while(confirm != 'y' && confirm != 'Y' && confirm != 'n' && confirm != 'N')
				{
					confirm = Helper.readChar("Please enter (Y/N) > ");
				}
				
				if (confirm == 'Y' || confirm == 'y') {
					PurchaseOrdersList.remove(i);
					isDeleted = true;
					isValid = true;
				}
				else if(confirm == 'N' || confirm == 'n')
				{
					isValid = true;
				}
			}
		}
		if (isValid == true)
		{
			if(isDeleted == true)
			{
				System.out.println(stallName + " Purchase Order of " + ingredientsName + " has been successfully deleted!");
			}
			else
			{
				System.out.println(stallName + " Purchase Order of " + ingredientsName + " will not be deleted!");
			}
		}
		else
		{
			System.out.println("There is no existing stall or ingredients in the system!");
		}
	}
	
	
	public static PurchaseOrders updatePurchasesOrderQuantity() //Sir Hong
	{
		String stallName = Helper.readString("Enter Stall Name > ");
		String updateIngredients = Helper.readString("Enter ingredients to update > ");
		int updateQuantity = Helper.readInt("Enter the number of quantity to update >");
		
		PurchaseOrders pO = new PurchaseOrders(stallName, updateIngredients, updateQuantity);
		if (stallName.isEmpty() || updateIngredients.isEmpty()) {
			System.out.println("Stall name, Ingredients cannot be empty");
		}
		return pO;
	}
	
	
	public static void updatePurchasesOrderQuantity(ArrayList<PurchaseOrders> PurchaseOrdersList, PurchaseOrders pO)  //Sir Hong
	{
		boolean updatedOrder = false;
		boolean quantityMoreThen1 = false;
		{
		for (int i = 0; i < PurchaseOrdersList.size(); i++) 
		{
		
			if (PurchaseOrdersList.get(i).getStallName().equals(pO.getStallName()) && PurchaseOrdersList.get(i).getIngredients().equals(pO.getIngredients())) 
			{
				if(pO.getQuantity() > 0)
				{
					PurchaseOrdersList.get(i).setQuantity(pO.getQuantity());
					updatedOrder = true;
					quantityMoreThen1 = true;
				}
			}
		}
		if(updatedOrder == true)
		{
			System.out.println("Order of ingredients has been updated for purchase");
		}
		else if(quantityMoreThen1 == false)
		{
			System.out.println("Quantity cannot be empty or less then 1");
		}
		else
		{
			System.out.println("Stall name or Ingredients is invalid!");
		}
	}
	}
}

