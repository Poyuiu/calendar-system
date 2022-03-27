package CalendarSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class mySystem {
	/***
	 * 印出指定年月的日曆
	 * @param Year 年
	 * @param Month 月
	 * @return none
	 *  * Example: mySystem.printCalendar(2022, 3): print calendar of this date
	 * Time estimate: O(n)
	 */
	public  String printCalendar(int Year, int Month) {
		int year = Year;
		int month = Month;
		String output;
		// input
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		int startDay = calendar.get(Calendar.DAY_OF_WEEK); 
		int count = startDay - 1; 
		int maxDay = maxDayInMonth(year, month);
		output = "Sun Mon Tue Wed Thu Fri Sat\n";
		output += fillSpace(startDay);
		for (int i = 1; i <= maxDay; i++) {
			output += i>9?" ":"  ";
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
	 * 在本月的起始天之前加入空格
	 * @param startDay 起始日期
	 * @return none
	 *  * Example: mySystem.fillSpace(6): print 4*5 spaces
	 *  Time estimate: O(n)
	 */
	private   String fillSpace(int startDay) {
		String output = "";
		for (int i = 1; i < startDay; i++) {
			output += "    ";
		}
		return output;
	}
	/***
	 * 查詢這個月份最多有幾天
	 * @param year 年
	 * @param month 月
	 * @return max 是該月的最大天數
	 * Time estimate: O(1)
	 */
	public  int maxDayInMonth(int year, int month) {
		int max = 30;
		if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12)
			max = 31;
		else if (month == 2 & (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
			max = 29;
		else if (month == 2)
			max = 28;
		return max;
	}
	/***
	 * 輸入日期字串
	 * @param none
	 * @return 日期字串
	 * * Example: 請輸入欲查詢日期(年/月/日):2022/1/1:
	 *   return "2022/1/1"
	 * Time estimate: O(1)
	 */
	public String getDateString() {
		System.out.print("請輸入欲查詢日期(年/月/日):");
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		return str;
	}
	/***
	 * 判斷日期字串是不是合法，是return true，不是return false
	 * @param str
	 * @return whether the date string is valid
	 * * Example: mySystem.validDate("2022/13/1"): false
	 * Time estimate: O(1)
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
			else return true;
		}
	}
	/*** 判斷日期是否合法，如果合法便印出該日期的日曆，否則便要求用戶重新輸入
	 * @param none
	 * @return none
	 * * Example: 請輸入欲查詢日期(年/月/日): 2022/03/26: 輸出對應月曆
	 * Time estimate: O(n)
	 */
	public String funcA() {
		String str = getDateString();
		String output = "";
		if(validDate(str)) {
			String[] tokens = str.split("/");
			int[] num = new int[3];
			num[0] = Integer.parseInt(tokens[0]);
			num[1] = Integer.parseInt(tokens[1]);
				output += printCalendar(num[0], num[1]);
				output += "\n";
			}
		else {
			funcA();
		}
		return output;
	}
	/***
	 * 判斷年份是否合法，如果合法便印出該年對應的天干地支生肖，否則要求用戶重新輸入
	 * @param none
	 * @return none
	 * * Example: 請輸入欲查詢年:2022: 輸出"2022是壬寅年，屬虎"
	 * Time estimate: O(1)
	 */
	public String funcB() {
		String output = "";
		System.out.print("請輸入欲查詢年:");
		Scanner in = new Scanner(System.in);
		String input = in.next();
//		in.close();
		int y;
		try {
			y = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			funcB();
			return output;
		}
		int key = (y - 3) % 60;
		output += y + "是" + searchA(key) + searchB(key) + "\n";
		return output;
	}
	/***
	 * 利用key查詢該年的天干並印出
	 * @param key 公式的解
	 * @return none
	 * * Example: mySystem.searchA(5): 輸出"戊"
	 * Time estimate: O(1)
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
	 * 利用key查詢該年的地支和生肖並印出
	 * @param key 公式的解
	 * @return none
	 * * Example: mySystem.searchB(5): 輸出"辰年，屬龍"
	 * Time estimate: O(1)
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
	 * 判斷輸入日期是否合法，如果合法便印出距離今天幾天，若不合法便要求用戶重新輸入
	 * @param none
	 * @return none
	 * * Example: mySystem.funcC(): 請輸入欲查詢日期(年/月/日):2022/03/27 :輸出
	 * "2022/03/27距離今天還有1天"
	 * Time estimate: O(1)
	 */
	public  void funcC() {
		System.out.print("請輸入欲查詢日期(年/月/日):");
		Scanner in = new Scanner(System.in);
//		in.close();
		String str = in.nextLine();
		int cntSlash = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '/') {
				cntSlash++;
			}
		}
		if (cntSlash != 2)
			funcC();
		else {
			String[] tokens = str.split("/");
			int[] num = new int[3];
			num[0] = Integer.parseInt(tokens[0]);
			num[1] = Integer.parseInt(tokens[1]);
			num[2] = Integer.parseInt(tokens[2]);
			if (num[1] > 12 || num[2] > maxDayInMonth(num[0], num[1])) {
				funcC();
			} else {
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
//				System.out.println(date1);
//				System.out.println(date2);
				LocalDate date_1 = LocalDate.parse(date1);
				LocalDate date_2 = LocalDate.parse(date2);
				System.out.println(str + "距離今天還有" + ChronoUnit.DAYS.between(date_2, date_1) + "天");
			}
		}
	}
	/***
	 * 判斷輸入的天數是否合法，如果合法便輸出往後＃天的日期，如果不合法便要求用戶重新輸入
	 * @param none
	 * @return none
	 * * Example: mySystem.funcD(): 請輸入往後推算的天數：10000 :
	 * 輸出"往後10000天是2049/08/11"
	 * Time estimate: O(1)
	 */
	public  void funcD() {
		System.out.print("請輸入往後推算的天數：");
		Scanner in = new Scanner(System.in);
		String input = in.next();
		int days;
		try {
			days = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			funcD();
			return;
		}
		Calendar now = Calendar.getInstance();
		now.set(Calendar.DATE, now.get(Calendar.DATE) + days);
		System.out.println("\n往後" + days + "天是" + now.get(Calendar.YEAR) + "/"
				+ ((now.get(Calendar.MONTH) + 1) > 9 ? now.get(Calendar.MONTH) + 1
						: "0" + (now.get(Calendar.MONTH) + 1))
				+ "/" + (now.get(Calendar.DAY_OF_MONTH) > 9 ? now.get(Calendar.DAY_OF_MONTH)
						: "0" + now.get(Calendar.DAY_OF_MONTH)));

	}
	/***
	 * 日曆系統的菜單
	 * @param args contains the supplied command-line arguments as an array of String objects.
	 * @return none
	 * * Example: 輸入Ａ: call funcA()
	 * Time estimate: O(n)
	 */
	public static void main(String[] args) {
		while (true) {
			System.out.println("輸入指令號碼或 E(結束使用)?\n");
			System.out.println("輸入指令:");
			System.out.println("1): A 顯示該月月曆");
			System.out.println("2): B 西元轉換干支、生肖");
			System.out.println("3): C 計算天數");
			System.out.println("4): D 計算日期");
			System.out.println("5): E 離開");
			Scanner in = new Scanner(System.in);
			char cmd = in.nextLine().charAt(0);
//			in.close();
			mySystem ms = new mySystem(); 
			if (cmd == 'A') {
				System.out.print(ms.funcA());
			} else if (cmd == 'B') {
				System.out.print(ms.funcB());
			} else if (cmd == 'C') {
				ms.funcC();
			} else if (cmd == 'D') {
				ms.funcD();
			} else if (cmd == 'E') {
				break;
			}
		}
//	System.out.println("�x�_ϵ�y");
		System.out.println("離開系統");

	}
}