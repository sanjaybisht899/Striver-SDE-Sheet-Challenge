/**
 * MakeStringPalindrome
 */
public class MakeStringPalindrome {

    public static int minChar(String s) {
        String s2="";
        int n=s.length();
        for(int i=s.length()-1;i>=0;i--){
            s2=s2+s.charAt(i);
        }
        int dp[][]= new int [n][n];
        for (int []temp : dp){
            Arrays.fill(temp,-1);
        }
        return s.length() - lcs(0,0,s,s2,dp);
    }
    static int lcs(int i, int j , String s1, String s2, int [][]dp){
        if(i==s1.length() || j==s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]= 1+ lcs(i+1,j+1,s1,s2,dp);
        }
        return dp[i][j] = Math.max(lcs(i,j+1,s1,s2,dp),lcs(i+1,j,s1,s2,dp));
    }
}