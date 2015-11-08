import java.util.*;

public class HappyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.isHappy(7));

	}

	public boolean isHappy(int n) {

		Set<Integer> s = new HashSet<>();

		while (!s.contains(n)) {
			s.add(n);
			n = sumOfSqures(n);
			if (n == 1)
				return true;
			
		}

		return false;
	}

	int sumOfSqures(int n) {
		int sum = 0;
		while (n > 0) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		return sum;
	}

}
