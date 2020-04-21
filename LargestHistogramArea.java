package dynamicprogramming;

import java.util.Stack;

public class LargestHistogramArea {

    public static void main(String args[]) {
        int[] a = {1,3,4,2, 1, 1, 1, 1, 1,1, 9};
        System.out.println(largestArea(a));
    }

    private static int largestArea(int[] a) {
        int tempPos =0;
        int max = Integer.MIN_VALUE;
        int pos;
        Stack<Integer> position = new Stack<>();
        Stack<Integer> height = new Stack<>();

        for(pos = 0; pos< a.length; pos++) {
            int t = a[pos];
            if(height.isEmpty() || height.peek() < t){
                height.push(a[pos]);
                position.push(pos);
            } else if(height.peek() > t) {
                while(!height.isEmpty() && height.peek() > t) {
                    int h = height.pop();
                    tempPos = position.pop();

                    int size = h * (pos - tempPos);
                    if(size > max)
                        max = size;

                }
                if(height.isEmpty()) {
                    height.push(a[pos]);
                    position.push(tempPos);
                } else {
                    if(height.peek() == t) {
                       height.pop();
                       tempPos = position.pop();
                    }
                    height.push(a[pos]);
                    position.push(tempPos);
                }

            }
        }

        while(!height.isEmpty()) {
            int h = height.pop();
            tempPos = position.pop();
            int size = h * (pos - tempPos);
            if(size > max)
                max = size;
        }

        return max;
    }


}
