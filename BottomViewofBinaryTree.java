class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> arr= new ArrayList<>();
        Queue <Pair> q = new LinkedList<>();
        TreeMap <Integer, Integer> map= new TreeMap<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            map.put(temp.h,temp.node.data);
            if(temp.node.left!=null)
            q.add(new Pair(temp.node.left,temp.h-1));
            
            if(temp.node.right!=null)
            q.add(new Pair(temp.node.right,temp.h+1));
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            arr.add(e.getValue());
        }
        return arr;
    }
    static class Pair{
        int h;
        Node node;
        Pair( Node y,int x){
            node=y;
            h=x;
        }
    }
}