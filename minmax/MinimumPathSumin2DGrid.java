package dynamicprogramming.minmax;

import java.util.ArrayList;
import java.util.List;

public class MinimumPathSumin2DGrid {

    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] minPathSum = new int[n][m];
        char[][] dir = new char[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if((i==0) && (j==0))
                    minPathSum[i][j] = grid[i][j];
                else if(i==0) { //First row
                    minPathSum[i][j] = minPathSum[i][j-1] + grid[i][j];
                    dir[i][j] = 'L';
                } else if(j == 0) { //First column
                    minPathSum[i][j] = minPathSum[i-1][j] + grid[i][j];
                    dir[i][j] = 'T';
                } else {
                    int min = Math.min(minPathSum[i][j-1], minPathSum[i-1][j]);
                    minPathSum[i][j] = min + grid[i][j];
                    if(minPathSum[i][j-1] < minPathSum[i-1][j])
                        dir[i][j] = 'L';
                    else
                        dir[i][j] = 'T';
                }
            }
        }

        int i = n-1;
        int j = m-1;

        List<List<Integer>> res = new ArrayList<>();
        while(true) {
            List<Integer> l = new ArrayList<>();
            l.add(i);
            l.add(j);
            res.add(0,l);

            if(i==0 && j==0)
                break;
            if(dir[i][j] == 'T')
                i--;
            else
                j--;
        }

        System.out.println(res);

        return minPathSum[n-1][m-1];
    }

    public static void main(String a[]) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
