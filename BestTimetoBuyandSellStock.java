class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int low=Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(low>prices[i]){
                low=prices[i];
            }
            max=Math.max(max, prices[i] -low);
        }

        return max;
    }
}