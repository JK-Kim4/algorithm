class Solution {
    
    public char convert(char c, boolean isEven) {    
        if (isEven) return Character.toUpperCase(c);
        return Character.toLowerCase(c);
    }
    
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isEven = true;
        
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isSpaceChar(c)) {
                sb.append(c);
                isEven = true;
            }
            if (Character.isAlphabetic(c)) {
                sb.append(convert(c, isEven));   
                isEven = !isEven;
            }
        }
        
        return sb.toString();
    }
}