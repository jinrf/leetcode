import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class LargestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String largestNumber(int[] num) {
        int len = num.length;
        List<String> nums = new ArrayList<>();
        
        for (int i: num) nums.add(Integer.toString(i));
        Collections.sort(nums, new MyComparator());
        
        StringBuilder sb = new StringBuilder();
        for (String n: nums){
            sb.append(n);
        }
        
        return sb.toString();
    }
    
    class MyComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return (a+b).compareTo(b+a);
        }
    }
    
}


