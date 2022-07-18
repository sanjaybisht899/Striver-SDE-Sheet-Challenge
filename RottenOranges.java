class Solution {
    public int orangesRotting(int[][] grid) {
        int result = 0;
        Queue <Pair> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int x=temp.i;
            int y=temp.j;
            int count=temp.count;
            result=Math.max(result,count);
            int X[]={0,0,1,-1};
            int Y[]={-1,1,0,0};
            for(int k=0;k<4;k++){
                if(x+X[k]>=0  &&  x+X[k]<grid.length && y+Y[k]>=0  &&  y+Y[k]<grid[0].length 
                  && grid[x+X[k]][y+Y[k]]==1){
                    grid[x+X[k]][y+Y[k]]=2;
                    q.add(new Pair(x+X[k],y+Y[k],count+1));
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return result;
    }
}
class Pair{
    int i;
    int j;
    int count;
    public Pair(int i,int j,int count){
        this.i=i;
        this.j=j;
        this.count=count;
    }
}