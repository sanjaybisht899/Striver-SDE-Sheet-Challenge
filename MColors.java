public class Solution {
	public static String graphColoring(int[][] mat, int m) {
        int colors[]= new int[mat.length];
        if(helper(0,mat,m,colors)){
            return "YES";
        }
        return "NO";
	}
    public static boolean helper(int index,int mat[][],int m,int []colors){
        if(index==mat.length){
            return true;
        }
        for(int i=1;i<=m;i++){
            if(isValid(index,mat,colors,i)){
                colors[index]=i;
                if(helper(index+1,mat,m,colors)){
                    return true;
                }
                colors[index]=0;
            }
        }
        return false;
    }
    public static boolean isValid(int index,int [][]mat,int []colors,int color){
        for(int i=0;i<mat.length;i++){
            if(mat[index][i]==1 && colors[i]==color){
                return false;
            }
        }
        return true;
    }
}
