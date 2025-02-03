import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovilles = new PriorityQueue<>();
        
        for(int i : scoville){
            scovilles.add(i);
        }
        
        int mix = -1;
        while(scovilles.peek() < K){
            //최소 실행 조건
            if(scovilles.size() < 2) return -1;
            
            
            int first = scovilles.poll();
            int second = scovilles.poll();
            mix = first + second * 2;
            scovilles.add(mix);
            
            answer++;
            
        }

        
        return answer;
    }
}