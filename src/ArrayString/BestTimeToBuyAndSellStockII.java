package ArrayString;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int currPrice = -1;
        int length = prices.length;
        int maxProfit = 0;
        for(int i = 0; i < length; i++) {
            if (i == 0) {
                currPrice = prices[i];
            } else if (i == length - 1) {
                if (prices[i] > currPrice) {
                    maxProfit += prices[i] - currPrice;
                }
            } else {
                if (currPrice > prices[i]) {
                    currPrice = prices[i];
                }
                else if (prices[i] >= prices[i-1] && prices[i] >= prices[i+1]) {
                    maxProfit += prices[i] - currPrice;
                    currPrice = prices[++i];
                }
            }
        }
        return maxProfit;
    }
}
