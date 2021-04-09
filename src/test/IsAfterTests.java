package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import net.sf.borg.common.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

/**
 * <p> This class tests the isAfter method in the DateUtil class of the BORGCalendar project. </p>
 * 
 * <p> It utilizes boundary and equivalence testing as well as decision table testing in order to determine the correctness of the method. </p>
 * 
 * <p> Additionally, 100% coverage is achieved. </p>
 * 
 * @author Allen Kaplan (214494928), Jamie Dishy (212904041), Akinloluwa Adewale (215238231), Matthew Walker (214779300)
 * @version 2.0
 */
public class IsAfterTests {
	//TESTING ATTRIBUTES
	private Date d1, d2;
	
	private final Long ONE_DAY = 86400000L;
	
	//TEST NAMES FOR BOUNDARY TESTS
	private final String boundaryTest1 = "Boundry Test: (Date) d1,d2: 0,0 -> false ";
	private final String boundaryTest2 = "Boundry Test: (Date) d1,d2: -1,0 -> false ";
	private final String boundaryTest3 = "Boundry Test: (Date) d1,d2: 0,-1 -> true ";
	private final String boundaryTest4 = "Boundry Test: (Date) d1,d2: Long.MAX,Long.MAX-86400 -> true ";
	private final String boundaryTest5 = "Boundry Test: (Date) d1,d2: Long.MAX-86400,Long.MAX -> false ";
	private final String boundaryTest6 = "Boundry Test: (Date) d1,d2: Long.MIN+86400,Long.MIN -> true ";
	private final String boundaryTest7 = "Boundry Test: (Date) d1,d2: Long.MIN,Long.MIN+86400 -> false ";
	
	//TEST NAMES FOR DECISION TABLE TESTS
	private final String decisionTableTest = "Decision Table Test: See Doc ";
	
	//EXPECTED TEST RESULTS
	private final String MESSAGE_6 = "Does not handle years before common era (BCE) for d1 < d2";
	private final String MESSAGE_7 = "Does not handle years before common era (BCE) for d1 > d2";

	/**
	 * <p>Test Case: IA1</p> 
	 * <p>Date d1: 0</p> 
	 * <p>Date d2: 0</p> 
	 * <p>Expected Output: False</p> 
	 */
	@Test
	@DisplayName(boundaryTest1)
	public void BoundryTest1() {
		d1 = new Date(0);
		d2 = new Date(0);
		System.out.println(boundaryTest1 + "\t" + d1.getTime());
		assertFalse(DateUtil.isAfter(d1, d2));
	}

	/**
	 * <p>Test Case: IA2</p> 
	 * <p>Date d1: -1</p> 
	 * <p>Date d2: 0</p> 
	 * <p>Expected Output: False</p> 
	 */
	@Test
	@DisplayName(boundaryTest2)
	public void BoundryTest2() {

		d1 = new Date(-ONE_DAY);
		d2 = new Date(0);
		System.out.println(boundaryTest2 + "\t" + d1.getTime());
		assertFalse(DateUtil.isAfter(d1, d2));
	}

	/**
	 * <p>Test Case: IA3</p> 
	 * <p>Date d1: 0</p> 
	 * <p>Date d2: -1</p> 
	 * <p>Expected Output: True</p> 
	 */
	@Test
	@DisplayName(boundaryTest3)
	public void BoundryTest3() {
		d1 = new Date(0);
		d2 = new Date(-ONE_DAY);
		System.out.println(boundaryTest3 + "\t" + d1.getTime());
		assertTrue(DateUtil.isAfter(d1, d2));

	}

	/**
	 * <p>Test Case: IA4</p> 
	 * <p>Date d1: Long.MAX_VALUE</p> 
	 * <p>Date d2: Long.MAX_VALUE - ONE_DAY</p> 
	 * <p>Expected Output: True</p> 
	 */
	@Test
	@DisplayName(boundaryTest4)
	public void BoundryTest4() {
		d1 = new Date(Long.MAX_VALUE);
		d2 = new Date(Long.MAX_VALUE - ONE_DAY);
		System.out.println(boundaryTest4 + "\t" + d1.getTime());
		assertTrue(DateUtil.isAfter(d1, d2));
	}

	/**
	 * <p>Test Case: IA5</p> 
	 * <p>Date d1: Long.MAX_VALUE - ONE_DAY</p> 
	 * <p>Date d2: Long.MAX_VALUE</p> 
	 * <p>Expected Output: False</p> 
	 */
	@Test
	@DisplayName(boundaryTest5)
	public void BoundryTest5() { 
		d1 = new Date(Long.MAX_VALUE - ONE_DAY);
		d2 = new Date(Long.MAX_VALUE);
		System.out.println(boundaryTest5 + "\t" + d1.getTime());
		assertFalse(DateUtil.isAfter(d1, d2));

	}

	/**
	 * <p>Test Case: IA6</p> 
	 * <p>Date d1: Long.MIN_VALUE</p> 
	 * <p>Date d1: Long.MIN_VALUE + ONE_DAY</p> 
	 * <p>Expected Output: True</p> 
	 */
	@Test
	@DisplayName(boundaryTest6)
	public void BoundryTest6() {
		d1 = new Date(Long.MIN_VALUE);
		d2 = new Date(Long.MIN_VALUE + ONE_DAY);
		System.out.println(boundaryTest6 + "\t" + d1.getTime());
		assertFalse(MESSAGE_6, DateUtil.isAfter(d1, d2));
	}

	/**
	 * <p>Test Case: IA7</p> 
	 * <p>Date d1: Long.MIN_VALUE + ONE_DAY</p> 
	 * <p>Date d1: Long.MIN_VALUE</p> 
	 * <p>Expected Output: False</p> 
	 */
	@Test
	@DisplayName(boundaryTest7)
	public void BoundryTest7() {
		d1 = new Date(Long.MIN_VALUE + ONE_DAY);
		d2 = new Date(Long.MIN_VALUE);
		System.out.println(boundaryTest7 + "\t" + d1.getTime());
		assertTrue(MESSAGE_7, DateUtil.isAfter(d1, d2));
	}
	
	/**
	 * <p>Test Case: DT1</p> 
	 * <p>Date d1: Long.MAX_VALUE</p> 
	 * <p>Date d1: Long.MAX_VALUE</p> 
	 * <p>Expected Output: 622191234</p> 
	 */
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName(boundaryTest1)
	public void DecisionTable() {
		d1 = new Date();
		d2 = new Date(0, 0, 0);
		System.out.println(decisionTableTest + "\t" + d1.getTime());
		for (int year = 0; year <= 1; year++) {
			for (int month = 0; month <= 1; month++) {
				for (int day = 0; day <= 1; day++) {
					for (int hour = 0; hour <= 1; hour++) {
						for (int min = 0; min <= 1; min++) {
							for (int milli = 0; milli <= 0; milli++) {
								d1 = new Date(year, month, day, hour, min, milli);
								assertEquals(DateUtil.isAfter(d1, d2), d1.getDay() > d2.getDay());
							}
						}
					}
				}
			}
		}
	
	}

}
