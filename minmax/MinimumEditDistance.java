package dynamicprogramming.minmax;

import java.util.ArrayList;
import java.util.List;

public class MinimumEditDistance {

    public static void main(String arg[]) {
        int result = findMinimumEditDistance("abcd", "abcbd");
        System.out.println(result);
        List<String> res = new ArrayList<>();
        res.stream().toArray(String[]::new);

        int k = (int)(Math.pow(2, 31)-1);
        System.out.println(k);
    }

    private static int findMinimumEditDistance(String a1, String b1) {
        char[] a = a1.toCharArray();
        char[] b = b1.toCharArray();

        int[][] dp = new int[a.length+1][b.length+1];
        dp[0][0] = 0;
        for(int i=0; i<=a.length; i++) {
            for (int j=0; j<=b.length; j++) {
                if(i == 0 && j == 0)
                    dp[i][j] =0;
                else if(i==0) {
                    dp[i][j] = j;
                } else if( j==0 )
                    dp[i][j] = i;
                else {
                    if(a[i-1] == b[j-1])
                        dp[i][j] = dp[i-1][j-1];
                    else {
                        int min = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                        dp[i][j] = min + 1;
                    }
                }
            }
        }
        return dp[a.length][b.length];
    }
}
