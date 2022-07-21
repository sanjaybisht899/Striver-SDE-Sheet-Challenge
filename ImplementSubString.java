/**
 * ImplementSubString
 */
import java.util.*;
public class ImplementSubString {
    public static void main(String[] args) {
        String s="helloll";
        String p="ll";
        int m=p.length();
        int result=0;
        int n=s.length();
        while(s.indexOf(p)!=-1){
            int tmp=s.indexOf(p)-1;
            System.err.println(tmp+" Temp");
            s=s.substring(tmp+1+m);
            System.err.println(s+" S");
            result++;
            
        }
    

        System.out.println(result);
    }    
}