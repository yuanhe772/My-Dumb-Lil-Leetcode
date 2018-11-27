class Solution {
    
    // 法一： Brute Force
    // public int maxProfit(int[] prices) {
    //     int len = prices.length;
    //     int max_diff = 0;
    //     // My stupid solution:
    //     for(int i=0; i<len; i++){
    //         for(int j=i+1; j<len; j++){ // 因为是两层循环，所以j的上限和i一样
    //             if(prices[i]<prices[j] && (prices[j] - prices[i])>max_diff){
    //                 max_diff = prices[j] - prices[i];
    //             }
    //         }
    //     }
    //     return max_diff;
    // }
    
//     // 法二：DP1 (相当于keep 一个 max_profic 和一个 min_buy)
       // 今天的值和min比
    
//     public int maxProfit(int[] prices){
        
//         if(prices == null || prices.length == 0) return 0;
        
//         int min = prices[0];
//         int[] dp = new int[prices.length];
//         dp[0] = 0;
        
//         for(int i=1; i<prices.length; i++){
//             if(prices[i]>min){
//                 dp[i] = Math.max(dp[i-1], prices[i] - min);                
//             }
//             else{
//                 dp[i] = dp[i-1];
//                 min = prices[i];
//             }
//         }
//         return dp[prices.length-1];
//     }
    
    
//     // 法三：DP2:
//     // 今天的值和昨天的比
//     public int maxProfit(int[] prices){
//         if(prices == null || prices.length == 0) return 0;
        
//         int min = prices[0];
//         int[] dp = new int[prices.length];
        
//         dp[0] = 0;
        
//         for(int i=1; i<prices.length; i++){
//             if(prices[i] > prices[i-1]){
//                 dp[i] = Math.max(dp[i-1], prices[i] - min);
//             }
//             else{
//                 dp[i] = dp[i-1];
//                 min = Math.min(prices[i], min);
//             }
//         }
//         return dp[prices.length-1];
//     }
// }

// 法四：DP3：
// 其实简单的画个图一句话就搞定了呀：

public int maxProfit(int[] prices) {
    if(prices == null || prices.length == 0) return 0;

    int min = prices[0];
    int[] dp = new int[prices.length];
    dp[0] = 0;

    for(int i=1; i<prices.length; i++){
        dp[i] = Math.max(dp[i-1], prices[i] - min);
        min = Math.min(prices[i], min);
    }
    return dp[prices.length-1];
}
