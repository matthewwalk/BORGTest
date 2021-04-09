package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import net.sf.borg.common.*;

import static org.junit.Assert.assertEquals;

import java.util.Date;

/**
 * <p> This class tests the dayOfEpoch method in the DateUtil class of the BORGCalendar project. </p>
 * 
 * <p> It utilizes bounday and equivalence testing in order to determine the correctness of the method. </p>
 * 
 * <p> Additionally, 100% coverage is achieved. </p>
 * 
 * @author Allen Kaplan (214494928), Jamie Dishy (212904041), Akinloluwa Adewale (215238231), Matthew Walker (214779300)
 * @version 2.0
 */
public class DayOfEpochTests {
	
	//EXPECTED BOUNDARY TEST RESULTS
	private final long EXPECTED_BOUNDARY_TEST_1 = 622191234;
	private final long EXPECTED_BOUNDARY_TEST_2 = -622191234;
	private final long EXPECTED_BOUNDARY_TEST_3 = 622191233;
	private final long EXPECTED_BOUNDARY_TEST_4 = -622191233;
	
	//EXPECTED EQUIVALENCE TEST RESULTS
	private final long EXPECTED_EQUIVALENCE_TEST_1 = 9;
	private final long EXPECTED_EQUIVALENCE_TEST_2 = 99;
	private final long EXPECTED_EQUIVALENCE_TEST_3 = 999;
	private final long EXPECTED_EQUIVALENCE_TEST_4 = -10;
	private final long EXPECTED_EQUIVALENCE_TEST_5 = 0;
	private final long EXPECTED_EQUIVALENCE_TEST_6 = -1;
	private final long EXPECTED_EQUIVALENCE_TEST_7 = 0;
	
	//TEST NAMES FOR BOUNDARY TESTS
	private final String boundaryTest1 = "Boundry Test: Long.MAX_VALUE ";
	private final String boundaryTest2 = "Boundry Test: Long.MIN_VALUE ";
	private final String boundaryTest3 = "Boundary Test: Long.MAX_VALUE - 86400000L ";
	private final String boundaryTest4 = "Boundary Test: Long.MIN_VALUE + 86400000L ";
	
	//TEST NAMES FOR EQUIVALENCE TESTS
	private final String equivalenceTest1 = "Equivalence Test: (Date) 86400000*10 === 9 ";
	private final String equivalenceTest2 = "Equivalence Test: (Date) 86400000*100 === 99 ";
	private final String equivalenceTest3 = "Equivalence Test: (Date) 86400000*1000 === 999 ";
	private final String equivalenceTest4 = "Equivalence Test: (Date) 86400000*-10 === -10 ";
	private final String equivalenceTest5 = "Equivalence Test: (Date) 0 === 0 ";
	private final String equivalenceTest6 = "Equivalence Test: (Date) -86400000 === -1 ";
	private final String equivalenceTest7 = "Equivalence Test: (Date) 86400000 === 0 ";
	
	/**
	 * <p>Test Case: IA1</p> 
	 * <p>Date d1: Long.MAX_VALUE</p> 
	 * <p>Expected Output: 622191234</p> 
	 */
	@Test
	@DisplayName(boundaryTest1)
	public void BoundryTest1() {
		Date d1 = new Date(Long.MAX_VALUE);
		System.out.println(boundaryTest1 + "\t" + d1.getTime());
		assertEquals(EXPECTED_BOUNDARY_TEST_1, DateUtil.dayOfEpoch(d1));
	}

	/**
	 * <p>Test Case: IA2</p> 
	 * <p>Date d1: Long.MIN_VALUE</p> 
	 * <p>Expected Output: &#45;622191233</p> 
	 */
	@Test
	@DisplayName(boundaryTest2)
	public void BoundryTest2() {
		Date d1 = new Date(Long.MIN_VALUE);
		System.out.println(boundaryTest2 + "\t" + d1.getTime());
		assertEquals(EXPECTED_BOUNDARY_TEST_2, DateUtil.dayOfEpoch(d1));
	}

	/**
	 * <p>Test Case: IA3</p> 
	 * <p>Date d1: Long.MAX_VALUE &#45; 86400000</p> 
	 * <p>Expected Output: 622191233</p> 
	 */
	@Test
	@DisplayName(boundaryTest3)
	public void BoundaryTest3() { 
		Date d1 = new Date(Long.MAX_VALUE - 86400000L);
		System.out.println(boundaryTest3 + "\t" + d1.getTime());
		assertEquals(EXPECTED_BOUNDARY_TEST_3, DateUtil.dayOfEpoch(d1));
	}

	/**
	 * <p>Test Case: IA4</p> 
	 * <p>Date d1: Long.MIN_VALUE + 86400000</p> 
	 * <p>Expected Output: &#45;622191234</p> 
	 */
	@Test
	@DisplayName(boundaryTest4)
	public void BoundaryTest4() { //
		Date d1 = new Date(Long.MIN_VALUE + 86400000L);
		System.out.println(boundaryTest4 + "\t" + d1.getTime());
		assertEquals(EXPECTED_BOUNDARY_TEST_4, DateUtil.dayOfEpoch(d1));
	}

	/**
	 * <p>Test Case: IA5</p> 
	 * <p>Date d1: 86400000 * 10</p> 
	 * <p>Expected Output: 9</p> 
	 */
	@Test
	@DisplayName(equivalenceTest1)
	public void EquivalenceTest1() {
		Date d1 = new Date(86400000 * 10);
		System.out.println(equivalenceTest1 + "\t" + d1);
		assertEquals(EXPECTED_EQUIVALENCE_TEST_1, DateUtil.dayOfEpoch(d1));
	}

	/**
	 * <p>Test Case: IA6</p> 
	 * <p>Date d1: 86400000 * 100</p> 
	 * <p>Expected Output: 99</p> 
	 */
	@Test
	@DisplayName(equivalenceTest2)
	public void EquivalenceTest2() {
		Date d1 = new Date(8640000000L); // 86400000 * 100
		System.out.println(equivalenceTest2 + "\t" + d1);
		assertEquals(EXPECTED_EQUIVALENCE_TEST_2, DateUtil.dayOfEpoch(d1));
	}

	/**
	 * <p>Test Case: IA7</p> 
	 * <p>Date d1: 86400000 * 1000</p> 
	 * <p>Expected Output: 999</p> 
	 */
	@Test
	@DisplayName(equivalenceTest3)
	public void EquivalenceTest3() {
		Date d1 = new Date(86400000000L); // 86400000 * 1000
		System.out.println(equivalenceTest3 + "\t" + d1);
		assertEquals(EXPECTED_EQUIVALENCE_TEST_3, DateUtil.dayOfEpoch(d1));
	}

	/**
	 * <p>Test Case: IA8</p> 
	 * <p>Date d1: 86400000 * &#45;10</p> 
	 * <p>Expected Output: &#45;10</p> 
	 */
	@Test
	@DisplayName(equivalenceTest4)
	public void EquivalenceTest4() {
		Date d1 = new Date(86400000 * -10);
		System.out.println(equivalenceTest4 + "\t" + d1);
		assertEquals(EXPECTED_EQUIVALENCE_TEST_4, DateUtil.dayOfEpoch(d1));
	}

	/**
	 * <p>Test Case: IA9</p> 
	 * <p>Date d1: 86400000 * 0</p> 
	 * <p>Expected Output: 0</p> 
	 */
	@Test
	@DisplayName(equivalenceTest5)
	public void EquivalenceTest5() {
		Date d1 = new Date(0); // d1 = Wed Dec 31 19:00:00 EST 1969
		System.out.println(equivalenceTest5 + "\t" + d1);
		assertEquals(EXPECTED_EQUIVALENCE_TEST_5, DateUtil.dayOfEpoch(d1));
	}

	/**
	 * <p>Test Case: IA10</p> 
	 * <p>Date d1: &#45;86400000</p> 
	 * <p>Expected Output: &#45;1</p> 
	 */
	@Test
	@DisplayName(equivalenceTest6)
	public void EquivalenceTest6() {
		Date d1 = new Date(-86400000); // d1 = Tue Dec 30 19:00:00 EST 1969
		System.out.println(equivalenceTest6 + "\t" + d1);
		assertEquals(EXPECTED_EQUIVALENCE_TEST_6, DateUtil.dayOfEpoch(d1));
	}

	/**
	 * <p>Test Case: IA11</p> 
	 * <p>Date d1: 86400000</p> 
	 * <p>Expected Output: 0</p> 
	 */
	@Test
	@DisplayName(equivalenceTest7)
	public void EquivalenceTest7() { // d1 = Thu Jan 01 19:00:00 EST 1970
		Date d1 = new Date(86400000);
		System.out.println(equivalenceTest7 + "\t" + d1);
		assertEquals(EXPECTED_EQUIVALENCE_TEST_7, DateUtil.dayOfEpoch(d1));
	}

}