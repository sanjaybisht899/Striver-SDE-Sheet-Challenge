class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> result= new ArrayList<>();
        int dx[]= {1,0,0,-1};
        int dy[]= {0,-1,1,0};
        String S="DLRU";
        HashSet<String> set = new HashSet<>();
        int visited[][]=new int [n][n];
        if(m[0][0]==1){
            helper(0,0,visited,m,"",result,dx,dy,S);
        }
        return result;
    }
     static void helper(int i,int j, int visited[][], int [][]m,String move,
     ArrayList<String> result,int []dx, int []dy, String S){
         int n=visited.length;
        if(i==n-1 && j ==n-1){
            
                result.add(move);
            
            return;
        }
        for(int index=0;index<4;index++){
            int xindex=i+dx[index];
            int yindex=j+dy[index];
            if(xindex<n && yindex<n && xindex>=0 && yindex>=0 && m[xindex][yindex]==1 && visited[xindex][yindex]!=1 ){
                visited[i][j]=1;
                helper(xindex,yindex,visited,m,move+S.charAt(index),result,dx,dy,S);
                visited[i][j]=0;
            }
        }
    }
}