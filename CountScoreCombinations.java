package dynamicprogramming;

import java.util.*;

public class CountScoreCombinations {

    public static void main(String arg[]) {
        int[] a = {3,5,10};
        int sum = 20;
        int[] dp = new int[sum+1];
        Arrays.fill(dp, -1);

        HashSet<ArrayList<Integer>> result = new HashSet<>();
        ArrayList<Integer> curr = new ArrayList<>();
        naiveCountScoreCombinations(sum, a, result, curr);
        System.out.println("result " + result.size() + result);

        System.out.println(countForScoreCombinationsIterative(a, sum));
    }

    private static int countForScoreCombinationsIterative(int[] coins, int sum) {
        int[] dp = new int[sum+1];

        dp[0] = 1;

        for(int coin: coins) {
            for(int i=1; i<=sum; i++) {
                if(i>=coin) {
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[sum];
    }

    private static void naiveCountScoreCombinations(int sum, int a[], HashSet<ArrayList<Integer>> result,
                                                   ArrayList<Integer> curr) {
        if(sum ==0) {
            Collections.sort(curr);
            result.add(curr);
            return;
        }
        else if(sum < 0)
            return;
        else {
            for(int i: a) {
                ArrayList<Integer> curr1 = new ArrayList<>(curr);
                curr1.add(i);
                naiveCountScoreCombinations(sum-i, a, result, curr1);
            }
        }
    }
}
