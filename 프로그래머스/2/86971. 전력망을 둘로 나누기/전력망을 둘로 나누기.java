import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] adj = new ArrayList[n+1];
        
        int answer = Integer.MAX_VALUE;
        
        // parameters set
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList();
        }
        
        for (int[] wire : wires) {
            adj[wire[0]].add(wire[1]);
            adj[wire[1]].add(wire[0]);
        }
        
        // dfs
        for (int[] wire : wires) {
            boolean[] visited = new boolean[n+1];
            // wire 끊은 상태로 순회하며 count 
            int count = dfs(wire[0], wire[0], wire[1], visited, adj);
            int diff = Math.abs(count - (n - count));
            
            answer = Math.min(diff, answer);
        }
        
        return answer;
    }
    
    private int dfs(int cur, int cutA, int cutB, boolean[] visited, List<Integer>[] adj) {
        int count = 1;
        visited[cur] = true;
        
        // cur에 연결되어있는 좌표 중 방문하지 않은 노드를 찾아 재귀호출
        for (int i : adj[cur]) {
            if ((cur == cutA && i == cutB) || (cur == cutB && i == cutA)) continue;
            
            
            if (!visited[i]) {
                count += dfs(i, cutA, cutB, visited, adj);
            }
        }
        
        return count;
    }
    
    


}