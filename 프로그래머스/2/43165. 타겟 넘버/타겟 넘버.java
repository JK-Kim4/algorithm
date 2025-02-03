class Solution {

    public int solution(int[] numbers, int target) {
        DFSSolution sol = new DFSSolution(numbers, target);
        sol.doSomething(0,0);
        return sol.getResult();
    }

}


class DFSSolution {
    
    private int[] numbers;
    private int numbersLength;
    private int target;
    private int result;
    
    public DFSSolution(int[] numbers, int target){
        this.numbers = numbers;
        this.numbersLength = numbers.length;
        this.target = target;
        
        System.out.println("target is " +this.target);
    }
    
    public void doSomething(int index, int sum){
        if(index < this.numbersLength){
            //index가 배열의 크기에 도달하지 못하였을 때
            doSomething((index+1), sum + this.numbers[index]);
            doSomething((index+1), (sum + this.numbers[index] * -1) );
        }else if(index == this.numbersLength){
            //index가 배열의 끝에 도달하였을 때
            if(sum == this.target) this.result++;
        }
    }
        
    public int getResult(){
        return this.result;
    }
    
    public void printNumbers(){
        for(int i = 0; i < numbersLength; i++){
            System.out.println(numbers[i]);
        }
    }
    
    
}