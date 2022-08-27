class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        //defined a visted array to check whether we have processed the array or not
        boolean visited[] = new boolean[V];
        //looping to all the vertices 
        for(int i=0;i<V;i++){
            if(!visited[i]){
                //if it will be true then our graph have a cycle
                //we are passing -1 as parent as its the root note 
                if(dfs(i,visited,adj,-1)){
                    return true;
                }
                
            }
        }
        return false;        
    }
    boolean dfs(int index,boolean []visited, ArrayList<ArrayList<Integer>> adj,int parent){
        //Marking the traversed node visited
        visited[index]=true;
        
        
        for(Integer i : adj.get(index)){
            //we will skip if it is our parent otherwise we will continue
            if(i==parent){
                continue;
            }
            // if it is not our parent and still visisted then there is a loop
            if(visited[i]){
                return true;
            }
            //calling the dfs for the other adjacent nodes
            if(dfs(i,visited,adj,index)){
                return true;
            }
        }
        //returning false if there was no loop found
        return false;
    }
}