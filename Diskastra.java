class Solution
{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        boolean visited[]= new boolean [V];
        PriorityQueue <Pair> q = new PriorityQueue<>();
        int result [] = new int[V];
        //Filling Array with the maximum Value possible
        Arrays.fill(result,10000000);
        //Filling the distance to react out of node 0
        result[S]=0;
        //adding the first node in the queue to start processing the 
        q.add(new Pair(S,0));
        
        while(!q.isEmpty()){
            Pair curr= q.remove();
            int index=curr.Vertex;
            if(visited[index]){
                continue;
            }
            //Marking that node visited
            visited[index]=true;
            
            ArrayList<ArrayList<Integer>> neightbours = adj.get(index);
            //looping through all the neighbours
            for(ArrayList<Integer> nodes : neightbours){
                int vertex=nodes.get(0); 
                int weight=nodes.get(1);
                //if for the given node distance is less while traveling through index
                //then update it to the shortest
                if(result[vertex]>result[index]+weight){
                    result[vertex]=result[index]+weight;
                    //add the updated distance in the priorityqueue
                    q.add(new Pair(vertex,result[vertex]));
                }
            }
        }
        return result;
        
    }
}
class Pair implements Comparable<Pair>{
    int Vertex;
    int Weight;
    public Pair(int v, int w){
        Vertex=v;
        Weight=w;
    }
    public int compareTo(Pair that){
        return this.Weight-that.Weight;
    }
}

