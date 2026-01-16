import java.util.*;

class Solution {
    private char[] vowels = new char[] {'A','E','I','O','U'};

    public int solution(String word) {
        List<String> dictionary = new ArrayList();
        
        generate("", dictionary);
        
        return dictionary.indexOf(word);
    }
    
    private void generate(String s, List<String> dictionary) {
        dictionary.add(s);
        
        if (s.length() == 5) return;
        
        for (char v : vowels) {
            generate(s+v, dictionary);
        }
    }
}