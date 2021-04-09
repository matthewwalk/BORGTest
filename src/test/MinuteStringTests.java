package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import net.sf.borg.common.*;

/**
 *  
 * <p>Through out this testClass, methods follow the below naming legend </p>
 * 	<pre> 
 * 		3 Letter Name Code XYZ
 *		X = {N, P, Z} = {negative, positive, zero}
 *		Y | hour, Z | minute = {S, P, Z} = {singular, plural, zero} 
 *  </pre>
 *<p>
 *  Example : minStrPPP - Minute String Positive Plural Plural  where 
 *  integer `122` would represent `2 hours 2 minutes` which is Positive, Plural hours and Plural Minutes </p>
 *  
 * <p> Example 2: minStNPS - Minute String Negative, Plural, Singular where
 *  integer `-120` would represent `-2 hours 2 minutes` which is Negative, Plural hours and Singular Minute </p>
 * 
 * @author Allen Kaplan (214494928), Jamie Dishy (212904041), Akinloluwa Adewale (215238231), Matthew Walker (214779300)
 * @version 2.0
 */
@DisplayName("Minute String Test Class")
public class MinuteStringTests {

	int min;
	String minStr;
	private int MINUTES_IN_HOUR = 60;

	/** 
	 * <p>Test Case: PPP </p>
	 * <p>Integer min: 122 </p>
	 * <p>Expected: 2 Hours 2 Minute</p>
	 */
	@Test
	@DisplayName("Boundary Test: Positive, Plural, Plural Time Sring")
	public void minStrPPP() {
		min = 122;
		minStr = "2 Hours 2 Minutes";
		assertEquals(minStr, DateUtil.minuteString(min));
	}
	
	/** 
	 * <p>Test Case: PPS </p>
	 * <p>Integer min: 121 </p>
	 * <p>Expected: 2 Hours 1 Minute</p>
	 */
	@Test
	@DisplayName("Bounday Test: Positive, Plural, Singular Time Sring")
	public void minStrPPS() {
		min = 121;
		minStr = "2 Hours 1 Minute";
		assertEquals(minStr, DateUtil.minuteString(min));
	}
	
	/** 
	 * <p>Test Case: PPZ </p>
	 * <p>Integer min: 120 </p>
	 * <p>Expected: 2 Hours</p>
	 */
	@Test
	@DisplayName("Boundary Test: Positive, Plural, Zero Time Sring")
	public void minStrPPZ() {
		min = 120;
		minStr = "2 Hours";
		assertEquals(minStr, DateUtil.minuteString(min));
	}
	
	/** 
	 * <p>Test Case: PSPHigh </p>
	 * <p>Integer min: 119 </p>
	 * <p>Expected: 1 Hour 59 Minutes</p>
	 */
	@Test
	@DisplayName("Boundary Test: High Edge Positive, Singluar, Plural Time Sring")
	public void minStrPSPHigh() {
		min = 119;
		minStr = "1 Hour 59 Minutes";
		assertEquals(minStr, DateUtil.minuteString(min));
	}
	
	/** 
	 * <p>Test Case: PSPLow </p>
	 * <p>Integer min: 62 </p>
	 * <p>Expected: 1 Hour 2 Minutes</p>
	 */
	@Test
	@DisplayName("Boundary Test: Low Edge Positive, Singular Plural Time Sring")
	public void minStrPSPLow() {
		min = 62;
		minStr = "1 Hour 2 Minutes";
		assertEquals(minStr, DateUtil.minuteString(min));
	}
	
	/** 
	 * <p>Test Case: PSS </p>
	 * <p>Integer min: 61 </p>
	 * <p>Expected: 1 Hour 1 Minute</p>
	 */
	@Test
	@DisplayName("Boundary Test: Positive, Singular, Singular Time Sring")
	public void minStrPSS() {
		min = 61;
		minStr = "1 Hour 1 Minute";
		assertEquals(minStr, DateUtil.minuteString(min));
	}
	
	/** 
	 * <p>Test Case: PSZ </p>
	 * <p>Integer min: 60 </p>
	 * <p>Expected: 1 Hour </p>
	 */
	@Test
	@DisplayName("Boundary Test: Positive, Singular, Zero Time Sring")
	public void minStrPSZ() {
		min = 60;
		minStr = "1 Hour";
		assertEquals(minStr, DateUtil.minuteString(min));
	}
	
	/** 
	 * <p>Test Case: PZPHigh </p>
	 * <p>Integer min: 59 </p>
	 * <p>Expected: 59 Minutes </p>
	 */
	@Test
	@DisplayName("Boundary Test: High Edge Positive, Zero, Plural Time Sring")
	public void minStrPZPHigh() {
		min = 59;
		minStr = "59 Minutes";
		assertEquals(minStr, DateUtil.minuteString(min));
	}
	
	/** 
	 * <p>Test Case: PZPLow </p>
	 * <p>Integer min: 2 </p>
	 * <p>Expected: 2 Minutes </p>
	 */
	@Test
	@DisplayName("Boundary Test: Low Edge Positive, Zero, Plural Time Sring")
	public void minStrPZPLow() {
		min = 2;
		minStr = "2 Minutes";
		assertEquals(minStr, DateUtil.minuteString(min));
	}
	
	/** 
	 * <p>Test Case: PZS </p>
	 * <p>Integer min: 1 </p>
	 * <p>Expected: 1 Minute </p>
	 */
	@Test
	@DisplayName("Boundary Test: Positive, Zero, Singular Time Sring")
	public void minStrPZS() {
		min = 1;
		minStr = "1 Minute";
		assertEquals(minStr, DateUtil.minuteString(min));
	}
	
	/** 
	 * <p>Test Case: ZZZ </p>
	 * <p>Integer min: 0 </p>
	 * <p>Expected: 0 Minutes </p>
	 */
	@Test
	@DisplayName("Boundary Test: Zero, Zero, Zero Time Sring")
	public void minStrZZZ() {
		min = 0;
		minStr = "0 Minutes";
		assertEquals(minStr, DateUtil.minuteString(min));
	}

	/** 
	 * <p>Test Case: NPP </p>
	 * <p>Integer min: &#45;122 </p>
	 * <p>Expected: &#45;2 Hours 2 Minutes </p>
	 */
//	@Test
//	@DisplayName("Boundary Test: Negative, Plural, Plural Time Sring")
//	public void minStrNPP() {
//		min = -122;
//		minStr = "-2 Hours 2 Minutes";
//		assertEquals(minStr, DateUtil.minuteString(min));
//	}


	/** 
	 * <p>Test Case: NPS </p>
	 * <p>Integer min: &#45;121  </p>
	 * <p>Expected: &#45;2 Hours 1 Minute </p>
	 */
//	@Test
//	@DisplayName("Boundary Test: Negative, Plural, Singular Time Sring")
//	public void minStrNPS() {
//		min = -121;
//		minStr = "-2 Hours 1 Minute";
//		assertEquals(minStr, DateUtil.minuteString(min));
//	}
	
	/** 
	 * <p>Test Case: NPZ </p>
	 * <p>Integer min: &#45;120  </p>
	 * <p>Expected: &#45;2 Hours </p>
	 */
//	@Test
//	@DisplayName("Boundary Test: Negative, Plural, Singular Time Sring")
//	public void minStrNPZ() {
//		min = -120;
//		minStr = "-2 Hours";
//		assertEquals(minStr, DateUtil.minuteString(min));
//	}
	
	/** 
	 * <p>Test Case: NSPHigh </p>
	 * <p>Integer min: &#45;119  </p>
	 * <p>Expected: &#45;1 Hour 59 Minutes </p>
	 */
//	@Test
//	@DisplayName("Boundary Test: High Edge Negative, Singular, Plural Time Sring")
//	public void minStrNSPHigh() {
//		min = -119;
//		minStr = "-1 Hour 59 Minutes";
//		assertEquals(minStr, DateUtil.minuteString(min));
//	}
	
	/** 
	 * <p>Test Case: NSPLow </p>
	 * <p>Integer min: &#45;62  </p>
	 * <p>Expected: &#45;1 Hour 2 Minutes </p>
	 */
//	@Test
//	@DisplayName("Boundary Test: Low Edge, Negative, Singular, Plural Time Sring")
//	public void minStrNSPLow() {
//		min = -62;
//		minStr = "-1 Hour 2 Minutes";
//		assertEquals(minStr, DateUtil.minuteString(min));
//	}
	
	/** 
	 * <p>Test Case: NSS </p>
	 * <p>Integer min: &#45;61  </p>
	 * <p>Expected: &#45;1 Hour 1 Minute </p>
	 */
//	@Test
//	@DisplayName("Boundary Test: Negative, Singular, Singular Time Sring")
//	public void minStrNSS() {
//		min = -61;
//		minStr = "-1 Hour 1 Minute";
//		assertEquals(minStr, DateUtil.minuteString(min));
//	}
	
	/** 
	 * <p>Test Case: NSZ </p>
	 * <p>Integer min: &#45;60  </p>
	 * <p>Expected: &#45;1 Hour </p>
	 */
//	@Test
//	@DisplayName("Boundary Test: Negative Singular Zero Time Sring")
//	public void minStrNSZ() {
//		min = -60;
//		minStr = "-1 Hour";
//		assertEquals(minStr, DateUtil.minuteString(min));
//	}
	
	/** 
	 * <p>Test Case: NZPHigh </p>
	 * <p>Integer min: &#45;59  </p>
	 * <p>Expected: &#45;59 Minutes </p>
	 */
//	@Test
//	@DisplayName("Boundary Test: High Edge Negative, Zero, Positve Time Sring")
//	public void minStrNZPHigh() {
//		min = -59;
//		minStr = "-59 Minutes";
//		assertEquals(minStr, DateUtil.minuteString(min));
//	}
	
	/** 
	 * <p>Test Case: NZPLow </p>
	 * <p>Integer min: &#45;2  </p>
	 * <p>Expected: &#45;2 Minutes </p>
	 */
//	@Test
//	@DisplayName("Boundary Test: Low Edge, Negative, Zero, Positive Time Sring")
//	public void minStrNZPLow() {
//		min = -2;
//		minStr = "-2 Minutes";
//		assertEquals(minStr, DateUtil.minuteString(min));
//	}
	
	/** 
	 * <p>Test Case: NZS </p>
	 * <p>Integer min: &#45;1  </p>
	 * <p>Expected:  &#45;1 Minute </p>
	 */
//	@Test
//	@DisplayName("Boundary Test: Negative, Zero, Singular Time Sring")
//	public void minStrNZS() {
//		min = -1;
//		minStr = "-1 Minute";
//		assertEquals(minStr, DateUtil.minuteString(min));
//	}
	
	/**
	 * <p>Test Case: Equivalence Test: mins > 60 </p>
	 * <p>Integer min: 80  </p>
	 * <p>Expected: 1 Hour 20 Minutes </p>
	 */
//	@Test
//	@DisplayName("Equivalence Test: mins / 60 > 1")
//	public void equivalenceTest1() {
//		min = 80;
//		double time = min > MINUTES_IN_HOUR ? min/MINUTES_IN_HOUR : min;
//		int hour = Integer.parseInt(String.valueOf(time).split("\\.")[0]);
//		int minute = Integer.parseInt(String.valueOf(time).split("\\.")[1]);
//
//		minStr = hour + " Hour " +minute + " Minutes";
//		assertEquals(minStr, DateUtil.minuteString(min));
//	}
	
	/**
	 * <p>Test Case: Equivalence Test: 0 < mins / 60 < 1 </p>
	 * <p>Integer min: 59  </p>
	 * <p>Expected: 59 Minutes </p>
	 */
	@Test
	@DisplayName("Equivalence Test:  0 < mins / 60 < 1 ")
	public void equivalenceTest2() {
		min = 59;
		double time = min > MINUTES_IN_HOUR ? min/MINUTES_IN_HOUR : min;
		int minute = min > MINUTES_IN_HOUR ? Integer.parseInt(String.valueOf(time).split("\\.")[1]) : Integer.parseInt(String.valueOf(time).split("\\.")[0]);
		
		minStr = minute + " Minutes";
		assertEquals(minStr, DateUtil.minuteString(min));
	}

	/**
	 * <p>Test Case: Equivalence Test: mins / 60 = 0 </p>
	 * <p>Integer min: 0  </p>
	 * <p>Expected: 0 Minutes </p>
	 */
	@Test
	@DisplayName("Equivalence Test: mins / 60 = 0")
	public void equivalenceTest3_1() {
		min = 0;
		double time = min > MINUTES_IN_HOUR ? min/MINUTES_IN_HOUR : min;
		int minute = min > MINUTES_IN_HOUR ? Integer.parseInt(String.valueOf(time).split("\\.")[1]) : Integer.parseInt(String.valueOf(time).split("\\.")[0]);
		minStr = minute + " Minutes";
		assertEquals(minStr, DateUtil.minuteString(min));
	}
	
	/**
	 * <p>Test Case: Equivalence Test: mins / 60 < 0 </p>
	 * <p>Integer min:  &#45;30  </p>
	 * <p>Expected:  &#45;30 Minutes </p>
	 */
	@Test
	@DisplayName("Equivalence Test:  mins / 60 < 0")
	public void equivalenceTest3_2() {
		min = -30;
		double time = min > MINUTES_IN_HOUR ? min/MINUTES_IN_HOUR : min;
		int minute = min > MINUTES_IN_HOUR ? Integer.parseInt(String.valueOf(time).split("\\.")[1]) : Integer.parseInt(String.valueOf(time).split("\\.")[0]);
		
		minStr = minute + " Minutes";
		assertEquals(minStr, DateUtil.minuteString(min));
	}
	
	
}
