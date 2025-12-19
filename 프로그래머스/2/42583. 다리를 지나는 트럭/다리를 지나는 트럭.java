import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitT = new LinkedList<>();
        Queue<Truck> moveT = new LinkedList<>();
        
        for(int i : truck_weights) {
            waitT.offer(new Truck(i));
        }
        
        int answer = 0;
        int curWeight = 0;
        
        while (!waitT.isEmpty() || !moveT.isEmpty()) {
            answer++;
            
            // 1. 대기중인 트럭 이동
            if (moveT.isEmpty()) {
                Truck t = waitT.poll();
                curWeight += t.weight;
                moveT.offer(t);
                continue;
            }
            
            // 2. 이동중인 트럭 이동
            for (Truck t : moveT) {
                t.moving();
            }
            
            // 3. 이동 완료 트럭 제거
            if (moveT.peek().position > bridge_length) {
                Truck t = moveT.poll();
                curWeight -= t.weight;
            }
            
            // 4. 대기중 트럭 이동
            if (moveT.size() < bridge_length && !waitT.isEmpty() && waitT.peek().weight + curWeight <= weight) {
                Truck t = waitT.poll();
                curWeight += t.weight;
                moveT.offer(t);
            }
        
        }
        
        return answer;
    }
}

class Truck {
    
    int weight;
    int position;
    
    public Truck (int weight) {
        this.weight = weight;
        this.position = 1;
    }
    
    public void moving() {
        this.position += 1;
    }
}