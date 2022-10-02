class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0,0,m-1,n-1);
    }
    public int helper(int i,int j,int m,int n){
        if(i==m && j==n){
            return 1;
        }
        int result=0;
        if(i+1<=m){
            result+=helper(i+1,j,m,n);    
        }
        if(j+1<=n){
            result+=helper(i,j+1,m,n);    
        }
        return result;
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        return helper(0,0,m-1,n-1,dp);
    }
    public int helper(int i,int j,int m,int n,int dp[][]){
        if(i==m && j==n){
            return 1;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int result=0;
        if(i+1<=m){
            dp[i+1][j]=helper(i+1,j,m,n,dp);
            result+=dp[i+1][j];    
        }
        if(j+1<=n){
            dp[i][j+1]=helper(i,j+1,m,n,dp);
            result+=dp[i][j+1];    
        }
        return dp[i][j]=result;
    }
}