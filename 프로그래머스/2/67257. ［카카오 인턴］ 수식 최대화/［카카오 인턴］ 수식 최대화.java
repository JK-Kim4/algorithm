import java.util.*;

class Solution {
    
    private static final String[][] precedences = {
        "+-*".split(""),
        "+*-".split(""),
        "-+*".split(""),
        "-*+".split(""),
        "*-+".split(""),
        "*+-".split(""),  
    };
    
    private long calculate(String oprator, long x, long y) {
        return switch(oprator) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            default -> throw new RuntimeException();
        };
    }
    
    private long calculate(List<String> tokens, String[] precedence) {
        for (String op : precedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long x = Long.parseLong(tokens.get(i-1));
                    long y = Long.parseLong(tokens.get(i+1));
                    long result = calculate(op, x, y);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(result));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }

    
    public long solution(String expression) {
        long answer = 0;
        
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList();
    
        //List 형식으로 저장
        while(st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        
        //우선순위 완전 탐색 최대값 반환
        for (String[] ops : precedences) {
            long value = Math.abs(calculate(new ArrayList<>(tokens), ops));
            if (value > answer) answer = value;
        }
        return answer;
    }
}