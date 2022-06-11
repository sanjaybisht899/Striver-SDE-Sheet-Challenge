/**
 * MajorityElement
 */
public class MajorityElement {
    public static int findMajority(int[] arr, int n) {
		if (n==1){
            return arr[0];
        }
        
        int prev=arr[0];
        int count=1;
        
        for(int i=1;i<n;i++){
            if(arr[i]==prev){
                count++;
            }
            else{
                count--;
                if(count==0){
                    count=1;
                    prev=arr[i];
                }
            }
        }
        count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==prev){
                count++;
            }
        }
        if(count>Math.floor(n/2)){
            return prev;
        }
        else{
            return -1;
        }
	}
    public static void main(String[] args) {
        
    }
}