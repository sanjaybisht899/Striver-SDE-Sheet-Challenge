/**
 * MissingRepeatingNumbers
 */
import java.util.*;
public class MissingRepeatingNumbers {

    public static void main(String[] args) {
        int arr[]= {1,2,3,5,4,4};
        int sum1=0;
        int sum2=0;
        int duplicate=0;
        HashSet <Integer> set= new HashSet<>();
        for(int i=1;i<=arr.length;i++){
            if(!set.add(arr[i-1])){
                duplicate=arr[i-1];
            }
            sum1=sum1+i;
            sum2=sum2+arr[i-1];
        }
        int missing= sum1-(sum2-duplicate);

        System.out.println(duplicate);
        System.out.println(missing);


    }
}