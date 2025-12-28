import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++ ) {    
            if (isCorrect(s.toCharArray(), i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isCorrect(char[] chars, int offset) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < chars.length; i++) {
            char c = chars[(i+offset) % chars.length];
            
            switch(c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                case ')', '}', ']' -> {
                    if (stack.isEmpty()) return false;
                    if (stack.pop() != c) return false;
                }
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}
