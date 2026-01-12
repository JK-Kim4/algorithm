import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int[] w : wires) {
            int a = w[0], b = w[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        int answer = Integer.MAX_VALUE;

        for (int[] w : wires) {
            int cutA = w[0], cutB = w[1];
            
            boolean[] visited = new boolean[n];
            int cnt = dfs(cutA, cutA, cutB, adj, visited);
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    
    private int dfs(int cur, int cutA, int cutB, List<Integer>[] adj, boolean[] visited) {
        visited[cur-1] = true;
        int count = 1;
        
        for (int next : adj[cur]) {
            if ((cur == cutA && next == cutB) || (cur == cutB && next == cutA)) continue;
            
            if (!visited[next-1]) {
                count += dfs(next, cutA, cutB, adj, visited);
            }
            
        }
        
        return count;
    }


}