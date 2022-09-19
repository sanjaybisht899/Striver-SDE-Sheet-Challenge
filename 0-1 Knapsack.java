class Solution {
  public int findMaxForm(String[] strs, int m, int n) {
      int x=strs.length;
      int count[]=new int[x];
      Arrays.fill(count,-1);
      int dp[][][]=new int [x][m+1][n+1];
      for(int i=0;i<x;i++){
          for(int j=0;j<=m;j++){
              for(int k=0;k<=n;k++){
                  dp[i][j][k]=-1;
              }
          }
      }
      return helper(0,strs,m,n,dp,count);
  }
  public int helper(int index,String []strs,int m,int n,int dp[][][],int count[]){
      if(index==strs.length || m==0 && n==0){
          return 0;
      }
      if(dp[index][m][n]!=-1){
          return dp[index][m][n];
      }
      String temp = strs[index];
      int zero=0;
      if(count[index]==-1){
          for(int i=0;i<temp.length();i++){
              if(temp.charAt(i)=='0'){
                  zero++;
              }
          }
          count[index]=zero;
      }
      zero=count[index];
      int ones=temp.length()-zero;
      int tmp=0;
      if(m>=zero && n>=ones){
          zero=m-zero;
          ones=n-ones;
          tmp=1+helper(index+1,strs,zero,ones,dp,count);
              
      }
      return dp[index][m][n]=Math.max(tmp,helper(index+1,strs,m,n,dp,count));
      
  }
}

class GFG{
public static int countString(int m, int n, String []strs){
  // dynamic programming table for subset making up to m zeros and n ones
  int[][] dp = new int[m+1][n+1];
  // scan each string
  for(String s:strs){
    //counting zero's in variable z
    int z=0;
    for(int i=0;i<s.length();i++){
       if(s.charAt(i)=='0'){
          z++;
       }
     }
    //putting ones in variable o
     int o=s.length()-z;
	// maximize subset size from growing on smaller cases with string
     for(int zero=m;zero>=z;zero--){
       for(int one=n;one>=o;one--){
         dp[zero][one]=Math.max(dp[zero-z][one-o]+1,dp[zero][one]);
       }
     }
  }
  // return the maximum
  return dp[m][n];
}
 
// Driver Code
public static void main(String[] args)
{
    String []arr = { "10", "0001", "1",
                           "111001", "0" };
 
    // N 0's and M 1's
    int N = 3, M = 5;
    // Function call
    System.out.print(countString(M, N, arr));
}
}

// This code is contributed by sanjaybisht8999
