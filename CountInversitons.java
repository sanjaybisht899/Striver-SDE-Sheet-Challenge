/**
 * CountInversitons
 */
public class CountInversitons {
    static long inversionCount(long arr[], long N)
    {
        long []a= new long[(int)N];
        long res= mergesort(arr,0,N-1,a);
        return res;
    }
    public static long mergesort(long arr[], long left, long right,long a[]){
        long res=0;
        if(left<right){
            long mid=(left+right)/2;
            res=res+mergesort(arr, left, mid,a);
            res=res+mergesort(arr, mid+1, right,a);
            res=res+merge(arr,left,mid,right,a);
        }
        return res;
    }
    
    public static long merge(long arr[], long l, long mid, long h,long B[]){
        long res=0;
        long i=l;
        long j=mid+1;
        long k=l;
        while(i<=mid && j<=h){
            if(arr[(int)i]<=arr[(int)j]){
                B[(int)k]=arr[(int)i];
                i++;
                
            }
            else{
                B[(int)k]=arr[(int)j];
                j++;
                res=res+(mid-i+1);
            }
            k++;
        }
        
        while(j<=h){
            B[(int)k]=arr[(int)j];
            j++;
            k++;
        }
        while(i<=mid){
            B[(int)k]=arr[(int)i];
            i++;
            k++;
        }
        
        for(i=l;i<=h;i++){
            arr[(int)i]=B[(int)i];
        }
        return res;
    }



    public static void main(String[] args) {
        long arr[]= {2, 5, 1, 3 ,4};
        long a[] = new long[arr.length];
        long res= mergesort(arr,0,arr.length-1,a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println(res);
    }
}