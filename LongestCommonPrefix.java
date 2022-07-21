class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        int min=Integer.MAX_VALUE;
        String MIN="";
        for(String i : strs){
            if(i.length()<min){
                min=i.length();
                MIN=i;
            }
        }
        String res="";
        for(int i=0;i<MIN.length();i++){
            for(int j=0;j<strs.length;j++){
                if(strs[j].charAt(i)!=MIN.charAt(i)){
                    return res;
                }
            }
            res=res+MIN.charAt(i);
        }
        return res;
    }
}