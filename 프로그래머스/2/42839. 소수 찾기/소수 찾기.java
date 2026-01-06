import java.util.*;


class Solution {
    public int solution(String numbers) {
        int result = 0;
        //1. 조합 가능 목록 추출
        Set<Integer> all = buildAllNumbers(numbers);
        System.out.println(all);
        
        //2. 소수 갯수
        for(Integer i : all) {
            if (isPrime(i)) result++;
        }        
    
        return result;
    }
    
    private Set<Integer> buildAllNumbers(String target) {
        char[] chars = target.toCharArray();
        Set<Integer> result = new HashSet();
        boolean[] visited = new boolean[chars.length];
        
        dfs(chars, new StringBuilder(), visited, result);
        
        return result;
    }
    
    private void dfs(char[] chars, StringBuilder sb, boolean[] visited, Set<Integer> result) {
        if (sb.length() > 0) {
            result.add(Integer.parseInt(sb.toString()));
        }
        
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            sb.append(chars[i]);
            
            dfs(chars, sb, visited, result);
            
            visited[i] = false;
            sb.deleteCharAt(sb.length() -1);
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
