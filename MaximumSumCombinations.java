import java.util.PriorityQueue;

/**
 * MaximumSumCombinations
 */
import java.util.*;
public class MaximumSumCombinations {
    public static void main(String[] args) {
        int []A = {3, 2};
        int []B = {1, 4};
        int C = 2;
        int n=A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < C; j++) {
                pq.add(A[n-1-i]+A[n-1-j]);
            }
        }
        int result[] = new int[C];
        System.out.println(pq);
        for (int i = 0; i < C; i++) {
           result[i]=pq.poll();
        }
    }
}
