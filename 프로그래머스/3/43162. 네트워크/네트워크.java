class Solution {
    
    private int result;
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        this.visited = new boolean[n];
        
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                this.result++;
                this.dfs(i, computers);
            }
        }
        
        return this.result;
    }
    
    public void dfs(int i, int[][] computers){
        this.visited[i] = true;
        
        for(int j = 0; j < computers.length; j++){
            if( !visited[j] && computers[i][j] == 1 ){
                dfs(j, computers);
            }
        }
    }
    
}
