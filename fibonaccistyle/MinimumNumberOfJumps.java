package dynamicprogramming.fibonaccistyle;

import java.util.Arrays;

public class MinimumNumberOfJumps {

    //https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/

    public static void main(String args[]) {
        int[] a = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int[] dp = new int[a.length];
        Arrays.fill(dp, -1);
        int min = minJumpsNaive(a, dp, 0, 0);
        System.out.println("Minimum jumps " + min);

        int min1 = minJumpsDP(a);
        System.out.println("Minimum jumps " + min);

    }

    private static int minJumpsNaive(int[] a, int[] dp, int index, int jumps) {
        if(index >= a.length)
            return jumps;

        if(a[index] == 0)
            return Integer.MAX_VALUE;

        //if(dp[index] != -1)
        //    return dp[index];
        int min = Integer.MAX_VALUE;
        for(int i=1; i<=a[index]; i++){
            int v = minJumpsNaive(a, dp, index+i, jumps+1);
            min = Math.min(min, v);
        }
        dp[index] = min;
        return min;
    }

    private static int minJumpsDP(int[] a) {
        if(a.length ==0)
            return 0;

        int[] dp = new int[a.length+1];

        dp[0] = 0;

        for(int i=1; i<=a.length; i++) {

            dp[i] = Integer.MAX_VALUE;

            for(int j=0; j<i; j++) {
                if(i <= (j + dp[j]) && dp[j] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[j] +1);
            }
        }
        return dp[a.length];
    }
}
