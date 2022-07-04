class MatrixMedian {
    int median(int M[][], int R, int C) {
        int n=R*C;
        int left=0;
        int right=2000;
        while(left<=right){
            int mid=(right+left)/2;
            int ans=0;
            for (int i = 0; i < R; i++) {
                int l=0;
                int h=C-1;
                while(l<=h){
                    int m=l+(h-l)/2;
                    if(M[i][m]<=mid){
                        l=m+1;
                    }
                    else{
                        h=m-1;
                    }
                }
                ans=ans+l;
            }
            if(ans<=n/2){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }    
        return left;
    }
}