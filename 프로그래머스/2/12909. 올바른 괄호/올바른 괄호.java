import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack();

        for(char c : s.toCharArray()){
            if(stack.empty()){
                stack.push(c);
            }else{
                if(stack.peek() != ')' && stack.peek() != c) stack.pop();
                else stack.push(c);
            }
        }



        return stack.empty();
    }
}