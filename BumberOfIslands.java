class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int islands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    islands++;
                    dfs(i,j,m,n,grid,visited);
                }
            }
        }
        return islands;
        
    }
    public void dfs(int i,int j, int m, int n, char [][]grid,boolean[][]visited){
        visited[i][j]=true;
        int dy[]={-1,1,0,0};
        int dx[]={0,0,-1,1};
        
        for(int a=0;a<4;a++){
            int y=j+dy[a];
            int x=i+dx[a];
            
            if(x>=0 && x<m && y>=0 && y<n){
                if(!visited[x][y] &&  grid[x][y]=='1'){
                    dfs(x,y,m,n,grid,visited);
                }
            }
        }
        
    }
    
    
}