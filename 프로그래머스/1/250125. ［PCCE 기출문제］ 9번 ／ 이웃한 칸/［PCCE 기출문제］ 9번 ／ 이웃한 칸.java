class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int boradLength = board.length;
        
        int top = h - 1;
        int bottom = h + 1;
        int left = w - 1;
        int right = w + 1;
        
        String target = board[h][w];

        if (top >= 0 && board[top][w].equals(target)) {
            answer++;
        }
        
        if (bottom <= boradLength -1 && board[bottom][w].equals(target)) {
            answer++;
        }
        
        if (left >= 0 && board[h][left].equals(target)) {
            answer++;
        }
        
        if (right <= boradLength -1 && board[h][right].equals(target)) {
            answer++;
        }
        
        
        
        return answer;
    }
}