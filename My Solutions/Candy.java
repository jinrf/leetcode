import java.util.*;

public class Candy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test = { 1, 2, 2};
		Candy c = new Candy();
		System.out.print(c.candy(test));
	}

	public int candy(int[] ratings) {
		int len = ratings.length;
		if (len < 2)
			return len; // 0 -> 0, 1 -> 1;

		int[] candies = new int[len];
		Arrays.fill(candies, 1);

		Map<Integer, List<Integer>> m = new HashMap<>();

		for (int i = 0; i < len; i++) {
			if (m.containsKey(ratings[i])) {
				m.get(ratings[i]).add(i);
			} else {
				List<Integer> l = new ArrayList<>();
				l.add(i);
				m.put(ratings[i], l);
			}
		}

		Integer[] rs = m.keySet().toArray(new Integer[0]);
		Arrays.sort(rs);

		for (int i = 1; i < rs.length; i++) { //skip the lowest rating
			List<Integer> l = m.get(rs[i]);
			for (int j : l) {
				if (j - 1 >= 0 && candies[j] <= candies[j - 1])
					candies[j] = candies[j - 1] + 1;
				if (j + 1 < len && candies[j] <= candies[j + 1])
					candies[j] = candies[j + 1] + 1;
			}
		}

		int sum = 0;
		for (int i : candies)
			sum += i;
		return sum;
	}
}
