import java.util.*;

public class PhoneInterview {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PhoneInterview pi = new PhoneInterview();

		pi.myTest();

	}

	private void myTest() {

		List<Integer> testList = new LinkedList<>();
		int[] testArray = new int[] { 1, 2, 3, 4 };
		testList.subList(0, 1);
		Arrays.sort(testArray);
		Collections.sort(testList);
		Collections.reverse(testList);
	}
	
	public boolean isParlindrome(String s) {

		if (s == null) return false;
		int n = s.length();
		if (n < 2) return true;

		int i = 0, j = n - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) return false;
		}
		return true;
	}
	
	class Averager {

		int nWnd;
		Queue<Double> values;
		
		public Averager(int n) {
			nWnd = n;
			values = new LinkedList<>();
		}
		
		public double addValue(double num) {
			int len = values.size();
			if (len < nWnd) values.add(num);
			else {
				values.remove();
				values.add(num);
			}
			return getAvg(); 		
		}

		private double getAvg() {
			double sum = 0;
			for (Double v: values) {
				sum += v;
			}
			return sum / values.size();
		}
	}

}