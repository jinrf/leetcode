public class ReverseString {

	public static void main(String[] args) {
		String s = "Welcome";
		System.out.println(reverse(s));
		
		System.out.println(fib(5));
		
		System.out.println(formatRGB(123,211,40));
	}

	public static String reverse(String str) {

		char[] chars = str.toCharArray();
		int len = chars.length;

		for (int i = 0; i < len / 2; i++) {
			char tmp = chars[i];
			chars[i] = chars[len - 1 - i];
			chars[len - 1 - i] = tmp;
		}

		return new String(chars);
	}

	public static int fib(int n) {
		return n<2?1:fib(n-1)+fib(n-2);
	}
	
	public static String formatRGB ( int r, int g, int b ) {
        return String.format ( "%02X%02X%02X", r, g, b );
    }
}
