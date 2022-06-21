import java.util.*;
/**
 * TrappingRainWater
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int sum=0;
        int n = height.length;
        int left [] = new int[n];
        int right [] = new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            max= Math.max(max,height[i]);
            left[i]=max;
        }
        max=0;
        
        for(int i=n-1;i>=0;i--){
            max = Math.max(max,height[i]);
            right[i]=max;
            sum+=Math.min(left[i],right[i]) - height[i];
        }
        return sum;
    }
}