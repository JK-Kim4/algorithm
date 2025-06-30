import java.util.*;

class Solution {
    private char[] vowels = new char[] {'A','E','I','O','U'};
    
    private List<String> generateWords(String s) {
        List<String> words = new ArrayList<>();
        words.add(s);
        
        if (s.length() == 5) return words;
        
        for (char c : vowels) {
            words.addAll(generateWords(s + c));
        }
        
        return words;
    }
    
    
    public int solution(String word) {
        List<String> dictionary = generateWords("");
        
        return dictionary.indexOf(word);
    }
}