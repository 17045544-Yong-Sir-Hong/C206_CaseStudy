
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
	
}
