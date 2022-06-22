import java.util.*;
public class CombinationSum2II
{
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> candidates, int n, int target)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Collections.sort(candidates);
        combination(candidates,0,target,temp,result);
        return result;
    }
    public static void combination(ArrayList<Integer> arr, int index, int target, ArrayList<Integer> temp , ArrayList<ArrayList<Integer>>result){
        if(index>=arr.size()){
            if(target==0){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        if(arr.get(index)<=target){
            temp.add(arr.get(index));
            combination(arr,index+1,target-arr.get(index),temp,result);
            temp.remove(temp.size()-1);
        }
        while((index<arr.size()-1) && (arr.get(index)==arr.get(index+1))){
            index++;
        }
        combination(arr,index+1,target,temp,result);
    }
}