package dynamicprogramming.boundedknapsackstyle;

/**
 * https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/3j64vRY6JnR
 */
public class SubsetSum {

    static boolean subsetSumRecursiveHelperToDown(int[] arr, int sum) {
        if(sum <= 0 )
            return false;
        return subsetSumRecursiveTopDown(arr, sum, 0);
    }

    static boolean subsetSumRecursiveTopDown(int[] arr, int sum, int currentIndex) {
        if(sum == 0)
            return true;
        if(currentIndex >= arr.length)
            return false;

        boolean b1 = false;
        if(arr[currentIndex] <= sum)
            b1 = subsetSumRecursiveTopDown(arr, sum - arr[currentIndex], currentIndex + 1);
        return b1 || subsetSumRecursiveTopDown(arr, sum, currentIndex + 1);
    }

    static boolean canPartitionBottomUp(int[] nums) {

        if(nums == null || nums.length == 1)
            return false;

        int sum = 0;
        int n = nums.length;

        for(int n1: nums) {
            sum += n1;
        }

        if(sum % 2 != 0)
            return false;

        boolean[][] dp = new boolean[2][sum/2+1];

        for(int i=0; i<n; i++)
            dp[i%2][0] = true;

        for(int i=0; i<n; i++) {
            for(int j=1; j<=sum/2; j++) {
                if(i == 0) {
                    if(j != 0)
                        dp[i%2][nums[i]] = true;
                } else {
                    if(j-nums[i] >=0)
                        dp[i%2][j] = dp[(i-1)%2][j] || dp[(i-1)%2][j-nums[i]];
                    else
                        dp[i%2][j] = dp[(i-1)%2][j];
                }
            }
        }

        return dp[1][sum/2];
    }

    public static void main(String ar[]) {
        System.out.println(subsetSumRecursiveHelperToDown(new int[]{1, 2, 3, 7}, 7));
        System.out.println(canPartitionBottomUp(new int[]{1, 2, 3, 7}));

    }
}
