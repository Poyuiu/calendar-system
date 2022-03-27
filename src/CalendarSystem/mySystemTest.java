package CalendarSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class mySystemTest {
	
	mySystem ms = new mySystem();
	
	/**
	 * test method: mySystem.printCalendar(year, month)
	 * test year: 2022
	 * test month: 3
	 */
	@Test
	void testPrintCalendar1() {
		String ans = "Sun Mon Tue Wed Thu Fri Sat\n" + 
				"          1   2   3   4   5 \n" + 
				"  6   7   8   9  10  11  12 \n" + 
				" 13  14  15  16  17  18  19 \n" + 
				" 20  21  22  23  24  25  26 \n" + 
				" 27  28  29  30  31 ";
		assertEquals(ans, ms.printCalendar(2022, 3));
		
	}
	
	/**
	 * test method: mySystem.printCalendar(year, month)
	 * test year: 10000
	 * test month: 12
	 */
	@Test
	void testPrintCalendar2() {
		String ans = "Sun Mon Tue Wed Thu Fri Sat\n" + 
				"                      1   2 \n" + 
				"  3   4   5   6   7   8   9 \n" + 
				" 10  11  12  13  14  15  16 \n" + 
				" 17  18  19  20  21  22  23 \n" + 
				" 24  25  26  27  28  29  30 \n" + 
				" 31 ";
		assertEquals(ans, ms.printCalendar(10000, 12));
	}
	
	/**
	 * test method: mySystem.maxDayInMonth(year, month)
	 * test year: 10000
	 * test month: 2
	 */
	@Test
	void testMaxDayInMonth1() {
		int ans = 29;
		assertEquals(ans, ms.maxDayInMonth(10000, 2));
	}
	
	/**
	 * test method: mySystem.maxDayInMonth(year, month)
	 * test year: 1100
	 * test month: 2
	 */
	@Test
	void testMaxDayInMonth2() {
		int ans = 28;
		assertEquals(ans, ms.maxDayInMonth(1100, 2));
	}
	
	
}
