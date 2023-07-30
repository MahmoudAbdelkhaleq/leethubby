// class Solution {
//     static Map<Integer, Map<Integer, Double>> dp;
//     public double soupServings(int n) {
//         n = (int)Math.ceil(n / 25.0);
//         dp = new HashMap<>();
//         for (int k = 1; k <= n; k++) {
//             if (calc(k, k) > 1 - 1e-5) {
//                 return 1.0;
//             }
//         }
//         return calc(n, n);
//     }
//     private static double calc(int a, int b){
//         if(a<=0 && b<=0) return 0.5;
//         if(a<=0) return 1;
//         if(b<=0) return 0;
//         if(dp.containsKey(a) && dp.get(a).containsKey(b)) dp.get(a).get(b);
//         double res = (calc(a-4,b) + 
//                     calc(a-3,b-1) + 
//                     calc(a-2,b-2) + 
//                     calc(a-1,b-3))/4.0;
//         dp.computeIfAbsent(a, k->new HashMap<>()).put(b, res);
//         return res;
//     }
// }
class Solution {
    public double soupServings(int n) {
        int m = (int)Math.ceil(n / 25.0);
        Map<Integer, Map<Integer, Double>> dp = new HashMap<>();

        for (int k = 1; k <= m; k++) {
            if (calculateDP(k, k, dp) > 1 - 1e-5) {
                return 1.0;
            }
        }
        return calculateDP(m, m, dp);
    }

    private double calculateDP(int i, int j, Map<Integer, Map<Integer, Double>> dp) {
        if (i <= 0 && j <= 0) {
            return 0.5;
        }
        if (i <= 0) {
            return 1.0;
        }
        if (j <= 0) {
            return 0.0;
        }
        if (dp.containsKey(i) && dp.get(i).containsKey(j)) {
            return dp.get(i).get(j);
        }
        double result = (calculateDP(i - 4, j, dp) + calculateDP(i - 3, j - 1, dp) +
                calculateDP(i - 2, j - 2, dp) + calculateDP(i - 1, j - 3, dp)) / 4.0;
        dp.computeIfAbsent(i, k -> new HashMap<>()).put(j, result);
        return result;
    }
}