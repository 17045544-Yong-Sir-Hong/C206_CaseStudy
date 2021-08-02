import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private foodItems ft1;
	private foodItems ft2;
	private ArrayList<foodItems> foodItemList;
	private stall st1;
	private stall st2;
	private ArrayList<stall> stallList;
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

		

		st1 = new stall("Drinks");
		st2 = new stall("Korean Food");
		stallList = new ArrayList<stall>();

		
		
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
		assertEquals("Check that ViewAllstallList", testoutput,allstall);
		
		
		
		
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
		// Ensure that the Selling Price entered must be integer & between 3 to 15
		
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid foodItems arraylist to add to", foodItemList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		foodItemList.add(ft1);
		assertEquals("Check that foodItems arraylist size is 1", 1, foodItemList.size());
		assertSame("Check that foodItems is added", ft1, foodItemList.get(0));
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
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, foodItemList.size());
		
		//test if the expected output string same as the list of fooditems retrieved from the case study
		allFoodItems = C206_CaseStudy.retrieveAllFoodItems(foodItemList);

		testOutput = String.format("%-10s $%-10d\n", "Curry", 3);
		testOutput += String.format("%-10s $%-10d\n", "Soup", 15);
	
		assertEquals("Check that ViewAllFoodItemlist", testOutput, allFoodItems);
		
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
		
	}
	@Test
	public void testViewPurchasesOrder()
	{
		
	}
	@Test
	public void testdeletePurchasesOrder()
	{
		
	}
	
	@After
	public void tearDown() throws Exception {
		st1=null;
		st2=null;
		ft1 = null;
		ft2 = null;
		stallList=null;
		foodItemList = null;
	}

}
