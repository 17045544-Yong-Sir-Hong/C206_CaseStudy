import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private foodItems ft1;
	private foodItems ft2;
	private ArrayList<foodItems> foodItemList;
	private Poffer po1;
	private Poffer po2;
	private ArrayList<Poffer> PofferList;
	
	private ArrayList<PurchaseOrders> PurchaseOrdersList;
	private PurchaseOrders purchaseOrder1;
	private PurchaseOrders purchaseOrder2;
	
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		ft1 = new foodItems("Curry", 3);
		ft2 = new foodItems("Soup", 15);
		
		foodItemList = new ArrayList<foodItems>();
		
		
		
		
		purchaseOrder1 = new PurchaseOrders("Test1", "Eggs", 20);
		purchaseOrder2 = new PurchaseOrders("Test2", "Rice", 20);
		PurchaseOrdersList= new ArrayList<PurchaseOrders>();

		po1 = new Poffer("Chicken", 3, "Chicken");
		po2 = new Poffer("Duck", 6, "Duck");
		
		
	}



	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void testAddFoodItems() {
		// Ensure that the Selling Price entered must be integer & between 3 to 15
		
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid foodItems arraylist to add to", foodItemList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addFoodItems(foodItemList);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, foodItemList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", ft1, foodItemList.get(0));
		
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addFoodItems(foodItemList);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, foodItemList.size());
	}
	
	@Test
	public void testRetrieveAllFoodItems() { 
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid foodItems arraylist to add to", foodItemList); 
		
		//test if the list of fooditems retrieved from the case study is empty
		String allFoodItems = C206_CaseStudy.retrieveAllFoodItems(foodItemList); 
		String testOutput = "";
		assertEquals("Check that ViewAllFoodItemslist", testOutput, allFoodItems); 
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addFoodItems(foodItemList);
		C206_CaseStudy.addFoodItems(foodItemList);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, foodItemList.size());
		
		//test if the expected output string same as the list of fooditems retrieved from the case study
		allFoodItems = C206_CaseStudy.retrieveAllFoodItems(foodItemList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allFoodItems);
		
	}
	
	@Test
	public void testDeleteFoodItems() {
		
	}
	
	@Test
	public void testaddPoffer() {
		
	}
	
	@Test
	public void testviewPoffer() {
		
	}
	
	@Test
	public void testdeletePoffer() {
		
	}
	
	
	public void testAddPurchasesOrder()
	{
		
	}
	
	public void testViewPurchasesOrder()
	{
		
	}
	
	public void testdeletePurchasesOrder()
	{
		
	}
	
	@After
	public void tearDown() throws Exception {
		ft1 = null;
		ft2 = null;
		foodItemList = null;
	}

}
