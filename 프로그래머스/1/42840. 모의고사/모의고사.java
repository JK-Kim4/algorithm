import java.util.*;

class Solution {
    private int[] answer01 = {1,2,3,4,5};
    private int[] answer02 = {2,1,2,3,2,4,2,5};
    private int[] answer03 = {3,3,1,1,2,2,4,4,5,5};
    
    
    public int[] solution(int[] answers) {
        int[] results = new int[3];
        int maxvalue = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == answer01[i % answer01.length]) results[0]++;
            if (answers[i] == answer02[i % answer02.length]) results[1]++;
            if (answers[i] == answer03[i % answer03.length]) results[2]++;
        }
        
        for (int i : results) {
            System.out.println(i);
            if (maxvalue <= i) maxvalue = i;
        }
        
        int resultLength = 0;
        
        for (int i : results) {
            if (i == maxvalue) resultLength++;
        }
        
        int[] answer = new int[resultLength];
        int idx = 0;
        
        for (int i = 0; i < results.length; i++) {
            if (results[i] == maxvalue) answer[idx++] = i+1;
        }
    
        
        return answer;
    }
}