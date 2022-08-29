class Solution
{
    //Function to return list containing vertices in Topological order. 
    static boolean DetechCycle(int V, ArrayList<ArrayList<Integer>> adj) 
    {

        //using topoloical sort , as topological sort is possible only if there is no cycle present 

        // result of the topological sort
        int topo[]= new int[V];
        // counting the indegree of all the elements
        int indegree[] = new int[V];
        for(int i=0;i<V;i++){
            for(Integer x: adj.get(i)){
                indegree[x]++;
            }
        }
        
        //will add all the elements whose indegree is 0 to queue 
        Queue <Integer> q = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        //print the elements in the q and keep on decreasing the indegree till we reach the end
        int index=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            topo[index++]=curr;
            //looping through the other elements
            for(Integer neighbours: adj.get(curr)){
                if(indegree[neighbours]!=0){
                    indegree[neighbours]--;
                    if(indegree[neighbours]==0){
                        q.add(neighbours);
                    }
                }
            }
            
        }
        
        if (index!=V){
            return true;
        }
        return false;
    }
}
