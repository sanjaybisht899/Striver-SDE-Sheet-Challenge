public class CheckAnagram {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = map.get(c);
            if(count != null) {
                map.put(c, count.intValue() + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(map.containsKey(c)) {
                int count = map.get(c);
                if(--count > 0) {
                    map.put(c,count);
                } else {
                    map.remove(c);
                }
            }
        }
        
        return map.isEmpty();
    }

}
