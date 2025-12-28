import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int n = gems.length;

        // 전체 보석 종류 수
        Set<String> gemSet = new HashSet<>(Arrays.asList(gems));
        int kinds = gemSet.size();

        int start = 0;
        int end = n - 1;

        int startPointer = 0;
        int endPointer = 0;

        Map<String, Integer> includes = new HashMap<>();
        includes.put(gems[0], 1);

        while (true) {
            // 모든 종류를 포함하고 있다면: 가능한 한 왼쪽을 줄이면서 최솟값 갱신
            if (includes.size() == kinds) {
                if ((end - start) > (endPointer - startPointer)) {
                    start = startPointer;
                    end = endPointer;
                }

                // 윈도우 왼쪽 줄이기
                String leftGem = gems[startPointer];
                int cnt = includes.get(leftGem) - 1;
                if (cnt == 0) includes.remove(leftGem);
                else includes.put(leftGem, cnt);

                startPointer++;
            } else {
                // 아직 모든 종류가 없다면: 오른쪽 확장
                endPointer++;
                if (endPointer == n) break; // 더 이상 확장 불가

                includes.put(gems[endPointer], includes.getOrDefault(gems[endPointer], 0) + 1);
            }
        }

        // 문제는 1-based index 반환
        return new int[]{start + 1, end + 1};
    }
}