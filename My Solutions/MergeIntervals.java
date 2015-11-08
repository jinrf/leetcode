import java.util.*;

public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		
	}

	public List<Interval> merge(List<Interval> intervals) {

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.start, i2.start);
			}
		});

		return intervals;

	}
}
