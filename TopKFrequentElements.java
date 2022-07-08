class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        
        for (int val : map.keySet()) {
            pq.add(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[pq.size()];
        
        while (!pq.isEmpty()) {
            result[--k] = pq.poll();
        }
        return result;
    }
}