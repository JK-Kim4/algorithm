import java.util.*;

class Solution {
    private char[] target;
    
    
    public int solution(String s) {
        int answer = 0;
        this.target = s.toCharArray();
        
        for (int i = 0; i < target.length; i++) {
            if (isCorrect(i)) answer++;
        }
        
        return answer;
    }
    
    public boolean isCorrect(int offset) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < target.length; i++) {
            char c = target[(i + offset) % target.length];
            
            switch(c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                case ')', '}', ']' -> {
                    if (stack.isEmpty()) return false;
                    if (c != stack.pop()) return false;
                }
            }
        }
        
        if (!stack.isEmpty()) return false;
        
        return true;
    }
}
