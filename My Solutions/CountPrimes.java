import java.util.BitSet;


public class CountPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountPrimes cp = new CountPrimes();
		System.out.println(cp.countPrimes(4));

	}
	
    public int countPrimes(int n) {
        
        if (n < 2) return 0;
        
        BitSet set = new BitSet(n);
        set.set(0, 2);
        
        for (int i = 2; i < n; i++) {
            if (!set.get(i)) {
                for (int j = i * 2; j < n; j += i) {
                    set.set(j);
                }
            }
        }
        
        return n - set.cardinality();
    }

}
