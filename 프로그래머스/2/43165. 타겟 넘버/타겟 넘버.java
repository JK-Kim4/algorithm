class Solution {

    public int solution(int[] numbers, int target) {
        TargetNumber tn = new TargetNumber(numbers, target);
        return tn.find(0,0);
    }

}

class TargetNumber {
    
    private static final int[] OPERATORS = {1, -1};
    
    int[] numbers;
    int target;
    int answer;
    
    public TargetNumber(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        this.answer = 0;
    }
    
    public int find(int index, int sum) {
        
        if (index < this.numbers.length) {
            for (int i : OPERATORS) {
                find(index+1, sum + (numbers[index]*i));
            }
        } else if (sum == this.target) {
            this.answer++;
        }
        
        return answer;
    }
}