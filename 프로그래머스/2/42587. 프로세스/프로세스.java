import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int targetPriority = priorities[location];
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            queue.offer(new int[]{i, priorities[i]});
        }

        
        while(!queue.isEmpty()){
            boolean isMaxValue = true;
            int[] temp = queue.poll();
            
            for(int[] i : queue){
                if(temp[1] < i[1]) isMaxValue = false;
            }
            
            if(!isMaxValue){
                queue.add(temp);
                continue;
            }else{
                if(temp[0] == location) {
                    answer++;
                    break;
                }
            }
            
            answer++;
            
        }
        
        
        return answer;
    }
}