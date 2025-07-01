import java.util.*;

class Solution {
    
    public List<int[]> hanoi (int n, int start, int end) {
        if (n == 1) return List.of(new int[] {start, end});
        
        int empty = 6 - start - end;
        
        List<int[]> list = new ArrayList();
        list.addAll(hanoi(n-1, start, empty));    
        list.addAll(hanoi(1, start, end));
        list.addAll(hanoi(n-1, empty, end));
    
        return list;
    }

    
    public int[][] solution(int n) {
        return hanoi(n,1,3).toArray(new int[0][]);
    }
}