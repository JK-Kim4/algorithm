import java.util.*;

class Solution {
    public int solution(String before, String after) {
        Map<Character, Integer> beforeM = new HashMap();
        Map<Character, Integer> afterM = new HashMap();
        
        for (char c : before.toCharArray()) {
            beforeM.putIfAbsent(c, 0);
            beforeM.put(c, beforeM.get(c) + 1);   
        }
        
        
        for (char c : after.toCharArray()) {
            afterM.putIfAbsent(c, 0);
            afterM.put(c, afterM.get(c) + 1);   
        }
        
        
        for (char c : after.toCharArray()) {
            if (beforeM.get(c) != afterM.get(c)) {
                return 0;
            } 
        }
        
        return 1;
    }
}