class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        //defined a visted array to check whether we have processed the array or not
        boolean visited[] = new boolean[V];
        //Storing the parent so that it can differenciate who call them
        int parent[] = new int[V];
        //Queue for storing all the elements in the Queue
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            //using this so that we can cover the disconnected components also
            
            if(!visited[i]){
                //adding the first element of the component in the queue and marking it visited
                q.add(i);
                visited[i]=true;
                //since it is parent assigning its value to -1
                parent[i]=-1;
                
                //loop till q is empty
                while(!q.isEmpty()){
                    
                    int curr= q.poll();
                    
                    //looping for all the adjacent nodes
                    for(Integer neighbours : adj.get(curr)){
                        
                        if(!visited[neighbours]){
                            //if not visited marking it true and making curr its parent
                            visited[neighbours]=true;
                            parent[neighbours]=curr;
                            q.add(neighbours);
                            
                        }
                        //if its is not called by parent then there is loop 
                        else if(parent[curr]!=neighbours){
                            return true;
                        }
                        
                    }
                    
                }
                
            }
        }
        return false;        
    }
}