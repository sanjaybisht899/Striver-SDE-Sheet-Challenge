class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        //Making adjaceney matrix
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> temp = new ArrayList<>();
            for(Integer x : graph[i]){
                temp.add(x);
            }
            adj.add(temp);
        }
        //color array in place of visited to store the colors either 1 or 2
        int color[] = new int[n];
        for(int i=0;i<n;i++){
            if(color[i]==0){
                //if found same color for both i index and its neibours then return false;
                if(dfs(i,color,adj,2)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int index, int []color,List<List<Integer>> adj,int parent){
        //if parent was 2 then we will assign 1 to the current node
        //it will be always different for the both the parent and the node
        if(parent==2){
            color[index]=1;
        }
        else{
            color[index]=2;
        }
        //looping through all the neighbours
        for(Integer neighbours: adj.get(index)){
            //if color of neighbours and the current is same return true
            if(color[neighbours]==color[index]){
                return true;
            }
            //if color is not define make dfs call to color that element
            else if(color[neighbours]==0){
                if(dfs(neighbours,color,adj,color[index])){
                    return true;
                }
            }
        }
        return false;
    }
}
Using BFS

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        //Making adjaceney matrix
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> temp = new ArrayList<>();
            for(Integer x : graph[i]){
                temp.add(x);
            }
            adj.add(temp);
        }
        //color array like visited to store the colors
        int color[] = new int[n];
        //here we will be adding pair in the queue as we need parent color
        //and the color node
        Queue <Pair> queue = new LinkedList<>();
        
        //looping through all the components
        for(int i=0;i<n;i++){
            if(color[i]==0){
                //adding the parent color as 2
                queue.add(new Pair(i,2));
                while(!queue.isEmpty()){
                    Pair temp=queue.poll();
                    int index=temp.node;
                    //if parent was 2 then we will assign 1 to the current node
                    //it will be always different for the both the parent and the node
                    int parent=temp.color;
                    if(parent==2){
                        color[index]=1;
                    }
                    else{
                        color[index]=2;
                    }
                    //looping through all the neighbours
                    for(Integer neighbour: adj.get(index)){
                        //if neighbour and current index have same color return false
                        if(color[index]==color[neighbour]){
                            return false;
                        }
                        //if color is not fill put that in queue 
                        //along with the called parent color
                        else if(color[neighbour]==0){
                            queue.add(new Pair(neighbour,color[index]));
                        }
                    }
                    
                }
            }
        }
        //at the end if no diffenent color was found return true
        return true;
    }
}
class Pair{
    int node;
    int color;
    public Pair(int node,int color){
        this.color=color;
        this.node=node;
    }
}