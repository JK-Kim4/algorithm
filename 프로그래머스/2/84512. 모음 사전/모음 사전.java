import java.util.*;

class Solution {
    private char[] vowels = new char[] {'A','E','I','O','U'};

    public int solution(String word) {
        List<String> dictionary = generate("");
        
        return dictionary.indexOf(word);
    }
    
    private List<String> generate(String s) {
        List<String> words = new ArrayList<>();
        words.add(s);
        
        if (s.length() == 5) return words;
        
        for (char v : vowels) {
            words.addAll(generate(s + v));
        }
        
        return words;
    }
}