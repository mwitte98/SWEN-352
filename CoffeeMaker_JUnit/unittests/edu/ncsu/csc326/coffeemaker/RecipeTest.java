package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;

public class RecipeTest extends TestCase {
	private Recipe r1;
	private Recipe r2;
	
	protected void setUp() throws Exception {
		r1 = new Recipe();
		r2 = new Recipe();
		
		super.setUp();
	}

	protected void tearDown() throws Exception {
		r1 = null;
		r2 = null;
		
		super.tearDown();
	}

	public void testGetChocolate() {
		assertEquals(0, r1.getAmtChocolate());
	}

	public void testSetAmtChocolateNaN() {
		try {
			r1.setAmtChocolate("NaN");
			fail("RecipeException should be thrown");
		} catch (RecipeException e) {
			assertEquals("Units of chocolate must be a positive integer", e.getMessage());
		}
	}

	public void testSetAmtChocolateNegative() {
		try {
			r1.setAmtChocolate("-1");
			fail("RecipeException should be thrown");
		} catch (RecipeException e) {
			assertEquals("Units of chocolate must be a positive integer", e.getMessage());
		}
	}

	public void testSetAmtChocolateZero() {
		try {
			r1.setAmtChocolate("0");
			assertEquals(0, r1.getAmtChocolate());
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
	}

	public void testSetAmtChocolatePositive() {
		try {
			r1.setAmtChocolate("1");
			assertEquals(1, r1.getAmtChocolate());
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
	}

	public void testGetCoffee() {
		assertEquals(0, r1.getAmtCoffee());
	}

	public void testSetAmtCoffeeNaN() {
		try {
			r1.setAmtCoffee("NaN");
			fail("RecipeException should be thrown");
		} catch (RecipeException e) {
			assertEquals("Units of coffee must be a positive integer", e.getMessage());
		}
	}

	public void testSetAmtCoffeeNegative() {
		try {
			r1.setAmtCoffee("-1");
			fail("RecipeException should be thrown");
		} catch (RecipeException e) {
			assertEquals("Units of coffee must be a positive integer", e.getMessage());
		}
	}

	public void testSetAmtCoffeeZero() {
		try {
			r1.setAmtCoffee("0");
			assertEquals(0, r1.getAmtCoffee());
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
	}

	public void testSetAmtCoffeePositive() {
		try {
			r1.setAmtCoffee("1");
			assertEquals(1, r1.getAmtCoffee());
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
	}

	public void testGetMilk() {
		assertEquals(0, r1.getAmtMilk());
	}

	public void testSetAmtMilkNaN() {
		try {
			r1.setAmtMilk("NaN");
			fail("RecipeException should be thrown");
		} catch (RecipeException e) {
			assertEquals("Units of milk must be a positive integer", e.getMessage());
		}
	}

	public void testSetAmtMilkNegative() {
		try {
			r1.setAmtMilk("-1");
			fail("RecipeException should be thrown");
		} catch (RecipeException e) {
			assertEquals("Units of milk must be a positive integer", e.getMessage());
		}
	}

	public void testSetAmtMilkZero() {
		try {
			r1.setAmtMilk("0");
			assertEquals(0, r1.getAmtMilk());
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
	}

	public void testSetAmtMilkPositive() {
		try {
			r1.setAmtMilk("1");
			assertEquals(1, r1.getAmtMilk());
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
	}

	public void testGetSugar() {
		assertEquals(0, r1.getAmtSugar());
	}

	public void testSetAmtSugarNaN() {
		try {
			r1.setAmtSugar("NaN");
			fail("RecipeException should be thrown");
		} catch (RecipeException e) {
			assertEquals("Units of sugar must be a positive integer", e.getMessage());
		}
	}

	public void testSetAmtSugarNegative() {
		try {
			r1.setAmtSugar("-1");
			fail("RecipeException should be thrown");
		} catch (RecipeException e) {
			assertEquals("Units of sugar must be a positive integer", e.getMessage());
		}
	}

	public void testSetAmtSugarZero() {
		try {
			r1.setAmtSugar("0");
			assertEquals(0, r1.getAmtSugar());
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
	}

	public void testSetAmtSugarPositive() {
		try {
			r1.setAmtSugar("1");
			assertEquals(1, r1.getAmtSugar());
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
	}
	
	public void testGetName() {
		assertNull(r1.getName());
	}
	
	public void testSetNameNull() {
		r1.setName("");
		assertEquals("", r1.getName());
	}
	
	public void testSetNameValid(){
		r1.setName("foo");
		assertEquals("foo", r1.getName());
	}

	public void testGetPrice() {
		assertEquals(0, r1.getPrice());
	}

	public void testSetPriceNaN() {
		try {
			r1.setPrice("NaN");
			fail("RecipeException should be thrown");
		} catch (RecipeException e) {
			assertEquals("Price must be a positive integer", e.getMessage());
		}
	}

	public void testSetPriceNegative() {
		try {
			r1.setPrice("-1");
			fail("RecipeException should be thrown");
		} catch (RecipeException e) {
			assertEquals("Price must be a positive integer", e.getMessage());
		}
	}

	public void testSetPriceZero() {
		try {
			r1.setPrice("0");
			assertEquals(0, r1.getPrice());
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
	}

	public void testSetPricePositive() {
		try {
			r1.setPrice("1");
			assertEquals(1, r1.getPrice());
		} catch (RecipeException e) {
			fail("RecipeException should not be thrown");
		}
	}

	public void testToString() {
		r1.setName("foo");
		assertEquals("foo", r1.toString());
	}
	
	public void testHashCodeNull() {
		assertEquals(31, r1.hashCode());
	}
	
	public void testHashCodeValue() {
		r1.setName("foo");
		assertEquals(101605, r1.hashCode());
	}

	public void testHashCodesNotEqual() {
		r1.setName("foo");
		r2.setName("bar");

		assertTrue(r1.hashCode() != r2.hashCode());
	}
	
	public void testEqualsSame() {
		assertTrue(r1.equals(r1));
	}
	
	public void testEqualsNull() {
		assertFalse(r1.equals(null));
	}
	
	public void testEqualsDifferentClass() {
		assertFalse(r1.equals("foo"));
	}
	
	public void testEqualsDifferentNames() {
		r1.setName("foo");
		r2.setName("fail");
		assertFalse(r1.equals(r2));
	}
	
	public void testEqualsFirstNameNull() {
		r1.setName("foo");
		assertFalse(r1.equals(r2));
	}
	
	public void testEqualsSecondNameNull() {
		r2.setName("foo");
		assertFalse(r1.equals(r2));
	}
	
	public void testEqualsBothNamesNull() {
		assertTrue(r1.equals(r2));
	}
	
	public void testEqualsSameName() {
		r1.setName("foo");
		r2.setName("foo");
		assertTrue(r1.equals(r2));
	}

}
