import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothCount = new HashMap<>();
        
        for(String[] arr : clothes){
            clothCount.put(arr[1], clothCount.getOrDefault(arr[1], 0) + 1);
        }


        for(Integer i : clothCount.values()){
            answer *= (i + 1);
        }
        
        return answer-1;
    }
}