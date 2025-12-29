import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> requiredDays = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            requiredDays.offer((int)Math.ceil( (100.0 - progresses[i]) / speeds[i]));
        }
        
        while (!requiredDays.isEmpty()) {
            int count = 1;
            int days = requiredDays.poll();
            
            while (!requiredDays.isEmpty() && requiredDays.peek() <= days) {
                requiredDays.poll();
                count++;
            }
            
            answer.add(count);
        }
        
        int[] result = new int[answer.size()];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        

        return result;
    }
}