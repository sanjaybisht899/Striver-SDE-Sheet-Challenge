import java.util.*;
/**
 * MaximumOfMinimumForEveryWindowSize
 */
public class MaximumOfMinimumForEveryWindowSize {

    public static void main(String[] args) {
        int[] arr={10,20,30,50,10,70,30};
        int n=7;
        Stack <Integer> stack = new Stack<>();
        int max=Intger.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
            stack.push(arr[i]);
        }
        Stack <Integer> stack2 = new Stack<>();
        for(int i=0;i<n;i++){
            int temp= (Math.min(stack.pop(), stack.pop()));
        }


    }
}