package dynamicprogramming;

import java.util.Arrays;

public class NumberOfSteps {
    static int numberOfJumps(int n, int[] jumps) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        for(int j: jumps){
            if(j <=n)
                dp[j] = 1;
        }

        for(int i=1; i<=n; i++) {
            for(int j: jumps) {
                if((i-j) >=0) {
                    dp[i] += dp[i-j];
                }
            }
        }

        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String a[]) {
        int[] arr = {1,2,5};
        System.out.println("Number of jumps " + numberOfJumps(5,arr));
    }
}
