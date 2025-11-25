import java.util.*;

class Solution {
    
     public List<String> split(String source, int length) {
         List<String> tokens = new ArrayList();
         
         for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
             int endIndex = startIndex + length;
             if (endIndex > source.length()) endIndex = source.length();
             
             tokens.add(source.substring(startIndex, endIndex));
         }
         
         return tokens;
     }
    
    
    public int compress(String source, int length) {
        StringBuilder sb = new StringBuilder();
        String last = "";
        int count = 0;
        
        for (String token : split(source, length)) {
            if (token.equals(last)) {
                count++;
            } else {
                if (count > 1) sb.append(count);
                sb.append(last);
                last = token;
                count = 1;    
            }
        }
        if (count > 1) sb.append(count);
        sb.append(last);
        
        return sb.toString().length();
    }
    
    
    
    
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= s.length(); i++) {
            int temp = compress(s, i);
            if (temp < min) min = temp;
        }

        return min;
    }
}