class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        //replcaAll
        for(String str : babbling){
            //wyeoo
            str = str.replaceAll("aya", "-").replaceAll("ye", "-")
                .replaceAll("woo", "-").replaceAll("ma", "-");
            
            if("".equals(str.replaceAll("-", ""))){
                answer++;
            }
        }
            
        return answer;
    }
}