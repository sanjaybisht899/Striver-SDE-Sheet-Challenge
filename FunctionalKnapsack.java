/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/

import java.util.*;
public class FunctionalKnapsack {
    public static double maximumValue(Pair[] arr, int n, int W) {
           Arrays.sort(arr, new Comparator<Pair>(){
            public int compare(Pair i1, Pair i2){
                double i2Ratio = (i2.value*1.0)/i2.weight;
                double i1Ratio = (i1.value*1.0)/i1.weight;
                if(i2Ratio>i1Ratio){
                    return 1;
                }else if(i2Ratio<i1Ratio){
                    return -1;
                }
                    return 0;
                
            }
        });
        
        double sum=0;
        
        for(int i=0;i<n;i++){
            if(W>=arr[i].weight){
                sum=sum+arr[i].value;
                W=W-arr[i].weight;
            }
            else{
                double temp=(arr[i].value*1.0)/arr[i].weight;
                sum=sum+ temp*W;
                break;
            }
        }
        
        return sum;
    }
}
