import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> numberSet = new HashSet<>();
        
        for(String s : phone_book){
            numberSet.add(s);
        }
        
        for(String s : phone_book){
            for(int i = 0; i < s.length(); i++){
                if(numberSet.contains(s.substring(0, i))) return false;
            }    
        }
        
        return true;
    }
}