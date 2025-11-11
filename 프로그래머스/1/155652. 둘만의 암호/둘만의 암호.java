import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> skipSet = new HashSet<>();
        for (char ch : skip.toCharArray()) {
            skipSet.add(ch);
        }

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int count = 0;
            while (count < index) {
                c = (char) ((c - 'a' + 1) % 26 + 'a'); // 'z' 다음은 'a'
                if (!skipSet.contains(c)) {
                    count++;
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }
}