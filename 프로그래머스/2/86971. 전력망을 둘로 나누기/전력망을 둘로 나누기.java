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

            boolean[] visited = new boolean[n + 1];
            int cnt = dfsCount(cutA, cutA, cutB, adj, visited); // cutA 쪽 컴포넌트 크기
            int diff = Math.abs(n - 2 * cnt);
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    private int dfsCount(int cur, int cutA, int cutB,
                         List<Integer>[] adj, boolean[] visited) {
        visited[cur] = true;
        int count = 1;

        for (int next : adj[cur]) {
            // 이번 루프에서 끊은 간선은 통과 금지
            if ((cur == cutA && next == cutB) || (cur == cutB && next == cutA)) continue;
            if (!visited[next]) {
                count += dfsCount(next, cutA, cutB, adj, visited);
            }
        }
        return count;
    }
}