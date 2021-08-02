import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private foodItems ft1;
	private foodItems ft2;
	private ArrayList<foodItems> foodItemList;
	private ArrayList<stall> stallList;
	private Poffer po1;
	private Poffer po2;
	private ArrayList<Poffer> PofferList;
	
	private ArrayList<PurchaseOrders> PurchaseOrdersList;
	private PurchaseOrders purchaseOrder1;
	private PurchaseOrders purchaseOrder2;
	private PurchaseOrders purchaseOrder3;
	
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		ft1 = new foodItems("Curry", 3);
		ft2 = new foodItems("Soup", 10);
		
		foodItemList = new ArrayList<foodItems>();

		stallList = new ArrayList<stall>();

		

		
		
		
		purchaseOrder1 = new PurchaseOrders("Test1", "Eggs", 20);
		purchaseOrder2 = new PurchaseOrders("Test2", "Rice", 20);
		purchaseOrder3 = new PurchaseOrders("Test2", "Meat", -2);
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
	public void testaddNewStall() {
		
	}
	@Test
	public void testviewStall() {
		
	}
	public void testdeleteStall() {
		
	}
	
	
	@Test 
	 public void testAddFoodItems() { 
		
	  // Item list is not null, so that can add a new item - boundary 
	  assertNotNull("Check if there is valid foodItems arraylist to add to", foodItemList); 

	  // boundary
	  foodItemList.add(ft1); 
	  // Selling Price entered is 3 (integer) - boundary
	  assertEquals("Check that new foodItems selling price is between $3 to $15", 3, ft1.getSellingPrice());
	  //Given an empty list, after adding 1 item, the size of the list is 1 - normal 
	  assertEquals("Check that foodItems arraylist size is 1", 1, foodItemList.size()); 
	  //The item just added is the same as the first item of the list 
	  assertSame("Check that foodItems is added", ft1, foodItemList.get(0)); 
	  
	  // normal 
	  foodItemList.add(ft2); 
	  // Selling Price entered is 10 (integer) - normal
	  assertEquals("Check that new foodItems selling price is between $3 to $15", 10, ft2.getSellingPrice());
	  //Add another item. test The size of the list is 2?
	  assertEquals("Check that foodItems arraylist size is 2", 2, foodItemList.size());
	  //The item just added is the same as the second item of the list 
	  assertSame("Check that foodItems is added", ft2, foodItemList.get(1)); 
	  
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
		foodItemList.add(ft1);
		foodItemList.add(ft2);
		assertEquals("Test if that foodItems arraylist size is 2?", 2, foodItemList.size());
		
		//test if the expected output string same as the list of fooditems retrieved from the case study
		allFoodItems = C206_CaseStudy.retrieveAllFoodItems(foodItemList);

		testOutput = String.format("%-10s $%-10d\n", "Curry", 3);
		testOutput += String.format("%-10s $%-10d\n", "Soup", 10);
	
		assertEquals("Check that ViewAllFoodItemlist", testOutput, allFoodItems);
		
	}
	
	@Test
	public void testDeleteFoodItems() {
		
		  // Item list is not null, so that can add a new item - boundary 
		  assertNotNull("Check if there is valid foodItems arraylist to add to", foodItemList); 

		  // boundary
		  foodItemList.add(ft1); 
		  // Selling Price entered is 3 (integer) - boundary
		  assertEquals("Check that new foodItems selling price is between $3 to $15", 3, ft1.getSellingPrice());
		  //Given an empty list, after adding 1 item, the size of the list is 1 - normal 
		  assertEquals("Check that foodItems arraylist size is 1", 1, foodItemList.size()); 
		  //The item just added is the same as the first item of the list 
		  assertSame("Check that foodItems is added", ft1, foodItemList.get(0)); 
		  
		  // normal 
		  foodItemList.add(ft2); 
		  // Selling Price entered is 10 (integer) - normal
		  assertEquals("Check that new foodItems selling price is between $3 to $15", 10, ft2.getSellingPrice());
		  //Add another item. Test the size of the list is 2?
		  assertEquals("Check that foodItems arraylist size is 2", 2, foodItemList.size());
		  //The item just added is the same as the second item of the list 
		  assertSame("Check that foodItems is added", ft2, foodItemList.get(1)); 
		  
		  // Remove the last row food item in the arraylist
		  foodItemList.remove(1);
		  // after removing, the size of the list is 1 
		  assertEquals("Check that foodItems arraylist size is 1", 1, foodItemList.size()); 
		  // Remove the second last row food item in the arraylist
		  foodItemList.remove(0);
		  // after removing, the size of the list is 0 (empty)
		  assertEquals("Check that foodItems arraylist size is 0", 0, foodItemList.size()); 
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
	
	@Test
	public void testAddPurchasesOrder()
	{
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid PurchasesOrder arraylist to add to", PurchaseOrdersList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		PurchaseOrdersList.add(purchaseOrder1);
		assertEquals("Check that PurchaseOrder arraylist size is 1", 1, PurchaseOrdersList.size());
		assertSame("Check that PurchaseOrder is added", purchaseOrder1, PurchaseOrdersList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		PurchaseOrdersList.add(purchaseOrder2);
		assertEquals("Check that PurchaseOrder arraylist size is 2", 2, PurchaseOrdersList.size());
		assertSame("Check that PurchaseOrder is added", purchaseOrder2, PurchaseOrdersList.get(1));
		
		//Add another item. test The size of the list is 2? -error
		//The item just added is as same as the second item of the list
		PurchaseOrdersList.add(purchaseOrder3);
		assertEquals("Check that PurchaseOrder arraylist size is 3", 3, PurchaseOrdersList.size());
		assertSame("Check that PurchaseOrder is added", purchaseOrder3, PurchaseOrdersList.get(2));
		
	}
	
	@Test
	public void testViewPurchasesOrder()
	{
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		PurchaseOrdersList.add(purchaseOrder1);
		assertEquals("Check that PurchaseOrder arraylist size is 1", 1, PurchaseOrdersList.size());
		assertSame("Check that PurchaseOrder is added", purchaseOrder1, PurchaseOrdersList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		PurchaseOrdersList.add(purchaseOrder2);
		assertEquals("Check that PurchaseOrder arraylist size is 2", 2, PurchaseOrdersList.size());
		assertSame("Check that PurchaseOrder is added", purchaseOrder2, PurchaseOrdersList.get(1));
		
		//Test PurchaseOrdersList can view purchases order
		C206_CaseStudy.ViewPurchasesOrder(PurchaseOrdersList);
	}
	
	@Test
	public void testdeletePurchasesOrder()
	{
		PurchaseOrdersList.add(purchaseOrder1);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		assertEquals("Check that PurchaseOrder arraylist size is 1", 1, PurchaseOrdersList.size());
		assertSame("Check that PurchaseOrder is added", purchaseOrder1, PurchaseOrdersList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		PurchaseOrdersList.add(purchaseOrder2);
		assertEquals("Check that PurchaseOrder arraylist size is 2", 2, PurchaseOrdersList.size());
		assertSame("Check that PurchaseOrder is added", purchaseOrder2, PurchaseOrdersList.get(1));
		
		//Delete item from PurchaseOrdersList. test The size of the list is 1? -normal
		PurchaseOrdersList.remove(1);
		assertEquals("Check that PurchaseOrder arraylist size is 1", 1, PurchaseOrdersList.size());
		
		//Delete item from PurchaseOrdersList. test The size of the list is 0? -normal
		PurchaseOrdersList.remove(0);
		assertEquals("Check that PurchaseOrder arraylist size is 1", 0, PurchaseOrdersList.size());
		
	}
	
	@After
	public void tearDown() throws Exception {
		ft1 = null;
		ft2 = null;
		foodItemList = null;
		purchaseOrder1 = null;
		purchaseOrder2 = null;
		purchaseOrder3 = null;
		
	}

}



