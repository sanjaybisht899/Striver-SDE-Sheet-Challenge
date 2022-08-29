class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        //Result array for storing the visited values
        ArrayList<Integer> result = new ArrayList<>();
        
        boolean visited[]=new boolean[V];
        
        //we will store the adjacent elements in the queue
        Queue <Integer> q = new LinkedList<>();
        //adding the first element in the queue and marking it visited
        q.add(0);
        visited[0]=true;
        
        //loop till we will get the all the nodes of the graph
        while(!q.isEmpty()){
            int curr = q.poll();
            //adding all the nodes in the current 
            result.add(curr);
            //visiting all the adjacent elements of the current node 
            for(Integer neighbours : adj.get(curr)){
                if(!visited[neighbours]){
                    visited[neighbours]=true;
                    q.add(neighbours);
                }
            }
        }
        
        return result;
        
    }
}

class BFS{
    private static boolean bfs(ArrayList<ArrayList<Integer>> adj, int src, int dest, int v, int pred[], int dist[]){
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[]=new boolean[v];
        for (int i = 0; i < V ; i++) {
            visited[i] = false;
            dist[i]=Integer.MAX_VALUE;
            pred[i]=-1;
        }
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        while (!queue.isEmpty()) {
            int cur = queue.remove();
            for (int i = 0; i < adj.get(u). size(); i++) {
                int neighbor = adj.get(u).get(i);
                if (visited[neighbor] == false) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[cur] + 1;
                    pred[neighbor] = cur;
                    queue .add(neighbor);

                    if (neighbor == dest){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        int v = 6;
        int e = 8;
    
     
    
        int pred[] = new int[v+1];
        int dist = new int[v+1];
        boolean vis[] = new boolean[v+1];
    
        int isReached = dfs(adj, 1, 6, v, pred, dist);

        

        int components = 0;

        for(int i = l; i<=v; i++) {
            if(!vis[i]) {
                components++;
                dfs(adj, 1, 6, v, pred, dist, vis);
            }
        }
    }
}

    

