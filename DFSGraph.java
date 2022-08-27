class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        //Creating a visted array to store whether we have travesed the particular node or not
        boolean visited[] = new boolean[V];
        //To Store the elements
        ArrayList <Integer> result = new ArrayList<>();
        //Need stack to put the elemenets for DFS
        
        //calling for the 0th element
        dfs(0,adj,visited,result);
        
        //returning result back
        return result;
    }
    public void dfs(int index, ArrayList<ArrayList<Integer>> adj , boolean visited[], ArrayList<Integer> result){
        
        //marking the particular index true as visited
        visited[index]=true;
        //storing the element in the result
        result.add(index);
        //checking all the nodes for the particular element and calling them
        for(Integer i : adj.get(index)){
            if(!visited[i]){
                dfs(i,adj,visited,result);
            }
        }
    }
}