import java.util.*;
public class CountXOR {
    public static void main(String[] args) {
        int []A = {5, 6, 7, 8, 9};
        int B = 5;
        int sum=A[0];
        int count=A[0]==B?1:0;
        for(int i=1;i<A.length;i++){
            sum = sum ^ A[i];
            System.out.println(sum);
            if(sum==B){
               count++;
            }
        }
        System.out.println(count);
    }
}
