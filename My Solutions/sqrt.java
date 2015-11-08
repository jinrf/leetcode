public class sqrt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print(newton(2147395599));
	}

	public static int newton(int x) {
		if (x < 2)
			return x;
		long y = x >> 1;
		long dy = (long) (y * y - x);
		while (dy > 0){
			y -= (dy - 1) / (y << 1) + 1;
			dy = y * y - x;
		}
			
		return (int)y;
	}

}
