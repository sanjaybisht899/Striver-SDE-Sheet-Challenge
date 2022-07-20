import java.util.*;
/**
 * ReverseAString
 */
public class ReverseAString {

    public static void main(String[] args) {
        s = s.trim();
        String str[] =  s.split("\\s+");
        String rev = "";
        for(int i=str.length-1;i>=0;i--){
            if(i==0)
                rev += str[i];
            else
            rev += (str[i]+" ");
            
        }
        System.out.println(rev);
    }
    
}