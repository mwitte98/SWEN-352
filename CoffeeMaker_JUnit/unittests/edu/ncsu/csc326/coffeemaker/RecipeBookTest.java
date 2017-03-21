package edu.ncsu.csc326.coffeemaker;

import java.util.Arrays;

import junit.framework.TestCase;

public class RecipeBookTest extends TestCase {
	private RecipeBook book;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;
	private Recipe r5;

	protected void setUp() throws Exception {
		book = new RecipeBook();
		r1 = new Recipe();
		r1.setName("1");
		r2 = new Recipe();
		r2.setName("2");
		r3 = new Recipe();
		r3.setName("3");
		r4 = new Recipe();
		r4.setName("4");
		r5 = new Recipe();
		r5.setName("5");
		
		super.setUp();
	}

	protected void tearDown() throws Exception {
		book = null;
		
		super.tearDown();
	}
	
	public void testGetRecipes() {
		assertTrue(Arrays.equals(new Recipe[4], book.getRecipes()));
	}
	
	public void testAddRecipe() {
		assertTrue(book.addRecipe(r1));
	}

	public void testAddRecipeDuplicate() {
		book.addRecipe(r1);
		assertFalse(book.addRecipe(r1));
	}
	
	public void testAddRecipeOverflow() {
		book.addRecipe(r1);
		book.addRecipe(r2);
		book.addRecipe(r3);
		book.addRecipe(r4);
		assertFalse(book.addRecipe(r5));
	}
	
	public void testDeleteRecipeDoesNotExist() {
		assertNull(book.deleteRecipe(3));
	}
	
	public void testDeleteDecipeArrayOutOfBounds() {
		assertNull(book.deleteRecipe(100));
	}

	public void testDeleteRecipePresent() {
		r1.setName("1");
		book.addRecipe(r1);
		assertEquals("1", book.deleteRecipe(0));
	}
	
	public void testAddRecipeAfterDelete() {
		book.addRecipe(r1);
		book.addRecipe(r2);
		book.addRecipe(r3);
		book.addRecipe(r4);
		book.deleteRecipe(0);
		assertTrue(book.addRecipe(r5));
	}

	public void testEditRecipeDoesNotExist() {
		assertNull(book.editRecipe(0, r1));
	}
	
	public void testEditRecipeArrayOutOfBounds() {
		assertNull(book.editRecipe(100, new Recipe()));
	}

	public void testEditRecipeReturnsOldRecipeName() {
		book.addRecipe(r1);
		assertEquals("1", book.editRecipe(0, r2));
	}

	public void testEditRecipeSetsNewRecipeName() {
		book.addRecipe(r1);
		book.editRecipe(0, r2);
		assertEquals("2", book.getRecipes()[0].getName());
	}

}
