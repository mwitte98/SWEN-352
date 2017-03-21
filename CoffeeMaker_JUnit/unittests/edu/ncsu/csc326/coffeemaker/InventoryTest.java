package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class InventoryTest extends TestCase {
	private Inventory inventory;
	private Recipe recipe;

	protected void setUp() throws Exception {
		inventory = new Inventory();
		recipe = new Recipe();
		
		super.setUp();
	}

	protected void tearDown() throws Exception {
		inventory = null;
		recipe = null;
		
		super.tearDown();
	}
	
	public void testGetChocolate() {
		assertEquals(15, inventory.getChocolate());
	}

	public void testSetChocolateNegative() {
		inventory.setChocolate(-1);
		assertEquals(15, inventory.getChocolate());
	}

	public void testSetChocolateZero() {
		inventory.setChocolate(0);
		assertEquals(0, inventory.getChocolate());
	}

	public void testSetChocolatePositive() {
		inventory.setChocolate(1);
		assertEquals(1, inventory.getChocolate());
	}

	public void testAddChocolateNaN() {
		try {
			inventory.addChocolate("NaN");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			assertEquals("Units of chocolate must be a positive integer", e.getMessage());
		}
	}

	public void testAddChocolateNegative() {
		try {
			inventory.addChocolate("-1");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			assertEquals("Units of chocolate must be a positive integer", e.getMessage());
		}
	}

	public void testAddChocolateZero() {
		try {
			inventory.addChocolate("0");
			assertEquals(15, inventory.getChocolate());
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
	}

	public void testAddChocolatePositive() {
		try {
			inventory.addChocolate("1");
			assertEquals(16, inventory.getChocolate());
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
	}
	
	public void testGetCoffee() {
		assertEquals(15, inventory.getCoffee());
	}

	public void testSetCoffeeNegative() {
		inventory.setCoffee(-1);
		assertEquals(15, inventory.getCoffee());
	}

	public void testSetCoffeeZero() {
		inventory.setCoffee(0);
		assertEquals(0, inventory.getCoffee());
	}

	public void testSetCoffeePositive() {
		inventory.setCoffee(1);
		assertEquals(1, inventory.getCoffee());
	}

	public void testAddCoffeeNaN() {
		try {
			inventory.addCoffee("NaN");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			assertEquals("Units of coffee must be a positive integer", e.getMessage());
		}
	}

	public void testAddCoffeeNegative() {
		try {
			inventory.addCoffee("-1");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			assertEquals("Units of coffee must be a positive integer", e.getMessage());
		}
	}

	public void testAddCoffeeZero() {
		try {
			inventory.addCoffee("0");
			assertEquals(15, inventory.getCoffee());
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
	}

	public void testAddCoffeePositive() {
		try {
			inventory.addCoffee("1");
			assertEquals(16, inventory.getCoffee());
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
	}
	
	public void testGetMilk() {
		assertEquals(15, inventory.getMilk());
	}

	public void testSetMilkNegative() {
		inventory.setMilk(-1);
		assertEquals(15, inventory.getMilk());
	}

	public void testSetMilkZero() {
		inventory.setMilk(0);
		assertEquals(0, inventory.getMilk());
	}

	public void testSetMilkPositive() {
		inventory.setMilk(1);
		assertEquals(1, inventory.getMilk());
	}

	public void testAddMilkNaN() {
		try {
			inventory.addMilk("NaN");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			assertEquals("Units of milk must be a positive integer", e.getMessage());
		}
	}

	public void testAddMilkNegative() {
		try {
			inventory.addMilk("-1");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			assertEquals("Units of milk must be a positive integer", e.getMessage());
		}
	}

	public void testAddMilkZero() {
		try {
			inventory.addMilk("0");
			assertEquals(15, inventory.getMilk());
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
	}

	public void testAddMilkPositive() {
		try {
			inventory.addMilk("1");
			assertEquals(16, inventory.getMilk());
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
	}
	
	public void testGetSugar() {
		assertEquals(15, inventory.getSugar());
	}

	public void testSetSugarNegative() {
		inventory.setSugar(-1);
		assertEquals(15, inventory.getSugar());
	}

	public void testSetSugarZero() {
		inventory.setSugar(0);
		assertEquals(0, inventory.getSugar());
	}

	public void testSetSugarPositive() {
		inventory.setSugar(1);
		assertEquals(1, inventory.getSugar());
	}

	public void testAddSugarNaN() {
		try {
			inventory.addSugar("NaN");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			assertEquals("Units of sugar must be a positive integer", e.getMessage());
		}
	}

	public void testAddSugarNegative() {
		try {
			inventory.addSugar("-1");
			fail("InventoryException should be thrown");
		} catch (InventoryException e) {
			assertEquals("Units of sugar must be a positive integer", e.getMessage());
		}
	}

	public void testAddSugarZero() {
		try {
			inventory.addSugar("0");
			assertEquals(15, inventory.getSugar());
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
	}

	public void testAddSugarPositive() {
		try {
			inventory.addSugar("1");
			assertEquals(16, inventory.getSugar());
		} catch (InventoryException e) {
			fail("InventoryException should not be thrown");
		}
	}
	
	public void testEnoughIngredientsCoffeeNotEnough() {
		try {
			recipe.setAmtCoffee("20");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		assertFalse(inventory.enoughIngredients(recipe));
	}
	
	public void testEnoughIngredientsCoffeeEqual() {
		try {
			recipe.setAmtCoffee("15");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		assertTrue(inventory.enoughIngredients(recipe));
	}
	
	public void testEnoughIngredientsCoffeeEnough() {
		try {
			recipe.setAmtCoffee("10");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		assertTrue(inventory.enoughIngredients(recipe));
	}
	
	public void testEnoughIngredientsMilkNotEnough() {
		try {
			recipe.setAmtMilk("20");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		assertFalse(inventory.enoughIngredients(recipe));
	}
	
	public void testEnoughIngredientsMilkEqual() {
		try {
			recipe.setAmtMilk("15");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		assertTrue(inventory.enoughIngredients(recipe));
	}
	
	public void testEnoughIngredientsMilkEnough() {
		try {
			recipe.setAmtMilk("10");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		assertTrue(inventory.enoughIngredients(recipe));
	}
	
	public void testEnoughIngredientsSugarNotEnough() {
		try {
			recipe.setAmtSugar("20");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		assertFalse(inventory.enoughIngredients(recipe));
	}
	
	public void testEnoughIngredientsSugarEqual() {
		try {
			recipe.setAmtSugar("15");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		assertTrue(inventory.enoughIngredients(recipe));
	}
	
	public void testEnoughIngredientsSugarEnough() {
		try {
			recipe.setAmtSugar("10");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		assertTrue(inventory.enoughIngredients(recipe));
	}
	
	public void testEnoughIngredientsChocolateNotEnough() {
		try {
			recipe.setAmtChocolate("20");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		assertFalse(inventory.enoughIngredients(recipe));
	}
	
	public void testEnoughIngredientsChocolateEqual() {
		try {
			recipe.setAmtChocolate("15");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		assertTrue(inventory.enoughIngredients(recipe));
	}
	
	public void testEnoughIngredientsChocolateEnough() {
		try {
			recipe.setAmtChocolate("10");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		assertTrue(inventory.enoughIngredients(recipe));
	}
	
	public void testUseIngredientsNotEnough() {
		try {
			recipe.setAmtCoffee("20");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		assertFalse(inventory.useIngredients(recipe));
	}
	
	public void testUseIngredientsCoffee() {
		try {
			recipe.setAmtCoffee("10");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		inventory.useIngredients(recipe);
		assertEquals(5, inventory.getCoffee());
	}
	
	public void testUseIngredientsMilk() {
		try {
			recipe.setAmtMilk("10");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		inventory.useIngredients(recipe);
		assertEquals(5, inventory.getMilk());
	}
	
	public void testUseIngredientsSugar() {
		try {
			recipe.setAmtSugar("10");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		inventory.useIngredients(recipe);
		assertEquals(5, inventory.getSugar());
	}
	
	public void testUseIngredientsChocolate() {
		try {
			recipe.setAmtChocolate("10");
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
		inventory.useIngredients(recipe);
		assertEquals(5, inventory.getChocolate());
	}
	
	public void testToString() {
		assertEquals("Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n", inventory.toString());
	}
}
