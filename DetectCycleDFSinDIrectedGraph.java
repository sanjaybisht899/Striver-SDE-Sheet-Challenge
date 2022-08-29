class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        //Making two arrays visited and recStack ,where recStack will store the already processed nodes
        //in a partiuclar path whereas the visited one will store the whole visited  nodes
        boolean visited[]  = new boolean[V];
        
        boolean recStack[] = new boolean[V];
        //calling for all the nodes
        for(int i=0;i<V;i++){
            if(dfs(i,visited,recStack,adj)){
                return true;
            }
        }
        //if everything ran smooth then it means there was no cycle present
        return false;
    }
    boolean dfs(int index, boolean visited[],boolean recStack[],ArrayList<ArrayList<Integer>> adj){
        
        //marking the node visited both in visited and the recursive stack
        visited[index]=true;
        recStack[index]=true;
        //loop through all the nodes
        for(Integer neighbors: adj.get(index)){
            if(!visited[neighbors]){
                if(dfs(neighbors,visited,recStack,adj)){
                    return true;
                }
            }
            //if it is already visited check the recursive stack if the element was already processed
            else if(recStack[neighbors]){
                return true;
            }
        }
        //marking the element out of the recusive stack
        recStack[index]=false;
        return false;
    }
}