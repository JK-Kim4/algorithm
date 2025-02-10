import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        
        for(int[] intA : commands){
            
            if(intA[0] == intA[1]) {
                answer[idx++] = array[intA[0]-1];
                continue;
            } else {
                int[] temp = Arrays.copyOfRange(array, intA[0]-1, intA[1]);
                Arrays.sort(temp);
                answer[idx++] = temp[intA[2]-1];
            }
        }
        return answer;
    }
}