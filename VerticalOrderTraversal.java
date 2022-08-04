/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result =  new ArrayList<>();
        Queue <Pair> q = new LinkedList<>();
        TreeMap <Integer, TreeMap<Integer,PriorityQueue<Integer>>> map= new TreeMap<>();
        q.add(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            if(map.containsKey(temp.h)){
                if(map.get(temp.h).containsKey(temp.l)){
                    map.get(temp.h).get(temp.l).add(temp.node.val);
                }
                else{
                    PriorityQueue <Integer> pq = new PriorityQueue<>();
                    pq.add(temp.node.val);
                    TreeMap <Integer,PriorityQueue<Integer>> tempmap = new TreeMap<>();
                    tempmap.put(temp.l,pq);
                    (map.get(temp.h)).put(temp.l,pq);
                }
            }
            else{
                PriorityQueue <Integer> pq = new PriorityQueue<>();
                pq.add(temp.node.val);
                TreeMap <Integer,PriorityQueue<Integer>> tempmap = new TreeMap<>();
                tempmap.put(temp.l,pq);
                map.put(temp.h,tempmap);
                
            }
            if(temp.node.left!=null)
            q.add(new Pair(temp.node.left,temp.h-1,temp.l+1));
            
            if(temp.node.right!=null)
            q.add(new Pair(temp.node.right,temp.h+1,temp.l+1));
        }
        for(Map.Entry<Integer, TreeMap<Integer,PriorityQueue<Integer>>> e : map.entrySet()){
            result.add(new ArrayList <> ());
            TreeMap <Integer, PriorityQueue<Integer>> tmp  = e.getValue();
            for(Map.Entry<Integer, PriorityQueue<Integer>> ee : tmp.entrySet()){
                PriorityQueue <Integer> pq = ee.getValue();
                while (!pq.isEmpty()) {
                    result.get(result.size() - 1).add(pq.poll());
                }
            }
        }
        return result;
        
    }
    class Pair{
        int h;
        int l;
        TreeNode node;
        Pair( TreeNode y,int x,int ll){
            node=y;
            h=x;
            l=ll;
        }
    }
}