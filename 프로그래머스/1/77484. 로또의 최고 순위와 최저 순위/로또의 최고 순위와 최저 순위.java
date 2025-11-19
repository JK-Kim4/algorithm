import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int correctCount = 0;
        int zeroCount = 0;

        Set<Integer> winSet = new HashSet<>();
        for (int wn : win_nums) {
            winSet.add(wn);
        }

        for (int l : lottos) {
            if (l == 0) {
                zeroCount++;
                continue;
            }
            if (winSet.contains(l)) {
                correctCount++;
            }
        }

        return new int[]{ranking(correctCount + zeroCount), ranking(correctCount)};
    }

    public int ranking(int count) {
        switch (count) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
}