import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        List<StringNumber> nums = new ArrayList();
        
        for (int i : numbers) {
            nums.add(new StringNumber(i));
        }
        
        Collections.sort(nums);
        
        for (StringNumber sn : nums) {
            sb.append(sn.value);
        }
        
        
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}

class StringNumber implements Comparable<StringNumber> {
    
    String value;
    
    public StringNumber (int i) {
        this.value = String.valueOf(i);
    }
    
    @Override
    public int compareTo(StringNumber o) {
        return (o.value + this.value).compareTo(this.value + o.value);
    }
    
}