import java.util.*;
/**
 * PalindromicPartioning
 */
public class PalindromicPartioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> result= new ArrayList<>();
        dfs(s,0,new ArrayList<>(),result);
        return result;
    }
    static void dfs(String s, int index, List<String> temp, List<List<String>> result){
        if(index==s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s.substring(index,i+1))){
                temp.add(s.substring(index,i+1));
                dfs(s,i+1,temp,result);
                temp.remove(temp.size()-1);
            }
        }
    }
    static boolean isPalindrome(String s){
        int left=0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }   
}
