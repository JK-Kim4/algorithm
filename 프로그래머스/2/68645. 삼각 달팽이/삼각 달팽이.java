class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
        //1. n x n 2차원 배열 선언
        int[][] grid = new int[n][n];
        int v = 1;
        
        //2. 숫자를 채울 현재 위치를 (0,0)으로 선언
        int x = 0;
        int y = 0;
        
        //3. 반시계 반향을 따라 이동하며 숫자 채움
        while(true){
            //아래 이동
            while(true){
                grid[y][x] = v++;
                if( y + 1 == n || grid[y+1][x] != 0) break;
                y++;
            }
            if(x + 1 == n ||  grid[y][x + 1] != 0) break;
            x++;
            
            
            //오른쪽으로 이동
            while(true){
                grid[y][x] = v++;
                if( x + 1 == n || grid[y][x + 1] != 0) break;
                x++;
            }
            if(grid[y-1][x-1] != 0) break;
            x--; y--;
            
            //왼쪽 위로 이동
            while(true){
                grid[y][x] = v++;
                if (grid[y-1][x-1] != 0) break;
                y--;x--;
            }
            if(y + 1 == n || grid[y+1][x] != 0) break;
            y++;
        }
        
        //4. 채워진 숫자를 1차원 배열에 옮겨 반환
        answer = new int[v-1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++){
                answer[index++] = grid[i][j];
            }
        }
        
        
        return answer;
    }
}