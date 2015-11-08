import java.util.*;

public class InsertInterval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InsertInterval ii = new InsertInterval();
		List<Interval> l = new LinkedList<>();
		l.add(new Interval(2, 4));
		l.add(new Interval(5, 7));
		l.add(new Interval(8, 10));
		l.add(new Interval(11, 13));
		List<Interval> ret = ii.insert(l, new Interval(3, 8));

		return;

	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> ret = new LinkedList<>();
		int len = intervals.size();
		if (len == 0) {
			ret.add(newInterval);
			return ret;
		}

		if (newInterval.end < intervals.get(len - 1).start) {
			ret.add(newInterval);
			ret.addAll(intervals);
			return ret;
		}

		if (newInterval.start > intervals.get(len - 1).end) {
			ret.addAll(intervals);
			ret.add(newInterval);
			return ret;
		}

		int i = 0, start = 0, end = 0;
		while (i < len) {
			Interval in = intervals.get(i);
			if (newInterval.start > in.end) {
				i++;
				ret.add(in);
			} else {
				start = Math.min(newInterval.start, in.start); // record the
																// starting
																// point
				break;
			}
		}

		while (i < len) {
			Interval in = intervals.get(i);
			if (newInterval.end >= intervals.get(i).start)
				i++;
			else {
				end = Math.max(newInterval.end, in.end); // record the starting
															// point
				break;
			}
		}
		ret.add(new Interval(start, end));
		i++;
		while (i < len)
			ret.add(intervals.get(i++));
		return ret;
	}

}
