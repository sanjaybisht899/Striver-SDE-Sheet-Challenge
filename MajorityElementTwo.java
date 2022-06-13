import java.util.ArrayList;

/**
 * MajorityElementII
 */
public class MajorityElementTwo {
    public static List<Integer> majorityElement(int[] a) {
        int n=a.length;
        int curr1=-1;
        int curr2=-1;
        int count1=0;
        int count2=0;
        for(int i=0;i<n;i++){
            if(curr1==a[i]){
                count1++;
            }
            else if(curr2==a[i]){
                count2++;
            }
            else if(count1==0){
                curr1=a[i];
                count1=1;
            }
            else if(count2==0){
                curr2=a[i];
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for(int i=0;i<n;i++){
            if(curr1==a[i]){
                count1++;
            }
            else if(curr2==a[i]){
                count2++;
            }
        }
        ArrayList <Integer> arr = new ArrayList<>();
        if(count1>Math.floor(n/3)){
            arr.add(curr1);
        }
        if(count2>Math.floor(n/3)){
            arr.add(curr2);
        }
        return arr;
         
    }
    public static void main(String[] args) {
        int arr[]= {7 ,4 ,4 ,9 ,7};
        System.out.println(majorityElement(arr));
        
    }
}