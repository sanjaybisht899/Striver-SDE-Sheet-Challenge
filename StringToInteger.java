import java.util.*;
public class StringToInteger {
    public static int myAtoi(String s) {
        Long result=0L;
        s=s.trim();
        if(s.length()==0){
            return 0;
        }
        boolean positive=true;
        int i=0;
        if(s.charAt(0)=='-'){
            positive=false;
            i=1;
        }
        if(s.charAt(0)=='+'){
            i=1;
        }
        for (; i < s.length(); i++) {
            int temp=s.charAt(i)-'0';
            if(temp>=0 && temp<=9){
                result=result*10 + temp;
            }
            else{
                break;
            }
            
            if(positive){
                if(result>Integer.MAX_VALUE){ return Integer.MAX_VALUE;}
            }
            else{
                Long x=result*-1;
                if(x<Integer.MIN_VALUE ){ return Integer.MIN_VALUE;}
            }
            
        }
        
        if(!positive){
            result=result*-1;
        }
        
        
            
        //System.out.println(result);
        return result.intValue();
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("   -42"));
    }
}
