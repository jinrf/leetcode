public class TrappingRainWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TrappingRainWater trw = new TrappingRainWater();
		trw.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });

	}

	public int trap(int[] height) {
		int i = 0, j = height.length - 1, sum = 0, curr = 0;
		while (i < j) {
			int min = Math.min(height[i], height[j]);
			if (curr < min)
				curr = min;
			if (height[i] < height[j]) {
				sum += curr - height[i++];
			} else {
				sum += curr - height[j--];
			}
		}
		return sum;
	}

}
