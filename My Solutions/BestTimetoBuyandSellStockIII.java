public class BestTimetoBuyandSellStockIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

	private int[] prices;

	public int maxProfit(int[] prices) {

		int p = 0;
		this.prices = prices;
		for (int i = 2; i < prices.length - 2; i++) {
			p = Math.max(p, maxProfit(0, i) + maxProfit(i, prices.length));
		}

		return p;
	}

	private int maxProfit(int start, int end) {
		int p = 0;
		for (int i = start; i < end - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				p += prices[i + 1] - prices[i];
			}
		}

		return p;
	}

}
