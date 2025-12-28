import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        int start = 0;
        int end = gems.length-1;
        
        Set<String> gemSet = new HashSet<>(List.of(gems));
        
        int startPointer = 0;
        int endPointer = startPointer;
        Map<String, Integer> includes = new HashMap();
        includes.put(gems[0], 1);
        
        
        while (startPointer < gems.length-1) {
            if (includes.keySet().size() == gemSet.size()) {
                if (endPointer - startPointer < end - start) {
                    start = startPointer;
                    end = endPointer;
                }
                
                includes.put(gems[startPointer], includes.get(gems[startPointer]) - 1);
                if (includes.get(gems[startPointer]) == 0) {
                    includes.remove(gems[startPointer]);
                }
                
                startPointer++;
            } else if (endPointer < gems.length -1 ) {
                
                endPointer++;
                includes.put(gems[endPointer], includes.getOrDefault(gems[endPointer], 0) + 1);
                
            } else {
                break;
            }
            
        }
        
        
        
        return new int[]{start + 1, end + 1};
    }
}