
public class C206_CaseStudy {

	private static final int OPTION_QUIT = 3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {


			} else if (option == 2) {
				System.out.println("Stall Staff Users");
				System.out.println("1. Orders Placed By Customers");
				System.out.println("2. Purchase Orders of Ingredients");
				System.out.println("3. Promotion Offers");
				
				int choice = Helper.readInt("Enter option to select choice > ");
				
				if (choice == 1) {
					
				} else if (choice == 2) {
					
				} else if (choice == 3) {
					System.out.println("Promotion Offers");
					System.out.println("1. Add promotion offers");
					System.out.println("2. View promotion offers");
					System.out.println("3. Edit promotion offers");
					System.out.println("4. Delete promotion offers");
					
					int type = Helper.readInt("Enter option to select choice > ");
					
					if (type == 1) {
						C206_CaseStudy.addPoffer();
					} else if (type == 2) {
						C206_CaseStudy.viewPoffer();
					} else if (type == 3) {
						C206_CaseStudy.editPoffer();
					} else if (type == 4){
						C206_CaseStudy.deletePoffer();
					} else {
						System.out.println("Invalid type");
					}
					
				} else {
					System.out.println("Invalid type");
				}
				
			} else if (option == 3) {
				System.out.println("Bye!");
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
		System.out.println("3. Quit");
		Helper.line(80, "-");

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
	
	public static void editPoffer() {
		
	}
	
	public static void deletePoffer() {
		
	}
}
