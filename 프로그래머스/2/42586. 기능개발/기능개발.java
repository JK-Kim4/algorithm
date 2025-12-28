import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> result = new ArrayList();
        
        Queue<Integer> remainingDays = new LinkedList();
        
        for (int i = 0; i < progresses.length; i++) {
            int remainDay = (int)Math.ceil(((double)(100 - progresses[i]) / speeds[i]));
            remainingDays.add(remainDay);
        }
        
        while (!remainingDays.isEmpty()) {
            int count = 1;
            int days = remainingDays.poll();
            while (!remainingDays.isEmpty() && remainingDays.peek() <= days) {
                remainingDays.poll();
                count++;
            }
            result.add(count);
        }

        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        }
}