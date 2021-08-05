import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private foodItems ft1;
	private foodItems ft2;
	private foodItems ft3;
	private ArrayList<foodItems> foodItemList;
	private stall st1;
	private stall st2;
	private ArrayList<stall> stallList;
	private Poffer po1;
	private Poffer po2;
	private Poffer po3;
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
		ft3 = new foodItems("Cake", 20);
		
		foodItemList = new ArrayList<foodItems>();

		

		st1 = new stall("Drinks");
		st2 = new stall("Korean Food");
		stallList = new ArrayList<stall>();

		
		
		purchaseOrder1 = new PurchaseOrders("Test1", "Eggs", 20);
		purchaseOrder2 = new PurchaseOrders("Test2", "Rice", 20);
		purchaseOrder3 = new PurchaseOrders("Test2", "Meat", -2);
		PurchaseOrdersList= new ArrayList<PurchaseOrders>();

		po1 = new Poffer("Chicken", 3, "Chicken");
		po2 = new Poffer("Duck", 6, "Duck");
		po3 = new Poffer("Chicken rice", 4, "Chicken");
		PofferList = new ArrayList<Poffer>();
		
	}



	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	@Test
	public void testaddNewStall() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Stall arraylist to add to", stallList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		stallList.add(st1);	
		assertEquals("Test if that stall arraylist size is 1?", 1, stallList.size());
		assertSame("Check that stall is added", st1, stallList.get(0));
		
		stallList.add(st2);	
		assertEquals("Test if that stall arraylist size is 2?", 2, stallList.size());
		assertSame("Check that stall is added", st2, stallList.get(1));
		
		
	
		
		
	}
	@Test
	public void testRetrieveAllStall() {
		assertNotNull("Test if there is valid stall arraylist to add to", stallList);
		String allstall = C206_CaseStudy.retrieveAllstall(stallList);
		String testoutput="";
		assertEquals("Check that ViewAllstallList", testoutput,allstall);
		
		stallList.add(st1);
		stallList.add(st2);
		assertEquals("Test if that stall arraylist size is 2?" , 2, stallList.size());
		
		allstall = C206_CaseStudy.retrieveAllstall(stallList);
		
		testoutput = String.format("%-10s ", "drinks");
		testoutput += String.format("%-10s", "Korean Food");
		
		C206_CaseStudy.viewAllstall(stallList);
		
		
		
		
	}
	public void testdeleteStall() {
		stallList.add(st1);	
		assertEquals("Test if that stall arraylist size is 1?", 1, stallList.size());
		assertSame("Check that stall is added", st1, stallList.get(0));
		
		stallList.add(st2);	
		assertEquals("Test if that stall arraylist size is 2?", 2, stallList.size());
		assertSame("Check that stall is added", st2, stallList.get(1));
		
		stallList.remove(1);
		assertEquals("Test if that stall arraylist size is 1?", 1, stallList.size());
		stallList.remove(0);
		assertEquals("Test if that stall arraylist size is 0?", 0, stallList.size());
		
		
		
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
	  
	  // error
	  // Selling Price entered is 20 (integer) - error
	  assertEquals("Check that new foodItems selling price is between $3 to $15", 20, ft3.getSellingPrice());
	  //Do not add this item. test The size of the list is 2 (remain the same)?
	  assertEquals("Check that foodItems arraylist size is 2", 2, foodItemList.size());
	  
	  //Test to ensure that all food items are successfully added into foodItemList
	  C206_CaseStudy.viewAllFoodItems(foodItemList);
	  
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
		
		//Test to check if able to view food items in foodItemList
		C206_CaseStudy.viewAllFoodItems(foodItemList);
		
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
		  
		  //Test to see and ensure that foodItemList is empty
		  C206_CaseStudy.viewAllFoodItems(foodItemList);
			
	}
	
	@Test
	public void testaddPoffer() {
		  // Item list is not null, so that can add a new item - boundary 
		  assertNotNull("Check if there is valid foodItems arraylist to add to", PofferList); 

		  // normal
		  PofferList.add(po1); 
		  // no duplicate stall name in the array - normal
		  assertEquals("check if there is no duplicate stall name in the array list", "Chicken", po1.getStallName());
		  assertNotEquals("check if there is no duplicate stall name in the array list", "Chicken", po2.getStallName());
		  //Given an empty list, after adding 1 item, the size of the list is 1 - normal 
		  assertEquals("Check that foodItems arraylist size is 1", 1, PofferList.size()); 
		  //The item just added is the same as the first item of the list 
		  assertSame("Check that foodItems is added", po1, PofferList.get(0)); 
		  
		  // normal 
		  PofferList.add(po2); 
		  // no duplicate stall name in the array - normal
		  assertEquals("check if there is no duplicate stall name in the array list", "Duck", po2.getStallName());
		  assertNotEquals("check if there is no duplicate stall name in the array list", "Duck", po1.getStallName());
		  //Add another item. test The size of the list is 2?
		  assertEquals("Check that foodItems arraylist size is 2", 2, PofferList.size());
		  //The item just added is the same as the second item of the list 
		  assertSame("Check that foodItems is added", po2, PofferList.get(1)); 
		  
		  // error 
		  PofferList.add(po3); 
		  // test if there is duplicate stall name in the array - error
		  assertEquals("check if there is no duplicate stall name in the array list", po1.getStallName(), po3.getStallName());
		  //Add another item. test The size of the list is 3?
		  assertEquals("Check that foodItems arraylist size is 3", 3, PofferList.size());
		  //The item just added is the same as the third item of the list 
		  assertSame("Check that foodItems is added", po3, PofferList.get(2)); 
	}
	
	@Test
	public void testretrieveAllPoffer() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Promotion offer arraylist to add to", PofferList); 
		
		//test if the list of Promotion offer retrieved from the case study is empty
		String allPoffer= C206_CaseStudy.retrieveAllPoffer(PofferList); 
		String testOutput = "";
		assertEquals("Check that ViewAllPofferlist", testOutput, allPoffer); 
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		PofferList.add(po1);
		PofferList.add(po2);
		assertEquals("Test if that Promotion offer arraylist size is 2?", 2, PofferList.size());
		
		//test if the expected output string same as the list of Promotion offer retrieved from the case study
		allPoffer= C206_CaseStudy.retrieveAllPoffer(PofferList);

		testOutput = String.format("%-10s $%-19d %-10s\n", "Chicken", 3, "Chicken");
		testOutput += String.format("%-10s $%-19d %-10s\n", "Duck", 6, "Duck");
	
		assertEquals("Check that ViewAllPofferlist", testOutput, allPoffer);
		
	}
	
	@Test
	public void testdeletePoffer() {
		PofferList.add(po1);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		assertEquals("Check that Promotion Offer arraylist size is 1", 1, PofferList.size());
		assertSame("Check that Promotion Offer is added", po1, PofferList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		PofferList.add(po2);
		assertEquals("Check that Promotion Offer arraylist size is 2", 2, PofferList.size());
		assertSame("Check that Promotion Offer is added", po2, PofferList.get(1));
		
		//Delete item from Promotion Offer List. test The size of the list is 1? -normal
		PofferList.remove(1);
		assertEquals("Check that Promotion Offer arraylist size is 1", 1, PofferList.size());
		
		//Delete item from Promotion Offer List. test The size of the list is 0? -normal
		PofferList.remove(0);
		assertEquals("Check that Promotion Offer arraylist size is 0", 0, PofferList.size());
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
		st1=null;
		st2=null;
		ft1 = null;
		ft2 = null;
		ft3 = null;
		stallList=null;
		foodItemList = null;
		purchaseOrder1 = null;
		purchaseOrder2 = null;
		purchaseOrder3 = null;
		po1 = null;
		po2 = null;
		po3 = null;
	
	}

}




