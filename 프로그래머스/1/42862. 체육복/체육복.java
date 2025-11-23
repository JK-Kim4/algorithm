import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Set<Integer> lostStudents = new HashSet<>();
        Set<Integer> rentableStudents = new HashSet();
        
        
        for (int l : lost) {
            lostStudents.add(l);
        }
        
        for (int i : reserve) {
            rentableStudents.add(i);
        }
        
        Iterator<Integer> it = lostStudents.iterator();
        while (it.hasNext()) {
            int student = it.next();
            if (rentableStudents.contains(student)) {
                it.remove();
                rentableStudents.remove(student);
            }
        }
        
        for (int i : lostStudents) {
            
            if (rentableStudents.contains(i-1)) {
                rentableStudents.remove(i-1);
                continue;
            } else if (rentableStudents.contains(i+1)) {
                rentableStudents.remove(i+1);
                continue;
            } else {
                answer--; 
            }
            
        }
        
        return answer;
    }
}