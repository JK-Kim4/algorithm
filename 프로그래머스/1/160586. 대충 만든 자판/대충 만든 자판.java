import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];        
        int i = 0;
        for (String target: targets) {
            char[] chars = target.toCharArray();
            
            for (char c: chars) {
                int index = -1;
                int count = 0;
                boolean find = false;
                
                for (String key: keymap) {
                    if (key.indexOf(c) > -1) {
                        if (index == -1) index = key.indexOf(c);
                        else index = Math.min(index, key.indexOf(c));
                        count++;
                    }
                }
                
                if (count > 0) {
                    answer[i] = answer[i] + (index+1);
                } else {
                    answer[i] = -1;
                    break;
                }
                
            }
            i++;
        }        
        // 4. 합
        return answer;
    }
}