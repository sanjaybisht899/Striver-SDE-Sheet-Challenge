class wordBreak {
    public int help(int index,String s, List<String> wordDict,HashSet <String> set,int dp[]){
        if(index==s.length()){
            return 1;
        }
        
        String temp="";
        if(dp[index]!=-1){
            return dp[index];
        }
        for(int j=index;j<s.length();j++){
            temp=temp+s.charAt(j);
            if(set.contains(temp)){
                if(help(j+1,s,wordDict,set,dp)==1){
                    return dp[index]=1;
                }
            }
        }
        return dp[index]=0;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet <String> set = new HashSet<>();
        int dp[]=new int[300];
        Arrays.fill(dp,-1);
        for(String x : wordDict){
            set.add(x);
        }
        
        return help(0,s,wordDict,set,dp)==1?true:false;
    }
}