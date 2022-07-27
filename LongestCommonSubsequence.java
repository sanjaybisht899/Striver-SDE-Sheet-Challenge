/**
 * LongestCommonSubsequence
 */
public class LongestCommonSubsequence {
    //Brute Force Comparing the First Element
    static int lcs(int x, int y, String s1, String s2)
    {
        if(x==0 || y==0){
            return 0;
        }
        
        if(s1.charAt(0)==s2.charAt(0)){
            return 1 + lcs(x-1,y-1,s1.substring(1,x),s2.substring(1,y));
        }
        
        return 0 + Math.max(lcs(x,y-1,s1,s2.substring(1,y)), 
            lcs(x-1,y,s1.substring(1,x),s2));
        
    }
    //Brute Force Comparing the Last Element
    static int lcs2(int x, int y, String s1, String s2)
    {
        if(x==0 || y==0){
            return 0;
        }
        
        if(s1.charAt(x-1)==s2.charAt(y-1)){
            return 1 + lcs2(x-1,y-1,s1,s2);
        }
        
        return Math.max(lcs2(x,y-1,s1,s2), 
            lcs2(x-1,y,s1,s2));
        
    }
    static int lcs(int x, int y, String s1, String s2)
    {
        int dp[][] = new int[x+1][y+1];
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                dp[i][j]=-1;
            }
        }
        return lcsUtil(x,y,s1,s2,dp);
        
    }
    static int lcsUtil(int x, int y, String s1, String s2,int dp[][])
    {
        
        if(x==0 || y==0){
            return 0;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        if(s1.charAt(x-1)==s2.charAt(y-1)){
            return dp[x][y] = 1 + lcsUtil(x-1,y-1,s1,s2,dp);
            
        }
        
        return dp[x][y] = Math.max(lcsUtil(x,y-1,s1,s2,dp), 
            lcsUtil(x-1,y,s1,s2,dp));
        
    }

    static int lcs(int x, int y, String s1, String s2)
    {
        int dp[][] = new int[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                dp[i][j]=-1;
            }
        }
        return lcsUtil(0,0,s1,s2,dp);
        
    }
    //Function to find the length of longest common subsequence in two strings.
    static int lcsUtil(int x, int y, String s1, String s2,int dp[][])
    {
        if(x==s1.length() || y==s2.length()){
            return 0;
        }
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        if(s1.charAt(x)==s2.charAt(y)){
            return dp[x][y] = 1 + lcsUtil(x+1,y+1,s1,s2,dp);
        }
        
        return dp[x][y] = Math.max(lcsUtil(x,y+1,s1,s2,dp), lcsUtil(x+1,y,s1,s2,dp));
        
    }

    public static void main(String[] args) {
        
    }
}