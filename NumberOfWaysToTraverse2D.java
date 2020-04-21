package dynamicprogramming;

import java.util.Arrays;


/**
 * Count the number of ways of starting at top left and reach bottom right.
 * https://leetcode.com/problems/unique-paths/submissions/
 */
public class NumberOfWaysToTraverse2D {

    public static void main(String arg[]) {
        int a[][] = new int[5][5];
        int dp[][] = new int[a.length][a.length];
        Arrays.stream(dp).forEach(e-> Arrays.fill(e, -1));
        System.out.println(findNumberOfWaysToTraverse2DTopDown(a, 0, 0, dp));
        Arrays.stream(dp).forEach( e-> System.out.println(Arrays.toString(e)));

        System.out.println("Number of ways to traverse Bottom up " + findNumberOfWaysToTraverse2DBottomUp(5,5));
    }

    private static int findNumberOfWaysToTraverse2DBottomUp(int n, int m) {
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0)
                    dp[i][j] = 1;
                else if(j==0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }


        private static int findNumberOfWaysToTraverse2DTopDown(int a[][], int i, int j, int dp[][]) {
        if(i == a[0].length || j == a[0].length)
            return 0;
        else if(i == a.length-1 && j == a[0].length-1)
            return 1;
        else {
            if(dp[i][j] != -1)
                return dp[i][j];
            int i1 = findNumberOfWaysToTraverse2DTopDown(a, i, j+1, dp);
            int i2 = findNumberOfWaysToTraverse2DTopDown(a,i+1, j, dp);
            dp[i][j] = i1+ i2;
            return i1 + i2;
        }
    }
}
