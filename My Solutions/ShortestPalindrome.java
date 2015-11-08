public class ShortestPalindrome {

	public static void main(String[] args) {
		ShortestPalindrome sp = new ShortestPalindrome();
		System.out.println(sp.shortestPalindrome("abb"));
	}

	public String shortestPalindrome(String s) {
        
        int len = s.length();
        if (len <= 1) return s;
        
        
        int i = (len - 1) / 2;
        for (; i >= 0; i--) {
            if (isPalindrome(s, i, i + 1)) {
                i = i * 2 + 1;
                break;
            }
            if (isPalindrome(s, i, i)) {
                i = i * 2;
                break;
            }
        }
        String suffix = s.substring(i + 1);
        return new StringBuilder(suffix).reverse().toString() + s;
        
    }
    	
    private boolean isPalindrome(String s, int i, int j) {
        while (i >=0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i--;
            j++;
        }
        return i < 0;
    }
}
