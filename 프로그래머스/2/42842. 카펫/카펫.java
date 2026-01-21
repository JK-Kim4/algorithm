import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        // H는 최소 3 (테두리 때문에), H * H <= total까지만 보면 약수쌍을 모두 커버
        for (int h = 3; h * h <= total; h++) {
            if (total % h != 0) continue;

            int w = total / h; // w >= h가 되도록 h를 작은 쪽으로 두는 방식
            if (w < h) continue;

            // 내부가 yellow인지 확인
            if ((w - 2) * (h - 2) == yellow) {
                return new int[]{w, h};
            }
        }
        return new int[0]; // 문제 특성상 도달하지 않음
    }
}