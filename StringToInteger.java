import java.util.*;
public class StringToInteger {
    public static int myAtoi(String s) {
        s=s.trim();
        String arr[]= s.split("[a-zA-Z]");
        System.out.println(Arrays.toString(arr));

        String temp = arr[0].trim();
        System.out.println(temp);
        String result="";
        for (int i = 0; i < temp.length(); i++) {
            if(temp.charAt(i)==' '){
                break;
            }
            result=result+temp.charAt(i);
        }

        return Integer.valueOf(result).intValue();
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("words and 987"));
    }
}
