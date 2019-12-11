package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import suduko.Suduko;

public class TestSuduko {

	Suduko suduko;
	
	@Before
	public void setUp() throws Exception {
		suduko = new Suduko();
	}

	@After
	public void tearDown() throws Exception {
		suduko = null;
	}

	@Test
	public void testEmptySuduko() {
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
				int test = suduko.getValueOfIndex(i, j);				
				assertSame("Object at index " + i + " " + j + " is not 0", 0, test);										
				
			}
		}
	}
	
	@Test
	public void testTestcaseSuduko() {
		
		suduko.setValueOfIndex(0, 2, 8);
		suduko.setValueOfIndex(0, 5, 9);
		suduko.setValueOfIndex(0, 7, 6);
		suduko.setValueOfIndex(0, 8, 2);
		suduko.setValueOfIndex(1, 8, 5);
		suduko.setValueOfIndex(2, 0, 1);
		suduko.setValueOfIndex(2, 2, 2);
		suduko.setValueOfIndex(2, 3, 5);
		suduko.setValueOfIndex(3, 3, 2);
		suduko.setValueOfIndex(3, 4, 1);
		suduko.setValueOfIndex(3, 7, 9);
		suduko.setValueOfIndex(4, 1, 5);
		suduko.setValueOfIndex(4, 6, 6);
		suduko.setValueOfIndex(5, 0, 6);
		suduko.setValueOfIndex(5, 7, 2);
		suduko.setValueOfIndex(5, 8, 8);
		suduko.setValueOfIndex(8, 6, 4);
		suduko.setValueOfIndex(7, 6, 1);
		suduko.setValueOfIndex(7, 4, 3);
		suduko.setValueOfIndex(7, 1, 6);
		suduko.setValueOfIndex(7, 0, 8);
		suduko.setValueOfIndex(6, 0, 4);
		suduko.setValueOfIndex(6, 1, 1);
		suduko.setValueOfIndex(6, 3, 6);
		suduko.setValueOfIndex(6, 5, 8);
		
		assertTrue("Solve returns the wrong value", suduko.solve());
		suduko.print();
		
	}
	
	@Test
	public void testUnsolvableSuduko() {

		suduko.setValueOfIndex(0, 0, 1);
		suduko.setValueOfIndex(0, 1, 2);
		suduko.setValueOfIndex(0, 2, 3);
		suduko.setValueOfIndex(1, 0, 4);
		suduko.setValueOfIndex(1, 1, 5);
		suduko.setValueOfIndex(1, 2, 6);
		suduko.setValueOfIndex(2, 3, 7);
		assertFalse("Solve returns the wrong value", suduko.solve());
		suduko.clear();

		// test cluster
		suduko.setValueOfIndex(0, 0, 1);
		suduko.setValueOfIndex(1, 1, 1);
		assertFalse("Solve returns the wrong value", suduko.solve());
		suduko.clear();

		// test row
		suduko.setValueOfIndex(0, 0, 1);
		suduko.setValueOfIndex(0, 1, 1);
		assertFalse("Solve returns the wrong value", suduko.solve());
		suduko.clear();

		// test col
		suduko.setValueOfIndex(0, 0, 1);
		suduko.setValueOfIndex(1, 0, 1);
		assertFalse("Solve returns the wrong value", suduko.solve());
		suduko.clear();
	}


}
