public class SmartDate {

	private static final int[] DAYS_IN_MONTHS = { -1, 31, 29, 31, 30, 31, 30,
			31, 31, 30, 31, 30, 31 };

	private final int day;
	private final int month;
	private final int year;
	
	public SmartDate(int day, int month, int year) {
		checkMonth(month);
		checkDay(day, month, year);
		this.day = day;
		this.month = month;
		this.year = year;
	}

	private static void checkDay(int day, int month, int year) {
		if (notFebruary(month)) {
			if (day >= 1 && day <= DAYS_IN_MONTHS[month]) {
				return;
			}
			throw new IllegalArgumentException("day out of range");
		}

		if (isLeapYear(year)) {
			if (day >= 1 && day <= 29) {
				return;
			}
			throw new IllegalArgumentException("day out of range for Feb");
		}

		if (day >= 1 && day <= 28) {
			return;
		}
		throw new IllegalArgumentException("day out of range for Feb");

	}

	private static boolean isLeapYear(int y) {
		if (y % 400 == 0)
			return true;
		if (y % 100 == 0)
			return false;
		return y % 4 == 0;
	}

	private static boolean notFebruary(int month) {
		return month != 2;
	}

	private static void checkMonth(int month) {
		if (month >= 1 && month <= 12) {
			return;
		}
		throw new IllegalArgumentException("month must be value from 1 to 12");
	}

	
	
	public static void main(String[] args) {
		
		String[] params = args[0].split("/");
		int day = Integer.parseInt(params[0]);
		int month = Integer.parseInt(params[1]);
		int year = Integer.parseInt(params[2]);
		
		SmartDate smartDate = new SmartDate(day, month, year);
		StdOut.println(smartDate.dayOfTheWeek());
		
	}

	public String dayOfTheWeek() {
		int days = daysSinceStartOfTwentyFirstCentury();
		return convertDayToWeekDay(days);
	}
	
	static String convertDayToWeekDay(int day) {
		int dayCode = (day + 4) % 7 + 1;
		if(dayCode == 1) {
			return "Monday";
		}
		if(dayCode == 2) {
			return "Tuesday";
		}
		if(dayCode == 3) {
			return "Wednesday";
		}
		if(dayCode == 4) {
			return "Thursday";
		}
		if(dayCode == 5) {
			return "Friday";
		}
		if(dayCode == 6) {
			return "Saturday";
		}
		if(dayCode == 7) {
			return "Sunday";
		}
		
		throw new IllegalStateException("could not relove day of week");

	}
	
	private int daysSinceStartOfTwentyFirstCentury() {
		int dayCount = 0;
		for(int i = 2000; i < year; i++) {
			dayCount += daysInYear(i);
		}
		dayCount += daysSoFarInThisYear();
		return dayCount;
	}
	
	private static int daysInYear(int year) {
		if(isLeapYear(year)) {
			return 366;
		}
		return 365;
	}
	
	private int daysSoFarInThisYear() {
		
		int dayCount = 0;
		for(int m = 1; m < month; m++) {
			dayCount += daysInMonth(m, year);
		}
		dayCount += day;
		return dayCount;
		
	}

	private static int daysInMonth(int month, int year) {
		if(notFebruary(month)) {
			return DAYS_IN_MONTHS[month];
		} 
		return daysInFebruary(year);
		
	}
	
	private static int daysInFebruary(int year) {
		if(isLeapYear(year)) {
			return 29;
		}
		return 28;
	}

}
