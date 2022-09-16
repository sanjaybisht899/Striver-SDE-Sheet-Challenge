class Solution
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S){
        int result [] = new int[V];
        
        Arrays.fill(result,100000000);
        
        //S is Starting element 
        result[S]=0;
        //No of time we have to do this operation
        int count=V;
        while(count>=0){
            //Looping through all the elements to find the shortest distance
            for(ArrayList<Integer> neighbour : adj){
                int source=neighbour.get(0);
                int destination=neighbour.get(1);
                int distance=neighbour.get(2);
                //if found then update
                if(result[destination]>result[source]+distance){
                    result[destination]= result[source]+distance;
                }
            }
            count--;
        }
        
        return result;
        
    }
}

