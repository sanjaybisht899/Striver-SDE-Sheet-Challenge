import java.util.*;
public class BestTimetoBuyandSellStock {
    public static void maximumProfit(int []arr){
        int max=0;
        int low=Integer.MAX_VALUE;
        int prevlow=0;
        for (int i = 0; i < arr.length; i++) {
            if(i==arr.length-1){
                if(arr[i] - low>max){
                    max=arr[i] - low;
                }
                System.out.println(low+ " "+(max+low));   
            }
            if(low>arr[i]){
                prevlow=low;
                low=arr[i];
            }
            if(arr[i] - low>max){
                max=arr[i] - low;
            }
            else if(max!=0){
                System.out.println(prevlow+" "+arr[i-1]);
            }
            
        }
        
    }
   public static void main(String[] args) {
       int arr[]= {100, 180, 260, 310, 40, 535, 695};
       maximumProfit(arr);
   } 
}
