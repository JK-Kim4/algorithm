class Solution {
    public int[] solution(int n) {
        //1.전달받은 파라미터로 n x n 2차원 배열 생성
        int[][] answer = new int[n][n];        
        int x = 0;
        int y = 0;
        int value = 1; 
        
        //2. 값 입력 반복
        while (true) {
            
            //2.A 아래(y+1)로 이동
            while (true) {
                answer[y][x] = value++;
                if (y + 1 == n || answer[y+1][x] != 0) break;
                y++;
            }
            
            if (x + 1 == n || answer[y][x+1] != 0) break;
            x++;
            
            //2.B 오른쪽(x+1)로 이동
            while (true) {
                answer[y][x] = value++;
                if (x + 1 == n || answer[y][x+1] != 0) break;
                x++;
            }
            
            if (y-1 < 0 || x-1 < 0 || answer[y-1][x-1] != 0) break;
            x--;
            y--;
            
            //2.C 좌상(x-1, y-1)으로 이동
            while (true) {
                answer[y][x] = value++;
                
                if (y-1 < 0 || x-1 < 0 || answer[y-1][x-1] != 0) break;
                x--;
                y--;
            }
            
            if (y < 0 || y > n - 1 || answer[y + 1][x] != 0) break;
            y++;
            
        }
        
        int[] result = new int[value-1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i+1; j++) {
                result[index++] = answer[i][j];
            }
        }
        
        
        return result;
    }
}