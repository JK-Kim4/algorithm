class Solution {
    
    private boolean[] visited;
    private int result;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                this.result++;
                this.find(i, computers);    
            }
        }
        
        
        return this.result;
    }
    
    public void find(int i, int[][] computers) {
        this.visited[i] = true;
        int[] c = computers[i];
        
        for (int j = 0; j < c.length; j++) {
            if (!visited[j] && c[j] == 1) {
                this.find(j, computers);
            }
        }
    }
    
}
