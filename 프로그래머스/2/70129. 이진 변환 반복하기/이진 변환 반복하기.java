class Solution {
    public int[] solution(String s) {    
        int convertCount = 0;
        int numberOfZero = 0;
        
        //s.equals("1") 반복
        while(!"1".equals(s)) {
            convertCount++;
            numberOfZero += (int) s.chars().filter(i -> String.valueOf((char) i).equals("0")).count();
            
            //모든 0을 제거
            s = s.replaceAll("0", "");
            
            //길이를 2진법으로 표현
            s = Integer.toString(s.length(), 2);
        }
        
        return new int[] {convertCount, numberOfZero};
    }
}