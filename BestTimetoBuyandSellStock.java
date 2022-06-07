import java.util.*;
public class BestTimetoBuyandSellStock {
    public static int maximumProfit(List<Integer> prices){
        int max=0;
        int low=Integer.MAX_VALUE;
        for (int i = 0; i < prices.size(); i++) {
            if(low>prices.get(i)){
                low=prices.get(i);
            }
            max=Math.max(max, prices.get(i)-low);
        }

        return max;
    }
   public static void main(String[] args) {
       Integer a[]= {23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
       List <Integer> arr = Arrays.asList(a);
       System.out.println( maximumProfit(arr));
   } 
}
