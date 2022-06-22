import java.util.ArrayList;

/**
 * SubsetSums
 */
public class SubsetSums {
    public static void main(String[] args) {
        int arr[]={1,2,3};
        int n= arr.length;
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < (1<<n); i++) {
            int sum=0;
            for (int j = 0; j < n; j++) {
                if(((1<<j)&i) !=0){
                    sum=sum+arr[j];
                }
            }
            x.add(sum);
        }
        System.out.println(x);
    }
}