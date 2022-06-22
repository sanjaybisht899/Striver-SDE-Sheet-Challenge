/**
 * CombinationSum
 */
import java.util.*;
public class CombinationSum {
    public static void main(String[] args) {
        int [] Candidates = {2,3,6,7};

        int target= 7;

        ArrayList < ArrayList < Integer> > result = new ArrayList<>();
        ArrayList < Integer> temp = new ArrayList<>();
        Combinations(Candidates, 0 , target, temp, result);
        System.out.println(result);
    }
    static void Combinations (int arr[] , int index , int target , ArrayList <Integer> temp , ArrayList<ArrayList<Integer>>result){
        if(index==arr.length){
            if(target==0){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        if(arr[index]<=target){
            temp.add(arr[index]);
            Combinations(arr,index,target-arr[index],temp,result);
            temp.remove(temp.size()-1);
        }
        Combinations(arr,index+1,target,temp,result);
    }
}