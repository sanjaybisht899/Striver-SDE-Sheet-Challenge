import javax.swing.text.DefaultStyledDocument.ElementSpec;

/**
 * ReversePairs
 */
public class ReversePairs {
    public  static int reversePairs(int[] nums) {
        int B[]=new int [nums.length];
        
        
        return mergesort(0,nums.length-1,nums,B);
    }
    public static int  mergesort(int left, int right, int arr[],int B[]){
        int mid;
        int res=0;
        if(left<right){
            mid=(left+right)/2;
            res+=mergesort(left, mid, arr,B);
            res+=mergesort(mid+1, right, arr,B);
            res+=merge(left,mid,right,arr,B);
        }
        return res;
    }
    public static int merge(int left, int mid, int right, int arr[],int B[]){
        int res=0;
        int l=left;
        int m=mid+1;
        int x=left;
        int j=mid+1;
        for (int i = left; i <= mid; i++) {
            while (j<=right && arr[i]>2*arr[j]) {
                j++;
            }
            res+=j-(mid+1);
        }

        while (l<=mid && m<=right) {
            if(arr[l]<=arr[m]){
                B[x]=arr[l];
                l++;
            }
            else{
                B[x]=arr[m];
                m++;
            }
            x++;
        }
        while(l<=mid){
            B[x]=arr[l];
            l++;
            x++;
        }
        while(m<=right){
            B[x]=arr[m];
            m++;
            x++;
        }
        for(int i=left;i<=right;i++){
            arr[i]=B[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1,33,12,13,3,12,45};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println(reversePairs(arr));
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
}