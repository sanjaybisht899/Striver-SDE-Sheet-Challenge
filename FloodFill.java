class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        else{
            int source=image[sr][sc];
            image[sr][sc]=color;
            callAll(image,sr,sc,source,color);
        }
        return image;
    }
    public void callAll(int [][]image, int i,int j,int source,int color){
        int dx[]={-1,1,0,0};
        int dy[]={0,0,-1,1};
        //left right up down
        
        for(int a=0;a<4;a++){
            int x=i+dx[a];
            int y=j+dy[a];
            if(x==-1 || y ==-1 || x>=image.length || y>=image[0].length || image[x][y]==color){
                continue;
            }
            if(image[x][y]==source){
                image[x][y]=color;
                callAll(image,x,y,source,color);
            }
            
        }
    }
}