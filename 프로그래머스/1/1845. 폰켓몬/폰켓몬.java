import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int maxSize = nums.length/2;
    
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        for(int i : nums){
            if(map.size() <  maxSize) map.put(i, true);   
        }
        
        
        
        return map.size();
    }
}