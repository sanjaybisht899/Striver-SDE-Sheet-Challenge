import java.util.*;
/**
 * MaximumOfMinimumForEveryWindowSize
 */
public class MaximumOfMinimumForEveryWindowSize {
    static int[] maxOfMin(int[] arr, int n) 
    {
        int result[]= new int [n];
        int resultset[]= new int [n];
        int left[]=new int[n];
        int right[]=new int[n];
        findLeft(arr,left);
        findRight(arr,right);
        System.out.println("Left :"+Arrays.toString(left));
        System.out.println("Left :"+Arrays.toString(right));
        for(int i=0;i<n;i++){
            result[i]=right[i]-left[i]-2;
        }
        for(int i=0;i<n;i++){
            resultset[result[i]]=Math.max(resultset[result[i]],arr[i]);
        }
        for (int i = n-2; i >=0 ; i--) {
            resultset[i]=Math.max(resultset[i], resultset[i+1]);
        }
        return resultset;
    }
    static void findLeft(int []arr, int []left){
        Stack <Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()){
                left[i]=-1;
            }
            else{
                while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    left[i]=-1;
                }
                else{
                    left[i]=stack.peek();
                }
            }
            stack.push(i);
        }
    }
    static void findRight(int []arr, int []right){
        Stack <Integer> stack = new Stack<>();
        for (int i = arr.length-1; i >=0  ; i--) {
            if(stack.isEmpty()){
                right[i]=arr.length;
            }
            else{
                while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    right[i]=arr.length;
                }
                else{
                    right[i]=stack.peek();
                }
            }
            stack.push(i);
        } 
    }
    public static void main(String[] args) {
        int[] arr={1 ,32, 71, 1, 86, 85 ,18 ,27 ,9 ,68 ,87 ,54 ,41 ,70 ,76 ,13 ,38};
        int n=arr.length;
        System.out.println(Arrays.toString(maxOfMin(arr,n)));
    }
}