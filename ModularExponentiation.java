/**
 * ModularExponentiation
 */
public class ModularExponentiation {
    public static int modularExponentiation(int X, int N, int m) {
        long result=1;
        long x=X;
        long n=N;
        if(n>0){
            while(n!=0){
                if(n%2==1){
                    result=result*x;
                    result=result%m;
                }
                x=x*x;
                x=x%m;
                n=n/2;
            }
            
        }
        else{
            n=-n;
            while(n!=0){
                if(n%2==1){
                    result=result*x;
                    result=result%m;
                }
                
                x=x*x;
                x=x%m;
                n=n/2;
            }
            result=1/result;
            
        }
        return (int)result;        
    }
    public static void main(String[] args) {
        
    }
}