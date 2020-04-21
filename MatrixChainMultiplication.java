package dynamicprogramming;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class MatrixChainMultiplication {

    static class Node {
        int[] arr;
        int result;
    }

    static int minMultiplicationCost(int[] input) {
        int[][] matrix = new int[input.length - 1][2];

        for (int i = 0; i < input.length - 1; ++i) {
            matrix[i][0] = input[i];
            matrix[i][1] = input[i + 1];
        }

        Map<Map.Entry<Integer, Integer>, Node> map = new HashMap<>();

        for(int length=1; length <= matrix.length; ++length) {
            for(int i = 0; (i+length) <= matrix.length; ++i) {
                int j = i + length -1;

                Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleImmutableEntry<>(i, j);

                Node n = new Node();
                int[] arr = new int[2];
                arr[0] = matrix[i][0];
                arr[1] = matrix[j][1];
                n.arr = arr;

                if(i == j)
                    n.result = 0;
                else if(i == j-1)
                    n.result = matrix[i][0] * matrix[i][1] * matrix[j][1];
                else {
                    n.result = Integer.MAX_VALUE;

                    for(int x = i; x<j; ++x) {
                        Map.Entry<Integer, Integer> pre = new AbstractMap.SimpleImmutableEntry<>(i, x);
                        Map.Entry<Integer, Integer> post = new AbstractMap.SimpleImmutableEntry<>(x+1, j);

                        Node n1 = map.get(pre);
                        Node n2 = map.get(post);

                        int result = n1.result + n2.result + n1.arr[0]*n1.arr[1]*n2.arr[1];
                        if(result < n.result)
                            n.result = result;
                    }
                }
                map.put(entry, n);
            }
        }

        Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleImmutableEntry<>(0, matrix.length-1);
        return map.get(entry).result;
    }

    public static void main(String d[]) {
        int[] input = {10, 30, 5, 60};
        System.out.println(minMultiplicationCost(input));
    }

}
