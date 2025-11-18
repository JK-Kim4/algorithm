class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int correctCount = 0;
        int zeroCount = 0;
        
        //1. 현재까지 일치 횟수 
        for (int l : lottos) {
            if (l == 0) zeroCount++;
            for ( int wn : win_nums ) {
                if (wn == l) correctCount++;
            }
        }
        
        System.out.println("correct = " + correctCount);
        System.out.println("zero = " + zeroCount);
        
        return new int[]{ranking(correctCount+zeroCount), ranking(correctCount)};
    }
    
    public int ranking(int count) {
        switch(count) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}