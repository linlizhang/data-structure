package alg;

public class DaysCalculation {
	
	private static final int[] DAYS_OF_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int dayOfYear(int year, int month, int day) {
		assert year > 0;
		assert month > 0 && month <= 12;
		assert day > 0 && day <= DAYS_OF_MONTH[month];
		
		int daysOfYear = daysBeforeMonth(month) + day + (isLeap(year) ? 1 : 0);
		
		return daysOfYear;
	}
	
	
	private boolean isLeap(int year) {
		return year % 400 ==0 || (year % 100 != 0 && year % 4 == 0);
	}
	
	private int daysBeforeMonth(int month) {
		int sum = 0;
		for (int i = 0; i < month -1; i--) {
			sum += DAYS_OF_MONTH[i];
		}
		return sum;
	}

}
