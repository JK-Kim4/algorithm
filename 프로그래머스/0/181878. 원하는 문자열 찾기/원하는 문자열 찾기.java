class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        myString = myString.toUpperCase();
        pat = pat.toUpperCase();
        
        if(myString.contains(pat)){
            answer++;
        }
        
        
        System.out.print(myString + " " + pat); 
        
        return answer;
    }
}