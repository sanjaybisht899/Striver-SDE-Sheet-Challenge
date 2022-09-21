class Solution{
    static int matrixMultiplication(int n, int a[])
    {
        int dp[][]=new int[n][n];
        
        for(int len=2;len<n;len++){
            
            int col = len;
            for(int row=0;row<n-len;row++){
                
                dp[row][col] = Integer.MAX_VALUE;
                for(int k=row+1;k<col;k++){
                    dp[row][col]=Math.min(dp[row][col],
                    dp[row][k]+dp[k][col]+
                    a[row]*a[col]*a[k]
                    );
                }
                col++;
            }
        }
        
        return dp[0][n-1];
    }
}