import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String target = board[h][w];
        List<int[]> avaliableDirections = getDirections(h,w,board.length);
        
        for (int[] d : avaliableDirections) {
            if (target.equals(board[d[0]][d[1]])) {
                answer++;
            }   
        }        
        return answer;
    }
    
    private List<int[]> getDirections(int h, int w, int length) {
        List<int[]> result = new ArrayList<>();
        
        int[][] directions = {{-1,0}, {1,0}, {0,-1},{0,1}};
        
        
        for (int[] d : directions) {
            int tempH = h + d[0];
            int tempW = w + d[1];
            
            if (tempH >= 0 && tempW >= 0 && tempH < length && tempW < length) {
                result.add(new int[]{tempH, tempW});
            }
        }
        return result;
    }
}