import java.util.Arrays;

public class SortColor {

	public static void main(String[] args) {
		SortColor sc = new SortColor();
		int[] test = { 0 };
		sc.sortColors(test);
	}

	public void sortColors(int[] A) {
		// countSort(A);
		onePassSort(A);
	}

	public void onePassSort(int[] A) {
		int len = A.length;
		int head = 0, tail = len - 1;
		int curr = 0;
		while (curr <= tail) {
			switch (A[curr]) {
			case 0:
				A[curr++] = A[head];
				A[head++] = 0;
				break;
			case 1:
				curr++;
				break;
			case 2:
				A[curr++] = A[tail];
				A[tail--] = 2;
				break;
			}
		}
	}

	public void countSort(int[] A) {
		int count0 = 0, count1 = 0, count2 = 0;
		for (int i = 0; i < A.length; i++) {
			switch (A[i]) {
			case 0:
				count0++;
				break;
			case 1:
				count1++;
				break;
			case 2:
				count2++;
				break;
			}
		}

		int i = 0;
		while (count0-- > 0) {
			A[i++] = 0;
		}

		while (count1-- > 0) {
			A[i++] = 1;
		}

		while (count2-- > 0) {
			A[i++] = 2;
		}

	}

}