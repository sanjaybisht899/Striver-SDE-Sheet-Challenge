import java.util.*;
public class CountZeroOneTwo {
    public static void sort012(int[] arr)
    {
        int zero=0;
        int one=0;
        int two=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1){
                one++;
            }
            else if(arr[i]==2){
                two++;
            }
            else{
                zero++;
            }
        }
        int x=0;
        for(int i=0;i<zero;i++){
            arr[x]=0;
            x++;
        }
        for(int i=0;i<one;i++){
            arr[x]=1;
            x++;
        }
        for(int i=0;i<two;i++){
            arr[x]=2;
            x++;
        }
    }
    public static void main(String[] args) {
        int arr[]= {0, 1, 2, 2, 1 ,0};
        sort012(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
