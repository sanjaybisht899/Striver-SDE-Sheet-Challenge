/**
 * PascalTriangle
 */
import java.util.*;
public class PascalTriangle {
    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> result= new ArrayList<>();
        ArrayList <Long> temp = new ArrayList<>();
        temp.add((long)1);
        result.add(temp);
        if(n==1){
            return result;
        }
        for(int i=2;i<=n;i++){
            ArrayList <Long> arr = new ArrayList<>();
            
                for (int j = 0; j < i; j++) {
                    
                    if(j==0){
                        arr.add((long)1);
                    }
                    else if(j==i-1){
                        arr.add((long)1);
                    }
                    else{
                        long a = result.get(i-2).get(j-1);
                        long b = result.get(i-2).get(j);
                        arr.add(a+b);
                    }
                }
            
            result.add(arr);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(printPascal(5));
    }    
}