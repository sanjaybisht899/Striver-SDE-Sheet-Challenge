class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length()-1;
        int n2=word2.length()-1;
        //if length is i making array of i+1
        int dp[][]=new int[n1+2][n2+2];
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                dp[i][j]=-1;
            }
        }
        return dp[n1+1][n2+1]=1+helper(word1,word2,n1,n2,dp);
    }
    public int helper(String word1,String word2,int index1,int index2,int dp[][]){
        //If one of them becomes -1 then return the other
        if(index1==-1){
            return index2;
        }
        if(index2==-1){
            return index1;
        }
        //if already computed then the result
        if(dp[index1][index2]!=-1){
            return dp[index1][index2];
        }
        //There can be two things either they are equal or not
        //if equal we will just update the dp
        if(word1.charAt(index1) == word2.charAt(index2)){
            return dp[index1][index2]=helper(word1,word2,index1-1,index2-1,dp);
        }
        //If not we will check for all replace,insert,delete
        else{
            int replace=1+helper(word1,word2,index1-1,index2-1,dp);
            int insert=1+helper(word1,word2,index1,index2-1,dp);
            int delete=1+helper(word1,word2,index1-1,index2,dp);
            dp[index1][index2]=Math.min(delete,Math.min(insert,replace));
        }
        // at the ennd will return the minimum of the operations that is possbile
        return dp[index1][index2];
        
    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length()-1;
        int n2=word2.length()-1;
        //Make DP array
        int dp[][]=new int[n1+2][n2+2];
        for(int i=0;i<=n1+1;i++){
            for(int j=0;j<=n2+1;j++){
                if(i==0 || j==0){
                    //put the max of i, j when one of them will be 0
                    dp[i][j]=Math.max(i,j);
                }
                else{
                    break;
                }
            }
        }
        for(int i=0;i<=n1+1;i++){
            for(int j=0;j<=n2+1;j++){
                if(i==0 || j==0){
                    continue;
                }
                //if both characters are equal then keep the i-1 and j-1 value as result
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                //else add one to result and keep the max of left,top and top left.
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
            
        }
        //at the end we will add 1 also
        return dp[n1+1][n2+1];
        
    }
    
}