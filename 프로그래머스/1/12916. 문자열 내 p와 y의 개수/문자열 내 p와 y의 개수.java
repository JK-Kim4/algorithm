class Solution {
    boolean solution(String s) {    
        s = s.toUpperCase();
    
        int pCount = 0;
        int yCount = 0;
        
        for (char c : s.toCharArray()) {
            if('P' == c) pCount++;
            if('Y' == c) yCount++;
        }
        

        return pCount == yCount;
    }
}