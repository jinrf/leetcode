import java.util.Arrays;

public class PlusOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		plusOne(new int[] { 0 });

	}

	public static int[] plusOne(int[] digits) {

		int len = digits.length;
		int newdigits[] = new int[len + 1];
		int carry = 0, sum = 0;
		for (int i = len - 1; i >= 0; i--) {
			sum = digits[i] + carry;
			if (sum > 9) {
				carry = 1;
				newdigits[i + 1] = sum % 10;
			} else {
				carry = 0;
				newdigits[i + 1] = sum;
			}
		}
		if (carry == 1) {
			newdigits[0] = 1;
			return newdigits;
		} else
			return Arrays.copyOfRange(newdigits, 1, len + 1);
	}

}
