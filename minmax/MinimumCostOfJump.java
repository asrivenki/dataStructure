package dynamicprogramming.minmax;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumCostOfJump {

    static int minCostStairClimbing(int[] arr, int[] jumps) {
        int n = arr.length;
        Set<Integer> jumpSet = new HashSet<>();

        Arrays.stream(jumps).forEach(e -> jumpSet.add(e));

        int[] a = new int[n+2];
        for(int i=0; i<n; i++) {
            a[i+1] = arr[i];
        }
        a[n+1] = 0;

        int[] dp = new int[n+2];

        for(int j: jumps) {
            if(j<=n)
                dp[j] = a[j];
        }

        for(int i=1; i<=n+1; i++) {
            if(!jumpSet.contains(i)) {
                int min = Integer.MAX_VALUE;
                for(int j: jumps) {
                    if(i-j > 0)
                        min = Math.min(min, dp[i-j]);
                }
                dp[i] = a[i] + min;
            }
        }

        return dp[n+1];
    }

    public static void main(String d[]) {
        int a[] = {10,15,10,5,20,10};
        int[] jumps = {1,2,5};

        System.out.println(minCostStairClimbing(a, jumps));
    }
}
