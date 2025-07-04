import java.util.*;

class Solution {
    
    // List<int[]> 전체 타일 수를 파라미터로 n X m이 가능한 약수 산출
    public List<int[]> getMeasures(int number) {
        List<int[]> measures = new ArrayList();
        
        for (int i = 1; i <= number; i++) {
            if (number % i == 0 && i >= number/i) measures.add(new int[]{i, number/i});
        }
        
        return measures;
    }
    
    
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        //1. yellow 타일수가 가능한 n X m 조합 O(n)
        List<int[]> yMeasures = getMeasures(yellow);
        
        
        //2. 전체 타일수가 가능한 o X p 조합 O(m)
        List<int[]> totalMeasure = getMeasures(brown + yellow);
        
        //3. n + a = o && m + a = p 가 되는 a 찾아서 return (o,p)
        for (int[] tia : totalMeasure) {
            
            for (int[] yia : yMeasures) {
                int diff = tia[0] - yia[0];
                if (yia[1] + diff == tia[1]) answer = tia;
            }    
        }
        
        return answer;
    }
}