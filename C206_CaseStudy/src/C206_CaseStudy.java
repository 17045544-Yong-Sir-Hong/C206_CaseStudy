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
					}else if (function ==2) {
						viewStall(stallList);
					}else if (function ==3) {
						deleteStall(stallList);
					}else {
						System.out.println("Invalid function");
					}
					
					
				} else if (pick == 2) {
					foodItemsFunction();

					int function = Helper.readInt("Enter option to select a function > ");
					
					if (function == 1) {
						addFoodItems(foodItemList);
					} else if (function == 2) {
						viewFoodItems(foodItemList);
					} else if (function == 3) {
						deleteFoodItems(foodItemList);
					} else {
						System.out.println("Invalid function");
					}
					
				}
				

			} else if (option == 2) {
				canteenAdministratorMenu();
				Helper.line(80, "-");
				System.out.println("Stall Staff Users");
				Helper.line(80, "-");
				System.out.println("1. Purchase Orders of Ingredients");
				System.out.println("2. Promotion Offers \n");
				
				int choice = Helper.readInt("Enter option to select a choice > ");
				
				if (choice == 1) {
					
				} else if (choice == 2) {
					Helper.line(80,  "-");
					System.out.println("PROMOTION OFFERS");
					Helper.line(80,  "-");
					System.out.println("1. Add Promotion Offers");
					System.out.println("2. View Promotion Offers");
					System.out.println("3. Delete Promotion Offers \n");
					
					int function = Helper.readInt("Enter option to select a function > ");
					
					if (function == 1) {
						C206_CaseStudy.addPoffer();
					} else if (function == 2) {
						C206_CaseStudy.viewPoffer();
					} else if (function == 3){
						C206_CaseStudy.deletePoffer();
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

	/**
	 * 
	 */

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
	
	public static void addPoffer() {
		
	}
	
	public static void viewPoffer() {
		
	}

	
	public static void deletePoffer() {
		
	}
	
	public static void canteenAdministratorMenu() { 
		Helper.line(80, "-");
		System.out.println("CANTEEN ADMINISTRATOR");
		Helper.line(80, "-");
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
		String stallName= Helper.readString("Enter New Stall Name >");
		LocalDate today = LocalDate.now();
		String formattedDate = today.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
		System.out.println("Date of stall " + formattedDate);
		
		if(!(stallList.contains(stallName)) && stallList.size() <= 10) {
			stallList.add(new stall(stallName));
			System.out.println("New Stall has been sucessfully added");
		}else {
			System.out.println("The Stall is currently exisitng");
		}
		
	}
	public static void viewStall(ArrayList<stall>stallList) {
		Helper.line(80, "-");
		System.out.println("VIEW ALL STALL");
		Helper.line(80, "-");
		
		String output= String.format("%-10s\n", "NAME");
		
		for (stall s: stallList) {
			output += String.format("%-10s \n", s.getStallName());
		}
		System.out.println(output);
	}
	public static void deleteStall(ArrayList<stall> stallList) {
		Helper.line(80, "-");
		System.out.println("DELETE STALL");
		Helper.line(80, "-");
		
		String stallname= Helper.readString("Enter Stall Name to delete > ");
		char confirm = Helper.readChar("Are you sure (Y/N)> ");
		
		for(int i =0; i < stallList.size(); i++) {
			if(stallname == stallList.get(i).getStallName() && confirm == 'Y' || confirm == 'y') {
				stallList.remove(i);
				System.out.println(stallname + " has been successfully deleted");
				
			}
		}
	}
	

	
	public static void foodItemsFunction() {
		Helper.line(80,  "-");
		System.out.println("FOOD ITEMS IN MENU");
		Helper.line(80,  "-");
		System.out.println("1. Add Food Items to Menu");
		System.out.println("2. View Food Items in Menu");
		System.out.println("3. Delete Food Items in Menu \n");
	}
	
	public static void addFoodItems(ArrayList<foodItems> foodItemList) {
		Helper.line(80, "-");
		System.out.println("ADD FOOD ITEMS TO MENU");
		Helper.line(80, "-");
		String name = Helper.readString("Enter New Food Item Name > ");
		Integer price = Helper.readInt("Enter New Food Item Selling Price ($3 to $15) > $");
		
		if (!(name.isEmpty()) && price >= 3 && price <= 15) {
			foodItemList.add(new foodItems(name, price));
			System.out.println("New food item has been successfully added into the menu!");
			
		} else {
			System.out.println("Price MUST be between $3 to $15");
		}
		
	}
	
	public static void viewFoodItems(ArrayList<foodItems> foodItemList) {
		Helper.line(80, "-");
		System.out.println("VIEW FOOD ITEMS IN MENU");
		Helper.line(80, "-");
		
		String output = String.format("%-10s %-10s\n", "NAME", "SELLING PRICE");
		
		for (foodItems ft : foodItemList) {
			output += String.format("%-10s $%-10d\n", ft.getName(), ft.getSellingPrice());
		}
		System.out.println(output);
		
	}
	
	public static void deleteFoodItems(ArrayList<foodItems> foodItemList) {
		Helper.line(80, "-");
		System.out.println("DELETE FOOD ITEMS IN MENU");
		Helper.line(80, "-");
		
		String name = Helper.readString("Enter food item name to delete > ");
		char confirm = Helper.readChar("Are you sure (Y/N) > ");
		
		for (int i = 0; i < foodItemList.size(); i++) {
			if (name == foodItemList.get(i).getName() && confirm == 'Y') {
				foodItemList.remove(i);
				System.out.println(name + " has been successfully deleted!");
			} 
		}
		
	}
	
	
	
}
