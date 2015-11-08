import java.util.*;

public class MaxPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxPoint mp = new MaxPoint();

		Point[] p = new Point[3];
		p[0] = new Point(2, 3);
		p[1] = new Point(3, 3);
		p[2] = new Point(-5, 3);

		System.out.println(mp.maxPoints(p));
	}

	public int maxPoints(Point[] points) {
		int len = points.length;
		if (len < 2)
			return len;
		int max = 0;

		for (int i = 0; i < len; i++) {
			Map<Double, Integer> m = new HashMap<>();
			int overlap = 1, maxV = 0, maxSlope = 0;
			for (int j = i + 1; j < len; j++) {
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					overlap++;
				} else if (points[i].x == points[j].x) {
					int count = m.containsKey(Double.MAX_VALUE) ? m
							.get(Double.MAX_VALUE) : 0;
					m.put(Double.MAX_VALUE, ++count);
					maxV = Math.max(maxV, count);
				} else {
					double slope = points[i].y == points[j].y? 0: (double) (points[i].y - points[j].y)
							/ (double) (points[i].x - points[j].x);
					int count = m.containsKey(slope) ? m.get(slope) : 0;
					m.put(slope, ++count);
					maxSlope = Math.max(maxSlope, count);
				}
			}
			max = Math.max(max, maxV + overlap);
			max = Math.max(max, maxSlope + overlap);
		}
		return max;
	}

}
