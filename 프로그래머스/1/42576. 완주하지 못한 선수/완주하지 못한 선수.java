import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> resultMap = new HashMap<>();
        
        for(String s : participant){
            resultMap.put(s, resultMap.getOrDefault(s, 0) + 1);
        }
        
        for (String s : completion){
            resultMap.put(s, resultMap.getOrDefault(s, 0) - 1);
        }
        
        Set<String> keySet = resultMap.keySet();
        for(String s : keySet){
            if(resultMap.get(s) != 0) return s;
        }
        
        
        return answer;
    }
}