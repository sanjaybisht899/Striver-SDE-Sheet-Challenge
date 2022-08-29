class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // result of the topological sort
        int topo[]= new int[V];
        
        boolean visited[]= new boolean[V];
        
        Stack <Integer> stack = new Stack<>();
        
        //Simple DFS
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,stack,visited,adj);
            }
        }
        
        //Storing the elements in reverse order
        int i=0;
        while(!stack.isEmpty()){
            topo[i++]=stack.pop();
        }
        
        return topo;
    }
    static void dfs(int x,Stack <Integer> stack,boolean []visited,ArrayList<ArrayList<Integer>> adj){
        
        visited[x]=true;
        
        for(Integer i : adj.get(x)){
            if(!visited[i]){
                dfs(i,stack,visited,adj);
            }
        }
        //Pushing the element in the last to maintain toplogical order
        stack.push(x);
    }
}
