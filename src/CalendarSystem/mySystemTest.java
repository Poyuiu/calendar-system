// ひらがな for default UTF-8 type
package CalendarSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

class mySystemTest {
	
	/**
	 * test method:	mySystem.printCalendar(year, month) 
	 * test year:	2022 
	 * test month:	3
	 */
	@Test
	void testPrintCalendar1() {
		String ans = "Sun Mon Tue Wed Thu Fri Sat\n" + "          1   2   3   4   5 \n"
				+ "  6   7   8   9  10  11  12 \n" + " 13  14  15  16  17  18  19 \n" + " 20  21  22  23  24  25  26 \n"
				+ " 27  28  29  30  31 ";
		ByteArrayInputStream inputStream = new ByteArrayInputStream("".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
		assertEquals(ans, ms.printCalendar(2022, 3));

	}

	/**
	 * test method:	mySystem.printCalendar(year, month) 
	 * test year:	10000 
	 * test month:	12
	 */
	@Test
	void testPrintCalendar2() {
		String ans = "Sun Mon Tue Wed Thu Fri Sat\n" + "                      1   2 \n"
				+ "  3   4   5   6   7   8   9 \n" + " 10  11  12  13  14  15  16 \n" + " 17  18  19  20  21  22  23 \n"
				+ " 24  25  26  27  28  29  30 \n" + " 31 ";
		ByteArrayInputStream inputStream = new ByteArrayInputStream("".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
		assertEquals(ans, ms.printCalendar(10000, 12));
	}

	/**
	 * test method: mySystem.getDateString() 
	 * test input:	"2022/12/12"
	 */
	@Test
	void testGetDateString1() {
		
		ByteArrayInputStream inputStream = new ByteArrayInputStream("2022/12/12\n".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
	    
	    // call method and test return string
	    String ansForReturn = "2022/12/12";
		assertEquals(ansForReturn, ms.getDateString());
		
		String methodOutput = byteArrayOutputStream.toString();
	    
	    // test method's output
	    String ansForOutput = "請輸入欲查詢日期(年/月/日):";
	    assertEquals(ansForOutput, methodOutput);
	}

	/**
	 * test method: mySystem.getDateString() 
	 * test input:	"10000/13/33\n10000/12/12\n"
	 */
	@Test
	void testGetDateString2() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("10000/13/33\n10000/12/12\n".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
	    
	    // call method and test return string
	    String ansForReturn = "10000/12/12";
		assertEquals(ansForReturn, ms.getDateString());
		
		String methodOutput = byteArrayOutputStream.toString();
	    
	    // test method's output
	    String ansForOutput = "請輸入欲查詢日期(年/月/日):" + 
	    		"請輸入欲查詢日期(年/月/日):";
	    assertEquals(ansForOutput, methodOutput);
	}

	/**
	 * test method: mySystem.validDate()
	 * test str:	"2022.12.12"
	 */
	@Test
	void testValidDate1() {
		boolean ans = false;
		ByteArrayInputStream inputStream = new ByteArrayInputStream("".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
		assertEquals(ans, ms.validDate("2022.12.12"));
	}

	/**
	 * test method: mySystem.validDate()
	 * test str:	"100/02/29"
	 */
	@Test
	void testValidDate2() {
		boolean ans = false;
		ByteArrayInputStream inputStream = new ByteArrayInputStream("".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
		assertEquals(ans, ms.validDate("100/02/29"));
	}
	
	/**
	 * test method: mySystem.getYearString() 
	 * test input:	"abc\n10000"
	 */
	@Test
	void testGetYearString1() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("abc\n10000\n".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
	    
	    // call method and test return string
	    String ansForReturn = "10000";
		assertEquals(ansForReturn, ms.getYearString());
		String methodOutput = byteArrayOutputStream.toString();
	    
	    // test method's output
	    String ansForOutput = "請輸入欲查詢年:" + 
	    		"請輸入欲查詢年:";
	    assertEquals(ansForOutput, methodOutput);
	}
	
	/**
	 * test method: mySystem.getYearString() 
	 * test input:	"ABC\n2o22\n2022"
	 */
	@Test
	void testGetYearString2() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("ABC\n2o22\n2022\n".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
	    
	    // call method and test return string
	    String ansForReturn = "2022";
		assertEquals(ansForReturn, ms.getYearString());
		
		String methodOutput = byteArrayOutputStream.toString();
	    
	    // test method's output
	    String ansForOutput = "請輸入欲查詢年:" + 
	    		"請輸入欲查詢年:"+ 
	    		"請輸入欲查詢年:";
	    assertEquals(ansForOutput, methodOutput);
	}
	
	/**
	 * test method: mySystem.funcA()
	 * test input: "2022.03.01\n2022/03/01"
	 */
	@Test
	void testFuncA1() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("2022.03.01\n2022/03/01\n".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
	    
	    ms.funcA();
		
	    String methodOutput = byteArrayOutputStream.toString();
	    
	    // test method's output
	    String ans = 
	    		"請輸入欲查詢日期(年/月/日):" +
	    		"請輸入欲查詢日期(年/月/日):" +
	    		"Sun Mon Tue Wed Thu Fri Sat\n" + 
	    		"          1   2   3   4   5 \n" + 
	    		"  6   7   8   9  10  11  12 \n" + 
	    		" 13  14  15  16  17  18  19 \n" + 
	    		" 20  21  22  23  24  25  26 \n" + 
	    		" 27  28  29  30  31 \n";
	    assertEquals(ans, methodOutput);
	}
	
	/**
	 * test method: mySystem.funcA()
	 * test input: "2022.03.01\n2022/02/29\n8000/2/2"
	 */
	@Test
	void testFuncA2() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("2022.03.01\n2022/02/29\n8000/2/2\n".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
	    
	    ms.funcA();
	    
		String methodOutput = byteArrayOutputStream.toString();
	    
	    // test method's output
	    String ans =
	    		"請輸入欲查詢日期(年/月/日):" +
	    		"請輸入欲查詢日期(年/月/日):" +
	    		"請輸入欲查詢日期(年/月/日):" +
	    		"Sun Mon Tue Wed Thu Fri Sat\n" + 
	    		"          1   2   3   4   5 \n" + 
	    		"  6   7   8   9  10  11  12 \n" + 
	    		" 13  14  15  16  17  18  19 \n" + 
	    		" 20  21  22  23  24  25  26 \n" + 
	    		" 27  28  29 \n";
	    assertEquals(ans, methodOutput);
	}
	
	/**
	 * test method: mySystem.funcB()
	 * test input: "ABC\n2022"
	 */
	@Test
	void testFuncB1() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("ABC\n2022\n".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
	    
	    ms.funcB();
		
	    String methodOutput = byteArrayOutputStream.toString();
	    
	    // test method's output
	    String ans = "請輸入欲查詢年:" + "請輸入欲查詢年:" + 
	    		"2022是壬寅年，屬虎\n";
	    assertEquals(ans, methodOutput);
	}
	
	/**
	 * test method: mySystem.funcB()
	 * test input: "10000"
	 */
	@Test
	void testFuncB2() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("10000\n".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
		
		ms.funcB();
		
		String methodOutput = byteArrayOutputStream.toString();
	    
		// test method'd output
		String ans = "請輸入欲查詢年:" +
				"10000是庚子年，屬鼠\n";
		assertEquals(ans, methodOutput);
	}
	
	/**
	 * test method: mySystem.funcC()
	 * test input: "2022.05.05\n2022/05/05\n"
	 */
	@Test
	void testFuncC1() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("2022.05.05\n2022/05/05\n".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
		
	    ms.funcC();
		
	    String methodOutput = byteArrayOutputStream.toString();
	    
	    LocalDate date_2 = LocalDate.now();
	    LocalDate date_1 = LocalDate.parse("2022-05-05");
	    // test method's output
	    String ans = 
	    		"請輸入欲查詢日期(年/月/日):" +
	    		"請輸入欲查詢日期(年/月/日):" +
	    		"2022/05/05距離今天還有" + 
	    		ChronoUnit.DAYS.between(date_2, date_1) + 
	    		"天\n";
	    assertEquals(ans, methodOutput);
	}
	
	/**
	 * test method: mySystem.funcC()
	 * test input: "2022/2/29\n2022/7/15" 
	 */
	@Test
	void testFuncC2() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("2022/2/29\n2022/7/15\n".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
		
	    ms.funcC();
		
	    String methodOutput = byteArrayOutputStream.toString();
	    
	    LocalDate date_2 = LocalDate.now();
	    LocalDate date_1 = LocalDate.parse("2022-07-15");
	    // test method's output
	    String ans =
	    		"請輸入欲查詢日期(年/月/日):" +
	    		"請輸入欲查詢日期(年/月/日):" +
	    		"2022/7/15距離今天還有" + 
	    		ChronoUnit.DAYS.between(date_2, date_1) + 
	    		"天\n";
	    assertEquals(ans, methodOutput);
	}
	
	/**
	 * test method: mySystem.funcD()
	 * test input: "20.00\n20\n"
	 */
	@Test
	void testFuncD1() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("20.00\n20\n".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
		
	    ms.funcD();
		
	    String methodOutput = byteArrayOutputStream.toString();
	    
	    Calendar now = Calendar.getInstance();
		now.set(Calendar.DATE, now.get(Calendar.DATE) + 20);
		LocalDate localDate = LocalDateTime.ofInstant(now.toInstant(), now.getTimeZone().toZoneId()).toLocalDate();
		String ld = localDate.toString();
		ld = ld.replace('-', '/');
	    // test method's output
	    String ans =
	    		"請輸入往後推算的天數:" +
	    		"請輸入往後推算的天數:\n" +
	    		"往後20天是" + ld +
	    		"\n";
	    assertEquals(ans, methodOutput);
	}
	
	/**
	 * test method: mySystem.funcD()
	 * test input: "20o\n200"
	 */
	@Test
	void testFuncD2() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("20o\n200\n".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
		
	    ms.funcD();
		
	    String methodOutput = byteArrayOutputStream.toString();
	    
	    Calendar now = Calendar.getInstance();
		now.set(Calendar.DATE, now.get(Calendar.DATE) + 200);
		LocalDate localDate = LocalDateTime.ofInstant(now.toInstant(), now.getTimeZone().toZoneId()).toLocalDate();
		String ld = localDate.toString();
		ld = ld.replace('-', '/');
	    // test method's output
	    String ans =
	    		"請輸入往後推算的天數:" +
	    		"請輸入往後推算的天數:\n" +
	    		"往後200天是" + ld +
	    		"\n";
	    assertEquals(ans, methodOutput);
	}
	
	/**
	 * test method: mySystem.start()
	 * test input: A -> 2022/4/4 -> B -> 2022 -> C -> 2022/05/20 
	 * -> D -> 520 -> E
	 */
	@Test
	void testStart1() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("A\n2022/4/4\nB\n2022\nC\n2022/05/20\nD\n520\nE\n".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
		
	    ms.start();
	    
	    String methodOutput = byteArrayOutputStream.toString();
	    
	    LocalDate date_2 = LocalDate.now();
	    LocalDate date_1 = LocalDate.parse("2022-05-20");
	    
	    Calendar now = Calendar.getInstance();
		now.set(Calendar.DATE, now.get(Calendar.DATE) + 520);
		LocalDate localDate = LocalDateTime.ofInstant(now.toInstant(), now.getTimeZone().toZoneId()).toLocalDate();
		String ld = localDate.toString();
		ld = ld.replace('-', '/');
		
		// test method'd output
		String ans = 
				"輸入指令號碼或 E(結束使用)?\n\n" + 
			    "輸入指令:\n" + 
			    "1): A 顯示該月月曆\n" +
			    "2): B 西元轉換干支、生肖\n" + 
			    "3): C 計算天數\n" +
			    "4): D 計算日期\n" +
			    "5): E 離開\n" + 
			    "請輸入欲查詢日期(年/月/日):" +
				"Sun Mon Tue Wed Thu Fri Sat\n" + 
				"                      1   2 \n" + 
				"  3   4   5   6   7   8   9 \n" + 
				" 10  11  12  13  14  15  16 \n" + 
				" 17  18  19  20  21  22  23 \n" + 
				" 24  25  26  27  28  29  30 \n\n" +
				"輸入指令號碼或 E(結束使用)?\n\n" + 
			    "輸入指令:\n" + 
			    "1): A 顯示該月月曆\n" +
			    "2): B 西元轉換干支、生肖\n" + 
			    "3): C 計算天數\n" +
			    "4): D 計算日期\n" +
			    "5): E 離開\n" +
			    "請輸入欲查詢年:" + 
			    "2022是壬寅年，屬虎\n" + 
			    "輸入指令號碼或 E(結束使用)?\n\n" + 
			    "輸入指令:\n" + 
			    "1): A 顯示該月月曆\n" +
			    "2): B 西元轉換干支、生肖\n" + 
			    "3): C 計算天數\n" +
			    "4): D 計算日期\n" +
			    "5): E 離開\n" +
			    "請輸入欲查詢日期(年/月/日):" +
	    		"2022/05/20距離今天還有" + 
	    		ChronoUnit.DAYS.between(date_2, date_1) + 
	    		"天\n" +
	    		"輸入指令號碼或 E(結束使用)?\n\n" + 
			    "輸入指令:\n" + 
			    "1): A 顯示該月月曆\n" +
			    "2): B 西元轉換干支、生肖\n" + 
			    "3): C 計算天數\n" +
			    "4): D 計算日期\n" +
			    "5): E 離開\n" +
			    "請輸入往後推算的天數:\n" +
	    		"往後520天是" + ld +
	    		"\n" + 
	    		"輸入指令號碼或 E(結束使用)?\n\n" + 
			    "輸入指令:\n" + 
			    "1): A 顯示該月月曆\n" +
			    "2): B 西元轉換干支、生肖\n" + 
			    "3): C 計算天數\n" +
			    "4): D 計算日期\n" +
			    "5): E 離開\n" +
			    "離開系統\n";
		assertEquals(ans, methodOutput);
	}
	/**
	 * test method: mySystem.start()
	 * test input: A -> 2022/13/4 -> 2022/2/29 -> 2077/7/7
	 * -> B -> 2022.0 -> 2abc22 -> 2077
	 * -> C -> 2022.5.20 -> 2077/07/07
	 * -> D -> 1oo -> 52o -> 777 
	 * -> E
	 */
	@Test
	void testStart2() {
		ByteArrayInputStream inputStream = new ByteArrayInputStream("A\n2022/13/4\n2022/2/29\n2077/7/7\nB\n2022.0\n2abc22\n2077\nC\n2022.5.20\n2077/07/07\nD\n1oo\n52o\n777\nE\n".getBytes());
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(byteArrayOutputStream);
	    mySystem ms = new mySystem(inputStream, ps);
		
	    ms.start();
	    
	    String methodOutput = byteArrayOutputStream.toString();
	    
	    LocalDate date_2 = LocalDate.now();
	    LocalDate date_1 = LocalDate.parse("2077-07-07");
	    
	    Calendar now = Calendar.getInstance();
		now.set(Calendar.DATE, now.get(Calendar.DATE) + 777);
		LocalDate localDate = LocalDateTime.ofInstant(now.toInstant(), now.getTimeZone().toZoneId()).toLocalDate();
		String ld = localDate.toString();
		ld = ld.replace('-', '/');
		
		// test method'd output
		String ans = 
				"輸入指令號碼或 E(結束使用)?\n\n" + 
			    "輸入指令:\n" + 
			    "1): A 顯示該月月曆\n" +
			    "2): B 西元轉換干支、生肖\n" + 
			    "3): C 計算天數\n" +
			    "4): D 計算日期\n" +
			    "5): E 離開\n" + 
			    "請輸入欲查詢日期(年/月/日):" +
			    "請輸入欲查詢日期(年/月/日):" +
			    "請輸入欲查詢日期(年/月/日):" +
				"Sun Mon Tue Wed Thu Fri Sat\n" + 
				"                  1   2   3 \n" + 
				"  4   5   6   7   8   9  10 \n" + 
				" 11  12  13  14  15  16  17 \n" + 
				" 18  19  20  21  22  23  24 \n" + 
				" 25  26  27  28  29  30  31 \n\n" +
				"輸入指令號碼或 E(結束使用)?\n\n" + 
			    "輸入指令:\n" + 
			    "1): A 顯示該月月曆\n" +
			    "2): B 西元轉換干支、生肖\n" + 
			    "3): C 計算天數\n" +
			    "4): D 計算日期\n" +
			    "5): E 離開\n" +
			    "請輸入欲查詢年:" + 
			    "請輸入欲查詢年:" + 
			    "請輸入欲查詢年:" +
			    "2077是丁酉年，屬雞\n" + 
			    "輸入指令號碼或 E(結束使用)?\n\n" + 
			    "輸入指令:\n" + 
			    "1): A 顯示該月月曆\n" +
			    "2): B 西元轉換干支、生肖\n" + 
			    "3): C 計算天數\n" +
			    "4): D 計算日期\n" +
			    "5): E 離開\n" +
			    "請輸入欲查詢日期(年/月/日):" +
			    "請輸入欲查詢日期(年/月/日):" +
	    		"2077/07/07距離今天還有" + 
	    		ChronoUnit.DAYS.between(date_2, date_1) + 
	    		"天\n" +
	    		"輸入指令號碼或 E(結束使用)?\n\n" + 
			    "輸入指令:\n" + 
			    "1): A 顯示該月月曆\n" +
			    "2): B 西元轉換干支、生肖\n" + 
			    "3): C 計算天數\n" +
			    "4): D 計算日期\n" +
			    "5): E 離開\n" +
			    "請輸入往後推算的天數:" +
			    "請輸入往後推算的天數:" +
			    "請輸入往後推算的天數:" +
	    		"\n往後777天是" + ld +
	    		"\n" + 
	    		"輸入指令號碼或 E(結束使用)?\n\n" + 
			    "輸入指令:\n" + 
			    "1): A 顯示該月月曆\n" +
			    "2): B 西元轉換干支、生肖\n" + 
			    "3): C 計算天數\n" +
			    "4): D 計算日期\n" +
			    "5): E 離開\n" +
			    "離開系統\n";
		assertEquals(ans, methodOutput);
	}
	
	/**
	 * Integrated test
	 * test method: mySystem.main()
	 * test input: A -> 2022/4/4 -> B -> 2022 -> C -> 2022/05/20 
	 * -> D -> 520 -> E
	 */
	@Test
	public void mySystemIntegratedTest1(){
	      InputStream stdin = System.in;
	      System.setIn(new ByteArrayInputStream("A\n2022/4/4\nB\n2022\nC\n2022/05/20\nD\n520\nE\n".getBytes()));

	      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(byteArrayOutputStream);
	      PrintStream stdout = System.out;
	      System.setOut(ps);

	      mySystem.main(new String[0]);

	      System.setIn(stdin);
	      System.setOut(stdout);
	      
	      String methodOutput = byteArrayOutputStream.toString();
		    
		  LocalDate date_2 = LocalDate.now();
		  LocalDate date_1 = LocalDate.parse("2022-05-20");
		    
		  Calendar now = Calendar.getInstance();
		  now.set(Calendar.DATE, now.get(Calendar.DATE) + 520);
		  LocalDate localDate = LocalDateTime.ofInstant(now.toInstant(), now.getTimeZone().toZoneId()).toLocalDate();
		  String ld = localDate.toString();
		  ld = ld.replace('-', '/');
			
		  String ans = 
					"輸入指令號碼或 E(結束使用)?\n\n" + 
				    "輸入指令:\n" + 
				    "1): A 顯示該月月曆\n" +
				    "2): B 西元轉換干支、生肖\n" + 
				    "3): C 計算天數\n" +
				    "4): D 計算日期\n" +
				    "5): E 離開\n" + 
				    "請輸入欲查詢日期(年/月/日):" +
					"Sun Mon Tue Wed Thu Fri Sat\n" + 
					"                      1   2 \n" + 
					"  3   4   5   6   7   8   9 \n" + 
					" 10  11  12  13  14  15  16 \n" + 
					" 17  18  19  20  21  22  23 \n" + 
					" 24  25  26  27  28  29  30 \n\n" +
					"輸入指令號碼或 E(結束使用)?\n\n" + 
				    "輸入指令:\n" + 
				    "1): A 顯示該月月曆\n" +
				    "2): B 西元轉換干支、生肖\n" + 
				    "3): C 計算天數\n" +
				    "4): D 計算日期\n" +
				    "5): E 離開\n" +
				    "請輸入欲查詢年:" + 
				    "2022是壬寅年，屬虎\n" + 
				    "輸入指令號碼或 E(結束使用)?\n\n" + 
				    "輸入指令:\n" + 
				    "1): A 顯示該月月曆\n" +
				    "2): B 西元轉換干支、生肖\n" + 
				    "3): C 計算天數\n" +
				    "4): D 計算日期\n" +
				    "5): E 離開\n" +
				    "請輸入欲查詢日期(年/月/日):" +
		    		"2022/05/20距離今天還有" + 
		    		ChronoUnit.DAYS.between(date_2, date_1) + 
		    		"天\n" +
		    		"輸入指令號碼或 E(結束使用)?\n\n" + 
				    "輸入指令:\n" + 
				    "1): A 顯示該月月曆\n" +
				    "2): B 西元轉換干支、生肖\n" + 
				    "3): C 計算天數\n" +
				    "4): D 計算日期\n" +
				    "5): E 離開\n" +
				    "請輸入往後推算的天數:\n" +
		    		"往後520天是" + ld +
		    		"\n" + 
		    		"輸入指令號碼或 E(結束使用)?\n\n" + 
				    "輸入指令:\n" + 
				    "1): A 顯示該月月曆\n" +
				    "2): B 西元轉換干支、生肖\n" + 
				    "3): C 計算天數\n" +
				    "4): D 計算日期\n" +
				    "5): E 離開\n" +
				    "離開系統\n";
	      assertEquals(ans, methodOutput);
	   }
	/**
	 * test method: mySystem.start()
	 * test input: A -> 2022/13/4 -> 2022/2/29 -> 2077/7/7
	 * -> B -> 2022.0 -> 2abc22 -> 2077
	 * -> C -> 2022.5.20 -> 2077/07/07
	 * -> D -> 1oo -> 52o -> 777 
	 * -> E
	 */
	@Test
	public void mySystemIntegratedTest2(){
	      InputStream stdin = System.in;
	      System.setIn(new ByteArrayInputStream("A\n2022/13/4\n2022/2/29\n2077/7/7\nB\n2022.0\n2abc22\n2077\nC\n2022.5.20\n2077/07/07\nD\n1oo\n52o\n777\nE\n".getBytes()));

	      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	      PrintStream ps = new PrintStream(byteArrayOutputStream);
	      PrintStream stdout = System.out;
	      System.setOut(ps);

	      mySystem.main(new String[0]);

	      System.setIn(stdin);
	      System.setOut(stdout);
	      
	      String methodOutput = byteArrayOutputStream.toString();
		    
		  LocalDate date_2 = LocalDate.now();
		  LocalDate date_1 = LocalDate.parse("2077-07-07");
		    
		  Calendar now = Calendar.getInstance();
		  now.set(Calendar.DATE, now.get(Calendar.DATE) + 777);
		  LocalDate localDate = LocalDateTime.ofInstant(now.toInstant(), now.getTimeZone().toZoneId()).toLocalDate();
		  String ld = localDate.toString();
		  ld = ld.replace('-', '/');
			
		  String ans = 
					"輸入指令號碼或 E(結束使用)?\n\n" + 
				    "輸入指令:\n" + 
				    "1): A 顯示該月月曆\n" +
				    "2): B 西元轉換干支、生肖\n" + 
				    "3): C 計算天數\n" +
				    "4): D 計算日期\n" +
				    "5): E 離開\n" + 
				    "請輸入欲查詢日期(年/月/日):" +
				    "請輸入欲查詢日期(年/月/日):" +
				    "請輸入欲查詢日期(年/月/日):" +
					"Sun Mon Tue Wed Thu Fri Sat\n" + 
					"                  1   2   3 \n" + 
					"  4   5   6   7   8   9  10 \n" + 
					" 11  12  13  14  15  16  17 \n" + 
					" 18  19  20  21  22  23  24 \n" + 
					" 25  26  27  28  29  30  31 \n\n" +
					"輸入指令號碼或 E(結束使用)?\n\n" + 
				    "輸入指令:\n" + 
				    "1): A 顯示該月月曆\n" +
				    "2): B 西元轉換干支、生肖\n" + 
				    "3): C 計算天數\n" +
				    "4): D 計算日期\n" +
				    "5): E 離開\n" +
				    "請輸入欲查詢年:" + 
				    "請輸入欲查詢年:" + 
				    "請輸入欲查詢年:" +
				    "2077是丁酉年，屬雞\n" + 
				    "輸入指令號碼或 E(結束使用)?\n\n" + 
				    "輸入指令:\n" + 
				    "1): A 顯示該月月曆\n" +
				    "2): B 西元轉換干支、生肖\n" + 
				    "3): C 計算天數\n" +
				    "4): D 計算日期\n" +
				    "5): E 離開\n" +
				    "請輸入欲查詢日期(年/月/日):" +
				    "請輸入欲查詢日期(年/月/日):" +
		    		"2077/07/07距離今天還有" + 
		    		ChronoUnit.DAYS.between(date_2, date_1) + 
		    		"天\n" +
		    		"輸入指令號碼或 E(結束使用)?\n\n" + 
				    "輸入指令:\n" + 
				    "1): A 顯示該月月曆\n" +
				    "2): B 西元轉換干支、生肖\n" + 
				    "3): C 計算天數\n" +
				    "4): D 計算日期\n" +
				    "5): E 離開\n" +
				    "請輸入往後推算的天數:" +
				    "請輸入往後推算的天數:" +
				    "請輸入往後推算的天數:" +
		    		"\n往後777天是" + ld +
		    		"\n" + 
		    		"輸入指令號碼或 E(結束使用)?\n\n" + 
				    "輸入指令:\n" + 
				    "1): A 顯示該月月曆\n" +
				    "2): B 西元轉換干支、生肖\n" + 
				    "3): C 計算天數\n" +
				    "4): D 計算日期\n" +
				    "5): E 離開\n" +
				    "離開系統\n";
	      assertEquals(ans, methodOutput);
	   }
}
