public class MaxProfit {
    // 核心原理：记录之前的最小值，用当前值减去之前的最小值
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 计算当前位置的最大profit
            profit = Math.max(profit, prices[i] - min);
            // 更新最小值
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
