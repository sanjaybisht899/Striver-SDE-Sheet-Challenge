class MedianOfSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int n=n1+n2;
        int arr[]=new int[n1+n2];
        int i=0,j=0,x=0;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                arr[x++]=nums1[i++];
            }
            else{
                arr[x++]=nums2[j++];
            }
        }
        while(i<n1){
            arr[x++]=nums1[i++];
        }
         while(j<n2){
            arr[x++]=nums2[j++];
        }
        double res=0;
        if(n%2==0){
            res=(arr[n/2]+arr[(n-1)/2])/2.0;
        }
        else{
            res=arr[n/2];
        }
        return res;
    }
}
class MedianOfSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
    // When length are different then apply binary search on shortest array to avoid index out of bound
       if(nums1.length > nums2.length){
            return(findMedianSortedArrays(nums2, nums1));
        }
        int n1=nums1.length;
        int n2=nums2.length;
        int lo=0,hi=n1;
        while(lo<=hi)
        {
    //         Initialize the cuts or partitions
            int cut1=lo+(hi-lo)/2;
    //         Total required - already present
            int cut2=((n1+n2)/2)-cut1;
            
    //         Initialize l1,l2,r1,r2
            int l1= (cut1==0)?Integer.MIN_VALUE:nums1[cut1-1];
            int l2= (cut2==0)?Integer.MIN_VALUE:nums2[cut2-1];
            int r1= (cut1==n1)?Integer.MAX_VALUE:nums1[cut1];
            int r2= (cut2==n2)?Integer.MAX_VALUE:nums2[cut2];
            
    //         Shift element to the left
            if(l1>r2) hi=cut1-1;
            else if(l2>r1) lo=cut1+1;
            else
            {
    //             Check for even length
                if((n1+n2)%2==0)
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
                else
                    return (double)(Math.min(r1,r2));
            }
    //         To avoid error  
        } 
        return 0.0; 
        }
    }