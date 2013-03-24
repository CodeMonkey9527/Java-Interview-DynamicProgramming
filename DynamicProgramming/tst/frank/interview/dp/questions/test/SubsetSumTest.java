package frank.interview.dp.questions.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import frank.interview.dp.questions.SubsetSum;

public class SubsetSumTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFind() {
		System.out.println("------Test 1------");
		int [] array = {1, 2, 4, 8, 16, 32};
		for (int num=0; num<64; num++) {
			List<Integer> subset = SubsetSum.find(array, num);
			assertNotNull(subset);
			int sum = 0; 
			for (Integer i : subset) {
				sum += i;
			}
			assertEquals(num, sum);
		}
		for (int num=64; num<70; num++) {
			assertNull(SubsetSum.find(array, num));
		}
	}

	@Test
	public void testFind2() {
		System.out.println("------Test 2------");
		int [] array = {1, 3, 5, 7, 9};
		for (int num = 0; num < 30; num++) {
			SubsetSum.find(array, num);
		}
	}
	
	@Test
	public void testFind3() {
		System.out.println("------Test 3------");
		int [] array = {1, 2, 3, 4, 5, 6, 7};
		for (int num = 0; num < 40; num++) {
			SubsetSum.find(array, num);
		}
	}
}
