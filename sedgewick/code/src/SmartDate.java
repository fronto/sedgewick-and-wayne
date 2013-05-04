public class SmartDate {

	private static final int[] DAYS_IN_MONTHS = { -1, 31, 29, 31, 30, 31, 30,
			31, 31, 30, 31, 30, 31 };

	public SmartDate(int day, int month, int year) {
		checkMonth(month);
		checkDay(day, month, year);
	}

	private static void checkDay(int day, int month, int year) {
		if (notFebruary(month)) {
			if (day >= 1 && day <= DAYS_IN_MONTHS[month]) {
				return;
			}
			throw new IllegalArgumentException("day out of range");
		}

		if (isLeapYear(year)) {
			if (day >= 1 && day <= 28) {
				return;
			}
			throw new IllegalArgumentException("day out of range for Feb");
		}

		if (day >= 1 && day <= 29) {
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
		
	}
	
}
