import java.util.*;

class Solution {
    
    //연산자 우선순위 정적 변수 선언
    private static final String[][] precedences = {
        "+-*".split(""),
        "+*-".split(""),
        "-+*".split(""),
        "-*+".split(""),
        "*-+".split(""),
        "*+-".split(""),  
    };
    
    //연산 결과 
    public long calculate(String operation, long x, long y) {
        return switch(operation) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            default -> throw new RuntimeException();
        };
    }
    
    public long calculate(List<String> tokens, String[] oprs) {
        
        for (String op : oprs) {
            for (int i = 0; i < tokens.size(); i++) {
                if (op.equals(tokens.get(i))) {
                    long x = Long.parseLong(tokens.get(i-1));
                    long y = Long.parseLong(tokens.get(i+1));
                    
                    long result = calculate(op, x, y);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.add(i-1, String.valueOf(result));
                    i -= 2;
                }
            }
        }
        
        return Long.parseLong(tokens.get(0));
    }
    
    
    public long solution(String expression) {
        long max = 0;
        
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new ArrayList();
        
        while(st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        
        //ArrayList는 가변 객체기 때문에 함수 파라미터 전달 시 새로운 List 생성하여 전달
        for (String[] oprs : precedences) {
            long result = Math.abs(calculate(new ArrayList(tokens), oprs));
            if (result > max) max = result;
        }
        
        return max;
    }
}