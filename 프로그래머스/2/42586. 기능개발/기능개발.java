import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        Queue<Integer> remainingdays = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int days = (int)Math.ceil( (100.0 - progresses[i]) / speeds[i]);
            remainingdays.add(days);
        }
        
        while(!remainingdays.isEmpty()){
            int value = remainingdays.poll();
            int count = 1;
            
            while(!remainingdays.isEmpty() && value >= remainingdays.peek()){
                remainingdays.poll();
                count++;
            }
            result.add(count);
            
        }
        
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}