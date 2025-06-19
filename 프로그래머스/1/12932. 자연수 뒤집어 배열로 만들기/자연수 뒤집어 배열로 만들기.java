class Solution {
    public int[] solution(long n) {
        
        String target = Long.toString(n);
        int[] answer = new int[target.length()];
        
        StringBuffer buffer = new StringBuffer(target);
        String reverse = buffer.reverse().toString();
        
        char[] targetCharArray = reverse.toCharArray();
        
        for (int i = 0; i < targetCharArray.length; i++) {
            answer[i] = (int)(targetCharArray[i] - '0');
        }
        
        
        return answer;
    }
}