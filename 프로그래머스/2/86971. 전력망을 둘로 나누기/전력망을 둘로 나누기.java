import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] adj = new ArrayList[n + 1];
        int answer = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList();
        }
        
        for (int[] wire : wires) {
            adj[wire[0]].add(wire[1]);
            adj[wire[1]].add(wire[0]);
        }
        
        for (int[] wire : wires) {
            boolean[] visited = new boolean[n + 1];
            int count = dfs(wire[0], wire[0], wire[1], visited, adj);
            int diff = Math.abs(count - (n - count));
            answer = Math.min(diff, answer);
        }
            

        return answer;
    }
    
    
    private int dfs(int cur, int cutA, int cutB, boolean[] visited, List<Integer>[] adj) {
        int count = 1;
        visited[cur] = true;
        
        for (int next : adj[cur]) {
            if ((cur == cutA && next == cutB) || (cur == cutB && next == cutA)) continue;
            
            if (!visited[next]) {
                count += dfs(next, cutA, cutB, visited, adj);
            }
        }

        return count;
    }
}