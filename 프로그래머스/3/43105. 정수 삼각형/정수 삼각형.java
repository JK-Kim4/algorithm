import java.lang.Math;

class Solution {
    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        int[][] memoriese = new int[triangle.length][];
        memoriese[0] = triangle[0];
        
        
        for (int i = 0; i < triangle.length -1; i++) {
            int[] row = triangle[i];
            int[] nextRow = triangle[i+1];
            for (int j = 0; j < nextRow.length; j++) {
                if (j == 0) {
                    nextRow[j] = nextRow[j] + row[0];
                } else if (j == nextRow.length-1) {
                    nextRow[j] = nextRow[j] + row[row.length-1];
                } else {
                    nextRow[j] = Math.max(nextRow[j] + row[j-1], nextRow[j] + row[j]);
                }
            }
        }
        
        int[] leafs = triangle[triangle.length-1];
        
        for (int i : leafs) {
            answer = Math.max(answer, i);
        }
        
        
        return answer;
    }
}