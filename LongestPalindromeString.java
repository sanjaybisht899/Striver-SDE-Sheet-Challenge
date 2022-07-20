import java.util.*;
/**
 * LongestPalindromeString
 */
public class LongestPalindromeString {
    static String res="";
    static  int max=0;
    public static String longestPalindrome(String s) {
        
        for (int i = 0; i < s.length(); i++) {
            //Odd
            check(i,i,s);
            //even
            if(i!=s.length()-1){
                check(i,i+1,s);
            }
            //System.out.println(max+" "+res);
        }
        return res;
    }
    public static void check(int index1, int index2, String s){
        while(index1>=0 && index2<s.length() && s.charAt(index1)==s.charAt(index2)){
            index1+=-1;
            index2+=1;
        }
        if((index2-index1)>max){
            max=index2-index1;
            res=s.substring(index1+1, index2);
            System.out.println(res);
        }
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abb"));
    }
}