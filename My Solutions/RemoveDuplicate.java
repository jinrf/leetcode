public class RemoveDuplicate {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 1, 2,2 }));
	}

	public static int removeDuplicates(int[] A) {

		int len = A.length;
		if (len < 2)
			return len;

		int i = 0, j = 1;

		while (i < len && j < A.length) {
			while (A[i] == A[j]) {
				len--;
				if (j < A.length - 1) {
					j++;
				} else {
					return len;
				}
			}
			A[++i] = A[j++];
		}
		return len;
	}
}
