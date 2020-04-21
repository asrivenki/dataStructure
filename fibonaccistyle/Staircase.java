package dynamicprogramming.fibonaccistyle;

import java.util.Arrays;

/**
 * Given a stair with ‘n’ steps, implement a method to count how many possible ways are there to reach the top of the staircase, given that, at every step you can either take 1 step, 2 steps, or 3 steps.
 */
public class Staircase {

    static int  findNoOfWaysRecursiveHelper(int steps) {
        int[] dp = new int[steps+1];
        Arrays.fill(dp , -1);
        return findNoOfWaysRecursive(steps, dp);
    }

    /**
     * Top down approach
     * @param steps
     * @param dp
     * @return
     */
    static int findNoOfWaysRecursive(int steps, int[] dp) {
        if(steps == 1 || steps == 2)
            return steps;
        if(steps == 0)
            return 1;

        if(dp[steps] != -1)
            return dp[steps];
        dp[steps] = findNoOfWaysRecursive(steps-1, dp) + findNoOfWaysRecursive(steps-2, dp) + findNoOfWaysRecursive(steps-3, dp);
        return dp[steps];
    }

    static int findNoOfWaysBottomUp(int steps) {
        if (steps == 1 || steps == 2)
            return steps;
        if (steps == 0)
            return 1;

        int[] dp = new int[steps+1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i<=steps; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[steps];
    }

    public static void main(String arg[]) {
        System.out.println(findNoOfWaysRecursiveHelper(4));
        System.out.println(findNoOfWaysBottomUp(4));
    }
}
