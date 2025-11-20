import java.util.regex.*;
import java.util.*;

class Solution {

    private static final Pattern PATTERN =
        Pattern.compile("(10|[0-9])([SDT])([*#]?)");

    public int solution(String dartResult) {
        Matcher matcher = PATTERN.matcher(dartResult);
        int[] scores = new int[3];
        int idx = 0;

        while (matcher.find()) {
            int score = Integer.parseInt(matcher.group(1));
            char bonus = matcher.group(2).charAt(0);
            String opt = matcher.group(3);
            char option = opt.isEmpty() ? ' ' : opt.charAt(0);

            // 보너스 처리
            if (bonus == 'S') {
                score = (int) Math.pow(score, 1);
            } else if (bonus == 'D') {
                score = (int) Math.pow(score, 2);
            } else if (bonus == 'T') {
                score = (int) Math.pow(score, 3);
            }

            // 옵션 처리
            if (option == '*') {
                score *= 2;
                if (idx > 0) {
                    scores[idx - 1] *= 2;
                }
            } else if (option == '#') {
                score *= -1;
            }

            scores[idx++] = score;
        }

        return scores[0] + scores[1] + scores[2];
    }
}