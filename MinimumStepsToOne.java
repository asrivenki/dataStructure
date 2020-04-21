package dynamicprogramming;

public class MinimumStepsToOne {

    public static void main(String args[]) {
        System.out.println(" findMinimumStepsToOne " + findMinimumStepsToOne(7));
    }

    private static int findMinimumStepsToOne(int n) {
        if(n==1)
            return 0;
        if( n==2 || n==3 )
            return 1;
        if(n <=0)
            return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;

        int v = n - 1;
        int val = findMinimumStepsToOne(v);
        min = Integer.min(min, val);

        if(n % 2 == 0) {
            v = n / 2;
            val = findMinimumStepsToOne(v);
            min = Integer.min(min, val);
        }

        if(n % 3 == 0) {
            v = n / 3;
            val = findMinimumStepsToOne(v);
            min = Integer.min(min, val);
        }

        if(min == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return 1 + min;
    }
}
