import java.util.*;

class Solution {
    
    static class Node {
        String value;
        int depth;
        
        public Node (String v, int d) {
            this.value = v;
            this.depth = d;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        
        Queue<Node> q = new LinkedList();
        q.offer(new Node(begin, 0));
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if (node.value.equals(target)) return node.depth;
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isNext(node.value, words[i])) {
                    q.offer(new Node(words[i], node.depth + 1));
                    visited[i] = true;
                }
            }
        }    

        return 0;
    }
 
   private boolean isNext(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }

}