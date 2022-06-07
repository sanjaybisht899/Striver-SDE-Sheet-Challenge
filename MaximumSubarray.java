import java.util.*;
public class MaximumSubarray{
    public static void main(String[] args) {
        int arr[] = {5,4,-1,7,8};
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum=sum+arr[i];
            max=Math.max(max, sum);
            if(sum<0){
                sum=0;
            }
        }
        System.out.println(max);
    }
}