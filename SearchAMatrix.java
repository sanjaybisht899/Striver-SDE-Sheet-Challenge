class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        //row
        int m=matrix[0].length;
        //col
        int left=0;
        int right=n*m-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            //Trick is to divide and mod by the col
            if(matrix[mid/m][mid%m]==target){
                return true;
            }
            else if(matrix[mid/m][mid%m]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return false;
    }
}