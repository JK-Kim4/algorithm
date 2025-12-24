class Solution {
    
    boolean[] visited;
    int result;
    
    public int solution(int n, int[][] computers) {
        this.visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result++;
                find(i, computers);
            }
        }
        
        return result;
    }
    
    public void find(int i, int[][] computers) {
        visited[i] = true;
        
        for (int j = 0; j < computers.length; j++) {
            if (!visited[j] && computers[i][j] == 1) {
                find(j, computers);    
            }
        }
    }
}

