

// User function Template for Java
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
class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        boolean visited[]= new boolean [v];
        PriorityQueue <Pair> q = new PriorityQueue<>();
        q.add(new Pair(0,0));
        int res=0;
        while(!q.isEmpty()){
            Pair curr= q.remove();
            int index=curr.Vertex;
            if(visited[index]){
                continue;
            }
            res=res+curr.Weight;
            visited[index]=true;
            ArrayList<ArrayList<Integer>> N = adj.get(index);
            
            for(ArrayList<Integer> i : N){
                int ver=i.get(0);
                int w=i.get(1);
                if(!visited[ver]){
                    q.add(new Pair(ver,w));
                }
            }
        }
        return res;
        
    }
    
}