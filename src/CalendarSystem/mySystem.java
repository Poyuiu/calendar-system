// ひらがな for default UTF-8 type
package CalendarSystem;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class mySystem {
	
	private Scanner in;
	private PrintStream printStream;

	public mySystem(InputStream inputStream, PrintStream printStream) {
	      this.in = new Scanner(inputStream);
	      this.printStream = printStream;
	}
	/***
	 * Print out the desired monthly calendar
	 * 
	 * @param Year:	desired year
	 * @param Month: desired month
	 * @return output: formatted calendar 
	 * * Example: mySystem.printCalendar(2022, 3): return
	 * 	 calendar string of this month 
	 * * Time estimate: O(1)
	 */
	public String printCalendar(int Year, int Month) {
		
		// initialize the variable to utilize
		int year = Year;
		int month = Month;
		String output;
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		
		// check the day of start day and fill 
		// space before it in the returned string
		int startDay = calendar.get(Calendar.DAY_OF_WEEK);
		int count = startDay - 1;
		output = "Sun Mon Tue Wed Thu Fri Sat\n";
		output += fillSpace(startDay);
		
		// fill in the date number in the returned string
		int maxDay = maxDayInMonth(year, month);
		for (int i = 1; i <= maxDay; i++) { 
			output += i > 9 ? " " : "  ";
			output += i;
			output += " ";
			count++;
			if (count >= 7) {
				count = 0;
				output += "\n";
			}
		}
		
		return output;
	}
	
	/***
	 * Giving the appropriate spaces according to start day
	 * 
	 * @param startDay: desired start day
	 * @return output: space string
	 * * Example: mySystem.fillSpace(6): return 4*5 spaces string
	 * * Time estimate: O(n)
	 */
	private String fillSpace(int startDay) {
		String output = "";
		for (int i = 1; i < startDay; i++) {
			output += "    ";
		}
		return output;
	}
	
	/***
	 * Check the max number of day of given month
	 * 
	 * @param Year: desired year
	 * @param Month: desired month
	 * @return max: the max number of day of given month
	 * * Example: mySystem.maxDayInMonth(2000, 2): return 29
	 * * Time estimate: O(1)
	 */
	private int maxDayInMonth(int Year, int Month) {
		int max = 30;
		if (Month == 1 | Month == 3 | Month == 5 | Month == 7 | Month == 8 | Month == 10 | Month == 12)
			max = 31;
		else if (Month == 2 & (Year % 4 == 0) && (Year % 100 != 0) || (Year % 400 == 0))
			max = 29;
		else if (Month == 2)
			max = 28;
		return max;
	}

	/***
	 * Get the date string input by user
	 * 
	 * @param none
	 * @return str: the string user text on console
	 * * Example: user input: 2022/1/1 return "2022/1/1" 
	 * * Time estimate: O(1)
	 */
	public String getDateString() {
		printStream.print("請輸入欲查詢日期(年/月/日):");
		String str = in.nextLine();
		while(validDate(str) == false) {
			printStream.print("請輸入欲查詢日期(年/月/日):");
			str = in.nextLine();
		}
		return str;
	}

	/***
	 * Check if the date string is valid
	 * 
	 * @param str: giving string
	 * @return true when valid, false when invlaid
	 * * Example: mySystem.validDate("2022/13/1"): false 
	 * * Time estimate: O(1)
	 */
	public boolean validDate(String str) {
		int cntSlash = 0;
		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == '/')
				cntSlash++;
		if (cntSlash != 2)
			return false;
		else {
			String[] tokens = str.split("/");
			int[] num = new int[3];
			num[0] = Integer.parseInt(tokens[0]);
			num[1] = Integer.parseInt(tokens[1]);
			num[2] = Integer.parseInt(tokens[2]);
			if (num[1] > 12 || num[2] > maxDayInMonth(num[0], num[1]))
				return false;
			else
				return true;
		}
	}
	
	/***
	 * Get the year string input by user
	 * 
	 * @param none
	 * @return str: the string user text on console
	 * * Example: user input: 2022 return "2022" 
	 * * Time estimate: O(1)
	 */
	public String getYearString() {
		printStream.print("請輸入欲查詢年:");
		String input = in.nextLine();
		while(isNumeric(input) == false) {
			printStream.print("請輸入欲查詢年:");
			input = in.nextLine();
		}
		return input;
	}
	
	/***
	 * Check if the string is numeric
	 * 
	 * @param str: giving string
	 * @return true when is numeric, or false
	 * * Example: mySystem.isNumeric("2000."): return false
	 * * Time estimate: O(1)
	 */
	public boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/***
	 * Acquire the date string and output the desired monthly calendar string
	 * 
	 * @param none
	 * @return none  
	 * * Example: mySystem.funcA(): input("2022/1/1"): output monthly calendar 
	 * *Time estimate: O(1)
	 */
	public void funcA() {
		String str = getDateString();
		String[] tokens = str.split("/");
		int[] num = new int[3];
		num[0] = Integer.parseInt(tokens[0]);
		num[1] = Integer.parseInt(tokens[1]);
		printStream.println(printCalendar(num[0], num[1]));
	}

	/***
	 * Acquire the year string and output the yearly 
	 * heavenly-stem and earthly-branch string
	 * 
	 * @param none
	 * @return none 
	 * * Example: mySystem.funcB(): input("2022"):
	 * output: "2022是壬寅年，屬虎"
	 * * Time estimate: O(1)
	 */
	public void funcB() {
		String input = getYearString();
		int y = Integer.parseInt(input);
		int key = (y - 3) % 60;
		printStream.println(y + "是" + searchA(key) + searchB(key));
	}

	/***
	 * Return a heavenly-stem year string
	 * by the given keys
	 * 
	 * @param key: factor of heavely-stem formula
	 * @return output: heavenly-stem string 
	 * * Example: mySystem.searchA(5): return "戊" 
	 * * Time estimate: O(1)
	 */
	private String searchA(int key) {
		String output = "";
		switch (key % 10) {
		case 1:
			output = "甲";
			break;
		case 2:
			output = "乙";
			break;
		case 3:
			output = "丙";
			break;
		case 4:
			output = "丁";
			break;
		case 5:
			output = "戊";
			break;
		case 6:
			output = "己";
			break;
		case 7:
			output = "庚";
			break;
		case 8:
			output = "辛";
			break;
		case 9:
			output = "壬";
			break;
		default:
			output = "癸";
		}
		return output;
	}

	/***
	 * Return a earthly-branch year string
	 * by the given keys
	 * 
	 * @param key: factor of earthly-branch formula
	 * @return output: earthly-branch string 
	 * * Example: mySystem.searchA(5): return "辰年，屬龍" 
	 * * Time estimate: O(1)
	 */
	private String searchB(int key) {
		String output = "";
		switch (key % 12) {
		case 1:
			output = "子年，屬鼠";
			break;
		case 2:
			output = "丑年，屬牛";
			break;
		case 3:
			output = "寅年，屬虎";
			break;
		case 4:
			output = "卯年，屬兔";
			break;
		case 5:
			output = "辰年，屬龍";
			break;
		case 6:
			output = "巳年，屬蛇";
			break;
		case 7:
			output = "午年，屬馬";
			break;
		case 8:
			output = "未年，屬羊";
			break;
		case 9:
			output = "申年，屬猴";
			break;
		case 10:
			output = "酉年，屬雞";
			break;
		case 11:
			output = "須年，屬狗";
			break;
		default:
			output = "亥年，屬豬";
		}
		return output;
	}

	/***
	 * Acquire the date string and output the date from today to 
	 * the added day
	 * 
	 * @param none
	 * @return none 
	 * * Example: mySystem.funcC(): 請輸入欲查詢日期(年/月/日):2022/03/27 :輸出
	 * 	"2022/03/27距離今天還有1天" 
	 * * Time estimate: O(1)
	 */
	public void funcC() {
		String str = getDateString();
		String[] tokens = str.split("/");
		int[] num = new int[3];
		num[0] = Integer.parseInt(tokens[0]);			
		num[1] = Integer.parseInt(tokens[1]);
		num[2] = Integer.parseInt(tokens[2]);
				
		String date1 = num[0] + "-" + (num[1] > 9 ? num[1] : "0" + num[1]) + "-"
			+ (num[2] > 9 ? num[2] : "0" + num[2]);
		Date d = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(d);
		String date2 = calendar.get(Calendar.YEAR) + "-"
			+ ((calendar.get(Calendar.MONTH) + 1) > 9 ? calendar.get(Calendar.MONTH) + 1
			: "0" + (calendar.get(Calendar.MONTH) + 1))
			+ "-" + (calendar.get(Calendar.DAY_OF_MONTH) > 9 ? calendar.get(Calendar.DAY_OF_MONTH)
			: "0" + calendar.get(Calendar.DAY_OF_MONTH));
		LocalDate date_1 = LocalDate.parse(date1);
		LocalDate date_2 = LocalDate.parse(date2);
		printStream.println(str + "距離今天還有" + ChronoUnit.DAYS.between(date_2, date_1) + "天");
	}
	
	
	/***
	 * 判斷輸入的天數是否合法，如果合法便輸出往後＃天的日期，如果不合法便要求用戶重新輸入
	 * 
	 * @param none
	 * @return none 
	 * * Example: mySystem.funcD(): 請輸入往後推算的天數：10000 :
	 *         輸出"往後10000天是2049/08/11" 
	 * * Time estimate: O(1)
	 */
	public void funcD() {
		printStream.print("請輸入往後推算的天數:");
		String input = in.nextLine();
		int days;
		while(isNumeric(input) == false) {
			printStream.print("請輸入往後推算的天數:");
			input = in.nextLine();
		}
		days = Integer.parseInt(input);
		Calendar now = Calendar.getInstance();
		now.set(Calendar.DATE, now.get(Calendar.DATE) + days);
		printStream.println("\n往後" + days + "天是" + now.get(Calendar.YEAR) + "/"
				+ ((now.get(Calendar.MONTH) + 1) > 9 ? now.get(Calendar.MONTH) + 1
						: "0" + (now.get(Calendar.MONTH) + 1))
				+ "/" + (now.get(Calendar.DAY_OF_MONTH) > 9 ? now.get(Calendar.DAY_OF_MONTH)
						: "0" + now.get(Calendar.DAY_OF_MONTH)));
	}
	
	/***
	 * 日曆系統的菜單
	 * 
	 * @param none
	 * @return none 
	 * * Example: 輸入Ａ: call funcA() 
	 * * Time estimate: O(1)
	 */
	public void start() {
		while (true) {
			printStream.println("輸入指令號碼或 E(結束使用)?\n");
			printStream.println("輸入指令:");
			printStream.println("1): A 顯示該月月曆");
			printStream.println("2): B 西元轉換干支、生肖");
			printStream.println("3): C 計算天數");
			printStream.println("4): D 計算日期");
			printStream.println("5): E 離開");
			char cmd = in.nextLine().charAt(0);
			if (cmd == 'A') {
				funcA();
			} else if (cmd == 'B') {
				funcB();
			} else if (cmd == 'C') {
				funcC();
			} else if (cmd == 'D') {
				funcD();
			} else if (cmd == 'E') {
				break;
			}
		}
		in.close();
		printStream.println("離開系統");
	}
	/***
	 * Main function 
	 * 
	 * @param args contains the supplied command-line arguments as an array of
	 *             String objects.
	 * @return none 
	 * * Example: 輸入Ａ: call funcA() 
	 * * Time estimate: O(1)
	 */
	public static void main(String[] args) {
		mySystem ms = new mySystem(System.in, System.out);
		ms.start();
	}
}