import java.util.*;

/**
 * CountAndSay
 */
public class CountAndSay {
    public  String countAndSay(int n) {
        //Starting for n=1
        int j=1;
        String x="1";
		//if n==1 it will skip the loop and directly return the string x otherwise move into the loop 
		//and compute the n+1 th solution
        while(j!=n){
            String result="";
            int i=0;
            char prev='a';
			//setting the previous 
            int sum=0;
            while(i<x.length()){
			//we will have only two cases either it will match or not
			//if match we will simply increment the sum otherwise we will store the prev and the sum in the result string
                if(x.charAt(i)!=prev ){
                    if(sum!=0){
                        result=result+""+sum+prev;
                    }
                    prev=x.charAt(i);
                    sum=1;
                }
                else{
                    sum++;
                }
                i++;
            }
			//computing for the remaning 
            if(sum!=0){
                result=result+""+sum+prev;
            }
			//updating the string for the next test case
            x=result;
            j++;
        }
        return x;
    }
    
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}