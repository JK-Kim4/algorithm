class Solution {
    boolean solution(String s) {    
        s = s.toUpperCase();
        
        //시간비교 1. replace 사용
        int ps = s.length() - s.replaceAll("P", "").length();
        int ys = s.length() - s.replaceAll("Y", "").length();

        return ps == ys;
    }
}