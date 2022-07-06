class KthNumberOfTwoSortedArrays {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        if(n>m){
            kthElement(arr2,arr1,m,n,k);
        }
        int left=Math.max(0,k-m);
        int right=Math.min(n,k);
        while(left<=right){
            int cut1=(left+right)/2;
            int cut2=k-cut1;
            int l1=(cut1==0)?Integer.MIN_VALUE:arr1[cut1-1];
            int l2=(cut2==0)?Integer.MIN_VALUE:arr2[cut2-1];
            int r1=(cut1==n)?Integer.MAX_VALUE:arr1[cut1];
            int r2=(cut2==m)?Integer.MAX_VALUE:arr2[cut2];
            if(r1>=l2 && r2>=l1){
                return Math.max(l1,l2);
            }
            else if(l1>r2){
                right=cut1-1;
            }
            else{
                left=cut1+1;
            }
        }
        return -1;
        
        
    }
}