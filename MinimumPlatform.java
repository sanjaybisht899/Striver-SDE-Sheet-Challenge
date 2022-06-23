import java.util.*;
class MinimumPlatform
{
   static int findPlatform(int arr[], int dep[], int n)
    {
        sort(at,at+n);
        sort(dt,dt+n);
        int i=1,j=0,max=1,p=1;
        while(i<n && j<n){
            if(at[i]<=dt[j]){
                p++;
                i++;
            }
            else {
                p--;
                j++;
            }
            if(p>max){
                max=p;
            }
        }
        return max;
    }
}
