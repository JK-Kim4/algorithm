class Solution {
    boolean solution(String s) {    
        int ps = 0;
        int ys = 0;
        
        //시간비교 2. count
        for (char c : s.toCharArray()) {
            if ( c == 'P' || c == 'p') ps++;
            if ( c == 'Y' || c == 'y') ys++;
            
        }

        return ps == ys;
    }
}