import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private foodItems ft1;
	private foodItems ft2;
	private ArrayList<foodItems> foodItemList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		ft1 = new foodItems("Curry", 3);
		ft2 = new foodItems("Soup", 15);
		
		foodItemList = new ArrayList<foodItems>();
	}



	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void testAddFoodItems() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid foodItems arraylist to add to", foodItemList);
		
		// Ensure that the Selling Price entered must be integer & between 3 to 15
		
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addFoodItems(foodItemList);
		assertEquals("Check that foodItems arraylist size is 1", 1, foodItemList.size());
		assertSame("Check that foodItems is added", ft1, foodItemList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addFoodItems(foodItemList);
		assertEquals("Check that foodItems arraylist size is 2", 2, foodItemList.size());
		assertSame("Check that foodItems is added", ft2, foodItemList.get(1));
	}
	
	@Test
	public void testViewFoodItems() {
		
	}
	
	@Test
	public void testDeleteFoodItems() {
		
	}
	
	@After
	public void tearDown() throws Exception {
		ft1 = null;
		ft2 = null;
		foodItemList = null;
	}

}
