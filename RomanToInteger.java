import java.util.*;
/**
 * RomanToInteger
 * 
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
 */
public class RomanToInteger {
    public static int toRoman(String s){
        int result=0;
        HashMap <Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);


        int n=s.length();
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                result+=map.get(s.charAt(i));
                continue;
            }
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                result-=map.get(s.charAt(i));
            }
            else{
                result+=map.get(s.charAt(i));
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String s="DCXIVD";
        System.out.println(toRoman(s));
    }
}