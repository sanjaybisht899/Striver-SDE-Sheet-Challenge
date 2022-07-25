/**
 * ImplementSubString
 */
import java.util.*;
public class ImplementSubString {
    public static void main(String[] args) {
        String s="helloll";
        String p="ll";
        for(int i=0;i<s.length()-2;i++){
            String p=s.substring(i, i+2);
            if(ans==p){
                count++;
            }
        }
    

        System.out.println(count);
    }    
}