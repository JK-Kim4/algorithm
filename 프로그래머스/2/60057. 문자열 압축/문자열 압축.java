import java.util.*;

class Solution {
    
    public String compress(List<String> units) {
        StringBuilder sb = new StringBuilder();
        
        String last = "";
        int count = 0;
        for (String unit : units) {
            if (unit.equals(last)) {
                count++;
            } else {
                if (count > 1) sb.append(count);
                sb.append(last);
                last = unit;
                count = 1;
            }
        }
        if (count > 1) sb.append(count);
        sb.append(last);
        
        return sb.toString();
    }
    
    public List<String> split(String s, int length) {
        List<String> result = new ArrayList<>();
        
        for (int startIndex = 0; startIndex < s.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if (endIndex >= s.length()) endIndex = s.length();
            result.add(s.substring(startIndex, endIndex));
        }
        return result;
    }
    
    public int solution(String s) {
        if (s.length() == 1) return 1;
        
        int min = Integer.MAX_VALUE;
        
        for (int length = 1; length < s.length(); length++) {
            String compressed = compress(split(s, length));
            if (compressed.length() < min) min = compressed.length();
        }
        
        return min;
    }
}