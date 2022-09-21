
class Solution {
    public int minPathSum(int[][] grid) {
        return helper(grid,0,0);
    }
    public int helper(int [][]grid,int i,int j){
	//Base Case
	//If we will reach at the last index will just return that value
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
		//Making a curr variable and putting max so that it will always get the minimum 
        int curr=Integer.MAX_VALUE;
		//Checking for out of bounds and moving to the right
        if(j+1<grid[0].length){
            curr=Math.min(curr,grid[i][j]+helper(grid,i,j+1));
        }
		//checking for the out of bounds and moving to down
        if(i+1<grid.length){
            curr=Math.min(curr,grid[i][j]+helper(grid,i+1,j));
        }
		//At the end we will have the minimum and will return that.
        return curr;
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length-1;
        int n=grid[0].length-1;
        //Making a DP array and putting MAX_VALUE in it
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        return helper(grid,0,0,dp);
    }
    public int helper(int [][]grid,int i,int j,int dp[][]){
        //Base case if reach at the end just return the last index value
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        //If we have already computed the value will just return that
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        //Making right and down and setting them as MAX so that we will get minimum everytime
        int right=Integer.MAX_VALUE,down=Integer.MAX_VALUE;
        //checking for out of bound and moving to right
        if(j+1<grid[0].length){
            right=grid[i][j]+helper(grid,i,j+1,dp);
        }
        //same for down
        if(i+1<grid.length){
            down=grid[i][j]+helper(grid,i+1,j,dp);
        }
        //return the minimum
        return dp[i][j]=Math.min(right,down);
    }
}


class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        /*
        Filling the left and right side first
        
        1 3 1    
        1 5 1
        4 2 1  
        
        For this it will be 
        
        1 4 5
        2 0 0
        6 0 0
        
        */
        dp[0][0]=grid[0][0];
        for(int i=1;i<n;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for(int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        
        
        //Now starting for 1st row and 1 col
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //everytime checking for the left side and top side
                dp[i][j]=grid[i][j]+Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }
        //return the last element at the end
        return dp[m-1][n-1];
    }
}