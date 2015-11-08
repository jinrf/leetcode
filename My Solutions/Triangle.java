import java.util.*;

public class Triangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumTotal(List<List<Integer>> triangle) {

		int n = triangle.size();
		int[] cost = new int[n + 1]; // for the initial case

		for (int i = n - 1; i > 0; i--) {
			List<Integer> level = triangle.get(i);
			for (int j = 0; j < level.size(); j++) {
				cost[j] = Math.min(cost[j] + level.get(j), cost[j+1] + level.get(j));
			}
		}

		return cost[0];
	}
}
