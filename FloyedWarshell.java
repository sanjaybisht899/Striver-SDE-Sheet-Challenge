class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        
        //Total number of vertices
        int n = matrix.length;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    //if path is not present from i to k or k to i then skip
                    if(matrix[i][k]==-1 || matrix[k][j]==-1){
                        continue;
                    }
                    
                    int alternate_path=matrix[i][k] + matrix[k][j];
                    
                    //if there is no path between i & j then assign alternate path
                    //or if the path existing path is greater than the alternate then replace too
                    if(matrix[i][j]==-1  || matrix[i][j]!=-1 && (matrix[i][j]>alternate_path)){
                        matrix[i][j]=alternate_path;
                    }
                }
            }
        }
    }
}