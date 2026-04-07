package ArrayString;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int bestPrice = -1;
        int maxProfit = 0;
        for (int price : prices) {
            if (bestPrice == -1 || price < bestPrice) {
                bestPrice = price;
            }
            int currProfit = price - bestPrice;
            maxProfit = Math.max(maxProfit, currProfit);
        }
        return maxProfit;
    }
}
