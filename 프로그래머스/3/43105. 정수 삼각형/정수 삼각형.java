import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[] dp = Arrays.copyOf(triangle[0], 1);

        for (int i = 1; i < n; i++) {
            int[] next = new int[i + 1];
            next[0] = dp[0] + triangle[i][0];
            next[i] = dp[i - 1] + triangle[i][i];

            for (int j = 1; j < i; j++) {
                next[j] = Math.max(dp[j - 1], dp[j]) + triangle[i][j];
            }
            dp = next;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}