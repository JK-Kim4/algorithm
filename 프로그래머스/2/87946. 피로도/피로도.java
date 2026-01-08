import java.util.*;

class Solution {
    private int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        search(k, dungeons, 0, visited);
        
        return answer;
    }
    
    public void search(int k, int[][] dungeons, int count, boolean[] visited) {
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            
            if (k >= dungeons[i][0]) {
                visited[i] = true;
                
                search(k - dungeons[i][1], dungeons, count+1, visited);
                
                visited[i] = false;
            }
        }
    }
}